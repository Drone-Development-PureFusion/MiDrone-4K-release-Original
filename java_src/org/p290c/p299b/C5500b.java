package org.p290c.p299b;

import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5432m;
import org.p287b.C5433n;
/* renamed from: org.c.b.b */
/* loaded from: classes.dex */
public class C5500b extends RuntimeException implements AbstractC5432m {
    private static final long serialVersionUID = 2;

    /* renamed from: a */
    private final String f22563a;

    /* renamed from: b */
    private final boolean f22564b;

    /* renamed from: c */
    private final Object f22565c;

    /* renamed from: d */
    private final AbstractC5430k<?> f22566d;

    @Deprecated
    public C5500b(Object obj, AbstractC5430k<?> abstractC5430k) {
        this(null, true, obj, abstractC5430k);
    }

    @Deprecated
    public C5500b(String str) {
        this(str, false, null, null);
    }

    @Deprecated
    public C5500b(String str, Object obj, AbstractC5430k<?> abstractC5430k) {
        this(str, true, obj, abstractC5430k);
    }

    @Deprecated
    public C5500b(String str, Throwable th) {
        this(str, false, null, null);
        initCause(th);
    }

    @Deprecated
    public C5500b(String str, boolean z, Object obj, AbstractC5430k<?> abstractC5430k) {
        this.f22563a = str;
        this.f22565c = obj;
        this.f22566d = abstractC5430k;
        this.f22564b = z;
        if (obj instanceof Throwable) {
            initCause((Throwable) obj);
        }
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        if (this.f22563a != null) {
            abstractC5425g.mo1086a(this.f22563a);
        }
        if (this.f22564b) {
            if (this.f22563a != null) {
                abstractC5425g.mo1086a(": ");
            }
            abstractC5425g.mo1086a("got: ");
            abstractC5425g.mo1087a(this.f22565c);
            if (this.f22566d == null) {
                return;
            }
            abstractC5425g.mo1086a(", expected: ");
            abstractC5425g.mo1083a((AbstractC5432m) this.f22566d);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return C5433n.m1072c(this);
    }
}
