package com.mining.app.zxing.p221a;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* renamed from: com.mining.app.zxing.a.d */
/* loaded from: classes.dex */
public final class C4104d {

    /* renamed from: a */
    private static final String f17160a = C4104d.class.getSimpleName();

    /* renamed from: b */
    private static final Object f17161b = m6167c();

    /* renamed from: c */
    private static final Method f17162c = m6172a(f17161b);

    static {
        if (f17161b == null) {
            Log.v(f17160a, "This device does supports control of a flashlight");
        } else {
            Log.v(f17160a, "This device does not support control of a flashlight");
        }
    }

    private C4104d() {
    }

    /* renamed from: a */
    private static Class<?> m6171a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (RuntimeException e2) {
            Log.w(f17160a, "Unexpected error while finding class " + str, e2);
            return null;
        }
    }

    /* renamed from: a */
    private static Object m6170a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.w(f17160a, "Unexpected error while invoking " + method, e);
            return null;
        } catch (RuntimeException e2) {
            Log.w(f17160a, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.w(f17160a, "Unexpected error while invoking " + method, e3.getCause());
            return null;
        }
    }

    /* renamed from: a */
    private static Method m6173a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (RuntimeException e2) {
            Log.w(f17160a, "Unexpected error while finding method " + str, e2);
            return null;
        }
    }

    /* renamed from: a */
    private static Method m6172a(Object obj) {
        if (obj == null) {
            return null;
        }
        return m6173a(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    /* renamed from: a */
    public static void m6174a() {
        m6169a(true);
    }

    /* renamed from: a */
    private static void m6169a(boolean z) {
        if (f17161b != null) {
            m6170a(f17162c, f17161b, Boolean.valueOf(z));
        }
    }

    /* renamed from: b */
    public static void m6168b() {
        m6169a(false);
    }

    /* renamed from: c */
    private static Object m6167c() {
        Method m6173a;
        Object m6170a;
        Class<?> m6171a;
        Method m6173a2;
        Class<?> m6171a2 = m6171a("android.os.ServiceManager");
        if (m6171a2 == null || (m6173a = m6173a(m6171a2, "getService", String.class)) == null || (m6170a = m6170a(m6173a, (Object) null, "hardware")) == null || (m6171a = m6171a("android.os.IHardwareService$Stub")) == null || (m6173a2 = m6173a(m6171a, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return m6170a(m6173a2, (Object) null, m6170a);
    }
}
