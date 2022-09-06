package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.gf */
/* loaded from: classes.dex */
public class C1028gf {

    /* renamed from: a */
    private C1016fu f3212a;

    /* renamed from: b */
    private Context f3213b;

    public C1028gf(Context context) {
        this.f3213b = context;
        this.f3212a = m17927a(this.f3213b);
    }

    /* renamed from: a */
    private C1016fu m17927a(Context context) {
        try {
            return new C1016fu(context, C1016fu.m17968a((Class<? extends AbstractC1015ft>) C1024gb.class));
        } catch (Throwable th) {
            C1002fl.m18028a(th, "UpdateLogDB", "getDB");
            return null;
        }
    }

    /* renamed from: a */
    public C1029gg m17928a() {
        try {
            if (this.f3212a == null) {
                this.f3212a = m17927a(this.f3213b);
            }
            List m17952b = this.f3212a.m17952b("1=1", C1029gg.class);
            if (m17952b.size() > 0) {
                return (C1029gg) m17952b.get(0);
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "UpdateLogDB", "getUpdateLog");
        }
        return null;
    }

    /* renamed from: a */
    public void m17926a(C1029gg c1029gg) {
        if (c1029gg == null) {
            return;
        }
        try {
            if (this.f3212a == null) {
                this.f3212a = m17927a(this.f3213b);
            }
            List m17952b = this.f3212a.m17952b("1=1", C1029gg.class);
            if (m17952b == null || m17952b.size() == 0) {
                this.f3212a.m17966a((C1016fu) c1029gg);
            } else {
                this.f3212a.m17959a("1=1", c1029gg);
            }
        } catch (Throwable th) {
            C1002fl.m18028a(th, "UpdateLogDB", "updateLog");
        }
    }
}
