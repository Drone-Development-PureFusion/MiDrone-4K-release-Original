package com.p080b;

import android.content.Context;
import java.util.List;
/* renamed from: com.b.r */
/* loaded from: classes.dex */
public class C1572r {

    /* renamed from: a */
    private C1565k f5602a;

    /* renamed from: b */
    private Context f5603b;

    public C1572r(Context context, boolean z) {
        this.f5603b = context;
        this.f5602a = m15462a(this.f5603b, z);
    }

    /* renamed from: a */
    private C1565k m15462a(Context context, boolean z) {
        try {
            return new C1565k(context, C1568n.m15484c());
        } catch (Throwable th) {
            if (!z) {
                C1450b.m16187a(th, "SDKDB", "getDB");
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<C1549dv> m15463a() {
        try {
            C1573s c1573s = new C1573s();
            return this.f5602a.m15491b(C1573s.m15455c(), c1573s, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m15461a(C1549dv c1549dv) {
        if (c1549dv == null) {
            return;
        }
        try {
            if (this.f5602a == null) {
                this.f5602a = m15462a(this.f5603b, false);
            }
            C1573s c1573s = new C1573s();
            c1573s.mo15448a((C1573s) c1549dv);
            String m15459a = C1573s.m15459a(c1549dv.m15580a());
            List m15489c = this.f5602a.m15489c(m15459a, new C1573s());
            if (m15489c == null || m15489c.size() == 0) {
                this.f5602a.m15499a(c1573s);
            } else {
                this.f5602a.m15492b(m15459a, c1573s);
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "SDKDB", "insert");
            th.printStackTrace();
        }
    }
}
