package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.AbstractC0858bw;
import com.amap.api.mapcore.util.C1060gz;
import com.amap.api.maps.AMapException;
import com.fimi.kernel.C2172a;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.p248a.p249a.C5083e;
import p004b.p005a.p006a.p028b.p054o.AbstractC0525d;
/* renamed from: com.amap.api.mapcore.util.br */
/* loaded from: classes.dex */
public class C0848br implements C1060gz.AbstractC1061a {

    /* renamed from: a */
    C0850bs f2367a;

    /* renamed from: d */
    long f2370d;

    /* renamed from: f */
    C0842bm f2372f;

    /* renamed from: h */
    AbstractC0849a f2374h;

    /* renamed from: i */
    private Context f2375i;

    /* renamed from: j */
    private AbstractC0858bw f2376j;

    /* renamed from: k */
    private String f2377k;

    /* renamed from: l */
    private C1060gz f2378l;

    /* renamed from: m */
    private C0843bn f2379m;

    /* renamed from: b */
    long f2368b = 0;

    /* renamed from: c */
    long f2369c = 0;

    /* renamed from: e */
    boolean f2371e = true;

    /* renamed from: g */
    long f2373g = 0;

    /* renamed from: com.amap.api.mapcore.util.br$a */
    /* loaded from: classes.dex */
    public interface AbstractC0849a {
        /* renamed from: d */
        void mo18780d();
    }

    public C0848br(C0850bs c0850bs, String str, Context context, AbstractC0858bw abstractC0858bw) {
        this.f2367a = null;
        this.f2372f = C0842bm.m18820a(context.getApplicationContext());
        this.f2367a = c0850bs;
        this.f2375i = context;
        this.f2377k = str;
        this.f2376j = abstractC0858bw;
        m18785g();
    }

    /* renamed from: a */
    private void m18791a(int i) {
        System.err.println("Error Code : " + i);
    }

    /* renamed from: a */
    private void m18790a(long j) {
        if (this.f2370d <= 0 || this.f2376j == null) {
            return;
        }
        this.f2376j.mo18738a(this.f2370d, j);
        this.f2373g = System.currentTimeMillis();
    }

    /* renamed from: f */
    private void m18786f() {
        C0860bx c0860bx = new C0860bx(this.f2377k);
        c0860bx.a(AbstractC0525d.f1187l);
        c0860bx.b(AbstractC0525d.f1187l);
        this.f2378l = new C1060gz(c0860bx, this.f2368b, this.f2369c);
        this.f2379m = new C0843bn(this.f2367a.m18778b() + File.separator + this.f2367a.m18777c(), this.f2368b);
    }

