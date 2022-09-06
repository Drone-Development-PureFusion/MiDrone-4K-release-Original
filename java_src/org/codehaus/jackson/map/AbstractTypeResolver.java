package org.codehaus.jackson.map;

import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public abstract class AbstractTypeResolver {
    public JavaType findTypeMapping(DeserializationConfig deserializationConfig, JavaType javaType) {
        return null;
    }

    public JavaType resolveAbstractType(DeserializationConfig deserializationConfig, JavaType javaType) {
        return null;
    }
}
