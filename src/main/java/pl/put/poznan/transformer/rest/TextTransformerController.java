package pl.put.poznan.transformer.rest;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/{string}")
public class TextTransformerController {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String string, @RequestParam(value = "transforms", defaultValue = "upper") List<String> transforms) {
        log(string, transforms);

        var transformations = TransformParser.from(transforms);
        var result = TransformsApplier.apply(transformations, string);

        return new Gson().toJson(new TransformationDetails(transformations, string, result));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String string, @RequestBody List<String> transforms) {
        return get(string, transforms);
    }

    private static void log(String text, List<String> transforms) {
        logger.info("Requested transformation of '{}' with transforms: {}", text, transforms);
    }

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
}


