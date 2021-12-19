package pl.put.poznan.transformer.rest;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa odpowiedzialna za parsowanie danych z wejścia w postaci łańcucha znaków do
 * odpowiadających mu metod transformacyjnych.
 */
public class TransformParser {
    public static List<TransformMethod> from(List<String> transforms) {
        return transforms.stream().map(TransformMethod::from).collect(Collectors.toList());
    }
}
