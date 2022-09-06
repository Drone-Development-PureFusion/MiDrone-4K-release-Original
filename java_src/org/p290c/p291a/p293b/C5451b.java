package org.p290c.p291a.p293b;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.p290c.p299b.p302c.C5508c;
import org.p290c.p299b.p303d.C5514b;
import org.p290c.p299b.p303d.C5539e;
import org.p290c.p309e.AbstractC5627i;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.C5626h;
import org.p290c.p309e.C5629j;
import org.p290c.p312f.C5670g;
import org.p290c.p312f.p313a.C5642e;
import p069c.p071b.C0624n;
/* renamed from: org.c.a.b.b */
/* loaded from: classes.dex */
public class C5451b {

    /* renamed from: a */
    private static final String f22517a = "malformed JUnit 3 test class: ";

    /* renamed from: b */
    private final C5454c f22518b;

    private C5451b(File file) {
        this.f22518b = C5454c.m1019a(file);
    }

    /* renamed from: a */
    public static C5451b m1032a(File file) {
        return new C5451b(file);
    }

    @Deprecated
    /* renamed from: a */
    public static C5451b m1030a(String str) {
        return m1032a(new File(str));
    }

    /* renamed from: a */
    private AbstractC5627i m1029a(List<C5619c> list) {
        final ArrayList arrayList = new ArrayList();
        for (C5619c c5619c : list) {
            arrayList.add(m1028a(c5619c));
        }
        return new AbstractC5627i() { // from class: org.c.a.b.b.1
            @Override // org.p290c.p309e.AbstractC5627i
            /* renamed from: a */
            public AbstractC5634l mo489a() {
                try {
                    return new C5670g(null, arrayList) { // from class: org.c.a.b.b.1.1
                    };
                } catch (C5642e e) {
                    return new C5514b(null, e);
                }
            }
        };
    }

    /* renamed from: a */
    private AbstractC5634l m1028a(C5619c c5619c) {
        if (c5619c.toString().equals("TestSuite with 0 tests")) {
            return C5670g.m317a();
        }
        if (c5619c.toString().startsWith(f22517a)) {
            return new C5539e(new C0624n(m1024b(c5619c)));
        }
        Class<?> m533i = c5619c.m533i();
        if (m533i == null) {
            throw new RuntimeException("Can't build a runner from description [" + c5619c + "]");
        }
        String m531k = c5619c.m531k();
        return m531k == null ? AbstractC5627i.m499a(m533i).mo489a() : AbstractC5627i.m498a(m533i, m531k).mo489a();
    }

    /* renamed from: a */
    private void m1027a(C5619c c5619c, C5619c c5619c2, List<C5619c> list) {
        if (!c5619c2.m541b().isEmpty()) {
            Iterator<C5619c> it2 = c5619c2.m541b().iterator();
            while (it2.hasNext()) {
                m1027a(c5619c2, it2.next(), list);
            }
        } else if (c5619c2.toString().equals("warning(junit.framework.TestSuite$1)")) {
            list.add(C5619c.m543a(f22517a + c5619c, new Annotation[0]));
        } else {
            list.add(c5619c2);
        }
    }

    /* renamed from: b */
    private Class<?> m1024b(C5619c c5619c) {
        try {
            return Class.forName(c5619c.toString().replace(f22517a, ""));
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: d */
    private List<C5619c> m1021d(AbstractC5627i abstractC5627i) {
        ArrayList arrayList = new ArrayList();
        m1027a(null, abstractC5627i.mo489a().mo327d(), arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public C5629j m1031a(Class<?> cls) {
        return m1026a(AbstractC5627i.m499a(cls));
    }

    /* renamed from: a */
    public C5629j m1026a(AbstractC5627i abstractC5627i) {
        return m1025a(abstractC5627i, new C5626h());
    }

    /* renamed from: a */
    public C5629j m1025a(AbstractC5627i abstractC5627i, C5626h c5626h) {
        c5626h.m508a(this.f22518b.m1020a());
        return c5626h.m506a(m1023b(abstractC5627i).mo489a());
    }

    /* renamed from: b */
    public AbstractC5627i m1023b(AbstractC5627i abstractC5627i) {
        if (abstractC5627i instanceof C5508c) {
            return abstractC5627i;
        }
        List<C5619c> m1021d = m1021d(abstractC5627i);
        Collections.sort(m1021d, this.f22518b.m1015b());
        return m1029a(m1021d);
    }

    /* renamed from: c */
    public List<C5619c> m1022c(AbstractC5627i abstractC5627i) {
        return m1021d(m1023b(abstractC5627i));
    }
}
