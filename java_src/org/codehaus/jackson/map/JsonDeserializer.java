package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonParser;
/* loaded from: classes.dex */
public abstract class JsonDeserializer<T> {

    /* loaded from: classes.dex */
    public static abstract class None extends JsonDeserializer<Object> {
    }

    /* renamed from: deserialize */
    public abstract T mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext);

    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, T t) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: deserializeWithType */
    public Object mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public T getNullValue() {
        return null;
    }
}
