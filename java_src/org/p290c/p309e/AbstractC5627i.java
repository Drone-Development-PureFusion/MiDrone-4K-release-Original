package org.p290c.p309e;

import java.util.Comparator;
import org.p290c.p299b.p300a.C5492a;
import org.p290c.p299b.p302c.C5506a;
import org.p290c.p299b.p302c.C5507b;
import org.p290c.p299b.p302c.C5508c;
import org.p290c.p299b.p303d.C5514b;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p312f.p313a.C5642e;
/* renamed from: org.c.e.i */
/* loaded from: classes2.dex */
public abstract class AbstractC5627i {
    /* renamed from: a */
    public static AbstractC5627i m499a(Class<?> cls) {
        return new C5506a(cls);
    }

    /* renamed from: a */
    public static AbstractC5627i m498a(Class<?> cls, String str) {
        return m499a(cls).m493a(C5619c.m549a(cls, str));
    }

    /* renamed from: a */
    public static AbstractC5627i m497a(Class<?> cls, Throwable th) {
        return m492a(new C5514b(cls, th));
    }

    /* renamed from: a */
    public static AbstractC5627i m494a(C5593a c5593a, Class<?>... clsArr) {
        try {
            return m492a(c5593a.mo585a(new C5492a(true), clsArr));
        } catch (C5642e e) {
            throw new RuntimeException("Bug in saff's brain: Suite constructor, called as above, should always complete");
        }
    }

    /* renamed from: a */
    public static AbstractC5627i m492a(final AbstractC5634l abstractC5634l) {
        return new AbstractC5627i() { // from class: org.c.e.i.1
            @Override // org.p290c.p309e.AbstractC5627i
            /* renamed from: a */
            public AbstractC5634l mo489a() {
                return AbstractC5634l.this;
            }
        };
    }

    /* renamed from: a */
    public static AbstractC5627i m491a(Class<?>... clsArr) {
        return m494a(C5626h.m503b(), clsArr);
    }

    /* renamed from: b */
    public static AbstractC5627i m490b(Class<?> cls) {
        return new C5506a(cls, false);
    }

    /* renamed from: a */
    public AbstractC5627i m496a(Comparator<C5619c> comparator) {
        return new C5508c(this, comparator);
    }

    /* renamed from: a */
    public AbstractC5627i m495a(AbstractC5595a abstractC5595a) {
        return new C5507b(this, abstractC5595a);
    }

    /* renamed from: a */
    public AbstractC5627i m493a(C5619c c5619c) {
        return m495a(AbstractC5595a.m583b(c5619c));
    }

    /* renamed from: a */
    public abstract AbstractC5634l mo489a();
}
