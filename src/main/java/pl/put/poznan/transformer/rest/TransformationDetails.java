package pl.put.poznan.transformer.rest;

import java.util.List;

public class TransformationDetails {
    private final List<TransformMethod> transformations;
    private final String source;
    private final String result;

    public TransformationDetails(List<TransformMethod> transformations, String source, String result) {
        this.transformations = transformations;
        this.source = source;
        this.result = result;
    }
}
