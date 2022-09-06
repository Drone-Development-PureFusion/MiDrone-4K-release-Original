package com.amap.api.mapcore.util;
/* renamed from: com.amap.api.mapcore.util.hm */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC1086hm implements Runnable {

    /* renamed from: d */
    AbstractC1087a f3388d;

    /* renamed from: com.amap.api.mapcore.util.hm$a */
    /* loaded from: classes.dex */
    interface AbstractC1087a {
        /* renamed from: a */
        void mo17656a(AbstractRunnableC1086hm abstractRunnableC1086hm);

        /* renamed from: b */
        void mo17655b(AbstractRunnableC1086hm abstractRunnableC1086hm);

        /* renamed from: c */
        void mo17654c(AbstractRunnableC1086hm abstractRunnableC1086hm);
    }

    /* renamed from: a */
    public abstract void mo17658a();

    /* renamed from: e */
    public final void m17657e() {
        try {
            if (this.f3388d == null) {
                return;
            }
            this.f3388d.mo17654c(this);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f3388d != null) {
                this.f3388d.mo17656a(this);
            }
            if (Thread.interrupted()) {
                return;
            }
            mo17658a();
            if (Thread.interrupted() || this.f3388d == null) {
                return;
            }
            this.f3388d.mo17655b(this);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
