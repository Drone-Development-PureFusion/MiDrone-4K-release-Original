package com.fimi.soul.module.update;

import java.util.Timer;
import java.util.TimerTask;
/* renamed from: com.fimi.soul.module.update.c */
/* loaded from: classes.dex */
public class C3588c {

    /* renamed from: b */
    AbstractC3590a f14604b;

    /* renamed from: d */
    private int f14606d;

    /* renamed from: c */
    private final int f14605c = 100;

    /* renamed from: a */
    Timer f14603a = new Timer();

    /* renamed from: com.fimi.soul.module.update.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC3590a {
        /* renamed from: a */
        void mo6452a(boolean z);
    }

    public C3588c(int i, AbstractC3590a abstractC3590a) {
        this.f14606d = i;
        this.f14604b = abstractC3590a;
    }

    /* renamed from: a */
    static /* synthetic */ int m7882a(C3588c c3588c) {
        int i = c3588c.f14606d;
        c3588c.f14606d = i + 1;
        return i;
    }

    /* renamed from: a */
    public void m7884a() {
        TimerTask timerTask = new TimerTask() { // from class: com.fimi.soul.module.update.c.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                C3588c.m7882a(C3588c.this);
                if (C3588c.this.f14606d == 100) {
                    C3588c.this.m7881b();
                    C3588c.this.m7878d();
                    C3588c.this.f14604b.mo6452a(true);
                }
                System.out.println(" counter=" + C3588c.this.f14606d);
            }
        };
        if (this.f14603a != null) {
            this.f14603a.schedule(timerTask, 100L, 1000L);
        }
    }

    /* renamed from: a */
    public void m7883a(int i) {
        this.f14606d = i;
    }

    /* renamed from: b */
    public void m7881b() {
        m7883a(0);
    }

    /* renamed from: c */
    public int m7879c() {
        return this.f14606d;
    }

    /* renamed from: d */
    public void m7878d() {
        this.f14606d = 0;
        if (this.f14603a != null) {
            this.f14603a.cancel();
            this.f14603a = null;
        }
    }
}
