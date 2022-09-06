package org.p290c.p315g;

import java.util.concurrent.ConcurrentHashMap;
/* renamed from: org.c.g.b */
/* loaded from: classes.dex */
public class C5674b {

    /* renamed from: a */
    private static final ConcurrentHashMap<AbstractC5683f, AbstractC5673a> f22788a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public AbstractC5673a m306a(AbstractC5683f abstractC5683f) {
        AbstractC5673a abstractC5673a = f22788a.get(abstractC5683f);
        if (abstractC5673a != null) {
            return abstractC5673a;
        }
        Class<? extends AbstractC5673a> m297a = abstractC5683f.m297a();
        if (m297a == null) {
            throw new IllegalArgumentException("Can't create validator, value is null in annotation " + abstractC5683f.getClass().getName());
        }
        try {
            f22788a.putIfAbsent(abstractC5683f, m297a.newInstance());
            return f22788a.get(abstractC5683f);
        } catch (Exception e) {
            throw new RuntimeException("Exception received when creating AnnotationValidator class " + m297a.getName(), e);
        }
    }
}
