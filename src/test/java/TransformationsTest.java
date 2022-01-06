import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.logic.text.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransformationsTest {
    @Test
    public void test_UppercaseTransformation() {
        Transformer decorator = mock(UppercaseDecorator.class);
        var input = "UPPERCASEDECORATOR";
        var expected = "uppercasedecorator";

        assertEquals(expected, decorator.transform(input));
    }

    @Test
    public void test_LowercaseTransformation() {
        Transformer transformer = new LowercaseDecorator(base);
        var input = "LOWERCASEDECORATOR";
        var expected = "lowercasedecorator";

        assertEquals(expected, transformer.transform(input));
    }

    @Test
    public void test_ShortcutExpandTransformation() {
        Transformer transformer = new ShortcutExpanderDecorator(base);
        var input = "Pan Prof. spóźnił się na zajęcia";
        var expected = "Pan Profesor spóźnił się na zajęcia";

        assertEquals(expected, transformer.transform(input));
    }

    @Test
    public void test_ShortcutCollapseTransformation() {
        Transformer transformer = new ShortcutCollapserDecorator(base);
        var input = "Pieczywo to Na przykład na przykład  chleb i bułki";
        var expected = "Pieczywo to np. np. chleb i bułki";

        assertEquals(expected, transformer.transform(input));
    }

    @Test
    public void test_InverseTransformation() {
        Transformer transformer = new InverseDecorator(base);
        var input = "MirEk";
        var expected = "KerIm";

        assertEquals(expected, transformer.transform(input));
    }

    private static final BaseTransformer base = new BaseTransformer();
}
