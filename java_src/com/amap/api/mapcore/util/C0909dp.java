package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.SingalThread;
/* renamed from: com.amap.api.mapcore.util.dp */
/* loaded from: classes.dex */
public class C0909dp {

    /* renamed from: a */
    AbstractC1116m f2792a;

    /* renamed from: b */
    C0910a f2793b;

    /* renamed from: c */
    private int f2794c = 30;

    /* renamed from: d */
    private int f2795d = 33;

    /* renamed from: e */
    private boolean f2796e = false;

    /* renamed from: f */
    private Object f2797f = new Object();

    /* renamed from: com.amap.api.mapcore.util.dp$a */
    /* loaded from: classes.dex */
    private class C0910a extends SingalThread {

        /* renamed from: a */
        volatile int f2798a;

        /* renamed from: b */
        volatile boolean f2799b = false;

        /* renamed from: c */
        volatile boolean f2800c = false;

        /* renamed from: e */
        private int f2802e = 100;

        public C0910a() {
            this.f2798a = 0;
            this.f2798a = 90;
            this.logTag = "render";
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m18499a(int i) {
            if (this.f2800c) {
                return;
            }
            this.f2798a = i;
            doAwake();
        }

        /* renamed from: a */
        private void m18498a(int i, int i2) {
            int i3 = i2 / this.f2802e;
            int i4 = 0;
            int i5 = 0;
            while (this.f2798a <= 0 && !this.f2800c) {
                i5++;
                if (i5 >= i3) {
                    if (i != -1) {
                        i4++;
                    }
                    C0909dp.this.f2792a.requestRender();
                    i5 = 0;
                }
                if (i != -1 && i4 >= i) {
                    return;
                }
                sleep(this.f2802e);
            }
        }

        /* renamed from: b */
        private void m18496b() {
            while (this.f2798a > 0 && !this.f2800c) {
                C0909dp.this.f2792a.requestRender();
                if (this.f2798a > 0) {
                    this.f2798a--;
                }
                sleep(C0909dp.this.f2795d);
            }
        }

        /* renamed from: a */
        public void m18500a() {
            this.f2798a = 0;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!this.f2799b) {
                try {
                    m18496b();
                    m18498a(30, 100);
                    if (this.f2798a <= 0 || this.f2800c) {
                        m18498a(5, 200);
                        if (this.f2798a <= 0 || this.f2800c) {
                            m18498a(2, 500);
                            if (this.f2798a <= 0 || this.f2800c) {
                                if (C0909dp.this.f2796e) {
                                    m18498a(-1, 10000);
                                    if (this.f2798a > 0 && this.f2800c) {
                                    }
                                } else {
                                    doWait();
                                }
                            }
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public C0909dp(AbstractC1116m abstractC1116m) {
        this.f2792a = abstractC1116m;
    }

    /* renamed from: a */
    public void m18507a() {
        synchronized (this.f2797f) {
            if (this.f2793b != null) {
                this.f2793b.m18500a();
                this.f2793b.f2799b = true;
                if (this.f2793b.isAlive()) {
                    try {
                        this.f2793b.interrupt();
                        this.f2793b = null;
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m18506a(int i) {
        if (this.f2794c == i || i <= 0) {
            return;
        }
        this.f2795d = 1000 / i;
        this.f2794c = i;
    }

    /* renamed from: b */
    public void m18504b() {
        synchronized (this.f2797f) {
            if (this.f2793b != null && this.f2793b.isAlive()) {
                this.f2793b.f2799b = true;
                try {
                    this.f2793b.interrupt();
                    this.f2793b = null;
                } catch (Exception e) {
                }
            }
            this.f2793b = new C0910a();
            this.f2793b.start();
        }
    }

    /* renamed from: b */
    public void m18503b(int i) {
        try {
            synchronized (this.f2797f) {
                if (this.f2793b != null && !this.f2793b.f2800c) {
                    this.f2793b.m18499a(i);
                }
            }
        } catch (NullPointerException e) {
        }
    }

    /* renamed from: c */
    public boolean m18501c() {
        synchronized (this.f2797f) {
            if (this.f2793b != null) {
                return this.f2793b.f2800c;
            }
            return true;
        }
    }
}
