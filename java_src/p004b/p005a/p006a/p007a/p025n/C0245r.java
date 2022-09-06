package p004b.p005a.p006a.p007a.p025n;

import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.a.n.r */
/* loaded from: classes.dex */
public class C0245r {

    /* renamed from: a */
    public static final int f411a = 1;

    /* renamed from: b */
    public static final int f412b = 1;

    /* renamed from: c */
    private static final int f413c = 2048;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m21178a(StackTraceElement[] stackTraceElementArr, C0243p[] c0243pArr) {
        int i = 0;
        if (c0243pArr != null && stackTraceElementArr != null) {
            int length = stackTraceElementArr.length - 1;
            for (int length2 = c0243pArr.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr[length].equals(c0243pArr[length2].f397a); length2--) {
                i++;
                length--;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static String m21186a(AbstractC0232e abstractC0232e) {
        StringBuilder sb = new StringBuilder(2048);
        m21180a(sb, null, 1, abstractC0232e);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m21185a(C0244q c0244q, Throwable th, C0244q c0244q2) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i = -1;
        if (c0244q2 != null) {
            i = m21178a(stackTrace, c0244q2.mo21169c());
        }
        c0244q.f403b = i;
        c0244q.f402a = m21179a(stackTrace);
    }

    /* renamed from: a */
    public static void m21184a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append('\t');
        }
    }

    /* renamed from: a */
    public static void m21183a(StringBuilder sb, int i, AbstractC0232e abstractC0232e) {
        C0243p[] mo21169c = abstractC0232e.mo21169c();
        int mo21168d = abstractC0232e.mo21168d();
        for (int i2 = 0; i2 < mo21169c.length - mo21168d; i2++) {
            C0243p c0243p = mo21169c[i2];
            m21184a(sb, i);
            m21176b(sb, c0243p);
            sb.append(C0359h.f706c);
        }
        if (mo21168d > 0) {
            m21184a(sb, i);
            sb.append("... ").append(mo21168d).append(" common frames omitted").append(C0359h.f706c);
        }
    }

    /* renamed from: a */
    public static void m21182a(StringBuilder sb, AbstractC0232e abstractC0232e) {
        m21183a(sb, 1, abstractC0232e);
    }

    /* renamed from: a */
    public static void m21181a(StringBuilder sb, C0243p c0243p) {
        C0229b m21191c;
        if (c0243p == null || (m21191c = c0243p.m21191c()) == null) {
            return;
        }
        if (!m21191c.m21254c()) {
            sb.append(" ~[");
        } else {
            sb.append(" [");
        }
        sb.append(m21191c.m21256a()).append(C0359h.f671A).append(m21191c.m21255b()).append(']');
    }

    /* renamed from: a */
    private static void m21180a(StringBuilder sb, String str, int i, AbstractC0232e abstractC0232e) {
        if (abstractC0232e == null) {
            return;
        }
        m21175b(sb, str, i, abstractC0232e);
        sb.append(C0359h.f706c);
        m21183a(sb, i, abstractC0232e);
        AbstractC0232e[] mo21166f = abstractC0232e.mo21166f();
        if (mo21166f != null) {
            for (AbstractC0232e abstractC0232e2 : mo21166f) {
                m21180a(sb, C0359h.f719p, i + 1, abstractC0232e2);
            }
        }
        m21180a(sb, C0359h.f718o, i, abstractC0232e.mo21167e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C0243p[] m21179a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return new C0243p[0];
        }
        C0243p[] c0243pArr = new C0243p[stackTraceElementArr.length];
        for (int i = 0; i < c0243pArr.length; i++) {
            c0243pArr[i] = new C0243p(stackTraceElementArr[i]);
        }
        return c0243pArr;
    }

    /* renamed from: b */
    public static void m21177b(StringBuilder sb, AbstractC0232e abstractC0232e) {
        if (abstractC0232e.mo21168d() > 0) {
            sb.append(C0359h.f718o);
        }
        m21173d(sb, abstractC0232e);
    }

    /* renamed from: b */
    public static void m21176b(StringBuilder sb, C0243p c0243p) {
        sb.append(c0243p.toString());
        m21181a(sb, c0243p);
    }

    /* renamed from: b */
    private static void m21175b(StringBuilder sb, String str, int i, AbstractC0232e abstractC0232e) {
        m21184a(sb, i - 1);
        if (str != null) {
            sb.append(str);
        }
        m21173d(sb, abstractC0232e);
    }

    /* renamed from: c */
    public static void m21174c(StringBuilder sb, AbstractC0232e abstractC0232e) {
        if (abstractC0232e.mo21167e() != null) {
            sb.append(C0359h.f720q);
        }
        m21173d(sb, abstractC0232e);
    }

    /* renamed from: d */
    private static void m21173d(StringBuilder sb, AbstractC0232e abstractC0232e) {
        sb.append(abstractC0232e.mo21170b()).append(": ").append(abstractC0232e.mo21172a());
    }
}
