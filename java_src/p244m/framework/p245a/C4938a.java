package p244m.framework.p245a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import p244m.framework.p246b.C4949a;
/* renamed from: m.framework.a.a */
/* loaded from: classes2.dex */
public class C4938a extends AbstractC4940c {

    /* renamed from: a */
    private byte[] f21276a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: a */
    public InputStream mo2564a() {
        return (this.f21276a == null || this.f21276a.length <= 0) ? new ByteArrayInputStream(new byte[0]) : new ByteArrayInputStream(this.f21276a);
    }

    /* renamed from: a */
    public C4938a m2583a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f21276a != null && this.f21276a.length > 0) {
            byteArrayOutputStream.write(this.f21276a);
        }
        byteArrayOutputStream.write(bArr);
        byteArrayOutputStream.flush();
        this.f21276a = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: b */
    public long mo2562b() {
        return this.f21276a == null ? 0 : this.f21276a.length;
    }

    public String toString() {
        return C4949a.m2556a(this.f21276a);
    }
}
