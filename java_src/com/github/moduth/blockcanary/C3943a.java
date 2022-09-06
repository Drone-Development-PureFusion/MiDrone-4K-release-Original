package com.github.moduth.blockcanary;

import android.content.ComponentName;
import android.content.Context;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import com.github.moduth.blockcanary.p216ui.DisplayBlockActivity;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* renamed from: com.github.moduth.blockcanary.a */
/* loaded from: classes.dex */
public final class C3943a {

    /* renamed from: a */
    private static final String f16871a = "BlockCanary";

    /* renamed from: b */
    private static C3943a f16872b;

    /* renamed from: e */
    private static final Executor f16873e = m6416a("File-IO");

    /* renamed from: d */
    private boolean f16875d = false;

    /* renamed from: c */
    private C3953c f16874c = C3953c.m6385a();

    private C3943a() {
        C3953c.m6383a(C3946b.m6406d());
        m6408g();
    }

    /* renamed from: a */
    public static C3943a m6420a() {
        if (f16872b == null) {
            synchronized (C3943a.class) {
                if (f16872b == null) {
                    f16872b = new C3943a();
                }
            }
        }
        return f16872b;
    }

    /* renamed from: a */
    public static C3943a m6419a(Context context, C3946b c3946b) {
        C3946b.m6407a(context, c3946b);
        m6412c(context, DisplayBlockActivity.class, C3946b.m6406d().mo6367b());
        return m6420a();
    }

    /* renamed from: a */
    private static Executor m6416a(String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactoryC3964i(str));
    }

    /* renamed from: a */
    private static void m6417a(Runnable runnable) {
        f16873e.execute(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m6414b(Context context, Class<?> cls, boolean z) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), z ? 1 : 2, 1);
    }

    /* renamed from: c */
    private static void m6412c(Context context, final Class<?> cls, final boolean z) {
        final Context applicationContext = context.getApplicationContext();
        m6417a(new Runnable() { // from class: com.github.moduth.blockcanary.a.1
            @Override // java.lang.Runnable
            public void run() {
                C3943a.m6414b(applicationContext, cls, z);
            }
        });
    }

    /* renamed from: g */
    private void m6408g() {
        if (!C3946b.m6406d().mo6367b()) {
            return;
        }
        try {
            Class<?> cls = Class.forName("com.github.moduth.blockcanary.ui.c");
            if (cls == null) {
                return;
            }
            this.f16874c.m6381a((AbstractC3969l) cls.getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception e) {
            Log.e(f16871a, "initNotification: ", e);
        }
    }

    /* renamed from: b */
    public void m6415b() {
        if (!this.f16875d) {
            this.f16875d = true;
            Looper.getMainLooper().setMessageLogging(this.f16874c.f16944a);
        }
    }

    /* renamed from: c */
    public void m6413c() {
        if (this.f16875d) {
            this.f16875d = false;
            Looper.getMainLooper().setMessageLogging(null);
            this.f16874c.f16945b.d();
            this.f16874c.f16946c.d();
        }
    }

    /* renamed from: d */
    public void m6411d() {
        C3973o.m6343a();
    }

    /* renamed from: e */
    public void m6410e() {
        PreferenceManager.getDefaultSharedPreferences(C3946b.m6406d().mo6365e()).edit().putLong("BlockCanary_StartTime", System.currentTimeMillis()).commit();
    }

    /* renamed from: f */
    public boolean m6409f() {
        long j = PreferenceManager.getDefaultSharedPreferences(C3946b.m6406d().mo6365e()).getLong("BlockCanary_StartTime", 0L);
        return j != 0 && System.currentTimeMillis() - j > ((long) ((C3946b.m6406d().m6405i() * 3600) * 1000));
    }
}
