package p244m.framework.p245a;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: m.framework.a.f */
/* loaded from: classes2.dex */
public class C4943f extends InputStream {

    /* renamed from: a */
    private ArrayList<InputStream> f21281a = new ArrayList<>();

    /* renamed from: b */
    private int f21282b;

    /* renamed from: a */
    private boolean m2578a() {
        return this.f21281a == null || this.f21281a.size() <= 0;
    }

    /* renamed from: a */
    public void m2577a(InputStream inputStream) {
        this.f21281a.add(inputStream);
    }

    @Override // java.io.InputStream
    public int available() {
        if (m2578a()) {
            return 0;
        }
        return this.f21281a.get(this.f21282b).available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<InputStream> it2 = this.f21281a.iterator();
        while (it2.hasNext()) {
            it2.next().close();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (m2578a()) {
            return -1;
        }
        int read = this.f21281a.get(this.f21282b).read();
        while (read < 0) {
            this.f21282b++;
            if (this.f21282b >= this.f21281a.size()) {
                return read;
            }
            read = this.f21281a.get(this.f21282b).read();
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (m2578a()) {
            return -1;
        }
        int read = this.f21281a.get(this.f21282b).read(bArr, i, i2);
        while (read < 0) {
            this.f21282b++;
            if (this.f21282b >= this.f21281a.size()) {
                return read;
            }
            read = this.f21281a.get(this.f21282b).read(bArr, i, i2);
        }
        return read;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        throw new IOException();
    }
}
