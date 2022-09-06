package com.amap.api.services.core;
/* renamed from: com.amap.api.services.core.ax */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1188ax implements Runnable {

    /* renamed from: a */
    AbstractC1189a f4049a;

    /* renamed from: com.amap.api.services.core.ax$a */
    /* loaded from: classes.dex */
    interface AbstractC1189a {
        /* renamed from: a */
        void mo17184a(AbstractRunnableC1188ax abstractRunnableC1188ax);

        /* renamed from: b */
        void mo17183b(AbstractRunnableC1188ax abstractRunnableC1188ax);
    }

    /* renamed from: a */
    public abstract void mo17046a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f4049a != null) {
                this.f4049a.mo17184a(this);
            }
            if (Thread.interrupted()) {
                return;
            }
            mo17046a();
            if (Thread.interrupted() || this.f4049a == null) {
                return;
            }
            this.f4049a.mo17183b(this);
        } catch (Throwable th) {
            C1190ay.m17177a(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
