package p004b.p005a.p006a.p007a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.p318d.AbstractC5721a;
import org.p318d.AbstractC5744c;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.p008a.C0131b;
import p004b.p005a.p006a.p007a.p025n.AbstractC0236i;
import p004b.p005a.p006a.p007a.p025n.C0233f;
import p004b.p005a.p006a.p007a.p025n.C0237j;
import p004b.p005a.p006a.p007a.p025n.C0247t;
import p004b.p005a.p006a.p007a.p026o.AbstractC0257i;
import p004b.p005a.p006a.p007a.p027p.C0264g;
import p004b.p005a.p006a.p028b.C0297g;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p035g.p039d.C0346m;
import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
import p004b.p005a.p006a.p028b.p055p.AbstractC0549i;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0553m;
/* renamed from: b.a.a.a.f */
/* loaded from: classes.dex */
public class C0151f extends C0297g implements AbstractC0534m, AbstractC5721a {

    /* renamed from: g */
    private int f225g = 0;

    /* renamed from: h */
    private final List<AbstractC0236i> f226h = new ArrayList();

    /* renamed from: k */
    private final C0247t f229k = new C0247t();

    /* renamed from: l */
    private boolean f230l = true;

    /* renamed from: m */
    private boolean f231m = false;

    /* renamed from: n */
    private int f232n = 8;

    /* renamed from: b */
    int f223b = 0;

    /* renamed from: i */
    private Map<String, C0148e> f227i = new ConcurrentHashMap();

    /* renamed from: j */
    private C0237j f228j = new C0237j(this);

    /* renamed from: a */
    final C0148e f222a = new C0148e(AbstractC5744c.f23019c, null, this);

    /* renamed from: f */
    private int f224f = 1;

    /* renamed from: o */
    private List<String> f233o = new ArrayList();

    public C0151f() {
        this.f222a.m21474a(C0146d.f205s);
        this.f227i.put(AbstractC5744c.f23019c, this.f222a);
        m21447a();
    }

    /* renamed from: A */
    private void m21449A() {
        for (AbstractC0236i abstractC0236i : this.f226h) {
            abstractC0236i.mo21244a(this);
        }
    }

    /* renamed from: B */
    private void m21448B() {
        for (AbstractC0236i abstractC0236i : this.f226h) {
            abstractC0236i.mo21242c(this);
        }
    }

    /* renamed from: g */
    private boolean m21428g(String str) {
        return str.equals(C0359h.f689S) || str.equals(C0359h.f690T) || str.equals(C0359h.f691U) || str.equals(C0359h.f688R) || str.equals(C0359h.f687Q);
    }

    /* renamed from: u */
    private void m21423u() {
        this.f228j = new C0237j(this);
    }

    /* renamed from: v */
    private void m21422v() {
        this.f224f++;
    }

    /* renamed from: w */
    private void m21421w() {
        AbstractC0551k n = n();
        for (AbstractC0549i abstractC0549i : n.mo20182e()) {
            n.mo20184b(abstractC0549i);
        }
    }

