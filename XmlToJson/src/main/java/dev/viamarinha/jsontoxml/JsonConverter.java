package dev.viamarinha.jsontoxml;

import com.github.underscore.lodash.U;
import dev.viamarinha.Converter;
import dev.viamarinha.validators.ValidationConverterException;
import dev.viamarinha.validators.Validator;
import dev.viamarinha.validators.ValidatorImpl;



public class JsonConverter implements Converter {

    @Override
    public String convert(String convertInput) throws ValidationConverterException {

        Validator validator = new ValidatorImpl();
        validator.jsonValidator(convertInput);

        return U.jsonToXml(convertInput);

    }
}