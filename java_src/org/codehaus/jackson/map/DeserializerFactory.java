package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes.dex */
public abstract class DeserializerFactory {
    protected static final Deserializers[] NO_DESERIALIZERS = new Deserializers[0];

    /* loaded from: classes2.dex */
    public static abstract class Config {
        public abstract Iterable<AbstractTypeResolver> abstractTypeResolvers();

        public abstract Iterable<BeanDeserializerModifier> deserializerModifiers();

        public abstract Iterable<Deserializers> deserializers();

        public abstract boolean hasAbstractTypeResolvers();

        public abstract boolean hasDeserializerModifiers();

        public abstract boolean hasDeserializers();

        public abstract boolean hasKeyDeserializers();

        public abstract Iterable<KeyDeserializers> keyDeserializers();

        public abstract Config withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver);

        public abstract Config withAdditionalDeserializers(Deserializers deserializers);

        public abstract Config withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers);

        public abstract Config withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier);
    }

    public abstract JsonDeserializer<?> createArrayDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, ArrayType arrayType, BeanProperty beanProperty);

    @Deprecated
    public final JsonDeserializer<?> createArrayDeserializer(DeserializationConfig deserializationConfig, ArrayType arrayType, DeserializerProvider deserializerProvider) {
        return createArrayDeserializer(deserializationConfig, deserializerProvider, arrayType, null);
    }

    public abstract JsonDeserializer<Object> createBeanDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty);

    @Deprecated
    public final JsonDeserializer<Object> createBeanDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, DeserializerProvider deserializerProvider) {
        return createBeanDeserializer(deserializationConfig, deserializerProvider, javaType, null);
    }

    public abstract JsonDeserializer<?> createCollectionDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, CollectionType collectionType, BeanProperty beanProperty);

    @Deprecated
    public final JsonDeserializer<?> createCollectionDeserializer(DeserializationConfig deserializationConfig, CollectionType collectionType, DeserializerProvider deserializerProvider) {
        return createCollectionDeserializer(deserializationConfig, deserializerProvider, collectionType, null);
    }

    public abstract JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, CollectionLikeType collectionLikeType, BeanProperty beanProperty);

    @Deprecated
    public final JsonDeserializer<?> createEnumDeserializer(DeserializationConfig deserializationConfig, Class<?> cls, DeserializerProvider deserializerProvider) {
        return createEnumDeserializer(deserializationConfig, deserializerProvider, TypeFactory.type(cls), null);
    }

    public abstract JsonDeserializer<?> createEnumDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty);

    public KeyDeserializer createKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) {
        return null;
    }

    public abstract JsonDeserializer<?> createMapDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, MapType mapType, BeanProperty beanProperty);

    @Deprecated
    public final JsonDeserializer<?> createMapDeserializer(DeserializationConfig deserializationConfig, MapType mapType, DeserializerProvider deserializerProvider) {
        return createMapDeserializer(deserializationConfig, deserializerProvider, mapType, null);
    }

    public abstract JsonDeserializer<?> createMapLikeDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, MapLikeType mapLikeType, BeanProperty beanProperty);

    @Deprecated
    public final JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, Class<? extends JsonNode> cls, DeserializerProvider deserializerProvider) {
        return createTreeDeserializer(deserializationConfig, deserializerProvider, TypeFactory.type(cls), null);
    }

    public abstract JsonDeserializer<?> createTreeDeserializer(DeserializationConfig deserializationConfig, DeserializerProvider deserializerProvider, JavaType javaType, BeanProperty beanProperty);

    @Deprecated
    public final TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) {
        return findTypeDeserializer(deserializationConfig, javaType, null);
    }

    public TypeDeserializer findTypeDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, BeanProperty beanProperty) {
        return null;
    }

    public abstract Config getConfig();

    public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver) {
        return withConfig(getConfig().withAbstractTypeResolver(abstractTypeResolver));
    }

    public final DeserializerFactory withAdditionalDeserializers(Deserializers deserializers) {
        return withConfig(getConfig().withAdditionalDeserializers(deserializers));
    }

    public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers keyDeserializers) {
        return withConfig(getConfig().withAdditionalKeyDeserializers(keyDeserializers));
    }

    public abstract DeserializerFactory withConfig(Config config);

    public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier) {
        return withConfig(getConfig().withDeserializerModifier(beanDeserializerModifier));
    }
}
