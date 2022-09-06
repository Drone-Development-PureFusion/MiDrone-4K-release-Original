package org.codehaus.jackson.map.ext;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
/* loaded from: classes2.dex */
public abstract class DOMDeserializer<T> extends FromStringDeserializer<T> {
    static final DocumentBuilderFactory _parserFactory = DocumentBuilderFactory.newInstance();

    /* loaded from: classes2.dex */
    public static class DocumentDeserializer extends DOMDeserializer<Document> {
        public DocumentDeserializer() {
            super(Document.class);
        }

        @Override // org.codehaus.jackson.map.ext.DOMDeserializer, org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: collision with other method in class */
        public Document mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return parse(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class NodeDeserializer extends DOMDeserializer<Node> {
        public NodeDeserializer() {
            super(Node.class);
        }

        @Override // org.codehaus.jackson.map.ext.DOMDeserializer, org.codehaus.jackson.map.deser.FromStringDeserializer
        /* renamed from: _deserialize  reason: collision with other method in class */
        public Node mo21968_deserialize(String str, DeserializationContext deserializationContext) {
            return parse(str);
        }
    }

    static {
        _parserFactory.setNamespaceAware(true);
    }

    protected DOMDeserializer(Class<T> cls) {
        super(cls);
    }

    @Override // org.codehaus.jackson.map.deser.FromStringDeserializer
    /* renamed from: _deserialize */
    public abstract T mo21968_deserialize(String str, DeserializationContext deserializationContext);

    protected final Document parse(String str) {
        try {
            return _parserFactory.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse JSON String as XML: " + e.getMessage(), e);
        }
    }
}
