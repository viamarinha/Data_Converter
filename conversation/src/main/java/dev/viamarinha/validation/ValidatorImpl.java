package dev.viamarinha.validation;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import org.apache.log4j.Logger;

public class ValidatorImpl implements Validator {

    private JSONObject jsonObject;
    private final Logger logger = Logger.getLogger(ValidatorImpl.class);

    @Override
    public void jsonValidator(String inputJson) throws ValidationConverterException {
        logger.debug("Customer Data " + inputJson);
        if (inputJson == null) {
            logger.debug("Customer Data is null");
            throw new ValidationConverterException("Data is NULL");
        } else if (inputJson.isEmpty()) {
            logger.debug("Customer Data is empty");
            throw new ValidationConverterException("Data is empty");
        }
        try {
            jsonObject = new JSONObject(inputJson);
        } catch (JSONException ex) {
            logger.debug("Customer data is in incorrect format", ex);
            throw new ValidationConverterException("You have entered an incorrect format", ex);
        }
    }

    @Override
    public void xmlValidator(String inputXml) throws ValidationConverterException {
        logger.debug("Customer Data " + inputXml);
        if (inputXml == null) {
            logger.debug("Customer Data is null");
            throw new ValidationConverterException("Data is NULL");
        } else if (inputXml.isEmpty()) {
            logger.debug("Customer Data is empty");
            throw new ValidationConverterException("Data is empty");
        }
        try {
            jsonObject = XML.toJSONObject(inputXml);
        } catch (JSONException ex) {
            logger.debug("Customer data is in incorrect format", ex);
            throw new ValidationConverterException("You have entered an incorrect format", ex);
        }
    }
}
