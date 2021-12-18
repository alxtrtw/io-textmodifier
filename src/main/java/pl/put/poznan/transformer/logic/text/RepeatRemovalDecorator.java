package pl.put.poznan.transformer.logic.text;

import java.util.Arrays;

public class RepeatRemovalDecorator extends TransformerDecorator {
    public RepeatRemovalDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        var previous = new Object() {
            String word = null;
        };
        return Arrays.stream(text.split("\\s+")).reduce(super.transform(""), (sentence, word) -> {
            if (word.equals(previous.word)) return super.transform(sentence);

            previous.word = word;
            return super.transform(sentence + " " + word);
        });
    }
}
