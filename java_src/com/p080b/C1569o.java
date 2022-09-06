package com.p080b;

import android.content.Context;
import java.util.List;
/* renamed from: com.b.o */
/* loaded from: classes.dex */
public class C1569o {

    /* renamed from: a */
    private C1565k f5591a;

    public C1569o(Context context) {
        this.f5591a = new C1565k(context, C1568n.m15484c());
    }

    /* renamed from: a */
    private void m15481a(C1571q c1571q, C1570p c1570p) {
        c1570p.mo15448a(c1571q);
        this.f5591a.m15499a(c1570p);
    }

    /* renamed from: b */
    private void m15478b(C1571q c1571q, C1570p c1570p) {
        String m15473a = C1570p.m15473a(c1571q.m15468b());
        List m15491b = this.f5591a.m15491b(m15473a, c1570p, true);
        if (m15491b == null || m15491b.size() == 0) {
            c1570p.mo15448a(c1571q);
            this.f5591a.m15497a((AbstractC1566l) c1570p, true);
            return;
        }
        C1571q c1571q2 = (C1571q) m15491b.get(0);
        if (c1571q.m15471a() == 0) {
            c1571q2.m15467b(c1571q2.m15464d() + 1);
        } else {
            c1571q2.m15467b(0);
        }
        c1570p.mo15448a(c1571q2);
        this.f5591a.m15492b(m15473a, c1570p);
    }

    /* renamed from: c */
    private void m15476c(String str, int i) {
        this.f5591a.m15496a(C1570p.m15473a(str), new C1570p(i));
    }

    /* renamed from: a */
    public List<C1571q> m15483a(int i, int i2) {
        try {
            C1570p c1570p = new C1570p(i2);
            return this.f5591a.m15489c(C1570p.m15475a(i), c1570p);
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogDB", "ByState");
            return null;
        }
    }

    /* renamed from: a */
    public void m15482a(C1571q c1571q, int i) {
        try {
            C1570p c1570p = new C1570p(i);
            c1570p.mo15448a((C1570p) c1571q);
            this.f5591a.m15492b(C1570p.m15473a(c1571q.m15468b()), c1570p);
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogDB", "updateLogInfo");
        }
    }

    /* renamed from: a */
    public void m15480a(String str, int i) {
        try {
            m15476c(str, i);
        } catch (Throwable th) {
            C1450b.m16187a(th, "LogDB", "delLog");
        }
    }

    /* renamed from: b */
    public void m15479b(C1571q c1571q, int i) {
        try {
            C1570p c1570p = new C1570p(i);
            switch (i) {
                case 0:
                    m15481a(c1571q, c1570p);
                    break;
                case 1:
                    m15478b(c1571q, c1570p);
                    break;
                case 2:
                    m15478b(c1571q, c1570p);
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m15477b(String str, int i) {
        try {
            m15476c(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
