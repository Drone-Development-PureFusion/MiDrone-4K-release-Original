package org.codehaus.jackson.p317xc;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
/* renamed from: org.codehaus.jackson.xc.XmlAdapterJsonDeserializer */
/* loaded from: classes2.dex */
public class XmlAdapterJsonDeserializer extends StdDeserializer<Object> {
    protected static final JavaType ADAPTER_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(XmlAdapter.class);
    protected JsonDeserializer<?> _deserializer;
    protected final BeanProperty _property;
    protected final JavaType _valueType;
    protected final XmlAdapter<Object, Object> _xmlAdapter;

    public XmlAdapterJsonDeserializer(XmlAdapter<Object, Object> xmlAdapter, BeanProperty beanProperty) {
        super(Object.class);
        this._property = beanProperty;
        this._xmlAdapter = xmlAdapter;
        TypeFactory defaultInstance = TypeFactory.defaultInstance();
        JavaType[] findTypeParameters = defaultInstance.findTypeParameters(defaultInstance.constructType(xmlAdapter.getClass()), XmlAdapter.class);
        this._valueType = (findTypeParameters == null || findTypeParameters.length == 0) ? TypeFactory.unknownType() : findTypeParameters[0];
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize */
    public Object mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        JsonDeserializer<?> jsonDeserializer = this._deserializer;
        if (jsonDeserializer == null) {
            jsonDeserializer = deserializationContext.getDeserializerProvider().findValueDeserializer(deserializationContext.getConfig(), this._valueType, this._property);
            this._deserializer = jsonDeserializer;
        }
        try {
            return this._xmlAdapter.unmarshal(jsonDeserializer.mo22015deserialize(jsonParser, deserializationContext));
        } catch (Exception e) {
            throw new JsonMappingException("Unable to unmarshal (to type " + this._valueType + "): " + e.getMessage(), e);
        }
    }

    @Override // org.codehaus.jackson.map.deser.StdDeserializer, org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserializeWithType */
    public Object mo21953deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) {
        return typeDeserializer.deserializeTypedFromAny(jsonParser, deserializationContext);
    }
}
