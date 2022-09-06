package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
/* loaded from: classes2.dex */
public final class AnnotatedMethodMap implements Iterable<AnnotatedMethod> {
    LinkedHashMap<MemberKey, AnnotatedMethod> _methods;

    public void add(AnnotatedMethod annotatedMethod) {
        if (this._methods == null) {
            this._methods = new LinkedHashMap<>();
        }
        this._methods.put(new MemberKey(annotatedMethod.mo21976getAnnotated()), annotatedMethod);
    }

    public AnnotatedMethod find(String str, Class<?>[] clsArr) {
        if (this._methods == null) {
            return null;
        }
        return this._methods.get(new MemberKey(str, clsArr));
    }

    public AnnotatedMethod find(Method method) {
        if (this._methods == null) {
            return null;
        }
        return this._methods.get(new MemberKey(method));
    }

    public boolean isEmpty() {
        return this._methods == null || this._methods.size() == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotatedMethod> iterator() {
        return this._methods != null ? this._methods.values().iterator() : Collections.emptyList().iterator();
    }

    public AnnotatedMethod remove(Method method) {
        if (this._methods != null) {
            return this._methods.remove(new MemberKey(method));
        }
        return null;
    }

    public AnnotatedMethod remove(AnnotatedMethod annotatedMethod) {
        return remove(annotatedMethod.mo21976getAnnotated());
    }

    public int size() {
        if (this._methods == null) {
            return 0;
        }
        return this._methods.size();
    }
}
