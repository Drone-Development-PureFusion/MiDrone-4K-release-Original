package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.fr */
/* loaded from: classes.dex */
public class C1012fr extends AbstractC1013fs {

    /* renamed from: a */
    private static boolean f3187a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1012fr(int i) {
        super(i);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1013fs
    /* renamed from: a */
    protected String mo17991a(List<C0996fh> list) {
        return null;
    }

    @Override // com.amap.api.mapcore.util.AbstractC1013fs
    /* renamed from: a */
    protected boolean mo18005a(Context context) {
        boolean z = true;
        if (C0989fc.m18117m(context) != 1 || !f3187a) {
            return false;
        }
        f3187a = false;
        synchronized (Looper.getMainLooper()) {
            C1028gf c1028gf = new C1028gf(context);
            C1029gg m17928a = c1028gf.m17928a();
            if (m17928a != null) {
                if (m17928a.m17923b()) {
                    m17928a.m17922b(false);
                    c1028gf.m17926a(m17928a);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
