package dev.viamarinha.conversion;


import dev.viamarinha.validation.ValidationConverterException;
import dev.viamarinha.validation.Validator;
import dev.viamarinha.validation.ValidatorImpl;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.XML;

public class XmlConverter implements Converter {

    private final Logger logger = Logger.getLogger(XmlConverter.class);
    private static int PRETTY_PRINT_INDENT_FACTOR = 4;

    @Override
    public String convert(String convertInput) throws ValidationConverterException, JSONException {

        logger.debug("Customer Xml data to convert " + convertInput);
        Validator validator = new ValidatorImpl();
        validator.xmlValidator(convertInput);
        String jsonConverted = XML.toJSONObject(convertInput).toString(PRETTY_PRINT_INDENT_FACTOR);
        logger.debug("Json converted from Xml : " + jsonConverted);
        return jsonConverted;
    }
}
