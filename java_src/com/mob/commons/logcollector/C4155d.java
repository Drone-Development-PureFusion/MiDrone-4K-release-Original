package com.mob.commons.logcollector;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;
/* renamed from: com.mob.commons.logcollector.d */
/* loaded from: classes.dex */
public class C4155d {

    /* renamed from: a */
    private static C4155d f17333a;

    /* renamed from: b */
    private SharePrefrenceHelper f17334b;

    private C4155d(Context context) {
        this.f17334b = new SharePrefrenceHelper(context.getApplicationContext());
        this.f17334b.open("mob_sdk_exception", 1);
    }

    /* renamed from: a */
    public static C4155d m5986a(Context context) {
        if (f17333a == null) {
            f17333a = new C4155d(context);
        }
        return f17333a;
    }

    /* renamed from: a */
    public long m5989a() {
        return this.f17334b.getLong("service_time");
    }

    /* renamed from: a */
    public void m5988a(int i) {
        this.f17334b.putInt("is_upload_crash", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m5987a(long j) {
        this.f17334b.putLong("service_time", Long.valueOf(j));
    }

    /* renamed from: a */
    public void m5985a(String str) {
        this.f17334b.putString("err_log_filter", str);
    }

    /* renamed from: a */
    public void m5984a(boolean z) {
        this.f17334b.putInt("is_upload_err_log", Integer.valueOf(z ? 0 : 1));
    }

    /* renamed from: b */
    public void m5982b(int i) {
        this.f17334b.putInt("is_upload_sdkerr", Integer.valueOf(i));
    }

    /* renamed from: b */
    public boolean m5983b() {
        return this.f17334b.getInt("is_upload_err_log") == 0;
    }

    /* renamed from: c */
    public int m5981c() {
        return this.f17334b.getInt("is_upload_crash");
    }

    /* renamed from: c */
    public void m5980c(int i) {
        this.f17334b.putInt("is_upload_apperr", Integer.valueOf(i));
    }

    /* renamed from: d */
    public int m5979d() {
        return this.f17334b.getInt("is_upload_sdkerr");
    }

    /* renamed from: e */
    public int m5978e() {
        return this.f17334b.getInt("is_upload_apperr");
    }

    /* renamed from: f */
    public String m5977f() {
        return this.f17334b.getString("err_log_filter");
    }
}
