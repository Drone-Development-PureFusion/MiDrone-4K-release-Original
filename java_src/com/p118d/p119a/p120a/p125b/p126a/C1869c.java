package com.p118d.p119a.p120a.p125b.p126a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1875b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* renamed from: com.d.a.a.b.a.c */
/* loaded from: classes.dex */
public class C1869c extends AbstractC1875b {

    /* renamed from: a */
    private static final int f6615a = 10;

    /* renamed from: b */
    private static final float f6616b = 1.1f;

    /* renamed from: c */
    private final Map<String, Bitmap> f6617c = Collections.synchronizedMap(new LinkedHashMap(10, f6616b, true));

    public C1869c(int i) {
        super(i);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Bitmap mo14206a(String str) {
        this.f6617c.get(str);
        return super.a(str);
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
            this.f6617c.put(str, bitmap);
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
        this.f6617c.remove(str);
        return super.mo14203b(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b, com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6617c.clear();
        super.mo14204b();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b
    /* renamed from: d */
    protected Bitmap mo14208d() {
        Bitmap bitmap = null;
        synchronized (this.f6617c) {
            Iterator<Map.Entry<String, Bitmap>> it2 = this.f6617c.entrySet().iterator();
            if (it2.hasNext()) {
                bitmap = it2.next().getValue();
                it2.remove();
            }
        }
        return bitmap;
    }
}
