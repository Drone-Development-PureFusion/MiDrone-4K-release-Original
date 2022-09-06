package org.p248a.p249a.p267h;

import java.io.InputStream;
import java.io.OutputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5352b;
@AbstractC5006c
/* renamed from: org.a.a.h.b */
/* loaded from: classes2.dex */
public class C5137b extends AbstractC5136a {

    /* renamed from: e */
    private InputStream f21780e;

    /* renamed from: f */
    private long f21781f = -1;

    /* renamed from: a */
    public void m1949a(long j) {
        this.f21781f = j;
    }

    /* renamed from: a */
    public void m1948a(InputStream inputStream) {
        this.f21780e = inputStream;
    }

    public InputStream getContent() {
        C5352b.m1312a(this.f21780e != null, "Content has not been provided");
        return this.f21780e;
    }

    public long getContentLength() {
        return this.f21781f;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return this.f21780e != null;
    }

    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } finally {
            content.close();
        }
    }
}
