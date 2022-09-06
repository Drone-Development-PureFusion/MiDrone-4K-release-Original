package com.amap.api.mapcore.util;

import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
/* renamed from: com.amap.api.mapcore.util.di */
/* loaded from: classes.dex */
public class C0902di implements Cloneable {

    /* renamed from: l */
    long f2742l;

    /* renamed from: q */
    Interpolator f2747q;

    /* renamed from: r */
    Animation.AnimationListener f2748r;

    /* renamed from: x */
    private Handler f2754x;

    /* renamed from: y */
    private Runnable f2755y;

    /* renamed from: z */
    private Runnable f2756z;

    /* renamed from: d */
    boolean f2734d = false;

    /* renamed from: e */
    boolean f2735e = false;

    /* renamed from: f */
    boolean f2736f = false;

    /* renamed from: g */
    boolean f2737g = false;

    /* renamed from: h */
    boolean f2738h = true;

    /* renamed from: i */
    boolean f2739i = false;

    /* renamed from: j */
    boolean f2740j = false;

    /* renamed from: k */
    long f2741k = -1;

    /* renamed from: m */
    long f2743m = 500;

    /* renamed from: n */
    int f2744n = 0;

    /* renamed from: o */
    int f2745o = 0;

    /* renamed from: p */
    int f2746p = 1;

    /* renamed from: a */
    private float f2731a = 1.0f;

    /* renamed from: b */
    private boolean f2732b = false;

    /* renamed from: c */
    private boolean f2733c = true;

    /* renamed from: w */
    private boolean f2753w = true;

    /* renamed from: s */
    RectF f2749s = new RectF();

    /* renamed from: t */
    RectF f2750t = new RectF();

    /* renamed from: u */
    C0907dn f2751u = new C0907dn();

    /* renamed from: v */
    C0907dn f2752v = new C0907dn();

    public C0902di() {
        m18528j();
    }

    /* renamed from: m */
    private void m18525m() {
        if (this.f2748r != null) {
            if (this.f2754x == null) {
                this.f2748r.onAnimationStart();
            } else {
                this.f2754x.postAtFrontOfQueue(this.f2755y);
            }
        }
    }

    /* renamed from: n */
    private void m18524n() {
    }

    /* renamed from: o */
    private void m18523o() {
        if (this.f2748r != null) {
            if (this.f2754x == null) {
                this.f2748r.onAnimationEnd();
            } else {
                this.f2754x.postAtFrontOfQueue(this.f2756z);
            }
        }
    }

    @Override // 
    /* renamed from: a */
    public C0902di clone() {
        C0902di c0902di = (C0902di) super.clone();
        c0902di.f2749s = new RectF();
        c0902di.f2750t = new RectF();
        c0902di.f2751u = new C0907dn();
        c0902di.f2752v = new C0907dn();
        return c0902di;
    }

    /* renamed from: a */
    protected void mo18508a(float f, C0907dn c0907dn) {
    }

    /* renamed from: a */
    public void mo18520a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f2743m = j;
    }

    /* renamed from: a */
    public void m18535a(Interpolator interpolator) {
        this.f2747q = interpolator;
    }

    /* renamed from: a */
    public void m18534a(Animation.AnimationListener animationListener) {
        this.f2748r = animationListener;
    }

    /* renamed from: a */
    public boolean mo18519a(long j, C0907dn c0907dn) {
        float f;
        if (this.f2741k == -1) {
            this.f2741k = j;
        }
        long m18529g = m18529g();
        long j2 = this.f2743m;
        if (j2 != 0) {
            f = ((float) (j - (m18529g + this.f2741k))) / ((float) j2);
        } else {
            f = j < this.f2741k ? 0.0f : 1.0f;
        }
        boolean z = f >= 1.0f;
        this.f2733c = !z;
        float max = !this.f2740j ? Math.max(Math.min(f, 1.0f), 0.0f) : f;
        if ((max >= 0.0f || this.f2738h) && (max <= 1.0f || this.f2739i)) {
            if (!this.f2735e) {
                m18525m();
                this.f2735e = true;
            }
            if (this.f2740j) {
                max = Math.max(Math.min(max, 1.0f), 0.0f);
            }
            if (this.f2736f) {
                max = 1.0f - max;
            }
            mo18508a(this.f2747q.getInterpolation(max), c0907dn);
        }
        if (z) {
            if (this.f2744n != this.f2745o) {
                if (this.f2744n > 0) {
                    this.f2745o++;
                }
                if (this.f2746p == 2) {
                    this.f2736f = !this.f2736f;
                }
                this.f2741k = -1L;
                this.f2733c = true;
                m18524n();
            } else if (!this.f2734d) {
                this.f2734d = true;
                m18523o();
            }
        }
        if (this.f2733c || !this.f2753w) {
            return this.f2733c;
        }
        this.f2753w = false;
        return true;
    }

    /* renamed from: a */
    public boolean m18536a(long j, C0907dn c0907dn, float f) {
        this.f2731a = f;
        return mo18519a(j, c0907dn);
    }

    /* renamed from: b */
    public void m18533b() {
        if (this.f2735e && !this.f2734d) {
            m18523o();
            this.f2734d = true;
        }
        this.f2741k = Long.MIN_VALUE;
        this.f2753w = false;
        this.f2733c = false;
    }

    /* renamed from: b */
    public void mo18517b(long j) {
        this.f2741k = j;
        this.f2734d = false;
        this.f2735e = false;
        this.f2736f = false;
        this.f2745o = 0;
        this.f2733c = true;
    }

    /* renamed from: c */
    public void m18532c() {
        mo18517b(-1L);
    }

    /* renamed from: d */
    public void m18531d() {
        mo18517b(AnimationUtils.currentAnimationTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public float m18530e() {
        return this.f2731a;
    }

    /* renamed from: f */
    public long mo18516f() {
        return this.f2743m;
    }

    /* renamed from: g */
    public long m18529g() {
        return this.f2742l;
    }

    /* renamed from: h */
    public boolean mo18515h() {
        return true;
    }

    /* renamed from: i */
    public boolean mo18514i() {
        return true;
    }

    /* renamed from: j */
    protected void m18528j() {
        if (this.f2747q == null) {
            this.f2747q = new AccelerateDecelerateInterpolator();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public boolean m18527k() {
        return this.f2735e;
    }

    /* renamed from: l */
    public boolean m18526l() {
        return this.f2734d;
    }
}
