package dev.viamarinha.jsontoxml;

import dev.viamarinha.Converter;
import dev.viamarinha.validators.ValidationConverterException;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonConverterTest {

    private Converter converter;

    @BeforeEach
    void setUp() {
        converter = new JsonConverter();
    }

    @Test
    void validateCustomerJsonInput_ShouldReturnTrue_WhenRightFormat() throws ValidationConverterException, JSONException {

        String jsonInput = "{\n" +
                "    \"fruit\": \"Apple\",\n" +
                "    \"size\": \"Large\",\n" +
                "    \"color\": \"Red\"\n" +
                "}";

        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "  <fruit>Apple</fruit>\n" +
                "  <size>Large</size>\n" +
                "  <color>Red</color>\n" +
                "</root>";

        String actual = converter.convert(jsonInput);

        assertEquals(expected, actual);

    }
}