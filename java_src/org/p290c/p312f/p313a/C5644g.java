package org.p290c.p312f.p313a;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
/* renamed from: org.c.f.a.g */
/* loaded from: classes2.dex */
class C5644g {

    /* renamed from: a */
    private final Method f22749a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5644g(Method method) {
        this.f22749a = method;
    }

    /* renamed from: a */
    private void m437a(GenericArrayType genericArrayType, List<Throwable> list) {
        m435a(genericArrayType.getGenericComponentType(), list);
    }

    /* renamed from: a */
    private void m436a(ParameterizedType parameterizedType, List<Throwable> list) {
        for (Type type : parameterizedType.getActualTypeArguments()) {
            m435a(type, list);
        }
    }

    /* renamed from: a */
    private void m435a(Type type, List<Throwable> list) {
        if (type instanceof TypeVariable) {
            list.add(new Exception("Method " + this.f22749a.getName() + "() contains unresolved type variable " + type));
        } else if (type instanceof ParameterizedType) {
            m436a((ParameterizedType) type, list);
        } else if (type instanceof WildcardType) {
            m434a((WildcardType) type, list);
        } else if (!(type instanceof GenericArrayType)) {
        } else {
            m437a((GenericArrayType) type, list);
        }
    }

    /* renamed from: a */
    private void m434a(WildcardType wildcardType, List<Throwable> list) {
        for (Type type : wildcardType.getUpperBounds()) {
            m435a(type, list);
        }
        for (Type type2 : wildcardType.getLowerBounds()) {
            m435a(type2, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m433a(List<Throwable> list) {
        for (Type type : this.f22749a.getGenericParameterTypes()) {
            m435a(type, list);
        }
    }
}
