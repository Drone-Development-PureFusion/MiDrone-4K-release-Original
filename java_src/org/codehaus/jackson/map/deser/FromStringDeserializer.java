package org.codehaus.jackson.map.deser;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
/* loaded from: classes2.dex */
public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {

    /* loaded from: classes2.dex */
    public static class CurrencyDeserializer extends FromStringDeserializer<Currency> {
        public CurrencyDeserializer() {
            super(Currency.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public Currency mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return Currency.getInstance(str);
        }
    }

    /* loaded from: classes2.dex */
    protected static class InetAddressDeserializer extends FromStringDeserializer<InetAddress> {
        public InetAddressDeserializer() {
            super(InetAddress.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public InetAddress mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return InetAddress.getByName(str);
        }
    }

    /* loaded from: classes2.dex */
    protected static class LocaleDeserializer extends FromStringDeserializer<Locale> {
        public LocaleDeserializer() {
            super(Locale.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public Locale mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            int indexOf = str.indexOf(95);
            if (indexOf < 0) {
                return new Locale(str);
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf(95);
            return indexOf2 < 0 ? new Locale(substring, substring2) : new Locale(substring, substring2.substring(0, indexOf2), substring2.substring(indexOf2 + 1));
        }
    }

    /* loaded from: classes2.dex */
    public static class PatternDeserializer extends FromStringDeserializer<Pattern> {
        public PatternDeserializer() {
            super(Pattern.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public Pattern mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return Pattern.compile(str);
        }
    }

    /* loaded from: classes2.dex */
    protected static class TimeZoneDeserializer extends FromStringDeserializer<TimeZone> {
        public TimeZoneDeserializer() {
            super(TimeZone.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public TimeZone mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return TimeZone.getTimeZone(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class URIDeserializer extends FromStringDeserializer<URI> {
        public URIDeserializer() {
            super(URI.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public URI mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return URI.create(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class URLDeserializer extends FromStringDeserializer<URL> {
        public URLDeserializer() {
            super(URL.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public URL mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return new URL(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class UUIDDeserializer extends FromStringDeserializer<UUID> {
        public UUIDDeserializer() {
            super(UUID.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: avoid collision after fix types in other method */
        public UUID mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return UUID.fromString(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
        public UUID _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) {
            if (!(obj instanceof byte[])) {
                super._deserializeEmbedded(obj, deserializationContext);
                return null;
            }
            byte[] bArr = (byte[]) obj;
            if (bArr.length != 16) {
                deserializationContext.mappingException("Can only construct UUIDs from 16 byte arrays; got " + bArr.length + " bytes");
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            return new UUID(dataInputStream.readLong(), dataInputStream.readLong());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FromStringDeserializer(Class<?> cls) {
        super(cls);
    }

    public static Iterable<FromStringDeserializer<?>> all() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UUIDDeserializer());
        arrayList.add(new URLDeserializer());
        arrayList.add(new URIDeserializer());
        arrayList.add(new CurrencyDeserializer());
        arrayList.add(new PatternDeserializer());
        arrayList.add(new LocaleDeserializer());
        arrayList.add(new InetAddressDeserializer());
        arrayList.add(new TimeZoneDeserializer());
        return arrayList;
    }

    /* renamed from: _deserialize */
    protected abstract T mo21968_deserialize(String str, DeserializationContext deserializationContext);

    protected T _deserializeEmbedded(Object obj, DeserializationContext deserializationContext) {
        throw deserializationContext.mappingException("Don't know how to convert embedded Object of type " + obj.getClass().getName() + " into " + this._valueClass.getName());
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize */
    public final T mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        if (jsonParser.getCurrentToken() != JsonToken.VALUE_STRING) {
            if (jsonParser.getCurrentToken() != JsonToken.VALUE_EMBEDDED_OBJECT) {
                throw deserializationContext.mappingException(this._valueClass);
            }
            T t = (T) jsonParser.getEmbeddedObject();
            if (t == null) {
                return null;
            }
            return this._valueClass.isAssignableFrom(t.getClass()) ? t : _deserializeEmbedded(t, deserializationContext);
        }
        String trim = jsonParser.getText().trim();
        if (trim.length() == 0) {
            return null;
        }
        try {
            T mo21968_deserialize = mo21968_deserialize(trim, deserializationContext);
            if (mo21968_deserialize != null) {
                return mo21968_deserialize;
            }
        } catch (IllegalArgumentException e) {
        }
        throw deserializationContext.weirdStringException(this._valueClass, "not a valid textual representation");
    }
}
