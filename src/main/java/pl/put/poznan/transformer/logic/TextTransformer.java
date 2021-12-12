package pl.put.poznan.transformer.logic;

import java.util.Arrays;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {
    public static String identity(String text) {
        return text;
    }

    public static String asUpperCase(String text) {
        return text.toUpperCase();
    }

    public static String asLowerCase(String text) {
        return text.toLowerCase();
    }

    public static String capitalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public static String numberToWord(String text) {
        text = text.replaceAll("[^0-9]+", " ");
        System.out.println(Arrays.asList(text.trim().split(" ")));
        return "";
    }
}
