package com.p113c.p116c;

import android.view.View;
import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1775a;
import com.p113c.p114a.C1819q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.c.c.c */
/* loaded from: classes.dex */
public class C1836c extends AbstractC1835b {

    /* renamed from: k */
    private static final int f6461k = 0;

    /* renamed from: l */
    private static final int f6462l = 1;

    /* renamed from: m */
    private static final int f6463m = 2;

    /* renamed from: n */
    private static final int f6464n = 4;

    /* renamed from: o */
    private static final int f6465o = 8;

    /* renamed from: p */
    private static final int f6466p = 16;

    /* renamed from: q */
    private static final int f6467q = 32;

    /* renamed from: r */
    private static final int f6468r = 64;

    /* renamed from: s */
    private static final int f6469s = 128;

    /* renamed from: t */
    private static final int f6470t = 256;

    /* renamed from: u */
    private static final int f6471u = 512;

    /* renamed from: v */
    private static final int f6472v = 511;

    /* renamed from: b */
    private final WeakReference<View> f6474b;

    /* renamed from: c */
    private long f6475c;

    /* renamed from: g */
    private Interpolator f6479g;

    /* renamed from: d */
    private boolean f6476d = false;

    /* renamed from: e */
    private long f6477e = 0;

    /* renamed from: f */
    private boolean f6478f = false;

    /* renamed from: h */
    private boolean f6480h = false;

    /* renamed from: i */
    private AbstractC1775a.AbstractC1776a f6481i = null;

    /* renamed from: j */
    private C1838a f6482j = new C1838a();

    /* renamed from: a */
    ArrayList<C1839b> f6473a = new ArrayList<>();

