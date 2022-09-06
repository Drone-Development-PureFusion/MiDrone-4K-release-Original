package p004b.p005a.p006a.p028b.p033e;

import java.util.ArrayList;
import java.util.List;
/* renamed from: b.a.a.b.e.a */
/* loaded from: classes.dex */
public class C0288a<E> {

    /* renamed from: a */
    E[] f515a;

    /* renamed from: b */
    int f516b;

    /* renamed from: c */
    int f517c;

    /* renamed from: d */
    int f518d;

    /* renamed from: e */
    int f519e;

    public C0288a(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("The maxSize argument (" + i + ") is not a positive integer.");
        }
        m21028c(i);
    }

    public C0288a(C0288a<E> c0288a) {
        this.f519e = c0288a.f519e;
        this.f515a = (E[]) new Object[this.f519e];
        System.arraycopy(c0288a.f515a, 0, this.f515a, 0, this.f519e);
        this.f517c = c0288a.f517c;
        this.f516b = c0288a.f516b;
        this.f518d = c0288a.f518d;
    }

    /* renamed from: c */
    private void m21028c(int i) {
        this.f519e = i;
        this.f515a = (E[]) new Object[i];
        this.f516b = 0;
        this.f517c = 0;
        this.f518d = 0;
    }

    /* renamed from: a */
    public E m21033a(int i) {
        if (i < 0 || i >= this.f518d) {
            return null;
        }
        return this.f515a[(this.f516b + i) % this.f519e];
    }

    /* renamed from: a */
    public void m21034a() {
        m21028c(this.f519e);
    }

    /* renamed from: a */
    public void m21032a(E e) {
        this.f515a[this.f517c] = e;
        int i = this.f517c + 1;
        this.f517c = i;
        if (i == this.f519e) {
            this.f517c = 0;
        }
        if (this.f518d < this.f519e) {
            this.f518d++;
            return;
        }
        int i2 = this.f516b + 1;
        this.f516b = i2;
        if (i2 != this.f519e) {
            return;
        }
        this.f516b = 0;
    }

    /* renamed from: b */
    public int m21031b() {
        return this.f519e;
    }

    /* renamed from: b */
    public void m21030b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative array size [" + i + "] not allowed.");
        }
        if (i == this.f518d) {
            return;
        }
        E[] eArr = (E[]) new Object[i];
        int i2 = i < this.f518d ? i : this.f518d;
        for (int i3 = 0; i3 < i2; i3++) {
            eArr[i3] = this.f515a[this.f516b];
            this.f515a[this.f516b] = null;
            int i4 = this.f516b + 1;
            this.f516b = i4;
            if (i4 == this.f518d) {
                this.f516b = 0;
            }
        }
        this.f515a = eArr;
        this.f516b = 0;
        this.f518d = i2;
        this.f519e = i;
        if (i2 == i) {
            this.f517c = 0;
        } else {
            this.f517c = i2;
        }
    }

    /* renamed from: c */
    public E m21029c() {
        if (this.f518d > 0) {
            this.f518d--;
            E e = this.f515a[this.f516b];
            this.f515a[this.f516b] = null;
            int i = this.f516b + 1;
            this.f516b = i;
            if (i != this.f519e) {
                return e;
            }
            this.f516b = 0;
            return e;
        }
        return null;
    }

    /* renamed from: d */
    public List<E> m21027d() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < m21026e(); i++) {
            arrayList.add(m21033a(i));
        }
        return arrayList;
    }

    /* renamed from: e */
    public int m21026e() {
        return this.f518d;
    }
}
