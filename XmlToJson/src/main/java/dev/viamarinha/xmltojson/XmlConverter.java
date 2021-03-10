package dev.viamarinha.xmltojson;


import dev.viamarinha.Converter;
import dev.viamarinha.validators.ValidationConverterException;
import dev.viamarinha.validators.Validator;
import dev.viamarinha.validators.ValidatorImpl;
import org.json.JSONException;
import org.json.XML;

public class XmlConverter implements Converter {

    private static int PRETTY_PRINT_INDENT_FACTOR = 4;

    @Override
    public String convert(String convertInput) throws ValidationConverterException, JSONException {

        Validator validator = new ValidatorImpl();
        validator.xmlValidator(convertInput);
        return XML.toJSONObject(convertInput).toString(PRETTY_PRINT_INDENT_FACTOR);
    }
}
