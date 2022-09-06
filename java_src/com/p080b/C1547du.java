package com.p080b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.p080b.C1423an;
import com.p080b.C1549dv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
/* renamed from: com.b.du */
/* loaded from: classes.dex */
public class C1547du extends Thread implements C1423an.AbstractC1424a {

    /* renamed from: h */
    private static String f5517h = "sodownload";

    /* renamed from: i */
    private static String f5518i = "sofail";

    /* renamed from: a */
    private C1423an f5519a;

    /* renamed from: b */
    private C1548a f5520b;

    /* renamed from: c */
    private RandomAccessFile f5521c;

    /* renamed from: d */
    private String f5522d;

    /* renamed from: e */
    private String f5523e;

    /* renamed from: f */
    private String f5524f;

    /* renamed from: g */
    private Context f5525g;

    /* renamed from: com.b.du$a */
    /* loaded from: classes.dex */
    private static class C1548a extends AbstractC1428aq {

        /* renamed from: d */
        private String f5526d;

        C1548a(String str) {
            this.f5526d = str;
        }

        @Override // com.p080b.AbstractC1428aq
        /* renamed from: a */
        public Map<String, String> mo15505a() {
            return null;
        }

        @Override // com.p080b.AbstractC1428aq
        /* renamed from: b */
        public Map<String, String> mo15504b() {
            return null;
        }

        @Override // com.p080b.AbstractC1428aq
        /* renamed from: c */
        public String mo15503c() {
            return this.f5526d;
        }
    }

    public C1547du(Context context, String str, String str2, String str3) {
        this.f5525g = context;
        this.f5524f = str3;
        this.f5522d = m15583a(context, str + "temp.so");
        this.f5523e = m15583a(context, "libwgs2gcj.so");
        this.f5520b = new C1548a(str2);
        this.f5519a = new C1423an(this.f5520b);
    }

    /* renamed from: a */
    public static String m15583a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    /* renamed from: b */
    private static String m15582b(Context context, String str) {
        return m15583a(context, str);
    }

    /* renamed from: d */
    private void m15581d() {
        File file = new File(this.f5522d);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public void m15584a() {
        if (this.f5520b == null || TextUtils.isEmpty(this.f5520b.mo15503c()) || !this.f5520b.mo15503c().contains("libJni_wgs2gcj.so") || !this.f5520b.mo15503c().contains(Build.CPU_ABI) || new File(this.f5523e).exists()) {
            return;
        }
        start();
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: a */
    public void mo15431a(Throwable th) {
        try {
            if (this.f5521c != null) {
                this.f5521c.close();
            }
            m15581d();
            File file = new File(m15582b(this.f5525g, "tempfile"));
            if (file.exists()) {
                return;
            }
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdir();
                }
                file.createNewFile();
            } catch (IOException e) {
                C1450b.m16187a(e, "SDKCoordinatorDownload", "onException");
            }
        } catch (Throwable th2) {
            C1450b.m16187a(th2, "SDKCoordinatorDownload", "onException");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: a */
    public void mo15430a(byte[] bArr, long j) {
        try {
            if (this.f5521c == null) {
                File file = new File(this.f5522d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.f5521c = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e) {
                    C1450b.m16187a(e, "SDKCoordinatorDownload", "onDownload");
                    m15581d();
                }
            }
            try {
                this.f5521c.seek(j);
                this.f5521c.write(bArr);
            } catch (IOException e2) {
                m15581d();
                C1450b.m16187a(e2, "SDKCoordinatorDownload", "onDownload");
            }
        } catch (Throwable th) {
            m15581d();
            C1450b.m16187a(th, "SDKCoordinatorDownload", "onDownload");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: b */
    public void mo15429b() {
        try {
            if (this.f5521c != null) {
                this.f5521c.close();
            }
            if (!C1545ds.m15599a(this.f5522d).equalsIgnoreCase(this.f5524f)) {
                m15581d();
                C1534dn.m15658a(this.f5525g, new C1549dv.C1550a(f5518i, "1.0.0", "sodownload_1.0.0").m15569a(new String[0]).m15573a());
            } else if (new File(this.f5523e).exists()) {
                m15581d();
            } else {
                new File(this.f5522d).renameTo(new File(this.f5523e));
                C1534dn.m15658a(this.f5525g, new C1549dv.C1550a(f5517h, "1.0.0", "sodownload_1.0.0").m15569a(new String[0]).m15573a());
            }
        } catch (Throwable th) {
            m15581d();
            File file = new File(this.f5523e);
            if (file.exists()) {
                file.delete();
            }
            try {
                C1534dn.m15658a(this.f5525g, new C1549dv.C1550a(f5518i, "1.0.0", "sodownload_1.0.0").m15569a(new String[0]).m15573a());
            } catch (C1532dl e) {
                e.printStackTrace();
            }
            C1450b.m16187a(th, "SDKCoordinatorDownload", "onDownload");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: c */
    public void mo15428c() {
        m15581d();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            File file = new File(m15582b(this.f5525g, "tempfile"));
            if (file.exists()) {
                C1534dn.m15658a(this.f5525g, new C1549dv.C1550a(f5518i, "1.0.0", "sodownload_1.0.0").m15569a(new String[0]).m15573a());
                file.delete();
            }
            this.f5519a.m16339a(this);
        } catch (Throwable th) {
            C1450b.m16187a(th, "SDKCoordinatorDownload", "run");
            m15581d();
        }
    }
}
