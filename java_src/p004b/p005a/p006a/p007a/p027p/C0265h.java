package p004b.p005a.p006a.p007a.p027p;

import p004b.p005a.p006a.p007a.C0151f;
import p004b.p005a.p006a.p028b.p054o.AbstractC0526e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p055p.AbstractC0549i;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.a.p.h */
/* loaded from: classes.dex */
public class C0265h {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m21103a(C0151f c0151f) {
        String m20056c = C0589u.m20056c(C0258a.f454c);
        if (!C0589u.m20054e(m20056c)) {
            m21101a(c0151f, m20056c);
        }
    }

    /* renamed from: a */
    private static void m21102a(C0151f c0151f, AbstractC0549i abstractC0549i) {
        if (abstractC0549i != null) {
            if (abstractC0549i instanceof AbstractC0526e) {
                ((AbstractC0526e) abstractC0549i).mo20233a(c0151f);
            }
            if (abstractC0549i instanceof AbstractC0534m) {
                ((AbstractC0534m) abstractC0549i).mo20156j();
            }
            c0151f.n().mo20187a(abstractC0549i);
        }
    }

    /* renamed from: a */
    private static void m21101a(C0151f c0151f, String str) {
        m21102a(c0151f, m21100b(c0151f, str));
    }

    /* renamed from: b */
    private static AbstractC0549i m21100b(C0151f c0151f, String str) {
        try {
            return (AbstractC0549i) C0589u.m20064a(str, AbstractC0549i.class, c0151f);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
