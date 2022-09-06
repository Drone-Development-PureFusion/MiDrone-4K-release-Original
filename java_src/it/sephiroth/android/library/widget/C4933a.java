package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import it.sephiroth.android.library.C4881R;
/* renamed from: it.sephiroth.android.library.widget.a */
/* loaded from: classes2.dex */
public class C4933a {

    /* renamed from: L */
    private static final int f21170L = 0;

    /* renamed from: M */
    private static final int f21171M = 1;

    /* renamed from: N */
    private static final int f21172N = 2;

    /* renamed from: O */
    private static final int f21173O = 3;

    /* renamed from: P */
    private static final int f21174P = 4;

    /* renamed from: Q */
    private static final int f21175Q = 7;

    /* renamed from: R */
    private static final int f21176R = 7;

    /* renamed from: S */
    private static final float f21177S = 1.1f;

    /* renamed from: T */
    private static final int f21178T = 8;

    /* renamed from: U */
    private static final int f21179U = 16;

    /* renamed from: a */
    public static final int f21180a = 0;

    /* renamed from: b */
    public static final int f21181b = 1;

    /* renamed from: c */
    private static final String f21182c = "EdgeEffect";

    /* renamed from: d */
    private static final int f21183d = 1000;

    /* renamed from: e */
    private static final int f21184e = 167;

    /* renamed from: f */
    private static final int f21185f = 1000;

    /* renamed from: g */
    private static final float f21186g = 1.0f;

    /* renamed from: h */
    private static final float f21187h = 0.5f;

    /* renamed from: i */
    private static final float f21188i = 4.0f;

    /* renamed from: j */
    private static final float f21189j = 1.0f;

    /* renamed from: k */
    private static final float f21190k = 0.6f;

    /* renamed from: l */
    private static final int f21191l = 100;

    /* renamed from: m */
    private static final float f21192m = 0.001f;

    /* renamed from: u */
    private static final int f21193u = 300;

    /* renamed from: A */
    private float f21194A;

    /* renamed from: B */
    private float f21195B;

    /* renamed from: C */
    private float f21196C;

    /* renamed from: D */
    private float f21197D;

    /* renamed from: E */
    private float f21198E;

    /* renamed from: F */
    private float f21199F;

    /* renamed from: G */
    private float f21200G;

    /* renamed from: H */
    private float f21201H;

    /* renamed from: I */
    private long f21202I;

    /* renamed from: J */
    private float f21203J;

    /* renamed from: W */
    private float f21206W;

    /* renamed from: Y */
    private final int f21208Y;

    /* renamed from: Z */
    private final int f21209Z;

    /* renamed from: aa */
    private final int f21210aa;

    /* renamed from: ab */
    private final int f21211ab;

    /* renamed from: n */
    private final int f21212n;

    /* renamed from: o */
    private final Drawable f21213o;

    /* renamed from: p */
    private final Drawable f21214p;

    /* renamed from: q */
    private int f21215q;

    /* renamed from: r */
    private int f21216r;

    /* renamed from: s */
    private int f21217s;

    /* renamed from: t */
    private int f21218t;

    /* renamed from: v */
    private final int f21219v;

    /* renamed from: w */
    private float f21220w;

    /* renamed from: x */
    private float f21221x;

    /* renamed from: y */
    private float f21222y;

    /* renamed from: z */
    private float f21223z;

    /* renamed from: V */
    private int f21205V = 0;

    /* renamed from: X */
    private final Rect f21207X = new Rect();

    /* renamed from: K */
    private final Interpolator f21204K = new DecelerateInterpolator();

    public C4933a(Context context, int i) {
        Resources resources = context.getResources();
        this.f21213o = resources.getDrawable(C4881R.C4882drawable.hlv_overscroll_edge);
        this.f21214p = resources.getDrawable(C4881R.C4882drawable.hlv_overscroll_glow);
        this.f21212n = i;
        this.f21208Y = this.f21213o.getIntrinsicHeight();
        this.f21209Z = this.f21214p.getIntrinsicHeight();
        this.f21210aa = this.f21214p.getIntrinsicWidth();
        this.f21211ab = (int) (Math.min((((this.f21209Z * f21188i) * this.f21209Z) / this.f21210aa) * f21190k, this.f21209Z * f21188i) + f21187h);
        this.f21219v = (int) ((resources.getDisplayMetrics().density * 300.0f) + f21187h);
    }

