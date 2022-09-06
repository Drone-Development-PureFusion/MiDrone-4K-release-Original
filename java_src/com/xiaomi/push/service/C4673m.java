package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
/* renamed from: com.xiaomi.push.service.m */
/* loaded from: classes2.dex */
public class C4673m {

    /* renamed from: a */
    private static volatile C4673m f19123a;

    /* renamed from: b */
    private SharedPreferences f19124b;

    private C4673m(Context context) {
        this.f19124b = context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a */
    public static C4673m m4201a(Context context) {
        if (f19123a == null) {
            synchronized (C4673m.class) {
                if (f19123a == null) {
                    f19123a = new C4673m(context);
                }
            }
        }
        return f19123a;
    }

    /* renamed from: a */
    public synchronized void m4202a() {
        SharedPreferences.Editor edit = this.f19124b.edit();
        edit.remove(Constants.EXTRA_KEY_MIID);
        edit.commit();
    }

    /* renamed from: a */
    public synchronized void m4200a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        SharedPreferences.Editor edit = this.f19124b.edit();
        edit.putString(Constants.EXTRA_KEY_MIID, str);
        edit.commit();
    }

    /* renamed from: b */
    public synchronized String m4199b() {
        return this.f19124b.getString(Constants.EXTRA_KEY_MIID, "0");
    }

    /* renamed from: c */
    public synchronized boolean m4198c() {
        return !TextUtils.equals("0", m4199b());
    }
}
