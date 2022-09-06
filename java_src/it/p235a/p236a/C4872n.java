package it.p235a.p236a;

import java.util.Date;
/* renamed from: it.a.a.n */
/* loaded from: classes.dex */
public class C4872n {

    /* renamed from: a */
    public static final int f20834a = 0;

    /* renamed from: b */
    public static final int f20835b = 1;

    /* renamed from: c */
    public static final int f20836c = 2;

    /* renamed from: d */
    private String f20837d = null;

    /* renamed from: e */
    private String f20838e = null;

    /* renamed from: f */
    private Date f20839f = null;

    /* renamed from: g */
    private long f20840g = -1;

    /* renamed from: h */
    private int f20841h;

    /* renamed from: a */
    public Date m2993a() {
        return this.f20839f;
    }

    /* renamed from: a */
    public void m2992a(int i) {
        this.f20841h = i;
    }

    /* renamed from: a */
    public void m2991a(long j) {
        this.f20840g = j;
    }

    /* renamed from: a */
    public void m2990a(String str) {
        this.f20837d = str;
    }

    /* renamed from: a */
    public void m2989a(Date date) {
        this.f20839f = date;
    }

    /* renamed from: b */
    public String m2988b() {
        return this.f20837d;
    }

    /* renamed from: b */
    public void m2987b(String str) {
        this.f20838e = str;
    }

    /* renamed from: c */
    public int m2986c() {
        return this.f20841h;
    }

    /* renamed from: d */
    public long m2985d() {
        return this.f20840g;
    }

    /* renamed from: e */
    public String m2984e() {
        return this.f20838e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [name=");
        stringBuffer.append(this.f20837d);
        stringBuffer.append(", type=");
        if (this.f20841h == 0) {
            stringBuffer.append("FILE");
        } else if (this.f20841h == 1) {
            stringBuffer.append("DIRECTORY");
        } else if (this.f20841h == 2) {
            stringBuffer.append("LINK");
            stringBuffer.append(", link=");
            stringBuffer.append(this.f20838e);
        } else {
            stringBuffer.append("UNKNOWN");
        }
        stringBuffer.append(", size=");
        stringBuffer.append(this.f20840g);
        stringBuffer.append(", modifiedDate=");
        stringBuffer.append(this.f20839f);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
