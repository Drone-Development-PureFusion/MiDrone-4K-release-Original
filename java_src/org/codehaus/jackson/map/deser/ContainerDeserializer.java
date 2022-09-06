package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public abstract class ContainerDeserializer<T> extends StdDeserializer<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ContainerDeserializer(Class<?> cls) {
        super(cls);
    }

    public abstract JsonDeserializer<Object> getContentDeserializer();

    public abstract JavaType getContentType();
}
