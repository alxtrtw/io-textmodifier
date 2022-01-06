package pl.put.poznan.transformer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Wejście aplikacji.
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.transformer.rest"})
public class Application {
    /**
     * Główna metoda aplikacji.
     *
     * @param args Argumenty aplikacji (nieużywane)
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
