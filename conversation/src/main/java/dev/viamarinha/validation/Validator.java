package dev.viamarinha.validation;

public interface Validator {

    void typeValidator(Enum type) throws ValidationConverterException;

    void jsonValidator(String inputJson) throws ValidationConverterException;

    void xmlValidator(String inputXml) throws ValidationConverterException;
}
