package com.p080b;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;
/* renamed from: com.b.e */
/* loaded from: classes.dex */
public class C1555e extends AbstractC1561h {

    /* renamed from: a */
    private static boolean f5544a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1555e(int i) {
        super(i);
    }

    @Override // com.p080b.AbstractC1561h
    /* renamed from: a */
    protected String mo15528a(String str) {
        return C1545ds.m15594c(str + C1552dw.m15562a(new Date().getTime()));
    }

    @Override // com.p080b.AbstractC1561h
    /* renamed from: a */
    protected String mo15525a(List<C1549dv> list) {
        return null;
    }

    @Override // com.p080b.AbstractC1561h
    /* renamed from: a */
    protected boolean mo15538a(Context context) {
        boolean z = true;
        if (f5544a) {
            f5544a = false;
            synchronized (Looper.getMainLooper()) {
                C1574t c1574t = new C1574t(context);
                C1576v m15454a = c1574t.m15454a();
                if (m15454a != null) {
                    if (m15454a.m15445a()) {
                        m15454a.m15444a(false);
                        c1574t.m15452a(m15454a);
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
