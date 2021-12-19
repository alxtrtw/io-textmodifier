package pl.put.poznan.transformer.logic.text;

/**
 * Klasa odpowiedzialna za zmianę wielkości wszystkich liter w tekście na wielkie.
 */
public class UppercaseDecorator extends TransformerDecorator {
    public UppercaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.toUpperCase();
    }
}
