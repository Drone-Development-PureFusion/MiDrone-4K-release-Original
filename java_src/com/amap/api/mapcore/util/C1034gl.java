package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.gl */
/* loaded from: classes.dex */
public class C1034gl {

    /* renamed from: a */
    private static final C1034gl f3238a = new C1034gl();

    /* renamed from: b */
    private final Map<String, AbstractC1033gk> f3239b = new HashMap();

    private C1034gl() {
    }

    /* renamed from: a */
    public static C1034gl m17897a() {
        return f3238a;
    }

    /* renamed from: a */
    private boolean m17895a(C0996fh c0996fh) {
        return c0996fh != null && !TextUtils.isEmpty(c0996fh.m18070b()) && !TextUtils.isEmpty(c0996fh.m18074a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized AbstractC1033gk m17896a(Context context, C0996fh c0996fh) {
        AbstractC1033gk abstractC1033gk;
        if (!m17895a(c0996fh) || context == null) {
            throw new Exception("sdkInfo or context referance is null");
        }
        String m18074a = c0996fh.m18074a();
        abstractC1033gk = this.f3239b.get(m18074a);
        if (abstractC1033gk == null) {
            try {
                C1039go c1039go = new C1039go(context.getApplicationContext(), c0996fh, true);
                try {
                    this.f3239b.put(m18074a, c1039go);
                    C1041gp.m17863a(context, c0996fh);
                    abstractC1033gk = c1039go;
                } catch (Throwable th) {
                    abstractC1033gk = c1039go;
                }
            } catch (Throwable th2) {
            }
        }
        return abstractC1033gk;
    }
}
