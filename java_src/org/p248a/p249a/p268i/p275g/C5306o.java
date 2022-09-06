package org.p248a.p249a.p268i.p275g;

import java.io.InputStream;
import org.apache.http.io.SessionInputBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p277j.AbstractC5317a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.g.o */
/* loaded from: classes2.dex */
public class C5306o extends InputStream {

    /* renamed from: a */
    private final SessionInputBuffer f22288a;

    /* renamed from: b */
    private boolean f22289b = false;

    public C5306o(SessionInputBuffer sessionInputBuffer) {
        this.f22288a = (SessionInputBuffer) C5351a.m1321a(sessionInputBuffer, "Session input buffer");
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f22288a instanceof AbstractC5317a) {
            return this.f22288a.mo1468c();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22289b = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f22289b) {
            return -1;
        }
        return this.f22288a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f22289b) {
            return -1;
        }
        return this.f22288a.read(bArr, i, i2);
    }
}
