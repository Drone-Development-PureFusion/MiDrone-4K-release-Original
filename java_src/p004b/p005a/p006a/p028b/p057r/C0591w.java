package p004b.p005a.p006a.p028b.p057r;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p033e.C0290c;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0552l;
/* renamed from: b.a.a.b.r.w */
/* loaded from: classes.dex */
public class C0591w {

    /* renamed from: b */
    private static PrintStream f1321b = System.out;

    /* renamed from: a */
    static C0568b f1320a = new C0568b("HH:mm:ss,SSS");

    /* renamed from: a */
    public static void m20053a(AbstractC0292f abstractC0292f) {
        m20052a(abstractC0292f, 0L);
    }

    /* renamed from: a */
    public static void m20052a(AbstractC0292f abstractC0292f, long j) {
        if (abstractC0292f == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        AbstractC0551k mo20997n = abstractC0292f.mo20997n();
        if (mo20997n == null) {
            f1321b.println("WARN: Context named \"" + abstractC0292f.mo20996p() + "\" has no status manager");
        } else if (new C0552l(abstractC0292f).m20167c(j) < 1) {
        } else {
            m20050a(mo20997n, j);
        }
    }

    /* renamed from: a */
    public static void m20051a(AbstractC0551k abstractC0551k) {
        m20050a(abstractC0551k, 0L);
    }

    /* renamed from: a */
    public static void m20050a(AbstractC0551k abstractC0551k, long j) {
        StringBuilder sb = new StringBuilder();
        m20046a(sb, C0552l.m20171a(abstractC0551k.mo20189a(), j));
        f1321b.println(sb.toString());
    }

    /* renamed from: a */
    public static void m20049a(PrintStream printStream) {
        f1321b = printStream;
    }

    /* renamed from: a */
    public static void m20048a(StringBuilder sb, String str, AbstractC0547g abstractC0547g) {
        String str2 = abstractC0547g.mo20193g() ? str + "+ " : str + "|-";
        if (f1320a != null) {
            sb.append(f1320a.m20122a(abstractC0547g.mo20194f().longValue())).append(" ");
        }
        sb.append(str2).append(abstractC0547g).append(C0359h.f706c);
        if (abstractC0547g.mo20195e() != null) {
            m20047a(sb, abstractC0547g.mo20195e());
        }
        if (abstractC0547g.mo20193g()) {
            Iterator<AbstractC0547g> mo20192h = abstractC0547g.mo20192h();
            while (mo20192h.hasNext()) {
                m20048a(sb, str + "  ", mo20192h.next());
            }
        }
    }

    /* renamed from: a */
    private static void m20047a(StringBuilder sb, Throwable th) {
        String[] m21025a;
        for (String str : C0290c.m21025a(th)) {
            if (!str.startsWith(C0359h.f718o)) {
                if (Character.isDigit(str.charAt(0))) {
                    sb.append("\t... ");
                } else {
                    sb.append("\tat ");
                }
            }
            sb.append(str).append(C0359h.f706c);
        }
    }

    /* renamed from: a */
    private static void m20046a(StringBuilder sb, List<AbstractC0547g> list) {
        if (list == null) {
            return;
        }
        for (AbstractC0547g abstractC0547g : list) {
            m20048a(sb, "", abstractC0547g);
        }
    }

    /* renamed from: a */
    public static void m20045a(List<AbstractC0547g> list) {
        StringBuilder sb = new StringBuilder();
        m20046a(sb, list);
        f1321b.println(sb.toString());
    }

    /* renamed from: b */
    public static void m20044b(AbstractC0292f abstractC0292f) {
        if (abstractC0292f == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        AbstractC0551k mo20997n = abstractC0292f.mo20997n();
        if (mo20997n == null) {
            f1321b.println("WARN: Context named \"" + abstractC0292f.mo20996p() + "\" has no status manager");
        } else if (new C0552l(abstractC0292f).m20167c(0L) != 2) {
        } else {
            m20051a(mo20997n);
        }
    }

    /* renamed from: b */
    public static void m20043b(AbstractC0292f abstractC0292f, long j) {
        if (abstractC0292f == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        AbstractC0551k mo20997n = abstractC0292f.mo20997n();
        if (mo20997n == null) {
            f1321b.println("WARN: Context named \"" + abstractC0292f.mo20996p() + "\" has no status manager");
        } else {
            m20050a(mo20997n, j);
        }
    }

    /* renamed from: c */
    public static void m20042c(AbstractC0292f abstractC0292f) {
        m20043b(abstractC0292f, 0L);
    }
}
