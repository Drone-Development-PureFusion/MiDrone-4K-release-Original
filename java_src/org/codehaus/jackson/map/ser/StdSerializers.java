package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSerializableSchema;
import org.codehaus.jackson.util.TokenBuffer;
/* loaded from: classes2.dex */
public class StdSerializers {

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class BooleanSerializer extends NonTypedScalarSerializer<Boolean> {
        final boolean _forPrimitive;

        public BooleanSerializer(boolean z) {
            super(Boolean.class);
            this._forPrimitive = z;
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("boolean", !this._forPrimitive);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Boolean bool, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeBoolean(bool.booleanValue());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class CalendarSerializer extends ScalarSerializerBase<Calendar> {
        public static final CalendarSerializer instance = new CalendarSerializer();

        public CalendarSerializer() {
            super(Calendar.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? "number" : "string", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Calendar calendar, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            serializerProvider.defaultSerializeDateValue(calendar.getTimeInMillis(), jsonGenerator);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class DoubleSerializer extends NonTypedScalarSerializer<Double> {
        static final DoubleSerializer instance = new DoubleSerializer();

        public DoubleSerializer() {
            super(Double.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("number", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Double d, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(d.doubleValue());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class FloatSerializer extends ScalarSerializerBase<Float> {
        static final FloatSerializer instance = new FloatSerializer();

        public FloatSerializer() {
            super(Float.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("number", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Float f, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(f.floatValue());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class IntLikeSerializer extends ScalarSerializerBase<Number> {
        static final IntLikeSerializer instance = new IntLikeSerializer();

        public IntLikeSerializer() {
            super(Number.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("integer", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Number number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(number.intValue());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class IntegerSerializer extends NonTypedScalarSerializer<Integer> {
        public IntegerSerializer() {
            super(Integer.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("integer", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Integer num, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(num.intValue());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class LongSerializer extends ScalarSerializerBase<Long> {
        static final LongSerializer instance = new LongSerializer();

        public LongSerializer() {
            super(Long.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("number", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Long l, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeNumber(l.longValue());
        }
    }

    /* loaded from: classes2.dex */
    protected static abstract class NonTypedScalarSerializer<T> extends ScalarSerializerBase<T> {
        protected NonTypedScalarSerializer(Class<T> cls) {
            super(cls);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.JsonSerializer
        public final void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            serialize(t, jsonGenerator, serializerProvider);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class NumberSerializer extends ScalarSerializerBase<Number> {
        public static final NumberSerializer instance = new NumberSerializer();

        public NumberSerializer() {
            super(Number.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("number", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Number number, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            if (number instanceof BigDecimal) {
                jsonGenerator.writeNumber((BigDecimal) number);
            } else if (number instanceof BigInteger) {
                jsonGenerator.writeNumber((BigInteger) number);
            } else if (number instanceof Integer) {
                jsonGenerator.writeNumber(number.intValue());
            } else if (number instanceof Long) {
                jsonGenerator.writeNumber(number.longValue());
            } else if (number instanceof Double) {
                jsonGenerator.writeNumber(number.doubleValue());
            } else if (number instanceof Float) {
                jsonGenerator.writeNumber(number.floatValue());
            } else if ((number instanceof Byte) || (number instanceof Short)) {
                jsonGenerator.writeNumber(number.intValue());
            } else {
                jsonGenerator.writeNumber(number.toString());
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class SerializableSerializer extends SerializerBase<JsonSerializable> {
        protected static final SerializableSerializer instance = new SerializableSerializer();

        private SerializableSerializer() {
            super(JsonSerializable.class);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            String str;
            String str2 = null;
            ObjectNode createObjectNode = createObjectNode();
            String str3 = "any";
            if (type != null) {
                Class<?> rawClass = TypeFactory.type(type).getRawClass();
                if (rawClass.isAnnotationPresent(JsonSerializableSchema.class)) {
                    JsonSerializableSchema jsonSerializableSchema = (JsonSerializableSchema) rawClass.getAnnotation(JsonSerializableSchema.class);
                    String schemaType = jsonSerializableSchema.schemaType();
                    str = !"##irrelevant".equals(jsonSerializableSchema.schemaObjectPropertiesDefinition()) ? jsonSerializableSchema.schemaObjectPropertiesDefinition() : null;
                    if (!"##irrelevant".equals(jsonSerializableSchema.schemaItemDefinition())) {
                        str2 = jsonSerializableSchema.schemaItemDefinition();
                        str3 = schemaType;
                    } else {
                        str3 = schemaType;
                    }
                    createObjectNode.put("type", str3);
                    if (str != null) {
                        try {
                            createObjectNode.put("properties", (JsonNode) new ObjectMapper().readValue(str, JsonNode.class));
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    if (str2 != null) {
                        try {
                            createObjectNode.put("items", (JsonNode) new ObjectMapper().readValue(str2, JsonNode.class));
                        } catch (IOException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                    return createObjectNode;
                }
            }
            str = null;
            createObjectNode.put("type", str3);
            if (str != null) {
            }
            if (str2 != null) {
            }
            return createObjectNode;
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonSerializable.serialize(jsonGenerator, serializerProvider);
        }

        @Override // org.codehaus.jackson.map.JsonSerializer
        public final void serializeWithType(JsonSerializable jsonSerializable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            if (jsonSerializable instanceof JsonSerializableWithType) {
                ((JsonSerializableWithType) jsonSerializable).serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
            } else {
                serialize(jsonSerializable, jsonGenerator, serializerProvider);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class SerializableWithTypeSerializer extends SerializerBase<JsonSerializableWithType> {
        protected static final SerializableWithTypeSerializer instance = new SerializableWithTypeSerializer();

        private SerializableWithTypeSerializer() {
            super(JsonSerializableWithType.class);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            String str;
            String str2 = null;
            ObjectNode createObjectNode = createObjectNode();
            String str3 = "any";
            if (type != null) {
                Class<?> rawClass = TypeFactory.rawClass(type);
                if (rawClass.isAnnotationPresent(JsonSerializableSchema.class)) {
                    JsonSerializableSchema jsonSerializableSchema = (JsonSerializableSchema) rawClass.getAnnotation(JsonSerializableSchema.class);
                    String schemaType = jsonSerializableSchema.schemaType();
                    str = !"##irrelevant".equals(jsonSerializableSchema.schemaObjectPropertiesDefinition()) ? jsonSerializableSchema.schemaObjectPropertiesDefinition() : null;
                    if (!"##irrelevant".equals(jsonSerializableSchema.schemaItemDefinition())) {
                        str2 = jsonSerializableSchema.schemaItemDefinition();
                        str3 = schemaType;
                    } else {
                        str3 = schemaType;
                    }
                    createObjectNode.put("type", str3);
                    if (str != null) {
                        try {
                            createObjectNode.put("properties", (JsonNode) new ObjectMapper().readValue(str, JsonNode.class));
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    }
                    if (str2 != null) {
                        try {
                            createObjectNode.put("items", (JsonNode) new ObjectMapper().readValue(str2, JsonNode.class));
                        } catch (IOException e2) {
                            throw new IllegalStateException(e2);
                        }
                    }
                    return createObjectNode;
                }
            }
            str = null;
            createObjectNode.put("type", str3);
            if (str != null) {
            }
            if (str2 != null) {
            }
            return createObjectNode;
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(JsonSerializableWithType jsonSerializableWithType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonSerializableWithType.serialize(jsonGenerator, serializerProvider);
        }

        @Override // org.codehaus.jackson.map.JsonSerializer
        public final void serializeWithType(JsonSerializableWithType jsonSerializableWithType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            jsonSerializableWithType.serializeWithType(jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class SqlDateSerializer extends ScalarSerializerBase<Date> {
        public SqlDateSerializer() {
            super(Date.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeString(date.toString());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class SqlTimeSerializer extends ScalarSerializerBase<Time> {
        public SqlTimeSerializer() {
            super(Time.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(Time time, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeString(time.toString());
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class StringSerializer extends NonTypedScalarSerializer<String> {
        public StringSerializer() {
            super(String.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("string", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeString(str);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class TokenBufferSerializer extends SerializerBase<TokenBuffer> {
        public TokenBufferSerializer() {
            super(TokenBuffer.class);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode("any", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(TokenBuffer tokenBuffer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            tokenBuffer.serialize(jsonGenerator);
        }

        @Override // org.codehaus.jackson.map.JsonSerializer
        public final void serializeWithType(TokenBuffer tokenBuffer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            typeSerializer.writeTypePrefixForScalar(tokenBuffer, jsonGenerator);
            serialize(tokenBuffer, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffixForScalar(tokenBuffer, jsonGenerator);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class UtilDateSerializer extends ScalarSerializerBase<java.util.Date> {
        public static final UtilDateSerializer instance = new UtilDateSerializer();

        public UtilDateSerializer() {
            super(java.util.Date.class);
        }

        @Override // org.codehaus.jackson.map.ser.ScalarSerializerBase, org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            return createSchemaNode(serializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS) ? "number" : "string", true);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public void serialize(java.util.Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            serializerProvider.defaultSerializeDateValue(date, jsonGenerator);
        }
    }

    protected StdSerializers() {
    }
}
