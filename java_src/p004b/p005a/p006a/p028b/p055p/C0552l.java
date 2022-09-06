package p004b.p005a.p006a.p028b.p055p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.b.p.l */
/* loaded from: classes.dex */
public class C0552l {

    /* renamed from: a */
    AbstractC0551k f1218a;

    public C0552l(AbstractC0292f abstractC0292f) {
        this.f1218a = abstractC0292f.mo20997n();
    }

    public C0552l(AbstractC0551k abstractC0551k) {
        this.f1218a = abstractC0551k;
    }

    /* renamed from: a */
    public static List<AbstractC0547g> m20171a(List<AbstractC0547g> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0547g abstractC0547g : list) {
            if (abstractC0547g.mo20194f().longValue() >= j) {
                arrayList.add(abstractC0547g);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m20177a(AbstractC0292f abstractC0292f) {
        List<AbstractC0549i> mo20182e;
        AbstractC0551k mo20997n = abstractC0292f.mo20997n();
        return (mo20997n == null || (mo20182e = mo20997n.mo20182e()) == null || mo20182e.size() == 0) ? false : true;
    }

    /* renamed from: a */
    public long m20181a() {
        List<AbstractC0547g> mo20189a = this.f1218a.mo20189a();
        if (mo20189a == null) {
            return -1L;
        }
        for (int size = mo20189a.size() - 1; size >= 0; size--) {
            AbstractC0547g abstractC0547g = mo20189a.get(size);
            if (C0359h.f701ad.equals(abstractC0547g.mo20196d())) {
                return abstractC0547g.mo20194f().longValue();
            }
        }
        return -1L;
    }

    /* renamed from: a */
    public void m20176a(AbstractC0547g abstractC0547g) {
        if (this.f1218a != null) {
            this.f1218a.mo20188a(abstractC0547g);
        }
    }

    /* renamed from: a */
    public void m20174a(Object obj, String str) {
        m20176a(new C0542b(str, obj));
    }

    /* renamed from: a */
    public void m20173a(Object obj, String str, Throwable th) {
        m20176a(new C0541a(str, obj, th));
    }

    /* renamed from: a */
    public boolean m20180a(int i, String str) {
        return m20178a(0L, i, str);
    }

    /* renamed from: a */
    public boolean m20179a(long j) {
        return m20178a(j, 2, C0359h.f684N);
    }

    /* renamed from: a */
    public boolean m20178a(long j, int i, String str) {
        List<AbstractC0547g> m20171a = m20171a(this.f1218a.mo20189a(), j);
        Pattern compile = Pattern.compile(str);
        for (AbstractC0547g abstractC0547g : m20171a) {
            if (i == abstractC0547g.mo20201a() && compile.matcher(abstractC0547g.mo20196d()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m20175a(Class<?> cls) {
        for (AbstractC0547g abstractC0547g : this.f1218a.mo20189a()) {
            Throwable mo20195e = abstractC0547g.mo20195e();
            if (mo20195e != null && mo20195e.getClass().getName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m20172a(String str) {
        Pattern compile = Pattern.compile(str);
        for (AbstractC0547g abstractC0547g : this.f1218a.mo20189a()) {
            if (compile.matcher(abstractC0547g.mo20196d()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public int m20168b(String str) {
        int i = 0;
        Pattern compile = Pattern.compile(str);
        Iterator<AbstractC0547g> it2 = this.f1218a.mo20189a().iterator();
        while (true) {
            int i2 = i;
            if (it2.hasNext()) {
                i = compile.matcher(it2.next().mo20196d()).lookingAt() ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* renamed from: b */
    public void m20169b(Object obj, String str) {
        m20176a(new C0553m(str, obj));
    }

    /* renamed from: b */
    public boolean m20170b(long j) {
        return !m20179a(j);
    }

    /* renamed from: c */
    public int m20167c(long j) {
        int i = 0;
        Iterator<AbstractC0547g> it2 = m20171a(this.f1218a.mo20189a(), j).iterator();
        while (true) {
            int i2 = i;
            if (it2.hasNext()) {
                AbstractC0547g next = it2.next();
                i = next.mo20201a() > i2 ? next.mo20201a() : i2;
            } else {
                return i2;
            }
        }
    }

    /* renamed from: d */
    public boolean m20166d(long j) {
        return 2 > m20167c(j);
    }
}
