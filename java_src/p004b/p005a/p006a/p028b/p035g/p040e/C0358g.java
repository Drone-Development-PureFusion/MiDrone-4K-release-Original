package p004b.p005a.p006a.p028b.p035g.p040e;

import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
/* renamed from: b.a.a.b.g.e.g */
/* loaded from: classes.dex */
public class C0358g {

    /* renamed from: a */
    private static final Class<?>[] f670a = {String.class};

    /* renamed from: a */
    private static Object m20789a(AbstractC0526e abstractC0526e, Class<?> cls, String str) {
        try {
            return cls.getMethod(C0359h.f716m, f670a).invoke(null, str);
        } catch (Exception e) {
            abstractC0526e.mo20228c("Failed to invoke valueOf{} method in class [" + cls.getName() + "] with value [" + str + "]");
            return null;
        }
    }

    /* renamed from: a */
    public static Object m20787a(AbstractC0526e abstractC0526e, String str, Class<?> cls) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (String.class.isAssignableFrom(cls)) {
            return trim;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return new Integer(trim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return new Long(trim);
        }
        if (Float.TYPE.isAssignableFrom(cls)) {
            return new Float(trim);
        }
        if (Double.TYPE.isAssignableFrom(cls)) {
            return new Double(trim);
        }
        if (Boolean.TYPE.isAssignableFrom(cls)) {
            if ("true".equalsIgnoreCase(trim)) {
                return Boolean.TRUE;
            }
            if (!"false".equalsIgnoreCase(trim)) {
                return null;
            }
            return Boolean.FALSE;
        } else if (cls.isEnum()) {
            return m20785b(abstractC0526e, trim, cls);
        } else {
            if (m20783c(cls)) {
                return m20789a(abstractC0526e, cls, trim);
            }
            if (!m20784b(cls)) {
                return null;
            }
            return m20788a(abstractC0526e, str);
        }
    }

    /* renamed from: a */
    private static Charset m20788a(AbstractC0526e abstractC0526e, String str) {
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException e) {
            abstractC0526e.mo20231a("Failed to get charset [" + str + "]", e);
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m20786a(Class<?> cls) {
        Package r1 = cls.getPackage();
        if (cls.isPrimitive()) {
            return true;
        }
        return (r1 != null && "java.lang".equals(r1.getName())) || m20783c(cls) || cls.isEnum() || m20784b(cls);
    }

    /* renamed from: b */
    private static Object m20785b(AbstractC0526e abstractC0526e, String str, Class<? extends Enum> cls) {
        return Enum.valueOf(cls, str);
    }

    /* renamed from: b */
    private static boolean m20784b(Class<?> cls) {
        return Charset.class.isAssignableFrom(cls);
    }

    /* renamed from: c */
    private static boolean m20783c(Class<?> cls) {
        return Modifier.isStatic(cls.getMethod(C0359h.f716m, f670a).getModifiers());
    }

    /* renamed from: a */
    boolean m20790a() {
        return false;
    }
}
