package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import java.io.File;
/* renamed from: com.xiaomi.channel.commonutils.file.c */
/* loaded from: classes2.dex */
public class C4476c {
    /* renamed from: a */
    public static boolean m5052a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            return true;
        }
    }

    /* renamed from: b */
    public static boolean m5051b() {
        try {
            return !Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            return true;
        }
    }

    /* renamed from: c */
    public static boolean m5050c() {
        return m5048e() <= 102400;
    }

    /* renamed from: d */
    public static boolean m5049d() {
        return !m5051b() && !m5050c() && !m5052a();
    }

    /* renamed from: e */
    public static long m5048e() {
        File externalStorageDirectory;
        if (!m5051b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return (statFs.getAvailableBlocks() - 4) * statFs.getBlockSize();
            } catch (Throwable th) {
                return 0L;
            }
        }
        return 0L;
    }
}
