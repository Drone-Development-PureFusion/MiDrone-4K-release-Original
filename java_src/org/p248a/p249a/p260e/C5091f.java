package org.p248a.p249a.p260e;

import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.e.f */
/* loaded from: classes2.dex */
public class C5091f implements Cloneable {

    /* renamed from: a */
    public static final C5091f f21712a = new C5092a().m2031a();

    /* renamed from: b */
    private final int f21713b;

    /* renamed from: c */
    private final boolean f21714c;

    /* renamed from: d */
    private final int f21715d;

    /* renamed from: e */
    private final boolean f21716e;

    /* renamed from: f */
    private final boolean f21717f;

    /* renamed from: org.a.a.e.f$a */
    /* loaded from: classes2.dex */
    public static class C5092a {

        /* renamed from: a */
        private int f21718a;

        /* renamed from: b */
        private boolean f21719b;

        /* renamed from: d */
        private boolean f21721d;

        /* renamed from: c */
        private int f21720c = -1;

        /* renamed from: e */
        private boolean f21722e = true;

        C5092a() {
        }

        /* renamed from: a */
        public C5092a m2030a(int i) {
            this.f21718a = i;
            return this;
        }

        /* renamed from: a */
        public C5092a m2029a(boolean z) {
            this.f21719b = z;
            return this;
        }

        /* renamed from: a */
        public C5091f m2031a() {
            return new C5091f(this.f21718a, this.f21719b, this.f21720c, this.f21721d, this.f21722e);
        }

        /* renamed from: b */
        public C5092a m2028b(int i) {
            this.f21720c = i;
            return this;
        }

        /* renamed from: b */
        public C5092a m2027b(boolean z) {
            this.f21721d = z;
            return this;
        }

        /* renamed from: c */
        public C5092a m2026c(boolean z) {
            this.f21722e = z;
            return this;
        }
    }

    C5091f(int i, boolean z, int i2, boolean z2, boolean z3) {
        this.f21713b = i;
        this.f21714c = z;
        this.f21715d = i2;
        this.f21716e = z2;
        this.f21717f = z3;
    }

    /* renamed from: a */
    public static C5092a m2038a(C5091f c5091f) {
        C5351a.m1321a(c5091f, "Socket config");
        return new C5092a().m2030a(c5091f.m2039a()).m2029a(c5091f.m2037b()).m2028b(c5091f.m2036c()).m2027b(c5091f.m2035d()).m2026c(c5091f.m2034e());
    }

    /* renamed from: g */
    public static C5092a m2032g() {
        return new C5092a();
    }

    /* renamed from: a */
    public int m2039a() {
        return this.f21713b;
    }

    /* renamed from: b */
    public boolean m2037b() {
        return this.f21714c;
    }

    /* renamed from: c */
    public int m2036c() {
        return this.f21715d;
    }

    /* renamed from: d */
    public boolean m2035d() {
        return this.f21716e;
    }

    /* renamed from: e */
    public boolean m2034e() {
        return this.f21717f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public C5091f clone() {
        return (C5091f) super.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[soTimeout=").append(this.f21713b).append(", soReuseAddress=").append(this.f21714c).append(", soLinger=").append(this.f21715d).append(", soKeepAlive=").append(this.f21716e).append(", tcpNoDelay=").append(this.f21717f).append("]");
        return sb.toString();
    }
}
