package dev.viamarinha.conversion;

import dev.viamarinha.validation.ValidationConverterException;
import org.json.*;

public interface Converter {

    String convert(String convertInput) throws ValidationConverterException, JSONException;
}
