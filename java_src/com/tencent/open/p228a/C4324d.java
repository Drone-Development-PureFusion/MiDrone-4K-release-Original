package com.tencent.open.p228a;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.text.SimpleDateFormat;
/* renamed from: com.tencent.open.a.d */
/* loaded from: classes.dex */
public class C4324d {

    /* renamed from: com.tencent.open.a.d$a */
    /* loaded from: classes.dex */
    public static final class C4325a {
        /* renamed from: a */
        public static final boolean m5462a(int i, int i2) {
            return i2 == (i & i2);
        }
    }

    /* renamed from: com.tencent.open.a.d$b */
    /* loaded from: classes.dex */
    public static final class C4326b {
        /* renamed from: a */
        public static boolean m5461a(File file) {
            if (file != null) {
                if (file.isFile()) {
                    if (file.delete()) {
                        return true;
                    }
                    file.deleteOnExit();
                    return false;
                } else if (!file.isDirectory()) {
                    return false;
                } else {
                    for (File file2 : file.listFiles()) {
                        m5461a(file2);
                    }
                    return file.delete();
                }
            }
            return false;
        }
    }

    /* renamed from: com.tencent.open.a.d$c */
    /* loaded from: classes.dex */
    public static final class C4327c {
        /* renamed from: a */
        public static boolean m5460a() {
            String externalStorageState = Environment.getExternalStorageState();
            return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
        }

        /* renamed from: b */
        public static C4328d m5459b() {
            if (!m5460a()) {
                return null;
            }
            return C4328d.m5453b(Environment.getExternalStorageDirectory());
        }
    }

    /* renamed from: com.tencent.open.a.d$d */
    /* loaded from: classes.dex */
    public static class C4328d {

        /* renamed from: a */
        private File f18113a;

        /* renamed from: b */
        private long f18114b;

        /* renamed from: c */
        private long f18115c;

        /* renamed from: b */
        public static C4328d m5453b(File file) {
            StatFs statFs;
            C4328d c4328d = new C4328d();
            c4328d.m5456a(file);
            long blockSize = new StatFs(file.getAbsolutePath()).getBlockSize();
            c4328d.m5457a(statFs.getBlockCount() * blockSize);
            c4328d.m5454b(blockSize * statFs.getAvailableBlocks());
            return c4328d;
        }

        /* renamed from: a */
        public File m5458a() {
            return this.f18113a;
        }

        /* renamed from: a */
        public void m5457a(long j) {
            this.f18114b = j;
        }

        /* renamed from: a */
        public void m5456a(File file) {
            this.f18113a = file;
        }

        /* renamed from: b */
        public long m5455b() {
            return this.f18114b;
        }

        /* renamed from: b */
        public void m5454b(long j) {
            this.f18115c = j;
        }

        /* renamed from: c */
        public long m5452c() {
            return this.f18115c;
        }

        public String toString() {
            return String.format("[%s : %d / %d]", m5458a().getAbsolutePath(), Long.valueOf(m5452c()), Long.valueOf(m5455b()));
        }
    }

    /* renamed from: com.tencent.open.a.d$e */
    /* loaded from: classes.dex */
    public static final class C4329e {
        @SuppressLint({"SimpleDateFormat"})
        /* renamed from: a */
        public static SimpleDateFormat m5451a(String str) {
            return new SimpleDateFormat(str);
        }
    }
}