    /* renamed from: w */
    private Runnable f6483w = new Runnable() { // from class: com.c.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            C1836c.this.m14354e();
        }
    };

    /* renamed from: x */
    private HashMap<AbstractC1775a, C1840c> f6484x = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.c.c$a */
    /* loaded from: classes.dex */
    public class C1838a implements AbstractC1775a.AbstractC1776a, C1819q.AbstractC1826b {
        private C1838a() {
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: a */
        public void mo14312a(AbstractC1775a abstractC1775a) {
            if (C1836c.this.f6481i != null) {
                C1836c.this.f6481i.mo14312a(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: b */
        public void mo14311b(AbstractC1775a abstractC1775a) {
            if (C1836c.this.f6481i != null) {
                C1836c.this.f6481i.mo14311b(abstractC1775a);
            }
            C1836c.this.f6484x.remove(abstractC1775a);
            if (C1836c.this.f6484x.isEmpty()) {
                C1836c.this.f6481i = null;
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: c */
        public void mo14310c(AbstractC1775a abstractC1775a) {
            if (C1836c.this.f6481i != null) {
                C1836c.this.f6481i.mo14310c(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: d */
        public void mo14309d(AbstractC1775a abstractC1775a) {
            if (C1836c.this.f6481i != null) {
                C1836c.this.f6481i.mo14309d(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.C1819q.AbstractC1826b
        public void onAnimationUpdate(C1819q c1819q) {
            View view;
            float m14530A = c1819q.m14530A();
            C1840c c1840c = (C1840c) C1836c.this.f6484x.get(c1819q);
            if ((c1840c.f6490a & 511) != 0 && (view = (View) C1836c.this.f6474b.get()) != null) {
                view.invalidate();
            }
            ArrayList<C1839b> arrayList = c1840c.f6491b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C1839b c1839b = arrayList.get(i);
                    C1836c.this.m14357c(c1839b.f6487a, c1839b.f6488b + (c1839b.f6489c * m14530A));
                }
            }
            View view2 = (View) C1836c.this.f6474b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.c.c$b */
    /* loaded from: classes.dex */
    public static class C1839b {

        /* renamed from: a */
        int f6487a;

        /* renamed from: b */
        float f6488b;

        /* renamed from: c */
        float f6489c;

        C1839b(int i, float f, float f2) {
            this.f6487a = i;
            this.f6488b = f;
            this.f6489c = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.c.c$c */
    /* loaded from: classes.dex */
    public static class C1840c {

        /* renamed from: a */
        int f6490a;

        /* renamed from: b */
        ArrayList<C1839b> f6491b;

        C1840c(int i, ArrayList<C1839b> arrayList) {
            this.f6490a = i;
            this.f6491b = arrayList;
        }

        /* renamed from: a */
        boolean m14353a(int i) {
            if ((this.f6490a & i) != 0 && this.f6491b != null) {
                int size = this.f6491b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f6491b.get(i2).f6487a == i) {
                        this.f6491b.remove(i2);
                        this.f6490a &= i ^ (-1);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1836c(View view) {
        this.f6474b = new WeakReference<>(view);
    }

    /* renamed from: a */
    private float m14365a(int i) {
        View view = this.f6474b.get();
        if (view != null) {
            switch (i) {
                case 1:
                    return view.getTranslationX();
                case 2:
                    return view.getTranslationY();
                case 4:
                    return view.getScaleX();
                case 8:
                    return view.getScaleY();
                case 16:
                    return view.getRotation();
                case 32:
                    return view.getRotationX();
                case 64:
                    return view.getRotationY();
                case 128:
                    return view.getX();
                case 256:
                    return view.getY();
                case 512:
                    return view.getAlpha();
            }
        }
        return 0.0f;
    }

    /* renamed from: a */
    private void m14364a(int i, float f) {
        float m14365a = m14365a(i);
        m14363a(i, m14365a, f - m14365a);
    }

    /* renamed from: a */
    private void m14363a(int i, float f, float f2) {
        AbstractC1775a abstractC1775a;
        if (this.f6484x.size() > 0) {
            Iterator<AbstractC1775a> it2 = this.f6484x.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    abstractC1775a = null;
                    break;
                }
                abstractC1775a = it2.next();
                C1840c c1840c = this.f6484x.get(abstractC1775a);
                if (c1840c.m14353a(i) && c1840c.f6490a == 0) {
                    break;
                }
            }
            if (abstractC1775a != null) {
                abstractC1775a.mo14505b();
            }
        }
        this.f6473a.add(new C1839b(i, f, f2));
        View view = this.f6474b.get();
        if (view != null) {
            view.removeCallbacks(this.f6483w);
            view.post(this.f6483w);
        }
    }

    /* renamed from: b */
    private void m14359b(int i, float f) {
        m14363a(i, m14365a(i), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14357c(int i, float f) {
        View view = this.f6474b.get();
        if (view != null) {
            switch (i) {
                case 1:
                    view.setTranslationX(f);
                    return;
                case 2:
                    view.setTranslationY(f);
                    return;
                case 4:
                    view.setScaleX(f);
                    return;
                case 8:
                    view.setScaleY(f);
                    return;
                case 16:
                    view.setRotation(f);
                    return;
                case 32:
                    view.setRotationX(f);
                    return;
                case 64:
                    view.setRotationY(f);
                    return;
                case 128:
                    view.setX(f);
                    return;
                case 256:
                    view.setY(f);
                    return;
                case 512:
                    view.setAlpha(f);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m14354e() {
        C1819q m14499b = C1819q.m14499b(1.0f);
        ArrayList arrayList = (ArrayList) this.f6473a.clone();
        this.f6473a.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((C1839b) arrayList.get(i2)).f6487a;
        }
        this.f6484x.put(m14499b, new C1840c(i, arrayList));
        m14499b.m14514a((C1819q.AbstractC1826b) this.f6482j);
        m14499b.a((AbstractC1775a.AbstractC1776a) this.f6482j);
        if (this.f6478f) {
            m14499b.mo14518a(this.f6477e);
        }
        if (this.f6476d) {
            m14499b.mo14503b(this.f6475c);
        }
        if (this.f6480h) {
            m14499b.mo14517a(this.f6479g);
        }
        m14499b.mo14521a();
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public long mo14352a() {
        return this.f6476d ? this.f6475c : new C1819q().mo14491e();
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14351a(float f) {
        m14364a(128, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14347a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f6476d = true;
        this.f6475c = j;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14346a(Interpolator interpolator) {
        this.f6480h = true;
        this.f6479g = interpolator;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14345a(AbstractC1775a.AbstractC1776a abstractC1776a) {
        this.f6481i = abstractC1776a;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public long mo14341b() {
        if (this.f6478f) {
            return this.f6477e;
        }
        return 0L;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public AbstractC1835b mo14340b(float f) {
        m14359b(128, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public AbstractC1835b mo14338b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f6478f = true;
        this.f6477e = j;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: c */
    public AbstractC1835b mo14335c(float f) {
        m14364a(256, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: c */
    public void mo14336c() {
        m14354e();
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: d */
    public AbstractC1835b mo14331d(float f) {
        m14359b(256, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: d */
    public void mo14332d() {
        if (this.f6484x.size() > 0) {
            for (AbstractC1775a abstractC1775a : ((HashMap) this.f6484x.clone()).keySet()) {
                abstractC1775a.mo14505b();
            }
        }
        this.f6473a.clear();
        View view = this.f6474b.get();
        if (view != null) {
            view.removeCallbacks(this.f6483w);
        }
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: e */
    public AbstractC1835b mo14328e(float f) {
        m14364a(16, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: f */
    public AbstractC1835b mo14327f(float f) {
        m14359b(16, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: g */
    public AbstractC1835b mo14326g(float f) {
        m14364a(32, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: h */
    public AbstractC1835b mo14325h(float f) {
        m14359b(32, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: i */
    public AbstractC1835b mo14324i(float f) {
        m14364a(64, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: j */
    public AbstractC1835b mo14323j(float f) {
        m14359b(64, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: k */
    public AbstractC1835b mo14322k(float f) {
        m14364a(1, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: l */
    public AbstractC1835b mo14321l(float f) {
        m14359b(1, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: m */
    public AbstractC1835b mo14320m(float f) {
        m14364a(2, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: n */
    public AbstractC1835b mo14319n(float f) {
        m14359b(2, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: o */
    public AbstractC1835b mo14318o(float f) {
        m14364a(4, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: p */
    public AbstractC1835b mo14317p(float f) {
        m14359b(4, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: q */
    public AbstractC1835b mo14316q(float f) {
        m14364a(8, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: r */
    public AbstractC1835b mo14315r(float f) {
        m14359b(8, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: s */
    public AbstractC1835b mo14314s(float f) {
        m14364a(512, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: t */
    public AbstractC1835b mo14313t(float f) {
        m14359b(512, f);
        return this;
    }
}
