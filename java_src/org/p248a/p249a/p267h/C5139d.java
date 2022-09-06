package org.p248a.p249a.p267h;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.h.d */
/* loaded from: classes.dex */
public class C5139d extends AbstractC5136a implements Cloneable {
    @Deprecated

    /* renamed from: e */
    protected final byte[] f21783e;

    /* renamed from: f */
    private final byte[] f21784f;

    /* renamed from: g */
    private final int f21785g;

    /* renamed from: h */
    private final int f21786h;

    public C5139d(byte[] bArr) {
        this(bArr, null);
    }

    public C5139d(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, null);
    }

    public C5139d(byte[] bArr, int i, int i2, C5140e c5140e) {
        C5351a.m1321a(bArr, "Source byte array");
        if (i < 0 || i > bArr.length || i2 < 0 || i + i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
        }
        this.f21783e = bArr;
        this.f21784f = bArr;
        this.f21785g = i;
        this.f21786h = i2;
        if (c5140e == null) {
            return;
        }
        a(c5140e.toString());
    }

    public C5139d(byte[] bArr, C5140e c5140e) {
        C5351a.m1321a(bArr, "Source byte array");
        this.f21783e = bArr;
        this.f21784f = bArr;
        this.f21785g = 0;
        this.f21786h = this.f21784f.length;
        if (c5140e != null) {
            a(c5140e.toString());
        }
    }

    public Object clone() {
        return super.clone();
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.f21784f, this.f21785g, this.f21786h);
    }

    public long getContentLength() {
        return this.f21786h;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public void writeTo(OutputStream outputStream) {
        C5351a.m1321a(outputStream, "Output stream");
        outputStream.write(this.f21784f, this.f21785g, this.f21786h);
        outputStream.flush();
    }
}
