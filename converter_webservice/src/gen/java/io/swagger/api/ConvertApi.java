package io.swagger.api;

import dev.viamarinha.validators.ValidationConverterException;
import io.swagger.api.factories.ConvertApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.model.BadConversationResult;
import io.swagger.model.Input;
import io.swagger.model.ValidResponse;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;


@Path("/Convert")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-03-09T02:20:28.751Z[GMT]")public class ConvertApi  {
   private final ConvertApiService delegate;

   public ConvertApi(@Context ServletConfig servletContext) {
      ConvertApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ConvertApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ConvertApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ConvertApiServiceFactory.getConvertApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @Operation(summary = "", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ValidResponse.class))),
        
        @ApiResponse(responseCode = "400", description = "data is in incorrect format", content = @Content(schema = @Schema(implementation = BadConversationResult.class))) })
    public Response convertPost(@Parameter(in = ParameterIn.DEFAULT, description = "convert an xml to json and vise versa" ,required=true) Input body

,@Context SecurityContext securityContext)
            throws NotFoundException, ValidationConverterException {
        return delegate.convertPost(body,securityContext);
    }
}
