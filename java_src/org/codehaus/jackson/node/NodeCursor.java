package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
/* loaded from: classes2.dex */
abstract class NodeCursor extends JsonStreamContext {
    final NodeCursor _parent;

    /* loaded from: classes2.dex */
    protected static final class Array extends NodeCursor {
        Iterator<JsonNode> _contents;
        JsonNode _currentNode;

        public Array(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(1, nodeCursor);
            this._contents = jsonNode.getElements();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonNode currentNode() {
            return this._currentNode;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken endToken() {
            return JsonToken.END_ARRAY;
        }

        @Override // org.codehaus.jackson.node.NodeCursor, org.codehaus.jackson.JsonStreamContext
        public String getCurrentName() {
            return null;
        }

        @Override // org.codehaus.jackson.node.NodeCursor, org.codehaus.jackson.JsonStreamContext
        /* renamed from: getParent */
        public /* bridge */ /* synthetic */ JsonStreamContext mo22000getParent() {
            return super.mo22000getParent();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken nextToken() {
            if (!this._contents.hasNext()) {
                this._currentNode = null;
                return null;
            }
            this._currentNode = this._contents.next();
            return this._currentNode.asToken();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken nextValue() {
            return nextToken();
        }
    }

    /* loaded from: classes2.dex */
    protected static final class Object extends NodeCursor {
        Iterator<Map.Entry<String, JsonNode>> _contents;
        Map.Entry<String, JsonNode> _current;
        boolean _needEntry = true;

        public Object(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(2, nodeCursor);
            this._contents = ((ObjectNode) jsonNode).getFields();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonNode currentNode() {
            if (this._current == null) {
                return null;
            }
            return this._current.getValue();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken endToken() {
            return JsonToken.END_OBJECT;
        }

        @Override // org.codehaus.jackson.node.NodeCursor, org.codehaus.jackson.JsonStreamContext
        public String getCurrentName() {
            if (this._current == null) {
                return null;
            }
            return this._current.getKey();
        }

        @Override // org.codehaus.jackson.node.NodeCursor, org.codehaus.jackson.JsonStreamContext
        /* renamed from: getParent */
        public /* bridge */ /* synthetic */ JsonStreamContext mo22000getParent() {
            return super.mo22000getParent();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken nextToken() {
            if (!this._needEntry) {
                this._needEntry = true;
                return this._current.getValue().asToken();
            } else if (!this._contents.hasNext()) {
                this._current = null;
                return null;
            } else {
                this._needEntry = false;
                this._current = this._contents.next();
                return JsonToken.FIELD_NAME;
            }
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken nextValue() {
            JsonToken nextToken = nextToken();
            return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
        }
    }

    /* loaded from: classes2.dex */
    protected static final class RootValue extends NodeCursor {
        protected boolean _done = false;
        JsonNode _node;

        public RootValue(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(0, nodeCursor);
            this._node = jsonNode;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public boolean currentHasChildren() {
            return false;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonNode currentNode() {
            return this._node;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken endToken() {
            return null;
        }

        @Override // org.codehaus.jackson.node.NodeCursor, org.codehaus.jackson.JsonStreamContext
        public String getCurrentName() {
            return null;
        }

        @Override // org.codehaus.jackson.node.NodeCursor, org.codehaus.jackson.JsonStreamContext
        /* renamed from: getParent */
        public /* bridge */ /* synthetic */ JsonStreamContext mo22000getParent() {
            return super.mo22000getParent();
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken nextToken() {
            if (!this._done) {
                this._done = true;
                return this._node.asToken();
            }
            this._node = null;
            return null;
        }

        @Override // org.codehaus.jackson.node.NodeCursor
        public JsonToken nextValue() {
            return nextToken();
        }
    }

    public NodeCursor(int i, NodeCursor nodeCursor) {
        this._type = i;
        this._index = -1;
        this._parent = nodeCursor;
    }

    public abstract boolean currentHasChildren();

    public abstract JsonNode currentNode();

    public abstract JsonToken endToken();

    @Override // org.codehaus.jackson.JsonStreamContext
    public abstract String getCurrentName();

    @Override // org.codehaus.jackson.JsonStreamContext
    /* renamed from: getParent  reason: collision with other method in class */
    public final NodeCursor mo22000getParent() {
        return this._parent;
    }

    public final NodeCursor iterateChildren() {
        JsonNode currentNode = currentNode();
        if (currentNode == null) {
            throw new IllegalStateException("No current node");
        }
        if (currentNode.isArray()) {
            return new Array(currentNode, this);
        }
        if (!currentNode.isObject()) {
            throw new IllegalStateException("Current node of type " + currentNode.getClass().getName());
        }
        return new Object(currentNode, this);
    }

    public abstract JsonToken nextToken();

    public abstract JsonToken nextValue();
}
