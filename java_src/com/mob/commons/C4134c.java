package com.mob.commons;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ResHelper;
import java.io.File;
/* renamed from: com.mob.commons.c */
/* loaded from: classes.dex */
public class C4134c {
    /* renamed from: a */
    public static synchronized boolean m6090a(Context context, String str) {
        boolean z;
        synchronized (C4134c.class) {
            try {
                z = new File(ResHelper.getCacheRoot(context), str).exists();
            } catch (Throwable th) {
                MobLog.getInstance().m5959w(th);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static synchronized void m6089b(Context context, String str) {
        synchronized (C4134c.class) {
            try {
                File file = new File(ResHelper.getCacheRoot(context), str);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
            } finally {
            }
        }
    }

    /* renamed from: c */
    public static synchronized void m6088c(Context context, String str) {
        synchronized (C4134c.class) {
            try {
                File file = new File(ResHelper.getCacheRoot(context), str);
                if (file.exists()) {
                    file.delete();
                }
            } finally {
            }
        }
    }
}
