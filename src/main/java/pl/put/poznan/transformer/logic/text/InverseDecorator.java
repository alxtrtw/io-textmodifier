package pl.put.poznan.transformer.logic.text;

import java.util.ArrayList;
import java.util.List;

public class InverseDecorator extends TransformerDecorator {
    public InverseDecorator(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        text = super.transform(text);
        List<String> list = new ArrayList<>();
        String reverse = new StringBuffer(text).reverse().toString().toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                list.add(Character.toString(reverse.charAt(i)).toUpperCase());
            } else {
                list.add(Character.toString(reverse.charAt(i)));
            }
        }
        return String.join("", list);
    }
}
