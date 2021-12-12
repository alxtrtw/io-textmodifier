package pl.put.poznan.transformer.logic;

import java.util.*;
import java.util.stream.IntStream;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {
    public TextTransformer() {
    }

    public String transformUpperCase(String text) {
        return text.toUpperCase();
    }

    public String transformLowerCase(String text) {
        return text.toLowerCase();
    }

    public String transformCaptalize(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public String transformInverse(String text) {
        List<String> list = new ArrayList<>();
        String reverse = new StringBuffer(text).reverse().toString().toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                list.add(Character.toString(reverse.charAt(i)).toUpperCase());
            } else {
                list.add(Character.toString(reverse.charAt(i)));
            }
        }
        return String.join("", list);
    }

    public String transformShorcuts(String text) {
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(processShortcuts(word));
        }
        return String.join(" ", list);
    }

    private String processShortcuts(String text) {
        String result;
        Map<String, String> shortcuts = new Shortcuts().getShortcuts();
        boolean b = shortcuts.get(text.toLowerCase()) != null;
        if (b) {
            if (Character.isUpperCase(text.charAt(0))) {
                result = shortcuts.get(text.toLowerCase());
                result = result.substring(0, 1).toUpperCase() + result.substring(1);
            } else {
                result = shortcuts.get(text);
            }
        } else {
            result = text;
        }
        return result;
    }
}

