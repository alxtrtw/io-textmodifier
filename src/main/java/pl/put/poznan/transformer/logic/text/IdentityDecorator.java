package pl.put.poznan.transformer.logic.text;

/**
 * Klasa reprezentująca transformator, który nie zmienia tekstu.
 */
public class IdentityDecorator extends TransformerDecorator {
    public IdentityDecorator(Transformer transformer) {
        super(transformer);
    }

    /**
     * @param text Tekst do transformacji
     * @return transformowany tekst bez zmian (identyczny)
     */
    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text;
    }
}
