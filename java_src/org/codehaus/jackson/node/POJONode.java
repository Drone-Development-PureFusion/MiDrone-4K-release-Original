package org.codehaus.jackson.node;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
/* loaded from: classes2.dex */
public final class POJONode extends ValueNode {
    protected final Object _value;

    public POJONode(Object obj) {
        this._value = obj;
    }

    @Override // org.codehaus.jackson.node.ValueNode, org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.JsonNode
    public JsonToken asToken() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            POJONode pOJONode = (POJONode) obj;
            return this._value == null ? pOJONode._value == null : this._value.equals(pOJONode._value);
        }
        return false;
    }

    public Object getPojo() {
        return this._value;
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean getValueAsBoolean(boolean z) {
        return (this._value == null || !(this._value instanceof Boolean)) ? z : ((Boolean) this._value).booleanValue();
    }

    @Override // org.codehaus.jackson.JsonNode
    public double getValueAsDouble(double d) {
        return this._value instanceof Number ? ((Number) this._value).doubleValue() : d;
    }

    @Override // org.codehaus.jackson.JsonNode
    public int getValueAsInt(int i) {
        return this._value instanceof Number ? ((Number) this._value).intValue() : i;
    }

    @Override // org.codehaus.jackson.JsonNode
    public long getValueAsLong(long j) {
        return this._value instanceof Number ? ((Number) this._value).longValue() : j;
    }

    @Override // org.codehaus.jackson.JsonNode
    public String getValueAsText() {
        return this._value == null ? "null" : this._value.toString();
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    @Override // org.codehaus.jackson.JsonNode
    public boolean isPojo() {
        return true;
    }

    @Override // org.codehaus.jackson.node.BaseJsonNode, org.codehaus.jackson.map.JsonSerializable
    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        if (this._value == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeObject(this._value);
        }
    }

    @Override // org.codehaus.jackson.node.ValueNode, org.codehaus.jackson.JsonNode
    public String toString() {
        return String.valueOf(this._value);
    }
}
