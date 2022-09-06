package org.p290c.p312f.p313a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
/* renamed from: org.c.f.a.b */
/* loaded from: classes.dex */
public class C5638b extends AbstractC5639c<C5638b> {

    /* renamed from: a */
    private final Field f22742a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5638b(Field field) {
        if (field == null) {
            throw new NullPointerException("FrameworkField cannot be created without an underlying field.");
        }
        this.f22742a = field;
    }

    /* renamed from: a */
    public Object m461a(Object obj) {
        return this.f22742a.get(obj);
    }

    @Override // org.p290c.p312f.p313a.AbstractC5637a
    /* renamed from: a */
    public <T extends Annotation> T mo424a(Class<T> cls) {
        return (T) this.f22742a.getAnnotation(cls);
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo453a(C5638b c5638b) {
        return c5638b.mo450b().equals(mo450b());
    }

    @Override // org.p290c.p312f.p313a.AbstractC5637a
    /* renamed from: a */
    public Annotation[] mo425a() {
        return this.f22742a.getAnnotations();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: b */
    public String mo450b() {
        return m459d().getName();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: c */
    protected int mo446c() {
        return this.f22742a.getModifiers();
    }

    /* renamed from: d */
    public Field m459d() {
        return this.f22742a;
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: e */
    public Class<?> mo444e() {
        return this.f22742a.getType();
    }

    @Override // org.p290c.p312f.p313a.AbstractC5639c
    /* renamed from: f */
    public Class<?> mo443f() {
        return this.f22742a.getDeclaringClass();
    }

    public String toString() {
        return this.f22742a.toString();
    }
}
