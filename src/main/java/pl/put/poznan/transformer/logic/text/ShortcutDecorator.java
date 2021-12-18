package pl.put.poznan.transformer.logic.text;

import pl.put.poznan.transformer.logic.Shortcuts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShortcutDecorator extends TransformerDecorator {
    public ShortcutDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        String[] words = text.split(" ");
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(processShortcuts(word));
        }
        return String.join(" ", list);
    }

    private static String processShortcuts(String text) {
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
