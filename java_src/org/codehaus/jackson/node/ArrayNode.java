package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.node.ContainerNode;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public final class ArrayNode extends ContainerNode {
    protected ArrayList<JsonNode> _children;

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    private void _add(JsonNode jsonNode) {
        if (this._children == null) {
            this._children = new ArrayList<>();
        }
        this._children.add(jsonNode);
    }

    private void _insert(int i, JsonNode jsonNode) {
        if (this._children == null) {
            this._children = new ArrayList<>();
            this._children.add(jsonNode);
        } else if (i < 0) {
            this._children.add(0, jsonNode);
        } else if (i >= this._children.size()) {
            this._children.add(jsonNode);
        } else {
            this._children.add(i, jsonNode);
        }
    }

    private boolean _sameChildren(ArrayList<JsonNode> arrayList) {
        int size = arrayList.size();
        if (size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this._children.get(i).equals(arrayList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public JsonNode _set(int i, JsonNode jsonNode) {
        if (this._children == null || i < 0 || i >= this._children.size()) {
            throw new IndexOutOfBoundsException("Illegal index " + i + ", array size " + size());
        }
        return this._children.set(i, jsonNode);
    }

    public void add(double d) {
        _add(numberNode(d));
    }

    public void add(float f) {
        _add(numberNode(f));
    }

    public void add(int i) {
        _add(numberNode(i));
    }

    public void add(long j) {
        _add(numberNode(j));
    }

    public void add(String str) {
        if (str == null) {
            addNull();
        } else {
            _add(textNode(str));
        }
    }

    public void add(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            addNull();
        } else {
            _add(numberNode(bigDecimal));
        }
    }

    public void add(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _add(jsonNode);
    }

    public void add(boolean z) {
        _add(booleanNode(z));
    }

    public void add(byte[] bArr) {
        if (bArr == null) {
            addNull();
        } else {
            _add(binaryNode(bArr));
        }
    }

    public JsonNode addAll(Collection<JsonNode> collection) {
        if (collection.size() > 0) {
            if (this._children == null) {
                this._children = new ArrayList<>(collection);
            } else {
                this._children.addAll(collection);
            }
        }
        return this;
    }

    public JsonNode addAll(ArrayNode arrayNode) {
        int size = arrayNode.size();
        if (size > 0) {
            if (this._children == null) {
                this._children = new ArrayList<>(size + 2);
            }
            arrayNode.addContentsTo(this._children);
        }
        return this;
    }

    public ArrayNode addArray() {
        ArrayNode arrayNode = arrayNode();
        _add(arrayNode);
        return arrayNode;
    }

    protected void addContentsTo(List<JsonNode> list) {
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                list.add(it2.next());
            }
        }
    }

    public void addNull() {
        _add(nullNode());
    }

    public ObjectNode addObject() {
        ObjectNode objectNode = objectNode();
        _add(objectNode);
        return objectNode;
    }

    public void addPOJO(Object obj) {
        if (obj == null) {
            addNull();
        } else {
            _add(POJONode(obj));
        }
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public JsonToken asToken() {
        return JsonToken.START_ARRAY;
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            ArrayNode arrayNode = (ArrayNode) obj;
            return (this._children == null || this._children.size() == 0) ? arrayNode.size() == 0 : arrayNode._sameChildren(this._children);
        }
        return false;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    /* renamed from: findParent  reason: collision with other method in class */
    public ObjectNode mo22001findParent(String str) {
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                JsonNode mo22001findParent = it2.next().mo22001findParent(str);
                if (mo22001findParent != null) {
                    return (ObjectNode) mo22001findParent;
                }
            }
        }
        return null;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                list = it2.next().findParents(str, list);
            }
        }
        return list;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public JsonNode findValue(String str) {
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                JsonNode findValue = it2.next().findValue(str);
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
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                list = it2.next().findValues(str, list);
            }
        }
        return list;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public List<String> findValuesAsText(String str, List<String> list) {
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                list = it2.next().findValuesAsText(str, list);
            }
        }
        return list;
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.JsonNode
    public JsonNode get(int i) {
        if (i < 0 || this._children == null || i >= this._children.size()) {
            return null;
        }
        return this._children.get(i);
    }

    @Override // org.codehaus.jackson.node.ContainerNode, org.codehaus.jackson.JsonNode
    public JsonNode get(String str) {
        return null;
    }

    @Override // org.codehaus.jackson.JsonNode
    public Iterator<JsonNode> getElements() {
        return this._children == null ? ContainerNode.NoNodesIterator.instance() : this._children.iterator();
    }

    public int hashCode() {
        if (this._children == null) {
            return 1;
        }
        int size = this._children.size();
        Iterator<JsonNode> it2 = this._children.iterator();
        while (true) {
            int i = size;
            if (!it2.hasNext()) {
                return i;
            }
            JsonNode next = it2.next();
            size = next != null ? next.hashCode() ^ i : i;
        }
    }

    public void insert(int i, double d) {
        _insert(i, numberNode(d));
    }

    public void insert(int i, float f) {
        _insert(i, numberNode(f));
    }

    public void insert(int i, int i2) {
        _insert(i, numberNode(i2));
    }

    public void insert(int i, long j) {
        _insert(i, numberNode(j));
    }

    public void insert(int i, String str) {
        if (str == null) {
            insertNull(i);
        } else {
            _insert(i, textNode(str));
        }
    }

    public void insert(int i, BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            insertNull(i);
        } else {
            _insert(i, numberNode(bigDecimal));
        }
    }

    public void insert(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _insert(i, jsonNode);
    }

    public void insert(int i, boolean z) {
        _insert(i, booleanNode(z));
    }

    public void insert(int i, byte[] bArr) {
        if (bArr == null) {
            insertNull(i);
        } else {
            _insert(i, binaryNode(bArr));
        }
    }

    public ArrayNode insertArray(int i) {
        ArrayNode arrayNode = arrayNode();
        _insert(i, arrayNode);
        return arrayNode;
    }

    public void insertNull(int i) {
        _insert(i, nullNode());
    }

    public ObjectNode insertObject(int i) {
        ObjectNode objectNode = objectNode();
        _insert(i, objectNode);
        return objectNode;
    }

    public void insertPOJO(int i, Object obj) {
        if (obj == null) {
            insertNull(i);
        } else {
            _insert(i, POJONode(obj));
        }
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean isArray() {
        return true;
    }

    @Override // org.codehaus.jackson.JsonNode
    public JsonNode path(int i) {
        return (i < 0 || this._children == null || i >= this._children.size()) ? MissingNode.getInstance() : this._children.get(i);
    }

    @Override // org.codehaus.jackson.JsonNode
    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public JsonNode remove(int i) {
        if (i < 0 || this._children == null || i >= this._children.size()) {
            return null;
        }
        return this._children.remove(i);
    }

    @Override // org.codehaus.jackson.node.ContainerNode
    /* renamed from: removeAll */
    public ArrayNode mo22002removeAll() {
        this._children = null;
        return this;
    }

    @Override // org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.map.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartArray();
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                ((BaseJsonNode) it2.next()).writeTo(jsonGenerator);
            }
        }
        jsonGenerator.writeEndArray();
    }

    @Override // org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.map.JsonSerializableWithType
    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        typeSerializer.writeTypePrefixForArray(this, jsonGenerator);
        if (this._children != null) {
            Iterator<JsonNode> it2 = this._children.iterator();
            while (it2.hasNext()) {
                ((BaseJsonNode) it2.next()).writeTo(jsonGenerator);
            }
        }
        typeSerializer.writeTypeSuffixForArray(this, jsonGenerator);
    }

    public JsonNode set(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        return _set(i, jsonNode);
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
        StringBuilder sb = new StringBuilder((size() << 4) + 16);
        sb.append('[');
        if (this._children != null) {
            int size = this._children.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append(C0359h.f727x);
                }
                sb.append(this._children.get(i).toString());
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
