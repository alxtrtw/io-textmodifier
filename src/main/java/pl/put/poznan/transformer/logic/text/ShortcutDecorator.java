package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.CharSeq;
import io.vavr.collection.HashMap;
import io.vavr.collection.Stream;

public class ShortcutDecorator extends TransformerDecorator {
    public ShortcutDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        return Stream
            .of(super.transform(text).split("\\s+"))
            .map(this::parse)
            .mkString(" ");
    }

    private String parse(String text) {
        var shortcut = shortcuts.get(text.toLowerCase()).get();
        return Character.isUpperCase(shortcut.charAt(0))
            ? CharSeq.of(shortcut).capitalize().mkString()
            : shortcut;
    }

    private static final HashMap<String, String> shortcuts = HashMap
        .of("np.", "na przykład")
        .put("m.in.", "między innymi")
        .put("itd.", "i tak dalej")
        .put("dr", "doktor")
        .put("prof.", "profesor");

}
