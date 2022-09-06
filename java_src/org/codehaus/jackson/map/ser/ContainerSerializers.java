package org.codehaus.jackson.map.ser;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public final class ContainerSerializers {

    /* loaded from: classes.dex */
    public static abstract class AsArraySerializer<T> extends ContainerSerializerBase<T> implements ResolvableSerializer {
        protected PropertySerializerMap _dynamicSerializers;
        protected JsonSerializer<Object> _elementSerializer;
        protected final JavaType _elementType;
        protected final BeanProperty _property;
        protected final boolean _staticTyping;
        protected final TypeSerializer _valueTypeSerializer;

        @Deprecated
        protected AsArraySerializer(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            this(cls, javaType, z, typeSerializer, beanProperty, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        protected AsArraySerializer(Class<?> cls, JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
            super(cls, false);
            boolean z2 = false;
            this._elementType = javaType;
            if (z || (javaType != null && javaType.isFinal())) {
                z2 = true;
            }
            this._staticTyping = z2;
            this._valueTypeSerializer = typeSerializer;
            this._property = beanProperty;
            this._elementSerializer = jsonSerializer;
            this._dynamicSerializers = PropertySerializerMap.emptyMap();
        }

        protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) {
            PropertySerializerMap.SerializerAndMapResult findAndAddSerializer = propertySerializerMap.findAndAddSerializer(cls, serializerProvider, this._property);
            if (propertySerializerMap != findAndAddSerializer.map) {
                this._dynamicSerializers = findAndAddSerializer.map;
            }
            return findAndAddSerializer.serializer;
        }

        protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, JavaType javaType, SerializerProvider serializerProvider) {
            PropertySerializerMap.SerializerAndMapResult findAndAddSerializer = propertySerializerMap.findAndAddSerializer(javaType, serializerProvider, this._property);
            if (propertySerializerMap != findAndAddSerializer.map) {
                this._dynamicSerializers = findAndAddSerializer.map;
            }
            return findAndAddSerializer.serializer;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
            JavaType javaType;
            JsonNode jsonNode;
            ObjectNode createSchemaNode = createSchemaNode("array", true);
            if (type != null) {
                javaType = serializerProvider.constructType(type).getContentType();
                if (javaType == null && (type instanceof ParameterizedType)) {
                    Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                    if (actualTypeArguments.length == 1) {
                        javaType = serializerProvider.constructType(actualTypeArguments[0]);
                    }
                }
            } else {
                javaType = null;
            }
            if (javaType == null && this._elementType != null) {
                javaType = this._elementType;
            }
            if (javaType != null) {
                if (javaType.getRawClass() != Object.class) {
                    JsonSerializer<Object> findValueSerializer = serializerProvider.findValueSerializer(javaType, this._property);
                    if (findValueSerializer instanceof SchemaAware) {
                        jsonNode = ((SchemaAware) findValueSerializer).getSchema(serializerProvider, null);
                        if (jsonNode == null) {
                            jsonNode = JsonSchema.getDefaultSchemaNode();
                        }
                        createSchemaNode.put("items", jsonNode);
                    }
                }
                jsonNode = null;
                if (jsonNode == null) {
                }
                createSchemaNode.put("items", jsonNode);
            }
            return createSchemaNode;
        }

        @Override // org.codehaus.jackson.map.ResolvableSerializer
        public void resolve(SerializerProvider serializerProvider) {
            if (!this._staticTyping || this._elementType == null || this._elementSerializer != null) {
                return;
            }
            this._elementSerializer = serializerProvider.findValueSerializer(this._elementType, this._property);
        }

        @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
        public final void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.writeStartArray();
            serializeContents(t, jsonGenerator, serializerProvider);
            jsonGenerator.writeEndArray();
        }

        protected abstract void serializeContents(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider);

        @Override // org.codehaus.jackson.map.JsonSerializer
        public final void serializeWithType(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
            typeSerializer.writeTypePrefixForArray(t, jsonGenerator);
            serializeContents(t, jsonGenerator, serializerProvider);
            typeSerializer.writeTypeSuffixForArray(t, jsonGenerator);
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class CollectionSerializer extends AsArraySerializer<Collection<?>> {
        @Deprecated
        public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            this(javaType, z, typeSerializer, beanProperty, null);
        }

        public CollectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
            super(Collection.class, javaType, z, typeSerializer, beanProperty, jsonSerializer);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializerBase
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new CollectionSerializer(this._elementType, this._staticTyping, typeSerializer, this._property);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializers.AsArraySerializer
        public void serializeContents(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            if (this._elementSerializer != null) {
                serializeContentsUsing(collection, jsonGenerator, serializerProvider, this._elementSerializer);
                return;
            }
            Iterator<?> it2 = collection.iterator();
            if (!it2.hasNext()) {
                return;
            }
            PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            int i = 0;
            do {
                try {
                    Object next = it2.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class<?> cls = next.getClass();
                        JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                        if (serializerFor == null) {
                            JsonSerializer<Object> _findAndAddDynamic = this._elementType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap, this._elementType.forcedNarrowBy(cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            propertySerializerMap = this._dynamicSerializers;
                            serializerFor = _findAndAddDynamic;
                        }
                        if (typeSerializer == null) {
                            serializerFor.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            serializerFor.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                    i++;
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, e, collection, i);
                    return;
                }
            } while (it2.hasNext());
        }

        public void serializeContentsUsing(Collection<?> collection, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
            Iterator<?> it2 = collection.iterator();
            if (it2.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                int i = 0;
                do {
                    Object next = it2.next();
                    if (next == null) {
                        try {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } catch (Exception e) {
                            wrapAndThrow(serializerProvider, e, collection, i);
                        }
                    } else if (typeSerializer == null) {
                        jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                    } else {
                        jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                } while (it2.hasNext());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class EnumSetSerializer extends AsArraySerializer<EnumSet<? extends Enum<?>>> {
        public EnumSetSerializer(JavaType javaType, BeanProperty beanProperty) {
            super(EnumSet.class, javaType, true, null, beanProperty);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializerBase
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializers.AsArraySerializer
        public void serializeContents(EnumSet<? extends Enum<?>> enumSet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            JsonSerializer<Object> jsonSerializer = this._elementSerializer;
            Iterator it2 = enumSet.iterator();
            JsonSerializer<Object> jsonSerializer2 = jsonSerializer;
            while (it2.hasNext()) {
                Enum r0 = (Enum) it2.next();
                if (jsonSerializer2 == null) {
                    jsonSerializer2 = serializerProvider.findValueSerializer(r0.getDeclaringClass(), this._property);
                }
                jsonSerializer2.serialize(r0, jsonGenerator, serializerProvider);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class IndexedListSerializer extends AsArraySerializer<List<?>> {
        public IndexedListSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
            super(List.class, javaType, z, typeSerializer, beanProperty, jsonSerializer);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializerBase
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new IndexedListSerializer(this._elementType, this._staticTyping, typeSerializer, this._property, this._elementSerializer);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializers.AsArraySerializer
        public void serializeContents(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            if (this._elementSerializer != null) {
                serializeContentsUsing(list, jsonGenerator, serializerProvider, this._elementSerializer);
            } else if (this._valueTypeSerializer != null) {
                serializeTypedContents(list, jsonGenerator, serializerProvider);
            } else {
                int size = list.size();
                if (size == 0) {
                    return;
                }
                int i = 0;
                try {
                    PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                    while (i < size) {
                        Object obj = list.get(i);
                        if (obj == null) {
                            serializerProvider.defaultSerializeNull(jsonGenerator);
                        } else {
                            Class<?> cls = obj.getClass();
                            JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                            if (serializerFor == null) {
                                JsonSerializer<Object> _findAndAddDynamic = this._elementType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap, this._elementType.forcedNarrowBy(cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                                propertySerializerMap = this._dynamicSerializers;
                                serializerFor = _findAndAddDynamic;
                            }
                            serializerFor.serialize(obj, jsonGenerator, serializerProvider);
                        }
                        i++;
                    }
                } catch (Exception e) {
                    wrapAndThrow(serializerProvider, e, list, i);
                }
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0021 -> B:11:0x0016). Please submit an issue!!! */
        public void serializeContentsUsing(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer<Object> jsonSerializer) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            int i = 0;
            while (i < size) {
                Object obj = list.get(i);
                if (obj == null) {
                    try {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } catch (Exception e) {
                        wrapAndThrow(serializerProvider, e, list, i);
                    }
                } else if (typeSerializer == null) {
                    jsonSerializer.serialize(obj, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
                }
                i++;
            }
        }

        public void serializeTypedContents(List<?> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            int size = list.size();
            if (size == 0) {
                return;
            }
            int i = 0;
            try {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                while (i < size) {
                    Object obj = list.get(i);
                    if (obj == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class<?> cls = obj.getClass();
                        JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                        if (serializerFor == null) {
                            JsonSerializer<Object> _findAndAddDynamic = this._elementType.hasGenericTypes() ? _findAndAddDynamic(propertySerializerMap, this._elementType.forcedNarrowBy(cls), serializerProvider) : _findAndAddDynamic(propertySerializerMap, cls, serializerProvider);
                            propertySerializerMap = this._dynamicSerializers;
                            serializerFor = _findAndAddDynamic;
                        }
                        serializerFor.serializeWithType(obj, jsonGenerator, serializerProvider, typeSerializer);
                    }
                    i++;
                }
            } catch (Exception e) {
                wrapAndThrow(serializerProvider, e, list, i);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class IterableSerializer extends AsArraySerializer<Iterable<?>> {
        public IterableSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            super(Iterable.class, javaType, z, typeSerializer, beanProperty);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializerBase
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new IterableSerializer(this._elementType, this._staticTyping, typeSerializer, this._property);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializers.AsArraySerializer
        public void serializeContents(Iterable<?> iterable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            JsonSerializer<Object> jsonSerializer;
            Class<?> cls = null;
            Iterator<?> it2 = iterable.iterator();
            if (it2.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                JsonSerializer<Object> jsonSerializer2 = null;
                do {
                    Object next = it2.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class<?> cls2 = next.getClass();
                        if (cls2 == cls) {
                            jsonSerializer = jsonSerializer2;
                        } else {
                            jsonSerializer2 = serializerProvider.findValueSerializer(cls2, this._property);
                            cls = cls2;
                            jsonSerializer = jsonSerializer2;
                        }
                        if (typeSerializer == null) {
                            jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                } while (it2.hasNext());
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: classes.dex */
    public static class IteratorSerializer extends AsArraySerializer<Iterator<?>> {
        public IteratorSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
            super(Iterator.class, javaType, z, typeSerializer, beanProperty);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializerBase
        public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer) {
            return new IteratorSerializer(this._elementType, this._staticTyping, typeSerializer, this._property);
        }

        @Override // org.codehaus.jackson.map.ser.ContainerSerializers.AsArraySerializer
        public void serializeContents(Iterator<?> it2, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            JsonSerializer<Object> jsonSerializer;
            Class<?> cls = null;
            if (it2.hasNext()) {
                TypeSerializer typeSerializer = this._valueTypeSerializer;
                JsonSerializer<Object> jsonSerializer2 = null;
                do {
                    Object next = it2.next();
                    if (next == null) {
                        serializerProvider.defaultSerializeNull(jsonGenerator);
                    } else {
                        Class<?> cls2 = next.getClass();
                        if (cls2 == cls) {
                            jsonSerializer = jsonSerializer2;
                        } else {
                            jsonSerializer2 = serializerProvider.findValueSerializer(cls2, this._property);
                            cls = cls2;
                            jsonSerializer = jsonSerializer2;
                        }
                        if (typeSerializer == null) {
                            jsonSerializer.serialize(next, jsonGenerator, serializerProvider);
                        } else {
                            jsonSerializer.serializeWithType(next, jsonGenerator, serializerProvider, typeSerializer);
                        }
                    }
                } while (it2.hasNext());
            }
        }
    }

    private ContainerSerializers() {
    }

    public static ContainerSerializerBase<?> collectionSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        return new CollectionSerializer(javaType, z, typeSerializer, beanProperty, jsonSerializer);
    }

    public static JsonSerializer<?> enumSetSerializer(JavaType javaType, BeanProperty beanProperty) {
        return new EnumSetSerializer(javaType, beanProperty);
    }

    public static ContainerSerializerBase<?> indexedListSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty, JsonSerializer<Object> jsonSerializer) {
        return new IndexedListSerializer(javaType, z, typeSerializer, beanProperty, jsonSerializer);
    }

    public static ContainerSerializerBase<?> iterableSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        return new IterableSerializer(javaType, z, typeSerializer, beanProperty);
    }

    public static ContainerSerializerBase<?> iteratorSerializer(JavaType javaType, boolean z, TypeSerializer typeSerializer, BeanProperty beanProperty) {
        return new IteratorSerializer(javaType, z, typeSerializer, beanProperty);
    }
}