    /* renamed from: g */
    private void m18785g() {
        File file = new File(this.f2367a.m18778b() + this.f2367a.m18777c());
        if (!file.exists()) {
            this.f2368b = 0L;
            this.f2369c = 0L;
            return;
        }
        this.f2371e = false;
        this.f2368b = file.length();
        try {
            this.f2370d = m18788b();
            this.f2369c = this.f2370d;
        } catch (IOException e) {
            if (this.f2376j == null) {
                return;
            }
            this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.file_io_exception);
        }
    }

    /* renamed from: h */
    private boolean m18784h() {
        return new File(new StringBuilder().append(this.f2367a.m18778b()).append(File.separator).append(this.f2367a.m18777c()).toString()).length() >= 10;
    }

    /* renamed from: i */
    private void m18783i() {
        String str = "11K";
        if (C0977ez.f3050a != 1) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 3) {
                    return;
                }
                try {
                    C0977ez.m18164a(this.f2375i, C0945eh.m18310e(), str, null);
                } catch (Throwable th) {
                    C1007fo.m18012b(th, "NetFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
                if (C0977ez.f3050a == 1) {
                    return;
                }
                i = i2 + 1;
            }
        }
    }

    /* renamed from: j */
    private void m18782j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f2367a == null || currentTimeMillis - this.f2373g <= 500) {
            return;
        }
        m18781k();
        this.f2373g = currentTimeMillis;
        m18790a(this.f2368b);
    }

    /* renamed from: k */
    private void m18781k() {
        this.f2372f.m18817a(this.f2367a.m18775e(), this.f2367a.m18776d(), this.f2370d, this.f2368b, this.f2369c);
    }

    /* renamed from: a */
    public void m18792a() {
        try {
            if (!C0945eh.m18312c(this.f2375i)) {
                if (this.f2376j == null) {
                    return;
                }
                this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.network_exception);
                return;
            }
            m18783i();
            if (C0977ez.f3050a != 1) {
                if (this.f2376j == null) {
                    return;
                }
                this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.amap_exception);
                return;
            }
            if (!m18784h()) {
                this.f2371e = true;
            }
            if (this.f2371e) {
                this.f2370d = m18788b();
                if (this.f2370d == -1) {
                    C0856bu.m18754a("File Length is not known!");
                } else if (this.f2370d == -2) {
                    C0856bu.m18754a("File is not access!");
                } else {
                    this.f2369c = this.f2370d;
                }
                this.f2368b = 0L;
            }
            if (this.f2376j != null) {
                this.f2376j.mo18736n();
            }
            if (this.f2368b >= this.f2369c) {
                mo17751e();
                return;
            }
            m18786f();
            this.f2378l.m17755a(this);
        } catch (AMapException e) {
            C1007fo.m18012b(e, "SiteFileFetch", C2172a.f7285a);
            if (this.f2376j == null) {
                return;
            }
            this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.amap_exception);
        } catch (IOException e2) {
            if (this.f2376j == null) {
                return;
            }
            this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.file_io_exception);
        }
    }

    /* renamed from: a */
    public void m18789a(AbstractC0849a abstractC0849a) {
        this.f2374h = abstractC0849a;
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: a */
    public void mo17754a(Throwable th) {
        if (this.f2376j != null) {
            this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.network_exception);
        }
        if (!(th instanceof IOException) && this.f2379m != null) {
            this.f2379m.m18807a();
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: a */
    public void mo17753a(byte[] bArr, long j) {
        try {
            this.f2379m.m18806a(bArr);
            this.f2368b = j;
            m18782j();
        } catch (IOException e) {
            e.printStackTrace();
            C1007fo.m18012b(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            if (this.f2376j != null) {
                this.f2376j.mo18737a(AbstractC0858bw.EnumC0859a.file_io_exception);
            }
            if (this.f2378l == null) {
                return;
            }
            this.f2378l.m17756a();
        }
    }

    /* renamed from: b */
    public long m18788b() {
        int i;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f2367a.m18779a()).openConnection();
        httpURLConnection.setRequestProperty(C5083e.f21661Y, C1022g.f3202d);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 400) {
            m18791a(responseCode);
            return -2L;
        }
        int i2 = 1;
        while (true) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
            if (headerFieldKey == null) {
                i = -1;
                break;
            } else if (headerFieldKey.equalsIgnoreCase("Content-Length")) {
                i = Integer.parseInt(httpURLConnection.getHeaderField(headerFieldKey));
                break;
            } else {
                i2++;
            }
        }
        return i;
    }

    /* renamed from: c */
    public void m18787c() {
        if (this.f2378l != null) {
            this.f2378l.m17756a();
        }
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: d */
    public void mo17752d() {
        if (this.f2376j != null) {
            this.f2376j.mo18734p();
        }
        m18781k();
    }

    @Override // com.amap.api.mapcore.util.C1060gz.AbstractC1061a
    /* renamed from: e */
    public void mo17751e() {
        m18782j();
        if (this.f2376j != null) {
            this.f2376j.mo18735o();
        }
        if (this.f2379m != null) {
            this.f2379m.m18807a();
        }
        if (this.f2374h != null) {
            this.f2374h.mo18780d();
        }
    }
}