    /* renamed from: x */
    private void m21420x() {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0236i abstractC0236i : this.f226h) {
            if (abstractC0236i.mo21246a()) {
                arrayList.add(abstractC0236i);
            }
        }
        this.f226h.retainAll(arrayList);
    }

    /* renamed from: y */
    private void m21419y() {
        this.f226h.clear();
    }

    /* renamed from: z */
    private void m21418z() {
        for (AbstractC0236i abstractC0236i : this.f226h) {
            abstractC0236i.mo21243b(this);
        }
    }

    /* renamed from: a */
    public final C0148e m21441a(Class cls) {
        return mo126e(cls.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final EnumC0533l m21440a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object obj, Object obj2, Throwable th) {
        return this.f229k.size() == 0 ? EnumC0533l.NEUTRAL : this.f229k.m21165a(abstractC5756f, c0148e, c0146d, str, new Object[]{obj, obj2}, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final EnumC0533l m21439a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object obj, Throwable th) {
        return this.f229k.size() == 0 ? EnumC0533l.NEUTRAL : this.f229k.m21165a(abstractC5756f, c0148e, c0146d, str, new Object[]{obj}, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final EnumC0533l m21438a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        return this.f229k.size() == 0 ? EnumC0533l.NEUTRAL : this.f229k.m21165a(abstractC5756f, c0148e, c0146d, str, objArr, th);
    }

    @Override // p004b.p005a.p006a.p028b.C0297g, p004b.p005a.p006a.p028b.AbstractC0292f, p004b.p005a.p006a.p028b.p054o.AbstractC0537p
    /* renamed from: a */
    public String mo20211a(String str) {
        if (m21428g(str)) {
            try {
                if (!this.f231m) {
                    this.f231m = true;
                    C0131b.m21528a(this);
                }
            } catch (C0346m e) {
                n().mo20188a(new C0553m("Can't set manifest properties", e));
                this.f231m = false;
            }
        }
        return super.mo20211a(str);
    }

    /* renamed from: a */
    void m21447a() {
        a(C0359h.f715l, new HashMap());
    }

    /* renamed from: a */
    public void m21446a(int i) {
        this.f232n = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m21445a(C0148e c0148e) {
        int i = this.f225g;
        this.f225g = i + 1;
        if (i == 0) {
            n().mo20188a(new C0553m("No appenders present in context [" + p() + "] for logger [" + c0148e.mo88d() + "].", c0148e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m21444a(C0148e c0148e, C0146d c0146d) {
        for (AbstractC0236i abstractC0236i : this.f226h) {
            abstractC0236i.mo21245a(c0148e, c0146d);
        }
    }

    /* renamed from: a */
    public void m21443a(AbstractC0236i abstractC0236i) {
        this.f226h.add(abstractC0236i);
    }

    /* renamed from: a */
    public void m21442a(AbstractC0257i abstractC0257i) {
        this.f229k.add(abstractC0257i);
    }

    @Override // p004b.p005a.p006a.p028b.C0297g, p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: a */
    public void mo21001a(String str, String str2) {
        super.mo21001a(str, str2);
        m21423u();
    }

    /* renamed from: a */
    public void m21437a(boolean z) {
        this.f230l = z;
    }

    /* renamed from: b */
    int m21436b() {
        return this.f224f;
    }

    /* renamed from: b */
    public void m21435b(AbstractC0236i abstractC0236i) {
        this.f226h.remove(abstractC0236i);
    }

    @Override // p004b.p005a.p006a.p028b.C0297g, p004b.p005a.p006a.p028b.AbstractC0292f
    /* renamed from: b */
    public void mo21000b(String str) {
        super.mo21000b(str);
        m21423u();
    }

    @Override // org.p318d.AbstractC5721a
    /* renamed from: c */
    public final C0148e mo126e(String str) {
        C0148e c0148e;
        if (str == null) {
            throw new IllegalArgumentException("name argument cannot be null");
        }
        if (AbstractC5744c.f23019c.equalsIgnoreCase(str)) {
            return this.f222a;
        }
        C0148e c0148e2 = this.f222a;
        C0148e c0148e3 = this.f227i.get(str);
        if (c0148e3 != null) {
            return c0148e3;
        }
        C0148e c0148e4 = c0148e2;
        int i = 0;
        while (true) {
            int m21104a = C0264g.m21104a(str, i);
            String substring = m21104a == -1 ? str : str.substring(0, m21104a);
            int i2 = m21104a + 1;
            synchronized (c0148e4) {
                C0148e m21472a = c0148e4.m21472a(substring);
                if (m21472a == null) {
                    m21472a = c0148e4.m21459e(substring);
                    this.f227i.put(substring, m21472a);
                    m21422v();
                }
                c0148e = m21472a;
            }
            if (m21104a == -1) {
                return c0148e;
            }
            c0148e4 = c0148e;
            i = i2;
        }
    }

    /* renamed from: c */
    public List<C0148e> m21434c() {
        ArrayList arrayList = new ArrayList(this.f227i.values());
        Collections.sort(arrayList, new C0233f());
        return arrayList;
    }

    /* renamed from: d */
    public C0148e m21431d(String str) {
        return this.f227i.get(str);
    }

    /* renamed from: d */
    public C0237j m21432d() {
        return this.f228j;
    }

    /* renamed from: e */
    public boolean m21430e() {
        return this.f230l;
    }

    @Override // p004b.p005a.p006a.p028b.C0297g
    /* renamed from: f */
    public void mo20999f() {
        this.f223b++;
        super.mo20999f();
        m21447a();
        this.f222a.m21458g();
        m21427h();
        m21418z();
        m21420x();
        m21421w();
    }

    /* renamed from: g */
    public C0247t m21429g() {
        return this.f229k;
    }

    /* renamed from: h */
    public void m21427h() {
        Iterator<AbstractC0257i> it2 = this.f229k.iterator();
        while (it2.hasNext()) {
            it2.next().mo20155k();
        }
        this.f229k.clear();
    }

    /* renamed from: i */
    public List<AbstractC0236i> m21426i() {
        return new ArrayList(this.f226h);
    }

    @Override // p004b.p005a.p006a.p028b.C0297g, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        super.mo20156j();
        m21449A();
    }

    @Override // p004b.p005a.p006a.p028b.C0297g, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        mo20999f();
        m21448B();
        m21419y();
        super.mo20155k();
    }

    /* renamed from: l */
    public int m21425l() {
        return this.f232n;
    }

    /* renamed from: m */
    public List<String> m21424m() {
        return this.f233o;
    }

    @Override // p004b.p005a.p006a.p028b.C0297g
    public String toString() {
        return getClass().getName() + "[" + p() + "]";
    }
}
