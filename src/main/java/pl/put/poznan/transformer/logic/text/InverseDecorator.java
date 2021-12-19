package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.CharSeq;

public class InverseDecorator extends TransformerDecorator {
    public InverseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);

        var uppercaseIndices = CharSeq.of(text).map(Character::isUpperCase).toList();

        return CharSeq.of(text).reverse().zipWithIndex((chr, i) ->
            uppercaseIndices.get(i) ? chr.toString().toUpperCase() : chr.toString().toLowerCase()
        ).mkString();
    }
}
