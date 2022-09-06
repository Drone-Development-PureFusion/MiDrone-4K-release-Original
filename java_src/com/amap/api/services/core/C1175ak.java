package com.amap.api.services.core;

import android.content.Context;
import java.util.List;
/* renamed from: com.amap.api.services.core.ak */
/* loaded from: classes.dex */
public class C1175ak {

    /* renamed from: a */
    private C1173ai f4014a;

    public C1175ak(Context context) {
        this.f4014a = new C1173ai(context);
    }

    /* renamed from: a */
    private AbstractC1176al m17234a(int i) {
        switch (i) {
            case 0:
                return new C1171ag();
            case 1:
                return new C1174aj();
            case 2:
                return new C1170af();
            default:
                return null;
        }
    }

    /* renamed from: a */
    private void m17231a(C1177am c1177am, AbstractC1176al abstractC1176al) {
        abstractC1176al.mo17198a(c1177am);
        this.f4014a.m17239a(abstractC1176al);
    }

    /* renamed from: b */
    private void m17228b(C1177am c1177am, AbstractC1176al abstractC1176al) {
        String m17222a = AbstractC1176al.m17222a(c1177am.m17218b());
        List m17235c = this.f4014a.m17235c(m17222a, abstractC1176al);
        if (m17235c == null || m17235c.size() == 0) {
            abstractC1176al.mo17198a(c1177am);
            this.f4014a.m17239a(abstractC1176al);
            return;
        }
        C1177am c1177am2 = (C1177am) m17235c.get(0);
        if (c1177am.m17221a() == 0) {
            c1177am2.m17217b(c1177am2.m17214d() + 1);
        } else {
            c1177am2.m17217b(0);
        }
        abstractC1176al.mo17198a(c1177am2);
        this.f4014a.m17236b(m17222a, abstractC1176al);
    }

    /* renamed from: c */
    private void m17226c(String str, int i) {
        this.f4014a.m17238a(AbstractC1176al.m17222a(str), m17234a(i));
    }

    /* renamed from: a */
    public List<C1177am> m17233a(int i, int i2) {
        try {
            AbstractC1176al m17234a = m17234a(i2);
            return this.f4014a.m17235c(AbstractC1176al.m17225a(i), m17234a);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogDB", "ByState");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m17232a(C1177am c1177am, int i) {
        try {
            AbstractC1176al m17234a = m17234a(i);
            m17234a.mo17198a((AbstractC1176al) c1177am);
            this.f4014a.m17236b(AbstractC1176al.m17222a(c1177am.m17218b()), m17234a);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogDB", "updateLogInfo");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m17230a(String str, int i) {
        try {
            m17226c(str, i);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "LogDB", "delLog");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m17229b(C1177am c1177am, int i) {
        try {
            AbstractC1176al m17234a = m17234a(i);
            switch (i) {
                case 0:
                    m17231a(c1177am, m17234a);
                    break;
                case 1:
                    m17228b(c1177am, m17234a);
                    break;
                case 2:
                    m17228b(c1177am, m17234a);
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m17227b(String str, int i) {
        try {
            m17226c(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
