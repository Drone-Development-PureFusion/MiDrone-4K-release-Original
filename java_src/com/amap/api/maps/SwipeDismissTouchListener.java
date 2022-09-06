package com.amap.api.maps;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a */
    private int f3604a;

    /* renamed from: b */
    private int f3605b;

    /* renamed from: c */
    private int f3606c;

    /* renamed from: d */
    private long f3607d;

    /* renamed from: e */
    private View f3608e;

    /* renamed from: f */
    private DismissCallbacks f3609f;

    /* renamed from: g */
    private int f3610g = 1;

    /* renamed from: h */
    private float f3611h;

    /* renamed from: i */
    private float f3612i;

    /* renamed from: j */
    private boolean f3613j;

    /* renamed from: k */
    private int f3614k;

    /* renamed from: l */
    private Object f3615l;

    /* renamed from: m */
    private VelocityTracker f3616m;

    /* renamed from: n */
    private float f3617n;

    /* renamed from: o */
    private boolean f3618o;

    /* renamed from: p */
    private boolean f3619p;

    /* loaded from: classes.dex */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotifySwipe();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f3604a = viewConfiguration.getScaledTouchSlop();
        this.f3605b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f3606c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3607d = view.getContext().getResources().getInteger(17694720);
        this.f3608e = view;
        this.f3615l = obj;
        this.f3609f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m17421a() {
        this.f3609f.onDismiss(this.f3608e, this.f3615l);
        final ViewGroup.LayoutParams layoutParams = this.f3608e.getLayoutParams();
        final int height = this.f3608e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f3607d);
        duration.addListener(new AnimatorListenerAdapter() { // from class: com.amap.api.maps.SwipeDismissTouchListener.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SwipeDismissTouchListener.this.f3608e.setAlpha(0.0f);
                SwipeDismissTouchListener.this.f3608e.setTranslationX(0.0f);
                layoutParams.height = height;
                SwipeDismissTouchListener.this.f3608e.setLayoutParams(layoutParams);
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.amap.api.maps.SwipeDismissTouchListener.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SwipeDismissTouchListener.this.f3608e.setLayoutParams(layoutParams);
            }
        });
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = true;
        motionEvent.offsetLocation(this.f3617n, 0.0f);
        if (this.f3610g < 2) {
            this.f3610g = this.f3608e.getWidth();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f3611h = motionEvent.getRawX();
                this.f3612i = motionEvent.getRawY();
                if (!this.f3609f.canDismiss(this.f3615l)) {
                    return true;
                }
                this.f3618o = false;
                this.f3616m = VelocityTracker.obtain();
                this.f3616m.addMovement(motionEvent);
                return true;
            case 1:
                if (this.f3616m != null) {
                    float rawX = motionEvent.getRawX() - this.f3611h;
                    this.f3616m.addMovement(motionEvent);
                    this.f3616m.computeCurrentVelocity(1000);
                    float xVelocity = this.f3616m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.f3616m.getYVelocity());
                    if (Math.abs(rawX) > this.f3610g / 2 && this.f3613j) {
                        z = rawX > 0.0f;
                    } else if (this.f3605b > abs || abs > this.f3606c || abs2 >= abs || !this.f3613j) {
                        z = false;
                        z2 = false;
                    } else {
                        boolean z3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        if (this.f3616m.getXVelocity() <= 0.0f) {
                            z2 = false;
                        }
                        boolean z4 = z2;
                        z2 = z3;
                        z = z4;
                    }
                    if (z2) {
                        this.f3608e.animate().translationX(z ? this.f3610g : -this.f3610g).alpha(0.0f).setDuration(50L).setListener(new AnimatorListenerAdapter() { // from class: com.amap.api.maps.SwipeDismissTouchListener.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                SwipeDismissTouchListener.this.m17421a();
                            }
                        });
                    } else if (this.f3613j) {
                        this.f3608e.animate().translationX(0.0f).alpha(1.0f).setDuration(this.f3607d).setListener(null);
                    }
                    this.f3616m.recycle();
                    this.f3616m = null;
                    this.f3617n = 0.0f;
                    this.f3611h = 0.0f;
                    this.f3612i = 0.0f;
                    this.f3613j = false;
                    break;
                }
                break;
            case 2:
                if (this.f3616m != null) {
                    this.f3616m.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f3611h;
                    float rawY = motionEvent.getRawY() - this.f3612i;
                    if (Math.abs(rawX2) > this.f3604a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.f3613j = true;
                        this.f3614k = rawX2 > 0.0f ? this.f3604a : -this.f3604a;
                        this.f3608e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.f3618o) {
                            this.f3618o = true;
                            this.f3609f.onNotifySwipe();
                        }
                        if (Math.abs(rawX2) <= this.f3610g / 3) {
                            this.f3619p = false;
                        } else if (!this.f3619p) {
                            this.f3619p = true;
                            this.f3609f.onNotifySwipe();
                        }
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f3608e.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (this.f3613j) {
                        this.f3617n = rawX2;
                        this.f3608e.setTranslationX(rawX2 - this.f3614k);
                        this.f3608e.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((2.0f * Math.abs(rawX2)) / this.f3610g))));
                        return true;
                    }
                }
                break;
            case 3:
                if (this.f3616m != null) {
                    this.f3608e.animate().translationX(0.0f).alpha(1.0f).setDuration(this.f3607d).setListener(null);
                    this.f3616m.recycle();
                    this.f3616m = null;
                    this.f3617n = 0.0f;
                    this.f3611h = 0.0f;
                    this.f3612i = 0.0f;
                    this.f3613j = false;
                    break;
                }
                break;
        }
        return false;
    }
}
