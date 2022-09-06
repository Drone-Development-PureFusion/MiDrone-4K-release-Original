package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* renamed from: it.sephiroth.android.library.widget.d */
/* loaded from: classes.dex */
public class C4936d {

    /* renamed from: f */
    private static final int f21238f = 250;

    /* renamed from: g */
    private static final int f21239g = 0;

    /* renamed from: h */
    private static final int f21240h = 1;

    /* renamed from: i */
    private static float f21241i = 8.0f;

    /* renamed from: j */
    private static float f21242j;

    /* renamed from: a */
    private int f21243a;

    /* renamed from: b */
    private final C4937a f21244b;

    /* renamed from: c */
    private final C4937a f21245c;

    /* renamed from: d */
    private Interpolator f21246d;

    /* renamed from: e */
    private final boolean f21247e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: it.sephiroth.android.library.widget.d$a */
    /* loaded from: classes2.dex */
    public static class C4937a {

        /* renamed from: A */
        private static final int f21248A = 1;

        /* renamed from: B */
        private static final int f21249B = 2;

        /* renamed from: o */
        private static final float f21250o = 2000.0f;

        /* renamed from: r */
        private static final float f21252r = 0.35f;

        /* renamed from: s */
        private static final float f21253s = 0.5f;

        /* renamed from: t */
        private static final float f21254t = 1.0f;

        /* renamed from: u */
        private static final float f21255u = 0.175f;

        /* renamed from: v */
        private static final float f21256v = 0.35000002f;

        /* renamed from: w */
        private static final int f21257w = 100;

        /* renamed from: z */
        private static final int f21260z = 0;

        /* renamed from: a */
        private int f21261a;

        /* renamed from: b */
        private int f21262b;

        /* renamed from: c */
        private int f21263c;

        /* renamed from: d */
        private int f21264d;

        /* renamed from: e */
        private float f21265e;

        /* renamed from: f */
        private float f21266f;

        /* renamed from: g */
        private long f21267g;

        /* renamed from: h */
        private int f21268h;

        /* renamed from: i */
        private int f21269i;

        /* renamed from: j */
        private int f21270j;

        /* renamed from: l */
        private int f21272l;

        /* renamed from: p */
        private float f21275p;

        /* renamed from: q */
        private static float f21251q = (float) (Math.log(0.78d) / Math.log(0.9d));

        /* renamed from: x */
        private static final float[] f21258x = new float[101];

        /* renamed from: y */
        private static final float[] f21259y = new float[101];

        /* renamed from: m */
        private float f21273m = ViewConfiguration.getScrollFriction();

        /* renamed from: n */
        private int f21274n = 0;

        /* renamed from: k */
        private boolean f21271k = true;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5 = 0.0f;
            int i = 0;
            float f6 = 0.0f;
            while (i < 100) {
                float f7 = i / 100.0f;
                float f8 = 1.0f;
                float f9 = f6;
                while (true) {
                    f = ((f8 - f9) / 2.0f) + f9;
                    f2 = 3.0f * f * (1.0f - f);
                    float f10 = ((((1.0f - f) * f21255u) + (f21256v * f)) * f2) + (f * f * f);
                    if (Math.abs(f10 - f7) < 1.0E-5d) {
                        break;
                    } else if (f10 > f7) {
                        f8 = f;
                    } else {
                        f9 = f;
                    }
                }
                f21258x[i] = (f * f * f) + (f2 * (((1.0f - f) * f21253s) + f));
                float f11 = 1.0f;
                while (true) {
                    f3 = ((f11 - f5) / 2.0f) + f5;
                    f4 = 3.0f * f3 * (1.0f - f3);
                    float f12 = ((((1.0f - f3) * f21253s) + f3) * f4) + (f3 * f3 * f3);
                    if (Math.abs(f12 - f7) < 1.0E-5d) {
                        break;
                    } else if (f12 > f7) {
                        f11 = f3;
                    } else {
                        f5 = f3;
                    }
                }
                f21259y[i] = (f3 * f3 * f3) + ((((1.0f - f3) * f21255u) + (f21256v * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = f21258x;
            f21259y[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        C4937a(Context context) {
            this.f21275p = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        /* renamed from: a */
        private void m2609a(int i, int i2, int i3, int i4) {
            int i5;
            boolean z = true;
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.f21271k = true;
                return;
            }
            boolean z2 = i > i3;
            int i6 = z2 ? i3 : i2;
            if ((i - i6) * i4 < 0) {
                z = false;
            }
            if (z) {
                m2586g(i, i6, i4);
            } else if (m2592e(i4) > Math.abs(i5)) {
                m2608a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.f21272l);
            } else {
                m2591e(i, i6, i4);
            }
        }

        /* renamed from: c */
        private static float m2599c(int i) {
            if (i > 0) {
                return -2000.0f;
            }
            return f21250o;
        }

        /* renamed from: d */
        private double m2595d(int i) {
            return Math.log((f21252r * Math.abs(i)) / (this.f21273m * this.f21275p));
        }

        /* renamed from: d */
        private void m2596d() {
            float abs = (this.f21264d * this.f21264d) / (Math.abs(this.f21266f) * 2.0f);
            float signum = Math.signum(this.f21264d);
            if (abs > this.f21272l) {
                this.f21266f = (((-signum) * this.f21264d) * this.f21264d) / (this.f21272l * 2.0f);
                abs = this.f21272l;
            }
            this.f21272l = (int) abs;
            this.f21274n = 2;
            int i = this.f21261a;
            if (this.f21264d <= 0) {
                abs = -abs;
            }
            this.f21263c = ((int) abs) + i;
            this.f21268h = -((int) ((1000.0f * this.f21264d) / this.f21266f));
        }

        /* renamed from: d */
        private void m2594d(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = f21259y[i4];
                this.f21268h = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (f21259y[i4 + 1] - f2)) + f2) * this.f21268h);
            }
        }

