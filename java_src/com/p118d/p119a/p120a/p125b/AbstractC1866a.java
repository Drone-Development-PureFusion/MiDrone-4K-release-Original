package com.p118d.p119a.p120a.p125b;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* renamed from: com.d.a.a.b.a */
/* loaded from: classes.dex */
public abstract class AbstractC1866a implements AbstractC1876c {

    /* renamed from: a */
    private final Map<String, Reference<Bitmap>> f6611a = Collections.synchronizedMap(new HashMap());

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Bitmap mo14206a(String str) {
        Reference<Bitmap> reference = this.f6611a.get(str);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    /* renamed from: a */
    protected abstract Reference<Bitmap> mo14211a(Bitmap bitmap);

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Collection<String> mo14207a() {
        HashSet hashSet;
        synchronized (this.f6611a) {
            hashSet = new HashSet(this.f6611a.keySet());
        }
        return hashSet;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public boolean mo14205a(String str, Bitmap bitmap) {
        this.f6611a.put(str, mo14211a(bitmap));
        return true;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public Bitmap mo14203b(String str) {
        Reference<Bitmap> remove = this.f6611a.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6611a.clear();
    }
}
