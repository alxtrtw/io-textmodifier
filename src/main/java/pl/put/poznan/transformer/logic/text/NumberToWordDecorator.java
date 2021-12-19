package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class NumberToWordDecorator extends TransformerDecorator {

    List<String> units = Arrays.asList( "", "jeden", "dwa", "trzy", "cztery", "pięć",
                                        "sześć", "siedem", "osiem", "dziewięć");

    List<String> tens = Arrays.asList(  "", "jedenaście", "dwanaście", "trzynaście",
                                        "czternaście", "piętnaście", "szesnaście",
                                        "siedemnaście", "osiemnaście", "dziewiętnaście");

    List<String> teens = Arrays.asList( "", "dziesięć", "dwadzieścia", "trzydzieści",
                                        "czterdzieści", "pięćdziesiąt", "sześćdziesiąt",
                                        "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt");

    List<String> hundreds  = Arrays.asList( "", "sto", "dwieście", "trzysta",
                                            "czterysta", "pięćset", "sześćset",
                                            "siedemset", "osiemset", "dziewięćset");

    List<List<String>> groups = Arrays.asList(  Arrays.asList("", "", ""),
                                                Arrays.asList("tysiąc", "tysiące", "tysięcy"));

    public NumberToWordDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return Iterator.of(super.transform(text).split("\\s+")).map(this::translate).mkString(" ");
    }

    private String translateInteger(String integerText) {
        int number = Integer.parseInt(integerText);

        List<String> words = new ArrayList<String>();
        if (number < 0) {
            words.add("minus");
            number = -number;
        }

        int group = 0;
        while (number!=0) {
            int hundred = number % 1_000 / 100;
            int teen = number % 100 / 10;
            int unit = number % 10;
            number = number / 1_000;

            // brak elementów do nazwania
            if (hundred == 0 && teen == 0 && unit == 0 ){
                group += 1;
                continue;
            }

            // łączymy dziesiątki i jedności w -naście
            int ten = 0;
            if (teen == 1 && unit > 0){
                ten = unit;
                teen = 0;
                unit = 0;
            }

            // wybór formy gramatycznej
            int form = 0;
            if (unit == 1 && hundred + teen + ten == 0) {
                form = 0;
            } else if ( 2 <= unit && unit <= 4 ) {
                form = 1;
            } else {
                form = 2;
            }

            if (group == 0) {
                words.addAll(Arrays.asList(hundreds.get(hundred), teens.get(teen), tens.get(ten), units.get(unit)));
            } else {
                words.addAll(Arrays.asList( "", groups.get(group).get(form)));
            }
            group += 1;
        }

        String str = "";
        for (String word : words){
            str = str.concat(word).concat(" ");
        }
        return str.strip();
    }

    private String translateDecimal(String decimalText) {
        var numbers = decimalText.split("\\.");
        return translateInteger(numbers[0]) + " i " + translateInteger(numbers[1]) + " po przecinku";
    }

    private String translate(String word) {
        switch (NumberType.identify(word)) {
            case Integer:
                return translateInteger(word);
            case Decimal:
                return translateDecimal(word);
            case Invalid:
            default:
                return word;
        }
    }

    private enum NumberType {
        Integer(Pattern.compile("\\d+")), Decimal(Pattern.compile("")), Invalid(Pattern.compile(""));

        NumberType(Pattern pattern) {
            this.pattern = pattern;
        }

        private final Pattern pattern;

        public static NumberType identify(String str) {
            if (Integer.pattern.matcher(str).matches()) return Integer;
            if (Decimal.pattern.matcher(str).matches()) return Decimal;
            return Invalid;
        }
    }
}

