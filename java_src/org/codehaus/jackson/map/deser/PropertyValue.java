package org.codehaus.jackson.map.deser;
/* loaded from: classes2.dex */
abstract class PropertyValue {
    public final PropertyValue next;
    public final Object value;

    /* loaded from: classes2.dex */
    static final class Any extends PropertyValue {
        final SettableAnyProperty _property;
        final String _propertyName;

        public Any(PropertyValue propertyValue, Object obj, SettableAnyProperty settableAnyProperty, String str) {
            super(propertyValue, obj);
            this._property = settableAnyProperty;
            this._propertyName = str;
        }

        @Override // org.codehaus.jackson.map.deser.PropertyValue
        public void assign(Object obj) {
            this._property.set(obj, this._propertyName, this.value);
        }
    }

    /* loaded from: classes2.dex */
    static final class Map extends PropertyValue {
        final Object _key;

        public Map(PropertyValue propertyValue, Object obj, Object obj2) {
            super(propertyValue, obj);
            this._key = obj2;
        }

        @Override // org.codehaus.jackson.map.deser.PropertyValue
        public void assign(Object obj) {
            ((java.util.Map) obj).put(this._key, this.value);
        }
    }

    /* loaded from: classes2.dex */
    static final class Regular extends PropertyValue {
        final SettableBeanProperty _property;

        public Regular(PropertyValue propertyValue, Object obj, SettableBeanProperty settableBeanProperty) {
            super(propertyValue, obj);
            this._property = settableBeanProperty;
        }

        @Override // org.codehaus.jackson.map.deser.PropertyValue
        public void assign(Object obj) {
            this._property.set(obj, this.value);
        }
    }

    protected PropertyValue(PropertyValue propertyValue, Object obj) {
        this.next = propertyValue;
        this.value = obj;
    }

    public abstract void assign(Object obj);
}
