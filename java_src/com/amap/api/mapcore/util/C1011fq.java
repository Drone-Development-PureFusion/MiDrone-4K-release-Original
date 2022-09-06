package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.fq */
/* loaded from: classes.dex */
public class C1011fq extends AbstractC1013fs {

    /* renamed from: a */
    private static boolean f3186a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1011fq(int i) {
        super(i);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1013fs
    /* renamed from: a */
    protected String mo17994a(String str) {
        return C0992fe.m18090c(str + C0999fi.m18052a(new Date().getTime()));
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
        if (f3186a) {
            f3186a = false;
            synchronized (Looper.getMainLooper()) {
                C1028gf c1028gf = new C1028gf(context);
                C1029gg m17928a = c1028gf.m17928a();
                if (m17928a != null) {
                    if (m17928a.m17925a()) {
                        m17928a.m17924a(false);
                        c1028gf.m17926a(m17928a);
                    } else {
                        z = false;
                    }
                }
            }
            return z;
        }
        return false;
    }
}
