package org.p290c.p299b.p303d;

import java.lang.annotation.Annotation;
import org.p290c.p309e.AbstractC5604b;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p309e.p310a.AbstractC5599b;
import org.p290c.p309e.p310a.AbstractC5601d;
import org.p290c.p309e.p310a.C5600c;
import org.p290c.p309e.p310a.C5602e;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5608c;
import p069c.p070a.C0606c;
import p069c.p071b.AbstractC0618i;
import p069c.p071b.AbstractC0619j;
import p069c.p071b.AbstractC0621l;
import p069c.p071b.C0610b;
import p069c.p071b.C0622m;
import p069c.p071b.C0624n;
/* renamed from: org.c.b.d.e */
/* loaded from: classes2.dex */
public class C5539e extends AbstractC5634l implements AbstractC5599b, AbstractC5601d {

    /* renamed from: a */
    private volatile AbstractC0618i f22619a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: org.c.b.d.e$a */
    /* loaded from: classes2.dex */
    public static final class C5541a implements AbstractC0621l {

        /* renamed from: a */
        private final C5608c f22620a;

        private C5541a(C5608c c5608c) {
            this.f22620a = c5608c;
        }

        /* renamed from: c */
        private C5619c m832c(AbstractC0618i abstractC0618i) {
            return abstractC0618i instanceof AbstractC5604b ? ((AbstractC5604b) abstractC0618i).mo327d() : C5619c.m549a(m831d(abstractC0618i), m830e(abstractC0618i));
        }

        /* renamed from: d */
        private Class<? extends AbstractC0618i> m831d(AbstractC0618i abstractC0618i) {
            return abstractC0618i.getClass();
        }

        /* renamed from: e */
        private String m830e(AbstractC0618i abstractC0618i) {
            return abstractC0618i instanceof AbstractC0619j ? ((AbstractC0619j) abstractC0618i).m19875j() : abstractC0618i.toString();
        }

        @Override // p069c.p071b.AbstractC0621l
        /* renamed from: a */
        public void mo836a(AbstractC0618i abstractC0618i) {
            this.f22620a.m556d(m832c(abstractC0618i));
        }

        @Override // p069c.p071b.AbstractC0621l
        /* renamed from: a */
        public void mo835a(AbstractC0618i abstractC0618i, C0610b c0610b) {
            mo834a(abstractC0618i, (Throwable) c0610b);
        }

        @Override // p069c.p071b.AbstractC0621l
        /* renamed from: a */
        public void mo834a(AbstractC0618i abstractC0618i, Throwable th) {
            this.f22620a.m568a(new C5605a(m832c(abstractC0618i), th));
        }

        @Override // p069c.p071b.AbstractC0621l
        /* renamed from: b */
        public void mo833b(AbstractC0618i abstractC0618i) {
            this.f22620a.m560b(m832c(abstractC0618i));
        }
    }

    public C5539e(AbstractC0618i abstractC0618i) {
        m838b(abstractC0618i);
    }

    public C5539e(Class<?> cls) {
        this(new C0624n(cls.asSubclass(AbstractC0619j.class)));
    }

    /* renamed from: a */
    private AbstractC0618i m842a() {
        return this.f22619a;
    }

    /* renamed from: a */
    private static String m839a(C0624n c0624n) {
        int mo19848a = c0624n.mo19848a();
        return String.format("TestSuite with %s tests%s", Integer.valueOf(mo19848a), mo19848a == 0 ? "" : String.format(" [example: %s]", c0624n.m19847a(0)));
    }

    /* renamed from: a */
    private static C5619c m841a(AbstractC0618i abstractC0618i) {
        if (abstractC0618i instanceof AbstractC0619j) {
            AbstractC0619j abstractC0619j = (AbstractC0619j) abstractC0618i;
            return C5619c.m548a(abstractC0619j.getClass(), abstractC0619j.m19875j(), m840a(abstractC0619j));
        } else if (!(abstractC0618i instanceof C0624n)) {
            return abstractC0618i instanceof AbstractC5604b ? ((AbstractC5604b) abstractC0618i).mo327d() : abstractC0618i instanceof C0606c ? m841a(((C0606c) abstractC0618i).m19977b()) : C5619c.m550a(abstractC0618i.getClass());
        } else {
            C0624n c0624n = (C0624n) abstractC0618i;
            C5619c m543a = C5619c.m543a(c0624n.m19834c() == null ? m839a(c0624n) : c0624n.m19834c(), new Annotation[0]);
            int m19832d = c0624n.m19832d();
            for (int i = 0; i < m19832d; i++) {
                m543a.m542a(m841a(c0624n.m19847a(i)));
            }
            return m543a;
        }
    }

    /* renamed from: a */
    private static Annotation[] m840a(AbstractC0619j abstractC0619j) {
        try {
            return abstractC0619j.getClass().getMethod(abstractC0619j.m19875j(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException e) {
            return new Annotation[0];
        }
    }

    /* renamed from: b */
    private void m838b(AbstractC0618i abstractC0618i) {
        this.f22619a = abstractC0618i;
    }

    @Override // org.p290c.p309e.p310a.AbstractC5599b
    /* renamed from: a */
    public void mo344a(AbstractC5595a abstractC5595a) {
        if (m842a() instanceof AbstractC5599b) {
            ((AbstractC5599b) m842a()).mo344a(abstractC5595a);
        } else if (m842a() instanceof C0624n) {
            C0624n c0624n = (C0624n) m842a();
            C0624n c0624n2 = new C0624n(c0624n.m19834c());
            int m19832d = c0624n.m19832d();
            for (int i = 0; i < m19832d; i++) {
                AbstractC0618i m19847a = c0624n.m19847a(i);
                if (abstractC5595a.mo579a(m841a(m19847a))) {
                    c0624n2.m19846a(m19847a);
                }
            }
            m838b(c0624n2);
            if (c0624n2.m19832d() != 0) {
                return;
            }
            throw new C5600c();
        }
    }

    @Override // org.p290c.p309e.p310a.AbstractC5601d
    /* renamed from: a */
    public void mo342a(C5602e c5602e) {
        if (m842a() instanceof AbstractC5601d) {
            ((AbstractC5601d) m842a()).mo342a(c5602e);
        }
    }

    @Override // org.p290c.p309e.AbstractC5634l
    /* renamed from: a */
    public void mo341a(C5608c c5608c) {
        C0622m c0622m = new C0622m();
        c0622m.m19860a(m837b(c5608c));
        m842a().mo19844a(c0622m);
    }

    /* renamed from: b */
    public AbstractC0621l m837b(C5608c c5608c) {
        return new C5541a(c5608c);
    }

    @Override // org.p290c.p309e.AbstractC5634l, org.p290c.p309e.AbstractC5604b
    /* renamed from: d */
    public C5619c mo327d() {
        return m841a(m842a());
    }
}
