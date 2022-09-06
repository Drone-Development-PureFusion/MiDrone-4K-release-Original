package org.p290c.p299b.p300a;

import org.p290c.p299b.p303d.C5539e;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p312f.p313a.AbstractC5645h;
import p069c.p071b.AbstractC0619j;
/* renamed from: org.c.b.a.e */
/* loaded from: classes2.dex */
public class C5496e extends AbstractC5645h {
    @Override // org.p290c.p312f.p313a.AbstractC5645h
    /* renamed from: a */
    public AbstractC5634l mo432a(Class<?> cls) {
        if (m917b(cls)) {
            return new C5539e(cls);
        }
        return null;
    }

    /* renamed from: b */
    boolean m917b(Class<?> cls) {
        return AbstractC0619j.class.isAssignableFrom(cls);
    }
}
