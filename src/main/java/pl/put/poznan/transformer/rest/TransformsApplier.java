package pl.put.poznan.transformer.rest;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.List;
import java.util.function.Function;

public class TransformsApplier {
    public static String apply(List<TransformMethod> transforms, String string) {
        return transforms.stream()
            .map(TransformMethod::getTransform)
            .reduce(TextTransformer::identity, Function::andThen)
            .apply(string);
    }
}
