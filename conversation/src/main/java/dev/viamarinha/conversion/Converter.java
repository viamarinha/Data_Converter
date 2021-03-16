package dev.viamarinha.conversion;

import dev.viamarinha.validation.ValidationConverterException;
import org.json.JSONException;

public interface Converter {

    String convert(String convertInput) throws ValidationConverterException, JSONException;
}
