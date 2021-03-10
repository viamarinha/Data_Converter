package dev.viamarinha;

import dev.viamarinha.validators.ValidationConverterException;
import org.json.JSONException;

public interface Converter {

    String convert(String convertInput) throws ValidationConverterException, JSONException;
}
