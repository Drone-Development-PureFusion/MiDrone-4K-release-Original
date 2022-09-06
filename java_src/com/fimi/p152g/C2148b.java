package com.fimi.p152g;

import com.fimi.p147d.AbstractC2118a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* renamed from: com.fimi.g.b */
/* loaded from: classes.dex */
public class C2148b {

    /* renamed from: b */
    private static C2148b f7207b = new C2148b();

    /* renamed from: a */
    ExecutorService f7208a = Executors.newFixedThreadPool(10);

    /* renamed from: c */
    private RunnableC2147a f7209c;

    /* renamed from: a */
    public static C2148b m13440a() {
        if (f7207b == null) {
            f7207b = new C2148b();
        }
        return f7207b;
    }

    /* renamed from: a */
    public void m13439a(AbstractC2118a abstractC2118a) {
        if (this.f7209c == null) {
            this.f7209c = new RunnableC2147a(abstractC2118a);
            m13438a(this.f7209c);
        }
    }

    /* renamed from: a */
    public void m13438a(Runnable runnable) {
        this.f7208a.execute(runnable);
    }

    /* renamed from: b */
    public void m13437b() {
        if (this.f7209c != null) {
            this.f7209c.m13442a();
        }
    }
}
