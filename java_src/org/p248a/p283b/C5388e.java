package org.p248a.p283b;

import org.p248a.p283b.p285b.AbstractC5373e;
import org.p248a.p283b.p285b.AbstractC5375g;
import org.p248a.p283b.p285b.C5368a;
import org.p248a.p283b.p286c.C5384c;
/* renamed from: org.a.b.e */
/* loaded from: classes2.dex */
public class C5388e {

    /* renamed from: a */
    private final AbstractC5373e f22463a;

    /* renamed from: b */
    private final C5384c f22464b;

    public C5388e() {
        this(new C5368a.C5369a());
    }

    public C5388e(AbstractC5375g abstractC5375g) {
        this.f22464b = new C5384c();
        this.f22463a = abstractC5375g.mo1221a(this.f22464b);
    }

    /* renamed from: a */
    public void m1208a(AbstractC5358a abstractC5358a, byte[] bArr) {
        try {
            this.f22464b.m1219a(bArr);
            abstractC5358a.mo1286a(this.f22463a);
        } finally {
            this.f22463a.m1229y();
        }
    }
}
