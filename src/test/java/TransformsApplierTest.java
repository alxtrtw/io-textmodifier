import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.rest.TransformMethod;
import pl.put.poznan.transformer.rest.TransformParser;
import pl.put.poznan.transformer.rest.TransformsApplier;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TransformsApplierTest {

    @Test
    public void ShouldReturnIdentical() {
        TransformsApplier decorator = mock(TransformsApplier.class);
        List<TransformMethod> inputTransforms = Arrays.asList(TransformMethod.Inverse, TransformMethod.Inverse);
        String inputString = "Ala ma kota o imieniu Bartłomiej";

        assertEquals(inputString, decorator.apply(inputTransforms, inputString));
    }

    @Test
    public void ShouldReturnSingleNumber() {
        TransformsApplier decorator = mock(TransformsApplier.class);
        List<TransformMethod> inputTransforms =
                Arrays.asList(TransformMethod.NumberToWord, TransformMethod.RemoveRepeats);
        String inputString = "Mam w portfelu 1000 tysiąc złotych";
        String outputString = "Mam w portfelu tysiąc złotych";

        assertEquals(outputString, decorator.apply(inputTransforms, inputString));
    }

    @Test
    public void ShouldReturnProperIntroduction() {
        TransformsApplier decorator = mock(TransformsApplier.class);
        List<TransformMethod> inputTransforms =
                Arrays.asList(TransformMethod.Capitalize, TransformMethod.ShortcutExpanse);
        String inputString = "szanowna Pani prof.";
        String outputString = "Szanowna Pani Profesor";

        assertEquals(outputString, decorator.apply(inputTransforms, inputString));
    }

    @Test
    public void ShouldReturnUpperAndLowerNumbers() {
        TransformsApplier decorator = mock(TransformsApplier.class);
        List<TransformMethod> inputTransforms =
                Arrays.asList(TransformMethod.Uppercase, TransformMethod.NumberToWord);
        String inputString = "tysiąc 1000 sto 100 dwieście 200";
        String outputString = "TYSIĄC tysiąc STO sto DWIEŚCIE dwieście";

        assertEquals(outputString, decorator.apply(inputTransforms, inputString));
    }



}
