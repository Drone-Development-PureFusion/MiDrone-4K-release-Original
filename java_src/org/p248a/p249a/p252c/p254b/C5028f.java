package org.p248a.p249a.p252c.p254b;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
/* renamed from: org.a.a.c.b.f */
/* loaded from: classes2.dex */
public class C5028f extends AbstractC5022a {
    public C5028f(HttpEntity httpEntity) {
        super(httpEntity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.p248a.p249a.p252c.p254b.AbstractC5022a
    /* renamed from: a */
    public InputStream mo2235a(InputStream inputStream) {
        return new GZIPInputStream(inputStream);
    }

    @Override // org.p248a.p249a.p252c.p254b.AbstractC5022a, org.p248a.p249a.p267h.C5142g
    public /* bridge */ /* synthetic */ InputStream getContent() {
        return super.getContent();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public Header getContentEncoding() {
        return null;
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public long getContentLength() {
        return -1L;
    }

    @Override // org.p248a.p249a.p252c.p254b.AbstractC5022a, org.p248a.p249a.p267h.C5142g
    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) {
        super.writeTo(outputStream);
    }
}
