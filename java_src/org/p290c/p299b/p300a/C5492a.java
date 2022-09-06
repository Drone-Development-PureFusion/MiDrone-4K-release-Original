package org.p290c.p299b.p300a;

import java.util.Arrays;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p312f.p313a.AbstractC5645h;
/* renamed from: org.c.b.a.a */
/* loaded from: classes.dex */
public class C5492a extends AbstractC5645h {

    /* renamed from: a */
    private final boolean f22559a;

    public C5492a(boolean z) {
        this.f22559a = z;
    }

    /* renamed from: a */
    protected C5497f m924a() {
        return new C5497f();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5645h
    /* renamed from: a */
    public AbstractC5634l mo432a(Class<?> cls) {
        for (AbstractC5645h abstractC5645h : Arrays.asList(m921d(), m922c(), m920e(), m923b(), m924a())) {
            AbstractC5634l m428c = abstractC5645h.m428c(cls);
            if (m428c != null) {
                return m428c;
            }
        }
        return null;
    }

    /* renamed from: b */
    protected C5496e m923b() {
        return new C5496e();
    }

    /* renamed from: c */
    protected C5493b m922c() {
        return new C5493b(this);
    }

    /* renamed from: d */
    protected C5494c m921d() {
        return new C5494c();
    }

    /* renamed from: e */
    protected AbstractC5645h m920e() {
        return this.f22559a ? new C5499h() : new C5498g();
    }
}
