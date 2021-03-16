package dev.viamarinha.conversion;


import dev.viamarinha.validation.ValidationConverterException;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlConverterTest {

    private Converter converter;

    @BeforeEach
    void setUp() {
        converter = new XmlConverter();
    }

    @Test
    void validateCustomerXmlInput_ShouldReturnTrue_WhenRightFormat() throws ValidationConverterException, JSONException {

        String xmlInput = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        String expected = "{\"note\": {\n" +
                "    \"heading\": \"Reminder\",\n" +
                "    \"from\": \"Jani\",\n" +
                "    \"to\": \"Tove\",\n" +
                "    \"body\": \"Don't forget me this weekend!\"\n" +
                "}}";

        String actual = converter.convert(xmlInput);
        assertEquals(expected, actual);

    }
}