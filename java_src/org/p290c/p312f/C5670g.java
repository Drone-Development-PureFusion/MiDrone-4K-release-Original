package org.p290c.p312f;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import org.p290c.p299b.p300a.C5492a;
import org.p290c.p309e.AbstractC5634l;
import org.p290c.p309e.C5619c;
import org.p290c.p309e.p311b.C5608c;
import org.p290c.p312f.p313a.AbstractC5645h;
import org.p290c.p312f.p313a.C5642e;
/* renamed from: org.c.f.g */
/* loaded from: classes.dex */
public class C5670g extends AbstractC5665f<AbstractC5634l> {

    /* renamed from: a */
    private final List<AbstractC5634l> f22786a;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: org.c.f.g$a */
    /* loaded from: classes.dex */
    public @interface AbstractC5671a {
        /* renamed from: a */
        Class<?>[] m310a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C5670g(Class<?> cls, List<AbstractC5634l> list) {
        super(cls);
        this.f22786a = Collections.unmodifiableList(list);
    }

    public C5670g(Class<?> cls, AbstractC5645h abstractC5645h) {
        this(abstractC5645h, cls, m313b(cls));
    }

    protected C5670g(Class<?> cls, Class<?>[] clsArr) {
        this(new C5492a(true), cls, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C5670g(AbstractC5645h abstractC5645h, Class<?> cls, Class<?>[] clsArr) {
        this(cls, abstractC5645h.m430a(cls, clsArr));
    }

    public C5670g(AbstractC5645h abstractC5645h, Class<?>[] clsArr) {
        this((Class<?>) null, abstractC5645h.m430a((Class<?>) null, clsArr));
    }

    /* renamed from: a */
    public static AbstractC5634l m317a() {
        try {
            return new C5670g((Class<?>) null, new Class[0]);
        } catch (C5642e e) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    /* renamed from: b */
    private static Class<?>[] m313b(Class<?> cls) {
        AbstractC5671a abstractC5671a = (AbstractC5671a) cls.getAnnotation(AbstractC5671a.class);
        if (abstractC5671a == null) {
            throw new C5642e(String.format("class '%s' must have a SuiteClasses annotation", cls.getName()));
        }
        return abstractC5671a.m310a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: a */
    public C5619c mo311d(AbstractC5634l abstractC5634l) {
        return abstractC5634l.mo327d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo316a(AbstractC5634l abstractC5634l, C5608c c5608c) {
        abstractC5634l.mo341a(c5608c);
    }

    @Override // org.p290c.p312f.AbstractC5665f
    /* renamed from: c */
    protected List<AbstractC5634l> mo312c() {
        return this.f22786a;
    }
}
