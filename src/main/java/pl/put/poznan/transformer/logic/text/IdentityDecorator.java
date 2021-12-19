package pl.put.poznan.transformer.logic.text;

/**
 * Klasa reprezentująca transformator, który nie zmienia tekstu.
 */
public class IdentityDecorator extends TransformerDecorator {
    public IdentityDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text;
    }
}
