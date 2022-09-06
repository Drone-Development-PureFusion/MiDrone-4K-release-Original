package org.p248a.p249a.p268i.p274f;

import android.util.Log;
import java.io.InterruptedIOException;
import org.apache.http.Header;
import org.apache.http.conn.routing.HttpRoute;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.AbstractC5066f;
import org.p248a.p249a.p252c.p255c.AbstractC5035b;
import org.p248a.p249a.p252c.p255c.AbstractC5039f;
import org.p248a.p249a.p252c.p255c.C5047n;
import org.p248a.p249a.p252c.p257e.C5057a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.f.m */
/* loaded from: classes2.dex */
public class C5289m implements AbstractC5278b {

    /* renamed from: a */
    private static final String f22232a = "HttpClient";

    /* renamed from: b */
    private final AbstractC5278b f22233b;

    /* renamed from: c */
    private final AbstractC5066f f22234c;

    public C5289m(AbstractC5278b abstractC5278b, AbstractC5066f abstractC5066f) {
        C5351a.m1321a(abstractC5278b, "HTTP request executor");
        C5351a.m1321a(abstractC5066f, "Retry strategy");
        this.f22233b = abstractC5278b;
        this.f22234c = abstractC5066f;
    }

    @Override // org.p248a.p249a.p268i.p274f.AbstractC5278b
    /* renamed from: a */
    public AbstractC5035b mo1511a(HttpRoute httpRoute, C5047n c5047n, C5057a c5057a, AbstractC5039f abstractC5039f) {
        Header[] allHeaders = c5047n.getAllHeaders();
        int i = 1;
        while (true) {
            AbstractC5035b mo1511a = this.f22233b.mo1511a(httpRoute, c5047n, c5057a, abstractC5039f);
            try {
                if (!this.f22234c.mo1752a(mo1511a, i, c5057a)) {
                    return mo1511a;
                }
                mo1511a.close();
                long mo1753a = this.f22234c.mo1753a();
                if (mo1753a > 0) {
                    try {
                        if (Log.isLoggable(f22232a, 3)) {
                            Log.d(f22232a, "Wait for " + mo1753a);
                        }
                        Thread.sleep(mo1753a);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                c5047n.setHeaders(allHeaders);
                i++;
            } catch (RuntimeException e2) {
                mo1511a.close();
                throw e2;
            }
        }
    }
}
