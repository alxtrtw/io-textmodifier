package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/api/v2/{text}")
public class Controller {
  private static final Logger logger = LoggerFactory.getLogger(Controller.class);

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public String get(@PathVariable String text, @RequestParam(value = "transforms", defaultValue = "upper,escape") String[] transforms) {
    logger.debug(text);
    logger.debug(Arrays.toString(transforms));

    TextTransformer transformer = new TextTransformer(transforms);
    return transformer.transform(text);
  }

  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public String post(@PathVariable String text, @RequestBody String[] transforms) {

    logger.debug(text);
    logger.debug(Arrays.toString(transforms));

    TextTransformer transformer = new TextTransformer(transforms);
    return transformer.transform(text);
  }
}

