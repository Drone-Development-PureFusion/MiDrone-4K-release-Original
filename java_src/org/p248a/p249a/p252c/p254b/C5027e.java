package org.p248a.p249a.p252c.p254b;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.p248a.p249a.p267h.C5142g;
import org.p248a.p249a.p282o.C5351a;
/* renamed from: org.a.a.c.b.e */
/* loaded from: classes2.dex */
public class C5027e extends C5142g {

    /* renamed from: b */
    private static final String f21530b = "gzip";

    public C5027e(HttpEntity httpEntity) {
        super(httpEntity);
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public Header getContentEncoding() {
        return new BasicHeader("Content-Encoding", "gzip");
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public long getContentLength() {
        return -1L;
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public boolean isChunked() {
        return true;
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        this.f21805a.writeTo(gZIPOutputStream);
        gZIPOutputStream.close();
    }
}
