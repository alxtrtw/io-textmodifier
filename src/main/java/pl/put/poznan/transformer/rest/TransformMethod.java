package pl.put.poznan.transformer.rest;

import pl.put.poznan.transformer.logic.text.*;

import java.util.function.Function;

/**
 * Pomocniczy enum służacy do przekazywania metod transformujących tekst.
 */
public enum TransformMethod {
    Identity(new IdentityDecorator(new BaseTransformer())),
    Uppercase(new UppercaseDecorator(new BaseTransformer())),
    Lowercase(new LowercaseDecorator(new BaseTransformer())),
    NumberToWord(new NumberToWordDecorator(new BaseTransformer())),
    ShortcutExpanse(new ShortcutExpanderDecorator(new BaseTransformer())),
    ShortcutCollapse(new ShortcutCollapserDecorator(new BaseTransformer())),
    Capitalize(new CapitalizeDecorator(new BaseTransformer())),
    Inverse(new InverseDecorator(new BaseTransformer())),
    RemoveRepeats(new RepeatRemovalDecorator(new BaseTransformer())),
    Unknown(new BaseTransformer());

    TransformMethod(Transformer transform) {this.transform = transform;}

    public static TransformMethod from(String transform) {
        switch (transform.toLowerCase()) {
            case "id":
            case "identity":
                return Identity;
            case "i":
            case "inverse":
                return Inverse;
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
            case "se":
            case "shortcut-ex":
            case "shortcuts-e":
                return ShortcutExpanse;
            case "sc":
            case "shortcut-co":
            case "shortcuts-c":
                return ShortcutCollapse;
            case "ntw":
            case "number-to-word":
            case "to-word":
                return NumberToWord;
            case "rr":
            case "repeat-removal":
            case "remove-repeats":
                return RemoveRepeats;
            default:
                return Unknown;
        }
    }

    private final Transformer transform;

    public Function<String, String> getTransform() {
        return transform::transform;
    }
}
