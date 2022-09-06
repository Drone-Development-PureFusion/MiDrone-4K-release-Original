package org.p248a.p249a.p261f;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.EofSensorWatcher;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.f.c */
/* loaded from: classes2.dex */
public class C5107c extends InputStream implements ConnectionReleaseTrigger {

    /* renamed from: a */
    protected InputStream f21729a;

    /* renamed from: b */
    private boolean f21730b = false;

    /* renamed from: c */
    private final EofSensorWatcher f21731c;

    public C5107c(InputStream inputStream, EofSensorWatcher eofSensorWatcher) {
        C5351a.m1321a(inputStream, "Wrapped stream");
        this.f21729a = inputStream;
        this.f21731c = eofSensorWatcher;
    }

    /* renamed from: a */
    protected void m2016a(int i) {
        if (this.f21729a == null || i >= 0) {
            return;
        }
        boolean z = true;
        try {
            if (this.f21731c != null) {
                z = this.f21731c.eofDetected(this.f21729a);
            }
            if (z) {
                this.f21729a.close();
            }
        } finally {
            this.f21729a = null;
        }
    }

    /* renamed from: a */
    boolean m2017a() {
        return this.f21730b;
    }

    public void abortConnection() {
        this.f21730b = true;
        m2012e();
    }

    @Override // java.io.InputStream
    public int available() {
        if (m2014c()) {
            try {
                return this.f21729a.available();
            } catch (IOException e) {
                m2012e();
                throw e;
            }
        }
        return 0;
    }

    /* renamed from: b */
    InputStream m2015b() {
        return this.f21729a;
    }

    /* renamed from: c */
    protected boolean m2014c() {
        if (this.f21730b) {
            throw new IOException("Attempted read on closed stream.");
        }
        return this.f21729a != null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f21730b = true;
        m2013d();
    }

    /* renamed from: d */
    protected void m2013d() {
        if (this.f21729a != null) {
            boolean z = true;
            try {
                if (this.f21731c != null) {
                    z = this.f21731c.streamClosed(this.f21729a);
                }
                if (z) {
                    this.f21729a.close();
                }
            } finally {
                this.f21729a = null;
            }
        }
    }

    /* renamed from: e */
    protected void m2012e() {
        if (this.f21729a != null) {
            boolean z = true;
            try {
                if (this.f21731c != null) {
                    z = this.f21731c.streamAbort(this.f21729a);
                }
                if (z) {
                    this.f21729a.close();
                }
            } finally {
                this.f21729a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (m2014c()) {
            try {
                int read = this.f21729a.read();
                m2016a(read);
                return read;
            } catch (IOException e) {
                m2012e();
                throw e;
            }
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (m2014c()) {
            try {
                int read = this.f21729a.read(bArr, i, i2);
                m2016a(read);
                return read;
            } catch (IOException e) {
                m2012e();
                throw e;
            }
        }
        return -1;
    }

    public void releaseConnection() {
        close();
    }
}
