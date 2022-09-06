package com.google.p217a.p218a;

import java.io.IOException;
/* renamed from: com.google.a.a.e */
/* loaded from: classes.dex */
public abstract class AbstractC3995e {
    /* renamed from: a */
    public abstract int mo4533a();

    /* renamed from: a */
    public abstract AbstractC3995e mo4530a(C3991b c3991b);

    /* renamed from: a */
    public AbstractC3995e m6221a(byte[] bArr) {
        return m6219b(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public abstract void mo4529a(C3992c c3992c);

    /* renamed from: a */
    public void m6220a(byte[] bArr, int i, int i2) {
        try {
            C3992c m6262a = C3992c.m6262a(bArr, i, i2);
            mo4529a(m6262a);
            m6262a.m6247c();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m6222a(C3991b c3991b, int i) {
        return c3991b.m6298b(i);
    }

    /* renamed from: b */
    public abstract int mo4526b();

    /* renamed from: b */
    public AbstractC3995e m6219b(byte[] bArr, int i, int i2) {
        try {
            C3991b m6300a = C3991b.m6300a(bArr, i, i2);
            mo4530a(m6300a);
            m6300a.m6304a(0);
            return this;
        } catch (C3994d e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: c */
    public byte[] m6218c() {
        byte[] bArr = new byte[mo4526b()];
        m6220a(bArr, 0, bArr.length);
        return bArr;
    }
}
