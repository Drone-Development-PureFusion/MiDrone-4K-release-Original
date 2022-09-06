package com.p078a.p079a;

import java.nio.ByteBuffer;
/* renamed from: com.a.a.e */
/* loaded from: classes.dex */
class C0727e implements AbstractC0745u {

    /* renamed from: a */
    private final String f1790a;

    public C0727e() {
        this.f1790a = null;
    }

    public C0727e(String str) {
        this.f1790a = str;
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: a */
    public String mo19201a(byte[] bArr) {
        return this.f1790a == null ? new String(bArr) : new String(bArr, this.f1790a);
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: a */
    public boolean mo19202a(String str) {
        return true;
    }

    @Override // com.p078a.p079a.AbstractC0745u
    /* renamed from: b */
    public ByteBuffer mo19200b(String str) {
        return this.f1790a == null ? ByteBuffer.wrap(str.getBytes()) : ByteBuffer.wrap(str.getBytes(this.f1790a));
    }
}
