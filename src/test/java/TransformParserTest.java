import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.rest.TransformParser;
import pl.put.poznan.transformer.rest.TransformMethod;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransformParserTest {
    TransformParser decorator = mock(TransformParser.class);

    @Test
    public void ShouldReturnTransforms() {
        List<String> input = Arrays.asList("id", "i", "u", "l", "c", "se", "sc", "ntw", "rr", "cc");
        List<TransformMethod> expected =
                Arrays.asList(  TransformMethod.Identity, TransformMethod.Inverse, TransformMethod.Uppercase,
                                TransformMethod.Lowercase, TransformMethod.Capitalize, TransformMethod.ShortcutExpanse,
                                TransformMethod.ShortcutCollapse, TransformMethod.NumberToWord,
                                TransformMethod.RemoveRepeats, TransformMethod.CesarCipher);

        assertEquals(expected, TransformParser.from(input));
    }

    @Test
    public void ShouldReturnDuplicates() {
        List<String> input = Arrays.asList("cc", "cesar", "cesar-cipher");
        List<TransformMethod> expected =
                Arrays.asList(TransformMethod.CesarCipher, TransformMethod.CesarCipher, TransformMethod.CesarCipher);

        assertEquals(expected, TransformParser.from(input));
    }

    @Test
    public void ShouldReturnUnknown() {
        List<String> input = Arrays.asList("lowercaaase", "identty", "");
        List<TransformMethod> expected =
                Arrays.asList(TransformMethod.Unknown, TransformMethod.Unknown, TransformMethod.Unknown);

        assertEquals(expected, TransformParser.from(input));
    }

    @Test
    public void ShouldReturnEmptyList() {
        List<String> input = Arrays.asList();
        List<TransformMethod> expected = Arrays.asList();

        assertEquals(expected, TransformParser.from(input));
    }

}
