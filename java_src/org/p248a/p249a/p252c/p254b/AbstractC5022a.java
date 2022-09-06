package org.p248a.p249a.p252c.p254b;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.p248a.p249a.p267h.C5142g;
import org.p248a.p249a.p282o.C5351a;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.a.a.c.b.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5022a extends C5142g {

    /* renamed from: b */
    private static final int f21516b = 2048;

    /* renamed from: c */
    private InputStream f21517c;

    public AbstractC5022a(HttpEntity httpEntity) {
        super(httpEntity);
    }

    /* renamed from: a */
    private InputStream m2261a() {
        return new C5029g(this.f21805a.getContent(), this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract InputStream mo2235a(InputStream inputStream);

    @Override // org.p248a.p249a.p267h.C5142g
    public InputStream getContent() {
        if (this.f21805a.isStreaming()) {
            if (this.f21517c == null) {
                this.f21517c = m2261a();
            }
            return this.f21517c;
        }
        return m2261a();
    }

    @Override // org.p248a.p249a.p267h.C5142g
    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[2048];
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
