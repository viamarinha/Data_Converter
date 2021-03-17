package dev.viamarinha.conversion;

import com.github.underscore.lodash.U;
import dev.viamarinha.validation.ValidationConverterException;
import dev.viamarinha.validation.Validator;
import dev.viamarinha.validation.ValidatorImpl;
import org.apache.log4j.Logger;
import org.json.JSONException;


public class JsonConverter implements Converter {

    private final Logger logger = Logger.getLogger(JsonConverter.class);

    @Override
    public String convert(String convertInput) throws ValidationConverterException, JSONException {

        logger.debug("Customer JsonData to convert" + convertInput);
        Validator validator = new ValidatorImpl();
        validator.jsonValidator(convertInput);
        String xml = U.jsonToXml(convertInput);
        if(logger.isDebugEnabled())
        logger.debug("Xml converted from json" + xml);
        return xml;
    }
}