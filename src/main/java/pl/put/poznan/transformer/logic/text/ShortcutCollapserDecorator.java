package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.CharSeq;
import io.vavr.collection.HashMap;
import io.vavr.collection.Stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa odpowiedzialna za podmianę skrótów na ich rozszerzenia w tekście.
 */

public class ShortcutCollapserDecorator extends TransformerDecorator {
    public ShortcutCollapserDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return Stream
                .of(super.transform(text).replaceAll("\\s+", " "))
                .map(this::parse)
                .mkString(" ");
    }

    private String parse(String text) {
        for (String key :shortcuts.keySet()) {
            if (text.contains(key)){
                text = text.replace(key, shortcuts.get(key).get());
            }
        }
        return text;
    }

    private static final HashMap<String, String> shortcuts = HashMap
            .of("na przykład", "np.")
            .put("między innymi", "m.in.")
            .put("i tak dalej", "itd.")
            .put("doktor", "dr")
            .put("profesor", "prof.");
}
