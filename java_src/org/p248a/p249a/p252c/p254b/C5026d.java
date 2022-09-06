package org.p248a.p249a.p252c.p254b;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p267h.AbstractC5136a;
import org.p248a.p249a.p267h.C5137b;
import org.p248a.p249a.p267h.C5139d;
import org.p248a.p249a.p267h.C5140e;
import org.p248a.p249a.p267h.C5141f;
import org.p248a.p249a.p267h.C5143h;
import org.p248a.p249a.p267h.C5144i;
import org.p248a.p249a.p267h.C5145j;
@AbstractC5006c
/* renamed from: org.a.a.c.b.d */
/* loaded from: classes2.dex */
public class C5026d {

    /* renamed from: a */
    private String f21520a;

    /* renamed from: b */
    private byte[] f21521b;

    /* renamed from: c */
    private InputStream f21522c;

    /* renamed from: d */
    private List<NameValuePair> f21523d;

    /* renamed from: e */
    private Serializable f21524e;

    /* renamed from: f */
    private File f21525f;

    /* renamed from: g */
    private C5140e f21526g;

    /* renamed from: h */
    private String f21527h;

    /* renamed from: i */
    private boolean f21528i;

    /* renamed from: j */
    private boolean f21529j;

    C5026d() {
    }

    /* renamed from: a */
    public static C5026d m2260a() {
        return new C5026d();
    }

    /* renamed from: b */
    private C5140e m2249b(C5140e c5140e) {
        return this.f21526g != null ? this.f21526g : c5140e;
    }

    /* renamed from: o */
    private void m2236o() {
        this.f21520a = null;
        this.f21521b = null;
        this.f21522c = null;
        this.f21523d = null;
        this.f21524e = null;
        this.f21525f = null;
    }

    /* renamed from: a */
    public C5026d m2259a(File file) {
        m2236o();
        this.f21525f = file;
        return this;
    }

    /* renamed from: a */
    public C5026d m2258a(InputStream inputStream) {
        m2236o();
        this.f21522c = inputStream;
        return this;
    }

    /* renamed from: a */
    public C5026d m2257a(Serializable serializable) {
        m2236o();
        this.f21524e = serializable;
        return this;
    }

    /* renamed from: a */
    public C5026d m2256a(String str) {
        m2236o();
        this.f21520a = str;
        return this;
    }

    /* renamed from: a */
    public C5026d m2255a(List<NameValuePair> list) {
        m2236o();
        this.f21523d = list;
        return this;
    }

    /* renamed from: a */
    public C5026d m2254a(C5140e c5140e) {
        this.f21526g = c5140e;
        return this;
    }

    /* renamed from: a */
    public C5026d m2253a(byte[] bArr) {
        m2236o();
        this.f21521b = bArr;
        return this;
    }

    /* renamed from: a */
    public C5026d m2252a(NameValuePair... nameValuePairArr) {
        return m2255a(Arrays.asList(nameValuePairArr));
    }

    /* renamed from: b */
    public String m2251b() {
        return this.f21520a;
    }

    /* renamed from: b */
    public C5026d m2250b(String str) {
        this.f21527h = str;
        return this;
    }

    /* renamed from: c */
    public byte[] m2248c() {
        return this.f21521b;
    }

    /* renamed from: d */
    public InputStream m2247d() {
        return this.f21522c;
    }

    /* renamed from: e */
    public List<NameValuePair> m2246e() {
        return this.f21523d;
    }

    /* renamed from: f */
    public Serializable m2245f() {
        return this.f21524e;
    }

    /* renamed from: g */
    public File m2244g() {
        return this.f21525f;
    }

    /* renamed from: h */
    public C5140e m2243h() {
        return this.f21526g;
    }

    /* renamed from: i */
    public String m2242i() {
        return this.f21527h;
    }

    /* renamed from: j */
    public boolean m2241j() {
        return this.f21528i;
    }

    /* renamed from: k */
    public C5026d m2240k() {
        this.f21528i = true;
        return this;
    }

    /* renamed from: l */
    public boolean m2239l() {
        return this.f21529j;
    }

    /* renamed from: m */
    public C5026d m2238m() {
        this.f21529j = true;
        return this;
    }

    /* renamed from: n */
    public HttpEntity m2237n() {
        AbstractC5136a c5141f;
        if (this.f21520a != null) {
            c5141f = new C5145j(this.f21520a, m2249b(C5140e.f21799m));
        } else if (this.f21521b != null) {
            c5141f = new C5139d(this.f21521b, m2249b(C5140e.f21800n));
        } else if (this.f21522c != null) {
            c5141f = new C5143h(this.f21522c, 1L, m2249b(C5140e.f21800n));
        } else if (this.f21523d != null) {
            c5141f = new C5030h(this.f21523d, this.f21526g != null ? this.f21526g.m1940b() : null);
        } else if (this.f21524e != null) {
            c5141f = new C5144i(this.f21524e);
            c5141f.m1954a(C5140e.f21800n.toString());
        } else {
            c5141f = this.f21525f != null ? new C5141f(this.f21525f, m2249b(C5140e.f21800n)) : new C5137b();
        }
        if (c5141f.getContentType() != null && this.f21526g != null) {
            c5141f.m1954a(this.f21526g.toString());
        }
        c5141f.m1951b(this.f21527h);
        c5141f.m1952a(this.f21528i);
        return this.f21529j ? new C5027e(c5141f) : c5141f;
    }
}
