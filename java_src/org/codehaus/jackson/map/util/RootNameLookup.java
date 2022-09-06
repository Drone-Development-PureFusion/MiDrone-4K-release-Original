package org.codehaus.jackson.map.util;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.p316io.SerializedString;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public class RootNameLookup {
    protected LRUMap<ClassKey, SerializedString> _rootNames;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r0 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized SerializedString findRootName(Class<?> cls, MapperConfig<?> mapperConfig) {
        SerializedString serializedString;
        ClassKey classKey = new ClassKey(cls);
        if (this._rootNames == null) {
            this._rootNames = new LRUMap<>(20, 200);
        } else {
            serializedString = this._rootNames.get(classKey);
        }
        String findRootName = mapperConfig.getAnnotationIntrospector().findRootName(((BasicBeanDescription) mapperConfig.introspectClassAnnotations(cls)).getClassInfo());
        serializedString = new SerializedString(findRootName == null ? cls.getSimpleName() : findRootName);
        this._rootNames.put(classKey, serializedString);
        return serializedString;
    }

    public SerializedString findRootName(JavaType javaType, MapperConfig<?> mapperConfig) {
        return findRootName(javaType.getRawClass(), mapperConfig);
    }
}
