package com.p080b;

import android.content.Context;
import java.util.List;
/* renamed from: com.b.t */
/* loaded from: classes.dex */
public class C1574t {

    /* renamed from: a */
    private C1565k f5611a;

    /* renamed from: b */
    private Context f5612b;

    public C1574t(Context context) {
        this.f5612b = context;
        this.f5611a = m15453a(this.f5612b);
    }

    /* renamed from: a */
    private C1565k m15453a(Context context) {
        try {
            return new C1565k(context, C1568n.m15484c());
        } catch (Throwable th) {
            C1450b.m16187a(th, "UpdateLogDB", "getDB");
            return null;
        }
    }

    /* renamed from: a */
    public C1576v m15454a() {
        try {
            if (this.f5611a == null) {
                this.f5611a = m15453a(this.f5612b);
            }
            List m15489c = this.f5611a.m15489c("1=1", new C1575u());
            if (m15489c.size() > 0) {
                return (C1576v) m15489c.get(0);
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "UpdateLogDB", "getUpdateLog");
        }
        return null;
    }

    /* renamed from: a */
    public void m15452a(C1576v c1576v) {
        if (c1576v == null) {
            return;
        }
        try {
            if (this.f5611a == null) {
                this.f5611a = m15453a(this.f5612b);
            }
            C1575u c1575u = new C1575u();
            c1575u.mo15448a((C1575u) c1576v);
            List m15489c = this.f5611a.m15489c("1=1", new C1575u());
            if (m15489c == null || m15489c.size() == 0) {
                this.f5611a.m15499a(c1575u);
            } else {
                this.f5611a.m15492b("1=1", c1575u);
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "UpdateLogDB", "updateLog");
        }
    }
}
