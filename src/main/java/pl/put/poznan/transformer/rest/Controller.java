package pl.put.poznan.transformer.rest;

import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;
import java.util.function.Function;

@RestController
@RequestMapping("/api/v2/{text}")
public class Controller {
    public Function<String, String> transformMethod(String transform) {
        switch (transform.toLowerCase()) {
            case "upper":
            case "uppercase":
                return TextTransformer::asUpperCase;
            case "lower":
            case "lowercase":
                return TextTransformer::asLowerCase;
            case "capitalize":
            case "capitalized":
                return TextTransformer::captalize;
            case "number-to-word":
            case "to-word":
                return TextTransformer::numberToWord;
            default:
                throw new IllegalStateException("Unexpected value: " + transform);
        }
    }


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text, @RequestParam(value = "transforms", defaultValue = "upper,escape") String[] transforms) {
        log(text, transforms);
        return TextTransformer.asLowerCase(text);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text, @RequestBody String[] transforms) {
        log(text, transforms);
        var a =
            text;
        for (String transform : transforms) {
            Function<String, String> stringStringFunction = transformMethod(transform);
            a = stringStringFunction.apply(a);
        }
        return a;
//        return TextTransformer.asLowerCase(text);
    }

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private static void log(String text, String[] transforms) {
        logger.info(
            "Requested transformation of '{}' with transforms: {}",
            text, Arrays.toString(transforms)
        );
    }
}


