package com.fimi.soul.utils;

import android.app.Application;
/* renamed from: com.fimi.soul.utils.a */
/* loaded from: classes.dex */
public class C3623a {

    /* renamed from: a */
    private Application f14752a;

    /* renamed from: com.fimi.soul.utils.a$a */
    /* loaded from: classes.dex */
    private static class C3624a {

        /* renamed from: a */
        private static final C3623a f14753a = new C3623a();

        private C3624a() {
        }
    }

    /* renamed from: a */
    public static C3623a m7760a() {
        return C3624a.f14753a;
    }

    /* renamed from: a */
    public void m7759a(Application application) {
        this.f14752a = application;
    }

    /* renamed from: b */
    public boolean m7758b() {
        if (this.f14752a != null) {
            return C3658ar.m7566p(this.f14752a);
        }
        return false;
    }
}
