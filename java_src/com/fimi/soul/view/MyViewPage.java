package com.fimi.soul.view;

import android.content.Context;
import android.graphics.PointF;
import android.support.p001v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes.dex */
public class MyViewPage extends ViewPager {

    /* renamed from: a */
    PointF f15417a = new PointF();

    /* renamed from: b */
    PointF f15418b = new PointF();

    /* renamed from: c */
    private float f15419c;

    public MyViewPage(Context context) {
        super(context);
    }

    public MyViewPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.p001v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        System.out.println("MyViewPage2 onInterceptTouchEvent");
        return true;
    }

    @Override // android.support.p001v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f15418b.x = motionEvent.getX();
        this.f15418b.y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.f15417a.x = motionEvent.getX();
            this.f15417a.y = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 2) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (motionEvent.getAction() == 1 && this.f15417a.x == this.f15418b.x && this.f15417a.y == this.f15418b.y) {
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
