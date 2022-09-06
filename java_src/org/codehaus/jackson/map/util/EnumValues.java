package org.codehaus.jackson.map.util;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.p316io.SerializedString;
/* loaded from: classes.dex */
public final class EnumValues {
    private final EnumMap<?, SerializedString> _values;

    private EnumValues(Map<Enum<?>, SerializedString> map) {
        this._values = new EnumMap<>(map);
    }

    public static EnumValues construct(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        return constructFromName(cls, annotationIntrospector);
    }

    public static EnumValues constructFromName(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum<?>[] enumArr = (Enum[]) ClassUtil.findEnumType(cls).getEnumConstants();
        if (enumArr != null) {
            HashMap hashMap = new HashMap();
            for (Enum<?> r4 : enumArr) {
                hashMap.put(r4, new SerializedString(annotationIntrospector.findEnumValue(r4)));
            }
            return new EnumValues(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public static EnumValues constructFromToString(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) ClassUtil.findEnumType(cls).getEnumConstants();
        if (enumArr != null) {
            HashMap hashMap = new HashMap();
            for (Enum r4 : enumArr) {
                hashMap.put(r4, new SerializedString(r4.toString()));
            }
            return new EnumValues(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public SerializedString serializedValueFor(Enum<?> r2) {
        return this._values.get(r2);
    }

    @Deprecated
    public String valueFor(Enum<?> r2) {
        SerializedString serializedString = this._values.get(r2);
        if (serializedString == null) {
            return null;
        }
        return serializedString.getValue();
    }

    public Collection<SerializedString> values() {
        return this._values.values();
    }
}
