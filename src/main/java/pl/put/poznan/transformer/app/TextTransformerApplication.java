package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class TextTransformerApplication {

    public static void main(String[] args) {
        TextTransformer textTransformer = new TextTransformer();
        textTransformer.transformShorcuts("Pan prof. się spóźnił Np.");
        SpringApplication.run(TextTransformerApplication.class, args);
    }
}
