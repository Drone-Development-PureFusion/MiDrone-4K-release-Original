package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.map.TypeSerializer;
/* loaded from: classes2.dex */
public abstract class ContainerSerializerBase<T> extends SerializerBase<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ContainerSerializerBase(Class<T> cls) {
        super(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ContainerSerializerBase(Class<?> cls, boolean z) {
        super(cls, z);
    }

    public abstract ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer);

    /* JADX WARN: Multi-variable type inference failed */
    public ContainerSerializerBase<?> withValueTypeSerializer(TypeSerializer typeSerializer) {
        return typeSerializer == null ? this : _withValueTypeSerializer(typeSerializer);
    }
}
