package dev.viamarinha.validators;

public interface Validator {

    void jsonValidator(String inputJson) throws ValidationConverterException;

    void xmlValidator(String inputXml) throws ValidationConverterException;
}
