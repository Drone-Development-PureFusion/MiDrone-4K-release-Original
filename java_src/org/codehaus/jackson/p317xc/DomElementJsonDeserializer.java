package org.codehaus.jackson.p317xc;

import com.tencent.p227mm.sdk.contact.RContact;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.node.ArrayNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
/* renamed from: org.codehaus.jackson.xc.DomElementJsonDeserializer */
/* loaded from: classes2.dex */
public class DomElementJsonDeserializer extends StdDeserializer<Element> {
    private final DocumentBuilder builder;

    public DomElementJsonDeserializer() {
        super(Element.class);
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            this.builder = newInstance.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException();
        }
    }

    public DomElementJsonDeserializer(DocumentBuilder documentBuilder) {
        super(Element.class);
        this.builder = documentBuilder;
    }

    @Override // org.codehaus.jackson.map.JsonDeserializer
    /* renamed from: deserialize  reason: collision with other method in class */
    public Element mo22015deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return fromNode(this.builder.newDocument(), jsonParser.readValueAsTree());
    }

    protected Element fromNode(Document document, JsonNode jsonNode) {
        String valueAsText = jsonNode.get("namespace") != null ? jsonNode.get("namespace").getValueAsText() : null;
        String valueAsText2 = jsonNode.get("name") != null ? jsonNode.get("name").getValueAsText() : null;
        if (valueAsText2 == null) {
            throw new JsonMappingException("No name for DOM element was provided in the JSON object.");
        }
        Element createElementNS = document.createElementNS(valueAsText, valueAsText2);
        JsonNode jsonNode2 = jsonNode.get("attributes");
        if (jsonNode2 != null && (jsonNode2 instanceof ArrayNode)) {
            Iterator<JsonNode> elements = jsonNode2.getElements();
            while (elements.hasNext()) {
                JsonNode next = elements.next();
                String valueAsText3 = next.get("namespace") != null ? next.get("namespace").getValueAsText() : null;
                String valueAsText4 = next.get("name") != null ? next.get("name").getValueAsText() : null;
                String valueAsText5 = next.get(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR) != null ? next.get(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR).getValueAsText() : null;
                if (valueAsText4 != null) {
                    createElementNS.setAttributeNS(valueAsText3, valueAsText4, valueAsText5);
                }
            }
        }
        JsonNode jsonNode3 = jsonNode.get("children");
        if (jsonNode3 != null && (jsonNode3 instanceof ArrayNode)) {
            Iterator<JsonNode> elements2 = jsonNode3.getElements();
            while (elements2.hasNext()) {
                JsonNode next2 = elements2.next();
                String valueAsText6 = next2.get("name") != null ? next2.get("name").getValueAsText() : null;
                String valueAsText7 = next2.get(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR) != null ? next2.get(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR).getValueAsText() : null;
                if (valueAsText7 != null) {
                    createElementNS.appendChild(document.createTextNode(valueAsText7));
                } else if (valueAsText6 != null) {
                    createElementNS.appendChild(fromNode(document, next2));
                }
            }
        }
        return createElementNS;
    }
}
