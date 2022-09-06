package com.fimi.soul.view.photodraweeview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.p001v4.view.GestureDetectorCompat;
import android.support.p001v4.view.MotionEventCompat;
import android.support.p001v4.widget.ScrollerCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import java.lang.ref.WeakReference;
/* renamed from: com.fimi.soul.view.photodraweeview.a */
/* loaded from: classes.dex */
public class View$OnTouchListenerC3861a implements View.OnTouchListener, AbstractC3866c, AbstractC3869f {

    /* renamed from: e */
    private static final int f16380e = -1;

    /* renamed from: f */
    private static final int f16381f = 0;

    /* renamed from: g */
    private static final int f16382g = 1;

    /* renamed from: h */
    private static final int f16383h = 2;

    /* renamed from: A */
    private AbstractC3870g f16384A;

    /* renamed from: B */
    private View.OnLongClickListener f16385B;

    /* renamed from: C */
    private AbstractC3868e f16386C;

    /* renamed from: p */
    private ScaleGestureDetector$OnScaleGestureListenerC3871h f16394p;

    /* renamed from: q */
    private GestureDetectorCompat f16395q;

    /* renamed from: x */
    private RunnableC3864b f16402x;

    /* renamed from: y */
    private WeakReference<DraweeView<GenericDraweeHierarchy>> f16403y;

    /* renamed from: z */
    private AbstractC3867d f16404z;

    /* renamed from: i */
    private final float[] f16387i = new float[9];

    /* renamed from: j */
    private final RectF f16388j = new RectF();

    /* renamed from: k */
    private final Interpolator f16389k = new AccelerateDecelerateInterpolator();

    /* renamed from: l */
    private float f16390l = 1.0f;

    /* renamed from: m */
    private float f16391m = 1.75f;

    /* renamed from: n */
    private float f16392n = 3.0f;

    /* renamed from: o */
    private long f16393o = 200;

    /* renamed from: r */
    private boolean f16396r = false;

    /* renamed from: s */
    private boolean f16397s = true;

    /* renamed from: t */
    private int f16398t = 2;

    /* renamed from: u */
    private final Matrix f16399u = new Matrix();

    /* renamed from: v */
    private int f16400v = -1;

    /* renamed from: w */
    private int f16401w = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.view.photodraweeview.a$a */
    /* loaded from: classes.dex */
    public class RunnableC3863a implements Runnable {

        /* renamed from: b */
        private final float f16407b;

        /* renamed from: c */
        private final float f16408c;

        /* renamed from: d */
        private final long f16409d = System.currentTimeMillis();

        /* renamed from: e */
        private final float f16410e;

        /* renamed from: f */
        private final float f16411f;

        public RunnableC3863a(float f, float f2, float f3, float f4) {
            this.f16407b = f3;
            this.f16408c = f4;
            this.f16410e = f;
            this.f16411f = f2;
        }

