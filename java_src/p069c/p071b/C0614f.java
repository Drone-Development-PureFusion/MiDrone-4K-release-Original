package p069c.p071b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5605a;
import org.p290c.p309e.p311b.C5606b;
import org.p290c.p309e.p311b.C5608c;
/* renamed from: c.b.f */
/* loaded from: classes.dex */
public class C0614f extends HashMap<C5619c, AbstractC0618i> {

    /* renamed from: a */
    private static final C0614f f1396a = new C0614f();
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public static C0614f m19921a() {
        return f1396a;
    }

    /* renamed from: a */
    public AbstractC0618i m19919a(C5619c c5619c) {
        if (c5619c.m539c()) {
            return m19918b(c5619c);
        }
        if (!containsKey(c5619c)) {
            put(c5619c, m19918b(c5619c));
        }
        return get(c5619c);
    }

    /* renamed from: a */
    public C5608c m19920a(final C0622m c0622m, C0613e c0613e) {
        C5608c c5608c = new C5608c();
        c5608c.m567a(new C5606b() { // from class: c.b.f.1
            @Override // org.p290c.p309e.p311b.C5606b
            /* renamed from: a */
            public void mo476a(C5605a c5605a) {
                c0622m.m19862a(C0614f.this.m19919a(c5605a.m574b()), c5605a.m573c());
            }

            @Override // org.p290c.p309e.p311b.C5606b
            /* renamed from: a */
            public void mo475a(C5619c c5619c) {
                c0622m.m19865a(C0614f.this.m19919a(c5619c));
            }

            @Override // org.p290c.p309e.p311b.C5606b
            /* renamed from: b */
            public void mo553b(C5619c c5619c) {
                c0622m.m19858b(C0614f.this.m19919a(c5619c));
            }
        });
        return c5608c;
    }

    /* renamed from: b */
    AbstractC0618i m19918b(C5619c c5619c) {
        if (c5619c.m538d()) {
            return new C0616g(c5619c);
        }
        C0624n c0624n = new C0624n(c5619c.m552a());
        Iterator<C5619c> it2 = c5619c.m541b().iterator();
        while (it2.hasNext()) {
            c0624n.m19846a(m19919a(it2.next()));
        }
        return c0624n;
    }

    /* renamed from: c */
    public List<AbstractC0618i> m19917c(C5619c c5619c) {
        if (c5619c.m538d()) {
            return Arrays.asList(m19919a(c5619c));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C5619c> it2 = c5619c.m541b().iterator();
        while (it2.hasNext()) {
            arrayList.add(m19919a(it2.next()));
        }
        return arrayList;
    }
}
