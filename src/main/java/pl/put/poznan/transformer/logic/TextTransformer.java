package pl.put.poznan.transformer.logic;

import java.util.Arrays;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {
    public TextTransformer(){}

    public String transformUpperCase(String text){
        return text.toUpperCase();
    }
    public String transformLowerCase(String text){
        return text.toLowerCase();
    }
    public String transformCaptalize(String text){
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    public void transformNumberToWord(String text){
        text = text.replaceAll("[^0-9]+", " ");
        System.out.println(Arrays.asList(text.trim().split(" ")));
    }



}