        /* renamed from: e */
        private double m2592e(int i) {
            return Math.exp(m2595d(i) * (f21251q / (f21251q - 1.0d))) * this.f21273m * this.f21275p;
        }

        /* renamed from: e */
        private void m2591e(int i, int i2, int i3) {
            this.f21271k = false;
            this.f21274n = 1;
            this.f21261a = i;
            this.f21263c = i2;
            int i4 = i - i2;
            this.f21266f = m2599c(i4);
            this.f21264d = -i4;
            this.f21272l = Math.abs(i4);
            this.f21268h = (int) (Math.sqrt((i4 * (-2.0d)) / this.f21266f) * 1000.0d);
        }

        /* renamed from: f */
        private int m2589f(int i) {
            return (int) (Math.exp(m2595d(i) / (f21251q - 1.0d)) * 1000.0d);
        }

        /* renamed from: f */
        private void m2588f(int i, int i2, int i3) {
            float f = (-i3) / this.f21266f;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.f21266f)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.f21266f));
            this.f21267g -= (int) ((sqrt - f) * 1000.0f);
            this.f21261a = i2;
            this.f21264d = (int) ((-this.f21266f) * sqrt);
        }

        /* renamed from: g */
        private void m2586g(int i, int i2, int i3) {
            this.f21266f = m2599c(i3 == 0 ? i - i2 : i3);
            m2588f(i, i2, i3);
            m2596d();
        }

        /* renamed from: a */
        void m2613a() {
            this.f21262b = this.f21263c;
            this.f21271k = true;
        }

        /* renamed from: a */
        void m2612a(float f) {
            this.f21273m = f;
        }

        /* renamed from: a */
        void m2611a(int i) {
            this.f21263c = i;
            this.f21271k = false;
        }

        /* renamed from: a */
        void m2610a(int i, int i2, int i3) {
            this.f21271k = false;
            this.f21261a = i;
            this.f21263c = i + i2;
            this.f21267g = AnimationUtils.currentAnimationTimeMillis();
            this.f21268h = i3;
            this.f21266f = 0.0f;
            this.f21264d = 0;
        }

        /* renamed from: a */
        void m2608a(int i, int i2, int i3, int i4, int i5) {
            this.f21272l = i5;
            this.f21271k = false;
            this.f21264d = i2;
            this.f21265e = i2;
            this.f21269i = 0;
            this.f21268h = 0;
            this.f21267g = AnimationUtils.currentAnimationTimeMillis();
            this.f21261a = i;
            this.f21262b = i;
            if (i > i4 || i < i3) {
                m2609a(i, i3, i4, i2);
                return;
            }
            this.f21274n = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int m2589f = m2589f(i2);
                this.f21269i = m2589f;
                this.f21268h = m2589f;
                d = m2592e(i2);
            }
            this.f21270j = (int) (d * Math.signum(i2));
            this.f21263c = this.f21270j + i;
            if (this.f21263c < i3) {
                m2594d(this.f21261a, this.f21263c, i3);
                this.f21263c = i3;
            }
            if (this.f21263c <= i4) {
                return;
            }
            m2594d(this.f21261a, this.f21263c, i4);
            this.f21263c = i4;
        }

        /* renamed from: b */
        void m2604b(float f) {
            this.f21262b = this.f21261a + Math.round((this.f21263c - this.f21261a) * f);
        }

        /* renamed from: b */
        void m2603b(int i) {
            this.f21268h = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.f21267g)) + i;
            this.f21271k = false;
        }

        /* renamed from: b */
        boolean m2605b() {
            switch (this.f21274n) {
                case 0:
                    if (this.f21268h >= this.f21269i) {
                        return false;
                    }
                    this.f21261a = this.f21263c;
                    this.f21264d = (int) this.f21265e;
                    this.f21266f = m2599c(this.f21264d);
                    this.f21267g += this.f21268h;
                    m2596d();
                    break;
                case 1:
                    return false;
                case 2:
                    this.f21267g += this.f21268h;
                    m2591e(this.f21263c, this.f21261a, 0);
                    break;
            }
            m2600c();
            return true;
        }

        /* renamed from: b */
        boolean m2602b(int i, int i2, int i3) {
            this.f21271k = true;
            this.f21263c = i;
            this.f21261a = i;
            this.f21264d = 0;
            this.f21267g = AnimationUtils.currentAnimationTimeMillis();
            this.f21268h = 0;
            if (i < i2) {
                m2591e(i, i2, 0);
            } else if (i > i3) {
                m2591e(i, i3, 0);
            }
            return !this.f21271k;
        }

        /* renamed from: c */
        void m2598c(int i, int i2, int i3) {
            if (this.f21274n == 0) {
                this.f21272l = i3;
                this.f21267g = AnimationUtils.currentAnimationTimeMillis();
                m2609a(i, i2, i2, (int) this.f21265e);
            }
        }

        /* renamed from: c */
        boolean m2600c() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f21267g;
            if (currentAnimationTimeMillis > this.f21268h) {
                return false;
            }
            double d = 0.0d;
            switch (this.f21274n) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.f21269i;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = f21258x[i];
                        f3 = (f21258x[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.f21265e = ((f3 * this.f21270j) / this.f21269i) * 1000.0f;
                    d = f2 * this.f21270j;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.f21268h;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.f21264d);
                    d = this.f21272l * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.f21265e = ((-f6) + f7) * signum * this.f21272l * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.f21265e = this.f21264d + (this.f21266f * f8);
                    d = ((f8 * (this.f21266f * f8)) / 2.0f) + (this.f21264d * f8);
                    break;
            }
            this.f21262b = ((int) Math.round(d)) + this.f21261a;
            return true;
        }
    }

    static {
        f21242j = 1.0f;
        f21242j = 1.0f / m2640a(1.0f);
    }

    public C4936d(Context context) {
        this(context, null);
    }

    public C4936d(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public C4936d(Context context, Interpolator interpolator, float f, float f2) {
        this(context, interpolator, true);
    }

    public C4936d(Context context, Interpolator interpolator, float f, float f2, boolean z) {
        this(context, interpolator, z);
    }

    public C4936d(Context context, Interpolator interpolator, boolean z) {
        this.f21246d = interpolator;
        this.f21247e = z;
        this.f21244b = new C4937a(context);
        this.f21245c = new C4937a(context);
    }

    /* renamed from: a */
    public static float m2640a(float f) {
        float f2 = f21241i * f;
        return (f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f) * f21242j;
    }

    @Deprecated
    /* renamed from: a */
    public void m2638a(int i) {
        this.f21244b.m2603b(i);
        this.f21245c.m2603b(i);
    }

    /* renamed from: a */
    public void m2637a(int i, int i2, int i3) {
        this.f21244b.m2598c(i, i2, i3);
    }

    /* renamed from: a */
    public void m2636a(int i, int i2, int i3, int i4) {
        m2635a(i, i2, i3, i4, 250);
    }

    /* renamed from: a */
    public void m2635a(int i, int i2, int i3, int i4, int i5) {
        this.f21243a = 0;
        this.f21244b.m2610a(i, i3, i5);
        this.f21245c.m2610a(i2, i4, i5);
    }

    /* renamed from: a */
    public void m2633a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m2632a(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    /* renamed from: a */
    public void m2632a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.f21247e && !m2641a()) {
            float f = this.f21244b.f21265e;
            float f2 = this.f21245c.f21265e;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.f21243a = 1;
                this.f21244b.m2608a(i, i11, i5, i6, i9);
                this.f21245c.m2608a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.f21243a = 1;
        this.f21244b.m2608a(i, i11, i5, i6, i9);
        this.f21245c.m2608a(i2, i4, i7, i8, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2631a(Interpolator interpolator) {
        this.f21246d = interpolator;
    }

    /* renamed from: a */
    public final void m2630a(boolean z) {
        this.f21244b.f21271k = this.f21245c.f21271k = z;
    }

    /* renamed from: a */
    public final boolean m2641a() {
        return this.f21244b.f21271k && this.f21245c.f21271k;
    }

    /* renamed from: a */
    public boolean m2639a(float f, float f2) {
        return !m2641a() && Math.signum(f) == Math.signum((float) (this.f21244b.f21263c - this.f21244b.f21261a)) && Math.signum(f2) == Math.signum((float) (this.f21245c.f21263c - this.f21245c.f21261a));
    }

    /* renamed from: a */
    public boolean m2634a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f21243a = 1;
        return this.f21244b.m2602b(i, i3, i4) || this.f21245c.m2602b(i2, i5, i6);
    }

    /* renamed from: b */
    public final int m2629b() {
        return this.f21244b.f21262b;
    }

    /* renamed from: b */
    public final void m2628b(float f) {
        this.f21244b.m2612a(f);
        this.f21245c.m2612a(f);
    }

    @Deprecated
    /* renamed from: b */
    public void m2627b(int i) {
        this.f21244b.m2611a(i);
    }

    /* renamed from: b */
    public void m2626b(int i, int i2, int i3) {
        this.f21245c.m2598c(i, i2, i3);
    }

    /* renamed from: c */
    public final int m2625c() {
        return this.f21245c.f21262b;
    }

    @Deprecated
    /* renamed from: c */
    public void m2624c(int i) {
        this.f21245c.m2611a(i);
    }

    /* renamed from: d */
    public float m2623d() {
        return FloatMath.sqrt((this.f21244b.f21265e * this.f21244b.f21265e) + (this.f21245c.f21265e * this.f21245c.f21265e));
    }

    /* renamed from: e */
    public final int m2622e() {
        return this.f21244b.f21261a;
    }

    /* renamed from: f */
    public final int m2621f() {
        return this.f21245c.f21261a;
    }

    /* renamed from: g */
    public final int m2620g() {
        return this.f21244b.f21263c;
    }

    /* renamed from: h */
    public final int m2619h() {
        return this.f21245c.f21263c;
    }

    @Deprecated
    /* renamed from: i */
    public final int m2618i() {
        return Math.max(this.f21244b.f21268h, this.f21245c.f21268h);
    }

    /* renamed from: j */
    public boolean m2617j() {
        if (m2641a()) {
            return false;
        }
        switch (this.f21243a) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f21244b.f21267g;
                int i = this.f21244b.f21268h;
                if (currentAnimationTimeMillis >= i) {
                    m2615l();
                    break;
                } else {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    float m2640a = this.f21246d == null ? m2640a(f) : this.f21246d.getInterpolation(f);
                    this.f21244b.m2604b(m2640a);
                    this.f21245c.m2604b(m2640a);
                    break;
                }
            case 1:
                if (!this.f21244b.f21271k && !this.f21244b.m2600c() && !this.f21244b.m2605b()) {
                    this.f21244b.m2613a();
                }
                if (!this.f21245c.f21271k && !this.f21245c.m2600c() && !this.f21245c.m2605b()) {
                    this.f21245c.m2613a();
                    break;
                }
                break;
        }
        return true;
    }

    /* renamed from: k */
    public boolean m2616k() {
        return (!this.f21244b.f21271k && this.f21244b.f21274n != 0) || (!this.f21245c.f21271k && this.f21245c.f21274n != 0);
    }

    /* renamed from: l */
    public void m2615l() {
        this.f21244b.m2613a();
        this.f21245c.m2613a();
    }

    /* renamed from: m */
    public int m2614m() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.f21244b.f21267g, this.f21245c.f21267g));
    }
}
