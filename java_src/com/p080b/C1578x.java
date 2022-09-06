package com.p080b;

import android.content.Context;
import android.os.Build;
import com.p080b.C1399ab;
import com.p080b.C1407ag;
import com.p080b.C1423an;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
/* renamed from: com.b.x */
/* loaded from: classes.dex */
public class C1578x extends Thread implements C1423an.AbstractC1424a {

    /* renamed from: a */
    private C1579y f5620a;

    /* renamed from: b */
    private C1423an f5621b;

    /* renamed from: c */
    private C1549dv f5622c;

    /* renamed from: d */
    private String f5623d;

    /* renamed from: e */
    private RandomAccessFile f5624e;

    /* renamed from: f */
    private String f5625f;

    /* renamed from: g */
    private Context f5626g;

    /* renamed from: h */
    private String f5627h;

    /* renamed from: i */
    private String f5628i;

    /* renamed from: j */
    private String f5629j;

    /* renamed from: k */
    private String f5630k;

    /* renamed from: l */
    private int f5631l;

    /* renamed from: m */
    private int f5632m;

    public C1578x(Context context, C1579y c1579y, C1549dv c1549dv) {
        try {
            this.f5626g = context.getApplicationContext();
            this.f5622c = c1549dv;
            if (c1579y == null) {
                return;
            }
            this.f5620a = c1579y;
            this.f5621b = new C1423an(new C1398aa(this.f5620a));
            String[] split = this.f5620a.m15425a().split("/");
            this.f5625f = split[split.length - 1];
            String[] split2 = this.f5625f.split("_");
            this.f5627h = split2[0];
            this.f5628i = split2[2];
            this.f5629j = split2[1];
            this.f5631l = Integer.parseInt(split2[3]);
            this.f5632m = Integer.parseInt(split2[4].split("\\.")[0]);
            this.f5630k = c1579y.m15424b();
            this.f5623d = C1399ab.m16451a(context, this.f5625f);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DexDownLoad", "DexDownLoad");
        }
    }

    /* renamed from: a */
    private void m15434a(String str) {
        C1565k c1565k = new C1565k(this.f5626g, C1405ae.m16425c());
        List m15489c = c1565k.m15489c(C1406af.m16418b(str, "copy"), new C1406af());
        C1399ab.m16445a(m15489c);
        if (m15489c == null || m15489c.size() <= 1) {
            return;
        }
        int size = m15489c.size();
        for (int i = 1; i < size; i++) {
            C1399ab.m16453a(this.f5626g, c1565k, ((C1407ag) m15489c.get(i)).m16417a());
        }
    }

    /* renamed from: a */
    private boolean m15436a(Context context) {
        return C1542dq.m15619m(context) == 1;
    }

    /* renamed from: a */
    private boolean m15435a(C1565k c1565k, C1407ag c1407ag, String str, String str2, String str3, String str4) {
        if ("errorstatus".equals(c1407ag.m16411f())) {
            if (!new File(C1399ab.m16450a(this.f5626g, this.f5622c.m15580a(), this.f5622c.m15578b())).exists()) {
                C1402ac.m16436a(this.f5626g, this.f5622c, C1399ab.m16450a(this.f5626g, this.f5627h, this.f5622c.m15578b()), C1399ab.m16456a(this.f5626g), null, this.f5626g.getClassLoader(), C1399ab.m16455a(this.f5626g, c1565k, this.f5622c));
            }
            return true;
        } else if (!new File(this.f5623d).exists()) {
            return false;
        } else {
            List m15489c = c1565k.m15489c(C1406af.m16421a(C1399ab.m16442b(str, str2), str, str2, str3), new C1406af());
            if (m15489c != null && m15489c.size() > 0) {
                return true;
            }
            try {
                C1399ab.m16454a(this.f5626g, c1565k, this.f5622c, new C1407ag.C1408a(C1399ab.m16442b(str, this.f5622c.m15578b()), str4, str, str2, str3).m16408a("usedex").m16410a(), this.f5623d);
                C1402ac.m16436a(this.f5626g, this.f5622c, C1399ab.m16450a(this.f5626g, this.f5627h, this.f5622c.m15578b()), C1399ab.m16456a(this.f5626g), null, this.f5626g.getClassLoader(), str3);
            } catch (FileNotFoundException e) {
                C1450b.m16187a(e, "DexDownLoad", "processDownloadedFile()");
            } catch (IOException e2) {
                C1450b.m16187a(e2, "DexDownLoad", "processDownloadedFile()");
            } catch (Throwable th) {
                C1450b.m16187a(th, "DexDownLoad", "processDownloadedFile()");
            }
            return true;
        }
    }

    /* renamed from: a */
    private boolean m15433a(String str, String str2) {
        return this.f5622c != null && this.f5622c.m15580a().equals(str) && this.f5622c.m15578b().equals(str2);
    }

