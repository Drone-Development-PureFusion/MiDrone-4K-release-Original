package org.p290c.p299b.p303d.p304a;

import org.p290c.p299b.C5500b;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p312f.p313a.C5643f;
/* renamed from: org.c.b.d.a.a */
/* loaded from: classes.dex */
public class C5511a {

    /* renamed from: a */
    private final C5608c f22583a;

    /* renamed from: b */
    private final C5619c f22584b;

    public C5511a(C5608c c5608c, C5619c c5619c) {
        this.f22583a = c5608c;
        this.f22584b = c5619c;
    }

    /* renamed from: a */
    private void m885a(C5643f c5643f) {
        for (Throwable th : c5643f.m439a()) {
            m887a(th);
        }
    }

    /* renamed from: a */
    public void m888a() {
        this.f22583a.m556d(this.f22584b);
    }

    /* renamed from: a */
    public void m887a(Throwable th) {
        if (th instanceof C5643f) {
            m885a((C5643f) th);
        } else {
            this.f22583a.m568a(new C5605a(this.f22584b, th));
        }
    }

    /* renamed from: a */
    public void m886a(C5500b c5500b) {
        this.f22583a.m562b(new C5605a(this.f22584b, c5500b));
    }

    /* renamed from: b */
    public void m884b() {
        this.f22583a.m560b(this.f22584b);
    }

    /* renamed from: c */
    public void m883c() {
        this.f22583a.m558c(this.f22584b);
    }
}
