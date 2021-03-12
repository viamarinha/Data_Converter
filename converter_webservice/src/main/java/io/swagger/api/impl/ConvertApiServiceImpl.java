package io.swagger.api.impl;

import dev.viamarinha.Converter;
import dev.viamarinha.jsontoxml.JsonConverter;
import dev.viamarinha.validators.ValidationConverterException;
import dev.viamarinha.validators.Validator;
import dev.viamarinha.validators.ValidatorImpl;
import dev.viamarinha.xmltojson.XmlConverter;
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

    final static Logger logger = Logger.getLogger(ConvertApiServiceImpl.class);

    @Override
    public Response convertPost(Input body, SecurityContext securityContext) throws NotFoundException, ValidationConverterException {

        Validator validator = new ValidatorImpl();
        Converter converter = null;

        try {
            if (Type.XML.equals(body.getType())) {
                validator.xmlValidator(body.getCustomerData());
                converter = new XmlConverter();


            } else if (Type.JSON.equals(body.getType())) {
                validator.jsonValidator(body.getCustomerData());
                converter = new JsonConverter();

            }
        } catch (ValidationConverterException ex) {
            {
                logger.error("Error while validate data to convert" + ex.getMessage());
                BadConversationResult response = new BadConversationResult();
                response.validation(false);
                response.setValidationMessage(ex.getMessage());
                return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
            }
        }

        return getResponse(body, converter);
    }

    private Response getResponse(Input body, Converter converter) throws ValidationConverterException {
        ValidResponse response = new ValidResponse();
        response.setData(converter.convert(body.getCustomerData()));
        return Response.ok().entity(response).build();
    }
}




