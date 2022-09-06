package p244m.framework.p247ui.widget.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import p244m.framework.p246b.C4955f;
/* renamed from: m.framework.ui.widget.viewpager.ViewPagerClassic */
/* loaded from: classes2.dex */
public class ViewPagerClassic extends ViewGroup {

    /* renamed from: a */
    private static final int f21432a = 500;

    /* renamed from: g */
    private static final int f21433g = 0;

    /* renamed from: h */
    private static final int f21434h = 1;

    /* renamed from: b */
    private int f21435b;

    /* renamed from: c */
    private Scroller f21436c;

    /* renamed from: d */
    private VelocityTracker f21437d;

    /* renamed from: e */
    private float f21438e;

    /* renamed from: f */
    private float f21439f;

    /* renamed from: i */
    private int f21440i;

    /* renamed from: j */
    private int f21441j;

    /* renamed from: k */
    private int f21442k;

    /* renamed from: l */
    private AbstractC5002a f21443l;

    public ViewPagerClassic(Context context) {
        this(context, null);
    }

    public ViewPagerClassic(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerClassic(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21440i = 0;
        m2320a(context);
    }

    /* renamed from: a */
    private void m2321a(int i, boolean z) {
        boolean z2 = i != this.f21435b;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && z2 && focusedChild == getChildAt(this.f21435b)) {
            focusedChild.clearFocus();
        }
        int width = (getWidth() * i) - getScrollX();
        this.f21436c.startScroll(getScrollX(), 0, width, 0, z ? 0 : Math.abs(width) / 2);
        invalidate();
    }

    /* renamed from: a */
    private void m2320a(Context context) {
        this.f21436c = new Scroller(getContext(), new Interpolator() { // from class: m.framework.ui.widget.viewpager.ViewPagerClassic.1

            /* renamed from: a */
            float[] f21444a = {0.0f, 0.0157073f, 0.0314108f, 0.0471065f, 0.0627905f, 0.0784591f, 0.0941083f, 0.109734f, 0.125333f, 0.140901f, 0.156434f, 0.171929f, 0.187381f, 0.202787f, 0.218143f, 0.233445f, 0.24869f, 0.263873f, 0.278991f, 0.29404f, 0.309017f, 0.323917f, 0.338738f, 0.353475f, 0.368125f, 0.382683f, 0.397148f, 0.411514f, 0.425779f, 0.439939f, 0.45399f, 0.46793f, 0.481754f, 0.495459f, 0.509041f, 0.522499f, 0.535827f, 0.549023f, 0.562083f, 0.575005f, 0.587785f, 0.60042f, 0.612907f, 0.625243f, 0.637424f, 0.649448f, 0.661312f, 0.673013f, 0.684547f, 0.695913f, 0.707107f, 0.718126f, 0.728969f, 0.739631f, 0.750111f, 0.760406f, 0.770513f, 0.78043f, 0.790155f, 0.799685f, 0.809017f, 0.81815f, 0.827081f, 0.835807f, 0.844328f, 0.85264f, 0.860742f, 0.868632f, 0.876307f, 0.883766f, 0.891007f, 0.898028f, 0.904827f, 0.911403f, 0.917755f, 0.92388f, 0.929776f, 0.935444f, 0.940881f, 0.946085f, 0.951057f, 0.955793f, 0.960294f, 0.964557f, 0.968583f, 0.97237f, 0.975917f, 0.979223f, 0.982287f, 0.985109f, 0.987688f, 0.990024f, 0.992115f, 0.993961f, 0.995562f, 0.996917f, 0.998027f, 0.99889f, 0.999507f, 0.999877f, 1.0f};

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return this.f21444a[(int) (100.0f * f)];
            }
        });
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f21441j = viewConfiguration.getScaledTouchSlop();
        this.f21442k = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: a */
    private void m2319a(MotionEvent motionEvent) {
        boolean z = false;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int abs = (int) Math.abs(x - this.f21438e);
        int abs2 = (int) Math.abs(y - this.f21439f);
        boolean z2 = abs > this.f21441j;
        if (abs2 > this.f21441j) {
            z = true;
        }
        if ((z2 || z) && z2) {
            this.f21440i = 1;
            this.f21438e = x;
        }
    }

    /* renamed from: b */
    private void m2317b(MotionEvent motionEvent) {
        int right;
        if (this.f21443l == null) {
            return;
        }
        float x = motionEvent.getX();
        int i = (int) (this.f21438e - x);
        this.f21438e = x;
        if (i < 0) {
            if (getScrollX() <= 0) {
                return;
            }
            scrollBy(Math.max(-getScrollX(), i), 0);
        } else if (i <= 0 || getChildCount() == 0 || (right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth()) <= 0) {
        } else {
            scrollBy(Math.min(right, i), 0);
        }
    }

    /* renamed from: a */
    public void m2323a() {
        if (this.f21443l != null && this.f21435b > 0 && this.f21436c.isFinished()) {
            m2322a(this.f21435b - 1);
        }
    }

    /* renamed from: a */
    public void m2322a(int i) {
        m2321a(i, false);
    }

