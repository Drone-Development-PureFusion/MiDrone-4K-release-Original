package org.p290c.p312f.p313a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.p290c.p299b.p303d.C5514b;
import org.p290c.p309e.AbstractC5634l;
/* renamed from: org.c.f.a.h */
/* loaded from: classes.dex */
public abstract class AbstractC5645h {

    /* renamed from: a */
    private final Set<Class<?>> f22750a = new HashSet();

    /* renamed from: a */
    private List<AbstractC5634l> m429a(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls : clsArr) {
            AbstractC5634l m428c = m428c(cls);
            if (m428c != null) {
                arrayList.add(m428c);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<AbstractC5634l> m431a(Class<?> cls, List<Class<?>> list) {
        return m430a(cls, (Class[]) list.toArray(new Class[0]));
    }

    /* renamed from: a */
    public List<AbstractC5634l> m430a(Class<?> cls, Class<?>[] clsArr) {
        m427d(cls);
        try {
            return m429a(clsArr);
        } finally {
            m426e(cls);
        }
    }

    /* renamed from: a */
    public abstract AbstractC5634l mo432a(Class<?> cls);

    /* renamed from: c */
    public AbstractC5634l m428c(Class<?> cls) {
        try {
            return mo432a(cls);
        } catch (Throwable th) {
            return new C5514b(cls, th);
        }
    }

    /* renamed from: d */
    Class<?> m427d(Class<?> cls) {
        if (!this.f22750a.add(cls)) {
            throw new C5642e(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", cls.getName()));
        }
        return cls;
    }

    /* renamed from: e */
    void m426e(Class<?> cls) {
        this.f22750a.remove(cls);
    }
}
