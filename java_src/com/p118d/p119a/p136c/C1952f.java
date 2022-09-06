package com.p118d.p119a.p136c;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
/* renamed from: com.d.a.c.f */
/* loaded from: classes.dex */
public final class C1952f {

    /* renamed from: a */
    private static final String f6947a = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: b */
    private static final String f6948b = "uil-images";

    private C1952f() {
    }

    /* renamed from: a */
    public static File m13839a(Context context) {
        return m13836a(context, true);
    }

    /* renamed from: a */
    public static File m13838a(Context context, String str) {
        File m13839a = m13839a(context);
        File file = new File(m13839a, str);
        return (file.exists() || file.mkdir()) ? file : m13839a;
    }

    /* renamed from: a */
    public static File m13837a(Context context, String str, boolean z) {
        File file = null;
        if (z && "mounted".equals(Environment.getExternalStorageState()) && m13832d(context)) {
            file = new File(Environment.getExternalStorageDirectory(), str);
        }
        return (file == null || (!file.exists() && !file.mkdirs())) ? context.getCacheDir() : file;
    }

    /* renamed from: a */
    public static File m13836a(Context context, boolean z) {
        String str;
        File file = null;
        try {
            str = Environment.getExternalStorageState();
        } catch (IncompatibleClassChangeError e) {
            str = "";
        } catch (NullPointerException e2) {
            str = "";
        }
        if (z && "mounted".equals(str) && m13832d(context)) {
            file = m13833c(context);
        }
        if (file == null) {
            file = context.getCacheDir();
        }
        if (file == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            C1949d.m13847c("Can't define system cache directory! '%s' will be used.", str2);
            return new File(str2);
        }
        return file;
    }

    /* renamed from: b */
    public static File m13835b(Context context) {
        return m13838a(context, f6948b);
    }

    /* renamed from: b */
    public static File m13834b(Context context, String str) {
        File file = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && m13832d(context)) {
            file = new File(Environment.getExternalStorageDirectory(), str);
        }
        return (file == null || (!file.exists() && !file.mkdirs())) ? context.getCacheDir() : file;
    }

    /* renamed from: c */
    private static File m13833c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                C1949d.m13847c("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
                return file;
            } catch (IOException e) {
                C1949d.m13849b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return file;
            }
        }
        return file;
    }

    /* renamed from: d */
    private static boolean m13832d(Context context) {
        return context.checkCallingOrSelfPermission(f6947a) == 0;
    }
}
