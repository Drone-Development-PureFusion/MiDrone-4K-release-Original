package com.p118d.p119a.p120a.p125b.p126a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1875b;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* renamed from: com.d.a.a.b.a.g */
/* loaded from: classes.dex */
public class C1873g extends AbstractC1875b {

    /* renamed from: a */
    private final Map<Bitmap, Integer> f6625a = Collections.synchronizedMap(new HashMap());

    public C1873g(int i) {
        super(i);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Bitmap mo14206a(String str) {
        Integer num;
        Bitmap a = super.a(str);
        if (a != null && (num = this.f6625a.get(a)) != null) {
            this.f6625a.put(a, Integer.valueOf(num.intValue() + 1));
        }
        return a;
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
            this.f6625a.put(bitmap, 0);
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
            this.f6625a.remove(a);
        }
        return super.mo14203b(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b, com.p118d.p119a.p120a.p125b.AbstractC1866a, com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6625a.clear();
        super.mo14204b();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1875b
    /* renamed from: d */
    protected Bitmap mo14208d() {
        Bitmap bitmap;
        Integer num;
        Bitmap bitmap2 = null;
        Set<Map.Entry<Bitmap, Integer>> entrySet = this.f6625a.entrySet();
        synchronized (this.f6625a) {
            Integer num2 = null;
            for (Map.Entry<Bitmap, Integer> entry : entrySet) {
                if (bitmap2 == null) {
                    bitmap = entry.getKey();
                    num = entry.getValue();
                } else {
                    Integer value = entry.getValue();
                    if (value.intValue() < num2.intValue()) {
                        Bitmap key = entry.getKey();
                        num = value;
                        bitmap = key;
                    } else {
                        bitmap = bitmap2;
                        num = num2;
                    }
                }
                bitmap2 = bitmap;
                num2 = num;
            }
        }
        this.f6625a.remove(bitmap2);
        return bitmap2;
    }
}
