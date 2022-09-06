package com.fimi.soul.drone.p202h;

import android.os.Handler;
/* renamed from: com.fimi.soul.drone.h.f */
/* loaded from: classes.dex */
public class C2858f {

    /* renamed from: a */
    public boolean f10643a;

    /* renamed from: b */
    public boolean f10644b;

    /* renamed from: c */
    private int f10645c;

    /* renamed from: d */
    private Handler f10646d = new Handler();

    /* renamed from: e */
    private Runnable f10647e;

    /* renamed from: f */
    private Runnable f10648f;

    public C2858f(int i) {
        this.f10645c = i;
    }

    public C2858f(int i, Runnable runnable) {
        this.f10645c = i;
        m10754a(runnable);
    }

    /* renamed from: a */
    public int m10758a() {
        return this.f10645c;
    }

    /* renamed from: a */
    public void m10757a(int i) {
        this.f10645c = i;
    }

    /* renamed from: a */
    public void m10756a(int i, Runnable runnable) {
        this.f10644b = true;
        if (this.f10643a) {
            return;
        }
        this.f10645c = i;
        m10754a(runnable);
        this.f10646d.postDelayed(this.f10648f, this.f10645c);
        this.f10643a = true;
    }

    /* renamed from: a */
    public void m10754a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f10647e = runnable;
        this.f10648f = new Runnable() { // from class: com.fimi.soul.drone.h.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (C2858f.this.f10647e == null) {
                    return;
                }
                C2858f.this.f10647e.run();
                C2858f.this.f10646d.postDelayed(C2858f.this.f10648f, C2858f.this.f10645c);
            }
        };
    }

    /* renamed from: b */
    public boolean m10753b() {
        return this.f10643a;
    }

    /* renamed from: c */
    public void m10751c() {
        this.f10646d.removeCallbacks(this.f10648f);
        this.f10643a = false;
        this.f10646d.postDelayed(this.f10648f, this.f10645c);
        this.f10643a = true;
    }

    /* renamed from: d */
    public void m10749d() {
        if (this.f10643a) {
            return;
        }
        this.f10646d.postDelayed(this.f10648f, this.f10645c);
        this.f10643a = true;
    }

    /* renamed from: e */
    public void m10747e() {
        this.f10646d.removeCallbacks(this.f10648f);
        this.f10643a = false;
    }

    /* renamed from: f */
    public void m10746f() {
        this.f10646d.removeCallbacks(this.f10647e);
        this.f10646d.removeCallbacks(this.f10648f);
    }
}
