package com.github.moduth.blockcanary;

import android.os.SystemClock;
import android.util.Printer;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.moduth.blockcanary.k */
/* loaded from: classes.dex */
public class C3967k implements Printer {

    /* renamed from: a */
    private static final int f16981a = 3000;

    /* renamed from: b */
    private long f16982b;

    /* renamed from: e */
    private AbstractC3958d f16985e;

    /* renamed from: c */
    private long f16983c = 0;

    /* renamed from: d */
    private long f16984d = 0;

    /* renamed from: f */
    private boolean f16986f = false;

    public C3967k(AbstractC3958d abstractC3958d, long j) {
        this.f16982b = 3000L;
        this.f16985e = null;
        if (abstractC3958d == null) {
            throw new IllegalArgumentException("blockListener should not be null.");
        }
        this.f16985e = abstractC3958d;
        this.f16982b = j;
    }

    /* renamed from: a */
    private void m6353a() {
        if (C3953c.m6385a().f16945b != null) {
            C3953c.m6385a().f16945b.a();
        }
        if (C3953c.m6385a().f16946c != null) {
            C3953c.m6385a().f16946c.mo6348a();
        }
    }

    /* renamed from: a */
    private boolean m6352a(long j) {
        return j - this.f16983c > this.f16982b;
    }

    /* renamed from: b */
    private void m6350b() {
        if (C3953c.m6385a().f16945b != null) {
            C3953c.m6385a().f16945b.d();
        }
        if (C3953c.m6385a().f16946c != null) {
            C3953c.m6385a().f16946c.d();
        }
    }

    /* renamed from: b */
    private void m6349b(final long j) {
        final long j2 = this.f16983c;
        final long j3 = this.f16984d;
        final long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        C3961g.m6372b().post(new Runnable() { // from class: com.github.moduth.blockcanary.k.1
            @Override // java.lang.Runnable
            public void run() {
                C3967k.this.f16985e.mo6378a(j2, j, j3, currentThreadTimeMillis);
            }
        });
    }

    @Override // android.util.Printer
    public void println(String str) {
        if (!this.f16986f) {
            this.f16983c = System.currentTimeMillis();
            this.f16984d = SystemClock.currentThreadTimeMillis();
            this.f16986f = true;
            m6353a();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f16986f = false;
        if (m6352a(currentTimeMillis)) {
            m6349b(currentTimeMillis);
        }
        m6350b();
    }
}
