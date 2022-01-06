package pl.put.poznan.transformer.logic.text;

/**
 * Interfejs obiektów transformujących tekst.
 */
public interface Transformer {
    /**
     * @param text Tekst do transformacji
     * @return transformowany tekst
     */
    String transform(String text);
}
