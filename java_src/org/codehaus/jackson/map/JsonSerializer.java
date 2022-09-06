package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;
/* loaded from: classes.dex */
public abstract class JsonSerializer<T> {

    /* loaded from: classes.dex */
    public static abstract class None extends JsonSerializer<Object> {
    }

    public Class<T> handledType() {
        return null;
    }

    public abstract void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

    public void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        serialize(t, jsonGenerator, serializerProvider);
    }
}
