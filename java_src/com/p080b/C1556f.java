package com.p080b;

import android.content.Context;
import android.os.Looper;
import java.util.List;
/* renamed from: com.b.f */
/* loaded from: classes.dex */
public class C1556f extends AbstractC1561h {

    /* renamed from: a */
    private static boolean f5545a = true;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1556f(int i) {
        super(i);
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
        if (C1542dq.m15619m(context) != 1 || !f5545a) {
            return false;
        }
        f5545a = false;
        synchronized (Looper.getMainLooper()) {
            C1574t c1574t = new C1574t(context);
            C1576v m15454a = c1574t.m15454a();
            if (m15454a != null) {
                if (m15454a.m15443b()) {
                    m15454a.m15442b(false);
                    c1574t.m15452a(m15454a);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
