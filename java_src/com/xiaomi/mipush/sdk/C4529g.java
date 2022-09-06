package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.metok.geofencing.C4513a;
import com.xiaomi.xmpush.thrift.C4809j;
import com.xiaomi.xmpush.thrift.C4812l;
/* renamed from: com.xiaomi.mipush.sdk.g */
/* loaded from: classes2.dex */
public class C4529g {

    /* renamed from: a */
    private final int f18638a = -1;

    /* renamed from: b */
    private final double f18639b = 0.0d;

    /* renamed from: c */
    private C4513a f18640c;

    /* renamed from: d */
    private Context f18641d;

    public C4529g(Context context) {
        this.f18641d = context;
        m4860a();
    }

    /* renamed from: a */
    private void m4860a() {
        this.f18640c = new C4513a(this.f18641d);
    }

    /* renamed from: a */
    public void m4858a(String str) {
        this.f18640c.m4936a(this.f18641d, "com.xiaomi.xmsf", str);
    }

    /* renamed from: a */
    public boolean m4859a(C4809j c4809j) {
        if (c4809j == null) {
            return false;
        }
        if (c4809j.m3390m() != null && c4809j.m3388o() > 0.0d) {
            C4812l m3390m = c4809j.m3390m();
            this.f18640c.m4937a(this.f18641d, m3390m.m3370c(), m3390m.m3378a(), (float) c4809j.m3388o(), -1L, "com.xiaomi.xmsf", c4809j.m3417a(), c4809j.m3384s().name());
        }
        return true;
    }
}
