package org.p248a.p249a.p268i.p270b;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.p248a.p249a.p250a.AbstractC5006c;
@AbstractC5006c
/* renamed from: org.a.a.i.b.ad */
/* loaded from: classes2.dex */
public class C5172ad extends AbstractList<Object> {

    /* renamed from: a */
    private final Set<URI> f21937a = new HashSet();

    /* renamed from: b */
    private final List<URI> f21938b = new ArrayList();

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public URI get(int i) {
        return this.f21938b.get(i);
    }

    /* renamed from: a */
    public List<URI> m1794a() {
        return new ArrayList(this.f21938b);
    }

    /* renamed from: a */
    public boolean m1792a(URI uri) {
        return this.f21937a.contains(uri);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        this.f21938b.add(i, (URI) obj);
        this.f21937a.add((URI) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public URI remove(int i) {
        URI remove = this.f21938b.remove(i);
        this.f21937a.remove(remove);
        if (this.f21938b.size() != this.f21937a.size()) {
            this.f21937a.addAll(this.f21938b);
        }
        return remove;
    }

    /* renamed from: b */
    public void m1790b(URI uri) {
        this.f21937a.add(uri);
        this.f21938b.add(uri);
    }

    /* renamed from: c */
    public boolean m1789c(URI uri) {
        boolean remove = this.f21937a.remove(uri);
        if (remove) {
            Iterator<URI> it2 = this.f21938b.iterator();
            while (it2.hasNext()) {
                if (it2.next().equals(uri)) {
                    it2.remove();
                }
            }
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f21937a.contains(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        URI uri = this.f21938b.set(i, (URI) obj);
        this.f21937a.remove(uri);
        this.f21937a.add((URI) obj);
        if (this.f21938b.size() != this.f21937a.size()) {
            this.f21937a.addAll(this.f21938b);
        }
        return uri;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f21938b.size();
    }
}
