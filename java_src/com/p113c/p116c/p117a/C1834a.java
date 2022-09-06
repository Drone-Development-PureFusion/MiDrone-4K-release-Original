package com.p113c.p116c.p117a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* renamed from: com.c.c.a.a */
/* loaded from: classes.dex */
public final class C1834a extends Animation {

    /* renamed from: a */
    public static final boolean f6442a;

    /* renamed from: b */
    private static final WeakHashMap<View, C1834a> f6443b;

    /* renamed from: c */
    private final WeakReference<View> f6444c;

    /* renamed from: e */
    private boolean f6446e;

    /* renamed from: g */
    private float f6448g;

    /* renamed from: h */
    private float f6449h;

    /* renamed from: i */
    private float f6450i;

    /* renamed from: j */
    private float f6451j;

    /* renamed from: k */
    private float f6452k;

    /* renamed from: n */
    private float f6455n;

    /* renamed from: o */
    private float f6456o;

    /* renamed from: d */
    private final Camera f6445d = new Camera();

    /* renamed from: f */
    private float f6447f = 1.0f;

    /* renamed from: l */
    private float f6453l = 1.0f;

    /* renamed from: m */
    private float f6454m = 1.0f;

    /* renamed from: p */
    private final RectF f6457p = new RectF();

    /* renamed from: q */
    private final RectF f6458q = new RectF();

    /* renamed from: r */
    private final Matrix f6459r = new Matrix();

    static {
        f6442a = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f6443b = new WeakHashMap<>();
    }

    private C1834a(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f6444c = new WeakReference<>(view);
    }

    /* renamed from: a */
    public static C1834a m14421a(View view) {
        C1834a c1834a = f6443b.get(view);
        if (c1834a == null || c1834a != view.getAnimation()) {
            C1834a c1834a2 = new C1834a(view);
            f6443b.put(view, c1834a2);
            return c1834a2;
        }
        return c1834a;
    }

    /* renamed from: a */
    private void m14424a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f6446e;
        float f = z ? this.f6448g : width / 2.0f;
        float f2 = z ? this.f6449h : height / 2.0f;
        float f3 = this.f6450i;
        float f4 = this.f6451j;
        float f5 = this.f6452k;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.f6445d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f6453l;
        float f7 = this.f6454m;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.f6455n, this.f6456o);
    }

    /* renamed from: a */
    private void m14423a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f6459r;
        matrix.reset();
        m14424a(matrix, view);
        this.f6459r.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    /* renamed from: o */
    private void m14368o() {
        View view = this.f6444c.get();
        if (view != null) {
            m14423a(this.f6457p, view);
        }
    }

    /* renamed from: p */
    private void m14367p() {
        View view = this.f6444c.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f6458q;
        m14423a(rectF, view);
        rectF.union(this.f6457p);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* renamed from: a */
    public float m14427a() {
        return this.f6447f;
    }

    /* renamed from: a */
    public void m14426a(float f) {
        if (this.f6447f != f) {
            this.f6447f = f;
            View view = this.f6444c.get();
            if (view == null) {
                return;
            }
            view.invalidate();
        }
    }

    /* renamed from: a */
    public void m14425a(int i) {
        View view = this.f6444c.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        View view = this.f6444c.get();
        if (view != null) {
            transformation.setAlpha(this.f6447f);
            m14424a(transformation.getMatrix(), view);
        }
    }

    /* renamed from: b */
    public float m14418b() {
        return this.f6448g;
    }

    /* renamed from: b */
    public void m14417b(float f) {
        if (!this.f6446e || this.f6448g != f) {
            m14368o();
            this.f6446e = true;
            this.f6448g = f;
            m14367p();
        }
    }

    /* renamed from: b */
    public void m14416b(int i) {
        View view = this.f6444c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    /* renamed from: c */
    public float m14412c() {
        return this.f6449h;
    }

    /* renamed from: c */
    public void m14411c(float f) {
        if (!this.f6446e || this.f6449h != f) {
            m14368o();
            this.f6446e = true;
            this.f6449h = f;
            m14367p();
        }
    }

    /* renamed from: d */
    public float m14408d() {
        return this.f6452k;
    }

    /* renamed from: d */
    public void m14407d(float f) {
        if (this.f6452k != f) {
            m14368o();
            this.f6452k = f;
            m14367p();
        }
    }

    /* renamed from: e */
    public float m14404e() {
        return this.f6450i;
    }

    /* renamed from: e */
    public void m14403e(float f) {
        if (this.f6450i != f) {
            m14368o();
            this.f6450i = f;
            m14367p();
        }
    }

    /* renamed from: f */
    public float m14400f() {
        return this.f6451j;
    }

    /* renamed from: f */
    public void m14399f(float f) {
        if (this.f6451j != f) {
            m14368o();
            this.f6451j = f;
            m14367p();
        }
    }

    /* renamed from: g */
    public float m14396g() {
        return this.f6453l;
    }

    /* renamed from: g */
    public void m14395g(float f) {
        if (this.f6453l != f) {
            m14368o();
            this.f6453l = f;
            m14367p();
        }
    }

    /* renamed from: h */
    public float m14392h() {
        return this.f6454m;
    }

    /* renamed from: h */
    public void m14391h(float f) {
        if (this.f6454m != f) {
            m14368o();
            this.f6454m = f;
            m14367p();
        }
    }

    /* renamed from: i */
    public int m14388i() {
        View view = this.f6444c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    /* renamed from: i */
    public void m14387i(float f) {
        if (this.f6455n != f) {
            m14368o();
            this.f6455n = f;
            m14367p();
        }
    }

    /* renamed from: j */
    public int m14384j() {
        View view = this.f6444c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    /* renamed from: j */
    public void m14383j(float f) {
        if (this.f6456o != f) {
            m14368o();
            this.f6456o = f;
            m14367p();
        }
    }

    /* renamed from: k */
    public float m14380k() {
        return this.f6455n;
    }

    /* renamed from: k */
    public void m14379k(float f) {
        View view = this.f6444c.get();
        if (view != null) {
            m14387i(f - view.getLeft());
        }
    }

    /* renamed from: l */
    public float m14376l() {
        return this.f6456o;
    }

    /* renamed from: l */
    public void m14375l(float f) {
        View view = this.f6444c.get();
        if (view != null) {
            m14383j(f - view.getTop());
        }
    }

    /* renamed from: m */
    public float m14372m() {
        View view = this.f6444c.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.f6455n;
    }

    /* renamed from: n */
    public float m14370n() {
        View view = this.f6444c.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.f6456o;
    }
}
