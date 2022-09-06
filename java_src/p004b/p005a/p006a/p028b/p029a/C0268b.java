package p004b.p005a.p006a.p028b.p029a;

import java.lang.reflect.Method;
/* renamed from: b.a.a.b.a.b */
/* loaded from: classes.dex */
public class C0268b {

    /* renamed from: a */
    private static final C0268b f466a = new C0268b(null);

    /* renamed from: b */
    private Class<?> f467b;

    /* renamed from: c */
    private Method f468c;

    /* renamed from: d */
    private Method f469d;

    private C0268b(ClassLoader classLoader) {
        try {
            m21093a(classLoader);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static C0268b m21094a() {
        return f466a;
    }

    /* renamed from: a */
    public Boolean m21091a(String str, boolean z) {
        if (this.f467b == null || this.f469d == null) {
            return Boolean.valueOf(z);
        }
        try {
            return (Boolean) this.f469d.invoke(this.f467b, str, Boolean.valueOf(z));
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: a */
    public String m21092a(String str, String str2) {
        String str3;
        if (this.f467b == null || this.f468c == null) {
            return null;
        }
        try {
            str3 = (String) this.f468c.invoke(this.f467b, str, str2);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e2) {
            str3 = null;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    /* renamed from: a */
    public void m21093a(ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = getClass().getClassLoader();
        }
        this.f467b = classLoader.loadClass("android.os.SystemProperties");
        this.f468c = this.f467b.getMethod("get", String.class, String.class);
        this.f469d = this.f467b.getMethod("getBoolean", String.class, Boolean.TYPE);
    }
}
