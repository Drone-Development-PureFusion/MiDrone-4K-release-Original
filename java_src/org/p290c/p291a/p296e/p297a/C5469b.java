package org.p290c.p291a.p296e.p297a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.p290c.p291a.p296e.AbstractC5479e;
import org.p290c.p291a.p296e.AbstractC5480f;
import org.p290c.p291a.p296e.AbstractC5481g;
import org.p290c.p291a.p296e.C5478d;
import org.p290c.p312f.p313a.C5648k;
/* renamed from: org.c.a.e.a.b */
/* loaded from: classes2.dex */
public class C5469b {

    /* renamed from: a */
    private final List<AbstractC5481g> f22536a;

    /* renamed from: b */
    private final List<C5478d> f22537b;

    /* renamed from: c */
    private final C5648k f22538c;

    private C5469b(List<AbstractC5481g> list, List<C5478d> list2, C5648k c5648k) {
        this.f22537b = list2;
        this.f22536a = list;
        this.f22538c = c5648k;
    }

    /* renamed from: a */
    private List<AbstractC5481g> m981a(C5478d c5478d) {
        Class<?> m960a = c5478d.m960a();
        return m960a.isEnum() ? new C5471d(m960a).mo945a(c5478d) : (m960a.equals(Boolean.class) || m960a.equals(Boolean.TYPE)) ? new C5470c().mo945a(c5478d) : Collections.emptyList();
    }

    /* renamed from: a */
    public static C5469b m982a(Method method, C5648k c5648k) {
        List<C5478d> m956a = C5478d.m956a(c5648k.m408f());
        m956a.addAll(C5478d.m955a(method));
        return new C5469b(new ArrayList(), m956a, c5648k);
    }

    /* renamed from: a */
    private AbstractC5479e m983a(Class<? extends AbstractC5479e> cls) {
        Constructor<?>[] constructors;
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(C5648k.class)) {
                return (AbstractC5479e) constructor.newInstance(this.f22538c);
            }
        }
        return cls.newInstance();
    }

    /* renamed from: b */
    private AbstractC5479e m977b(C5478d c5478d) {
        AbstractC5480f abstractC5480f = (AbstractC5480f) c5478d.m947d(AbstractC5480f.class);
        return abstractC5480f != null ? m983a(abstractC5480f.m944a()) : new C5466a(this.f22538c);
    }

    /* renamed from: g */
    private int m972g() {
        return C5478d.m956a(this.f22538c.m408f()).size();
    }

    /* renamed from: a */
    public C5469b m980a(AbstractC5481g abstractC5481g) {
        ArrayList arrayList = new ArrayList(this.f22536a);
        arrayList.add(abstractC5481g);
        return new C5469b(arrayList, this.f22537b.subList(1, this.f22537b.size()), this.f22538c);
    }

    /* renamed from: a */
    public boolean m985a() {
        return this.f22537b.size() == 0;
    }

    /* renamed from: a */
    public Object[] m984a(int i, int i2) {
        Object[] objArr = new Object[i2 - i];
        for (int i3 = i; i3 < i2; i3++) {
            objArr[i3 - i] = this.f22536a.get(i3).mo942a();
        }
        return objArr;
    }

    /* renamed from: a */
    public Object[] m979a(boolean z) {
        Object[] objArr = new Object[this.f22536a.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < objArr.length) {
                objArr[i2] = this.f22536a.get(i2).mo941b();
                i = i2 + 1;
            } else {
                return objArr;
            }
        }
    }

    /* renamed from: b */
    public C5478d m978b() {
        return this.f22537b.get(0);
    }

    /* renamed from: c */
    public List<AbstractC5481g> m976c() {
        C5478d m978b = m978b();
        List<AbstractC5481g> mo945a = m977b(m978b).mo945a(m978b);
        return mo945a.size() == 0 ? m981a(m978b) : mo945a;
    }

    /* renamed from: d */
    public Object[] m975d() {
        return m984a(0, m972g());
    }

    /* renamed from: e */
    public Object[] m974e() {
        return m984a(m972g(), this.f22536a.size());
    }

    /* renamed from: f */
    public Object[] m973f() {
        return m984a(0, this.f22536a.size());
    }
}
