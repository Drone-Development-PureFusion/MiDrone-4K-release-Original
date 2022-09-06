package org.p248a.p249a.p268i.p270b;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p252c.AbstractC5031c;
import org.p248a.p249a.p280m.AbstractC5333d;
import org.p248a.p249a.p282o.C5351a;
/* renamed from: org.a.a.i.b.a */
/* loaded from: classes2.dex */
public class C5168a implements AbstractC5031c {

    /* renamed from: a */
    private final AbstractC5333d<HttpRoute> f21919a;

    /* renamed from: b */
    private final AbstractC5182g f21920b;

    /* renamed from: c */
    private final Map<HttpRoute, Long> f21921c;

    /* renamed from: d */
    private final Map<HttpRoute, Long> f21922d;

    /* renamed from: e */
    private long f21923e;

    /* renamed from: f */
    private double f21924f;

    /* renamed from: g */
    private int f21925g;

    public C5168a(AbstractC5333d<HttpRoute> abstractC5333d) {
        this(abstractC5333d, new C5174af());
    }

    C5168a(AbstractC5333d<HttpRoute> abstractC5333d, AbstractC5182g abstractC5182g) {
        this.f21923e = 5000L;
        this.f21924f = 0.5d;
        this.f21925g = 2;
        this.f21920b = abstractC5182g;
        this.f21919a = abstractC5333d;
        this.f21921c = new HashMap();
        this.f21922d = new HashMap();
    }

    /* renamed from: a */
    private Long m1801a(Map<HttpRoute, Long> map, HttpRoute httpRoute) {
        Long l = map.get(httpRoute);
        if (l == null) {
            return 0L;
        }
        return l;
    }

    /* renamed from: b */
    private int m1799b(int i) {
        if (i <= 1) {
            return 1;
        }
        return (int) Math.floor(this.f21924f * i);
    }

    /* renamed from: a */
    public void m1804a(double d) {
        C5351a.m1319a(d > 0.0d && d < 1.0d, "Backoff factor must be 0.0 < f < 1.0");
        this.f21924f = d;
    }

    /* renamed from: a */
    public void m1803a(int i) {
        C5351a.m1324a(i, "Per host connection cap");
        this.f21925g = i;
    }

    /* renamed from: a */
    public void m1802a(long j) {
        C5351a.m1323a(this.f21923e, "Cool down");
        this.f21923e = j;
    }

    @Override // org.p248a.p249a.p252c.AbstractC5031c
    /* renamed from: a */
    public void mo1800a(HttpRoute httpRoute) {
        synchronized (this.f21919a) {
            int mo1400b = this.f21919a.mo1400b((AbstractC5333d<HttpRoute>) httpRoute);
            Long m1801a = m1801a(this.f21922d, httpRoute);
            long mo1771a = this.f21920b.mo1771a();
            if (mo1771a - m1801a.longValue() < this.f21923e) {
                return;
            }
            this.f21919a.mo1402a(httpRoute, m1799b(mo1400b));
            this.f21922d.put(httpRoute, Long.valueOf(mo1771a));
        }
    }

    @Override // org.p248a.p249a.p252c.AbstractC5031c
    /* renamed from: b */
    public void mo1798b(HttpRoute httpRoute) {
        synchronized (this.f21919a) {
            int mo1400b = this.f21919a.mo1400b((AbstractC5333d<HttpRoute>) httpRoute);
            int i = mo1400b >= this.f21925g ? this.f21925g : mo1400b + 1;
            Long m1801a = m1801a(this.f21921c, httpRoute);
            Long m1801a2 = m1801a(this.f21922d, httpRoute);
            long mo1771a = this.f21920b.mo1771a();
            if (mo1771a - m1801a.longValue() < this.f21923e || mo1771a - m1801a2.longValue() < this.f21923e) {
                return;
            }
            this.f21919a.mo1402a(httpRoute, i);
            this.f21921c.put(httpRoute, Long.valueOf(mo1771a));
        }
    }
}
