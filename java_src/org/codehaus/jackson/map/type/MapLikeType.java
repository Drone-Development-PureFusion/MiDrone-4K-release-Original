package org.codehaus.jackson.map.type;

import java.util.Map;
import org.codehaus.jackson.type.JavaType;
import p004b.p005a.p006a.p028b.C0359h;
/* loaded from: classes2.dex */
public class MapLikeType extends TypeBase {
    protected final JavaType _keyType;
    protected final JavaType _valueType;

    /* JADX INFO: Access modifiers changed from: protected */
    public MapLikeType(Class<?> cls, JavaType javaType, JavaType javaType2) {
        super(cls, javaType.hashCode() ^ javaType2.hashCode());
        this._keyType = javaType;
        this._valueType = javaType2;
    }

    public static MapLikeType construct(Class<?> cls, JavaType javaType, JavaType javaType2) {
        return new MapLikeType(cls, javaType, javaType2);
    }

    @Override // org.codehaus.jackson.type.JavaType
    protected JavaType _narrow(Class<?> cls) {
        return new MapLikeType(cls, this._keyType, this._valueType);
    }

    @Override // org.codehaus.jackson.map.type.TypeBase
    protected String buildCanonicalName() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._keyType != null) {
            sb.append('<');
            sb.append(this._keyType.toCanonical());
            sb.append(C0359h.f727x);
            sb.append(this._valueType.toCanonical());
            sb.append('>');
        }
        return sb.toString();
    }

    @Override // org.codehaus.jackson.type.JavaType
    public JavaType containedType(int i) {
        if (i == 0) {
            return this._keyType;
        }
        if (i != 1) {
            return null;
        }
        return this._valueType;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public int containedTypeCount() {
        return 2;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public String containedTypeName(int i) {
        if (i == 0) {
            return "K";
        }
        if (i != 1) {
            return null;
        }
        return "V";
    }

    @Override // org.codehaus.jackson.type.JavaType
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            MapLikeType mapLikeType = (MapLikeType) obj;
            return this._class == mapLikeType._class && this._keyType.equals(mapLikeType._keyType) && this._valueType.equals(mapLikeType._valueType);
        }
        return false;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public JavaType getContentType() {
        return this._valueType;
    }

    @Override // org.codehaus.jackson.map.type.TypeBase, org.codehaus.jackson.type.JavaType
    public StringBuilder getErasedSignature(StringBuilder sb) {
        return _classSignature(this._class, sb, true);
    }

    @Override // org.codehaus.jackson.map.type.TypeBase, org.codehaus.jackson.type.JavaType
    public StringBuilder getGenericSignature(StringBuilder sb) {
        _classSignature(this._class, sb, false);
        sb.append('<');
        this._keyType.getGenericSignature(sb);
        this._valueType.getGenericSignature(sb);
        sb.append(">;");
        return sb;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public JavaType getKeyType() {
        return this._keyType;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public boolean isContainerType() {
        return true;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public boolean isMapLikeType() {
        return true;
    }

    public boolean isTrueMapType() {
        return Map.class.isAssignableFrom(this._class);
    }

    @Override // org.codehaus.jackson.type.JavaType
    public JavaType narrowContentsBy(Class<?> cls) {
        return cls == this._valueType.getRawClass() ? this : new MapLikeType(this._class, this._keyType, this._valueType.narrowBy(cls)).copyHandlers(this);
    }

    public JavaType narrowKey(Class<?> cls) {
        return cls == this._keyType.getRawClass() ? this : new MapLikeType(this._class, this._keyType.narrowBy(cls), this._valueType).copyHandlers(this);
    }

    @Override // org.codehaus.jackson.type.JavaType
    public String toString() {
        return "[map-like type; class " + this._class.getName() + ", " + this._keyType + " -> " + this._valueType + "]";
    }

    @Override // org.codehaus.jackson.type.JavaType
    public JavaType widenContentsBy(Class<?> cls) {
        return cls == this._valueType.getRawClass() ? this : new MapLikeType(this._class, this._keyType, this._valueType.widenBy(cls)).copyHandlers(this);
    }

    public JavaType widenKey(Class<?> cls) {
        return cls == this._keyType.getRawClass() ? this : new MapLikeType(this._class, this._keyType.widenBy(cls), this._valueType).copyHandlers(this);
    }

    @Override // org.codehaus.jackson.type.JavaType
    /* renamed from: withContentTypeHandler */
    public MapLikeType mo21992withContentTypeHandler(Object obj) {
        return new MapLikeType(this._class, this._keyType, this._valueType.mo21994withTypeHandler(obj));
    }

    @Override // org.codehaus.jackson.type.JavaType
    /* renamed from: withTypeHandler */
    public MapLikeType mo21994withTypeHandler(Object obj) {
        MapLikeType mapLikeType = new MapLikeType(this._class, this._keyType, this._valueType);
        mapLikeType._typeHandler = obj;
        return mapLikeType;
    }
}
