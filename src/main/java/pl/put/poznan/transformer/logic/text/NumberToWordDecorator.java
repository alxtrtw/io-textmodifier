package pl.put.poznan.transformer.logic.text;

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
        String newWord = "";

        for (int i = 0; i <= words.length; i++){
            String word = words[i];
            String check = checkNumber(word);

            if (check.equals("integer")){
                newWord = translateInteger(word);
            }
            else if (check.equals("double")){
                newWord = translateDouble(word);
            }
            else{
                newWord = word;
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
        return "";
    }

    public static String translateDouble(String strNum){
        return "";
    }
}
