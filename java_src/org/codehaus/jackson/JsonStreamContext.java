package org.codehaus.jackson;

import org.p318d.AbstractC5744c;
import p004b.p005a.p006a.p007a.p025n.C0228a;
/* loaded from: classes2.dex */
public abstract class JsonStreamContext {
    protected static final int TYPE_ARRAY = 1;
    protected static final int TYPE_OBJECT = 2;
    protected static final int TYPE_ROOT = 0;
    protected int _index;
    protected int _type;

    public final int getCurrentIndex() {
        if (this._index < 0) {
            return 0;
        }
        return this._index;
    }

    public abstract String getCurrentName();

    public final int getEntryCount() {
        return this._index + 1;
    }

    /* renamed from: getParent */
    public abstract JsonStreamContext mo22000getParent();

    public final String getTypeDesc() {
        switch (this._type) {
            case 0:
                return AbstractC5744c.f23019c;
            case 1:
                return "ARRAY";
            case 2:
                return "OBJECT";
            default:
                return C0228a.f351a;
        }
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }
}
