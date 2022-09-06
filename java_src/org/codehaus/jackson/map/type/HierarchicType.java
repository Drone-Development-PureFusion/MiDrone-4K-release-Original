package org.codehaus.jackson.map.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class HierarchicType {
    protected final Type _actualType;
    protected final ParameterizedType _genericType;
    protected final Class<?> _rawClass;
    protected HierarchicType _subType;
    protected HierarchicType _superType;

    public HierarchicType(Type type) {
        this._actualType = type;
        if (type instanceof Class) {
            this._rawClass = (Class) type;
            this._genericType = null;
        } else if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Type " + type.getClass().getName() + " can not be used to construct HierarchicType");
        } else {
            this._genericType = (ParameterizedType) type;
            this._rawClass = (Class) this._genericType.getRawType();
        }
    }

    public ParameterizedType asGeneric() {
        return this._genericType;
    }

    public Class<?> getRawClass() {
        return this._rawClass;
    }

    public HierarchicType getSubType() {
        return this._subType;
    }

    public HierarchicType getSuperType() {
        return this._superType;
    }

    public boolean isGeneric() {
        return this._genericType != null;
    }

    public void setSubType(HierarchicType hierarchicType) {
        this._subType = hierarchicType;
    }

    public void setSuperType(HierarchicType hierarchicType) {
        this._superType = hierarchicType;
    }

    public String toString() {
        return this._genericType != null ? this._genericType.toString() : this._rawClass.getName();
    }
}
