package com.fimi.soul.view.myhorizontalseebar;

import android.util.Log;
import com.fimi.soul.view.myhorizontalseebar.AbstractC3857c;
/* renamed from: com.fimi.soul.view.myhorizontalseebar.a */
/* loaded from: classes.dex */
class C3855a<T extends AbstractC3857c<T>> implements AbstractC3856b<T> {

    /* renamed from: a */
    private static final String f16371a = "FinitePool";

    /* renamed from: b */
    private final AbstractC3858d<T> f16372b;

    /* renamed from: c */
    private final int f16373c;

    /* renamed from: d */
    private final boolean f16374d;

    /* renamed from: e */
    private T f16375e;

    /* renamed from: f */
    private int f16376f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3855a(AbstractC3858d<T> abstractC3858d) {
        this.f16372b = abstractC3858d;
        this.f16373c = 0;
        this.f16374d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3855a(AbstractC3858d<T> abstractC3858d, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The pool limit must be > 0");
        }
        this.f16372b = abstractC3858d;
        this.f16373c = i;
        this.f16374d = false;
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3856b
    /* renamed from: a */
    public T mo6772a() {
        T mo6779a;
        if (this.f16375e != null) {
            T t = this.f16375e;
            this.f16375e = (T) t.mo6783a();
            this.f16376f--;
            mo6779a = t;
        } else {
            mo6779a = this.f16372b.mo6779a();
        }
        if (mo6779a != null) {
            mo6779a.mo6782a(null);
            mo6779a.mo6781a(false);
            this.f16372b.mo6778a(mo6779a);
        }
        return mo6779a;
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.AbstractC3856b
    /* renamed from: a */
    public void mo6771a(T t) {
        if (t.mo6780b()) {
            Log.w(f16371a, "Element is already in pool: " + t);
            return;
        }
        if (this.f16374d || this.f16376f < this.f16373c) {
            this.f16376f++;
            t.mo6782a(this.f16375e);
            t.mo6781a(true);
            this.f16375e = t;
        }
        this.f16372b.mo6777b(t);
    }
}
