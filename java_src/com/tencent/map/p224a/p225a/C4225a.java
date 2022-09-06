package com.tencent.map.p224a.p225a;

import android.content.Context;
import com.tencent.map.p226b.C4246f;
/* renamed from: com.tencent.map.a.a.a */
/* loaded from: classes.dex */
public class C4225a {

    /* renamed from: a */
    private static C4246f f17518a = C4246f.m5767a();

    /* renamed from: b */
    private static C4225a f17519b;

    /* renamed from: a */
    public static synchronized C4225a m5824a() {
        C4225a c4225a;
        synchronized (C4225a.class) {
            if (f17519b == null) {
                f17519b = new C4225a();
            }
            c4225a = f17519b;
        }
        return c4225a;
    }

    /* renamed from: a */
    public boolean m5823a(Context context, C4226b c4226b) {
        return f17518a.m5764a(context, c4226b);
    }

    /* renamed from: a */
    public boolean m5822a(String str, String str2) {
        return f17518a.m5750a(str, str2);
    }

    /* renamed from: b */
    public void m5821b() {
        f17518a.m5747b();
    }
}
