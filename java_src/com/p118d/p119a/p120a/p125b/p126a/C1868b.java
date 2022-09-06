package com.p118d.p119a.p120a.p125b.p126a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
/* renamed from: com.d.a.a.b.a.b */
/* loaded from: classes.dex */
public class C1868b implements AbstractC1876c {

    /* renamed from: a */
    private final AbstractC1876c f6613a;

    /* renamed from: b */
    private final Comparator<String> f6614b;

    public C1868b(AbstractC1876c abstractC1876c, Comparator<String> comparator) {
        this.f6613a = abstractC1876c;
        this.f6614b = comparator;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Bitmap mo14206a(String str) {
        return this.f6613a.mo14206a(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Collection<String> mo14207a() {
        return this.f6613a.mo14207a();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public boolean mo14205a(String str, Bitmap bitmap) {
        String str2;
        synchronized (this.f6613a) {
            Iterator<String> it2 = this.f6613a.mo14207a().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str2 = null;
                    break;
                }
                str2 = it2.next();
                if (this.f6614b.compare(str, str2) == 0) {
                    break;
                }
            }
            if (str2 != null) {
                this.f6613a.mo14203b(str2);
            }
        }
        return this.f6613a.mo14205a(str, bitmap);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public Bitmap mo14203b(String str) {
        return this.f6613a.mo14203b(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6613a.mo14204b();
    }
}
