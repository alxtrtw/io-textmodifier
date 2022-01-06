package pl.put.poznan.transformer.rest;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TextTransformerControllerTest {
    private final TextTransformerController controller = new TextTransformerController();

    @Test
    public void testGetJsonResponseContainsIdentityMethod() {
        var input = "To jEst TeKst";
        var expected = "{\"transformations\":[\"Identity\"],\"source\":\"To jEst TeKst\",\"result\":\"To jEst TeKst\"}";
        List<String> transforms = List.of("id");

        var output = controller.get(input, transforms);
        assertEquals(expected, output);
    }

    @Test
    public void testGetJsonResponseContainsInverseMethod() {
        var input = "To jEst TeKst";
        var expected = "{\"transformations\":[\"Inverse\"],\"source\":\"To jEst TeKst\",\"result\":\"TskeT tsEj ot\"}";
        List<String> transforms = List.of("i");

        var output = controller.get(input, transforms);
        assertEquals(expected, output);
    }

    @Test
    public void testGetJsonResponseContainsUppercaseMethod() {
        var input = "To jEst TeKst";
        var expected = "{\"transformations\":[\"Uppercase\"],\"source\":\"To jEst TeKst\",\"result\":\"TO JEST TEKST\"}";
        List<String> transforms = List.of("uppercase");

        var output = controller.get(input, transforms);
        assertEquals(expected, output);
    }

    @Test
    public void testGetJsonResponseContainsLowercaseMethod() {
        var input = "To jEst TeKst";
        var expected = "{\"transformations\":[\"Lowercase\"],\"source\":\"To jEst TeKst\",\"result\":\"to jest tekst\"}";
        List<String> transforms = List.of("lowercase");

        var output = controller.get(input, transforms);
        assertEquals(expected, output);
    }

    @Test
    public void testGetJsonResponseHandlesMultipleMethods() {
        var input = "To jEst TeKst";
        var expected = "{\"transformations\":[\"Lowercase\",\"Uppercase\",\"Lowercase\"],\"source\":\"To jEst TeKst\",\"result\":\"to jest tekst\"}";
        List<String> transforms = List.of("lowercase", "uppercase", "lowercase");

        var output = controller.get(input, transforms);
        assertEquals(expected, output);
    }

    @Test
    public void testWithoutGsonLibraryDependency() {
        var gson = mock(Gson.class);

        var expected = "{\"transformations\":[\"Identity\"],\"source\":\"To jEst TeKst\",\"result\":\"To jEst TeKst\"}";
        when(gson.toJson(any(TransformationModel.class))).thenReturn(expected);
        controller.gson = gson;


        var input = "To jEst TeKst";
        List<String> transforms = List.of("id");
        var output = controller.get(input, transforms);
        assertEquals(expected, output);
    }
}