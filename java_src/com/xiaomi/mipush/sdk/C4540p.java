package com.xiaomi.mipush.sdk;

import android.content.Context;
/* renamed from: com.xiaomi.mipush.sdk.p */
/* loaded from: classes.dex */
public class C4540p {

    /* renamed from: a */
    private static C4540p f18655a = null;

    /* renamed from: b */
    private Context f18656b;

    /* renamed from: c */
    private C4534j f18657c = new C4534j();

    private C4540p(Context context) {
        this.f18656b = context.getApplicationContext();
        if (this.f18656b == null) {
            this.f18656b = context;
        }
    }

    /* renamed from: a */
    public static C4540p m4845a(Context context) {
        if (f18655a == null) {
            synchronized (C4540p.class) {
                if (f18655a == null) {
                    f18655a = new C4540p(context);
                }
            }
        }
        return f18655a;
    }

    /* renamed from: a */
    public synchronized String m4846a() {
        return this.f18656b.getSharedPreferences(MiPushClient.PREF_EXTRA, 0).getString("enable_disable_sync_status", "");
    }

    /* renamed from: a */
    public void m4844a(String str) {
        synchronized (this) {
            if (this.f18657c == null) {
                this.f18657c = new C4534j();
            }
            this.f18657c.f18647a = 0;
            this.f18657c.f18648b = str;
        }
    }

    /* renamed from: b */
    public void m4843b(String str) {
        synchronized (this) {
            if (this.f18657c == null) {
                this.f18657c = new C4534j();
            }
            this.f18657c.f18647a++;
            this.f18657c.f18648b = str;
        }
    }

    /* renamed from: c */
    public int m4842c(String str) {
        int i;
        synchronized (this) {
            i = (this.f18657c == null || !this.f18657c.f18648b.equals(str)) ? 0 : this.f18657c.f18647a;
        }
        return i;
    }

    /* renamed from: d */
    public void m4841d(String str) {
        synchronized (this) {
            if (this.f18657c != null && this.f18657c.f18648b.equals(str)) {
                this.f18657c = null;
            }
        }
    }

    /* renamed from: e */
    public boolean m4840e(String str) {
        boolean z;
        synchronized (this) {
            z = this.f18657c != null && this.f18657c.f18648b.equals(str);
        }
        return z;
    }

    /* renamed from: f */
    public synchronized void m4839f(String str) {
        this.f18656b.getSharedPreferences(MiPushClient.PREF_EXTRA, 0).edit().putString("enable_disable_sync_status", str).commit();
    }
}
