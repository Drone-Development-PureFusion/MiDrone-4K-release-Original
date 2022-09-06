package org.codehaus.jackson.node;

import com.xiaomi.mipush.sdk.Constants;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.node.ContainerNode;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class ObjectNode extends ContainerNode {
    protected LinkedHashMap<String, JsonNode> _children = null;

    /* loaded from: classes2.dex */
    protected static class NoFieldsIterator implements Iterator<Map.Entry<String, JsonNode>> {
        static final NoFieldsIterator instance = new NoFieldsIterator();

        private NoFieldsIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Map.Entry<String, JsonNode> next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    public ObjectNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    private final JsonNode _put(String str, JsonNode jsonNode) {
        if (this._children == null) {
            this._children = new LinkedHashMap<>();
        }
        return this._children.put(str, jsonNode);
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public JsonToken asToken() {
        return JsonToken.START_OBJECT;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    @Override // org.codehaus.jackson.JsonNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            ObjectNode objectNode = (ObjectNode) obj;
            if (objectNode.size() != size()) {
                return false;
            }
            if (this._children != null) {
                for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                    JsonNode value = entry.getValue();
                    JsonNode jsonNode = objectNode.get(entry.getKey());
                    if (jsonNode == null || !jsonNode.equals(value)) {
                        return false;
                    }
                    while (r4.hasNext()) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    /* renamed from: findParent  reason: collision with other method in class */
    public ObjectNode mo22001findParent(String str) {
        if (this._children != null) {
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                if (str.equals(entry.getKey())) {
                    return this;
                }
                JsonNode mo22001findParent = entry.getValue().mo22001findParent(str);
                if (mo22001findParent != null) {
                    return (ObjectNode) mo22001findParent;
                }
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        List<JsonNode> findParents;
        if (this._children != null) {
            List<JsonNode> list2 = list;
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                if (str.equals(entry.getKey())) {
                    findParents = list2 == null ? new ArrayList<>() : list2;
                    findParents.add(this);
                } else {
                    findParents = entry.getValue().findParents(str, list2);
                }
                list2 = findParents;
            }
            return list2;
        }
        return list;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public JsonNode findValue(String str) {
        if (this._children != null) {
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                if (str.equals(entry.getKey())) {
                    return entry.getValue();
                }
                JsonNode findValue = entry.getValue().findValue(str);
                if (findValue != null) {
                    return findValue;
                }
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        if (this._children != null) {
            List<JsonNode> list2 = list;
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                if (str.equals(entry.getKey())) {
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.add(entry.getValue());
                } else {
                    list2 = entry.getValue().findValues(str, list2);
                }
            }
            return list2;
        }
        return list;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public List<String> findValuesAsText(String str, List<String> list) {
        if (this._children != null) {
            List<String> list2 = list;
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                if (str.equals(entry.getKey())) {
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.add(entry.getValue().getValueAsText());
                } else {
                    list2 = entry.getValue().findValuesAsText(str, list2);
                }
            }
            return list2;
        }
        return list;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.JsonNode
    public JsonNode get(int i) {
        return null;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.JsonNode
    public JsonNode get(String str) {
        if (this._children != null) {
            return this._children.get(str);
        }
        return null;
    }

    @Override // org.codehaus.jackson.JsonNode
    public Iterator<JsonNode> getElements() {
        return this._children == null ? ContainerNode.NoNodesIterator.instance() : this._children.values().iterator();
    }

    @Override // org.codehaus.jackson.JsonNode
    public Iterator<String> getFieldNames() {
        return this._children == null ? ContainerNode.NoStringsIterator.instance() : this._children.keySet().iterator();
    }

    @Override // org.codehaus.jackson.JsonNode
    public Iterator<Map.Entry<String, JsonNode>> getFields() {
        return this._children == null ? NoFieldsIterator.instance : this._children.entrySet().iterator();
    }

    public int hashCode() {
        if (this._children == null) {
            return -1;
        }
        return this._children.hashCode();
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean isObject() {
        return true;
    }

    @Override // org.codehaus.jackson.JsonNode
    public JsonNode path(int i) {
        return MissingNode.getInstance();
    }

    @Override // org.codehaus.jackson.JsonNode
    public JsonNode path(String str) {
        JsonNode jsonNode;
        return (this._children == null || (jsonNode = this._children.get(str)) == null) ? MissingNode.getInstance() : jsonNode;
    }

    public JsonNode put(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        return _put(str, jsonNode);
    }

    public void put(String str, double d) {
        _put(str, numberNode(d));
    }

    public void put(String str, float f) {
        _put(str, numberNode(f));
    }

    public void put(String str, int i) {
        _put(str, numberNode(i));
    }

    public void put(String str, long j) {
        _put(str, numberNode(j));
    }

    public void put(String str, String str2) {
        if (str2 == null) {
            putNull(str);
        } else {
            _put(str, textNode(str2));
        }
    }

    public void put(String str, BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            putNull(str);
        } else {
            _put(str, numberNode(bigDecimal));
        }
    }

    public void put(String str, boolean z) {
        _put(str, booleanNode(z));
    }

    public void put(String str, byte[] bArr) {
        if (bArr == null) {
            putNull(str);
        } else {
            _put(str, binaryNode(bArr));
        }
    }

    public JsonNode putAll(Map<String, JsonNode> map) {
        if (this._children == null) {
            this._children = new LinkedHashMap<>(map);
        } else {
            for (Map.Entry<String, JsonNode> entry : map.entrySet()) {
                JsonNode value = entry.getValue();
                if (value == null) {
                    value = nullNode();
                }
                this._children.put(entry.getKey(), value);
            }
        }
        return this;
    }

    public JsonNode putAll(ObjectNode objectNode) {
        int size = objectNode.size();
        if (size > 0) {
            if (this._children == null) {
                this._children = new LinkedHashMap<>(size);
            }
            objectNode.putContentsTo(this._children);
        }
        return this;
    }

    public ArrayNode putArray(String str) {
        ArrayNode arrayNode = arrayNode();
        _put(str, arrayNode);
        return arrayNode;
    }

    protected void putContentsTo(Map<String, JsonNode> map) {
        if (this._children != null) {
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void putNull(String str) {
        _put(str, nullNode());
    }

    public ObjectNode putObject(String str) {
        ObjectNode objectNode = objectNode();
        _put(str, objectNode);
        return objectNode;
    }

    public void putPOJO(String str, Object obj) {
        _put(str, POJONode(obj));
    }

    public JsonNode remove(String str) {
        if (this._children != null) {
            return this._children.remove(str);
        }
        return null;
    }

    public ObjectNode remove(Collection<String> collection) {
        if (this._children != null) {
            for (String str : collection) {
                this._children.remove(str);
            }
        }
        return this;
    }

    @Override // org.codehaus.jackson.node.ContainerNode
    /* renamed from: removeAll  reason: collision with other method in class */
    public ObjectNode mo22002removeAll() {
        this._children = null;
        return this;
    }

    public ObjectNode retain(Collection<String> collection) {
        if (this._children != null) {
            Iterator<Map.Entry<String, JsonNode>> it2 = this._children.entrySet().iterator();
            while (it2.hasNext()) {
                if (!collection.contains(it2.next().getKey())) {
                    it2.remove();
                }
            }
        }
        return this;
    }

    public ObjectNode retain(String... strArr) {
        return retain(Arrays.asList(strArr));
    }

    @Override // org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.map.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject();
        if (this._children != null) {
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                jsonGenerator.writeFieldName(entry.getKey());
                ((BaseJsonNode) entry.getValue()).serialize(jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeEndObject();
    }

    @Override // org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.map.JsonSerializableWithType
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.writeTypePrefixForObject(this, jsonGenerator);
        if (this._children != null) {
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                jsonGenerator.writeFieldName(entry.getKey());
                ((BaseJsonNode) entry.getValue()).serialize(jsonGenerator, serializerProvider);
            }
        }
        typeSerializer.writeTypeSuffixForObject(this, jsonGenerator);
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.JsonNode
    public int size() {
        if (this._children == null) {
            return 0;
        }
        return this._children.size();
    }

    @Override // org.codehaus.jackson.JsonNode
    public String toString() {
        StringBuilder sb = new StringBuilder((size() << 4) + 32);
        sb.append("{");
        if (this._children != null) {
            int i = 0;
            for (Map.Entry<String, JsonNode> entry : this._children.entrySet()) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                TextNode.appendQuoted(sb, entry.getKey());
                sb.append(C0359h.f671A);
                sb.append(entry.getValue().toString());
                i++;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // org.codehaus.jackson.JsonNode
    /* renamed from: with  reason: collision with other method in class */
    public ObjectNode mo22003with(String str) {
        if (this._children == null) {
            this._children = new LinkedHashMap<>();
        } else {
            JsonNode jsonNode = this._children.get(str);
            if (jsonNode != null) {
                if (!(jsonNode instanceof ObjectNode)) {
                    throw new UnsupportedOperationException("Property '" + str + "' has value that is not of type ObjectNode (but " + jsonNode.getClass().getName() + ")");
                }
                return (ObjectNode) jsonNode;
            }
        }
        ObjectNode objectNode = objectNode();
        this._children.put(str, objectNode);
        return objectNode;
    }
}
