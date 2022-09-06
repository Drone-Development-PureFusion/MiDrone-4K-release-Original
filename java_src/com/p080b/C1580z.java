package com.p080b;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* renamed from: com.b.z */
/* loaded from: classes.dex */
public class C1580z {
    /* renamed from: a */
    public static <T> T m15422a(Context context, C1549dv c1549dv, String str, Class cls, Class[] clsArr, Object[] objArr) {
        C1402ac c1402ac;
        Class<?> loadClass;
        try {
            c1402ac = C1402ac.m16437a(context, c1549dv, C1399ab.m16450a(context, c1549dv.m15580a(), c1549dv.m15578b()), C1399ab.m16456a(context), null, context.getClassLoader());
        } catch (Throwable th) {
            C1450b.m16187a(th, "InstanceFactory", "getInstance");
            c1402ac = null;
        }
        if (c1402ac != null) {
            try {
                if (c1402ac.m16438a() && c1402ac.f4819a && (loadClass = c1402ac.loadClass(str)) != null) {
                    return (T) loadClass.getConstructor(clsArr).newInstance(objArr);
                }
            } catch (ClassNotFoundException e) {
                C1450b.m16187a(e, "InstanceFactory", "getInstance()");
            } catch (IllegalAccessException e2) {
                C1450b.m16187a(e2, "InstanceFactory", "getInstance()");
            } catch (IllegalArgumentException e3) {
                C1450b.m16187a(e3, "InstanceFactory", "getInstance()");
            } catch (InstantiationException e4) {
                C1450b.m16187a(e4, "InstanceFactory", "getInstance()");
            } catch (NoSuchMethodException e5) {
                C1450b.m16187a(e5, "InstanceFactory", "getInstance()");
            } catch (InvocationTargetException e6) {
                C1450b.m16187a(e6, "InstanceFactory", "getInstance()");
            } catch (Throwable th2) {
                C1450b.m16187a(th2, "InstanceFactory", "getInstance()");
            }
        }
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e7) {
            C1450b.m16187a(e7, "InstanceFactory", "getInstance()");
            throw new C1532dl("获取对象错误");
        } catch (IllegalArgumentException e8) {
            C1450b.m16187a(e8, "InstanceFactory", "getInstance()");
            throw new C1532dl("获取对象错误");
        } catch (InstantiationException e9) {
            C1450b.m16187a(e9, "InstanceFactory", "getInstance()");
            throw new C1532dl("获取对象错误");
        } catch (NoSuchMethodException e10) {
            C1450b.m16187a(e10, "InstanceFactory", "getInstance()");
            throw new C1532dl("获取对象错误");
        } catch (InvocationTargetException e11) {
            C1450b.m16187a(e11, "InstanceFactory", "getInstance()");
            throw new C1532dl("获取对象错误");
        } catch (Throwable th3) {
            C1450b.m16187a(th3, "InstanceFactory", "getInstance()");
            throw new C1532dl("获取对象错误");
        }
    }
}
