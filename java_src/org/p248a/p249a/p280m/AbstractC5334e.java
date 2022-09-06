package org.p248a.p249a.p280m;

import java.util.concurrent.TimeUnit;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5004a;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5007d
/* renamed from: org.a.a.m.e */
/* loaded from: classes2.dex */
public abstract class AbstractC5334e<T, C> {

    /* renamed from: a */
    private final String f22357a;

    /* renamed from: b */
    private final T f22358b;

    /* renamed from: c */
    private final C f22359c;

    /* renamed from: d */
    private final long f22360d;

    /* renamed from: e */
    private final long f22361e;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: f */
    private long f22362f;
    @AbstractC5004a(m2313a = "this")

    /* renamed from: g */
    private long f22363g;

    /* renamed from: h */
    private volatile Object f22364h;

    public AbstractC5334e(String str, T t, C c) {
        this(str, t, c, 0L, TimeUnit.MILLISECONDS);
    }

    public AbstractC5334e(String str, T t, C c, long j, TimeUnit timeUnit) {
        C5351a.m1321a(t, "Route");
        C5351a.m1321a(c, C5083e.f21675j);
        C5351a.m1321a(timeUnit, "Time unit");
        this.f22357a = str;
        this.f22358b = t;
        this.f22359c = c;
        this.f22360d = System.currentTimeMillis();
        if (j > 0) {
            this.f22361e = this.f22360d + timeUnit.toMillis(j);
        } else {
            this.f22361e = Long.MAX_VALUE;
        }
        this.f22363g = this.f22361e;
    }

    /* renamed from: a */
    public synchronized void m1395a(long j, TimeUnit timeUnit) {
        C5351a.m1321a(timeUnit, "Time unit");
        this.f22362f = System.currentTimeMillis();
        this.f22363g = Math.min(j > 0 ? this.f22362f + timeUnit.toMillis(j) : Long.MAX_VALUE, this.f22361e);
    }

    /* renamed from: a */
    public void m1394a(Object obj) {
        this.f22364h = obj;
    }

    /* renamed from: a */
    public synchronized boolean mo1396a(long j) {
        return j >= this.f22363g;
    }

    /* renamed from: e */
    public abstract boolean mo1393e();

    /* renamed from: f */
    public abstract void mo1392f();

    /* renamed from: g */
    public String m1391g() {
        return this.f22357a;
    }

    /* renamed from: h */
    public T m1390h() {
        return this.f22358b;
    }

    /* renamed from: i */
    public C m1389i() {
        return this.f22359c;
    }

    /* renamed from: j */
    public long m1388j() {
        return this.f22360d;
    }

    /* renamed from: k */
    public long m1387k() {
        return this.f22361e;
    }

    /* renamed from: l */
    public Object m1386l() {
        return this.f22364h;
    }

    /* renamed from: m */
    public synchronized long m1385m() {
        return this.f22362f;
    }

    /* renamed from: n */
    public synchronized long m1384n() {
        return this.f22363g;
    }

    public String toString() {
        return "[id:" + this.f22357a + "][route:" + this.f22358b + "][state:" + this.f22364h + "]";
    }
}
