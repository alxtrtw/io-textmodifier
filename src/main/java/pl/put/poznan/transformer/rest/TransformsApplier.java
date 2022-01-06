package pl.put.poznan.transformer.rest;

import java.util.List;
import java.util.function.Function;

/**
 * Klasa odpowiedzialna za dokonanie transformacji na wejściowym łańcuchu znaków.
 */
public class TransformsApplier {
    /**
     * @param transforms Lista metod transformujących
     * @param string     tekst do przetworzenia
     * @return Tekst po przetworzeniu
     */
    public static String apply(List<TransformMethod> transforms, String string) {
        return transforms.stream()
            .map(TransformMethod::getTransform)
            .reduce((s) -> s, Function::andThen)
            .apply(string);
    }
}
