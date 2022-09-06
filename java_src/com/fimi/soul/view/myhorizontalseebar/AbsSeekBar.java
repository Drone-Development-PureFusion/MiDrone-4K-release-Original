package com.fimi.soul.view.myhorizontalseebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public abstract class AbsSeekBar extends ProgressBar {

    /* renamed from: q */
    private static final int f16313q = 255;

    /* renamed from: a */
    float f16314a;

    /* renamed from: n */
    private Drawable f16316n;

    /* renamed from: o */
    private int f16317o;

    /* renamed from: r */
    private float f16319r;

    /* renamed from: s */
    private int f16320s;

    /* renamed from: t */
    private float f16321t;

    /* renamed from: u */
    private boolean f16322u;

    /* renamed from: b */
    boolean f16315b = true;

    /* renamed from: p */
    private int f16318p = 1;

    public AbsSeekBar(Context context) {
        super(context);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.SeekBar, i, 0);
        setThumb(obtainStyledAttributes.getDrawable(0));
        setThumbOffset(obtainStyledAttributes.getDimensionPixelOffset(1, getThumbOffset()));
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C2300R.styleable.Theme, 0, 0);
        this.f16319r = obtainStyledAttributes2.getFloat(0, 0.5f);
        obtainStyledAttributes2.recycle();
        this.f16320s = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* renamed from: a */
    private void m6822a(int i, int i2) {
        Drawable currentDrawable = getCurrentDrawable();
        Drawable drawable = this.f16316n;
        int intrinsicHeight = drawable == null ? 0 : drawable.getIntrinsicHeight();
        int min = Math.min(this.f16338f, (i2 - this.f16344l) - this.f16345m);
        int max = getMax();
        float progress = max > 0 ? getProgress() / max : 0.0f;
        if (intrinsicHeight > min) {
            if (drawable != null) {
                m6821a(i, drawable, progress, 0);
            }
            int i3 = (intrinsicHeight - min) / 2;
            if (currentDrawable == null) {
                return;
            }
            currentDrawable.setBounds(0, i3, (i - this.f16343k) - this.f16342j, ((i2 - this.f16345m) - i3) - this.f16344l);
            return;
        }
        if (currentDrawable != null) {
            currentDrawable.setBounds(0, 0, (i - this.f16343k) - this.f16342j, (i2 - this.f16345m) - this.f16344l);
        }
        int i4 = (min - intrinsicHeight) / 2;
        if (drawable == null) {
            return;
        }
        m6821a(i, drawable, progress, i4);
    }

    /* renamed from: a */
    private void m6821a(int i, Drawable drawable, float f, int i2) {
        int i3;
        int i4 = (i - this.f16342j) - this.f16343k;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i5 = (int) (((i4 - intrinsicWidth) + (this.f16317o * 2)) * f);
        if (i2 == Integer.MIN_VALUE) {
            Rect bounds = drawable.getBounds();
            i2 = bounds.top;
            i3 = bounds.bottom;
        } else {
            i3 = i2 + intrinsicHeight;
        }
        drawable.setBounds(i5, i2, intrinsicWidth + i5, i3);
    }

    /* renamed from: a */
    private void m6820a(MotionEvent motionEvent) {
        float f;
        float f2 = 0.0f;
        int width = getWidth();
        int i = (width - this.f16342j) - this.f16343k;
        int x = (int) motionEvent.getX();
        if (x < this.f16342j) {
            f = 0.0f;
        } else if (x > width - this.f16343k) {
            f = 1.0f;
        } else {
            f = (x - this.f16342j) / i;
            f2 = this.f16314a;
        }
        a((int) (f2 + (f * getMax())), true);
    }

    /* renamed from: g */
    private void m6818g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6789a() {
        this.f16322u = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar
    /* renamed from: a */
    public void mo6788a(float f, boolean z) {
        super.mo6788a(f, z);
        Drawable drawable = this.f16316n;
        if (drawable != null) {
            m6821a(getWidth(), drawable, f, Integer.MIN_VALUE);
            invalidate();
        }
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar
    /* renamed from: a */
    public void mo6816a(int i) {
        super.mo6816a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6787b() {
        this.f16322u = false;
    }

    /* renamed from: c */
    void m6819c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setAlpha(isEnabled() ? 255 : (int) (255.0f * this.f16319r));
        }
        if (this.f16316n == null || !this.f16316n.isStateful()) {
            return;
        }
        this.f16316n.setState(getDrawableState());
    }

    public int getKeyProgressIncrement() {
        return this.f16318p;
    }

    public Drawable getThumb() {
        return this.f16316n;
    }

    public int getThumbOffset() {
        return this.f16317o;
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f16316n != null) {
            this.f16316n.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f16316n != null) {
            canvas.save();
            canvas.translate(this.f16342j - this.f16317o, this.f16344l);
            this.f16316n.draw(canvas);
            canvas.restore();
        }
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsSeekBar.class.getName());
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSeekBar.class.getName());
        if (isEnabled()) {
            int progress = getProgress();
            if (progress > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (progress >= getMax()) {
                return;
            }
            accessibilityNodeInfo.addAction(4096);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            int progress = getProgress();
            switch (i) {
                case 21:
                    if (progress > 0) {
                        a(progress - this.f16318p, true);
                        m6819c();
                        return true;
                    }
                    break;
                case 22:
                    if (progress < getMax()) {
                        a(progress + this.f16318p, true);
                        m6819c();
                        return true;
                    }
                    break;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        synchronized (this) {
            Drawable currentDrawable = getCurrentDrawable();
            int intrinsicHeight = this.f16316n == null ? 0 : this.f16316n.getIntrinsicHeight();
            if (currentDrawable != null) {
                i3 = Math.max(this.f16335c, Math.min(this.f16336d, currentDrawable.getIntrinsicWidth()));
                i4 = Math.max(intrinsicHeight, Math.max(this.f16337e, Math.min(this.f16338f, currentDrawable.getIntrinsicHeight())));
            } else {
                i3 = 0;
            }
            setMeasuredDimension(resolveSizeAndState(i3 + this.f16342j + this.f16343k, i, 0), resolveSizeAndState(i4 + this.f16344l + this.f16345m, i2, 0));
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        int max = getMax();
        float progress = max > 0 ? getProgress() / max : 0.0f;
        Drawable drawable = this.f16316n;
        if (drawable != null) {
            m6821a(getWidth(), drawable, progress, Integer.MIN_VALUE);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m6822a(i, i2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f16315b || !isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                setPressed(true);
                if (this.f16316n != null) {
                    invalidate(this.f16316n.getBounds());
                }
                mo6789a();
                m6820a(motionEvent);
                m6818g();
                return true;
            case 1:
                if (this.f16322u) {
                    m6820a(motionEvent);
                    mo6787b();
                    setPressed(false);
                } else {
                    mo6789a();
                    m6820a(motionEvent);
                    mo6787b();
                }
                invalidate();
                return true;
            case 2:
                if (this.f16322u) {
                    m6820a(motionEvent);
                    return true;
                } else if (Math.abs(motionEvent.getX() - this.f16321t) <= this.f16320s) {
                    return true;
                } else {
                    setPressed(true);
                    if (this.f16316n != null) {
                        invalidate(this.f16316n.getBounds());
                    }
                    mo6789a();
                    m6820a(motionEvent);
                    m6818g();
                    return true;
                }
            case 3:
                if (this.f16322u) {
                    mo6787b();
                    setPressed(false);
                }
                invalidate();
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        int progress = getProgress();
        int max = Math.max(1, Math.round(getMax() / 5.0f));
        switch (i) {
            case 4096:
                if (progress >= getMax()) {
                    return false;
                }
                a(progress + max, true);
                m6819c();
                return true;
            case 8192:
                if (progress <= 0) {
                    return false;
                }
                a(progress - max, true);
                m6819c();
                return true;
            default:
                return false;
        }
    }

    public void setKeyProgressIncrement(int i) {
        if (i < 0) {
            i = -i;
        }
        this.f16318p = i;
    }

    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar
    public synchronized void setMax(int i) {
        super.setMax(i);
        if (this.f16318p == 0 || getMax() / this.f16318p > 20) {
            setKeyProgressIncrement(Math.max(1, Math.round(getMax() / 20.0f)));
        }
    }

    public void setThumb(Drawable drawable) {
        boolean z;
        if (this.f16316n == null || drawable == this.f16316n) {
            z = false;
        } else {
            this.f16316n.setCallback(null);
            z = true;
        }
        if (drawable != null) {
            drawable.setCallback(this);
            this.f16317o = drawable.getIntrinsicWidth() / 2;
            if (z && (drawable.getIntrinsicWidth() != this.f16316n.getIntrinsicWidth() || drawable.getIntrinsicHeight() != this.f16316n.getIntrinsicHeight())) {
                requestLayout();
            }
        }
        this.f16316n = drawable;
        invalidate();
        if (z) {
            m6822a(getWidth(), getHeight());
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public void setThumbOffset(int i) {
        this.f16317o = i;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fimi.soul.view.myhorizontalseebar.ProgressBar, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f16316n || super.verifyDrawable(drawable);
    }
}
