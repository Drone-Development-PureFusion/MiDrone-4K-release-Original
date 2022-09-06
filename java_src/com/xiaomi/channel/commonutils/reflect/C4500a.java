package com.xiaomi.channel.commonutils.reflect;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.xiaomi.channel.commonutils.reflect.a */
/* loaded from: classes2.dex */
public class C4500a {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f18579a = new HashMap();

    /* renamed from: com.xiaomi.channel.commonutils.reflect.a$a */
    /* loaded from: classes2.dex */
    public static class C4501a<T> {

        /* renamed from: a */
        public final Class<? extends T> f18580a;

        /* renamed from: b */
        public final T f18581b;
    }

    static {
        f18579a.put(Boolean.class, Boolean.TYPE);
        f18579a.put(Byte.class, Byte.TYPE);
        f18579a.put(Character.class, Character.TYPE);
        f18579a.put(Short.class, Short.TYPE);
        f18579a.put(Integer.class, Integer.TYPE);
        f18579a.put(Float.class, Float.TYPE);
        f18579a.put(Long.class, Long.TYPE);
        f18579a.put(Double.class, Double.TYPE);
        f18579a.put(Boolean.TYPE, Boolean.TYPE);
        f18579a.put(Byte.TYPE, Byte.TYPE);
        f18579a.put(Character.TYPE, Character.TYPE);
        f18579a.put(Short.TYPE, Short.TYPE);
        f18579a.put(Integer.TYPE, Integer.TYPE);
        f18579a.put(Float.TYPE, Float.TYPE);
        f18579a.put(Long.TYPE, Long.TYPE);
        f18579a.put(Double.TYPE, Double.TYPE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Class<? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* renamed from: a */
    public static <T> T m4977a(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
                continue;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
                continue;
            }
            if (cls == 0) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    /* renamed from: a */
    public static <T> T m4976a(Class<? extends Object> cls, String str) {
        try {
            return (T) m4977a(cls, (Object) null, str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m4974a(Class<?> cls, String str, Object... objArr) {
        return (T) m4975a(cls, str, m4969a(objArr)).invoke(null, m4966b(objArr));
    }

    /* renamed from: a */
    public static <T> T m4973a(Object obj, String str) {
        try {
            return (T) m4977a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m4972a(Object obj, String str, Object... objArr) {
        try {
            return (T) m4967b(obj, str, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str + "' in " + obj, e);
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m4971a(String str, String str2, Object... objArr) {
        try {
            return (T) m4974a(Class.forName(str), str2, objArr);
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }

    /* renamed from: a */
    private static Method m4975a(Class<?> cls, String str, Class<?>... clsArr) {
        Method m4968a = m4968a(cls.getDeclaredMethods(), str, clsArr);
        if (m4968a != null) {
            m4968a.setAccessible(true);
            return m4968a;
        } else if (cls.getSuperclass() == null) {
            throw new NoSuchMethodException();
        } else {
            return m4975a((Class<?>) cls.getSuperclass(), str, clsArr);
        }
    }

    /* renamed from: a */
    private static Method m4968a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str == null) {
            throw new NullPointerException("Method name must not be null.");
        }
        for (Method method : methodArr) {
            if (method.getName().equals(str) && m4970a(method.getParameterTypes(), clsArr)) {
                return method;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m4970a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        } else if (clsArr2 == null) {
            return clsArr.length == 0;
        } else if (clsArr.length != clsArr2.length) {
            return false;
        } else {
            for (int i = 0; i < clsArr.length; i++) {
                if (!clsArr[i].isAssignableFrom(clsArr2[i]) && (!f18579a.containsKey(clsArr[i]) || !f18579a.get(clsArr[i]).equals(f18579a.get(clsArr2[i])))) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private static Class<?>[] m4969a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return clsArr;
            }
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof C4501a)) {
                clsArr[i2] = obj == null ? null : obj.getClass();
            } else {
                clsArr[i2] = ((C4501a) obj).f18580a;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    public static <T> T m4967b(Object obj, String str, Object... objArr) {
        return (T) m4975a(obj.getClass(), str, m4969a(objArr)).invoke(obj, m4966b(objArr));
    }

    /* renamed from: b */
    private static Object[] m4966b(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                return objArr2;
            }
            Object obj = objArr[i2];
            if (obj == null || !(obj instanceof C4501a)) {
                objArr2[i2] = obj;
            } else {
                objArr2[i2] = ((C4501a) obj).f18581b;
            }
            i = i2 + 1;
        }
    }
}
