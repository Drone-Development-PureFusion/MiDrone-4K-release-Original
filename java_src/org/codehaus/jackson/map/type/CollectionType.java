package org.codehaus.jackson.map.type;

import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public final class CollectionType extends CollectionLikeType {
    private CollectionType(Class<?> cls, JavaType javaType) {
        super(cls, javaType);
    }

    public static CollectionType construct(Class<?> cls, JavaType javaType) {
        return new CollectionType(cls, javaType);
    }

    @Override // org.codehaus.jackson.map.type.CollectionLikeType, org.codehaus.jackson.type.JavaType
    protected JavaType _narrow(Class<?> cls) {
        return new CollectionType(cls, this._elementType);
    }

    @Override // org.codehaus.jackson.map.type.CollectionLikeType, org.codehaus.jackson.type.JavaType
    public JavaType narrowContentsBy(Class<?> cls) {
        return cls == this._elementType.getRawClass() ? this : new CollectionType(this._class, this._elementType.narrowBy(cls)).copyHandlers(this);
    }

    @Override // org.codehaus.jackson.map.type.CollectionLikeType, org.codehaus.jackson.type.JavaType
    public String toString() {
        return "[collection type; class " + this._class.getName() + ", contains " + this._elementType + "]";
    }

    @Override // org.codehaus.jackson.map.type.CollectionLikeType, org.codehaus.jackson.type.JavaType
    public JavaType widenContentsBy(Class<?> cls) {
        return cls == this._elementType.getRawClass() ? this : new CollectionType(this._class, this._elementType.widenBy(cls)).copyHandlers(this);
    }

    @Override // org.codehaus.jackson.map.type.CollectionLikeType, org.codehaus.jackson.type.JavaType
    /* renamed from: withContentTypeHandler  reason: collision with other method in class */
    public CollectionType mo21992withContentTypeHandler(Object obj) {
        return new CollectionType(this._class, this._elementType.mo21994withTypeHandler(obj));
    }

    @Override // org.codehaus.jackson.map.type.CollectionLikeType, org.codehaus.jackson.type.JavaType
    /* renamed from: withTypeHandler  reason: collision with other method in class */
    public CollectionType mo21994withTypeHandler(Object obj) {
        CollectionType collectionType = new CollectionType(this._class, this._elementType);
        collectionType._typeHandler = obj;
        return collectionType;
    }
}
