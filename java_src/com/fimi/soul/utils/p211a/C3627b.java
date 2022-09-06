package com.fimi.soul.utils.p211a;

import android.content.Context;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.utils.C2284z;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.module.update.C3587b;
import com.fimi.soul.module.update.p210a.C3580b;
/* renamed from: com.fimi.soul.utils.a.b */
/* loaded from: classes.dex */
public class C3627b {
    /* renamed from: a */
    public boolean m7751a(Context context, C2657a c2657a, int i) {
        if (!c2657a.mo11216ac()) {
            C2284z.m12694a(context, context.getString(C2300R.C2303string.front_lights_setting_no_connect), C2284z.f7606b);
            return false;
        }
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        boolean z = c3580b != null && c3580b.m7959a() > 0 && c3580b.m7959a() >= i;
        if (z) {
            return z;
        }
        C2284z.m12694a(context, context.getString(C2300R.C2303string.fc_update_tip), C2284z.f7606b);
        return z;
    }

    /* renamed from: b */
    public boolean m7750b(Context context, C2657a c2657a, int i) {
        C3580b c3580b = (C3580b) C2238c.m13125c().mo13118a(C3587b.f14534C, C3580b.class);
        if (c3580b == null) {
            c3580b = new C3580b();
        }
        return c3580b != null && c3580b.m7959a() > 0 && c3580b.m7959a() >= i;
    }
}
