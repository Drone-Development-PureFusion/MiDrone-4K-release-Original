package com.fimi.soul.biz.camera;

import com.fimi.soul.biz.camera.p172b.AbstractC2385c;
import com.fimi.soul.biz.camera.p173c.AbstractC2404a;
import com.fimi.soul.biz.camera.p173c.C2405b;
import com.fimi.soul.biz.camera.p173c.C2410c;
import com.fimi.soul.biz.camera.p173c.C2416d;
import com.fimi.soul.biz.camera.p173c.C2420e;
import com.fimi.soul.biz.camera.p173c.C2421f;
import com.fimi.soul.biz.camera.p173c.C2422g;
import java.text.SimpleDateFormat;
import java.util.Date;
/* renamed from: com.fimi.soul.biz.camera.d */
/* loaded from: classes.dex */
public class C2423d extends AbstractC2390c {

    /* renamed from: d */
    private C2410c f8162d = new C2410c(this);

    /* renamed from: e */
    private C2416d f8163e = new C2416d(this);

    /* renamed from: f */
    private C2421f f8164f = new C2421f(this);

    /* renamed from: g */
    private C2420e f8165g = new C2420e(this);

    /* renamed from: h */
    private C2422g f8166h = new C2422g(this);

    /* renamed from: i */
    private C2405b f8167i = new C2405b(this);

    public C2423d(AbstractC2385c abstractC2385c) {
        super(abstractC2385c);
        a((AbstractC2404a) this.f8162d);
        a((AbstractC2404a) this.f8163e);
        a((AbstractC2404a) this.f8164f);
        a((AbstractC2404a) this.f8165g);
        a((AbstractC2404a) this.f8166h);
        a((AbstractC2404a) this.f8167i);
    }

    /* renamed from: t */
    public C2422g m12234t() {
        return this.f8166h;
    }

    /* renamed from: u */
    public C2410c m12233u() {
        return this.f8162d;
    }

    /* renamed from: v */
    public C2416d m12232v() {
        return this.f8163e;
    }

    /* renamed from: w */
    public C2421f m12231w() {
        return this.f8164f;
    }

    /* renamed from: x */
    public C2420e m12230x() {
        return C2379b.m12410a().m12401b() ? this.f8165g : this.f8167i;
    }

    /* renamed from: y */
    public C2420e m12229y() {
        return this.f8165g;
    }

    /* renamed from: z */
    public void m12228z() {
        m12233u().m12298a(C2427e.f8252bB, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
