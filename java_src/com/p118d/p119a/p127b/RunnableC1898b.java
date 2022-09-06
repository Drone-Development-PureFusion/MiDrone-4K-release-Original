package com.p118d.p119a.p127b;

import android.graphics.Bitmap;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p127b.p131c.AbstractC1907a;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
import com.p118d.p119a.p127b.p134f.AbstractC1932a;
import com.p118d.p119a.p136c.C1949d;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.d.a.b.b */
/* loaded from: classes.dex */
public final class RunnableC1898b implements Runnable {

    /* renamed from: a */
    private static final String f6684a = "Display image in ImageAware (loaded from %1$s) [%2$s]";

    /* renamed from: b */
    private static final String f6685b = "ImageAware is reused for another image. Task is cancelled. [%s]";

    /* renamed from: c */
    private static final String f6686c = "ImageAware was collected by GC. Task is cancelled. [%s]";

    /* renamed from: d */
    private final Bitmap f6687d;

    /* renamed from: e */
    private final String f6688e;

    /* renamed from: f */
    private final AbstractC1926a f6689f;

    /* renamed from: g */
    private final String f6690g;

    /* renamed from: h */
    private final AbstractC1907a f6691h;

    /* renamed from: i */
    private final AbstractC1932a f6692i;

    /* renamed from: j */
    private final C1930f f6693j;

    /* renamed from: k */
    private final EnumC1894f f6694k;

    public RunnableC1898b(Bitmap bitmap, C1936g c1936g, C1930f c1930f, EnumC1894f enumC1894f) {
        this.f6687d = bitmap;
        this.f6688e = c1936g.f6877a;
        this.f6689f = c1936g.f6879c;
        this.f6690g = c1936g.f6878b;
        this.f6691h = c1936g.f6881e.m14091q();
        this.f6692i = c1936g.f6882f;
        this.f6693j = c1930f;
        this.f6694k = enumC1894f;
    }

    /* renamed from: a */
    private boolean m14148a() {
        return !this.f6690g.equals(this.f6693j.m13917a(this.f6689f));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6689f.mo13920e()) {
            C1949d.m13854a(f6686c, this.f6690g);
            this.f6692i.mo13893b(this.f6688e, this.f6689f.mo13921d());
        } else if (m14148a()) {
            C1949d.m13854a(f6685b, this.f6690g);
            this.f6692i.mo13893b(this.f6688e, this.f6689f.mo13921d());
        } else {
            C1949d.m13854a(f6684a, this.f6694k, this.f6690g);
            this.f6691h.mo14037a(this.f6687d, this.f6689f, this.f6694k);
            this.f6693j.m13908b(this.f6689f);
            this.f6692i.mo13895a(this.f6688e, this.f6689f.mo13921d(), this.f6687d);
        }
    }
}
