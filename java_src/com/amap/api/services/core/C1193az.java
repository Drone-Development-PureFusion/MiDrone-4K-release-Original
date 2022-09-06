package com.amap.api.services.core;

import android.content.Context;
import android.os.Looper;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.az */
/* loaded from: classes.dex */
public class C1193az extends AbstractC1207bg {

    /* renamed from: a */
    private static boolean f4060a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1193az(Context context) {
        super(context);
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: a */
    protected String mo17163a() {
        return C1204bf.f4082d;
    }

    @Override // com.amap.api.services.core.AbstractC1207bg
    /* renamed from: a */
    protected boolean mo17162a(Context context) {
        boolean z = true;
        if (C1262z.m16898g(context) != 1 || !f4060a) {
            return false;
        }
        f4060a = false;
        synchronized (Looper.getMainLooper()) {
            C1181aq c1181aq = new C1181aq(context);
            C1183as m17204a = c1181aq.m17204a();
            if (m17204a != null) {
                if (m17204a.m17191c()) {
                    m17204a.m17190c(false);
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
        return 2;
    }
}
