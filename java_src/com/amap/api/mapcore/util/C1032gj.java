package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Constructor;
/* renamed from: com.amap.api.mapcore.util.gj */
/* loaded from: classes.dex */
public class C1032gj {
    /* renamed from: a */
    public static <T> T m17904a(Context context, C0996fh c0996fh, String str, Class cls, Class[] clsArr, Object[] objArr) {
        T t = (T) m17902a(m17900b(context, c0996fh), str, clsArr, objArr);
        if (t == null && (t = (T) m17901a(cls, clsArr, objArr)) == null) {
            throw new C0975ex("获取对象错误");
        }
        return t;
    }

    /* renamed from: a */
    private static <T> T m17902a(AbstractC1033gk abstractC1033gk, String str, Class[] clsArr, Object[] objArr) {
        Class<?> loadClass;
        try {
            if (m17903a(abstractC1033gk) && (loadClass = abstractC1033gk.loadClass(str)) != null) {
                Constructor<?> declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return (T) declaredConstructor.newInstance(objArr);
            }
        } catch (Throwable th) {
            C1045gs.m17831a(th, "IFactory", "getWrap");
        }
        return null;
    }

    /* renamed from: a */
    private static <T> T m17901a(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "IFactory", "gIns2()");
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m17905a(Context context, C0996fh c0996fh) {
        try {
            File file = new File(C1036gn.m17881b(context, c0996fh.m18074a(), c0996fh.m18070b()));
            if (file.exists()) {
                return true;
            }
            C1036gn.m17889a(context, file, c0996fh);
            return false;
        } catch (Throwable th) {
            C1045gs.m17831a(th, "IFactory", "isdowned");
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m17903a(AbstractC1033gk abstractC1033gk) {
        return abstractC1033gk != null && abstractC1033gk.m17899a() && abstractC1033gk.f3235d;
    }

    /* renamed from: b */
    private static AbstractC1033gk m17900b(Context context, C0996fh c0996fh) {
        try {
            if (!m17905a(context, c0996fh)) {
                return null;
            }
            return C1034gl.m17897a().m17896a(context, c0996fh);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "IFactory", "gIns1");
            return null;
        }
    }
}
