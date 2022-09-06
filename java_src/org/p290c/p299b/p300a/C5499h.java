package org.p290c.p299b.p300a;

import org.p290c.p299b.p303d.C5550i;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p312f.p313a.AbstractC5645h;
import p069c.p072c.AbstractC0626a;
/* renamed from: org.c.b.a.h */
/* loaded from: classes2.dex */
public class C5499h extends AbstractC5645h {
    @Override // org.p290c.p312f.p313a.AbstractC5645h
    /* renamed from: a */
    public AbstractC5634l mo432a(Class<?> cls) {
        if (m916b(cls)) {
            return new C5550i(cls);
        }
        return null;
    }

    /* renamed from: b */
    public boolean m916b(Class<?> cls) {
        try {
            cls.getMethod(AbstractC0626a.f1413a, new Class[0]);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }
}
