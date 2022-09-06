package p069c.p073d;

import java.io.PrintStream;
import p069c.p071b.AbstractC0618i;
import p069c.p071b.AbstractC0619j;
import p069c.p071b.C0622m;
import p069c.p071b.C0624n;
import p069c.p072c.AbstractC0626a;
import p069c.p072c.C0628c;
/* renamed from: c.d.b */
/* loaded from: classes.dex */
public class C0630b extends AbstractC0626a {

    /* renamed from: e */
    public static final int f1422e = 0;

    /* renamed from: f */
    public static final int f1423f = 1;

    /* renamed from: g */
    public static final int f1424g = 2;

    /* renamed from: h */
    private C0629a f1425h;

    public C0630b() {
        this(System.out);
    }

    public C0630b(C0629a c0629a) {
        this.f1425h = c0629a;
    }

    public C0630b(PrintStream printStream) {
        this(new C0629a(printStream));
    }

    /* renamed from: a */
    public static void m19784a(Class<? extends AbstractC0619j> cls) {
        m19778c(new C0624n(cls));
    }

    /* renamed from: b */
    public static void m19779b(String[] strArr) {
        try {
            if (!new C0630b().m19777c(strArr).m19851h()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }

    /* renamed from: c */
    public static C0622m m19778c(AbstractC0618i abstractC0618i) {
        return new C0630b().m19775e(abstractC0618i);
    }

    /* renamed from: d */
    public static void m19776d(AbstractC0618i abstractC0618i) {
        new C0630b().m19786a(abstractC0618i, true);
    }

    /* renamed from: a */
    public C0622m m19786a(AbstractC0618i abstractC0618i, boolean z) {
        C0622m m19774f = m19774f();
        m19774f.m19860a(this.f1425h);
        long currentTimeMillis = System.currentTimeMillis();
        abstractC0618i.mo19844a(m19774f);
        this.f1425h.m19794a(m19774f, System.currentTimeMillis() - currentTimeMillis);
        m19780b(z);
        return m19774f;
    }

    /* renamed from: a */
    protected C0622m m19782a(String str, String str2, boolean z) {
        return m19786a(C0624n.m19842a(g(str).asSubclass(AbstractC0619j.class), str2), z);
    }

    @Override // p069c.p072c.AbstractC0626a
    /* renamed from: a */
    public void mo19787a(int i, AbstractC0618i abstractC0618i, Throwable th) {
    }

    /* renamed from: a */
    public void m19785a(C0629a c0629a) {
        this.f1425h = c0629a;
    }

    @Override // p069c.p072c.AbstractC0626a
    /* renamed from: a */
    public void mo19783a(String str) {
    }

    @Override // p069c.p072c.AbstractC0626a
    /* renamed from: b */
    public void mo19781b(String str) {
    }

    /* renamed from: b */
    protected void m19780b(boolean z) {
        if (!z) {
            return;
        }
        this.f1425h.m19799a();
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public C0622m m19777c(String[] strArr) {
        String str = "";
        String str2 = "";
        int i = 0;
        boolean z = false;
        while (i < strArr.length) {
            if (strArr[i].equals("-wait")) {
                z = true;
            } else if (strArr[i].equals("-c")) {
                i++;
                str = d(strArr[i]);
            } else if (strArr[i].equals("-m")) {
                i++;
                String str3 = strArr[i];
                int lastIndexOf = str3.lastIndexOf(46);
                str = str3.substring(0, lastIndexOf);
                str2 = str3.substring(lastIndexOf + 1);
            } else if (strArr[i].equals("-v")) {
                System.err.println("JUnit " + C0628c.m19801a() + " by Kent Beck and Erich Gamma");
            } else {
                str = strArr[i];
            }
            i++;
        }
        if (str.equals("")) {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
        try {
            return !str2.equals("") ? m19782a(str, str2, z) : m19786a(c(str), z);
        } catch (Exception e) {
            throw new Exception("Could not create and run test suite: " + e);
        }
    }

    /* renamed from: e */
    public C0622m m19775e(AbstractC0618i abstractC0618i) {
        return m19786a(abstractC0618i, false);
    }

    /* renamed from: f */
    protected C0622m m19774f() {
        return new C0622m();
    }

    @Override // p069c.p072c.AbstractC0626a
    /* renamed from: f */
    protected void mo19773f(String str) {
        System.err.println(str);
        System.exit(1);
    }
}
