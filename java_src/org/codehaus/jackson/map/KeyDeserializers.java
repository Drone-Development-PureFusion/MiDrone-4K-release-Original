package org.codehaus.jackson.map;

import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public interface KeyDeserializers {
    KeyDeserializer findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription, BeanProperty beanProperty);
}
