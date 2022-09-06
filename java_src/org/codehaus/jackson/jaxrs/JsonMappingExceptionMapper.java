package org.codehaus.jackson.jaxrs;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.JsonMappingException;
@Provider
/* loaded from: classes.dex */
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {
    public Response toResponse(JsonMappingException jsonMappingException) {
        return Response.status(Response.Status.BAD_REQUEST).entity(jsonMappingException.getMessage()).type("text/plain").build();
    }
}
