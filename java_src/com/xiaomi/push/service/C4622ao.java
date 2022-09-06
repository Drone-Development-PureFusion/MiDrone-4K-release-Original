package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.channel.commonutils.misc.C4479a;
/* renamed from: com.xiaomi.push.service.ao */
/* loaded from: classes.dex */
public class C4622ao {

    /* renamed from: a */
    private static C4622ao f19012a;

    /* renamed from: b */
    private Context f19013b;

    /* renamed from: c */
    private int f19014c = 0;

    private C4622ao(Context context) {
        this.f19013b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C4622ao m4356a(Context context) {
        if (f19012a == null) {
            f19012a = new C4622ao(context);
        }
        return f19012a;
    }

    /* renamed from: a */
    public boolean m4357a() {
        return C4479a.f18537a.contains("xmsf") || C4479a.f18537a.contains("xiaomi") || C4479a.f18537a.contains("miui");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public int m4355b() {
        if (this.f19014c != 0) {
            return this.f19014c;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f19014c = Settings.Global.getInt(this.f19013b.getContentResolver(), "device_provisioned", 0);
            return this.f19014c;
        }
        this.f19014c = Settings.Secure.getInt(this.f19013b.getContentResolver(), "device_provisioned", 0);
        return this.f19014c;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public Uri m4354c() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }
}
