package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public final class AnnotatedField extends AnnotatedMember {
    protected final AnnotationMap _annotations;
    protected final Field _field;

    public AnnotatedField(Field field, AnnotationMap annotationMap) {
        this._field = field;
        this._annotations = annotationMap;
    }

    public void addOrOverride(Annotation annotation) {
        this._annotations.add(annotation);
    }

    @Override // org.codehaus.jackson.map.introspect.Annotated
    /* renamed from: getAnnotated  reason: collision with other method in class */
    public Field mo21976getAnnotated() {
        return this._field;
    }

    @Override // org.codehaus.jackson.map.introspect.Annotated
    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this._annotations.get(cls);
    }

    public int getAnnotationCount() {
        return this._annotations.size();
    }

    @Override // org.codehaus.jackson.map.introspect.AnnotatedMember
    public Class<?> getDeclaringClass() {
        return this._field.getDeclaringClass();
    }

    public String getFullName() {
        return getDeclaringClass().getName() + "#" + getName();
    }

    @Override // org.codehaus.jackson.map.introspect.Annotated
    public Type getGenericType() {
        return this._field.getGenericType();
    }

    @Override // org.codehaus.jackson.map.introspect.AnnotatedMember
    public Member getMember() {
        return this._field;
    }

    @Override // org.codehaus.jackson.map.introspect.Annotated
    public int getModifiers() {
        return this._field.getModifiers();
    }

    @Override // org.codehaus.jackson.map.introspect.Annotated
    public String getName() {
        return this._field.getName();
    }

    @Override // org.codehaus.jackson.map.introspect.Annotated
    public Class<?> getRawType() {
        return this._field.getType();
    }

    public String toString() {
        return "[field " + getName() + ", annotations: " + this._annotations + "]";
    }
}
