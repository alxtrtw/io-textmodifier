package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.Iterator;
import pl.put.poznan.transformer.logic.PolishDictionary;

import java.util.regex.Pattern;

public class NumberToWordDecorator extends TransformerDecorator {
    public NumberToWordDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return Iterator.of(super.transform(text).split("\\s+")).map(this::translate).mkString(" ");
    }

    private String translateInteger(String integerText) {
        PolishDictionary dict = new PolishDictionary();

        String[] digits = integerText.split("");
        String newText = "";

        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            String newWord = "";

            switch (digits.length - i) {
                case 3:
                    newWord = dict.getHundredDict().get(digit);
                    break;
                case 2:
                    if (digit.equals("1")) {
                        newWord = dict.getTenDict().get(digit.concat(digits[digits.length - 1]));
                    } else {
                        newWord = dict.getTenDict().get(digit);
                    }
                    break;
                case 1:
                    newWord = dict.getDict().get(digit);
                    break;
            }

            newText = newText.concat(newWord);
        }

        return newText.strip();
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

