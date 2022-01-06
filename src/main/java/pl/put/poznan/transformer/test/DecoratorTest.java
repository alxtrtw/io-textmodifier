package pl.put.poznan.transformer.test;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.text.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    public void testUppercaseDecoratorTransform() {
        UppercaseDecorator decorator = new UppercaseDecorator(new BaseTransformer());
        assertEquals("UPPERCASEDECORATOR", decorator.transform("uppercasedecorator"));
    }
    @Test
    public void testLowercaseDecoratorTransform(){
        LowercaseDecorator decorator = new LowercaseDecorator(new BaseTransformer());
        assertEquals("lowercasedecorator", decorator.transform("LOWERCASEDECORATOR"));
    }
    @Test
    public void testShortcutExpanderDecorator(){
        ShortcutExpanderDecorator decorator = new ShortcutExpanderDecorator(new BaseTransformer());
        assertEquals("Pan Profesor spóźnił się na zajęcia", decorator.transform("Pan Prof. spóźnił się na zajęcia"));
    }
    @Test
    public void testShortcutCollapserDecorator(){
        ShortcutCollapserDecorator decorator = new ShortcutCollapserDecorator(new BaseTransformer());
        assertEquals("Pieczywo to np. np. chleb i bułki", decorator.transform("Pieczywo to na przykład na przykład  chleb i bułki"));
    }
    @Test
    public void testInverseDecorator(){
        InverseDecorator decorator = new InverseDecorator(new BaseTransformer());
        assertEquals("KerIm", decorator.transform("MirEk"));
    }
}
