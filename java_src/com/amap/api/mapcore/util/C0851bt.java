package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* renamed from: com.amap.api.mapcore.util.bt */
/* loaded from: classes.dex */
public class C0851bt {

    /* renamed from: a */
    private C0854b f2385a;

    /* renamed from: com.amap.api.mapcore.util.bt$a */
    /* loaded from: classes.dex */
    public static class C0853a {

        /* renamed from: a */
        public boolean f2387a = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.amap.api.mapcore.util.bt$b */
    /* loaded from: classes.dex */
    public class C0854b {

        /* renamed from: b */
        private String f2389b;

        /* renamed from: c */
        private String f2390c;

        /* renamed from: d */
        private AbstractC0846bp f2391d;

        /* renamed from: e */
        private C0853a f2392e = new C0853a();

        /* renamed from: f */
        private String f2393f;

        public C0854b(AbstractC0847bq abstractC0847bq, AbstractC0846bp abstractC0846bp) {
            this.f2391d = null;
            this.f2389b = abstractC0847bq.mo18794B();
            this.f2390c = abstractC0847bq.mo18793C();
            this.f2391d = abstractC0846bp;
        }

        /* renamed from: a */
        public String m18766a() {
            return this.f2389b;
        }

        /* renamed from: a */
        public void m18765a(String str) {
            if (str.length() > 1) {
                this.f2393f = str;
            }
        }

        /* renamed from: b */
        public String m18764b() {
            return this.f2390c;
        }

        /* renamed from: c */
        public String m18763c() {
            return this.f2393f;
        }

        /* renamed from: d */
        public AbstractC0846bp m18762d() {
            return this.f2391d;
        }

        /* renamed from: e */
        public C0853a m18761e() {
            return this.f2392e;
        }

        /* renamed from: f */
        public void m18760f() {
            this.f2392e.f2387a = true;
        }
    }

    /* renamed from: com.amap.api.mapcore.util.bt$c */
    /* loaded from: classes.dex */
    public interface AbstractC0855c {
        /* renamed from: a */
        void mo18759a();

        /* renamed from: a */
        void mo18758a(long j);
    }

    public C0851bt(AbstractC0847bq abstractC0847bq, AbstractC0846bp abstractC0846bp) {
        this.f2385a = new C0854b(abstractC0847bq, abstractC0846bp);
    }

