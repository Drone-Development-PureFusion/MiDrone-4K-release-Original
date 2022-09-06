package p004b.p005a.p006a.p028b.p031c;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
/* renamed from: b.a.a.b.c.h */
/* loaded from: classes.dex */
public class C0282h<E> extends AbstractC0278d<E> {

    /* renamed from: c */
    public static final int f496c = 1853421169;

    /* renamed from: d */
    public static final int f497d = 640373619;

    /* renamed from: f */
    private int f499f = 100;

    /* renamed from: e */
    List<E> f498e = new ArrayList(this.f499f);

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0277c
    /* renamed from: a */
    public void mo21055a() {
        m21050b();
    }

    /* renamed from: a */
    void m21054a(ByteArrayOutputStream byteArrayOutputStream, int i) {
        C0275a.m21077a(byteArrayOutputStream, (int) f496c);
        C0275a.m21077a(byteArrayOutputStream, i);
        C0275a.m21077a(byteArrayOutputStream, 0);
        C0275a.m21077a(byteArrayOutputStream, 1853421169 ^ i);
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0278d, p004b.p005a.p006a.p028b.p031c.AbstractC0277c
    /* renamed from: a */
    public void mo21053a(OutputStream outputStream) {
        super.mo21053a(outputStream);
        this.f498e.clear();
    }

    @Override // p004b.p005a.p006a.p028b.p031c.AbstractC0277c
    /* renamed from: a */
    public void mo21052a(E e) {
        this.f498e.add(e);
        if (this.f498e.size() == this.f499f) {
            m21050b();
        }
    }

    /* renamed from: a */
    void m21051a(byte[] bArr) {
        C0275a.m21073a(bArr, 8, bArr.length - 8);
    }

    /* renamed from: b */
    void m21050b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10000);
        int size = this.f498e.size();
        m21054a(byteArrayOutputStream, size);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        for (E e : this.f498e) {
            objectOutputStream.writeObject(e);
        }
        this.f498e.clear();
        objectOutputStream.flush();
        m21049b(byteArrayOutputStream, size);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        objectOutputStream.close();
        m21051a(byteArray);
        this.f489b.write(byteArray);
    }

    /* renamed from: b */
    void m21049b(ByteArrayOutputStream byteArrayOutputStream, int i) {
        C0275a.m21077a(byteArrayOutputStream, (int) f497d);
        C0275a.m21077a(byteArrayOutputStream, 640373619 ^ i);
    }
}
