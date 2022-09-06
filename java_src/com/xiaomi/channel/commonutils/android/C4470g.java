package com.xiaomi.channel.commonutils.android;

import android.os.Environment;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/* renamed from: com.xiaomi.channel.commonutils.android.g */
/* loaded from: classes2.dex */
public class C4470g {

    /* renamed from: a */
    private static int f18527a = 0;

    /* renamed from: a */
    public static synchronized boolean m5075a() {
        boolean z = true;
        synchronized (C4470g.class) {
            if (m5073c() != 1) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    public static synchronized boolean m5074b() {
        boolean z;
        synchronized (C4470g.class) {
            z = m5073c() == 2;
        }
        return z;
    }

    /* renamed from: c */
    public static synchronized int m5073c() {
        FileInputStream fileInputStream;
        Properties properties;
        int i = 1;
        synchronized (C4470g.class) {
            if (f18527a == 0) {
                try {
                    properties = new Properties();
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                }
                try {
                    properties.load(fileInputStream);
                    if (!((properties.getProperty("ro.miui.ui.version.code", null) == null && properties.getProperty("ro.miui.ui.version.name", null) == null) ? false : true)) {
                        i = 2;
                    }
                    f18527a = i;
                    C4474a.m5059a(fileInputStream);
                } catch (Throwable th2) {
                    th = th2;
                    AbstractC4478b.m5040a("get isMIUI failed", th);
                    f18527a = 0;
                    C4474a.m5059a(fileInputStream);
                    AbstractC4478b.m5038b("isMIUI's value is: " + f18527a);
                    return f18527a;
                }
                AbstractC4478b.m5038b("isMIUI's value is: " + f18527a);
            }
        }
        return f18527a;
    }
}
