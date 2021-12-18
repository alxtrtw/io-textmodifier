package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Shortcuts {
    private final Map<String, String> shortcuts = new HashMap<>();

    public Shortcuts() {
        shortcuts.put("np.", "na przykład");
        shortcuts.put("m.in.", "między innymi");
        shortcuts.put("itd.", "i tym podobne");
        shortcuts.put("dr", "doktor");
        shortcuts.put("prof.", "profesor");
    }

    public Map<String, String> getShortcuts() {
        return this.shortcuts;
    }

    public String getKey(String key) {
        String result = "";
        for (Map.Entry<String, String> entry : this.shortcuts.entrySet()) {
            if (entry.getValue().equals(key)) {
                result = entry.getKey();
                System.out.println(result);
            }
        }
        return result;
    }
}
