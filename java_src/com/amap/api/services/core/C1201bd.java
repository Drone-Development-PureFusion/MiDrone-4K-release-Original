package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.bd */
/* loaded from: classes.dex */
public class C1201bd extends AbstractC1207bg {

    /* renamed from: a */
    private static boolean f4075a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1201bd(Context context) {
        super(context);
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: a */
    protected String mo17163a() {
        return C1204bf.f4080b;
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: a */
    protected boolean mo17162a(Context context) {
        boolean z = true;
        if (C1262z.m16898g(context) != 1 || !f4075a) {
            return false;
        }
        f4075a = false;
        synchronized (Looper.getMainLooper()) {
            C1181aq c1181aq = new C1181aq(context);
            C1183as m17204a = c1181aq.m17204a();
            if (m17204a != null) {
                if (m17204a.m17193b()) {
                    m17204a.m17192b(false);
                    c1181aq.m17202a(m17204a);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: b */
    protected int mo17155b() {
        return 1;
    }
}
