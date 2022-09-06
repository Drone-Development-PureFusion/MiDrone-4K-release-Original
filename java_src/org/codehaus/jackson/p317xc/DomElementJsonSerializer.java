package org.codehaus.jackson.p317xc;

import com.tencent.p227mm.sdk.contact.RContact;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.node.ObjectNode;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/* renamed from: org.codehaus.jackson.xc.DomElementJsonSerializer */
/* loaded from: classes2.dex */
public class DomElementJsonSerializer extends SerializerBase<Element> {
    public DomElementJsonSerializer() {
        super(Element.class);
    }

    @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.schema.SchemaAware
    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        ObjectNode createSchemaNode = createSchemaNode("object", true);
        createSchemaNode.put("name", createSchemaNode("string"));
        createSchemaNode.put("namespace", createSchemaNode("string", true));
        createSchemaNode.put("attributes", createSchemaNode("array", true));
        createSchemaNode.put("children", createSchemaNode("array", true));
        return createSchemaNode;
    }

    @Override // org.codehaus.jackson.map.ser.SerializerBase, org.codehaus.jackson.map.JsonSerializer
    public void serialize(Element element, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", element.getTagName());
        if (element.getNamespaceURI() != null) {
            jsonGenerator.writeStringField("namespace", element.getNamespaceURI());
        }
        NamedNodeMap attributes = element.getAttributes();
        if (attributes != null && attributes.getLength() > 0) {
            jsonGenerator.writeArrayFieldStart("attributes");
            for (int i = 0; i < attributes.getLength(); i++) {
                Attr attr = (Attr) attributes.item(i);
                jsonGenerator.writeStartObject();
                jsonGenerator.writeStringField(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR, attr.getValue());
                jsonGenerator.writeStringField("name", attr.getName());
                String namespaceURI = attr.getNamespaceURI();
                if (namespaceURI != null) {
                    jsonGenerator.writeStringField("namespace", namespaceURI);
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
        NodeList childNodes = element.getChildNodes();
        if (childNodes != null && childNodes.getLength() > 0) {
            jsonGenerator.writeArrayFieldStart("children");
            for (int i2 = 0; i2 < childNodes.getLength(); i2++) {
                Node item = childNodes.item(i2);
                switch (item.getNodeType()) {
                    case 1:
                        serialize((Element) item, jsonGenerator, serializerProvider);
                        break;
                    case 3:
                    case 4:
                        jsonGenerator.writeStartObject();
                        jsonGenerator.writeStringField(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR, item.getNodeValue());
                        jsonGenerator.writeEndObject();
                        break;
                }
            }
            jsonGenerator.writeEndArray();
        }
        jsonGenerator.writeEndObject();
    }
}
