package org.p248a.p249a.p268i.p274f;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpClientConnection;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.p248a.p249a.p250a.AbstractC5007d;
import org.p248a.p249a.p259d.AbstractC5081b;
import org.p248a.p249a.p261f.AbstractC5125d;
@AbstractC5007d
/* renamed from: org.a.a.i.f.c */
/* loaded from: classes2.dex */
class C5279c implements Closeable, AbstractC5081b, ConnectionReleaseTrigger {

    /* renamed from: a */
    private static final String f22193a = "HttpClient";

    /* renamed from: b */
    private final AbstractC5125d f22194b;

    /* renamed from: c */
    private final HttpClientConnection f22195c;

    /* renamed from: d */
    private volatile boolean f22196d;

    /* renamed from: e */
    private volatile Object f22197e;

    /* renamed from: f */
    private volatile long f22198f;

    /* renamed from: g */
    private volatile TimeUnit f22199g;

    /* renamed from: h */
    private volatile boolean f22200h;

    public C5279c(AbstractC5125d abstractC5125d, HttpClientConnection httpClientConnection) {
        this.f22194b = abstractC5125d;
        this.f22195c = httpClientConnection;
    }

    /* renamed from: a */
    public void m1531a(long j, TimeUnit timeUnit) {
        synchronized (this.f22195c) {
            this.f22198f = j;
            this.f22199g = timeUnit;
        }
    }

    /* renamed from: a */
    public void m1530a(Object obj) {
        this.f22197e = obj;
    }

    @Override // org.p248a.p249a.p259d.AbstractC5081b
    /* renamed from: a */
    public boolean mo1532a() {
        boolean z = this.f22200h;
        if (Log.isLoggable(f22193a, 3)) {
            Log.d(f22193a, "Cancelling request execution");
        }
        abortConnection();
        return !z;
    }

    public void abortConnection() {
        synchronized (this.f22195c) {
            if (this.f22200h) {
                return;
            }
            this.f22200h = true;
            try {
                this.f22195c.shutdown();
                if (Log.isLoggable(f22193a, 3)) {
                    Log.d(f22193a, "Connection discarded");
                }
                this.f22194b.mo1612a(this.f22195c, (Object) null, 0L, TimeUnit.MILLISECONDS);
            } catch (IOException e) {
                if (Log.isLoggable(f22193a, 3)) {
                    Log.d(f22193a, e.getMessage(), e);
                }
                this.f22194b.mo1612a(this.f22195c, (Object) null, 0L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* renamed from: b */
    public boolean m1529b() {
        return this.f22196d;
    }

    /* renamed from: c */
    public void m1528c() {
        this.f22196d = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        abortConnection();
    }

    /* renamed from: d */
    public void m1527d() {
        this.f22196d = false;
    }

    /* renamed from: e */
    public boolean m1526e() {
        return this.f22200h;
    }

    public void releaseConnection() {
        synchronized (this.f22195c) {
            if (this.f22200h) {
                return;
            }
            this.f22200h = true;
            if (this.f22196d) {
                this.f22194b.mo1612a(this.f22195c, this.f22197e, this.f22198f, this.f22199g);
            } else {
                try {
                    this.f22195c.close();
                    if (Log.isLoggable(f22193a, 3)) {
                        Log.d(f22193a, "Connection discarded");
                    }
                    this.f22194b.mo1612a(this.f22195c, (Object) null, 0L, TimeUnit.MILLISECONDS);
                } catch (IOException e) {
                    if (Log.isLoggable(f22193a, 3)) {
                        Log.d(f22193a, e.getMessage(), e);
                    }
                    this.f22194b.mo1612a(this.f22195c, (Object) null, 0L, TimeUnit.MILLISECONDS);
                }
            }
        }
    }
}