    /* renamed from: a */
    private boolean m15432a(String str, String str2, String str3, String str4, String str5) {
        C1565k c1565k = new C1565k(this.f5626g, C1405ae.m16425c());
        try {
            List m15489c = c1565k.m15489c(C1406af.m16418b(str3, "usedex"), new C1406af());
            if (m15489c != null && m15489c.size() > 0) {
                if (C1410ah.m16402a(((C1407ag) m15489c.get(0)).m16412e(), this.f5629j) > 0) {
                    return true;
                }
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "DexDownLoad", "isDownloaded()");
        }
        C1407ag m16439a = C1399ab.C1401a.m16439a(c1565k, str);
        if (m16439a != null) {
            return m15435a(c1565k, m16439a, str3, str4, str2, str5);
        }
        return false;
    }

    /* renamed from: d */
    private boolean m15427d() {
        return Build.VERSION.SDK_INT >= this.f5632m && Build.VERSION.SDK_INT <= this.f5631l;
    }

    /* renamed from: e */
    private boolean m15426e() {
        try {
            if (!m15433a(this.f5627h, this.f5628i) || m15432a(this.f5625f, this.f5629j, this.f5627h, this.f5628i, this.f5630k) || !m15436a(this.f5626g) || !m15427d()) {
                return false;
            }
            m15434a(this.f5622c.m15580a());
            return true;
        } catch (Throwable th) {
            C1450b.m16187a(th, "DexDownLoad", "isNeedDownload()");
            return false;
        }
    }

    /* renamed from: a */
    public void m15437a() {
        try {
            start();
        } catch (Throwable th) {
            C1450b.m16187a(th, "DexDownLoad", "startDownload");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: a */
    public void mo15431a(Throwable th) {
        try {
            if (this.f5624e != null) {
                try {
                    this.f5624e.close();
                } catch (IOException e) {
                    C1450b.m16187a(e, "DexDownLoad", "onException()");
                }
            }
        } catch (Throwable th2) {
            C1450b.m16187a(th2, "DexDownLoad", "onException()");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: a */
    public void mo15430a(byte[] bArr, long j) {
        try {
            if (this.f5624e == null) {
                File file = new File(this.f5623d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.f5624e = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e) {
                    C1450b.m16187a(e, "DexDownLoad", "onDownload()");
                }
            }
            try {
                this.f5624e.seek(j);
                this.f5624e.write(bArr);
            } catch (IOException e2) {
                C1450b.m16187a(e2, "DexDownLoad", "onDownload()");
            }
        } catch (Throwable th) {
            C1450b.m16187a(th, "DexDownLoad", "onDownload()");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: b */
    public void mo15429b() {
        try {
            if (this.f5624e == null) {
                return;
            }
            try {
                this.f5624e.close();
            } catch (IOException e) {
                C1450b.m16187a(e, "DexDownLoad", "onFinish()");
            }
            String m15424b = this.f5620a.m15424b();
            if (!C1399ab.m16446a(this.f5623d, m15424b)) {
                new File(this.f5623d).delete();
                return;
            }
            String m15423c = this.f5620a.m15423c();
            C1565k c1565k = new C1565k(this.f5626g, C1405ae.m16425c());
            C1399ab.C1401a.m16440a(c1565k, new C1407ag.C1408a(this.f5625f, m15424b, this.f5627h, m15423c, this.f5629j).m16408a("copy").m16410a(), C1406af.m16421a(this.f5625f, this.f5627h, m15423c, this.f5629j));
            try {
                try {
                    C1399ab.m16454a(this.f5626g, c1565k, this.f5622c, new C1407ag.C1408a(C1399ab.m16442b(this.f5627h, this.f5622c.m15578b()), m15424b, this.f5627h, m15423c, this.f5629j).m16408a("usedex").m16410a(), this.f5623d);
                    C1402ac.m16436a(this.f5626g, this.f5622c, C1399ab.m16450a(this.f5626g, this.f5627h, this.f5622c.m15578b()), C1399ab.m16456a(this.f5626g), null, this.f5626g.getClassLoader(), this.f5629j);
                } catch (FileNotFoundException e2) {
                    C1450b.m16187a(e2, "DexDownLoad", "onFinish()");
                }
            } catch (IOException e3) {
                C1450b.m16187a(e3, "DexDownLoad", "onFinish()");
            } catch (Throwable th) {
                C1450b.m16187a(th, "DexDownLoad", "onFinish()");
            }
        } catch (Throwable th2) {
            C1450b.m16187a(th2, "DexDownLoad", "onFinish()");
        }
    }

    @Override // com.p080b.C1423an.AbstractC1424a
    /* renamed from: c */
    public void mo15428c() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (!m15426e()) {
                return;
            }
            this.f5621b.m16339a(this);
        } catch (Throwable th) {
            C1450b.m16187a(th, "DexDownLoad", "run");
        }
    }
}
