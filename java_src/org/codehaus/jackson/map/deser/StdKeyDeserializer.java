package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.p316io.NumberInput;
/* loaded from: classes2.dex */
public abstract class StdKeyDeserializer extends KeyDeserializer {
    protected final Class<?> _keyClass;

    /* loaded from: classes2.dex */
    static final class BoolKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public BoolKD() {
            super(Boolean.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Boolean mo21963_parse(String str, DeserializationContext deserializationContext) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if (!"false".equals(str)) {
                throw deserializationContext.weirdKeyException(this._keyClass, str, "value not 'true' or 'false'");
            }
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes2.dex */
    static final class ByteKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ByteKD() {
            super(Byte.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Byte mo21963_parse(String str, DeserializationContext deserializationContext) {
            int _parseInt = _parseInt(str);
            if (_parseInt < -128 || _parseInt > 127) {
                throw deserializationContext.weirdKeyException(this._keyClass, str, "overflow, value can not be represented as 8-bit value");
            }
            return Byte.valueOf((byte) _parseInt);
        }
    }

    /* loaded from: classes2.dex */
    static final class CharKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CharKD() {
            super(Character.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Character mo21963_parse(String str, DeserializationContext deserializationContext) {
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "can only convert 1-character Strings");
        }
    }

    /* loaded from: classes2.dex */
    static final class DoubleKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public DoubleKD() {
            super(Double.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Double mo21963_parse(String str, DeserializationContext deserializationContext) {
            return Double.valueOf(_parseDouble(str));
        }
    }

    /* loaded from: classes2.dex */
    static final class EnumKD extends StdKeyDeserializer {
        final EnumResolver<?> _resolver;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EnumKD(EnumResolver<?> enumResolver) {
            super(enumResolver.getEnumClass());
            this._resolver = enumResolver;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Enum, java.lang.Enum<?>] */
        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Enum<?> mo21963_parse(String str, DeserializationContext deserializationContext) {
            ?? findEnum = this._resolver.findEnum(str);
            if (findEnum == 0) {
                throw deserializationContext.weirdKeyException(this._keyClass, str, "not one of values for Enum class");
            }
            return findEnum;
        }
    }

    /* loaded from: classes2.dex */
    static final class FloatKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public FloatKD() {
            super(Float.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Float mo21963_parse(String str, DeserializationContext deserializationContext) {
            return Float.valueOf((float) _parseDouble(str));
        }
    }

    /* loaded from: classes2.dex */
    static final class IntKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public IntKD() {
            super(Integer.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Integer mo21963_parse(String str, DeserializationContext deserializationContext) {
            return Integer.valueOf(_parseInt(str));
        }
    }

    /* loaded from: classes2.dex */
    static final class LongKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public LongKD() {
            super(Long.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Long mo21963_parse(String str, DeserializationContext deserializationContext) {
            return Long.valueOf(_parseLong(str));
        }
    }

    /* loaded from: classes2.dex */
    static final class ShortKD extends StdKeyDeserializer {
        /* JADX INFO: Access modifiers changed from: package-private */
        public ShortKD() {
            super(Integer.class);
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse  reason: collision with other method in class */
        public Short mo21963_parse(String str, DeserializationContext deserializationContext) {
            int _parseInt = _parseInt(str);
            if (_parseInt < -32768 || _parseInt > 32767) {
                throw deserializationContext.weirdKeyException(this._keyClass, str, "overflow, value can not be represented as 16-bit value");
            }
            return Short.valueOf((short) _parseInt);
        }
    }

    /* loaded from: classes2.dex */
    static final class StringCtorKeyDeserializer extends StdKeyDeserializer {
        final Constructor<?> _ctor;

        public StringCtorKeyDeserializer(Constructor<?> constructor) {
            super(constructor.getDeclaringClass());
            this._ctor = constructor;
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Object mo21963_parse(String str, DeserializationContext deserializationContext) {
            return this._ctor.newInstance(str);
        }
    }

    /* loaded from: classes2.dex */
    static final class StringFactoryKeyDeserializer extends StdKeyDeserializer {
        final Method _factoryMethod;

        public StringFactoryKeyDeserializer(Method method) {
            super(method.getDeclaringClass());
            this._factoryMethod = method;
        }

        @Override // org.codehaus.jackson.map.deser.StdKeyDeserializer
        /* renamed from: _parse */
        public Object mo21963_parse(String str, DeserializationContext deserializationContext) {
            return this._factoryMethod.invoke(null, str);
        }
    }

    protected StdKeyDeserializer(Class<?> cls) {
        this._keyClass = cls;
    }

    /* renamed from: _parse */
    protected abstract Object mo21963_parse(String str, DeserializationContext deserializationContext);

    protected double _parseDouble(String str) {
        return NumberInput.parseDouble(str);
    }

    protected int _parseInt(String str) {
        return Integer.parseInt(str);
    }

    protected long _parseLong(String str) {
        return Long.parseLong(str);
    }

    @Override // org.codehaus.jackson.map.KeyDeserializer
    public final Object deserializeKey(String str, DeserializationContext deserializationContext) {
        if (str == null) {
            return null;
        }
        try {
            Object mo21963_parse = mo21963_parse(str, deserializationContext);
            if (mo21963_parse != null) {
                return mo21963_parse;
            }
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation");
        } catch (Exception e) {
            throw deserializationContext.weirdKeyException(this._keyClass, str, "not a valid representation: " + e.getMessage());
        }
    }

    public Class<?> getKeyClass() {
        return this._keyClass;
    }
}
