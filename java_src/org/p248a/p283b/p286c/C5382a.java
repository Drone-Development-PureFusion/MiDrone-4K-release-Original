package org.p248a.p283b.p286c;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* renamed from: org.a.b.c.a */
/* loaded from: classes2.dex */
public class C5382a extends AbstractC5385d {

    /* renamed from: a */
    protected InputStream f22455a;

    /* renamed from: b */
    protected OutputStream f22456b;

    protected C5382a() {
        this.f22455a = null;
        this.f22456b = null;
    }

    public C5382a(OutputStream outputStream) {
        this.f22455a = null;
        this.f22456b = null;
        this.f22456b = outputStream;
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: a */
    public int mo1215a(byte[] bArr, int i, int i2) {
        if (this.f22455a == null) {
            throw new C5386e(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f22455a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new C5386e(4);
        } catch (IOException e) {
            throw new C5386e(0, e);
        }
    }

    @Override // org.p248a.p283b.p286c.AbstractC5385d
    /* renamed from: b */
    public void mo1213b(byte[] bArr, int i, int i2) {
        if (this.f22456b == null) {
            throw new C5386e(1, "Cannot write to null outputStream");
        }
        try {
            this.f22456b.write(bArr, i, i2);
        } catch (IOException e) {
            throw new C5386e(0, e);
        }
    }
}
