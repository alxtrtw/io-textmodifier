package pl.put.poznan.transformer.logic.text;

/**
 * Klasa odpowiedzialna za zmianę wszystkich liter w tekście na małe.
 */
public class LowercaseDecorator extends TransformerDecorator {
    public LowercaseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.toLowerCase();
    }
}
