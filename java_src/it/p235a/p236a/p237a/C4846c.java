package it.p235a.p236a.p237a;

import com.github.moduth.blockcanary.p215b.C3947a;
import java.io.OutputStream;
/* renamed from: it.a.a.a.c */
/* loaded from: classes2.dex */
class C4846c extends OutputStream {

    /* renamed from: a */
    private OutputStream f20693a;

    /* renamed from: b */
    private int f20694b;

    /* renamed from: c */
    private int f20695c;

    /* renamed from: d */
    private int f20696d;

    /* renamed from: e */
    private int f20697e;

    public C4846c(OutputStream outputStream) {
        this(outputStream, 76);
    }

    public C4846c(OutputStream outputStream, int i) {
        this.f20693a = null;
        this.f20694b = 0;
        this.f20695c = 0;
        this.f20696d = 0;
        this.f20697e = 0;
        this.f20693a = outputStream;
        this.f20697e = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m3131a() {
        if (this.f20695c > 0) {
            if (this.f20697e > 0 && this.f20696d == this.f20697e) {
                this.f20693a.write(C3947a.f16890a.getBytes());
                this.f20696d = 0;
            }
            char charAt = C4844a.f20687a.charAt((this.f20694b << 8) >>> 26);
            char charAt2 = C4844a.f20687a.charAt((this.f20694b << 14) >>> 26);
            char charAt3 = this.f20695c < 2 ? C4844a.f20688b : C4844a.f20687a.charAt((this.f20694b << 20) >>> 26);
            char charAt4 = this.f20695c < 3 ? C4844a.f20688b : C4844a.f20687a.charAt((this.f20694b << 26) >>> 26);
            this.f20693a.write(charAt);
            this.f20693a.write(charAt2);
            this.f20693a.write(charAt3);
            this.f20693a.write(charAt4);
            this.f20696d += 4;
            this.f20695c = 0;
            this.f20694b = 0;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m3131a();
        this.f20693a.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f20694b = ((i & 255) << (16 - (this.f20695c * 8))) | this.f20694b;
        this.f20695c++;
        if (this.f20695c == 3) {
            m3131a();
        }
    }
}
