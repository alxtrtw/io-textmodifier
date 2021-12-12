package pl.put.poznan.transformer.rest;

import java.util.List;
import java.util.stream.Collectors;

public class TransformParser {
    public static List<TransformMethod> from(List<String> transforms) {
        return transforms.stream().map(TransformMethod::from).collect(Collectors.toList());
    }
}
