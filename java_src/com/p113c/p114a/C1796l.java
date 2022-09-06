package com.p113c.p114a;

import android.view.View;
import com.p113c.p115b.AbstractC1830d;
import com.p113c.p116c.p117a.C1834a;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.c.a.l */
/* loaded from: classes.dex */
public final class C1796l extends C1819q {

    /* renamed from: p */
    private static final boolean f6352p = false;

    /* renamed from: q */
    private static final Map<String, AbstractC1830d> f6353q = new HashMap();

    /* renamed from: r */
    private Object f6354r;

    /* renamed from: s */
    private String f6355s;

    /* renamed from: t */
    private AbstractC1830d f6356t;

    static {
        f6353q.put("alpha", C1797m.f6357a);
        f6353q.put("pivotX", C1797m.f6358b);
        f6353q.put("pivotY", C1797m.f6359c);
        f6353q.put("translationX", C1797m.f6360d);
        f6353q.put("translationY", C1797m.f6361e);
        f6353q.put("rotation", C1797m.f6362f);
        f6353q.put("rotationX", C1797m.f6363g);
        f6353q.put("rotationY", C1797m.f6364h);
        f6353q.put("scaleX", C1797m.f6365i);
        f6353q.put("scaleY", C1797m.f6366j);
        f6353q.put("scrollX", C1797m.f6367k);
        f6353q.put("scrollY", C1797m.f6368l);
        f6353q.put("x", C1797m.f6369m);
        f6353q.put("y", C1797m.f6370n);
    }

    public C1796l() {
    }

    private <T> C1796l(T t, AbstractC1830d<T, ?> abstractC1830d) {
        this.f6354r = t;
        m14609a((AbstractC1830d) abstractC1830d);
    }

    private C1796l(Object obj, String str) {
        this.f6354r = obj;
        m14600a(str);
    }

    /* renamed from: a */
    public static <T, V> C1796l m14607a(T t, AbstractC1830d<T, V> abstractC1830d, AbstractC1818p<V> abstractC1818p, V... vArr) {
        C1796l c1796l = new C1796l(t, abstractC1830d);
        c1796l.mo14506a((Object[]) vArr);
        c1796l.a((AbstractC1818p) abstractC1818p);
        return c1796l;
    }

    /* renamed from: a */
    public static <T> C1796l m14606a(T t, AbstractC1830d<T, Float> abstractC1830d, float... fArr) {
        C1796l c1796l = new C1796l(t, abstractC1830d);
        c1796l.mo14509a(fArr);
        return c1796l;
    }

    /* renamed from: a */
    public static <T> C1796l m14605a(T t, AbstractC1830d<T, Integer> abstractC1830d, int... iArr) {
        C1796l c1796l = new C1796l(t, abstractC1830d);
        c1796l.mo14508a(iArr);
        return c1796l;
    }

    /* renamed from: a */
    public static C1796l m14604a(Object obj, String str, AbstractC1818p abstractC1818p, Object... objArr) {
        C1796l c1796l = new C1796l(obj, str);
        c1796l.mo14506a(objArr);
        c1796l.a(abstractC1818p);
        return c1796l;
    }

    /* renamed from: a */
    public static C1796l m14603a(Object obj, String str, float... fArr) {
        C1796l c1796l = new C1796l(obj, str);
        c1796l.mo14509a(fArr);
        return c1796l;
    }

    /* renamed from: a */
    public static C1796l m14602a(Object obj, String str, int... iArr) {
        C1796l c1796l = new C1796l(obj, str);
        c1796l.mo14508a(iArr);
        return c1796l;
    }

    /* renamed from: a */
    public static C1796l m14601a(Object obj, C1812n... c1812nArr) {
        C1796l c1796l = new C1796l();
        c1796l.f6354r = obj;
        c1796l.b(c1812nArr);
        return c1796l;
    }

    @Override // com.p113c.p114a.C1819q, com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14521a() {
        super.mo14521a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p113c.p114a.C1819q
    /* renamed from: a */
    public void mo14520a(float f) {
        super.mo14520a(f);
        int length = this.f6431k.length;
        for (int i = 0; i < length; i++) {
            this.f6431k[i].mo14535d(this.f6354r);
        }
    }

