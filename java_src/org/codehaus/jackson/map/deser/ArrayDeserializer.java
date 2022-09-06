package org.codehaus.jackson.map.deser;

import java.lang.reflect.Array;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;
@JacksonStdImpl
/* loaded from: classes.dex */
public class ArrayDeserializer extends ContainerDeserializer<Object[]> {
    protected final JavaType _arrayType;
    protected final Class<?> _elementClass;
    protected final JsonDeserializer<Object> _elementDeserializer;
    final TypeDeserializer _elementTypeDeserializer;
    protected final boolean _untyped;

    @Deprecated
    public ArrayDeserializer(ArrayType arrayType, JsonDeserializer<Object> jsonDeserializer) {
        this(arrayType, jsonDeserializer, null);
    }

    public ArrayDeserializer(ArrayType arrayType, JsonDeserializer<Object> jsonDeserializer, TypeDeserializer typeDeserializer) {
        super(Object[].class);
        this._arrayType = arrayType;
        this._elementClass = arrayType.getContentType().getRawClass();
        this._untyped = this._elementClass == Object.class;
        this._elementDeserializer = jsonDeserializer;
        this._elementTypeDeserializer = typeDeserializer;
    }

    private final Object[] handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (!deserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
            if (jsonParser.getCurrentToken() != JsonToken.VALUE_STRING || this._elementClass != Byte.class) {
                throw deserializationContext.mappingException(this._arrayType.getRawClass());
            }
            return deserializeFromBase64(jsonParser, deserializationContext);
        }
        Object mo22015deserialize = jsonParser.getCurrentToken() == JsonToken.VALUE_NULL ? null : this._elementTypeDeserializer == null ? this._elementDeserializer.mo22015deserialize(jsonParser, deserializationContext) : this._elementDeserializer.mo21953deserializeWithType(jsonParser, deserializationContext, this._elementTypeDeserializer);
        Object[] objArr = this._untyped ? new Object[1] : (Object[]) Array.newInstance(this._elementClass, 1);
        objArr[0] = mo22015deserialize;
        return objArr;
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize  reason: collision with other method in class */
    public Object[] mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int i;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext);
        }
        ObjectBuffer leaseObjectBuffer = deserializationContext.leaseObjectBuffer();
        Object[] resetAndStart = leaseObjectBuffer.resetAndStart();
        TypeDeserializer typeDeserializer = this._elementTypeDeserializer;
        Object[] objArr = resetAndStart;
        int i2 = 0;
        while (true) {
            JsonToken nextToken = jsonParser.nextToken();
            if (nextToken == JsonToken.END_ARRAY) {
                break;
            }
            Object mo22015deserialize = nextToken == JsonToken.VALUE_NULL ? null : typeDeserializer == null ? this._elementDeserializer.mo22015deserialize(jsonParser, deserializationContext) : this._elementDeserializer.mo21953deserializeWithType(jsonParser, deserializationContext, typeDeserializer);
            if (i2 >= objArr.length) {
                objArr = leaseObjectBuffer.appendCompletedChunk(objArr);
                i = 0;
            } else {
                i = i2;
            }
            i2 = i + 1;
            objArr[i] = mo22015deserialize;
        }
        Object[] completeAndClearBuffer = this._untyped ? leaseObjectBuffer.completeAndClearBuffer(objArr, i2) : leaseObjectBuffer.completeAndClearBuffer(objArr, i2, this._elementClass);
        deserializationContext.returnObjectBuffer(leaseObjectBuffer);
        return completeAndClearBuffer;
    }

    protected Byte[] deserializeFromBase64(JsonParser jsonParser, DeserializationContext deserializationContext) {
        byte[] binaryValue = jsonParser.getBinaryValue(deserializationContext.getBase64Variant());
        Byte[] bArr = new Byte[binaryValue.length];
        int length = binaryValue.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = Byte.valueOf(binaryValue[i]);
        }
        return bArr;
    }

    @Override // org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserializeWithType  reason: collision with other method in class */
    public Object[] mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return (Object[]) typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    @Override // org.codehaus.jackson.map.deser.ContainerDeserializer
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._elementDeserializer;
    }

    @Override // org.codehaus.jackson.map.deser.ContainerDeserializer
    public JavaType getContentType() {
        return this._arrayType.getContentType();
    }
}
