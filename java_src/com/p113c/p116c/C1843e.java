package com.p113c.p116c;

import android.view.View;
import android.view.animation.Interpolator;
import com.p113c.p114a.AbstractC1775a;
import com.p113c.p114a.C1819q;
import com.p113c.p116c.p117a.C1834a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.c.c.e */
/* loaded from: classes.dex */
public class C1843e extends AbstractC1835b {

    /* renamed from: l */
    private static final int f6496l = 0;

    /* renamed from: m */
    private static final int f6497m = 1;

    /* renamed from: n */
    private static final int f6498n = 2;

    /* renamed from: o */
    private static final int f6499o = 4;

    /* renamed from: p */
    private static final int f6500p = 8;

    /* renamed from: q */
    private static final int f6501q = 16;

    /* renamed from: r */
    private static final int f6502r = 32;

    /* renamed from: s */
    private static final int f6503s = 64;

    /* renamed from: t */
    private static final int f6504t = 128;

    /* renamed from: u */
    private static final int f6505u = 256;

    /* renamed from: v */
    private static final int f6506v = 512;

    /* renamed from: w */
    private static final int f6507w = 511;

    /* renamed from: b */
    private final C1834a f6509b;

    /* renamed from: c */
    private final WeakReference<View> f6510c;

    /* renamed from: d */
    private long f6511d;

    /* renamed from: h */
    private Interpolator f6515h;

    /* renamed from: e */
    private boolean f6512e = false;

    /* renamed from: f */
    private long f6513f = 0;

    /* renamed from: g */
    private boolean f6514g = false;

    /* renamed from: i */
    private boolean f6516i = false;

    /* renamed from: j */
    private AbstractC1775a.AbstractC1776a f6517j = null;

    /* renamed from: k */
    private C1845a f6518k = new C1845a();

    /* renamed from: a */
    ArrayList<C1846b> f6508a = new ArrayList<>();

    /* renamed from: x */
    private Runnable f6519x = new Runnable() { // from class: com.c.c.e.1
        @Override // java.lang.Runnable
        public void run() {
            C1843e.this.m14329e();
        }
    };

