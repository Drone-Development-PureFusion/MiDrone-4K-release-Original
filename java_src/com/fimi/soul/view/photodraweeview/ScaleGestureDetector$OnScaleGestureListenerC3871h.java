package com.fimi.soul.view.photodraweeview;

import android.content.Context;
import android.support.p001v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* renamed from: com.fimi.soul.view.photodraweeview.h */
/* loaded from: classes.dex */
public class ScaleGestureDetector$OnScaleGestureListenerC3871h implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: c */
    private static final int f16421c = -1;

    /* renamed from: a */
    float f16422a;

    /* renamed from: b */
    float f16423b;

    /* renamed from: d */
    private final float f16424d;

    /* renamed from: e */
    private final float f16425e;

    /* renamed from: f */
    private final ScaleGestureDetector f16426f;

    /* renamed from: g */
    private final AbstractC3869f f16427g;

    /* renamed from: h */
    private VelocityTracker f16428h;

    /* renamed from: i */
    private boolean f16429i;

    /* renamed from: j */
    private int f16430j = -1;

    /* renamed from: k */
    private int f16431k = 0;

    public ScaleGestureDetector$OnScaleGestureListenerC3871h(Context context, AbstractC3869f abstractC3869f) {
        this.f16426f = new ScaleGestureDetector(context, this);
        this.f16427g = abstractC3869f;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f16425e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f16424d = viewConfiguration.getScaledTouchSlop();
    }

    /* renamed from: a */
    private void m6733a(int i, MotionEvent motionEvent) {
        int i2 = 0;
        switch (i) {
            case 0:
                this.f16430j = motionEvent.getPointerId(0);
                break;
            case 1:
            case 3:
                this.f16430j = -1;
                break;
            case 6:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f16430j) {
                    int i3 = actionIndex == 0 ? 1 : 0;
                    this.f16430j = MotionEventCompat.getPointerId(motionEvent, i3);
                    this.f16422a = MotionEventCompat.getX(motionEvent, i3);
                    this.f16423b = MotionEventCompat.getY(motionEvent, i3);
                    break;
                }
                break;
        }
        if (this.f16430j != -1) {
            i2 = this.f16430j;
        }
        this.f16431k = MotionEventCompat.findPointerIndex(motionEvent, i2);
    }

    /* renamed from: b */
    private float m6729b(MotionEvent motionEvent) {
        try {
            return MotionEventCompat.getX(motionEvent, this.f16431k);
        } catch (Exception e) {
            return motionEvent.getX();
        }
    }

    /* renamed from: b */
    private void m6730b(int i, MotionEvent motionEvent) {
        boolean z = false;
        switch (i) {
            case 0:
                this.f16428h = VelocityTracker.obtain();
                if (this.f16428h != null) {
                    this.f16428h.addMovement(motionEvent);
                }
                this.f16422a = m6729b(motionEvent);
                this.f16423b = m6728c(motionEvent);
                this.f16429i = false;
                return;
            case 1:
                if (this.f16429i && this.f16428h != null) {
                    this.f16422a = m6729b(motionEvent);
                    this.f16423b = m6728c(motionEvent);
                    this.f16428h.addMovement(motionEvent);
                    this.f16428h.computeCurrentVelocity(1000);
                    float xVelocity = this.f16428h.getXVelocity();
                    float yVelocity = this.f16428h.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f16425e) {
                        this.f16427g.mo6737a(this.f16422a, this.f16423b, -xVelocity, -yVelocity);
                    }
                }
                if (this.f16428h == null) {
                    return;
                }
                this.f16428h.recycle();
                this.f16428h = null;
                return;
            case 2:
                float m6729b = m6729b(motionEvent);
                float m6728c = m6728c(motionEvent);
                float f = m6729b - this.f16422a;
                float f2 = m6728c - this.f16423b;
                if (!this.f16429i) {
                    if (Math.sqrt((f * f) + (f2 * f2)) >= this.f16424d) {
                        z = true;
                    }
                    this.f16429i = z;
                }
                if (!this.f16429i) {
                    return;
                }
                this.f16427g.mo6739a(f, f2);
                this.f16422a = m6729b;
                this.f16423b = m6728c;
                if (this.f16428h == null) {
                    return;
                }
                this.f16428h.addMovement(motionEvent);
                return;
            case 3:
                if (this.f16428h == null) {
                    return;
                }
                this.f16428h.recycle();
                this.f16428h = null;
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private float m6728c(MotionEvent motionEvent) {
        try {
            return MotionEventCompat.getY(motionEvent, this.f16431k);
        } catch (Exception e) {
            return motionEvent.getY();
        }
    }

    /* renamed from: a */
    public boolean m6734a() {
        return this.f16426f.isInProgress();
    }

    /* renamed from: a */
    public boolean m6732a(MotionEvent motionEvent) {
        this.f16426f.onTouchEvent(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        m6733a(actionMasked, motionEvent);
        m6730b(actionMasked, motionEvent);
        return true;
    }

    /* renamed from: b */
    public boolean m6731b() {
        return this.f16429i;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
            return false;
        }
        this.f16427g.mo6738a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f16427g.mo6736f();
    }
}
