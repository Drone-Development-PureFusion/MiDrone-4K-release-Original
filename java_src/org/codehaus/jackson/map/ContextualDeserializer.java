package org.codehaus.jackson.map;
/* loaded from: classes2.dex */
public interface ContextualDeserializer<T> {
    JsonDeserializer<T> createContextual(DeserializationConfig deserializationConfig, BeanProperty beanProperty);
}
