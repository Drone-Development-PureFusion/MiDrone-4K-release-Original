package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.deser.StdKeyDeserializer;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
class StdKeyDeserializers {
    final HashMap<JavaType, KeyDeserializer> _keyDeserializers = new HashMap<>();

    private StdKeyDeserializers() {
        add(new StdKeyDeserializer.BoolKD());
        add(new StdKeyDeserializer.ByteKD());
        add(new StdKeyDeserializer.CharKD());
        add(new StdKeyDeserializer.ShortKD());
        add(new StdKeyDeserializer.IntKD());
        add(new StdKeyDeserializer.LongKD());
        add(new StdKeyDeserializer.FloatKD());
        add(new StdKeyDeserializer.DoubleKD());
    }

    private void add(StdKeyDeserializer stdKeyDeserializer) {
        this._keyDeserializers.put(TypeFactory.defaultInstance().constructType(stdKeyDeserializer.getKeyClass()), stdKeyDeserializer);
    }

    public static HashMap<JavaType, KeyDeserializer> constructAll() {
        return new StdKeyDeserializers()._keyDeserializers;
    }

    public static KeyDeserializer constructEnumKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) {
        return new StdKeyDeserializer.EnumKD(EnumResolver.constructUnsafe(javaType.getRawClass(), deserializationConfig.getAnnotationIntrospector()));
    }

    public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) {
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) deserializationConfig.introspect(javaType);
        Constructor<?> findSingleArgConstructor = basicBeanDescription.findSingleArgConstructor(String.class);
        if (findSingleArgConstructor != null) {
            return new StdKeyDeserializer.StringCtorKeyDeserializer(findSingleArgConstructor);
        }
        Method findFactoryMethod = basicBeanDescription.findFactoryMethod(String.class);
        if (findFactoryMethod == null) {
            return null;
        }
        return new StdKeyDeserializer.StringFactoryKeyDeserializer(findFactoryMethod);
    }
}
