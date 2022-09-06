package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.mapcore.util.C1060gz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* renamed from: com.amap.api.mapcore.util.fg */
/* loaded from: classes.dex */
public class C0994fg extends Thread implements C1060gz.AbstractC1061a {

    /* renamed from: h */
    private static String f3122h = "sodownload";

    /* renamed from: i */
    private static String f3123i = "sofail";

    /* renamed from: a */
    private C1060gz f3124a;

    /* renamed from: b */
    private C0995a f3125b;

    /* renamed from: c */
    private RandomAccessFile f3126c;

    /* renamed from: d */
    private String f3127d;

    /* renamed from: e */
    private String f3128e;

    /* renamed from: f */
    private String f3129f;

    /* renamed from: g */
    private Context f3130g;

    /* renamed from: com.amap.api.mapcore.util.fg$a */
    /* loaded from: classes.dex */
    private static class C0995a extends AbstractC1075hd {

        /* renamed from: a */
        private String f3131a;

        C0995a(String str) {
            this.f3131a = str;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: a */
        public Map<String, String> mo17702a() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: b */
        public Map<String, String> mo17699b() {
            return null;
        }

        @Override // com.amap.api.mapcore.util.AbstractC1075hd
        /* renamed from: c */
        public String mo17697c() {
            return this.f3131a;
        }
    }

    public C0994fg(Context context, String str, String str2, String str3) {
        this.f3130g = context;
        this.f3129f = str3;
        this.f3127d = m18077a(context, str + "temp.so");
        this.f3128e = m18077a(context, "libwgs2gcj.so");
        this.f3125b = new C0995a(str2);
        this.f3124a = new C1060gz(this.f3125b);
    }

    /* renamed from: a */
    public static String m18077a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    /* renamed from: b */
    private static String m18075b(Context context, String str) {
        return m18077a(context, str);
    }

    /* renamed from: b */
    private void m18076b() {
        File file = new File(this.f3127d);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public void m18078a() {
        if (this.f3125b == null || TextUtils.isEmpty(this.f3125b.mo17697c()) || !this.f3125b.mo17697c().contains("libJni_wgs2gcj.so") || !this.f3125b.mo17697c().contains(Build.CPU_ABI) || new File(this.f3128e).exists()) {
            return;
        }
        start();
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: a */
    public void mo17754a(Throwable th) {
        try {
            if (this.f3126c != null) {
                this.f3126c.close();
            }
            m18076b();
            File file = new File(m18075b(this.f3130g, "tempfile"));
            if (file.exists()) {
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdir();
            }
            file.createNewFile();
        } catch (Throwable th2) {
            C1002fl.m18028a(th2, "SDKCoordinatorDownload", "onException");
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: a */
    public void mo17753a(byte[] bArr, long j) {
        try {
            if (this.f3126c == null) {
                File file = new File(this.f3127d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.f3126c = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e) {
                    C1002fl.m18028a(e, "SDKCoordinatorDownload", "onDownload");
                    m18076b();
                }
            }
            if (this.f3126c == null) {
                return;
            }
            try {
                this.f3126c.seek(j);
                this.f3126c.write(bArr);
            } catch (IOException e2) {
                m18076b();
                C1002fl.m18028a(e2, "SDKCoordinatorDownload", "onDownload");
            }
        } catch (Throwable th) {
            m18076b();
            C1002fl.m18028a(th, "SDKCoordinatorDownload", "onDownload");
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: d */
    public void mo17752d() {
        m18076b();
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: e */
    public void mo17751e() {
        try {
            if (this.f3126c != null) {
                this.f3126c.close();
            }
            String m18095a = C0992fe.m18095a(this.f3127d);
            if (m18095a == null || !m18095a.equalsIgnoreCase(this.f3129f)) {
                m18076b();
            } else if (new File(this.f3128e).exists()) {
                m18076b();
            } else {
                new File(this.f3127d).renameTo(new File(this.f3128e));
            }
        } catch (Throwable th) {
            m18076b();
            File file = new File(this.f3128e);
            if (file.exists()) {
                file.delete();
            }
            C1002fl.m18028a(th, "SDKCoordinatorDownload", "onFinish");
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            File file = new File(m18075b(this.f3130g, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.f3124a.m17755a(this);
        } catch (Throwable th) {
            C1002fl.m18028a(th, "SDKCoordinatorDownload", "run");
            m18076b();
        }
    }
}
