package com.fimi.soul.module.flyplannermedia;

import java.util.ArrayList;
import java.util.List;
/* renamed from: com.fimi.soul.module.flyplannermedia.a */
/* loaded from: classes.dex */
public class C3327a<T> {

    /* renamed from: a */
    private int f12920a;

    /* renamed from: b */
    private int f12921b;

    /* renamed from: c */
    private int f12922c;

    /* renamed from: d */
    private List<List<T>> f12923d;

    /* renamed from: e */
    private AbstractC3328a<T> f12924e;

    /* renamed from: com.fimi.soul.module.flyplannermedia.a$a */
    /* loaded from: classes.dex */
    public interface AbstractC3328a<T> {
        /* renamed from: a */
        boolean mo8687a(T t);
    }

    public C3327a() {
        this.f12920a = 12;
        this.f12921b = 0;
        this.f12922c = 0;
        this.f12923d = null;
    }

    public C3327a(List<T> list) {
        this.f12920a = 12;
        this.f12921b = 0;
        this.f12922c = 0;
        this.f12923d = null;
        m8692a(list);
    }

    public C3327a(List<T> list, int i) {
        this.f12920a = 12;
        this.f12921b = 0;
        this.f12922c = 0;
        this.f12923d = null;
        this.f12920a = i;
        m8692a(list);
    }

    /* renamed from: a */
    private void m8692a(List<T> list) {
        this.f12923d = new ArrayList();
        int size = ((list.size() - 1) / this.f12920a) + 1;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f12920a; i2++) {
                int i3 = (this.f12920a * i) + i2;
                if (i3 < list.size()) {
                    arrayList.add(list.get(i3));
                }
            }
            this.f12923d.add(arrayList);
        }
    }

    /* renamed from: a */
    public int m8694a() {
        return this.f12920a;
    }

    /* renamed from: a */
    public void m8693a(AbstractC3328a<T> abstractC3328a) {
        this.f12924e = abstractC3328a;
    }

    /* renamed from: b */
    public boolean m8691b() {
        if (this.f12924e == null || this.f12922c >= this.f12920a || this.f12921b >= this.f12923d.size() || this.f12922c >= this.f12923d.get(this.f12921b).size()) {
            return false;
        }
        T t = this.f12923d.get(this.f12921b).get(this.f12922c);
        this.f12922c++;
        this.f12924e.mo8687a(t);
        return true;
    }

    /* renamed from: c */
    public int m8690c() {
        return this.f12922c;
    }

    /* renamed from: d */
    public void m8689d() {
        this.f12921b = 0;
        this.f12922c = 0;
    }

    /* renamed from: e */
    public boolean m8688e() {
        if (this.f12921b >= this.f12923d.size() || this.f12922c < this.f12923d.get(this.f12921b).size()) {
            return false;
        }
        this.f12921b++;
        this.f12922c = 0;
        return true;
    }
}
