package org.codehaus.jackson.map.type;

import org.codehaus.jackson.type.JavaType;
/* loaded from: classes2.dex */
public abstract class TypeBase extends JavaType {
    volatile String _canonicalName;

    /* JADX INFO: Access modifiers changed from: protected */
    public TypeBase(Class<?> cls, int i) {
        super(cls, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static StringBuilder _classSignature(Class<?> cls, StringBuilder sb, boolean z) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i = 0; i < length; i++) {
                char charAt = name.charAt(i);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb.append(charAt);
            }
            if (z) {
                sb.append(';');
            }
        } else if (cls == Boolean.TYPE) {
            sb.append('Z');
        } else if (cls == Byte.TYPE) {
            sb.append('B');
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append('I');
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append('D');
        } else if (cls != Void.TYPE) {
            throw new IllegalStateException("Unrecognized primitive type: " + cls.getName());
        } else {
            sb.append('V');
        }
        return sb;
    }

    protected abstract String buildCanonicalName();

    /* JADX INFO: Access modifiers changed from: protected */
    public final JavaType copyHandlers(JavaType javaType) {
        this._valueHandler = javaType.getValueHandler();
        this._typeHandler = javaType.getTypeHandler();
        return this;
    }

    @Override // org.codehaus.jackson.type.JavaType
    public abstract StringBuilder getErasedSignature(StringBuilder sb);

    @Override // org.codehaus.jackson.type.JavaType
    public abstract StringBuilder getGenericSignature(StringBuilder sb);

    @Override // org.codehaus.jackson.type.JavaType
    public String toCanonical() {
        String str = this._canonicalName;
        return str == null ? buildCanonicalName() : str;
    }
}