        /* renamed from: a */
        private float m6748a() {
            return View$OnTouchListenerC3861a.this.f16389k.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f16409d)) * 1.0f) / ((float) View$OnTouchListenerC3861a.this.f16393o)));
        }

        @Override // java.lang.Runnable
        public void run() {
            DraweeView<GenericDraweeHierarchy> m6769a = View$OnTouchListenerC3861a.this.m6769a();
            if (m6769a == null) {
                return;
            }
            float m6748a = m6748a();
            View$OnTouchListenerC3861a.this.mo6738a((this.f16410e + ((this.f16411f - this.f16410e) * m6748a)) / View$OnTouchListenerC3861a.this.getScale(), this.f16407b, this.f16408c);
            if (m6748a >= 1.0f) {
                return;
            }
            View$OnTouchListenerC3861a.this.m6766a(m6769a, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.fimi.soul.view.photodraweeview.a$b */
    /* loaded from: classes.dex */
    public class RunnableC3864b implements Runnable {

        /* renamed from: b */
        private final ScrollerCompat f16413b;

        /* renamed from: c */
        private int f16414c;

        /* renamed from: d */
        private int f16415d;

        public RunnableC3864b(Context context) {
            this.f16413b = ScrollerCompat.create(context);
        }

        /* renamed from: a */
        public void m6747a() {
            this.f16413b.abortAnimation();
        }

        /* renamed from: a */
        public void m6746a(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF m6760c = View$OnTouchListenerC3861a.this.m6760c();
            if (m6760c == null) {
                return;
            }
            int round = Math.round(-m6760c.left);
            if (i < m6760c.width()) {
                i5 = Math.round(m6760c.width() - i);
                i6 = 0;
            } else {
                i5 = round;
                i6 = round;
            }
            int round2 = Math.round(-m6760c.top);
            if (i2 < m6760c.height()) {
                i7 = Math.round(m6760c.height() - i2);
                i8 = 0;
            } else {
                i7 = round2;
                i8 = round2;
            }
            this.f16414c = round;
            this.f16415d = round2;
            if (round == i5 && round2 == i7) {
                return;
            }
            this.f16413b.fling(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            DraweeView<GenericDraweeHierarchy> m6769a;
            if (!this.f16413b.isFinished() && (m6769a = View$OnTouchListenerC3861a.this.m6769a()) != null && this.f16413b.computeScrollOffset()) {
                int currX = this.f16413b.getCurrX();
                int currY = this.f16413b.getCurrY();
                View$OnTouchListenerC3861a.this.f16399u.postTranslate(this.f16414c - currX, this.f16415d - currY);
                m6769a.invalidate();
                this.f16414c = currX;
                this.f16415d = currY;
                View$OnTouchListenerC3861a.this.m6766a(m6769a, this);
            }
        }
    }

    public View$OnTouchListenerC3861a(DraweeView<GenericDraweeHierarchy> draweeView) {
        this.f16403y = new WeakReference<>(draweeView);
        draweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        draweeView.setOnTouchListener(this);
        this.f16394p = new ScaleGestureDetector$OnScaleGestureListenerC3871h(draweeView.getContext(), this);
        this.f16395q = new GestureDetectorCompat(draweeView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.fimi.soul.view.photodraweeview.a.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                if (View$OnTouchListenerC3861a.this.f16385B != null) {
                    View$OnTouchListenerC3861a.this.f16385B.onLongClick(View$OnTouchListenerC3861a.this.m6769a());
                }
            }
        });
        this.f16395q.setOnDoubleTapListener(new GestureDetector$OnDoubleTapListenerC3865b(this));
    }

    /* renamed from: a */
    private float m6767a(Matrix matrix, int i) {
        matrix.getValues(this.f16387i);
        return this.f16387i[i];
    }

    /* renamed from: a */
    private RectF m6768a(Matrix matrix) {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a == null || (this.f16401w == -1 && this.f16400v == -1)) {
            return null;
        }
        this.f16388j.set(0.0f, 0.0f, this.f16401w, this.f16400v);
        m6769a.getHierarchy().getActualImageBounds(this.f16388j);
        matrix.mapRect(this.f16388j);
        return this.f16388j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6766a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    /* renamed from: b */
    private static void m6762b(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f2 < f3) {
            return;
        }
        throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
    }

    /* renamed from: h */
    private int m6754h() {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a != null) {
            return (m6769a.getWidth() - m6769a.getPaddingLeft()) - m6769a.getPaddingRight();
        }
        return 0;
    }

    /* renamed from: i */
    private int m6753i() {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a != null) {
            return (m6769a.getHeight() - m6769a.getPaddingTop()) - m6769a.getPaddingBottom();
        }
        return 0;
    }

    /* renamed from: j */
    private void m6752j() {
        if (this.f16401w == -1 && this.f16400v == -1) {
            return;
        }
        m6751k();
    }

    /* renamed from: k */
    private void m6751k() {
        this.f16399u.reset();
        m6756e();
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a != null) {
            m6769a.invalidate();
        }
    }

    /* renamed from: l */
    private void m6750l() {
        RectF m6760c;
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a == null || getScale() >= this.f16390l || (m6760c = m6760c()) == null) {
            return;
        }
        m6769a.post(new RunnableC3863a(getScale(), this.f16390l, m6760c.centerX(), m6760c.centerY()));
    }

    /* renamed from: m */
    private void m6749m() {
        if (this.f16402x != null) {
            this.f16402x.m6747a();
            this.f16402x = null;
        }
    }

    @Nullable
    /* renamed from: a */
    public DraweeView<GenericDraweeHierarchy> m6769a() {
        return this.f16403y.get();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3869f
    /* renamed from: a */
    public void mo6739a(float f, float f2) {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a == null || this.f16394p.m6734a()) {
            return;
        }
        this.f16399u.postTranslate(f, f2);
        m6758d();
        ViewParent parent = m6769a.getParent();
        if (parent == null) {
            return;
        }
        if (!this.f16397s || this.f16394p.m6734a() || this.f16396r) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (this.f16398t != 2 && ((this.f16398t != 0 || f < 1.0f) && (this.f16398t != 1 || f > -1.0f))) {
        } else {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3869f
    /* renamed from: a */
    public void mo6738a(float f, float f2, float f3) {
        if (getScale() < this.f16392n || f < 1.0f) {
            if (this.f16386C != null) {
                this.f16386C.m6740a(f, f2, f3);
            }
            this.f16399u.postScale(f, f, f2, f3);
            m6758d();
        }
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3869f
    /* renamed from: a */
    public void mo6737a(float f, float f2, float f3, float f4) {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a == null) {
            return;
        }
        this.f16402x = new RunnableC3864b(m6769a.getContext());
        this.f16402x.m6746a(m6754h(), m6753i(), (int) f3, (int) f4);
        m6769a.post(this.f16402x);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    /* renamed from: a */
    public void mo6744a(float f, float f2, float f3, boolean z) {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a == null || f < this.f16390l || f > this.f16392n) {
            return;
        }
        if (z) {
            m6769a.post(new RunnableC3863a(getScale(), f, f2, f3));
            return;
        }
        this.f16399u.setScale(f, f, f2, f3);
        m6758d();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    /* renamed from: a */
    public void mo6743a(float f, boolean z) {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a != null) {
            mo6744a(f, m6769a.getRight() / 2, m6769a.getBottom() / 2, false);
        }
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    /* renamed from: a */
    public void mo6742a(int i, int i2) {
        this.f16401w = i;
        this.f16400v = i2;
        m6752j();
    }

    /* renamed from: b */
    public Matrix m6763b() {
        return this.f16399u;
    }

    /* renamed from: c */
    public RectF m6760c() {
        m6756e();
        return m6768a(m6763b());
    }

    /* renamed from: d */
    public void m6758d() {
        DraweeView<GenericDraweeHierarchy> m6769a = m6769a();
        if (m6769a != null && m6756e()) {
            m6769a.invalidate();
        }
    }

    /* renamed from: e */
    public boolean m6756e() {
        float f = 0.0f;
        RectF m6768a = m6768a(m6763b());
        if (m6768a == null) {
            return false;
        }
        float height = m6768a.height();
        float width = m6768a.width();
        int m6753i = m6753i();
        float f2 = height <= ((float) m6753i) ? ((m6753i - height) / 2.0f) - m6768a.top : m6768a.top > 0.0f ? -m6768a.top : m6768a.bottom < ((float) m6753i) ? m6753i - m6768a.bottom : 0.0f;
        int m6754h = m6754h();
        if (width <= m6754h) {
            f = ((m6754h - width) / 2.0f) - m6768a.left;
            this.f16398t = 2;
        } else if (m6768a.left > 0.0f) {
            f = -m6768a.left;
            this.f16398t = 0;
        } else if (m6768a.right < m6754h) {
            f = m6754h - m6768a.right;
            this.f16398t = 1;
        } else {
            this.f16398t = -1;
        }
        this.f16399u.postTranslate(f, f2);
        return true;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3869f
    /* renamed from: f */
    public void mo6736f() {
        m6750l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void m6755g() {
        m6749m();
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getMaximumScale() {
        return this.f16392n;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getMediumScale() {
        return this.f16391m;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getMinimumScale() {
        return this.f16390l;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public AbstractC3867d getOnPhotoTapListener() {
        return this.f16404z;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public AbstractC3870g getOnViewTapListener() {
        return this.f16384A;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(m6767a(this.f16399u, 0), 2.0d)) + ((float) Math.pow(m6767a(this.f16399u, 3), 2.0d)));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                m6749m();
                break;
            case 1:
            case 3:
                ViewParent parent2 = view.getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        boolean m6734a = this.f16394p.m6734a();
        boolean m6731b = this.f16394p.m6731b();
        boolean m6732a = this.f16394p.m6732a(motionEvent);
        boolean z2 = !m6734a && !this.f16394p.m6734a();
        boolean z3 = !m6731b && !this.f16394p.m6731b();
        if (z2 && z3) {
            z = true;
        }
        this.f16396r = z;
        if (this.f16395q.onTouchEvent(motionEvent)) {
            return true;
        }
        return m6732a;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f16397s = z;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setMaximumScale(float f) {
        m6762b(this.f16390l, this.f16391m, f);
        this.f16392n = f;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setMediumScale(float f) {
        m6762b(this.f16390l, f, this.f16392n);
        this.f16391m = f;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setMinimumScale(float f) {
        m6762b(f, this.f16391m, this.f16392n);
        this.f16390l = f;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f16395q.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f16395q.setOnDoubleTapListener(new GestureDetector$OnDoubleTapListenerC3865b(this));
        }
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f16385B = onLongClickListener;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnPhotoTapListener(AbstractC3867d abstractC3867d) {
        this.f16404z = abstractC3867d;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnScaleChangeListener(AbstractC3868e abstractC3868e) {
        this.f16386C = abstractC3868e;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setOnViewTapListener(AbstractC3870g abstractC3870g) {
        this.f16384A = abstractC3870g;
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setScale(float f) {
        mo6743a(f, false);
    }

    @Override // com.fimi.soul.view.photodraweeview.AbstractC3866c
    public void setZoomTransitionDuration(long j) {
        if (j < 0) {
            j = 200;
        }
        this.f16393o = j;
    }
}
