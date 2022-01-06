package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.CharSeq;

/**
 * Klasa reprezentująca dekorator odwracający znaki w tekście,
 * bez zmiany wielkości liter według kolejności występowania.
 */
public class InverseDecorator extends TransformerDecorator {
    public InverseDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * @param text Tekst do transformacji
     * @return transformowany tekst poddany inwerski zachowującej kolejność wielkości znaków
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);

        var uppercaseIndices = CharSeq.of(text).map(Character::isUpperCase).toList();

        return CharSeq.of(text).reverse().zipWithIndex((chr, i) ->
            uppercaseIndices.get(i) ? chr.toString().toUpperCase() : chr.toString().toLowerCase()
        ).mkString();
    }
}
