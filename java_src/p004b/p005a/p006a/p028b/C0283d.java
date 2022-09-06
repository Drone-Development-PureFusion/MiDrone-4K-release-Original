package p004b.p005a.p006a.p028b;

import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.p033e.C0288a;
import p004b.p005a.p006a.p028b.p054o.C0535n;
import p004b.p005a.p006a.p028b.p055p.AbstractC0547g;
import p004b.p005a.p006a.p028b.p055p.AbstractC0549i;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.b.d */
/* loaded from: classes.dex */
public class C0283d implements AbstractC0551k {

    /* renamed from: a */
    public static final int f500a = 150;

    /* renamed from: b */
    public static final int f501b = 150;

    /* renamed from: c */
    int f502c = 0;

    /* renamed from: d */
    protected final List<AbstractC0547g> f503d = new ArrayList();

    /* renamed from: e */
    protected final C0288a<AbstractC0547g> f504e = new C0288a<>(150);

    /* renamed from: f */
    protected final C0535n f505f = new C0535n();

    /* renamed from: g */
    int f506g = 0;

    /* renamed from: h */
    protected final List<AbstractC0549i> f507h = new ArrayList();

    /* renamed from: i */
    protected final C0535n f508i = new C0535n();

    /* renamed from: b */
    private void m21048b(AbstractC0547g abstractC0547g) {
        synchronized (this.f508i) {
            for (AbstractC0549i abstractC0549i : this.f507h) {
                abstractC0549i.mo20190a_(abstractC0547g);
            }
        }
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: a */
    public List<AbstractC0547g> mo20189a() {
        ArrayList arrayList;
        synchronized (this.f505f) {
            arrayList = new ArrayList(this.f503d);
            arrayList.addAll(this.f504e.m21027d());
        }
        return arrayList;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: a */
    public void mo20188a(AbstractC0547g abstractC0547g) {
        m21048b(abstractC0547g);
        this.f502c++;
        if (abstractC0547g.mo20201a() > this.f506g) {
            this.f506g = abstractC0547g.mo20201a();
        }
        synchronized (this.f505f) {
            if (this.f503d.size() < 150) {
                this.f503d.add(abstractC0547g);
            } else {
                this.f504e.m21032a((C0288a<AbstractC0547g>) abstractC0547g);
            }
        }
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: a */
    public void mo20187a(AbstractC0549i abstractC0549i) {
        synchronized (this.f508i) {
            this.f507h.add(abstractC0549i);
        }
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: a */
    public boolean mo20186a(AbstractC0549i abstractC0549i, Object obj) {
        for (AbstractC0549i abstractC0549i2 : mo20182e()) {
            if (abstractC0549i2.getClass().isInstance(abstractC0549i)) {
                mo20188a(new C0553m("A previous listener of type [" + abstractC0549i2.getClass() + "] has been already registered. Skipping double registration.", obj));
                return false;
            }
        }
        mo20187a(abstractC0549i);
        return true;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: b */
    public void mo20185b() {
        synchronized (this.f505f) {
            this.f502c = 0;
            this.f503d.clear();
            this.f504e.m21034a();
        }
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: b */
    public void mo20184b(AbstractC0549i abstractC0549i) {
        synchronized (this.f508i) {
            this.f507h.remove(abstractC0549i);
        }
    }

    /* renamed from: c */
    public int m21047c() {
        return this.f506g;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: d */
    public int mo20183d() {
        return this.f502c;
    }

    @Override // p004b.p005a.p006a.p028b.p055p.AbstractC0551k
    /* renamed from: e */
    public List<AbstractC0549i> mo20182e() {
        ArrayList arrayList;
        synchronized (this.f508i) {
            arrayList = new ArrayList(this.f507h);
        }
        return arrayList;
    }
}
