package com.tencent.map.p226b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
/* renamed from: com.tencent.map.b.l */
/* loaded from: classes.dex */
public final class C4262l {

    /* renamed from: b */
    private static C4262l f17732b;

    /* renamed from: a */
    private Context f17733a;

    private C4262l() {
    }

    /* renamed from: a */
    public static C4262l m5675a() {
        if (f17732b == null) {
            f17732b = new C4262l();
        }
        return f17732b;
    }

    /* renamed from: b */
    public static Context m5673b() {
        return m5675a().f17733a;
    }

    /* renamed from: c */
    public static boolean m5672c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) m5675a().f17733a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m5671d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) m5675a().f17733a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: a */
    public final void m5674a(Context context) {
        if (this.f17733a == null) {
            this.f17733a = context.getApplicationContext();
        }
    }
}
