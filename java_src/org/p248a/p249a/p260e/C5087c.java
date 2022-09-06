package org.p248a.p249a.p260e;

import org.p248a.p249a.p282o.C5351a;
/* renamed from: org.a.a.e.c */
/* loaded from: classes2.dex */
public class C5087c implements Cloneable {

    /* renamed from: a */
    public static final C5087c f21705a = new C5088a().m2046a();

    /* renamed from: b */
    private final int f21706b;

    /* renamed from: c */
    private final int f21707c;

    /* renamed from: org.a.a.e.c$a */
    /* loaded from: classes2.dex */
    public static class C5088a {

        /* renamed from: a */
        private int f21708a = -1;

        /* renamed from: b */
        private int f21709b = -1;

        C5088a() {
        }

        /* renamed from: a */
        public C5088a m2045a(int i) {
            this.f21708a = i;
            return this;
        }

        /* renamed from: a */
        public C5087c m2046a() {
            return new C5087c(this.f21708a, this.f21709b);
        }

        /* renamed from: b */
        public C5088a m2044b(int i) {
            this.f21709b = i;
            return this;
        }
    }

    C5087c(int i, int i2) {
        this.f21706b = i;
        this.f21707c = i2;
    }

    /* renamed from: a */
    public static C5088a m2050a(C5087c c5087c) {
        C5351a.m1321a(c5087c, "Message constraints");
        return new C5088a().m2044b(c5087c.m2049b()).m2045a(c5087c.m2052a());
    }

    /* renamed from: a */
    public static C5087c m2051a(int i) {
        return new C5087c(C5351a.m1317b(i, "Max line length"), -1);
    }

    /* renamed from: d */
    public static C5088a m2047d() {
        return new C5088a();
    }

    /* renamed from: a */
    public int m2052a() {
        return this.f21706b;
    }

    /* renamed from: b */
    public int m2049b() {
        return this.f21707c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public C5087c clone() {
        return (C5087c) super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[maxLineLength=").append(this.f21706b).append(", maxHeaderCount=").append(this.f21707c).append("]");
        return sb.toString();
    }
}
