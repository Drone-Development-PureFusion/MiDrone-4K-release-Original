package org.p248a.p249a.p267h;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.h.i */
/* loaded from: classes2.dex */
public class C5144i extends AbstractC5136a {

    /* renamed from: e */
    private byte[] f21808e;

    /* renamed from: f */
    private Serializable f21809f;

    public C5144i(Serializable serializable) {
        C5351a.m1321a(serializable, "Source object");
        this.f21809f = serializable;
    }

    public C5144i(Serializable serializable, boolean z) {
        C5351a.m1321a(serializable, "Source object");
        if (z) {
            m1934a(serializable);
        } else {
            this.f21809f = serializable;
        }
    }

    /* renamed from: a */
    private void m1934a(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        objectOutputStream.flush();
        this.f21808e = byteArrayOutputStream.toByteArray();
    }

    public InputStream getContent() {
        if (this.f21808e == null) {
            m1934a(this.f21809f);
        }
        return new ByteArrayInputStream(this.f21808e);
    }

    public long getContentLength() {
        if (this.f21808e == null) {
            return -1L;
        }
        return this.f21808e.length;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return this.f21808e == null;
    }

    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        if (this.f21808e != null) {
            outputStream.write(this.f21808e);
            outputStream.flush();
            return;
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.f21809f);
        objectOutputStream.flush();
    }
}
