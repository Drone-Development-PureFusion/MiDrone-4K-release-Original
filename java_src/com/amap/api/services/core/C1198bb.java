package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.bb */
/* loaded from: classes.dex */
public class C1198bb extends AbstractC1207bg {

    /* renamed from: a */
    private static boolean f4071a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1198bb(Context context) {
        super(context);
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: a */
    protected String mo17163a() {
        return C1204bf.f4081c;
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: a */
    protected boolean mo17162a(Context context) {
        boolean z = true;
        if (f4071a) {
            f4071a = false;
            synchronized (Looper.getMainLooper()) {
                C1181aq c1181aq = new C1181aq(context);
                C1183as m17204a = c1181aq.m17204a();
                if (m17204a != null) {
                    if (m17204a.m17195a()) {
                        m17204a.m17194a(false);
                        c1181aq.m17202a(m17204a);
                    } else {
                        z = false;
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: b */
    protected int mo17155b() {
        return 0;
    }
}
