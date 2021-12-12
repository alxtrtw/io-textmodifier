package pl.put.poznan.transformer.rest;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.function.Function;

public enum TransformMethod {
    Identity(TextTransformer::identity),
    Uppercase(TextTransformer::asUpperCase),
    Capitalize(TextTransformer::capitalize),
    NumberToWord(TextTransformer::numberToWord),
    Lowercase(TextTransformer::asLowerCase),
    Unknown(TextTransformer::identity);

    public Function<String, String> getTransform() {
        return transform;
    }

    TransformMethod(Function<String, String> transform) {
        this.transform = transform;
    }

    public static TransformMethod from(String transform) {
        switch (transform.toLowerCase()) {
            case "i":
            case "identity":
                return Identity;
            case "u":
            case "uc":
            case "upper":
            case "uppercase":
                return Uppercase;
            case "l":
            case "lc":
            case "lower":
            case "lowercase":
                return Lowercase;
            case "c":
            case "capitalize":
            case "capitalized":
                return Capitalize;
            case "ntw":
            case "number-to-word":
            case "to-word":
                return NumberToWord;
            default:
                return Unknown;
        }
    }

    private final Function<String, String> transform;
}
