package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.service.p */
/* loaded from: classes.dex */
public class C4685p {

    /* renamed from: a */
    private static C4685p f19173a = null;

    /* renamed from: b */
    private Context f19174b;

    /* renamed from: c */
    private List<String> f19175c = new ArrayList();

    /* renamed from: d */
    private final List<String> f19176d = new ArrayList();

    /* renamed from: e */
    private final List<String> f19177e = new ArrayList();

    private C4685p(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        this.f19174b = context.getApplicationContext();
        if (this.f19174b == null) {
            this.f19174b = context;
        }
        SharedPreferences sharedPreferences = this.f19174b.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f19175c.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f19176d.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f19177e.add(str3);
            }
        }
    }

    /* renamed from: a */
    public static C4685p m4130a(Context context) {
        if (f19173a == null) {
            f19173a = new C4685p(context);
        }
        return f19173a;
    }

    /* renamed from: a */
    public boolean m4129a(String str) {
        boolean contains;
        synchronized (this.f19175c) {
            contains = this.f19175c.contains(str);
        }
        return contains;
    }

    /* renamed from: b */
    public boolean m4128b(String str) {
        boolean contains;
        synchronized (this.f19176d) {
            contains = this.f19176d.contains(str);
        }
        return contains;
    }

    /* renamed from: c */
    public boolean m4127c(String str) {
        boolean contains;
        synchronized (this.f19177e) {
            contains = this.f19177e.contains(str);
        }
        return contains;
    }

    /* renamed from: d */
    public void m4126d(String str) {
        synchronized (this.f19175c) {
            if (!this.f19175c.contains(str)) {
                this.f19175c.add(str);
                this.f19174b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C4507d.m4947a(this.f19175c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: e */
    public void m4125e(String str) {
        synchronized (this.f19176d) {
            if (!this.f19176d.contains(str)) {
                this.f19176d.add(str);
                this.f19174b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C4507d.m4947a(this.f19176d, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: f */
    public void m4124f(String str) {
        synchronized (this.f19177e) {
            if (!this.f19177e.contains(str)) {
                this.f19177e.add(str);
                this.f19174b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C4507d.m4947a(this.f19177e, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: g */
    public void m4123g(String str) {
        synchronized (this.f19175c) {
            if (this.f19175c.contains(str)) {
                this.f19175c.remove(str);
                this.f19174b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", C4507d.m4947a(this.f19175c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: h */
    public void m4122h(String str) {
        synchronized (this.f19176d) {
            if (this.f19176d.contains(str)) {
                this.f19176d.remove(str);
                this.f19174b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", C4507d.m4947a(this.f19176d, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    /* renamed from: i */
    public void m4121i(String str) {
        synchronized (this.f19177e) {
            if (this.f19177e.contains(str)) {
                this.f19177e.remove(str);
                this.f19174b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", C4507d.m4947a(this.f19177e, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
