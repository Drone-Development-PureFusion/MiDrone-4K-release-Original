package com.p118d.p119a.p127b;

import android.graphics.Bitmap;
import android.os.Handler;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p136c.C1949d;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.d.a.b.i */
/* loaded from: classes.dex */
public final class RunnableC1943i implements Runnable {

    /* renamed from: a */
    private static final String f6931a = "PostProcess image before displaying [%s]";

    /* renamed from: b */
    private final C1930f f6932b;

    /* renamed from: c */
    private final Bitmap f6933c;

    /* renamed from: d */
    private final C1936g f6934d;

    /* renamed from: e */
    private final Handler f6935e;

    public RunnableC1943i(C1930f c1930f, Bitmap bitmap, C1936g c1936g, Handler handler) {
        this.f6932b = c1930f;
        this.f6933c = bitmap;
        this.f6934d = c1936g;
        this.f6935e = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C1949d.m13854a(f6931a, this.f6934d.f6878b);
        RunnableC1938h.m13888a(new RunnableC1898b(this.f6934d.f6881e.m14093p().m13892a(this.f6933c), this.f6934d, this.f6932b, EnumC1894f.MEMORY_CACHE), this.f6934d.f6881e.m14087s(), this.f6935e, this.f6932b);
    }
}
