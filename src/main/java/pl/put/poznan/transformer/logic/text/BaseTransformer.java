package pl.put.poznan.transformer.logic.text;

/**
 * Bazowa klasa dla transformatorów tekstowych.
 */
public class BaseTransformer implements Transformer {
    @Override
    public String transform(String text) {
        return text.strip();
    }
}
