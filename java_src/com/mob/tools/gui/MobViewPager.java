package com.mob.tools.gui;

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
/* loaded from: classes.dex */
public class MobViewPager extends ViewGroup {
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private float lastMotionX;
    private float lastMotionY;
    private int maximumVelocity;
    private View nextPage;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private int touchSlop;
    private int touchState;
    private VelocityTracker velocityTracker;

    public MobViewPager(Context context) {
        this(context, null);
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.touchState = 0;
        init(context);
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int abs = (int) Math.abs(x - this.lastMotionX);
        if (((int) Math.abs(y - this.lastMotionY)) >= abs || abs <= this.touchSlop) {
            return;
        }
        this.touchState = 1;
        this.lastMotionX = x;
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        int right;
        if (this.adapter == null) {
            return;
        }
        float x = motionEvent.getX();
        int i = (int) (this.lastMotionX - x);
        this.lastMotionX = x;
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

    private void init(Context context) {
        this.scroller = new Scroller(getContext(), new Interpolator() { // from class: com.mob.tools.gui.MobViewPager.1
            float[] values = {0.0f, 0.0157073f, 0.0314108f, 0.0471065f, 0.0627905f, 0.0784591f, 0.0941083f, 0.109734f, 0.125333f, 0.140901f, 0.156434f, 0.171929f, 0.187381f, 0.202787f, 0.218143f, 0.233445f, 0.24869f, 0.263873f, 0.278991f, 0.29404f, 0.309017f, 0.323917f, 0.338738f, 0.353475f, 0.368125f, 0.382683f, 0.397148f, 0.411514f, 0.425779f, 0.439939f, 0.45399f, 0.46793f, 0.481754f, 0.495459f, 0.509041f, 0.522499f, 0.535827f, 0.549023f, 0.562083f, 0.575005f, 0.587785f, 0.60042f, 0.612907f, 0.625243f, 0.637424f, 0.649448f, 0.661312f, 0.673013f, 0.684547f, 0.695913f, 0.707107f, 0.718126f, 0.728969f, 0.739631f, 0.750111f, 0.760406f, 0.770513f, 0.78043f, 0.790155f, 0.799685f, 0.809017f, 0.81815f, 0.827081f, 0.835807f, 0.844328f, 0.85264f, 0.860742f, 0.868632f, 0.876307f, 0.883766f, 0.891007f, 0.898028f, 0.904827f, 0.911403f, 0.917755f, 0.92388f, 0.929776f, 0.935444f, 0.940881f, 0.946085f, 0.951057f, 0.955793f, 0.960294f, 0.964557f, 0.968583f, 0.97237f, 0.975917f, 0.979223f, 0.982287f, 0.985109f, 0.987688f, 0.990024f, 0.992115f, 0.993961f, 0.995562f, 0.996917f, 0.998027f, 0.99889f, 0.999507f, 0.999877f, 1.0f};

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return this.values[(int) (100.0f * f)];
            }
        });
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void onScreenChange(int i) {
        if (this.adapter != null) {
            if (this.currentScreen > i) {
                for (int i2 = 0; i2 < this.currentScreen - i; i2++) {
                    int i3 = i + i2 + 1;
                    View view = this.previousPage;
                    this.previousPage = this.currentPage;
                    this.currentPage = this.nextPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(0);
                    }
                    if (i3 < this.screenCount - 1) {
                        this.nextPage = this.adapter.getView(i3 + 1, view, this);
                        addView(this.nextPage);
                    } else {
                        this.nextPage = view;
                    }
                }
            } else {
                for (int i4 = 0; i4 < i - this.currentScreen; i4++) {
                    int i5 = (i - i4) - 1;
                    View view2 = this.nextPage;
                    this.nextPage = this.currentPage;
                    this.currentPage = this.previousPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(2);
                    }
                    if (i5 > 0) {
                        this.previousPage = this.adapter.getView(i5 - 1, view2, this);
                        addView(this.previousPage, 0);
                    } else {
                        this.previousPage = view2;
                    }
                }
            }
            this.adapter.onScreenChange(this.currentScreen, i);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            postInvalidate();
            return;
        }
        int i = this.currentScreen;
        int currX = this.scroller.getCurrX();
        int width = getWidth();
        int i2 = currX / width;
        if (currX % width > width / 2) {
            i2++;
        }
        this.currentScreen = Math.max(0, Math.min(i2, this.screenCount - 1));
        if (i == this.currentScreen) {
            return;
        }
        onScreenChange(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        if (this.currentScreen > 0) {
            drawChild(canvas, this.previousPage, drawingTime);
        }
        drawChild(canvas, this.currentPage, drawingTime);
        if (this.currentScreen >= this.screenCount - 1) {
            return;
        }
        drawChild(canvas, this.nextPage, drawingTime);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        if (this.adapter == null) {
            return super.dispatchUnhandledMove(view, i);
        }
        if (i == 17) {
            if (this.currentScreen > 0) {
                scrollToScreen(this.currentScreen - 1, false);
                return true;
            }
        } else if (i == 66 && this.currentScreen < this.screenCount - 1) {
            scrollToScreen(this.currentScreen + 1, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 2 || this.touchState == 0) {
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            switch (action) {
                case 0:
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    this.lastMotionX = x;
                    this.lastMotionY = y;
                    this.touchState = this.scroller.isFinished() ? 0 : 1;
                    break;
                case 1:
                case 3:
                    if (this.velocityTracker != null) {
                        this.velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                    this.touchState = 0;
                    break;
                case 2:
                    handleInterceptMove(motionEvent);
                    break;
            }
            return this.touchState != 0;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = this.currentScreen * i5;
        if (this.currentScreen > 0) {
            this.previousPage.layout(i7 - i5, 0, i7, i6);
        }
        this.currentPage.layout(i7, 0, i7 + i5, i6);
        if (this.currentScreen >= this.screenCount - 1) {
            return;
        }
        this.nextPage.layout(i7 + i5, 0, i5 + i7 + i5, i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(makeMeasureSpec, makeMeasureSpec2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.adapter == null) {
            return false;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        switch (action) {
            case 0:
                if (this.touchState != 0) {
                    if (!this.scroller.isFinished()) {
                        this.scroller.abortAnimation();
                    }
                    this.lastMotionX = x;
                    break;
                }
                break;
            case 1:
                if (this.touchState == 1) {
                    VelocityTracker velocityTracker = this.velocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (xVelocity > 500 && this.currentScreen > 0) {
                        scrollToScreen(this.currentScreen - 1, false);
                    } else if (xVelocity >= -500 || this.currentScreen >= this.screenCount - 1) {
                        int width = getWidth();
                        scrollToScreen((getScrollX() + (width / 2)) / width, false);
                    } else {
                        scrollToScreen(this.currentScreen + 1, false);
                    }
                    if (this.velocityTracker != null) {
                        this.velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                this.touchState = 0;
                break;
            case 2:
                if (this.touchState != 1) {
                    if (onInterceptTouchEvent(motionEvent) && this.touchState == 1) {
                        handleScrollMove(motionEvent);
                        break;
                    }
                } else {
                    handleScrollMove(motionEvent);
                    break;
                }
                break;
            case 3:
                this.touchState = 0;
                break;
        }
        return true;
    }

    public void scrollLeft(boolean z) {
        if (this.currentScreen > 0) {
            scrollToScreen(this.currentScreen - 1, z);
        }
    }

    public void scrollRight(boolean z) {
        if (this.currentScreen < this.screenCount - 1) {
            scrollToScreen(this.currentScreen + 1, z);
        }
    }

    public void scrollToScreen(int i, boolean z) {
        if (this.currentPage != null && getFocusedChild() == this.currentPage) {
            this.currentPage.clearFocus();
        }
        int width = (getWidth() * i) - getScrollX();
        this.scroller.abortAnimation();
        this.scroller.startScroll(getScrollX(), 0, width, 0, z ? 0 : Math.abs(getWidth()) / 2);
        invalidate();
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        if (this.adapter != null) {
            this.adapter.setMobViewPager(null);
        }
        this.adapter = viewPagerAdapter;
        if (this.adapter != null) {
            this.adapter.setMobViewPager(this);
        }
        if (viewPagerAdapter == null) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        this.screenCount = viewPagerAdapter.getCount();
        if (this.screenCount <= 0) {
            this.currentScreen = 0;
            removeAllViews();
        } else if (this.screenCount <= this.currentScreen) {
            scrollToScreen(this.screenCount - 1, true);
        } else {
            removeAllViews();
            if (this.currentScreen > 0) {
                this.previousPage = viewPagerAdapter.getView(this.currentScreen - 1, this.previousPage, this);
                addView(this.previousPage);
            }
            this.currentPage = viewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
            addView(this.currentPage);
            if (this.currentScreen >= this.screenCount - 1) {
                return;
            }
            this.nextPage = viewPagerAdapter.getView(this.currentScreen + 1, this.nextPage, this);
            addView(this.nextPage);
        }
    }
}
