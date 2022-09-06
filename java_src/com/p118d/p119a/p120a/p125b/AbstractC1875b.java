package com.p118d.p119a.p120a.p125b;

import android.graphics.Bitmap;
import com.p118d.p119a.p136c.C1949d;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: com.d.a.a.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC1875b extends AbstractC1866a {

    /* renamed from: a */
    private static final int f6626a = 16;

    /* renamed from: b */
    private static final int f6627b = 16777216;

    /* renamed from: c */
    private final int f6628c;

    /* renamed from: e */
    private final List<Bitmap> f6630e = Collections.synchronizedList(new LinkedList());

    /* renamed from: d */
    private final AtomicInteger f6629d = new AtomicInteger();

    public AbstractC1875b(int i) {
        this.f6628c = i;
        if (i > 16777216) {
            C1949d.m13847c("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public boolean mo14205a(String str, Bitmap bitmap) {
        boolean z = false;
        int mo14210b = mo14210b(bitmap);
        int m14209c = m14209c();
        int i = this.f6629d.get();
        if (mo14210b < m14209c) {
            int i2 = i;
            while (i2 + mo14210b > m14209c) {
                Bitmap mo14208d = mo14208d();
                if (this.f6630e.remove(mo14208d)) {
                    i2 = this.f6629d.addAndGet(-mo14210b(mo14208d));
                }
            }
            this.f6630e.add(bitmap);
            this.f6629d.addAndGet(mo14210b);
            z = true;
        }
        super.mo14205a(str, bitmap);
        return z;
    }

    /* renamed from: b */
    protected abstract int mo14210b(Bitmap bitmap);

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public Bitmap mo14203b(String str) {
        Bitmap mo14206a = super.mo14206a(str);
        if (mo14206a != null && this.f6630e.remove(mo14206a)) {
            this.f6629d.addAndGet(-mo14210b(mo14206a));
        }
        return super.mo14203b(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6630e.clear();
        this.f6629d.set(0);
        super.mo14204b();
    }

    /* renamed from: c */
    protected int m14209c() {
        return this.f6628c;
    }

    /* renamed from: d */
    protected abstract Bitmap mo14208d();
}
