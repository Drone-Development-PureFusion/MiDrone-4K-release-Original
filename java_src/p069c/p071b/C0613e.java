package p069c.p071b;

import java.util.Iterator;
import java.util.List;
import org.p290c.AbstractC5690k;
import org.p290c.p309e.AbstractC5604b;
import org.p290c.p309e.AbstractC5627i;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p310a.AbstractC5595a;
import org.p290c.p309e.p310a.AbstractC5599b;
import org.p290c.p309e.p310a.AbstractC5601d;
import org.p290c.p309e.p310a.C5602e;
/* renamed from: c.b.e */
/* loaded from: classes.dex */
public class C0613e implements AbstractC0618i, AbstractC5599b, AbstractC5601d, AbstractC5604b {

    /* renamed from: a */
    private final Class<?> f1393a;

    /* renamed from: b */
    private final AbstractC5634l f1394b;

    /* renamed from: c */
    private final C0614f f1395c;

    public C0613e(Class<?> cls) {
        this(cls, C0614f.m19921a());
    }

    public C0613e(Class<?> cls, C0614f c0614f) {
        this.f1395c = c0614f;
        this.f1393a = cls;
        this.f1394b = AbstractC5627i.m490b(cls).mo489a();
    }

    /* renamed from: a */
    private C5619c m19925a(C5619c c5619c) {
        if (m19923b(c5619c)) {
            return C5619c.f22715a;
        }
        C5619c m535g = c5619c.m535g();
        Iterator<C5619c> it2 = c5619c.m541b().iterator();
        while (it2.hasNext()) {
            C5619c m19925a = m19925a(it2.next());
            if (!m19925a.m536f()) {
                m535g.m542a(m19925a);
            }
        }
        return m535g;
    }

    /* renamed from: b */
    private boolean m19923b(C5619c c5619c) {
        return c5619c.m540b(AbstractC5690k.class) != null;
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public int mo19848a() {
        return this.f1394b.m462h();
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public void mo19844a(C0622m c0622m) {
        this.f1394b.mo341a(this.f1395c.m19920a(c0622m, this));
    }

    @Override // org.p290c.p309e.p310a.AbstractC5599b
    /* renamed from: a */
    public void mo344a(AbstractC5595a abstractC5595a) {
        abstractC5595a.mo582a(this.f1394b);
    }

    @Override // org.p290c.p309e.p310a.AbstractC5601d
    /* renamed from: a */
    public void mo342a(C5602e c5602e) {
        c5602e.m578a(this.f1394b);
    }

    /* renamed from: b */
    public List<AbstractC0618i> m19924b() {
        return this.f1395c.m19917c(mo327d());
    }

    /* renamed from: c */
    public Class<?> m19922c() {
        return this.f1393a;
    }

    @Override // org.p290c.p309e.AbstractC5604b
    /* renamed from: d */
    public C5619c mo327d() {
        return m19925a(this.f1394b.mo327d());
    }

    public String toString() {
        return this.f1393a.getName();
    }
}
