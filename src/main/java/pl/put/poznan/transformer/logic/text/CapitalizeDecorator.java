package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.CharSeq;

public class CapitalizeDecorator extends TransformerDecorator {
    public CapitalizeDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return CharSeq.of(text).capitalize().mkString();
    }
}
