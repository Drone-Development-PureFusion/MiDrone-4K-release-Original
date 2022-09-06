package p244m.framework.p247ui.widget.slidingmenu;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;
/* renamed from: m.framework.ui.widget.slidingmenu.a */
/* loaded from: classes2.dex */
public class C4996a extends HorizontalScrollView {

    /* renamed from: a */
    private static final int f21407a = 500;

    /* renamed from: b */
    private static final int f21408b = 230;

    /* renamed from: c */
    private float f21409c = 2.14748365E9f;

    /* renamed from: d */
    private SlidingMenu f21410d;

    /* renamed from: e */
    private int f21411e;

    /* renamed from: f */
    private VelocityTracker f21412f;

    public C4996a(SlidingMenu slidingMenu) {
        super(slidingMenu.getContext());
        this.f21410d = slidingMenu;
        this.f21411e = ViewConfiguration.get(slidingMenu.getContext()).getScaledMaximumFlingVelocity();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f21409c = motionEvent.getX();
                if (this.f21410d.m2351e() && this.f21409c > this.f21410d.getMenuWidth() && motionEvent.getY() > this.f21410d.getMenuConfig().f21422i) {
                    super.onInterceptTouchEvent(motionEvent);
                    return true;
                }
                break;
            case 1:
            case 3:
                this.f21409c = 2.14748365E9f;
                break;
            case 2:
                if (!this.f21410d.m2351e() && this.f21409c > this.f21410d.getShowMenuWidth()) {
                    super.onInterceptTouchEvent(motionEvent);
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f21410d.getMenuCover().setBackgroundColor(Color.argb((i * 230) / this.f21410d.getMenuWidth(), 0, 0, 0));
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f21412f == null) {
            this.f21412f = VelocityTracker.obtain();
        }
        this.f21412f.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.f21410d.m2351e() && this.f21409c < this.f21410d.getMenuWidth()) {
                    return false;
                }
                this.f21409c = 2.14748365E9f;
                this.f21412f.computeCurrentVelocity(1000, this.f21411e);
                float xVelocity = this.f21412f.getXVelocity();
                this.f21412f.recycle();
                this.f21412f = null;
                int scrollX = getScrollX();
                if (xVelocity - 500.0f > 0.0f) {
                    this.f21410d.m2357c();
                } else if (xVelocity + 500.0f < 0.0f) {
                    this.f21410d.m2354d();
                } else if (scrollX > this.f21410d.getMenuWidth() / 2) {
                    this.f21410d.m2354d();
                } else {
                    this.f21410d.m2357c();
                }
                return true;
            case 2:
            default:
                if (this.f21410d.m2351e() && this.f21409c < this.f21410d.getMenuWidth()) {
                    return false;
                }
                return super.onTouchEvent(motionEvent);
        }
    }
}
