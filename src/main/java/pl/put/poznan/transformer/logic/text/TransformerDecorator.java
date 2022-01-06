package pl.put.poznan.transformer.logic.text;

/**
 * Transformator zmieniający podany tekst.
 */
public class TransformerDecorator implements Transformer {
    /**
     * Zapamiętany transformator tekstu
     */
    protected final Transformer transformer;

    /**
     * @param transformer transformator tekstu
     */
    protected TransformerDecorator(Transformer transformer) {
        this.transformer = transformer;
    }

    /**
     * @param text Tekst do transformacji
     * @return transformowany tekst
     */
    public String transform(String text) {
        return transformer.transform(text);
    }
}
