package com.tencent.open;

import android.content.Context;
import android.location.Location;
import com.tencent.map.p224a.p225a.C4225a;
/* renamed from: com.tencent.open.c */
/* loaded from: classes2.dex */
public class C4350c {

    /* renamed from: a */
    private C4356d f18166a;

    /* renamed from: com.tencent.open.c$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4351a {
        void onLocationUpdate(Location location);
    }

    /* renamed from: a */
    public void m5389a(Context context, AbstractC4351a abstractC4351a) {
        this.f18166a = new C4356d(abstractC4351a);
        C4225a.m5824a().m5823a(context, this.f18166a);
    }

    /* renamed from: a */
    public boolean m5390a() {
        return C4225a.m5824a().m5822a("OpenSdk", "WQMPF-XMH66-ISQXP-OIGMM-BNL7M");
    }

    /* renamed from: b */
    public void m5388b() {
        C4225a.m5824a().m5821b();
        this.f18166a = null;
    }
}
