package org.codehaus.jackson.jaxrs;

import com.baidu.tts.loopj.RequestParams;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
@Produces({RequestParams.APPLICATION_JSON, "text/json"})
@Provider
@Consumes({RequestParams.APPLICATION_JSON, "text/json"})
/* loaded from: classes.dex */
public class JacksonJaxbJsonProvider extends JacksonJsonProvider {
    public static final Annotations[] DEFAULT_ANNOTATIONS = {Annotations.JACKSON, Annotations.JAXB};

    public JacksonJaxbJsonProvider() {
        this(null, DEFAULT_ANNOTATIONS);
    }

    public JacksonJaxbJsonProvider(ObjectMapper objectMapper, Annotations[] annotationsArr) {
        super(objectMapper, annotationsArr);
    }

    public JacksonJaxbJsonProvider(Annotations... annotationsArr) {
        this(null, annotationsArr);
    }
}
