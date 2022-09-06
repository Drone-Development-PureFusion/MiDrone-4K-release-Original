package org.codehaus.jackson.map.jsontype.impl;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public class MinimalClassNameIdResolver extends ClassNameIdResolver {
    protected final String _basePackageName;
    protected final String _basePackagePrefix;

    /* JADX INFO: Access modifiers changed from: protected */
    public MinimalClassNameIdResolver(JavaType javaType, TypeFactory typeFactory) {
        super(javaType, typeFactory);
        String name = javaType.getRawClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf < 0) {
            this._basePackageName = "";
            this._basePackagePrefix = ".";
            return;
        }
        this._basePackagePrefix = name.substring(0, lastIndexOf + 1);
        this._basePackageName = name.substring(0, lastIndexOf);
    }

    @Override // org.codehaus.jackson.map.jsontype.impl.ClassNameIdResolver, org.codehaus.jackson.map.jsontype.TypeIdResolver
    public JsonTypeInfo.EnumC5696Id getMechanism() {
        return JsonTypeInfo.EnumC5696Id.MINIMAL_CLASS;
    }

    @Override // org.codehaus.jackson.map.jsontype.impl.ClassNameIdResolver, org.codehaus.jackson.map.jsontype.TypeIdResolver
    public String idFromValue(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this._basePackagePrefix) ? name.substring(this._basePackagePrefix.length() - 1) : name;
    }

    @Override // org.codehaus.jackson.map.jsontype.impl.ClassNameIdResolver, org.codehaus.jackson.map.jsontype.TypeIdResolver
    public JavaType typeFromId(String str) {
        if (str.startsWith(".")) {
            StringBuilder sb = new StringBuilder(str.length() + this._basePackageName.length());
            if (this._basePackageName.length() == 0) {
                sb.append(str.substring(1));
            } else {
                sb.append(this._basePackageName).append(str);
            }
            str = sb.toString();
        }
        return super.typeFromId(str);
    }
}
