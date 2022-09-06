package org.codehaus.jackson.schema;

import java.lang.reflect.Type;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
/* loaded from: classes2.dex */
public interface SchemaAware {
    JsonNode getSchema(SerializerProvider serializerProvider, Type type);
}
