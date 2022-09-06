package org.codehaus.jackson.map.deser;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.p316io.NumberInput;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;
/* loaded from: classes2.dex */
public abstract class StdDeserializer<T> extends JsonDeserializer<T> {
    protected final Class<?> _valueClass;

    /* loaded from: classes2.dex */
    public static final class AtomicBooleanDeserializer extends StdScalarDeserializer<AtomicBoolean> {
        public AtomicBooleanDeserializer() {
            super(AtomicBoolean.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public AtomicBoolean mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new AtomicBoolean(_parseBooleanPrimitive(jsonParser, deserializationContext));
        }
    }

    /* loaded from: classes2.dex */
    public static class AtomicReferenceDeserializer extends StdScalarDeserializer<AtomicReference<?>> implements ResolvableDeserializer {
        protected final BeanProperty _property;
        protected final JavaType _referencedType;
        protected JsonDeserializer<?> _valueDeserializer;

        public AtomicReferenceDeserializer(JavaType javaType, BeanProperty beanProperty) {
            super(AtomicReference.class);
            this._referencedType = javaType;
            this._property = beanProperty;
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public AtomicReference<?> mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new AtomicReference<>(this._valueDeserializer.mo22015deserialize(jsonParser, deserializationContext));
        }

        @Override // org.codehaus.jackson.map.ResolvableDeserializer
        public void resolve(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider) {
            this._valueDeserializer = deserializerProvider.findValueDeserializer(deserializationConfig, this._referencedType, this._property);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class BigDecimalDeserializer extends StdScalarDeserializer<BigDecimal> {
        public BigDecimalDeserializer() {
            super(BigDecimal.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public BigDecimal mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                return jsonParser.getDecimalValue();
            }
            if (currentToken != JsonToken.VALUE_STRING) {
                throw deserializationContext.mappingException(this._valueClass);
            }
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return new BigDecimal(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid representation");
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class BigIntegerDeserializer extends StdScalarDeserializer<BigInteger> {
        public BigIntegerDeserializer() {
            super(BigInteger.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public BigInteger mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                switch (jsonParser.getNumberType()) {
                    case INT:
                    case LONG:
                        return BigInteger.valueOf(jsonParser.getLongValue());
                }
            } else if (currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                return jsonParser.getDecimalValue().toBigInteger();
            } else {
                if (currentToken != JsonToken.VALUE_STRING) {
                    throw deserializationContext.mappingException(this._valueClass);
                }
            }
            String trim = jsonParser.getText().trim();
            if (trim.length() == 0) {
                return null;
            }
            try {
                return new BigInteger(trim);
            } catch (IllegalArgumentException e) {
                throw deserializationContext.weirdStringException(this._valueClass, "not a valid representation");
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class BooleanDeserializer extends PrimitiveOrWrapperDeserializer<Boolean> {
        public BooleanDeserializer(Class<Boolean> cls, Boolean bool) {
            super(cls, bool);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Boolean mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return _parseBoolean(jsonParser, deserializationContext);
        }

        @Override // org.codehaus.jackson.map.deser.StdScalarDeserializer, org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserializeWithType */
        public Boolean mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return _parseBoolean(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class ByteDeserializer extends PrimitiveOrWrapperDeserializer<Byte> {
        public ByteDeserializer(Class<Byte> cls, Byte b) {
            super(cls, b);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Byte mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
            if (_parseIntPrimitive < -128 || _parseIntPrimitive > 127) {
                throw deserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 8-bit value");
            }
            return Byte.valueOf((byte) _parseIntPrimitive);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class CalendarDeserializer extends StdScalarDeserializer<Calendar> {
        Class<? extends Calendar> _calendarClass;

        public CalendarDeserializer() {
            this(null);
        }

        public CalendarDeserializer(Class<? extends Calendar> cls) {
            super(Calendar.class);
            this._calendarClass = cls;
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public Calendar mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (_parseDate == null) {
                return null;
            }
            if (this._calendarClass == null) {
                return deserializationContext.constructCalendar(_parseDate);
            }
            try {
                Calendar newInstance = this._calendarClass.newInstance();
                newInstance.setTimeInMillis(_parseDate.getTime());
                return newInstance;
            } catch (Exception e) {
                throw deserializationContext.instantiationException(this._calendarClass, e);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class CharacterDeserializer extends PrimitiveOrWrapperDeserializer<Character> {
        public CharacterDeserializer(Class<Character> cls, Character ch) {
            super(cls, ch);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Character mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                int intValue = jsonParser.getIntValue();
                if (intValue >= 0 && intValue <= 65535) {
                    return Character.valueOf((char) intValue);
                }
            } else if (currentToken == JsonToken.VALUE_STRING) {
                String text = jsonParser.getText();
                if (text.length() == 1) {
                    return Character.valueOf(text.charAt(0));
                }
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class ClassDeserializer extends StdScalarDeserializer<Class<?>> {
        public ClassDeserializer() {
            super(Class.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Class<?> mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = jsonParser.getText();
                if (text.indexOf(46) < 0) {
                    if ("int".equals(text)) {
                        return Integer.TYPE;
                    }
                    if ("long".equals(text)) {
                        return Long.TYPE;
                    }
                    if ("float".equals(text)) {
                        return Float.TYPE;
                    }
                    if ("double".equals(text)) {
                        return Double.TYPE;
                    }
                    if ("boolean".equals(text)) {
                        return Boolean.TYPE;
                    }
                    if ("byte".equals(text)) {
                        return Byte.TYPE;
                    }
                    if ("char".equals(text)) {
                        return Character.TYPE;
                    }
                    if ("short".equals(text)) {
                        return Short.TYPE;
                    }
                    if ("void".equals(text)) {
                        return Void.TYPE;
                    }
                }
                try {
                    return Class.forName(jsonParser.getText());
                } catch (ClassNotFoundException e) {
                    throw deserializationContext.instantiationException(this._valueClass, e);
                }
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class DoubleDeserializer extends PrimitiveOrWrapperDeserializer<Double> {
        public DoubleDeserializer(Class<Double> cls, Double d) {
            super(cls, d);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Double mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return _parseDouble(jsonParser, deserializationContext);
        }

        @Override // org.codehaus.jackson.map.deser.StdScalarDeserializer, org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserializeWithType */
        public Double mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return _parseDouble(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class FloatDeserializer extends PrimitiveOrWrapperDeserializer<Float> {
        public FloatDeserializer(Class<Float> cls, Float f) {
            super(cls, f);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Float mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return _parseFloat(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class IntegerDeserializer extends PrimitiveOrWrapperDeserializer<Integer> {
        public IntegerDeserializer(Class<Integer> cls, Integer num) {
            super(cls, num);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Integer mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return _parseInteger(jsonParser, deserializationContext);
        }

        @Override // org.codehaus.jackson.map.deser.StdScalarDeserializer, org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserializeWithType */
        public Integer mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return _parseInteger(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class LongDeserializer extends PrimitiveOrWrapperDeserializer<Long> {
        public LongDeserializer(Class<Long> cls, Long l) {
            super(cls, l);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Long mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return _parseLong(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class NumberDeserializer extends StdScalarDeserializer<Number> {
        public NumberDeserializer() {
            super(Number.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize */
        public Number mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Number valueOf;
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                return deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS) ? jsonParser.getBigIntegerValue() : jsonParser.getNumberValue();
            } else if (currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
                return deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS) ? jsonParser.getDecimalValue() : Double.valueOf(jsonParser.getDoubleValue());
            } else if (currentToken != JsonToken.VALUE_STRING) {
                throw deserializationContext.mappingException(this._valueClass);
            } else {
                String trim = jsonParser.getText().trim();
                try {
                    if (trim.indexOf(46) >= 0) {
                        valueOf = deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS) ? new BigDecimal(trim) : new Double(trim);
                    } else if (deserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
                        valueOf = new BigInteger(trim);
                    } else {
                        long parseLong = Long.parseLong(trim);
                        valueOf = (parseLong > 2147483647L || parseLong < -2147483648L) ? Long.valueOf(parseLong) : Integer.valueOf((int) parseLong);
                    }
                    return valueOf;
                } catch (IllegalArgumentException e) {
                    throw deserializationContext.weirdStringException(this._valueClass, "not a valid number");
                }
            }
        }

        @Override // org.codehaus.jackson.map.deser.StdScalarDeserializer, org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserializeWithType */
        public Object mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            switch (jsonParser.getCurrentToken()) {
                case VALUE_NUMBER_INT:
                case VALUE_NUMBER_FLOAT:
                case VALUE_STRING:
                    return mo22015deserialize(jsonParser, deserializationContext);
                default:
                    return typeDeserializer.deserializeTypedFromScalar(jsonParser, deserializationContext);
            }
        }
    }

    /* loaded from: classes2.dex */
    protected static abstract class PrimitiveOrWrapperDeserializer<T> extends StdScalarDeserializer<T> {
        final T _nullValue;

        protected PrimitiveOrWrapperDeserializer(Class<T> cls, T t) {
            super(cls);
            this._nullValue = t;
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        public final T getNullValue() {
            return this._nullValue;
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class ShortDeserializer extends PrimitiveOrWrapperDeserializer<Short> {
        public ShortDeserializer(Class<Short> cls, Short sh) {
            super(cls, sh);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public Short mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return _parseShort(jsonParser, deserializationContext);
        }
    }

    /* loaded from: classes2.dex */
    public static class SqlDateDeserializer extends StdScalarDeserializer<java.sql.Date> {
        public SqlDateDeserializer() {
            super(java.sql.Date.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public java.sql.Date mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            Date _parseDate = _parseDate(jsonParser, deserializationContext);
            if (_parseDate == null) {
                return null;
            }
            return new java.sql.Date(_parseDate.getTime());
        }
    }

    /* loaded from: classes2.dex */
    public static class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
        public StackTraceElementDeserializer() {
            super(StackTraceElement.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public StackTraceElement mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
                String str = "";
                String str2 = "";
                String str3 = "";
                int i = -1;
                while (true) {
                    JsonToken nextValue = jsonParser.nextValue();
                    if (nextValue == JsonToken.END_OBJECT) {
                        return new StackTraceElement(str, str2, str3, i);
                    }
                    String currentName = jsonParser.getCurrentName();
                    if ("className".equals(currentName)) {
                        str = jsonParser.getText();
                    } else if ("fileName".equals(currentName)) {
                        str3 = jsonParser.getText();
                    } else if ("lineNumber".equals(currentName)) {
                        if (!nextValue.isNumeric()) {
                            throw JsonMappingException.from(jsonParser, "Non-numeric token (" + nextValue + ") for property 'lineNumber'");
                        }
                        i = jsonParser.getIntValue();
                    } else if ("methodName".equals(currentName)) {
                        str2 = jsonParser.getText();
                    } else if (!"nativeMethod".equals(currentName)) {
                        handleUnknownProperty(jsonParser, deserializationContext, this._valueClass, currentName);
                    }
                }
            } else {
                throw deserializationContext.mappingException(this._valueClass);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static final class StringDeserializer extends StdScalarDeserializer<String> {
        public StringDeserializer() {
            super(String.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public String mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_STRING) {
                return jsonParser.getText();
            }
            if (currentToken != JsonToken.VALUE_EMBEDDED_OBJECT) {
                if (!currentToken.isScalarValue()) {
                    throw deserializationContext.mappingException(this._valueClass);
                }
                return jsonParser.getText();
            }
            Object embeddedObject = jsonParser.getEmbeddedObject();
            if (embeddedObject == null) {
                return null;
            }
            return embeddedObject instanceof byte[] ? Base64Variants.getDefaultVariant().encode((byte[]) embeddedObject, false) : embeddedObject.toString();
        }

        @Override // org.codehaus.jackson.map.deser.StdScalarDeserializer, org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserializeWithType  reason: collision with other method in class */
        public String mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
            return mo22015deserialize(jsonParser, deserializationContext);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class TokenBufferDeserializer extends StdScalarDeserializer<TokenBuffer> {
        public TokenBufferDeserializer() {
            super(TokenBuffer.class);
        }

        @Override // org.codehaus.jackson.map.JsonDeserializer
        /* renamed from: deserialize  reason: collision with other method in class */
        public TokenBuffer mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            TokenBuffer tokenBuffer = new TokenBuffer(jsonParser.getCodec());
            tokenBuffer.copyCurrentStructure(jsonParser);
            return tokenBuffer;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StdDeserializer(Class<?> cls) {
        this._valueClass = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StdDeserializer(JavaType javaType) {
        this._valueClass = javaType == null ? null : javaType.getRawClass();
    }

    protected static final double parseDouble(String str) {
        if (NumberInput.NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_NORMAL;
        }
        return Double.parseDouble(str);
    }

    protected final Boolean _parseBoolean(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (currentToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT) {
            return jsonParser.getIntValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
        } else if (currentToken != JsonToken.VALUE_STRING) {
            throw deserializationContext.mappingException(this._valueClass);
        } else {
            String trim = jsonParser.getText().trim();
            if ("true".equals(trim)) {
                return Boolean.TRUE;
            }
            if (!"false".equals(trim) && trim.length() != 0) {
                throw deserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean _parseBooleanPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_TRUE) {
            return true;
        }
        if (currentToken != JsonToken.VALUE_FALSE && currentToken != JsonToken.VALUE_NULL) {
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                return jsonParser.getIntValue() != 0;
            } else if (currentToken != JsonToken.VALUE_STRING) {
                throw deserializationContext.mappingException(this._valueClass);
            } else {
                String trim = jsonParser.getText().trim();
                if ("true".equals(trim)) {
                    return true;
                }
                if (!"false".equals(trim) && trim.length() != 0) {
                    throw deserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
                }
                return Boolean.FALSE.booleanValue();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Date _parseDate(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        try {
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                return new Date(jsonParser.getLongValue());
            }
            if (currentToken != JsonToken.VALUE_STRING) {
                throw deserializationContext.mappingException(this._valueClass);
            }
            String trim = jsonParser.getText().trim();
            if (trim.length() != 0) {
                return deserializationContext.parseDate(trim);
            }
            return null;
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid representation (error: " + e.getMessage() + ")");
        }
    }

    protected final Double _parseDouble(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Double.valueOf(jsonParser.getDoubleValue());
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return null;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return null;
        }
        switch (trim.charAt(0)) {
            case '-':
                if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                    return Double.valueOf(Double.NEGATIVE_INFINITY);
                }
                break;
            case 'I':
                if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Double.valueOf(Double.POSITIVE_INFINITY);
                }
                break;
            case 'N':
                if ("NaN".equals(trim)) {
                    return Double.valueOf(Double.NaN);
                }
                break;
        }
        try {
            return Double.valueOf(parseDouble(trim));
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid Double value");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final double _parseDoublePrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getDoubleValue();
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return 0.0d;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return 0.0d;
        }
        switch (trim.charAt(0)) {
            case '-':
                if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                    return Double.NEGATIVE_INFINITY;
                }
                break;
            case 'I':
                if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Double.POSITIVE_INFINITY;
                }
                break;
            case 'N':
                if ("NaN".equals(trim)) {
                    return Double.NaN;
                }
                break;
        }
        try {
            return parseDouble(trim);
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid double value");
        }
    }

    protected final Float _parseFloat(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Float.valueOf(jsonParser.getFloatValue());
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return null;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return null;
        }
        switch (trim.charAt(0)) {
            case '-':
                if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                    return Float.valueOf(Float.NEGATIVE_INFINITY);
                }
                break;
            case 'I':
                if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Float.valueOf(Float.POSITIVE_INFINITY);
                }
                break;
            case 'N':
                if ("NaN".equals(trim)) {
                    return Float.valueOf(Float.NaN);
                }
                break;
        }
        try {
            return Float.valueOf(Float.parseFloat(trim));
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid Float value");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float _parseFloatPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getFloatValue();
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return 0.0f;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return 0.0f;
        }
        switch (trim.charAt(0)) {
            case '-':
                if ("-Infinity".equals(trim) || "-INF".equals(trim)) {
                    return Float.NEGATIVE_INFINITY;
                }
                break;
            case 'I':
                if ("Infinity".equals(trim) || "INF".equals(trim)) {
                    return Float.POSITIVE_INFINITY;
                }
                break;
            case 'N':
                if ("NaN".equals(trim)) {
                    return Float.NaN;
                }
                break;
        }
        try {
            return Float.parseFloat(trim);
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid float value");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int _parseIntPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getIntValue();
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return 0;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        try {
            int length = trim.length();
            if (length <= 9) {
                if (length == 0) {
                    return 0;
                }
                return NumberInput.parseInt(trim);
            }
            long parseLong = Long.parseLong(trim);
            if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                return (int) parseLong;
            }
            throw deserializationContext.weirdStringException(this._valueClass, "Overflow: numeric value (" + trim + ") out of range of int (-2147483648 - 2147483647)");
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid int value");
        }
    }

    protected final Integer _parseInteger(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Integer.valueOf(jsonParser.getIntValue());
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return null;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        try {
            int length = trim.length();
            if (length <= 9) {
                if (length == 0) {
                    return null;
                }
                return Integer.valueOf(NumberInput.parseInt(trim));
            }
            long parseLong = Long.parseLong(trim);
            if (parseLong >= -2147483648L && parseLong <= 2147483647L) {
                return Integer.valueOf((int) parseLong);
            }
            throw deserializationContext.weirdStringException(this._valueClass, "Overflow: numeric value (" + trim + ") out of range of Integer (-2147483648 - 2147483647)");
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid Integer value");
        }
    }

    protected final Long _parseLong(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Long.valueOf(jsonParser.getLongValue());
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return null;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return null;
        }
        try {
            return Long.valueOf(NumberInput.parseLong(trim));
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid Long value");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long _parseLongPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return jsonParser.getLongValue();
        }
        if (currentToken != JsonToken.VALUE_STRING) {
            if (currentToken == JsonToken.VALUE_NULL) {
                return 0L;
            }
            throw deserializationContext.mappingException(this._valueClass);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return 0L;
        }
        try {
            return NumberInput.parseLong(trim);
        } catch (IllegalArgumentException e) {
            throw deserializationContext.weirdStringException(this._valueClass, "not a valid long value");
        }
    }

    protected final Short _parseShort(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.VALUE_NULL) {
            return null;
        }
        if (currentToken == JsonToken.VALUE_NUMBER_INT || currentToken == JsonToken.VALUE_NUMBER_FLOAT) {
            return Short.valueOf(jsonParser.getShortValue());
        }
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_parseIntPrimitive >= -32768 && _parseIntPrimitive <= 32767) {
            return Short.valueOf((short) _parseIntPrimitive);
        }
        throw deserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final short _parseShortPrimitive(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int _parseIntPrimitive = _parseIntPrimitive(jsonParser, deserializationContext);
        if (_parseIntPrimitive < -32768 || _parseIntPrimitive > 32767) {
            throw deserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
        }
        return (short) _parseIntPrimitive;
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserializeWithType */
    public Object mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JsonDeserializer<Object> findDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty) {
        return deserializerProvider.findValueDeserializer(deserializationConfig, javaType, beanProperty);
    }

    public Class<?> getValueClass() {
        return this._valueClass;
    }

    public JavaType getValueType() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleUnknownProperty(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) {
        if (obj == null) {
            obj = getValueClass();
        }
        if (deserializationContext.handleUnknownProperty(jsonParser, this, obj, str)) {
            return;
        }
        reportUnknownProperty(deserializationContext, obj, str);
        jsonParser.skipChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDefaultSerializer(JsonDeserializer<?> jsonDeserializer) {
        return (jsonDeserializer == null || jsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) == null) ? false : true;
    }

    protected void reportUnknownProperty(DeserializationContext deserializationContext, Object obj, String str) {
        if (deserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw deserializationContext.unknownFieldException(obj, str);
        }
    }
}
