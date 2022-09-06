package org.p248a.p249a.p268i.p274f;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.http.HttpException;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.AbstractC5031c;
import org.p248a.p249a.p252c.AbstractC5054d;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.f.a */
/* loaded from: classes2.dex */
public class C5277a implements AbstractC5278b {

    /* renamed from: a */
    private final AbstractC5278b f22190a;

    /* renamed from: b */
    private final AbstractC5054d f22191b;

    /* renamed from: c */
    private final AbstractC5031c f22192c;

    public C5277a(AbstractC5278b abstractC5278b, AbstractC5054d abstractC5054d, AbstractC5031c abstractC5031c) {
        C5351a.m1321a(abstractC5278b, "HTTP client request executor");
        C5351a.m1321a(abstractC5054d, "Connection backoff strategy");
        C5351a.m1321a(abstractC5031c, "Backoff manager");
        this.f22190a = abstractC5278b;
        this.f22191b = abstractC5054d;
        this.f22192c = abstractC5031c;
    }

    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        C5351a.m1321a(httpRoute, "HTTP route");
        C5351a.m1321a(c5047n, "HTTP request");
        C5351a.m1321a(c5057a, "HTTP context");
        AbstractC5035b abstractC5035b = null;
        try {
            AbstractC5035b mo1511a = this.f22190a.mo1511a(httpRoute, c5047n, c5057a, abstractC5039f);
            if (this.f22191b.mo1762a(mo1511a)) {
                this.f22192c.mo1800a(httpRoute);
            } else {
                this.f22192c.mo1798b(httpRoute);
            }
            return mo1511a;
        } catch (Exception e) {
            if (0 != 0) {
                abstractC5035b.close();
            }
            if (this.f22191b.mo1763a((Throwable) e)) {
                this.f22192c.mo1800a(httpRoute);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            if (e instanceof HttpException) {
                throw e;
            }
            if (!(e instanceof IOException)) {
                throw new UndeclaredThrowableException(e);
            }
            throw ((IOException) e);
        }
    }
}
