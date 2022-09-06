package org.p287b.p289b;

import java.lang.reflect.Array;
import java.util.Iterator;
/* renamed from: org.b.b.a */
/* loaded from: classes2.dex */
public class C5413a implements Iterator<Object> {

    /* renamed from: a */
    private final Object f22487a;

    /* renamed from: b */
    private int f22488b = 0;

    public C5413a(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.f22487a = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22488b < Array.getLength(this.f22487a);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.f22487a;
        int i = this.f22488b;
        this.f22488b = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
