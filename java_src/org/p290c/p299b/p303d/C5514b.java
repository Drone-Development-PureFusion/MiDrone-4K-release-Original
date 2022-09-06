package org.p290c.p299b.p303d;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p312f.p313a.C5642e;
/* renamed from: org.c.b.d.b */
/* loaded from: classes2.dex */
public class C5514b extends AbstractC5634l {

    /* renamed from: a */
    private final List<Throwable> f22585a;

    /* renamed from: b */
    private final Class<?> f22586b;

    public C5514b(Class<?> cls, Throwable th) {
        if (cls == null) {
            throw new NullPointerException("Test class cannot be null");
        }
        this.f22586b = cls;
        this.f22585a = m881a(th);
    }

    /* renamed from: a */
    private List<Throwable> m881a(Throwable th) {
        return th instanceof InvocationTargetException ? m881a(th.getCause()) : th instanceof C5642e ? ((C5642e) th).m440a() : th instanceof C5538d ? ((C5538d) th).m843a() : Arrays.asList(th);
    }

    /* renamed from: a */
    private void m880a(Throwable th, C5608c c5608c) {
        C5619c m879b = m879b(th);
        c5608c.m560b(m879b);
        c5608c.m568a(new C5605a(m879b, th));
        c5608c.m556d(m879b);
    }

    /* renamed from: b */
    private C5619c m879b(Throwable th) {
        return C5619c.m549a(this.f22586b, "initializationError");
    }

    @Override // org.p290c.p309e.AbstractC5634l
    /* renamed from: a */
    public void mo341a(C5608c c5608c) {
        for (Throwable th : this.f22585a) {
            m880a(th, c5608c);
        }
    }

    @Override // org.p290c.p309e.AbstractC5634l, org.p290c.p309e.AbstractC5604b
    /* renamed from: d */
    public C5619c mo327d() {
        C5619c m550a = C5619c.m550a(this.f22586b);
        for (Throwable th : this.f22585a) {
            m550a.m542a(m879b(th));
        }
        return m550a;
    }
}
