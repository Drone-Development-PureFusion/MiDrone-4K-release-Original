package org.codehaus.jackson.map;
/* loaded from: classes2.dex */
public interface ContextualSerializer<T> {
    JsonSerializer<T> createContextual(SerializationConfig serializationConfig, BeanProperty beanProperty);
}
