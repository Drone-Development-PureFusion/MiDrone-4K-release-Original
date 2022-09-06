package com.p118d.p119a.p120a.p125b.p126a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p125b.AbstractC1876c;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.d.a.a.b.a.e */
/* loaded from: classes.dex */
public class C1871e implements AbstractC1876c {

    /* renamed from: a */
    private final AbstractC1876c f6619a;

    /* renamed from: b */
    private final long f6620b;

    /* renamed from: c */
    private final Map<String, Long> f6621c = Collections.synchronizedMap(new HashMap());

    public C1871e(AbstractC1876c abstractC1876c, long j) {
        this.f6619a = abstractC1876c;
        this.f6620b = 1000 * j;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Bitmap mo14206a(String str) {
        Long l = this.f6621c.get(str);
        if (l != null && System.currentTimeMillis() - l.longValue() > this.f6620b) {
            this.f6619a.mo14203b(str);
            this.f6621c.remove(str);
        }
        return this.f6619a.mo14206a(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public Collection<String> mo14207a() {
        return this.f6619a.mo14207a();
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: a */
    public boolean mo14205a(String str, Bitmap bitmap) {
        boolean mo14205a = this.f6619a.mo14205a(str, bitmap);
        if (mo14205a) {
            this.f6621c.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        return mo14205a;
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public Bitmap mo14203b(String str) {
        this.f6621c.remove(str);
        return this.f6619a.mo14203b(str);
    }

    @Override // com.p118d.p119a.p120a.p125b.AbstractC1876c
    /* renamed from: b */
    public void mo14204b() {
        this.f6619a.mo14204b();
        this.f6621c.clear();
    }
}
