package org.p290c.p309e.p310a;

import java.util.Iterator;
import org.p290c.p309e.C5619c;
/* renamed from: org.c.e.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC5595a {

    /* renamed from: a */
    public static final AbstractC5595a f22686a = new AbstractC5595a() { // from class: org.c.e.a.a.1
        @Override // org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public String mo580a() {
            return "all tests";
        }

        @Override // org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public AbstractC5595a mo581a(AbstractC5595a abstractC5595a) {
            return abstractC5595a;
        }

        @Override // org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public void mo582a(Object obj) {
        }

        @Override // org.p290c.p309e.p310a.AbstractC5595a
        /* renamed from: a */
        public boolean mo579a(C5619c c5619c) {
            return true;
        }
    };

    /* renamed from: b */
    public static AbstractC5595a m583b(final C5619c c5619c) {
        return new AbstractC5595a() { // from class: org.c.e.a.a.2
            @Override // org.p290c.p309e.p310a.AbstractC5595a
            /* renamed from: a */
            public String mo580a() {
                return String.format("Method %s", C5619c.this.m552a());
            }

            @Override // org.p290c.p309e.p310a.AbstractC5595a
            /* renamed from: a */
            public boolean mo579a(C5619c c5619c2) {
                if (c5619c2.m538d()) {
                    return C5619c.this.equals(c5619c2);
                }
                Iterator<C5619c> it2 = c5619c2.m541b().iterator();
                while (it2.hasNext()) {
                    if (mo579a(it2.next())) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /* renamed from: a */
    public abstract String mo580a();

    /* renamed from: a */
    public AbstractC5595a mo581a(final AbstractC5595a abstractC5595a) {
        return (abstractC5595a == this || abstractC5595a == f22686a) ? this : new AbstractC5595a() { // from class: org.c.e.a.a.3
            @Override // org.p290c.p309e.p310a.AbstractC5595a
            /* renamed from: a */
            public String mo580a() {
                return this.mo580a() + " and " + abstractC5595a.mo580a();
            }

            @Override // org.p290c.p309e.p310a.AbstractC5595a
            /* renamed from: a */
            public boolean mo579a(C5619c c5619c) {
                return this.mo579a(c5619c) && abstractC5595a.mo579a(c5619c);
            }
        };
    }

    /* renamed from: a */
    public void mo582a(Object obj) {
        if (!(obj instanceof AbstractC5599b)) {
            return;
        }
        ((AbstractC5599b) obj).mo344a(this);
    }

    /* renamed from: a */
    public abstract boolean mo579a(C5619c c5619c);
}
