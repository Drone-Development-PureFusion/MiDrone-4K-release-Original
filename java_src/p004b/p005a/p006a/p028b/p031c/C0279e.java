package p004b.p005a.p006a.p028b.p031c;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
/* renamed from: b.a.a.b.c.e */
/* loaded from: classes.dex */
public class C0279e<E> extends InputStream {

    /* renamed from: a */
    C0281g f490a;

    /* renamed from: b */
    List<E> f491b = new ArrayList();

    /* renamed from: c */
    int f492c = 0;

    C0279e(InputStream inputStream) {
        this.f490a = new C0281g(inputStream);
    }

    /* renamed from: d */
    private void m21066d() {
        this.f492c = 0;
        this.f491b.clear();
    }

    /* renamed from: a */
    public E m21072a() {
        E m21069b = m21069b();
        if (m21069b != null) {
            return m21069b;
        }
        m21066d();
        int m21067c = m21067c();
        if (m21067c == -1) {
            return null;
        }
        m21068b(m21067c);
        m21071a(m21067c);
        return m21069b();
    }

    /* renamed from: a */
    E m21070a(ObjectInputStream objectInputStream) {
        E e;
        ClassNotFoundException e2;
        try {
            e = (E) objectInputStream.readObject();
            try {
                this.f491b.add(e);
            } catch (ClassNotFoundException e3) {
                e2 = e3;
                e2.printStackTrace();
                return e;
            }
        } catch (ClassNotFoundException e4) {
            e = null;
            e2 = e4;
        }
        return e;
    }

    /* renamed from: a */
    void m21071a(int i) {
        byte[] bArr = new byte[8];
        if (this.f490a.read(bArr) == -1) {
            throw new IllegalStateException("Looks like a corrupt stream");
        }
        if (C0275a.m21074a(bArr, 0) != 640373619) {
            throw new IllegalStateException("Looks like a corrupt stream");
        }
        if (C0275a.m21074a(bArr, 4) == (640373619 ^ i)) {
            return;
        }
        throw new IllegalStateException("Invalid checksum");
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f490a.available();
    }

    /* renamed from: b */
    E m21069b() {
        if (this.f492c >= this.f491b.size()) {
            return null;
        }
        List<E> list = this.f491b;
        int i = this.f492c;
        this.f492c = i + 1;
        return list.get(i);
    }

    /* renamed from: b */
    void m21068b(int i) {
        ArrayList arrayList = new ArrayList(i);
        ObjectInputStream objectInputStream = new ObjectInputStream(this.f490a);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(m21070a(objectInputStream));
        }
        objectInputStream.close();
    }

    /* renamed from: c */
    int m21067c() {
        int i = -1;
        byte[] bArr = new byte[16];
        if (this.f490a.read(bArr) != -1) {
            if (C0275a.m21074a(bArr, 0) != 1853421169) {
                throw new IllegalStateException("Does not look like data created by ObjectStreamEncoder");
            }
            i = C0275a.m21074a(bArr, 4);
            if (C0275a.m21074a(bArr, 12) != (1853421169 ^ i)) {
                throw new IllegalStateException("Invalid checksum");
            }
        }
        return i;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f490a.m21056a();
    }

    @Override // java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Only the readEvent method is supported.");
    }
}
