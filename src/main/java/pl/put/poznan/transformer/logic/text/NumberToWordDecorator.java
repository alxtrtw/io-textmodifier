package pl.put.poznan.transformer.logic.text;

import pl.put.poznan.transformer.logic.PolishDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NumberToWordDecorator extends TransformerDecorator {
    public NumberToWordDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);

        String[] words = text.strip().split(" ");
        String newText = "";

        for (int i = 0; i < words.length; i++){
            String word = words[i];
            String check = checkNumber(word);
            String newWord = " ";

            if (check.equals("integer")){
                newWord = newWord.concat(translateInteger(word));
            }
            else if (check.equals("double")){
                newWord = newWord.concat(translateDouble(word));
            }
            else{
                newWord = newWord.concat(word);
            }

            newText = newText.concat(newWord);
        }

        return text;
    }

    public static String checkNumber(String strNum) {
        Pattern integerPattern = Pattern.compile("^\\d+$");
        Pattern doublePattern = Pattern.compile("/^[0-9]+.[0-9]+$");

        if (integerPattern.matcher(strNum).matches()){
            int i = Integer.parseInt(strNum);
            if ( i < 1000 && i >= 0){
                return "integer";
            }
        }
        else if (doublePattern.matcher(strNum).matches()){
            int d = Integer.parseInt(strNum);
            if ( d < 1000 && d >= 0){
                return "double";
            }
        }

        return "none";
    }

    public static String translateInteger(String strNum){
        PolishDictionary dict = new PolishDictionary();

        String[] digits = strNum.split("");
        String newText = "";

        for (int i = 0; i < digits.length; i++){
            String digit = digits[i];
            String newWord = " ";

            switch (digits.length - i){
                case 3:
                    newWord = dict.getHundredDict().get(digit);
                case 2:

                    if (digit.equals("1")){
                        newWord = dict.getTenDict().get( digit.concat(digits[digits.length-1]) );
                        break;
                    }else{
                        newWord = dict.getTenDict().get(digit);
                    }

                case 1:
                    newWord = dict.getDict().get(digit);
            }

            newText = newText.concat(newWord);
        }

        return newText.strip();
    }

    public static String translateDouble(String strNum){

        String dot = strNum.replaceAll("[0-9]", "");
        String[] numbers = strNum.split("\\.");
        String newText = "";

        newText = newText.concat(translateInteger(numbers[0]));
        newText = newText.concat(" i ");
        newText = newText.concat(translateInteger(numbers[1]));
        newText = newText.concat(" po przecinku");

        return newText;
    }
}
