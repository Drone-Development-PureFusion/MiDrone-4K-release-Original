package com.p118d.p119a.p120a.p125b.p126a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1875b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/* renamed from: com.d.a.a.b.a.a */
/* loaded from: classes.dex */
public class C1867a extends AbstractC1875b {

    /* renamed from: a */
    private final List<Bitmap> f6612a = Collections.synchronizedList(new LinkedList());

    public C1867a(int i) {
        super(i);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1866a
    /* renamed from: a */
    protected Reference<Bitmap> mo14211a(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b, com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public boolean mo14205a(String str, Bitmap bitmap) {
        if (super.mo14205a(str, bitmap)) {
            this.f6612a.add(bitmap);
            return true;
        }
        return false;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b
    /* renamed from: b */
    protected int mo14210b(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b, com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public Bitmap mo14203b(String str) {
        Bitmap a = super.a(str);
        if (a != null) {
            this.f6612a.remove(a);
        }
        return super.mo14203b(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b, com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6612a.clear();
        super.mo14204b();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b
    /* renamed from: d */
    protected Bitmap mo14208d() {
        return this.f6612a.remove(0);
    }
}
