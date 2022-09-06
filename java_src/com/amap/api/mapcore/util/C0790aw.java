package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.mapcore.util.AbstractC0858bw;
import com.amap.api.mapcore.util.C0844bo;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;
/* renamed from: com.amap.api.mapcore.util.aw */
/* loaded from: classes.dex */
public class C0790aw extends OfflineMapCity implements AbstractC0835bf, AbstractC0857bv {

    /* renamed from: o */
    public static final Parcelable.Creator<C0790aw> f2133o = new Parcelable.Creator<C0790aw>() { // from class: com.amap.api.mapcore.util.aw.2
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C0790aw createFromParcel(Parcel parcel) {
            return new C0790aw(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C0790aw[] newArray(int i) {
            return new C0790aw[i];
        }
    };

    /* renamed from: a */
    public AbstractC0864ca f2134a;

    /* renamed from: b */
    public AbstractC0864ca f2135b;

    /* renamed from: c */
    public AbstractC0864ca f2136c;

    /* renamed from: d */
    public AbstractC0864ca f2137d;

    /* renamed from: e */
    public AbstractC0864ca f2138e;

    /* renamed from: f */
    public AbstractC0864ca f2139f;

    /* renamed from: g */
    public AbstractC0864ca f2140g;

    /* renamed from: h */
    public AbstractC0864ca f2141h;

    /* renamed from: i */
    public AbstractC0864ca f2142i;

    /* renamed from: j */
    public AbstractC0864ca f2143j;

    /* renamed from: k */
    public AbstractC0864ca f2144k;

    /* renamed from: l */
    AbstractC0864ca f2145l;

    /* renamed from: m */
    Context f2146m;

    /* renamed from: n */
    boolean f2147n;

    /* renamed from: p */
    private String f2148p;

    /* renamed from: q */
    private String f2149q;

    /* renamed from: r */
    private long f2150r;

    public C0790aw(Context context, int i) {
        this.f2134a = new C0866cc(6, this);
        this.f2135b = new C0872ci(2, this);
        this.f2136c = new C0868ce(0, this);
        this.f2137d = new C0870cg(3, this);
        this.f2138e = new C0871ch(1, this);
        this.f2139f = new C0865cb(4, this);
        this.f2140g = new C0869cf(7, this);
        this.f2141h = new C0867cd(-1, this);
        this.f2142i = new C0867cd(101, this);
        this.f2143j = new C0867cd(102, this);
        this.f2144k = new C0867cd(103, this);
        this.f2148p = null;
        this.f2149q = "";
        this.f2147n = false;
        this.f2150r = 0L;
        this.f2146m = context;
        m19042a(i);
    }

    public C0790aw(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        m19024t();
    }

    public C0790aw(Parcel parcel) {
        super(parcel);
        this.f2134a = new C0866cc(6, this);
        this.f2135b = new C0872ci(2, this);
        this.f2136c = new C0868ce(0, this);
        this.f2137d = new C0870cg(3, this);
        this.f2138e = new C0871ch(1, this);
        this.f2139f = new C0865cb(4, this);
        this.f2140g = new C0869cf(7, this);
        this.f2141h = new C0867cd(-1, this);
        this.f2142i = new C0867cd(101, this);
        this.f2143j = new C0867cd(102, this);
        this.f2144k = new C0867cd(103, this);
        this.f2148p = null;
        this.f2149q = "";
        this.f2147n = false;
        this.f2150r = 0L;
        this.f2149q = parcel.readString();
    }

    /* renamed from: a */
    private void m19038a(final File file, File file2, final String str) {
        new C0844bo().m18804a(file, file2, -1L, C0856bu.m18755a(file), new C0844bo.AbstractC0845a() { // from class: com.amap.api.mapcore.util.aw.1
            @Override // com.amap.api.mapcore.util.C0844bo.AbstractC0845a
            /* renamed from: a */
            public void mo18803a(String str2, String str3) {
            }

            @Override // com.amap.api.mapcore.util.C0844bo.AbstractC0845a
            /* renamed from: a */
            public void mo18802a(String str2, String str3, float f) {
                int i = (int) (60.0d + (f * 0.39d));
                if (i - C0790aw.this.getcompleteCode() <= 0 || System.currentTimeMillis() - C0790aw.this.f2150r <= 1000) {
                    return;
                }
                C0790aw.this.setCompleteCode(i);
                C0790aw.this.f2150r = System.currentTimeMillis();
            }

            @Override // com.amap.api.mapcore.util.C0844bo.AbstractC0845a
            /* renamed from: a */
            public void mo18801a(String str2, String str3, int i) {
                C0790aw.this.f2145l.mo18718a(C0790aw.this.f2144k.m18723b());
            }

            @Override // com.amap.api.mapcore.util.C0844bo.AbstractC0845a
            /* renamed from: b */
            public void mo18800b(String str2, String str3) {
                try {
                    new File(str).delete();
                    C0856bu.m18749b(file);
                    C0790aw.this.setCompleteCode(100);
                    C0790aw.this.f2145l.mo18719h();
                } catch (Exception e) {
                    C0790aw.this.f2145l.mo18718a(C0790aw.this.f2144k.m18723b());
                }
            }
        });
    }

    @Override // com.amap.api.mapcore.util.AbstractC0857bv
    /* renamed from: A */
    public String mo18741A() {
        return getAdcode();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0847bq
    /* renamed from: B */
    public String mo18794B() {
        return m19023u();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0847bq
    /* renamed from: C */
    public String mo18793C() {
        return m19022v();
    }

    /* renamed from: a */
    public String m19043a() {
        return this.f2149q;
    }

    /* renamed from: a */
    public void m19042a(int i) {
        switch (i) {
            case -1:
                this.f2145l = this.f2141h;
                break;
            case 0:
                this.f2145l = this.f2136c;
                break;
            case 1:
                this.f2145l = this.f2138e;
                break;
            case 2:
                this.f2145l = this.f2135b;
                break;
            case 3:
                this.f2145l = this.f2137d;
                break;
            case 4:
                this.f2145l = this.f2139f;
                break;
            case 6:
                this.f2145l = this.f2134a;
                break;
            case 7:
                this.f2145l = this.f2140g;
                break;
            case 101:
                this.f2145l = this.f2142i;
                break;
            case 102:
                this.f2145l = this.f2143j;
                break;
            case 103:
                this.f2145l = this.f2144k;
                break;
            default:
                if (i < 0) {
                    this.f2145l = this.f2141h;
                    break;
                }
                break;
        }
        setState(i);
    }

    @Override // com.amap.api.mapcore.util.AbstractC0846bp
    /* renamed from: a */
    public void mo18799a(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f2150r > 500) {
            if (((int) j) > getcompleteCode()) {
                setCompleteCode((int) j);
                m19034d();
            }
            this.f2150r = currentTimeMillis;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0858bw
    /* renamed from: a */
    public void mo18738a(long j, long j2) {
        long j3 = (100 * j2) / j;
        if (((int) j3) != getcompleteCode()) {
            setCompleteCode((int) j3);
            m19034d();
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0858bw
    /* renamed from: a */
    public void mo18737a(AbstractC0858bw.EnumC0859a enumC0859a) {
        int i = 6;
        switch (enumC0859a) {
            case amap_exception:
                i = this.f2143j.m18723b();
                break;
            case file_io_exception:
                i = this.f2144k.m18723b();
                break;
            case network_exception:
                i = this.f2142i.m18723b();
                break;
        }
        if (this.f2145l.equals(this.f2136c) || this.f2145l.equals(this.f2135b)) {
            this.f2145l.mo18718a(i);
        }
    }

    /* renamed from: a */
    public void m19039a(AbstractC0864ca abstractC0864ca) {
        this.f2145l = abstractC0864ca;
        setState(abstractC0864ca.m18723b());
    }

    /* renamed from: a */
    public void m19037a(String str) {
        this.f2149q = str;
    }

    /* renamed from: b */
    public AbstractC0864ca m19036b(int i) {
        switch (i) {
            case 101:
                return this.f2142i;
            case 102:
                return this.f2143j;
            case 103:
                return this.f2144k;
            default:
                return this.f2141h;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0835bf
    /* renamed from: b */
    public String mo18848b() {
        return getUrl();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0846bp
    /* renamed from: b */
    public void mo18798b(String str) {
        if (!this.f2145l.equals(this.f2138e)) {
        }
        this.f2149q = str;
        String m19023u = m19023u();
        String m19022v = m19022v();
        if (TextUtils.isEmpty(m19023u) || TextUtils.isEmpty(m19022v)) {
            mo18796r();
            return;
        }
        File file = new File(m19022v + "/");
        File file2 = new File(C0945eh.m18357a(this.f2146m) + "vmap/");
        File file3 = new File(C0945eh.m18357a(this.f2146m));
        if (!file3.exists()) {
            file3.mkdir();
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        m19038a(file, file2, m19023u);
    }

    /* renamed from: c */
    public AbstractC0864ca m19035c() {
        return this.f2145l;
    }

    /* renamed from: d */
    public void m19034d() {
        C0794ax m19016a = C0794ax.m19016a(this.f2146m);
        if (m19016a != null) {
            m19016a.m19000c(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m19033e() {
        C0794ax m19016a = C0794ax.m19016a(this.f2146m);
        if (m19016a != null) {
            m19016a.m18992e(this);
            m19034d();
        }
    }

    /* renamed from: f */
    public void m19032f() {
        C0856bu.m18754a("CityOperation current State==>" + m19035c().m18723b());
        if (this.f2145l.equals(this.f2137d)) {
            this.f2145l.mo18720e();
        } else if (this.f2145l.equals(this.f2136c)) {
            this.f2145l.mo18715f();
        } else if (this.f2145l.equals(this.f2140g) || this.f2145l.equals(this.f2141h)) {
            m19027k();
            this.f2147n = true;
        } else if (this.f2145l.equals(this.f2143j) || this.f2145l.equals(this.f2142i) || this.f2145l.m18724a(this.f2144k)) {
            this.f2145l.mo18716d();
        } else {
            m19035c().mo18717c();
        }
    }

    /* renamed from: g */
    public void m19031g() {
        this.f2145l.mo18715f();
    }

    /* renamed from: h */
    public void m19030h() {
        this.f2145l.mo18718a(this.f2144k.m18723b());
    }

    /* renamed from: i */
    public void m19029i() {
        this.f2145l.mo18725a();
        if (this.f2147n) {
            this.f2145l.mo18717c();
        }
        this.f2147n = false;
    }

    /* renamed from: j */
    public void m19028j() {
        if (!this.f2145l.equals(this.f2139f)) {
        }
        this.f2145l.mo18721g();
    }

    /* renamed from: k */
    public void m19027k() {
        C0794ax m19016a = C0794ax.m19016a(this.f2146m);
        if (m19016a != null) {
            m19016a.m19015a(this);
        }
    }

    /* renamed from: l */
    public void m19026l() {
        C0794ax m19016a = C0794ax.m19016a(this.f2146m);
        if (m19016a != null) {
            m19016a.m19004b(this);
        }
    }

    /* renamed from: m */
    public void m19025m() {
        C0794ax m19016a = C0794ax.m19016a(this.f2146m);
        if (m19016a != null) {
            m19016a.m18996d(this);
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0858bw
    /* renamed from: n */
    public void mo18736n() {
        this.f2150r = 0L;
        if (!this.f2145l.equals(this.f2135b)) {
            C0856bu.m18754a("state must be waiting when download onStart");
        }
        this.f2145l.mo18716d();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0858bw
    /* renamed from: o */
    public void mo18735o() {
        if (!this.f2145l.equals(this.f2136c)) {
            C0856bu.m18754a("state must be Loading when download onFinish");
        }
        this.f2145l.mo18719h();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0858bw
    /* renamed from: p */
    public void mo18734p() {
        m19033e();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0846bp
    /* renamed from: q */
    public void mo18797q() {
        this.f2150r = 0L;
        setCompleteCode(0);
        if (!this.f2145l.equals(this.f2138e)) {
        }
        this.f2145l.mo18716d();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0846bp
    /* renamed from: r */
    public void mo18796r() {
        if (!this.f2145l.equals(this.f2138e)) {
        }
        this.f2145l.mo18718a(this.f2141h.m18723b());
    }

    @Override // com.amap.api.mapcore.util.AbstractC0846bp
    /* renamed from: s */
    public void mo18795s() {
        m19033e();
    }

    /* renamed from: t */
    protected void m19024t() {
        this.f2148p = C0794ax.f2155a + getPinyin() + ".zip.tmp";
    }

    /* renamed from: u */
    public String m19023u() {
        if (TextUtils.isEmpty(this.f2148p)) {
            return null;
        }
        return this.f2148p.substring(0, this.f2148p.lastIndexOf("."));
    }

    /* renamed from: v */
    public String m19022v() {
        if (TextUtils.isEmpty(this.f2148p)) {
            return null;
        }
        String m19023u = m19023u();
        return m19023u.substring(0, m19023u.lastIndexOf(46));
    }

    /* renamed from: w */
    public boolean m19021w() {
        if (C0856bu.m18757a() < (getSize() * 2.5d) - (getcompleteCode() * getSize())) {
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f2149q);
    }

    /* renamed from: x */
    public C0837bh m19020x() {
        setState(this.f2145l.m18723b());
        C0837bh c0837bh = new C0837bh(this, this.f2146m);
        c0837bh.m18839a(m19043a());
        C0856bu.m18754a("vMapFileNames: " + m19043a());
        return c0837bh;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0857bv
    /* renamed from: y */
    public boolean mo18740y() {
        return m19021w();
    }

    @Override // com.amap.api.mapcore.util.AbstractC0857bv
    /* renamed from: z */
    public String mo18739z() {
        StringBuffer stringBuffer = new StringBuffer(getPinyin());
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }
}
