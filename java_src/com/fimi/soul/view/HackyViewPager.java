package com.fimi.soul.view;

import android.content.Context;
import android.support.p001v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class HackyViewPager extends ViewPager {

    /* renamed from: a */
    private static final String f15323a = "HackyViewPager";

    /* renamed from: b */
    private boolean f15324b = true;

    public HackyViewPager(Context context) {
        super(context);
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.p001v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException e) {
            Log.e(f15323a, "hacky viewpager error2");
            return false;
        } catch (IllegalArgumentException e2) {
            Log.e(f15323a, "hacky viewpager error1");
            return false;
        }
    }

    @Override // android.support.p001v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f15324b) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (!this.f15324b) {
            return;
        }
        super.scrollTo(i, i2);
    }

    public void setScrollble(boolean z) {
        this.f15324b = z;
    }
}
