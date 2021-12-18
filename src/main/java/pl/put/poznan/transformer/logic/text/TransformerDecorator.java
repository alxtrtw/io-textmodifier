package pl.put.poznan.transformer.logic.text;

public class TransformerDecorator implements Transformer {
    protected final Transformer transformer;

    protected TransformerDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    public String transform(String text) {
        return transformer.transform(text);
    }
}
