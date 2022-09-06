package com.fimi.p139b.p144e;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.b.e.b */
/* loaded from: classes.dex */
public abstract class AbstractC2103b implements Serializable {
    private static final long serialVersionUID = -7754622750478538539L;

    /* renamed from: a */
    private int f7021a;

    /* renamed from: b */
    private int f7022b;

    /* renamed from: c */
    private int f7023c;

    /* renamed from: d */
    private int f7024d;

    /* renamed from: e */
    private byte f7025e;

    /* renamed from: f */
    private boolean f7026f;

    /* renamed from: a */
    public void mo13507a(byte b) {
        this.f7025e = b;
    }

    /* renamed from: a */
    public void m13723a(int i) {
        this.f7023c = i;
    }

    /* renamed from: a */
    public abstract void mo13475a(C2105d c2105d);

    /* renamed from: a */
    public void m13722a(boolean z) {
        this.f7026f = z;
    }

    /* renamed from: a */
    public boolean m13724a() {
        return this.f7026f;
    }

    /* renamed from: b */
    public byte mo13506b() {
        return this.f7025e;
    }

    /* renamed from: b */
    public void m13721b(int i) {
        this.f7024d = i;
    }

    /* renamed from: c */
    public int m13720c() {
        return this.f7023c;
    }

    /* renamed from: c */
    public void m13719c(int i) {
        this.f7021a = i;
    }

    /* renamed from: d */
    public int m13718d() {
        return this.f7024d;
    }

    /* renamed from: d */
    public void m13717d(int i) {
        this.f7022b = i;
    }

    /* renamed from: e */
    public int m13716e() {
        return this.f7021a;
    }

    /* renamed from: f */
    public int m13715f() {
        return this.f7022b;
    }

    /* renamed from: g */
    public abstract C2104c mo13473g();

    public String toString() {
        return "LinkMessage{tartgetId=" + this.f7021a + ", sourceId=" + this.f7022b + ", seq=" + this.f7023c + ", msgid=" + this.f7024d + ", type=" + ((int) this.f7025e) + ", isSuccess=" + this.f7026f + C0359h.f726w;
    }
}
