package org.p248a.p249a.p268i.p271c;

import android.util.Log;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p261f.AbstractC5130h;
import org.p248a.p249a.p280m.AbstractC5334e;
@AbstractC5007d
/* renamed from: org.a.a.i.c.c */
/* loaded from: classes2.dex */
class C5210c extends AbstractC5334e<HttpRoute, AbstractC5130h> {

    /* renamed from: a */
    private static final String f22072a = "HttpClient";

    /* renamed from: b */
    private volatile boolean f22073b;

    public C5210c(String str, HttpRoute httpRoute, AbstractC5130h abstractC5130h, long j, TimeUnit timeUnit) {
        super(str, httpRoute, abstractC5130h, j, timeUnit);
    }

    /* renamed from: a */
    public void m1648a() {
        this.f22073b = true;
    }

    @Override // org.p248a.p249a.p280m.AbstractC5334e
    /* renamed from: a */
    public boolean mo1396a(long j) {
        boolean mo1396a = super.mo1396a(j);
        if (mo1396a && Log.isLoggable(f22072a, 3)) {
            Log.d(f22072a, "Connection " + this + " expired @ " + new Date(n()));
        }
        return mo1396a;
    }

    /* renamed from: b */
    public boolean m1647b() {
        return this.f22073b;
    }

    /* renamed from: c */
    public void m1646c() {
        i().close();
    }

    /* renamed from: d */
    public void m1645d() {
        i().shutdown();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5334e
    /* renamed from: e */
    public boolean mo1393e() {
        return !i().isOpen();
    }

    @Override // org.p248a.p249a.p280m.AbstractC5334e
    /* renamed from: f */
    public void mo1392f() {
        try {
            m1646c();
        } catch (IOException e) {
            if (!Log.isLoggable(f22072a, 3)) {
                return;
            }
            Log.d(f22072a, "I/O error closing connection", e);
        }
    }
}
