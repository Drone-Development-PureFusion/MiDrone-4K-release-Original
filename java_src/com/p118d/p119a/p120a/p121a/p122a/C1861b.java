package com.p118d.p119a.p120a.p121a.p122a;

import android.graphics.Bitmap;
import com.p118d.p119a.p120a.p121a.p124b.AbstractC1863a;
import com.p118d.p119a.p127b.C1877a;
import com.p118d.p119a.p136c.C1947c;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.d.a.a.a.a.b */
/* loaded from: classes.dex */
public class C1861b extends AbstractC1849a {

    /* renamed from: j */
    private final long f6607j;

    /* renamed from: k */
    private final Map<File, Long> f6608k;

    public C1861b(File file, long j) {
        this(file, null, C1877a.m14194b(), j);
    }

    public C1861b(File file, File file2, long j) {
        this(file, file2, C1877a.m14194b(), j);
    }

    public C1861b(File file, File file2, AbstractC1863a abstractC1863a, long j) {
        super(file, file2, abstractC1863a);
        this.f6608k = Collections.synchronizedMap(new HashMap());
        this.f6607j = 1000 * j;
    }

    /* renamed from: d */
    private void m14216d(String str) {
        File c = c(str);
        long currentTimeMillis = System.currentTimeMillis();
        c.setLastModified(currentTimeMillis);
        this.f6608k.put(c, Long.valueOf(currentTimeMillis));
    }

    @Override // com.p118d.p119a.p120a.p121a.p122a.AbstractC1849a, com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public File mo14221a(String str) {
        boolean z;
        File mo14221a = super.mo14221a(str);
        if (mo14221a != null && mo14221a.exists()) {
            Long l = this.f6608k.get(mo14221a);
            if (l == null) {
                z = false;
                l = Long.valueOf(mo14221a.lastModified());
            } else {
                z = true;
            }
            if (System.currentTimeMillis() - l.longValue() > this.f6607j) {
                mo14221a.delete();
                this.f6608k.remove(mo14221a);
            } else if (!z) {
                this.f6608k.put(mo14221a, l);
            }
        }
        return mo14221a;
    }

    @Override // com.p118d.p119a.p120a.p121a.p122a.AbstractC1849a, com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public boolean mo14220a(String str, Bitmap bitmap) {
        boolean mo14220a = super.mo14220a(str, bitmap);
        m14216d(str);
        return mo14220a;
    }

    @Override // com.p118d.p119a.p120a.p121a.p122a.AbstractC1849a, com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: a */
    public boolean mo14219a(String str, InputStream inputStream, C1947c.AbstractC1948a abstractC1948a) {
        boolean mo14219a = super.mo14219a(str, inputStream, abstractC1948a);
        m14216d(str);
        return mo14219a;
    }

    @Override // com.p118d.p119a.p120a.p121a.p122a.AbstractC1849a, com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: b */
    public boolean mo14218b(String str) {
        this.f6608k.remove(c(str));
        return super.mo14218b(str);
    }

    @Override // com.p118d.p119a.p120a.p121a.p122a.AbstractC1849a, com.p118d.p119a.p120a.p121a.AbstractC1848a
    /* renamed from: c */
    public void mo14217c() {
        super.mo14217c();
        this.f6608k.clear();
    }
}
