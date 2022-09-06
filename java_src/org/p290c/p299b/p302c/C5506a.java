package org.p290c.p299b.p302c;

import org.p290c.p299b.p300a.C5492a;
import org.p290c.p309e.AbstractC5627i;
import org.p290c.p309e.AbstractC5634l;
/* renamed from: org.c.b.c.a */
/* loaded from: classes2.dex */
public class C5506a extends AbstractC5627i {

    /* renamed from: a */
    private final Object f22571a;

    /* renamed from: b */
    private final Class<?> f22572b;

    /* renamed from: c */
    private final boolean f22573c;

    /* renamed from: d */
    private volatile AbstractC5634l f22574d;

    public C5506a(Class<?> cls) {
        this(cls, true);
    }

    public C5506a(Class<?> cls, boolean z) {
        this.f22571a = new Object();
        this.f22572b = cls;
        this.f22573c = z;
    }

    @Override // org.p290c.p309e.AbstractC5627i
    /* renamed from: a */
    public AbstractC5634l mo489a() {
        if (this.f22574d == null) {
            synchronized (this.f22571a) {
                if (this.f22574d == null) {
                    this.f22574d = new C5492a(this.f22573c).c(this.f22572b);
                }
            }
        }
        return this.f22574d;
    }
}
