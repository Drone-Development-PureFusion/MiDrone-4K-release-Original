package com.tencent.open.p228a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.p228a.C4324d;
import com.tencent.open.utils.Global;
import java.io.File;
/* renamed from: com.tencent.open.a.f */
/* loaded from: classes.dex */
public class C4331f {

    /* renamed from: b */
    protected C4318a f18120b = new C4318a(f18118c);

    /* renamed from: a */
    public static C4331f f18117a = null;

    /* renamed from: d */
    public static final String f18119d = C4323c.f18093a;

    /* renamed from: c */
    protected static final C4319b f18118c = new C4319b(m5443c(), C4323c.f18111s, C4323c.f18105m, C4323c.f18106n, C4323c.f18100h, C4323c.f18107o, 10, C4323c.f18103k, C4323c.f18112t);

    private C4331f() {
    }

    /* renamed from: a */
    public static C4331f m5450a() {
        if (f18117a == null) {
            synchronized (C4331f.class) {
                if (f18117a == null) {
                    f18117a = new C4331f();
                }
            }
        }
        return f18117a;
    }

    /* renamed from: a */
    public static final void m5448a(String str, String str2) {
        m5450a().m5449a(1, str, str2, null);
    }

    /* renamed from: a */
    public static final void m5447a(String str, String str2, Throwable th) {
        m5450a().m5449a(2, str, str2, th);
    }

    /* renamed from: b */
    public static void m5446b() {
        synchronized (C4331f.class) {
            m5450a().m5441d();
            if (f18117a != null) {
                f18117a = null;
            }
        }
    }

    /* renamed from: b */
    public static final void m5445b(String str, String str2) {
        m5450a().m5449a(2, str, str2, null);
    }

    /* renamed from: b */
    public static final void m5444b(String str, String str2, Throwable th) {
        m5450a().m5449a(16, str, str2, th);
    }

    /* renamed from: c */
    protected static File m5443c() {
        String packageName = Global.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "default";
        }
        String str = C4323c.f18101i + File.separator + packageName;
        C4324d.C4328d m5459b = C4324d.C4327c.m5459b();
        return m5459b != null && (m5459b.m5452c() > C4323c.f18104l ? 1 : (m5459b.m5452c() == C4323c.f18104l ? 0 : -1)) > 0 ? new File(Environment.getExternalStorageDirectory(), str) : new File(Global.getFilesDir(), str);
    }

    /* renamed from: c */
    public static final void m5442c(String str, String str2) {
        m5450a().m5449a(4, str, str2, null);
    }

    /* renamed from: d */
    public static final void m5440d(String str, String str2) {
        m5450a().m5449a(8, str, str2, null);
    }

    /* renamed from: e */
    public static final void m5439e(String str, String str2) {
        m5450a().m5449a(16, str, str2, null);
    }

    /* renamed from: a */
    protected void m5449a(int i, String str, String str2, Throwable th) {
        C4330e.f18116a.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        if (!C4324d.C4325a.m5462a(C4323c.f18095c, i) || this.f18120b == null) {
            return;
        }
        this.f18120b.b(i, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
    }

    /* renamed from: d */
    protected void m5441d() {
        if (this.f18120b != null) {
            this.f18120b.a();
            this.f18120b.m5496b();
            this.f18120b = null;
        }
    }
}
