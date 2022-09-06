package com.fimi.p139b;

import com.fimi.p139b.p142c.AbstractC2094b;
/* renamed from: com.fimi.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC2089b implements AbstractC2094b {

    /* renamed from: a */
    public static final int f6983a = 0;

    /* renamed from: b */
    public static final int f6984b = 1;

    /* renamed from: c */
    public static final int f6985c = 2;

    /* renamed from: d */
    public static final int f6986d = 3;

    /* renamed from: e */
    public static final int f6987e = 4;

    /* renamed from: f */
    public static final int f6988f = 5;

    /* renamed from: g */
    public static final int f6989g = 2;

    /* renamed from: h */
    public static final int f6990h = 3;

    /* renamed from: i */
    public static final int f6991i = 4;

    /* renamed from: j */
    public static final String f6992j = "select_corresponding_view";

    /* renamed from: k */
    public static final int f6993k = 0;

    /* renamed from: l */
    public static final int f6994l = 1;

    /* renamed from: m */
    public static final int f6995m = 2;

    /* renamed from: o */
    public static final int f6996o = 4;

    /* renamed from: n */
    protected int f6997n = 0;

    /* renamed from: p */
    private Thread f6998p;

    /* renamed from: q */
    private boolean f6999q;

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13734a() {
        if (this.f6998p == null || !this.f6998p.isAlive() || this.f6998p.isInterrupted()) {
            return;
        }
        this.f6998p.interrupt();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13733a(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
            mo13731a(true);
        }
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public void mo13732a(Runnable runnable) {
        this.f6998p = new Thread(runnable);
        this.f6998p.start();
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: a */
    public synchronized void mo13731a(boolean z) {
        this.f6999q = z;
    }

    @Override // com.fimi.p139b.p142c.AbstractC2094b
    /* renamed from: b */
    public synchronized boolean mo13730b() {
        return this.f6999q;
    }
}
