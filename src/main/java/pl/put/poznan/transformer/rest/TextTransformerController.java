package pl.put.poznan.transformer.rest;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Kontroler odpowiedzialny za transformacje tekstu wraz z obsługą dostępnych w projekcie transformacji.
 * Kontroler przymuje dane na endpoint /api/v2/{string} z opcjonalnym ?transforms
 * decydującym o transformacjach i zwraca odpowiedź w postaci JSON.
 */
@CrossOrigin
@RestController
@RequestMapping("{string}")
public class TextTransformerController {

    /**
     * @param string     tekst do transformacji
     * @param transforms lista transformacji
     * @return odpowiedź w postaci JSON
     */
    @GetMapping(produces = "application/json")
    public String get(@PathVariable String string, @RequestParam(value = "transforms", defaultValue = "upper") List<String> transforms) {
        log(string, transforms);

        var transformations = TransformParser.from(transforms);
        var result = TransformsApplier.apply(transformations, string);

        return new Gson().toJson(new TransformationModel(transformations, string, result));
    }

    /**
     * @param string     tekst do transformacji
     * @param transforms lista transformacji
     * @return odpowiedź w postaci JSON
     */
    @PostMapping(produces = "application/json", consumes = "application/json")
    public String post(@PathVariable String string, @RequestBody List<String> transforms) {
        return get(string, transforms);
    }

    /**
     * Logowanie do aplikacji informacji o przetwarzanych danych.
     *
     * @param text       tekst do transformacji
     * @param transforms lista transformacji
     */
    private static void log(String text, List<String> transforms) {
        logger.info("Requested transformation of '{}' with transforms: {}", text, transforms);
    }

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);
}


