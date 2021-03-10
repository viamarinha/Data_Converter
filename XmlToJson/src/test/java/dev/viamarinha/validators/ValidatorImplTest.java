package dev.viamarinha.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorImplTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new ValidatorImpl();
    }

    //---------------Testing JsonToXmlValidation-----------------//

    @Test
    void validateCustomerJsonInput_ShouldTrowJsonException_WhenIncorrectFormat() {

        String incorrectJson = "\n" +
                "    \"fruit\": \"Apple\",\n" +
                "    \"size\": \"Large\",\n" +
                "    \"color\": \"Red\"\n" +
                "}";
        Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(incorrectJson);
        });

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(incorrectJson);
        });
        String actual = validationConverterException.getMessage();
        String expected = "You have entered an incorrect format";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerJsonInput_ShouldTrowValidatingException_WhenNullCustomerInput() {

        String nullValue = null;
        Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(nullValue);
        });

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(nullValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is NULL";
        assertEquals(expected, actual);

    }

    @Test
    void validateCustomerJsonInput_ShouldTrowValidatingException_WhenCustomerInputEmpty() {

        String emptyValue = "";
        Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(emptyValue);
        });

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.jsonValidator(emptyValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is empty";
        assertEquals(expected, actual);

    }

    //----------------Testing XmlToJsonValidation--------------------//

    @Test
    void validateCustomerXmlInput_ShouldTrowException_WhenIncorrectFormat() {

        String incorrectXml = "<note>\n" +
                "       <toTove</to>\n" +
                "       <from>Jani</from>\n" +
                "       <heading>Reminder</heading>\n" +
                "       <body>Don't forget me this weekend!</body>\n" +
                "   </note>";

        Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(incorrectXml);
        });
        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(incorrectXml);
        });
        String actual = validationConverterException.getMessage();
        String expected = "You have entered an incorrect format";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerXmlInput_ShouldTrowValidatingException_WhenNullCustomerInput() {

        String nullValue = null;
        Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(nullValue);
        });

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(nullValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is NULL";
        assertEquals(expected, actual);

    }

    @Test
    void validateCustomerXmlInput_ShouldTrowValidatingException_WhenCustomerInputEmpty() {

        String emptyValue = "";
        Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(emptyValue);
        });

        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class, () -> {
            validator.xmlValidator(emptyValue);
        });
        String actual = validationConverterException.getMessage();
        String expected = "Data is empty";
        assertEquals(expected, actual);

    }


}

