package com.google.p217a.p218a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* renamed from: com.google.a.a.c */
/* loaded from: classes.dex */
public final class C3992c {

    /* renamed from: a */
    private final byte[] f17070a;

    /* renamed from: b */
    private final int f17071b;

    /* renamed from: c */
    private int f17072c;

    /* renamed from: d */
    private final OutputStream f17073d;

    /* renamed from: com.google.a.a.c$a */
    /* loaded from: classes.dex */
    public static class C3993a extends IOException {
        C3993a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private C3992c(OutputStream outputStream, byte[] bArr) {
        this.f17073d = outputStream;
        this.f17070a = bArr;
        this.f17072c = 0;
        this.f17071b = bArr.length;
    }

    private C3992c(byte[] bArr, int i, int i2) {
        this.f17073d = null;
        this.f17070a = bArr;
        this.f17072c = i;
        this.f17071b = i + i2;
    }

    /* renamed from: a */
    public static C3992c m6267a(OutputStream outputStream) {
        return m6266a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C3992c m6266a(OutputStream outputStream, int i) {
        return new C3992c(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static C3992c m6262a(byte[] bArr, int i, int i2) {
        return new C3992c(bArr, i, i2);
    }

    /* renamed from: b */
    public static int m6257b(int i, C3990a c3990a) {
        return m6234f(i) + m6252b(c3990a);
    }

    /* renamed from: b */
    public static int m6256b(int i, AbstractC3995e abstractC3995e) {
        return m6234f(i) + m6251b(abstractC3995e);
    }

    /* renamed from: b */
    public static int m6255b(int i, String str) {
        return m6234f(i) + m6250b(str);
    }

    /* renamed from: b */
    public static int m6254b(int i, boolean z) {
        return m6234f(i) + m6249b(z);
    }

    /* renamed from: b */
    public static int m6252b(C3990a c3990a) {
        return m6231h(c3990a.m6309a()) + c3990a.m6309a();
    }

    /* renamed from: b */
    public static int m6251b(AbstractC3995e abstractC3995e) {
        int mo4526b = abstractC3995e.mo4526b();
        return mo4526b + m6231h(mo4526b);
    }

    /* renamed from: b */
    public static int m6250b(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + m6231h(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: b */
    public static int m6249b(boolean z) {
        return 1;
    }

    /* renamed from: c */
    public static int m6246c(int i) {
        if (i >= 0) {
            return m6231h(i);
        }
        return 10;
    }

    /* renamed from: c */
    public static int m6245c(int i, int i2) {
        return m6234f(i) + m6246c(i2);
    }

    /* renamed from: c */
    public static int m6244c(int i, long j) {
        return m6234f(i) + m6243c(j);
    }

    /* renamed from: c */
    public static int m6243c(long j) {
        return m6233f(j);
    }

    /* renamed from: d */
    public static int m6241d(int i) {
        return m6231h(i);
    }

    /* renamed from: d */
    public static int m6240d(int i, int i2) {
        return m6234f(i) + m6241d(i2);
    }

    /* renamed from: d */
    public static int m6239d(int i, long j) {
        return m6234f(i) + m6238d(j);
    }

    /* renamed from: d */
    public static int m6238d(long j) {
        return m6233f(j);
    }

    /* renamed from: d */
    private void m6242d() {
        if (this.f17073d == null) {
            throw new C3993a();
        }
        this.f17073d.write(this.f17070a, 0, this.f17072c);
        this.f17072c = 0;
    }

    /* renamed from: f */
    public static int m6234f(int i) {
        return m6231h(C3996f.m6216a(i, 0));
    }

    /* renamed from: f */
    public static int m6233f(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: h */
    public static int m6231h(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return ((-268435456) & i) == 0 ? 4 : 5;
    }

    /* renamed from: a */
    public void m6279a() {
        if (this.f17073d != null) {
            m6242d();
        }
    }

    /* renamed from: a */
    public void m6278a(byte b) {
        if (this.f17072c == this.f17071b) {
            m6242d();
        }
        byte[] bArr = this.f17070a;
        int i = this.f17072c;
        this.f17072c = i + 1;
        bArr[i] = b;
    }

    /* renamed from: a */
    public void m6277a(int i) {
        if (i >= 0) {
            m6232g(i);
        } else {
            m6235e(i);
        }
    }

    /* renamed from: a */
    public void m6276a(int i, int i2) {
        m6236e(i, 0);
        m6277a(i2);
    }

    /* renamed from: a */
    public void m6275a(int i, long j) {
        m6236e(i, 0);
        m6270a(j);
    }

    /* renamed from: a */
    public void m6274a(int i, C3990a c3990a) {
        m6236e(i, 2);
        m6269a(c3990a);
    }

    /* renamed from: a */
    public void m6273a(int i, AbstractC3995e abstractC3995e) {
        m6236e(i, 2);
        m6268a(abstractC3995e);
    }

    /* renamed from: a */
    public void m6272a(int i, String str) {
        m6236e(i, 2);
        m6265a(str);
    }

    /* renamed from: a */
    public void m6271a(int i, boolean z) {
        m6236e(i, 0);
        m6264a(z);
    }

    /* renamed from: a */
    public void m6270a(long j) {
        m6235e(j);
    }

    /* renamed from: a */
    public void m6269a(C3990a c3990a) {
        byte[] m6306b = c3990a.m6306b();
        m6232g(m6306b.length);
        m6263a(m6306b);
    }

    /* renamed from: a */
    public void m6268a(AbstractC3995e abstractC3995e) {
        m6232g(abstractC3995e.mo4533a());
        abstractC3995e.mo4529a(this);
    }

    /* renamed from: a */
    public void m6265a(String str) {
        byte[] bytes = str.getBytes("UTF-8");
        m6232g(bytes.length);
        m6263a(bytes);
    }

    /* renamed from: a */
    public void m6264a(boolean z) {
        m6237e(z ? 1 : 0);
    }

    /* renamed from: a */
    public void m6263a(byte[] bArr) {
        m6248b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public int m6261b() {
        if (this.f17073d == null) {
            return this.f17071b - this.f17072c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    /* renamed from: b */
    public void m6260b(int i) {
        m6232g(i);
    }

    /* renamed from: b */
    public void m6259b(int i, int i2) {
        m6236e(i, 0);
        m6260b(i2);
    }

    /* renamed from: b */
    public void m6258b(int i, long j) {
        m6236e(i, 0);
        m6253b(j);
    }

    /* renamed from: b */
    public void m6253b(long j) {
        m6235e(j);
    }

    /* renamed from: b */
    public void m6248b(byte[] bArr, int i, int i2) {
        if (this.f17071b - this.f17072c >= i2) {
            System.arraycopy(bArr, i, this.f17070a, this.f17072c, i2);
            this.f17072c += i2;
            return;
        }
        int i3 = this.f17071b - this.f17072c;
        System.arraycopy(bArr, i, this.f17070a, this.f17072c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f17072c = this.f17071b;
        m6242d();
        if (i5 > this.f17071b) {
            this.f17073d.write(bArr, i4, i5);
            return;
        }
        System.arraycopy(bArr, i4, this.f17070a, 0, i5);
        this.f17072c = i5;
    }

    /* renamed from: c */
    public void m6247c() {
        if (m6261b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: e */
    public void m6237e(int i) {
        m6278a((byte) i);
    }

    /* renamed from: e */
    public void m6236e(int i, int i2) {
        m6232g(C3996f.m6216a(i, i2));
    }

    /* renamed from: e */
    public void m6235e(long j) {
        while (((-128) & j) != 0) {
            m6237e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m6237e((int) j);
    }

    /* renamed from: g */
    public void m6232g(int i) {
        while ((i & (-128)) != 0) {
            m6237e((i & 127) | 128);
            i >>>= 7;
        }
        m6237e(i);
    }
}
