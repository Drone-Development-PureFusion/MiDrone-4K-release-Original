package p069c.p071b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* renamed from: c.b.j */
/* loaded from: classes.dex */
public abstract class AbstractC0619j extends C0609a implements AbstractC0618i {

    /* renamed from: a */
    private String f1400a;

    public AbstractC0619j() {
        this.f1400a = null;
    }

    public AbstractC0619j(String str) {
        this.f1400a = str;
    }

    /* renamed from: b */
    public static void m19915b(byte b, byte b2) {
        C0609a.m19973a(b, b2);
    }

    /* renamed from: b */
    public static void m19914b(char c, char c2) {
        C0609a.m19972a(c, c2);
    }

    /* renamed from: b */
    public static void m19913b(double d, double d2, double d3) {
        C0609a.m19971a(d, d2, d3);
    }

    /* renamed from: b */
    public static void m19912b(float f, float f2, float f3) {
        C0609a.m19970a(f, f2, f3);
    }

    /* renamed from: b */
    public static void m19911b(int i, int i2) {
        C0609a.m19969a(i, i2);
    }

    /* renamed from: b */
    public static void m19910b(long j, long j2) {
        C0609a.m19968a(j, j2);
    }

    /* renamed from: b */
    public static void m19909b(String str, byte b, byte b2) {
        C0609a.m19964a(str, b, b2);
    }

    /* renamed from: b */
    public static void m19908b(String str, char c, char c2) {
        C0609a.m19963a(str, c, c2);
    }

    /* renamed from: b */
    public static void m19907b(String str, double d, double d2, double d3) {
        C0609a.m19962a(str, d, d2, d3);
    }

    /* renamed from: b */
    public static void m19906b(String str, float f, float f2, float f3) {
        C0609a.m19961a(str, f, f2, f3);
    }

    /* renamed from: b */
    public static void m19905b(String str, int i, int i2) {
        C0609a.m19960a(str, i, i2);
    }

    /* renamed from: b */
    public static void m19904b(String str, long j, long j2) {
        C0609a.m19959a(str, j, j2);
    }

    /* renamed from: b */
    public static void m19903b(String str, String str2) {
        C0609a.m19956a(str, str2);
    }

    /* renamed from: b */
    public static void m19902b(String str, String str2, String str3) {
        C0609a.m19955a(str, str2, str3);
    }

    /* renamed from: b */
    public static void m19901b(String str, short s, short s2) {
        C0609a.m19954a(str, s, s2);
    }

    /* renamed from: b */
    public static void m19900b(String str, boolean z, boolean z2) {
        C0609a.m19952a(str, z, z2);
    }

    /* renamed from: b */
    public static void m19899b(short s, short s2) {
        C0609a.m19951a(s, s2);
    }

    /* renamed from: b */
    public static void m19898b(boolean z, boolean z2) {
        C0609a.m19949a(z, z2);
    }

    /* renamed from: c */
    public static void m19896c(Object obj) {
        C0609a.m19967a(obj);
    }

    /* renamed from: c */
    public static void m19895c(String str) {
        C0609a.m19965a(str);
    }

    /* renamed from: c */
    public static void m19894c(String str, Object obj) {
        C0609a.m19958a(str, obj);
    }

    /* renamed from: c */
    public static void m19893c(String str, boolean z) {
        C0609a.m19953a(str, z);
    }

    /* renamed from: c */
    public static void m19892c(boolean z) {
        C0609a.m19950a(z);
    }

    /* renamed from: d */
    public static void m19890d(Object obj) {
        C0609a.m19948b(obj);
    }

    /* renamed from: d */
    public static void m19889d(Object obj, Object obj2) {
        C0609a.m19966a(obj, obj2);
    }

    /* renamed from: d */
    public static void m19888d(String str) {
        C0609a.m19946b(str);
    }

    /* renamed from: d */
    public static void m19887d(String str, Object obj) {
        C0609a.m19945b(str, obj);
    }

    /* renamed from: d */
    public static void m19886d(String str, boolean z) {
        C0609a.m19943b(str, z);
    }

    /* renamed from: d */
    public static void m19885d(boolean z) {
        C0609a.m19942b(z);
    }

    /* renamed from: e */
    public static void m19884e(Object obj, Object obj2) {
        C0609a.m19947b(obj, obj2);
    }

    /* renamed from: f */
    public static void m19882f(Object obj, Object obj2) {
        C0609a.m19941c(obj, obj2);
    }

    /* renamed from: g */
    public static void m19881g() {
        C0609a.m19938e();
    }

    /* renamed from: g */
    public static void m19880g(String str, Object obj, Object obj2) {
        C0609a.m19957a(str, obj, obj2);
    }

    /* renamed from: h */
    public static void m19878h(String str, Object obj, Object obj2) {
        C0609a.m19944b(str, obj, obj2);
    }

    /* renamed from: i */
    public static void m19876i(String str, Object obj, Object obj2) {
        C0609a.m19940c(str, obj, obj2);
    }

    /* renamed from: j */
    public static void m19874j(String str, Object obj, Object obj2) {
        C0609a.m19939d(str, obj, obj2);
    }

    /* renamed from: k */
    public static void m19873k(String str, Object obj, Object obj2) {
        C0609a.m19937e(str, obj, obj2);
    }

    /* renamed from: l */
    public static String m19872l(String str, Object obj, Object obj2) {
        return C0609a.m19936f(str, obj, obj2);
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public int mo19848a() {
        return 1;
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public void mo19844a(C0622m c0622m) {
        c0622m.m19861a(this);
    }

    /* renamed from: b */
    protected C0622m m19916b() {
        return new C0622m();
    }

    /* renamed from: c */
    public C0622m m19897c() {
        C0622m m19916b = m19916b();
        mo19844a(m19916b);
        return m19916b;
    }

    /* renamed from: d */
    public void m19891d() {
        Throwable th = null;
        m19879h();
        try {
            mo19829f();
            try {
                m19877i();
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    th = null;
                }
                th = th;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                m19877i();
            } catch (Throwable th4) {
                th = th4;
                if (th != null) {
                    th = th;
                }
                th = th;
            }
        }
        if (th != null) {
            throw th;
        }
    }

    /* renamed from: e */
    public void m19883e(String str) {
        this.f1400a = str;
    }

    /* renamed from: f */
    protected void mo19829f() {
        Method method;
        m19894c("TestCase.fName cannot be null", (Object) this.f1400a);
        try {
            method = getClass().getMethod(this.f1400a, null);
        } catch (NoSuchMethodException e) {
            m19895c("Method \"" + this.f1400a + "\" not found");
            method = null;
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            m19895c("Method \"" + this.f1400a + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.fillInStackTrace();
            throw e2;
        } catch (InvocationTargetException e3) {
            e3.fillInStackTrace();
            throw e3.getTargetException();
        }
    }

    /* renamed from: h */
    protected void m19879h() {
    }

    /* renamed from: i */
    protected void m19877i() {
    }

    /* renamed from: j */
    public String m19875j() {
        return this.f1400a;
    }

    public String toString() {
        return m19875j() + "(" + getClass().getName() + ")";
    }
}
