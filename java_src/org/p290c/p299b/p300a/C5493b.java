package org.p290c.p299b.p300a;

import java.lang.reflect.Modifier;
import org.p290c.p309e.AbstractC5633k;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p312f.p313a.AbstractC5645h;
import org.p290c.p312f.p313a.C5642e;
/* renamed from: org.c.b.a.b */
/* loaded from: classes2.dex */
public class C5493b extends AbstractC5645h {

    /* renamed from: a */
    private static final String f22560a = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";

    /* renamed from: b */
    private final AbstractC5645h f22561b;

    public C5493b(AbstractC5645h abstractC5645h) {
        this.f22561b = abstractC5645h;
    }

    /* renamed from: b */
    private Class<?> m918b(Class<?> cls) {
        if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5645h
    /* renamed from: a */
    public AbstractC5634l mo432a(Class<?> cls) {
        Class<?> cls2 = cls;
        while (cls2 != null) {
            AbstractC5633k abstractC5633k = (AbstractC5633k) cls2.getAnnotation(AbstractC5633k.class);
            if (abstractC5633k != null) {
                return m919a(abstractC5633k.m463a(), cls);
            }
            cls2 = m918b(cls2);
        }
        return null;
    }

    /* renamed from: a */
    public AbstractC5634l m919a(Class<? extends AbstractC5634l> cls, Class<?> cls2) {
        try {
            return cls.getConstructor(Class.class).newInstance(cls2);
        } catch (NoSuchMethodException e) {
            try {
                return cls.getConstructor(Class.class, AbstractC5645h.class).newInstance(cls2, this.f22561b);
            } catch (NoSuchMethodException e2) {
                String simpleName = cls.getSimpleName();
                throw new C5642e(String.format(f22560a, simpleName, simpleName));
            }
        }
    }
}
