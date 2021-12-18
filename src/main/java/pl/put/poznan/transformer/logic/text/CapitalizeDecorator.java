package pl.put.poznan.transformer.logic.text;

public class CapitalizeDecorator extends TransformerDecorator {
    public CapitalizeDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