    /* renamed from: a */
    public void m14609a(AbstractC1830d abstractC1830d) {
        if (this.f6431k != null) {
            C1812n c1812n = this.f6431k[0];
            String m14544c = c1812n.m14544c();
            c1812n.m14564a(abstractC1830d);
            this.f6432l.remove(m14544c);
            this.f6432l.put(this.f6355s, c1812n);
        }
        if (this.f6356t != null) {
            this.f6355s = abstractC1830d.m14461b();
        }
        this.f6356t = abstractC1830d;
        this.f6430j = false;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: a */
    public void mo14608a(Object obj) {
        if (this.f6354r != obj) {
            Object obj2 = this.f6354r;
            this.f6354r = obj;
            if (obj2 != null && obj != null && obj2.getClass() == obj.getClass()) {
                return;
            }
            this.f6430j = false;
        }
    }

    /* renamed from: a */
    public void m14600a(String str) {
        if (this.f6431k != null) {
            C1812n c1812n = this.f6431k[0];
            String m14544c = c1812n.m14544c();
            c1812n.m14555a(str);
            this.f6432l.remove(m14544c);
            this.f6432l.put(str, c1812n);
        }
        this.f6355s = str;
        this.f6430j = false;
    }

    @Override // com.p113c.p114a.C1819q
    /* renamed from: a */
    public void mo14509a(float... fArr) {
        if (this.f6431k != null && this.f6431k.length != 0) {
            super.mo14509a(fArr);
        } else if (this.f6356t != null) {
            b(C1812n.m14562a(this.f6356t, fArr));
        } else {
            b(C1812n.m14552a(this.f6355s, fArr));
        }
    }

    @Override // com.p113c.p114a.C1819q
    /* renamed from: a */
    public void mo14508a(int... iArr) {
        if (this.f6431k != null && this.f6431k.length != 0) {
            super.mo14508a(iArr);
        } else if (this.f6356t != null) {
            b(C1812n.m14561a((AbstractC1830d<?, Integer>) this.f6356t, iArr));
        } else {
            b(C1812n.m14551a(this.f6355s, iArr));
        }
    }

    @Override // com.p113c.p114a.C1819q
    /* renamed from: a */
    public void mo14506a(Object... objArr) {
        if (this.f6431k != null && this.f6431k.length != 0) {
            super.mo14506a(objArr);
        } else if (this.f6356t != null) {
            b(C1812n.m14563a(this.f6356t, (AbstractC1818p) null, objArr));
        } else {
            b(C1812n.m14554a(this.f6355s, (AbstractC1818p) null, objArr));
        }
    }

    @Override // com.p113c.p114a.C1819q
    /* renamed from: a_ */
    public C1796l mo14492d(long j) {
        super.mo14503b(j);
        return this;
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: k */
    public void mo14598k() {
        mo14483n();
        int length = this.f6431k.length;
        for (int i = 0; i < length; i++) {
            this.f6431k[i].m14545b(this.f6354r);
        }
    }

    @Override // com.p113c.p114a.AbstractC1775a
    /* renamed from: l */
    public void mo14597l() {
        mo14483n();
        int length = this.f6431k.length;
        for (int i = 0; i < length; i++) {
            this.f6431k[i].m14543c(this.f6354r);
        }
    }

    /* renamed from: m */
    public String m14596m() {
        return this.f6355s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.p113c.p114a.C1819q
    /* renamed from: n */
    public void mo14483n() {
        if (!this.f6430j) {
            if (this.f6356t == null && C1834a.f6442a && (this.f6354r instanceof View) && f6353q.containsKey(this.f6355s)) {
                m14609a(f6353q.get(this.f6355s));
            }
            int length = this.f6431k.length;
            for (int i = 0; i < length; i++) {
                this.f6431k[i].m14557a(this.f6354r);
            }
            super.mo14483n();
        }
    }

    /* renamed from: o */
    public Object m14595o() {
        return this.f6354r;
    }

    @Override // com.p113c.p114a.C1819q
    /* renamed from: p */
    public C1796l mo14481q() {
        return (C1796l) super.mo14485j();
    }

    @Override // com.p113c.p114a.C1819q
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f6354r;
        if (this.f6431k != null) {
            for (int i = 0; i < this.f6431k.length; i++) {
                str = str + "\n    " + this.f6431k[i].toString();
            }
        }
        return str;
    }
}
