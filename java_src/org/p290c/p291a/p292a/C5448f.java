package org.p290c.p291a.p292a;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.p290c.p291a.p292a.C5439a;
import org.p290c.p309e.p310a.AbstractC5595a;
/* renamed from: org.c.a.a.f */
/* loaded from: classes2.dex */
public final class C5448f extends AbstractC5444c {

    /* renamed from: org.c.a.a.f$a */
    /* loaded from: classes2.dex */
    private static class C5449a extends C5439a.C5440a {
        public C5449a(List<Class<?>> list) {
            this(new HashSet(list));
        }

        public C5449a(Set<Class<?>> set) {
            super(true, set, true, null);
        }

        @Override // org.p290c.p291a.p292a.C5439a.C5440a, org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public String mo580a() {
            return "includes " + super.mo580a();
        }
    }

    @Override // org.p290c.p291a.p292a.AbstractC5444c
    /* renamed from: a */
    protected AbstractC5595a mo1033a(List<Class<?>> list) {
        return new C5449a(list);
    }
}
