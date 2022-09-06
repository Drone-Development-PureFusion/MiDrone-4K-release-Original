package com.tencent.stat;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import com.tencent.stat.common.C4413d;
import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.C4425p;
import com.tencent.stat.common.StatLogger;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
/* renamed from: com.tencent.stat.a */
/* loaded from: classes2.dex */
public class C4396a {

    /* renamed from: b */
    private static C4396a f18357b = null;

    /* renamed from: a */
    private StatLogger f18358a = C4420k.m5197b();

    /* renamed from: c */
    private boolean f18359c;

    /* renamed from: d */
    private boolean f18360d;

    /* renamed from: e */
    private boolean f18361e;

    /* renamed from: f */
    private Context f18362f;

    private C4396a(Context context) {
        this.f18359c = false;
        this.f18360d = false;
        this.f18361e = false;
        this.f18362f = null;
        this.f18362f = context.getApplicationContext();
        this.f18359c = m5260b(context);
        this.f18360d = m5256d(context);
        this.f18361e = m5258c(context);
    }

    /* renamed from: a */
    public static synchronized C4396a m5262a(Context context) {
        C4396a c4396a;
        synchronized (C4396a.class) {
            if (f18357b == null) {
                f18357b = new C4396a(context);
            }
            c4396a = f18357b;
        }
        return c4396a;
    }

    /* renamed from: b */
    private boolean m5260b(Context context) {
        if (!C4420k.m5202a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            this.f18358a.m5236e("Check permission failed: android.permission.WRITE_EXTERNAL_STORAGE");
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m5258c(Context context) {
        if (!C4420k.m5202a(context, "android.permission.WRITE_SETTINGS")) {
            this.f18358a.m5236e("Check permission failed: android.permission.WRITE_SETTINGS");
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m5256d(Context context) {
        if (C4420k.m5190d() < 14) {
            return m5260b(context);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m5261a(String str, String str2) {
        C4425p.m5149b(this.f18362f, str, str2);
        return true;
    }

    /* renamed from: b */
    public String m5259b(String str, String str2) {
        return C4425p.m5152a(this.f18362f, str, str2);
    }

    /* renamed from: c */
    public boolean m5257c(String str, String str2) {
        if (!this.f18359c) {
            return false;
        }
        try {
            C4413d.m5227a(Environment.getExternalStorageDirectory() + "/Tencent/mta");
            File file = new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt");
            if (file != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            }
            return true;
        } catch (Throwable th) {
            this.f18358a.m5233w(th);
            return false;
        }
    }

    /* renamed from: d */
    public String m5255d(String str, String str2) {
        if (!this.f18359c) {
            return null;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt");
            if (file != null) {
                for (String str3 : C4413d.m5228a(file)) {
                    String[] split = str3.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length == 2 && split[0].equals(str)) {
                        return split[1];
                    }
                }
            }
        } catch (FileNotFoundException e) {
            this.f18358a.m5233w("Tencent/mta/.mid.txt not found.");
        } catch (Throwable th) {
            this.f18358a.m5233w(th);
        }
        return null;
    }

    /* renamed from: e */
    public boolean m5254e(String str, String str2) {
        if (!this.f18361e) {
            return false;
        }
        Settings.System.putString(this.f18362f.getContentResolver(), str, str2);
        return true;
    }

    /* renamed from: f */
    public String m5253f(String str, String str2) {
        return !this.f18361e ? str2 : Settings.System.getString(this.f18362f.getContentResolver(), str);
    }
}
