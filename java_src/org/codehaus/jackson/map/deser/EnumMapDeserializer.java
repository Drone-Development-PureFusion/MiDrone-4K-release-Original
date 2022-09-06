package org.codehaus.jackson.map.deser;

import java.util.EnumMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
/* loaded from: classes2.dex */
public final class EnumMapDeserializer extends StdDeserializer<EnumMap<?, ?>> {
    final EnumResolver<?> _enumResolver;
    final JsonDeserializer<Object> _valueDeserializer;

    public EnumMapDeserializer(EnumResolver<?> enumResolver, JsonDeserializer<Object> jsonDeserializer) {
        super(EnumMap.class);
        this._enumResolver = enumResolver;
        this._valueDeserializer = jsonDeserializer;
    }

    private EnumMap<?, ?> constructMap() {
        return new EnumMap<>(this._enumResolver.getEnumClass());
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize  reason: collision with other method in class */
    public EnumMap<?, ?> mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
            throw deserializationContext.mappingException(EnumMap.class);
        }
        EnumMap<?, ?> constructMap = constructMap();
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            Object findEnum = this._enumResolver.findEnum(jsonParser.getCurrentName());
            if (findEnum == 0) {
                throw deserializationContext.weirdStringException(this._enumResolver.getEnumClass(), "value not one of declared Enum instance names");
            }
            constructMap.put((EnumMap<?, ?>) findEnum, (Object) (jsonParser.nextToken() == JsonToken.VALUE_NULL ? null : this._valueDeserializer.mo22015deserialize(jsonParser, deserializationContext)));
        }
        return constructMap;
    }

    @Override // org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserializeWithType */
    public Object mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromObject(jsonParser, deserializationContext);
    }
}
