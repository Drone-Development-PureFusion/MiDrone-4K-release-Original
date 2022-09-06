package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;
@Deprecated
/* loaded from: classes.dex */
public interface JsonSerializable {
    void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider);
}
