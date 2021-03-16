package dev.viamarinha.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorImplTest {

    private Validator validator;
    private String nullValue;
    private String emptyValue;

    @BeforeEach
    void setUp() {
        validator = new ValidatorImpl();
        nullValue = null;
        emptyValue = "";
    }

    //---------------Testing JsonToXmlValidation-----------------//

    @Test
    void validateCustomerJsonInput_shouldThrowJsonException_WhenIncorrectFormat() {

        String incorrectJson = "\n" +
                "    \"fruit\": \"Apple\",\n" +
                "    \"size\": \"Large\",\n" +
                "    \"color\": \"Red\"\n" +
                "}";

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(incorrectJson);
        });
        String actual = validationConverterException.getMessage();
        String expected = "You have entered an incorrect format";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerJsonInput_shouldThrowValidatingException_WhenNullCustomerInput() {

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(nullValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is NULL";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerJsonInput_shouldThrowValidatingException_WhenCustomerInputEmpty() {

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(emptyValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is empty";
        assertEquals(expected, actual);
    }

    //----------------Testing XmlToJsonValidation--------------------//

    @Test
    void validateCustomerXmlInput_shouldThrowException_WhenIncorrectFormat() {

        String incorrectXml = "<note>\n" +
                "       <toTove</to>\n" +
                "       <from>Jani</from>\n" +
                "       <heading>Reminder</heading>\n" +
                "       <body>Don't forget me this weekend!</body>\n" +
                "   </note>";

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(incorrectXml);
        });
        String actual = validationConverterException.getMessage();
        String expected = "You have entered an incorrect format";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerXmlInput_shouldThrowValidatingException_WhenNullCustomerInput() {

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(nullValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is NULL";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerXmlInput_shouldThrowValidatingException_WhenCustomerInputEmpty() {

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(emptyValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is empty";
        assertEquals(expected, actual);
    }


}

