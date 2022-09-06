package com.p113c.p115b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* renamed from: com.c.b.e */
/* loaded from: classes.dex */
class C1831e<T, V> extends AbstractC1830d<T, V> {

    /* renamed from: a */
    private static final String f6436a = "get";

    /* renamed from: b */
    private static final String f6437b = "is";

    /* renamed from: c */
    private static final String f6438c = "set";

    /* renamed from: d */
    private Method f6439d;

    /* renamed from: e */
    private Method f6440e;

    /* renamed from: f */
    private Field f6441f;

    public C1831e(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = f6436a + str2;
        try {
            this.f6440e = cls.getMethod(str3, null);
        } catch (NoSuchMethodException e) {
            try {
                this.f6440e = cls.getDeclaredMethod(str3, null);
                this.f6440e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                String str4 = f6437b + str2;
                try {
                    this.f6440e = cls.getMethod(str4, null);
                } catch (NoSuchMethodException e3) {
                    try {
                        this.f6440e = cls.getDeclaredMethod(str4, null);
                        this.f6440e.setAccessible(true);
                    } catch (NoSuchMethodException e4) {
                        try {
                            this.f6441f = cls.getField(str);
                            Class<?> type = this.f6441f.getType();
                            if (m14458a((Class) cls2, (Class) type)) {
                                return;
                            }
                            throw new C1829c("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                        } catch (NoSuchFieldException e5) {
                            throw new C1829c("No accessor method or field found for property with name " + str);
                        }
                    }
                }
            }
        }
        Class<?> returnType = this.f6440e.getReturnType();
        if (!m14458a((Class) cls2, (Class) returnType)) {
            throw new C1829c("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
        }
        try {
            this.f6439d = cls.getDeclaredMethod(f6438c + str2, returnType);
            this.f6439d.setAccessible(true);
        } catch (NoSuchMethodException e6) {
        }
    }

    /* renamed from: a */
    private boolean m14458a(Class<V> cls, Class cls2) {
        if (cls2 != cls) {
            if (!cls2.isPrimitive()) {
                return false;
            }
            return (cls2 == Float.TYPE && cls == Float.class) || (cls2 == Integer.TYPE && cls == Integer.class) || ((cls2 == Boolean.TYPE && cls == Boolean.class) || ((cls2 == Long.TYPE && cls == Long.class) || ((cls2 == Double.TYPE && cls == Double.class) || ((cls2 == Short.TYPE && cls == Short.class) || ((cls2 == Byte.TYPE && cls == Byte.class) || (cls2 == Character.TYPE && cls == Character.class))))));
        }
        return true;
    }

    @Override // com.p113c.p115b.AbstractC1830d
    /* renamed from: a */
    public V mo14457a(T t) {
        if (this.f6440e != null) {
            try {
                return (V) this.f6440e.invoke(t, null);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.f6441f == null) {
            throw new AssertionError();
        } else {
            try {
                return (V) this.f6441f.get(t);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        }
    }

    @Override // com.p113c.p115b.AbstractC1830d
    /* renamed from: a */
    public void mo14456a(T t, V v) {
        if (this.f6439d != null) {
            try {
                this.f6439d.invoke(t, v);
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else if (this.f6441f == null) {
            throw new UnsupportedOperationException("Property " + b() + " is read-only");
        } else {
            try {
                this.f6441f.set(t, v);
            } catch (IllegalAccessException e3) {
                throw new AssertionError();
            }
        }
    }

    @Override // com.p113c.p115b.AbstractC1830d
    /* renamed from: a */
    public boolean mo14459a() {
        return this.f6439d == null && this.f6441f == null;
    }
}
