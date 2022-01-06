package pl.put.poznan.transformer.logic.text;

/**
 * Bazowa klasa dla transformatorów tekstowych.
 */
public class BaseTransformer implements Transformer {
    /**
     * @param text Tekst do transformacji
     * @return transformowany tekst
     */
    @Override
    public String transform(String text) {
        return text.strip();
    }
}
