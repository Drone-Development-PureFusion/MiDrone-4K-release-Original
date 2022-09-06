package org.p248a.p249a.p268i.p275g;

import com.fimi.soul.media.player.FimiMediaMeta;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.io.SessionInputBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p277j.AbstractC5317a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.e */
/* loaded from: classes2.dex */
public class C5296e extends InputStream {

    /* renamed from: a */
    private static final int f22265a = 2048;

    /* renamed from: b */
    private final long f22266b;

    /* renamed from: c */
    private long f22267c = 0;

    /* renamed from: d */
    private boolean f22268d = false;

    /* renamed from: e */
    private SessionInputBuffer f22269e;

    public C5296e(SessionInputBuffer sessionInputBuffer, long j) {
        this.f22269e = null;
        this.f22269e = (SessionInputBuffer) C5351a.m1321a(sessionInputBuffer, "Session input buffer");
        this.f22266b = C5351a.m1316b(j, "Content length");
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f22269e instanceof AbstractC5317a) {
            return Math.min(this.f22269e.mo1468c(), (int) (this.f22266b - this.f22267c));
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f22268d) {
            try {
                if (this.f22267c >= this.f22266b) {
                }
                do {
                } while (read(new byte[2048]) >= 0);
            } finally {
                this.f22268d = true;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f22268d) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.f22267c >= this.f22266b) {
            return -1;
        }
        int read = this.f22269e.read();
        if (read != -1) {
            this.f22267c++;
        } else if (this.f22267c < this.f22266b) {
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.f22266b + "; received: " + this.f22267c);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f22268d) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.f22267c >= this.f22266b) {
            return -1;
        }
        if (this.f22267c + i2 > this.f22266b) {
            i2 = (int) (this.f22266b - this.f22267c);
        }
        int read = this.f22269e.read(bArr, i, i2);
        if (read == -1 && this.f22267c < this.f22266b) {
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.f22266b + "; received: " + this.f22267c);
        }
        if (read > 0) {
            this.f22267c += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int read;
        if (j <= 0) {
            return 0L;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j, this.f22266b - this.f22267c);
        long j2 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min((long) FimiMediaMeta.AV_CH_TOP_CENTER, min))) != -1) {
            j2 += read;
            min -= read;
        }
        return j2;
    }
}
