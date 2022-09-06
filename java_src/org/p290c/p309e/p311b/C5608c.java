package org.p290c.p309e.p311b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.C5629j;
import org.p290c.p309e.p311b.C5606b;
/* renamed from: org.c.e.b.c */
/* loaded from: classes.dex */
public class C5608c {

    /* renamed from: a */
    private final List<C5606b> f22695a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private volatile boolean f22696b = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.c.e.b.c$a */
    /* loaded from: classes2.dex */
    public abstract class AbstractC5616a {

        /* renamed from: a */
        private final List<C5606b> f22711a;

        AbstractC5616a(C5608c c5608c) {
            this(c5608c.f22695a);
        }

        AbstractC5616a(List<C5606b> list) {
            this.f22711a = list;
        }

        /* renamed from: a */
        void m555a() {
            int size = this.f22711a.size();
            ArrayList arrayList = new ArrayList(size);
            ArrayList arrayList2 = new ArrayList(size);
            for (C5606b c5606b : this.f22711a) {
                try {
                    mo554a(c5606b);
                    arrayList.add(c5606b);
                } catch (Exception e) {
                    arrayList2.add(new C5605a(C5619c.f22716b, e));
                }
            }
            C5608c.this.m569a(arrayList, arrayList2);
        }

        /* renamed from: a */
        protected abstract void mo554a(C5606b c5606b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m569a(List<C5606b> list, final List<C5605a> list2) {
        if (!list2.isEmpty()) {
            new AbstractC5616a(list) { // from class: org.c.e.b.c.4
                @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
                /* renamed from: a */
                protected void mo554a(C5606b c5606b) {
                    for (C5605a c5605a : list2) {
                        c5606b.mo476a(c5605a);
                    }
                }
            }.a();
        }
    }

    /* renamed from: a */
    public void m570a() {
        this.f22696b = true;
    }

    /* renamed from: a */
    public void m568a(C5605a c5605a) {
        m569a(this.f22695a, Arrays.asList(c5605a));
    }

    /* renamed from: a */
    public void m567a(C5606b c5606b) {
        if (c5606b == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f22695a.add(m559c(c5606b));
    }

    /* renamed from: a */
    public void m564a(final C5619c c5619c) {
        new AbstractC5616a() { // from class: org.c.e.b.c.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C5608c.this);
            }

            @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
            /* renamed from: a */
            protected void mo554a(C5606b c5606b) {
                c5606b.mo471d(c5619c);
            }
        }.a();
    }

    /* renamed from: a */
    public void m563a(final C5629j c5629j) {
        new AbstractC5616a() { // from class: org.c.e.b.c.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C5608c.this);
            }

            @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
            /* renamed from: a */
            protected void mo554a(C5606b c5606b) {
                c5606b.mo474a(c5629j);
            }
        }.a();
    }

    /* renamed from: b */
    public void m562b(final C5605a c5605a) {
        new AbstractC5616a() { // from class: org.c.e.b.c.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C5608c.this);
            }

            @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
            /* renamed from: a */
            protected void mo554a(C5606b c5606b) {
                c5606b.mo473b(c5605a);
            }
        }.a();
    }

    /* renamed from: b */
    public void m561b(C5606b c5606b) {
        if (c5606b == null) {
            throw new NullPointerException("Cannot remove a null listener");
        }
        this.f22695a.remove(m559c(c5606b));
    }

    /* renamed from: b */
    public void m560b(final C5619c c5619c) {
        if (this.f22696b) {
            throw new C5617d();
        }
        new AbstractC5616a() { // from class: org.c.e.b.c.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C5608c.this);
            }

            @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
            /* renamed from: a */
            protected void mo554a(C5606b c5606b) {
                c5606b.mo553b(c5619c);
            }
        }.a();
    }

    /* renamed from: c */
    C5606b m559c(C5606b c5606b) {
        return c5606b.getClass().isAnnotationPresent(C5606b.AbstractC5607a.class) ? c5606b : new C5618e(c5606b, this);
    }

    /* renamed from: c */
    public void m558c(final C5619c c5619c) {
        new AbstractC5616a() { // from class: org.c.e.b.c.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C5608c.this);
            }

            @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
            /* renamed from: a */
            protected void mo554a(C5606b c5606b) {
                c5606b.mo472c(c5619c);
            }
        }.a();
    }

    /* renamed from: d */
    public void m557d(C5606b c5606b) {
        if (c5606b == null) {
            throw new NullPointerException("Cannot add a null listener");
        }
        this.f22695a.add(0, m559c(c5606b));
    }

    /* renamed from: d */
    public void m556d(final C5619c c5619c) {
        new AbstractC5616a() { // from class: org.c.e.b.c.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(C5608c.this);
            }

            @Override // org.p290c.p309e.p311b.C5608c.AbstractC5616a
            /* renamed from: a */
            protected void mo554a(C5606b c5606b) {
                c5606b.mo475a(c5619c);
            }
        }.a();
    }
}
