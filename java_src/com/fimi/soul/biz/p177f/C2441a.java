package com.fimi.soul.biz.p177f;

import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.fimi.soul.biz.f.a */
/* loaded from: classes.dex */
public class C2441a {

    /* renamed from: a */
    public static final int f8419a = 1;

    /* renamed from: b */
    public static final int f8420b = 2;

    /* renamed from: c */
    private volatile AtomicInteger f8421c;

    /* renamed from: com.fimi.soul.biz.f.a$a */
    /* loaded from: classes.dex */
    public static class C2443a {

        /* renamed from: a */
        public static final C2441a f8422a = new C2441a();
    }

    private C2441a() {
        this.f8421c = new AtomicInteger(1);
    }

    /* renamed from: a */
    public static C2441a m12168a() {
        return C2443a.f8422a;
    }

    /* renamed from: a */
    public void m12167a(int i) {
        if (this.f8421c != null) {
            this.f8421c.set(i);
        }
    }

    /* renamed from: b */
    public int m12166b() {
        if (this.f8421c == null) {
            return 0;
        }
        return this.f8421c.get();
    }

    /* renamed from: c */
    public boolean m12165c() {
        return this.f8421c.get() == 2;
    }
}
