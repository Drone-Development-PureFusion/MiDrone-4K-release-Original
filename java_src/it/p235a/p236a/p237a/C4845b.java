package it.p235a.p236a.p237a;

import java.io.IOException;
import java.io.InputStream;
/* renamed from: it.a.a.a.b */
/* loaded from: classes2.dex */
class C4845b extends InputStream {

    /* renamed from: a */
    private InputStream f20689a;

    /* renamed from: b */
    private int[] f20690b;

    /* renamed from: c */
    private int f20691c = 0;

    /* renamed from: d */
    private boolean f20692d = false;

    public C4845b(InputStream inputStream) {
        this.f20689a = inputStream;
    }

    /* renamed from: a */
    private void m3132a() {
        int i = 1;
        char[] cArr = new char[4];
        int i2 = 0;
        do {
            int read = this.f20689a.read();
            if (read == -1) {
                if (i2 != 0) {
                    throw new IOException("Bad base64 stream");
                }
                this.f20690b = new int[0];
                this.f20692d = true;
                return;
            }
            char c = (char) read;
            if (C4844a.f20687a.indexOf(c) != -1 || c == C4844a.f20688b) {
                cArr[i2] = c;
                i2++;
                continue;
            } else if (c != '\r' && c != '\n') {
                throw new IOException("Bad base64 stream");
            }
        } while (i2 < 4);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            if (cArr[i3] != C4844a.f20688b) {
                if (z) {
                    throw new IOException("Bad base64 stream");
                }
            } else if (!z) {
                z = true;
            }
        }
        if (cArr[3] != C4844a.f20688b) {
            i = 3;
        } else if (this.f20689a.read() != -1) {
            throw new IOException("Bad base64 stream");
        } else {
            this.f20692d = true;
            if (cArr[2] != C4844a.f20688b) {
                i = 2;
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 4; i5++) {
            if (cArr[i5] != C4844a.f20688b) {
                i4 |= C4844a.f20687a.indexOf(cArr[i5]) << ((3 - i5) * 6);
            }
        }
        this.f20690b = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            this.f20690b[i6] = (i4 >>> ((2 - i6) * 8)) & 255;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f20689a.close();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f20690b == null || this.f20691c == this.f20690b.length) {
            if (this.f20692d) {
                return -1;
            }
            m3132a();
            if (this.f20690b.length == 0) {
                this.f20690b = null;
                return -1;
            }
            this.f20691c = 0;
        }
        int[] iArr = this.f20690b;
        int i = this.f20691c;
        this.f20691c = i + 1;
        return iArr[i];
    }
}
