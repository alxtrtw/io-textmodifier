package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.CharSeq;

/**
 * Klasa odpowiedzialna za zmianę pierwszej litery pierwszego słowa
 * w zdaniu na literę wielką.
 */
public class CapitalizeDecorator extends TransformerDecorator {
    public CapitalizeDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * @param text Tekst do transformacji
     * @return transformowany tekst zaczynający się od wielkiej litery
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return CharSeq.of(text).capitalize().mkString();
    }
}
