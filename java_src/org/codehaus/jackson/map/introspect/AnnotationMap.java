package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import org.codehaus.jackson.map.util.Annotations;
/* loaded from: classes2.dex */
public final class AnnotationMap implements Annotations {
    protected HashMap<Class<? extends Annotation>, Annotation> _annotations;

    protected final void _add(Annotation annotation) {
        if (this._annotations == null) {
            this._annotations = new HashMap<>();
        }
        this._annotations.put(annotation.annotationType(), annotation);
    }

    public void add(Annotation annotation) {
        _add(annotation);
    }

    public void addIfNotPresent(Annotation annotation) {
        if (this._annotations == null || !this._annotations.containsKey(annotation.annotationType())) {
            _add(annotation);
        }
    }

    @Override // org.codehaus.jackson.map.util.Annotations
    public <A extends Annotation> A get(Class<A> cls) {
        if (this._annotations == null) {
            return null;
        }
        return (A) this._annotations.get(cls);
    }

    @Override // org.codehaus.jackson.map.util.Annotations
    public int size() {
        if (this._annotations == null) {
            return 0;
        }
        return this._annotations.size();
    }

    public String toString() {
        return this._annotations == null ? "[null]" : this._annotations.toString();
    }
}
