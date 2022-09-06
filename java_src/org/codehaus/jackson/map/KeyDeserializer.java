package org.codehaus.jackson.map;
/* loaded from: classes.dex */
public abstract class KeyDeserializer {

    /* loaded from: classes.dex */
    public static abstract class None extends KeyDeserializer {
    }

    public abstract Object deserializeKey(String str, DeserializationContext deserializationContext);
}
