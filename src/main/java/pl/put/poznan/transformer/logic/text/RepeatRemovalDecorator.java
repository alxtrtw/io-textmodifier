package pl.put.poznan.transformer.logic.text;

import io.vavr.collection.Stream;

/**
 * Klasa odpowiedzialna za pozbycie się powtórzeń w tekście.
 */
public class RepeatRemovalDecorator extends TransformerDecorator {
    public RepeatRemovalDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        final var previous = new Object() {
            String word = null;
        };

        return Stream.of(text.split("\\s+")).reduce((sentence, word) -> {
            if (word.equals(previous.word)) return super.transform(sentence);

            previous.word = word;
            return super.transform(sentence + " " + word);
        });
    }

}
