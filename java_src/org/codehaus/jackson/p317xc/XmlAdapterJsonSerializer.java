package org.codehaus.jackson.p317xc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
/* renamed from: org.codehaus.jackson.xc.XmlAdapterJsonSerializer */
/* loaded from: classes2.dex */
public class XmlAdapterJsonSerializer extends SerializerBase<Object> implements SchemaAware {
    private final BeanProperty _property;
    private final XmlAdapter<Object, Object> xmlAdapter;

    public XmlAdapterJsonSerializer(XmlAdapter<Object, Object> xmlAdapter, BeanProperty beanProperty) {
        super(Object.class);
        this.xmlAdapter = xmlAdapter;
        this._property = beanProperty;
    }

    private Class<?> findValueClass() {
        Type genericSuperclass = this.xmlAdapter.getClass().getGenericSuperclass();
        while ((genericSuperclass instanceof ParameterizedType) && XmlAdapter.class != ((ParameterizedType) genericSuperclass).getRawType()) {
            genericSuperclass = ((Class) ((ParameterizedType) genericSuperclass).getRawType()).getGenericSuperclass();
        }
        return (Class) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        JsonSerializer<Object> findValueSerializer = serializerProvider.findValueSerializer(findValueClass(), this._property);
        return findValueSerializer instanceof SchemaAware ? ((SchemaAware) findValueSerializer).getSchema(serializerProvider, null) : JsonSchema.getDefaultSchemaNode();
    }

    @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            Object marshal = this.xmlAdapter.marshal(obj);
            if (marshal == null) {
                serializerProvider.getNullValueSerializer().serialize(null, jsonGenerator, serializerProvider);
            } else {
                serializerProvider.findTypedValueSerializer(marshal.getClass(), true, this._property).serialize(marshal, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            throw new JsonMappingException("Unable to marshal: " + e.getMessage(), e);
        }
    }
}
