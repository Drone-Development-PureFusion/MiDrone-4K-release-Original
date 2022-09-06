package com.p080b;

import java.util.Locale;
/* renamed from: com.b.ba */
/* loaded from: classes.dex */
public class C1451ba {

    /* renamed from: a */
    public String f5026a = "";

    /* renamed from: b */
    public String f5027b = "";

    /* renamed from: c */
    public int f5028c = 0;

    /* renamed from: d */
    public int f5029d = 0;

    /* renamed from: e */
    public int f5030e = 0;

    /* renamed from: f */
    public int f5031f = 0;

    /* renamed from: g */
    public int f5032g = 0;

    /* renamed from: h */
    public int f5033h = 0;

    /* renamed from: i */
    public int f5034i = 0;

    /* renamed from: j */
    public int f5035j = -113;

    /* renamed from: k */
    public int f5036k;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1451ba(int i) {
        this.f5036k = 9;
        this.f5036k = i;
    }

    /* renamed from: a */
    public boolean m16186a(C1451ba c1451ba) {
        if (c1451ba == null) {
            return false;
        }
        switch (c1451ba.f5036k) {
            case 1:
                return this.f5036k == 1 && c1451ba.f5028c == this.f5028c && c1451ba.f5029d == this.f5029d && c1451ba.f5027b != null && c1451ba.f5027b.equals(this.f5027b);
            case 2:
                return this.f5036k == 2 && c1451ba.f5034i == this.f5034i && c1451ba.f5033h == this.f5033h && c1451ba.f5032g == this.f5032g;
            default:
                return false;
        }
    }

    public String toString() {
        switch (this.f5036k) {
            case 1:
                return String.format(Locale.US, "GSM lac=%d, cid=%d, mnc=%s", Integer.valueOf(this.f5028c), Integer.valueOf(this.f5029d), this.f5027b);
            case 2:
                return String.format(Locale.US, "CDMA bid=%d, nid=%d, sid=%d", Integer.valueOf(this.f5034i), Integer.valueOf(this.f5033h), Integer.valueOf(this.f5032g));
            default:
                return "unknown";
        }
    }
}
