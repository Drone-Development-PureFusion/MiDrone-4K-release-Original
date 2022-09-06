package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;
/* loaded from: classes2.dex */
public interface JsonSerializableWithType extends JsonSerializable {
    void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer);
}
