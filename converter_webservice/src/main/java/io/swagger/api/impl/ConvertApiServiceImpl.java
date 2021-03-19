package io.swagger.api.impl;

import dev.viamarinha.conversion.Converter;
import dev.viamarinha.conversion.JsonConverter;
import dev.viamarinha.validation.ValidationConverterException;
import dev.viamarinha.validation.Validator;
import dev.viamarinha.validation.ValidatorImpl;
import dev.viamarinha.conversion.XmlConverter;
import io.swagger.api.*;

import io.swagger.model.BadConversationResult;
import io.swagger.model.Input;

import io.swagger.api.NotFoundException;
import io.swagger.model.Type;
import io.swagger.model.ValidResponse;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-09T02:20:28.751Z[GMT]")
public class ConvertApiServiceImpl extends ConvertApiService {

    Converter converter = null;
    Validator validator = new ValidatorImpl();
    final static Logger logger = Logger.getLogger(ConvertApiServiceImpl.class);

    @Override
    public Response convertPost(Input body, SecurityContext securityContext) throws NotFoundException, ValidationConverterException {

        logger.debug("Customer data to convert : " + body);
        try {
            validateCustomerType(body, validator);
            converter = getConverter(body);
        } catch (ValidationConverterException ex) {

            return getFailedResponse(ex);
        }
        return getResponse(body);
    }

    private void validateCustomerType(Input body, Validator validator) throws ValidationConverterException {

        logger.debug(" TypeOfdata to handle : " + body.getType());
        validator.typeValidator(body.getType());
    }

    private Converter getConverter(Input body) throws ValidationConverterException {

        if (Type.XML.equals(body.getType())) {
            validator.xmlValidator(body.getCustomerData());
            converter = new XmlConverter();
            logger.trace("Validation pased. Returned XmlConverter.");

        } else if (Type.JSON.equals(body.getType())) {
            validator.jsonValidator(body.getCustomerData());
            converter = new JsonConverter();
            logger.trace("Validation pased. Returned JsonConverter.");
        }
        return converter;
    }

    private Response getFailedResponse(ValidationConverterException ex) {

        logger.error(ex.getMessage(), ex);
        BadConversationResult response = new BadConversationResult();
        response.validation(false);
        response.setValidationMessage(ex.getMessage());
        Response finalResponse = Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        logger.debug(" FinalFailedResponse " + finalResponse);
        return finalResponse;
    }

    private Response getResponse(Input body) throws ValidationConverterException {

        ValidResponse response = new ValidResponse();
        response.setData(converter.convert(body.getCustomerData()));
        logger.debug(" Valid response to client " + response);
        return Response.ok().entity(response).build();
    }
}




