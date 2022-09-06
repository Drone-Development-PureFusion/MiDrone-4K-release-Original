package com.amap.api.services.core;

import android.content.Context;
import java.util.List;
/* renamed from: com.amap.api.services.core.an */
/* loaded from: classes.dex */
public class C1178an {

    /* renamed from: a */
    private C1173ai f4024a;

    /* renamed from: b */
    private Context f4025b;

    public C1178an(Context context) {
        this.f4025b = context;
        this.f4024a = m17212a(this.f4025b);
    }

    /* renamed from: a */
    private C1173ai m17212a(Context context) {
        try {
            return new C1173ai(context);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "SDKDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<C1166ad> m17213a() {
        try {
            C1179ao c1179ao = new C1179ao();
            return this.f4024a.m17235c(C1179ao.m17205c(), c1179ao);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m17211a(C1166ad c1166ad) {
        if (c1166ad == null) {
            return;
        }
        try {
            if (this.f4024a == null) {
                this.f4024a = m17212a(this.f4025b);
            }
            C1179ao c1179ao = new C1179ao();
            c1179ao.mo17198a((C1179ao) c1166ad);
            String m17208a = C1179ao.m17208a(c1166ad.m17264a());
            List m17235c = this.f4024a.m17235c(m17208a, new C1179ao());
            if (m17235c == null || m17235c.size() == 0) {
                this.f4024a.m17239a(c1179ao);
            } else {
                this.f4024a.m17236b(m17208a, c1179ao);
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "SDKDB", "insert");
            th.printStackTrace();
        }
    }
}
