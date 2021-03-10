package dev.viamarinha.validators;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class ValidatorImpl implements Validator {


    @Override
    public void jsonValidator(String inputJson) throws ValidationConverterException {

        if (inputJson == null) {
            throw new ValidationConverterException("JsonData is NULL");
        } else if (inputJson.isEmpty())
            throw new ValidationConverterException("Data is empty");
        try {
            JSONObject jsonObject = new JSONObject(inputJson);
        }catch (JSONException ex){
            throw new ValidationConverterException("You have entered an incorrect format", ex);
        }
    }

    @Override
    public void xmlValidator(String inputXml) throws ValidationConverterException {

        if (inputXml == null) {
            throw new ValidationConverterException("XmlData is NULL");
        } else if (inputXml.isEmpty()) {
            throw new ValidationConverterException("Data is empty");
        }
        try {
            JSONObject jsonObject = XML.toJSONObject(inputXml);
        } catch (JSONException ex) {
            throw new ValidationConverterException("You have entered an incorrect format", ex);
        }
    }
}
