package com.tencent.stat.common;

import android.content.Context;
/* renamed from: com.tencent.stat.common.f */
/* loaded from: classes2.dex */
public class C4415f {

    /* renamed from: a */
    static long f18437a = -1;

    /* renamed from: a */
    static long m5221a(Context context, String str) {
        return C4425p.m5153a(context, str, f18437a);
    }

    /* renamed from: a */
    static void m5220a(Context context, String str, long j) {
        C4425p.m5150b(context, str, j);
    }

    /* renamed from: a */
    public static synchronized boolean m5222a(Context context) {
        boolean z;
        synchronized (C4415f.class) {
            long m5221a = m5221a(context, "1.6.2_begin_protection");
            long m5221a2 = m5221a(context, "1.6.2_end__protection");
            if (m5221a <= 0 || m5221a2 != f18437a) {
                if (m5221a == f18437a) {
                    m5220a(context, "1.6.2_begin_protection", System.currentTimeMillis());
                }
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static synchronized void m5219b(Context context) {
        synchronized (C4415f.class) {
            if (m5221a(context, "1.6.2_end__protection") == f18437a) {
                m5220a(context, "1.6.2_end__protection", System.currentTimeMillis());
            }
        }
    }
}
