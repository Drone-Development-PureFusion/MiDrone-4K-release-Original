package org.p248a.p249a.p268i.p274f;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.conn.EofSensorWatcher;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p261f.C5107c;
import org.p248a.p249a.p267h.C5142g;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5006c
/* renamed from: org.a.a.i.f.k */
/* loaded from: classes.dex */
class C5287k extends C5142g implements EofSensorWatcher {

    /* renamed from: b */
    private final C5279c f22228b;

    C5287k(HttpEntity httpEntity, C5279c c5279c) {
        super(httpEntity);
        this.f22228b = c5279c;
    }

    /* renamed from: a */
    public static void m1513a(HttpResponse httpResponse, C5279c c5279c) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || !entity.isStreaming() || c5279c == null) {
            return;
        }
        httpResponse.setEntity(new C5287k(entity, c5279c));
    }

    /* renamed from: b */
    private void m1512b() {
        if (this.f22228b != null) {
            this.f22228b.abortConnection();
        }
    }

    /* renamed from: a */
    public void m1514a() {
        if (this.f22228b != null) {
            try {
                if (this.f22228b.m1529b()) {
                    this.f22228b.releaseConnection();
                }
            } finally {
                m1512b();
            }
        }
    }

    @Override // org.p248a.p249a.p267h.C5142g
    @Deprecated
    public void consumeContent() {
        m1514a();
    }

    public boolean eofDetected(InputStream inputStream) {
        try {
            inputStream.close();
            m1514a();
            m1512b();
            return false;
        } catch (Throwable th) {
            m1512b();
            throw th;
        }
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public InputStream getContent() {
        return new C5107c(this.f21805a.getContent(), this);
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public boolean isRepeatable() {
        return false;
    }

    public boolean streamAbort(InputStream inputStream) {
        m1512b();
        return false;
    }

    public boolean streamClosed(InputStream inputStream) {
        try {
            boolean z = this.f22228b != null && !this.f22228b.m1526e();
            try {
                inputStream.close();
                m1514a();
            } catch (SocketException e) {
                if (z) {
                    throw e;
                }
            }
            return false;
        } finally {
            m1512b();
        }
    }

    public String toString() {
        return "ResponseEntityProxy{" + this.f21805a + C0359h.f726w;
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public void writeTo(OutputStream outputStream) {
        try {
            this.f21805a.writeTo(outputStream);
            m1514a();
        } finally {
            m1512b();
        }
    }
}
