package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.mapcore.util.C1036gn;
import com.amap.api.mapcore.util.C1043gr;
import com.amap.api.mapcore.util.C1060gz;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.gh */
/* loaded from: classes.dex */
public class C1030gh extends Thread implements C1060gz.AbstractC1061a {

    /* renamed from: a */
    private C1031gi f3217a;

    /* renamed from: b */
    private C1060gz f3218b;

    /* renamed from: c */
    private C0996fh f3219c;

    /* renamed from: d */
    private String f3220d;

    /* renamed from: e */
    private RandomAccessFile f3221e;

    /* renamed from: f */
    private Context f3222f;

    public C1030gh(Context context, C1031gi c1031gi, C0996fh c0996fh) {
        try {
            this.f3222f = context.getApplicationContext();
            this.f3219c = c0996fh;
            if (c1031gi == null) {
                return;
            }
            this.f3217a = c1031gi;
            this.f3218b = new C1060gz(new C1035gm(this.f3217a));
            this.f3220d = C1036gn.m17887a(context, this.f3217a.f3223a);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    /* renamed from: a */
    private void m17917a(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.commit();
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "clearMarker()");
        }
    }

    /* renamed from: a */
    private void m17914a(String str) {
        String m17906c = this.f3217a.m17906c();
        C1016fu c1016fu = new C1016fu(this.f3222f, C1042gq.m17861a());
        C1036gn.C1038a.m17878a(c1016fu, new C1043gr.C1044a(this.f3217a.f3223a, str, this.f3217a.f3224b, m17906c, this.f3217a.f3226d).m17842a("copy").m17844a(), C1043gr.m17853a(this.f3217a.f3223a, this.f3217a.f3224b, m17906c, this.f3217a.f3226d));
        m17917a(this.f3222f, this.f3217a.f3224b);
        try {
            C1036gn.m17891a(this.f3222f, c1016fu, this.f3219c, this.f3220d, this.f3217a.f3226d);
            C1036gn.m17893a(this.f3222f, this.f3219c);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "onFinish1");
        }
    }

    /* renamed from: a */
    private boolean m17918a(Context context) {
        return C0989fc.m18117m(context) == 1;
    }

    /* renamed from: a */
    private boolean m17916a(C1016fu c1016fu) {
        try {
            List<C1043gr> m17876a = C1036gn.C1038a.m17876a(c1016fu, this.f3217a.f3224b, "used");
            if (m17876a != null && m17876a.size() > 0) {
                if (C1045gs.m17832a(m17876a.get(0).m17846e(), this.f3217a.f3226d) > 0) {
                    return true;
                }
            }
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "isUsed()");
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17915a(C1016fu c1016fu, C1043gr c1043gr, C1031gi c1031gi) {
        String str = c1031gi.f3224b;
        String str2 = c1031gi.f3225c;
        String str3 = c1031gi.f3226d;
        String str4 = c1031gi.f3227e;
        if ("errorstatus".equals(c1043gr.m17845f())) {
            m17912b(c1016fu);
            return true;
        } else if (!new File(this.f3220d).exists()) {
            return false;
        } else {
            List m17952b = c1016fu.m17952b(C1043gr.m17853a(C1036gn.m17886a(this.f3222f, str, str2), str, str2, str3), C1043gr.class);
            if (m17952b != null && m17952b.size() > 0) {
                return true;
            }
            try {
                C1036gn.m17886a(this.f3222f, str, this.f3219c.m18070b());
                C1036gn.m17891a(this.f3222f, c1016fu, this.f3219c, this.f3220d, str3);
                C1036gn.m17893a(this.f3222f, this.f3219c);
                return true;
            } catch (Throwable th) {
                C1045gs.m17831a(th, "dDownLoad", "processDownloadedFile()");
                return true;
            }
        }
    }

    /* renamed from: b */
    private void m17912b(C1016fu c1016fu) {
        if (new File(C1036gn.m17881b(this.f3222f, this.f3219c.m18074a(), this.f3219c.m18070b())).exists() || TextUtils.isEmpty(C1036gn.m17892a(this.f3222f, c1016fu, this.f3219c))) {
            return;
        }
        try {
            C1036gn.m17893a(this.f3222f, this.f3219c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: f */
    private boolean m17910f() {
        C1016fu c1016fu = new C1016fu(this.f3222f, C1042gq.m17861a());
        if (m17916a(c1016fu)) {
            return true;
        }
        C1043gr m17877a = C1036gn.C1038a.m17877a(c1016fu, this.f3217a.f3223a);
        if (m17877a == null) {
            return false;
        }
        return m17915a(c1016fu, m17877a, this.f3217a);
    }

    /* renamed from: g */
    private boolean m17909g() {
        return Build.VERSION.SDK_INT >= this.f3217a.f3229g && Build.VERSION.SDK_INT <= this.f3217a.f3228f;
    }

    /* renamed from: a */
    public void m17919a() {
        try {
            start();
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "startDownload()");
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: a */
    public void mo17754a(Throwable th) {
        try {
            C1045gs.m17833a(this.f3221e);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: a */
    public void mo17753a(byte[] bArr, long j) {
        try {
            if (this.f3221e == null) {
                File file = new File(this.f3220d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f3221e = new RandomAccessFile(file, "rw");
            }
            this.f3221e.seek(j);
            this.f3221e.write(bArr);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "onDownload()");
        }
    }

    /* renamed from: b */
    boolean m17913b() {
        return this.f3219c != null && this.f3219c.m18074a().equals(this.f3217a.f3224b) && this.f3219c.m18070b().equals(this.f3217a.f3225c);
    }

    /* renamed from: c */
    boolean m17911c() {
        try {
            if (!m17913b() || !m17909g() || !m17918a(this.f3222f) || m17910f()) {
                return false;
            }
            C1036gn.m17882b(this.f3222f, this.f3219c.m18074a());
            return true;
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: d */
    public void mo17752d() {
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: e */
    public void mo17751e() {
        try {
            if (this.f3221e != null) {
                C1045gs.m17833a(this.f3221e);
                String m17907b = this.f3217a.m17907b();
                if (C1045gs.m17829b(this.f3220d, m17907b)) {
                    m17914a(m17907b);
                    C1080hi c1080hi = new C1080hi(this.f3222f, this.f3219c.m18074a(), this.f3219c.m18070b(), "O008");
                    c1080hi.m17679a("{\"param_int_first\":1}");
                    C1081hj.m17674a(c1080hi, this.f3222f);
                } else {
                    new File(this.f3220d).delete();
                }
            }
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "onFinish()");
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (!m17911c()) {
                return;
            }
            C1080hi c1080hi = new C1080hi(this.f3222f, this.f3219c.m18074a(), this.f3219c.m18070b(), "O008");
            c1080hi.m17679a("{\"param_int_first\":0}");
            C1081hj.m17674a(c1080hi, this.f3222f);
            this.f3218b.m17755a(this);
        } catch (Throwable th) {
            C1045gs.m17831a(th, "dDownLoad", "run()");
        }
    }
}
