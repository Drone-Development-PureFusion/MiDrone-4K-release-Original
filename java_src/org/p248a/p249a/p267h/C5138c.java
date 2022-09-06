package org.p248a.p249a.p267h;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5354d;
@AbstractC5006c
/* renamed from: org.a.a.h.c */
/* loaded from: classes2.dex */
public class C5138c extends C5142g {

    /* renamed from: b */
    private final byte[] f21782b;

    public C5138c(HttpEntity httpEntity) {
        super(httpEntity);
        if (!httpEntity.isRepeatable() || httpEntity.getContentLength() < 0) {
            this.f21782b = C5354d.m1302c(httpEntity);
        } else {
            this.f21782b = null;
        }
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public InputStream getContent() {
        return this.f21782b != null ? new ByteArrayInputStream(this.f21782b) : super.getContent();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public long getContentLength() {
        return this.f21782b != null ? this.f21782b.length : super.getContentLength();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public boolean isChunked() {
        return this.f21782b == null && super.isChunked();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public boolean isStreaming() {
        return this.f21782b == null && super.isStreaming();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        if (this.f21782b != null) {
            outputStream.write(this.f21782b);
        } else {
            super.writeTo(outputStream);
        }
    }
}