    /* renamed from: b */
    public void m2318b() {
        if (this.f21443l != null && this.f21435b < getChildCount() - 1 && this.f21436c.isFinished()) {
            m2322a(this.f21435b + 1);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f21443l == null) {
            return;
        }
        if (this.f21436c.computeScrollOffset()) {
            scrollTo(this.f21436c.getCurrX(), this.f21436c.getCurrY());
            postInvalidate();
            return;
        }
        int i = this.f21435b;
        int currX = this.f21436c.getCurrX();
        int width = getWidth();
        int i2 = currX / width;
        if (currX % width > width / 2) {
            i2++;
        }
        this.f21435b = Math.max(0, Math.min(i2, getChildCount() - 1));
        if (i == this.f21435b || this.f21443l == null) {
            return;
        }
        this.f21443l.m2315a(this.f21435b, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.f21443l == null || getChildCount() <= 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        if (this.f21435b > 0) {
            drawChild(canvas, getChildAt(this.f21435b - 1), drawingTime);
        }
        drawChild(canvas, getChildAt(this.f21435b), drawingTime);
        if (this.f21435b >= getChildCount() - 1) {
            return;
        }
        drawChild(canvas, getChildAt(this.f21435b + 1), drawingTime);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        if (this.f21443l == null) {
            return super.dispatchUnhandledMove(view, i);
        }
        if (i == 17) {
            if (this.f21435b > 0) {
                m2322a(this.f21435b - 1);
                return true;
            }
        } else if (i == 66 && this.f21435b < getChildCount() - 1) {
            m2322a(this.f21435b + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    public int getCurrentScreen() {
        return this.f21435b;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 2 || this.f21440i == 0) {
            if (this.f21437d == null) {
                this.f21437d = VelocityTracker.obtain();
            }
            this.f21437d.addMovement(motionEvent);
            switch (action) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.f21438e = x;
                    this.f21439f = y;
                    this.f21440i = this.f21436c.isFinished() ? 0 : 1;
                    break;
                case 1:
                case 3:
                    if (this.f21437d != null) {
                        this.f21437d.recycle();
                        this.f21437d = null;
                    }
                    this.f21440i = 0;
                    break;
                case 2:
                    m2319a(motionEvent);
                    break;
            }
            return this.f21440i != 0;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f21443l == null) {
            return;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                childAt.layout(i7, 0, i7 + i5, i6);
                i7 += i5;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f21443l == null) {
            super.onMeasure(i, i2);
            return;
        }
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(C4955f.m2488a(getContext()), 1073741824);
        int i3 = 0;
        int i4 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            childAt.measure(makeMeasureSpec, 0);
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight <= i4) {
                measuredHeight = i4;
            }
            i3++;
            i4 = measuredHeight;
        }
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
        for (int i5 = 0; i5 < childCount; i5++) {
            getChildAt(i5).measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f21443l == null) {
            return false;
        }
        if (this.f21437d == null) {
            this.f21437d = VelocityTracker.obtain();
        }
        this.f21437d.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case 0:
                if (this.f21440i != 0) {
                    if (!this.f21436c.isFinished()) {
                        this.f21436c.abortAnimation();
                    }
                    this.f21438e = x;
                    break;
                }
                break;
            case 1:
                if (this.f21440i == 1) {
                    VelocityTracker velocityTracker = this.f21437d;
                    velocityTracker.computeCurrentVelocity(1000, this.f21442k);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (xVelocity > 500 && this.f21435b > 0) {
                        m2322a(this.f21435b - 1);
                    } else if (xVelocity >= -500 || this.f21435b >= getChildCount() - 1) {
                        int width = getWidth();
                        m2322a((getScrollX() + (width / 2)) / width);
                    } else {
                        m2322a(this.f21435b + 1);
                    }
                    if (this.f21437d != null) {
                        this.f21437d.recycle();
                        this.f21437d = null;
                    }
                }
                this.f21440i = 0;
                break;
            case 2:
                if (this.f21440i != 1) {
                    if (onInterceptTouchEvent(motionEvent) && this.f21440i == 1) {
                        m2317b(motionEvent);
                        break;
                    }
                } else {
                    m2317b(motionEvent);
                    break;
                }
                break;
            case 3:
                this.f21440i = 0;
                break;
        }
        return true;
    }

    public void setAdapter(AbstractC5002a abstractC5002a) {
        this.f21443l = abstractC5002a;
        removeAllViews();
        this.f21435b = 0;
        if (this.f21443l == null) {
            return;
        }
        int m2316a = abstractC5002a.m2316a();
        for (int i = 0; i < m2316a; i++) {
            addView(abstractC5002a.m2314a(i, this));
        }
    }

    public void setCurrentScreen(int i) {
        if (this.f21443l == null) {
            return;
        }
        if (!this.f21436c.isFinished()) {
            this.f21436c.abortAnimation();
        }
        int i2 = this.f21435b;
        this.f21435b = Math.max(0, Math.min(i, getChildCount()));
        this.f21443l.m2315a(this.f21435b, i2);
        int m2488a = C4955f.m2488a(getContext()) * this.f21435b;
        this.f21436c.startScroll(0, 0, m2488a, 0);
        scrollTo(m2488a, 0);
    }
}