    /* renamed from: a */
    private static int m18770a(File file, ZipInputStream zipInputStream, long j, long j2, AbstractC0855c abstractC0855c, C0853a c0853a) {
        int i = 0;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                break;
            } else if (c0853a != null && c0853a.f2387a) {
                bufferedOutputStream.close();
                break;
            } else {
                bufferedOutputStream.write(bArr, 0, read);
                i += read;
                if (j2 > 0 && abstractC0855c != null) {
                    long j3 = ((i + j) * 100) / j2;
                    if (c0853a == null || !c0853a.f2387a) {
                        abstractC0855c.mo18758a(j3);
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private static void m18773a(C0854b c0854b) {
        if (c0854b == null) {
            return;
        }
        final AbstractC0846bp m18762d = c0854b.m18762d();
        if (m18762d != null) {
            m18762d.mo18797q();
        }
        String m18766a = c0854b.m18766a();
        String m18764b = c0854b.m18764b();
        if (TextUtils.isEmpty(m18766a) || TextUtils.isEmpty(m18764b)) {
            if (c0854b.m18761e().f2387a) {
                if (m18762d == null) {
                    return;
                }
                m18762d.mo18795s();
                return;
            } else if (m18762d == null) {
                return;
            } else {
                m18762d.mo18796r();
                return;
            }
        }
        File file = new File(m18766a);
        if (!file.exists()) {
            if (c0854b.m18761e().f2387a) {
                if (m18762d == null) {
                    return;
                }
                m18762d.mo18795s();
                return;
            } else if (m18762d == null) {
                return;
            } else {
                m18762d.mo18796r();
                return;
            }
        }
        File file2 = new File(m18764b);
        if (file2.exists() || !file2.mkdirs()) {
        }
        AbstractC0855c abstractC0855c = new AbstractC0855c() { // from class: com.amap.api.mapcore.util.bt.1
            @Override // com.amap.api.mapcore.util.C0851bt.AbstractC0855c
            /* renamed from: a */
            public void mo18759a() {
                if (AbstractC0846bp.this != null) {
                    AbstractC0846bp.this.mo18796r();
                }
            }

            @Override // com.amap.api.mapcore.util.C0851bt.AbstractC0855c
            /* renamed from: a */
            public void mo18758a(long j) {
                try {
                    if (AbstractC0846bp.this == null) {
                        return;
                    }
                    AbstractC0846bp.this.mo18799a(j);
                } catch (Exception e) {
                }
            }
        };
        try {
            if (c0854b.m18761e().f2387a && m18762d != null) {
                m18762d.mo18795s();
            }
            m18771a(file, file2, abstractC0855c, c0854b);
            if (c0854b.m18761e().f2387a) {
                if (m18762d == null) {
                    return;
                }
                m18762d.mo18795s();
            } else if (m18762d == null) {
            } else {
                m18762d.mo18798b(c0854b.m18763c());
            }
        } catch (Throwable th) {
            if (c0854b.m18761e().f2387a) {
                if (m18762d == null) {
                    return;
                }
                m18762d.mo18795s();
            } else if (m18762d == null) {
            } else {
                m18762d.mo18796r();
            }
        }
    }

    /* renamed from: a */
    private static void m18772a(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            m18772a(parentFile);
            if (!parentFile.mkdir()) {
            }
        }
    }

    /* renamed from: a */
    private static void m18771a(File file, File file2, AbstractC0855c abstractC0855c, C0854b c0854b) {
        StringBuffer stringBuffer = new StringBuffer();
        C0853a m18761e = c0854b.m18761e();
        long j = 0;
        if (abstractC0855c != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new CRC32());
                ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        if (m18761e != null && m18761e.f2387a) {
                            zipInputStream.closeEntry();
                            zipInputStream.close();
                            checkedInputStream.close();
                            fileInputStream.close();
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            if (!m18768a(nextEntry.getName())) {
                                abstractC0855c.mo18759a();
                                break;
                            }
                            stringBuffer.append(nextEntry.getName()).append(";");
                        }
                        j += nextEntry.getSize();
                        zipInputStream.closeEntry();
                    } else {
                        break;
                    }
                }
                c0854b.m18765a(stringBuffer.toString());
                zipInputStream.close();
                checkedInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream2 = new FileInputStream(file);
        CheckedInputStream checkedInputStream2 = new CheckedInputStream(fileInputStream2, new CRC32());
        ZipInputStream zipInputStream2 = new ZipInputStream(checkedInputStream2);
        m18769a(file2, zipInputStream2, j, abstractC0855c, m18761e);
        zipInputStream2.close();
        checkedInputStream2.close();
        fileInputStream2.close();
    }

    /* renamed from: a */
    private static void m18769a(File file, ZipInputStream zipInputStream, long j, AbstractC0855c abstractC0855c, C0853a c0853a) {
        int i = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                if (c0853a != null && c0853a.f2387a) {
                    zipInputStream.closeEntry();
                    return;
                }
                String str = file.getPath() + File.separator + nextEntry.getName();
                if (!m18768a(str)) {
                    if (abstractC0855c == null) {
                        return;
                    }
                    abstractC0855c.mo18759a();
                    return;
                }
                File file2 = new File(str);
                m18772a(file2);
                int m18770a = nextEntry.isDirectory() ? !file2.mkdirs() ? i : i : m18770a(file2, zipInputStream, i, j, abstractC0855c, c0853a) + i;
                zipInputStream.closeEntry();
                i = m18770a;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private static boolean m18768a(String str) {
        return !str.contains("../");
    }

    /* renamed from: a */
    public void m18774a() {
        if (this.f2385a != null) {
            this.f2385a.m18760f();
        }
    }

    /* renamed from: b */
    public void m18767b() {
        if (this.f2385a != null) {
            m18773a(this.f2385a);
        }
    }
}
