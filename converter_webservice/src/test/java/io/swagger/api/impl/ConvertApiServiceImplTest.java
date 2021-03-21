package io.swagger.api.impl;

import dev.viamarinha.validation.ValidationConverterException;
import dev.viamarinha.validation.Validator;
import dev.viamarinha.validation.ValidatorImpl;
import io.swagger.model.Type;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class ConvertApiServiceImplTest extends TestCase {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validator = new ValidatorImpl();
    }

    @Test
    void validateCustomerType_shouldThrowValidatingException_whenNullCustomerTypeOrEmpty() {
        ValidationConverterException validationConverterException = Assertions.assertThrows(ValidationConverterException.class,
                () -> validator.typeValidator(null));
        String actual = validationConverterException.getMessage();
        String expected = " Type is incorrect format or Null ";
        assertEquals(expected, actual);
    }

    @Test
    void validateCustomerType_shouldNotThrowValidatingException_whenTypeOk() {

        assertDoesNotThrow(() -> validator.typeValidator(Type.JSON));
        assertDoesNotThrow(() -> validator.typeValidator(Type.XML));
    }

}