    /* renamed from: d */
    private void m2655d() {
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.f21202I)) / this.f21203J, 1.0f);
        float interpolation = this.f21204K.getInterpolation(min);
        this.f21220w = this.f21194A + ((this.f21195B - this.f21194A) * interpolation);
        this.f21221x = this.f21196C + ((this.f21197D - this.f21196C) * interpolation);
        this.f21222y = this.f21198E + ((this.f21199F - this.f21198E) * interpolation);
        this.f21223z = this.f21200G + ((this.f21201H - this.f21200G) * interpolation);
        if (min >= 0.999f) {
            switch (this.f21205V) {
                case 1:
                    this.f21205V = 4;
                    this.f21202I = AnimationUtils.currentAnimationTimeMillis();
                    this.f21203J = 1000.0f;
                    this.f21194A = this.f21220w;
                    this.f21196C = this.f21221x;
                    this.f21198E = this.f21222y;
                    this.f21200G = this.f21223z;
                    this.f21195B = 0.0f;
                    this.f21197D = 0.0f;
                    this.f21199F = 0.0f;
                    this.f21201H = 0.0f;
                    return;
                case 2:
                    this.f21205V = 3;
                    this.f21202I = AnimationUtils.currentAnimationTimeMillis();
                    this.f21203J = 1000.0f;
                    this.f21194A = this.f21220w;
                    this.f21196C = this.f21221x;
                    this.f21198E = this.f21222y;
                    this.f21200G = this.f21223z;
                    this.f21195B = 0.0f;
                    this.f21197D = 0.0f;
                    this.f21199F = 0.0f;
                    this.f21201H = 0.0f;
                    return;
                case 3:
                    this.f21205V = 0;
                    return;
                case 4:
                    this.f21221x = ((this.f21201H != 0.0f ? 1.0f / (this.f21201H * this.f21201H) : Float.MAX_VALUE) * interpolation * (this.f21197D - this.f21196C)) + this.f21196C;
                    this.f21205V = 3;
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public Rect m2659a(boolean z) {
        int i = 0;
        this.f21207X.set(0, 0, this.f21215q, this.f21211ab);
        Rect rect = this.f21207X;
        int i2 = this.f21217s;
        int i3 = this.f21218t;
        if (z) {
            i = this.f21211ab;
        }
        rect.offset(i2, i3 - i);
        return this.f21207X;
    }

    /* renamed from: a */
    public void m2663a(float f) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f21205V != 4 || ((float) (currentAnimationTimeMillis - this.f21202I)) >= this.f21203J) {
            if (this.f21205V != 1) {
                this.f21223z = 1.0f;
            }
            this.f21205V = 1;
            this.f21202I = currentAnimationTimeMillis;
            this.f21203J = 167.0f;
            this.f21206W += f;
            float abs = Math.abs(this.f21206W);
            float max = Math.max((float) f21190k, Math.min(abs, 1.0f));
            this.f21194A = max;
            this.f21220w = max;
            float max2 = Math.max((float) f21187h, Math.min(abs * 7.0f, 1.0f));
            this.f21196C = max2;
            this.f21221x = max2;
            float min = Math.min(1.0f, this.f21222y + (Math.abs(f) * f21177S));
            this.f21198E = min;
            this.f21222y = min;
            float abs2 = Math.abs(f);
            if (f > 0.0f && this.f21206W < 0.0f) {
                abs2 = -abs2;
            }
            if (this.f21206W == 0.0f) {
                this.f21223z = 0.0f;
            }
            float min2 = Math.min((float) f21188i, Math.max(0.0f, (abs2 * 7.0f) + this.f21223z));
            this.f21200G = min2;
            this.f21223z = min2;
            this.f21195B = this.f21220w;
            this.f21197D = this.f21221x;
            this.f21199F = this.f21222y;
            this.f21201H = this.f21223z;
        }
    }

    /* renamed from: a */
    public void m2662a(int i) {
        this.f21205V = 2;
        int max = Math.max(100, Math.abs(i));
        this.f21202I = AnimationUtils.currentAnimationTimeMillis();
        this.f21203J = 0.1f + (max * 0.03f);
        this.f21194A = 0.0f;
        this.f21196C = 0.0f;
        this.f21221x = 0.0f;
        this.f21198E = f21187h;
        this.f21200G = 0.0f;
        this.f21195B = Math.max(0, Math.min(max * 8, 1));
        this.f21197D = Math.max((float) f21187h, Math.min(max * 8, 1.0f));
        this.f21201H = Math.min(0.025f + ((max / 100) * max * 1.5E-4f), 1.75f);
        this.f21199F = Math.max(this.f21198E, Math.min(max * 16 * 1.0E-5f, 1.0f));
    }

    /* renamed from: a */
    public void m2661a(int i, int i2) {
        this.f21215q = i;
        this.f21216r = i2;
    }

    /* renamed from: a */
    public boolean m2664a() {
        return this.f21205V == 0;
    }

    /* renamed from: a */
    public boolean m2660a(Canvas canvas) {
        m2655d();
        this.f21214p.setAlpha((int) (Math.max(0.0f, Math.min(this.f21222y, 1.0f)) * 255.0f));
        int min = (int) Math.min((((this.f21209Z * this.f21223z) * this.f21209Z) / this.f21210aa) * f21190k, this.f21209Z * f21188i);
        if (this.f21212n == 0) {
            this.f21214p.setBounds(0, 0, this.f21215q, min);
        } else {
            this.f21214p.setBounds(0, 0, this.f21215q, min);
        }
        this.f21214p.draw(canvas);
        this.f21213o.setAlpha((int) (Math.max(0.0f, Math.min(this.f21220w, 1.0f)) * 255.0f));
        int i = (int) (this.f21208Y * this.f21221x);
        if (this.f21212n == 0) {
            this.f21213o.setBounds(0, 0, this.f21215q, i);
        } else {
            this.f21213o.setBounds(0, 0, this.f21215q, i);
        }
        this.f21213o.draw(canvas);
        if (this.f21205V == 3 && min == 0 && i == 0) {
            this.f21205V = 0;
        }
        return this.f21205V != 0;
    }

    /* renamed from: b */
    public void m2658b() {
        this.f21205V = 0;
    }

    /* renamed from: b */
    public void m2657b(int i, int i2) {
        this.f21217s = i;
        this.f21218t = i2;
    }

    /* renamed from: c */
    public void m2656c() {
        this.f21206W = 0.0f;
        if (this.f21205V == 1 || this.f21205V == 4) {
            this.f21205V = 3;
            this.f21194A = this.f21220w;
            this.f21196C = this.f21221x;
            this.f21198E = this.f21222y;
            this.f21200G = this.f21223z;
            this.f21195B = 0.0f;
            this.f21197D = 0.0f;
            this.f21199F = 0.0f;
            this.f21201H = 0.0f;
            this.f21202I = AnimationUtils.currentAnimationTimeMillis();
            this.f21203J = 1000.0f;
        }
    }
}
