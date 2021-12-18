package pl.put.poznan.transformer.logic.text;

import java.util.ArrayList;
import java.util.List;

public class NumberToWordDecorator extends TransformerDecorator {
    public NumberToWordDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        return text; // TODO - implement NumberToWordDecorator.transform
    }
}
