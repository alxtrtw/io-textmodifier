package pl.put.poznan.transformer.rest;

import java.util.List;

/**
 * Klasa zawierajaca informacje o transformacji enkapsulująca wyjściowy plik JSON
 */
public class TransformationModel {
    private final List<TransformMethod> transformations;
    private final String source;
    private final String result;

    public TransformationModel(List<TransformMethod> transformations, String source, String result) {
        this.transformations = transformations;
        this.source = source;
        this.result = result;
    }
}
