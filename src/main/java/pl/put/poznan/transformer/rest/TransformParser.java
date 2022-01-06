package pl.put.poznan.transformer.rest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa odpowiedzialna za parsowanie danych z wejścia w postaci łańcucha znaków do
 * odpowiadających mu metod transformacyjnych.
 */
public class TransformParser {
    /**
     * @param transforms łańcuchy znaków zawierające reprezentacje słowne metod transformujacych
     * @return lista metod transformujących
     */
    public static List<TransformMethod> from(List<String> transforms) {
        return transforms.stream().map(TransformMethod::from).collect(Collectors.toList());
    }
}
