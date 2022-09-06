package com.amap.api.services.core;

import android.content.Context;
import java.util.List;
/* renamed from: com.amap.api.services.core.aq */
/* loaded from: classes.dex */
public class C1181aq {

    /* renamed from: a */
    private C1173ai f4033a;

    /* renamed from: b */
    private Context f4034b;

    public C1181aq(Context context) {
        this.f4034b = context;
        this.f4033a = m17203a(this.f4034b);
    }

    /* renamed from: a */
    private C1173ai m17203a(Context context) {
        try {
            return new C1173ai(context);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "UpdateLogDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public C1183as m17204a() {
        try {
            if (this.f4033a == null) {
                this.f4033a = m17203a(this.f4034b);
            }
            List m17235c = this.f4033a.m17235c("1=1", new C1182ar());
            if (m17235c.size() > 0) {
                return (C1183as) m17235c.get(0);
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "UpdateLogDB", "getUpdateLog");
            th.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public void m17202a(C1183as c1183as) {
        if (c1183as == null) {
            return;
        }
        try {
            if (this.f4033a == null) {
                this.f4033a = m17203a(this.f4034b);
            }
            C1182ar c1182ar = new C1182ar();
            c1182ar.mo17198a((C1182ar) c1183as);
            List m17235c = this.f4033a.m17235c("1=1", new C1182ar());
            if (m17235c == null || m17235c.size() == 0) {
                this.f4033a.m17239a(c1182ar);
            } else {
                this.f4033a.m17236b("1=1", c1182ar);
            }
        } catch (Throwable th) {
            C1190ay.m17177a(th, "UpdateLogDB", "updateLog");
            th.printStackTrace();
        }
    }
}