    /* renamed from: y */
    private HashMap<AbstractC1775a, C1847c> f6520y = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.c.e$a */
    /* loaded from: classes.dex */
    public class C1845a implements AbstractC1775a.AbstractC1776a, C1819q.AbstractC1826b {
        private C1845a() {
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: a */
        public void mo14312a(AbstractC1775a abstractC1775a) {
            if (C1843e.this.f6517j != null) {
                C1843e.this.f6517j.mo14312a(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: b */
        public void mo14311b(AbstractC1775a abstractC1775a) {
            if (C1843e.this.f6517j != null) {
                C1843e.this.f6517j.mo14311b(abstractC1775a);
            }
            C1843e.this.f6520y.remove(abstractC1775a);
            if (C1843e.this.f6520y.isEmpty()) {
                C1843e.this.f6517j = null;
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: c */
        public void mo14310c(AbstractC1775a abstractC1775a) {
            if (C1843e.this.f6517j != null) {
                C1843e.this.f6517j.mo14310c(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.AbstractC1775a.AbstractC1776a
        /* renamed from: d */
        public void mo14309d(AbstractC1775a abstractC1775a) {
            if (C1843e.this.f6517j != null) {
                C1843e.this.f6517j.mo14309d(abstractC1775a);
            }
        }

        @Override // com.p113c.p114a.C1819q.AbstractC1826b
        public void onAnimationUpdate(C1819q c1819q) {
            View view;
            float m14530A = c1819q.m14530A();
            C1847c c1847c = (C1847c) C1843e.this.f6520y.get(c1819q);
            if ((c1847c.f6526a & 511) != 0 && (view = (View) C1843e.this.f6510c.get()) != null) {
                view.invalidate();
            }
            ArrayList<C1846b> arrayList = c1847c.f6527b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C1846b c1846b = arrayList.get(i);
                    C1843e.this.m14334c(c1846b.f6523a, c1846b.f6524b + (c1846b.f6525c * m14530A));
                }
            }
            View view2 = (View) C1843e.this.f6510c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.c.e$b */
    /* loaded from: classes.dex */
    public static class C1846b {

        /* renamed from: a */
        int f6523a;

        /* renamed from: b */
        float f6524b;

        /* renamed from: c */
        float f6525c;

        C1846b(int i, float f, float f2) {
            this.f6523a = i;
            this.f6524b = f;
            this.f6525c = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.c.c.e$c */
    /* loaded from: classes.dex */
    public static class C1847c {

        /* renamed from: a */
        int f6526a;

        /* renamed from: b */
        ArrayList<C1846b> f6527b;

        C1847c(int i, ArrayList<C1846b> arrayList) {
            this.f6526a = i;
            this.f6527b = arrayList;
        }

        /* renamed from: a */
        boolean m14308a(int i) {
            if ((this.f6526a & i) != 0 && this.f6527b != null) {
                int size = this.f6527b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (this.f6527b.get(i2).f6523a == i) {
                        this.f6527b.remove(i2);
                        this.f6526a &= i ^ (-1);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1843e(View view) {
        this.f6510c = new WeakReference<>(view);
        this.f6509b = C1834a.m14421a(view);
    }

    /* renamed from: a */
    private float m14350a(int i) {
        switch (i) {
            case 1:
                return this.f6509b.m14380k();
            case 2:
                return this.f6509b.m14376l();
            case 4:
                return this.f6509b.m14396g();
            case 8:
                return this.f6509b.m14392h();
            case 16:
                return this.f6509b.m14408d();
            case 32:
                return this.f6509b.m14404e();
            case 64:
                return this.f6509b.m14400f();
            case 128:
                return this.f6509b.m14372m();
            case 256:
                return this.f6509b.m14370n();
            case 512:
                return this.f6509b.m14427a();
            default:
                return 0.0f;
        }
    }

    /* renamed from: a */
    private void m14349a(int i, float f) {
        float m14350a = m14350a(i);
        m14348a(i, m14350a, f - m14350a);
    }

    /* renamed from: a */
    private void m14348a(int i, float f, float f2) {
        AbstractC1775a abstractC1775a;
        if (this.f6520y.size() > 0) {
            Iterator<AbstractC1775a> it2 = this.f6520y.keySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    abstractC1775a = null;
                    break;
                }
                abstractC1775a = it2.next();
                C1847c c1847c = this.f6520y.get(abstractC1775a);
                if (c1847c.m14308a(i) && c1847c.f6526a == 0) {
                    break;
                }
            }
            if (abstractC1775a != null) {
                abstractC1775a.mo14505b();
            }
        }
        this.f6508a.add(new C1846b(i, f, f2));
        View view = this.f6510c.get();
        if (view != null) {
            view.removeCallbacks(this.f6519x);
            view.post(this.f6519x);
        }
    }

    /* renamed from: b */
    private void m14339b(int i, float f) {
        m14348a(i, m14350a(i), f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m14334c(int i, float f) {
        switch (i) {
            case 1:
                this.f6509b.m14387i(f);
                return;
            case 2:
                this.f6509b.m14383j(f);
                return;
            case 4:
                this.f6509b.m14395g(f);
                return;
            case 8:
                this.f6509b.m14391h(f);
                return;
            case 16:
                this.f6509b.m14407d(f);
                return;
            case 32:
                this.f6509b.m14403e(f);
                return;
            case 64:
                this.f6509b.m14399f(f);
                return;
            case 128:
                this.f6509b.m14379k(f);
                return;
            case 256:
                this.f6509b.m14375l(f);
                return;
            case 512:
                this.f6509b.m14426a(f);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m14329e() {
        C1819q m14499b = C1819q.m14499b(1.0f);
        ArrayList arrayList = (ArrayList) this.f6508a.clone();
        this.f6508a.clear();
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i |= ((C1846b) arrayList.get(i2)).f6523a;
        }
        this.f6520y.put(m14499b, new C1847c(i, arrayList));
        m14499b.m14514a((C1819q.AbstractC1826b) this.f6518k);
        m14499b.a((AbstractC1775a.AbstractC1776a) this.f6518k);
        if (this.f6514g) {
            m14499b.mo14518a(this.f6513f);
        }
        if (this.f6512e) {
            m14499b.mo14503b(this.f6511d);
        }
        if (this.f6516i) {
            m14499b.mo14517a(this.f6515h);
        }
        m14499b.mo14521a();
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public long mo14352a() {
        return this.f6512e ? this.f6511d : new C1819q().mo14491e();
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14351a(float f) {
        m14349a(128, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14347a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f6512e = true;
        this.f6511d = j;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14346a(Interpolator interpolator) {
        this.f6516i = true;
        this.f6515h = interpolator;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: a */
    public AbstractC1835b mo14345a(AbstractC1775a.AbstractC1776a abstractC1776a) {
        this.f6517j = abstractC1776a;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public long mo14341b() {
        if (this.f6514g) {
            return this.f6513f;
        }
        return 0L;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public AbstractC1835b mo14340b(float f) {
        m14339b(128, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: b */
    public AbstractC1835b mo14338b(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f6514g = true;
        this.f6513f = j;
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: c */
    public AbstractC1835b mo14335c(float f) {
        m14349a(256, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: c */
    public void mo14336c() {
        m14329e();
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: d */
    public AbstractC1835b mo14331d(float f) {
        m14339b(256, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: d */
    public void mo14332d() {
        if (this.f6520y.size() > 0) {
            for (AbstractC1775a abstractC1775a : ((HashMap) this.f6520y.clone()).keySet()) {
                abstractC1775a.mo14505b();
            }
        }
        this.f6508a.clear();
        View view = this.f6510c.get();
        if (view != null) {
            view.removeCallbacks(this.f6519x);
        }
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: e */
    public AbstractC1835b mo14328e(float f) {
        m14349a(16, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: f */
    public AbstractC1835b mo14327f(float f) {
        m14339b(16, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: g */
    public AbstractC1835b mo14326g(float f) {
        m14349a(32, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: h */
    public AbstractC1835b mo14325h(float f) {
        m14339b(32, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: i */
    public AbstractC1835b mo14324i(float f) {
        m14349a(64, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: j */
    public AbstractC1835b mo14323j(float f) {
        m14339b(64, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: k */
    public AbstractC1835b mo14322k(float f) {
        m14349a(1, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: l */
    public AbstractC1835b mo14321l(float f) {
        m14339b(1, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: m */
    public AbstractC1835b mo14320m(float f) {
        m14349a(2, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: n */
    public AbstractC1835b mo14319n(float f) {
        m14339b(2, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: o */
    public AbstractC1835b mo14318o(float f) {
        m14349a(4, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: p */
    public AbstractC1835b mo14317p(float f) {
        m14339b(4, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: q */
    public AbstractC1835b mo14316q(float f) {
        m14349a(8, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: r */
    public AbstractC1835b mo14315r(float f) {
        m14339b(8, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: s */
    public AbstractC1835b mo14314s(float f) {
        m14349a(512, f);
        return this;
    }

    @Override // com.p113c.p116c.AbstractC1835b
    /* renamed from: t */
    public AbstractC1835b mo14313t(float f) {
        m14339b(512, f);
        return this;
    }
}
