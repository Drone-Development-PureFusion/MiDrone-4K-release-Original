package com.fimi.soul.media.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
/* loaded from: classes.dex */
public class MyExpandableListView extends ExpandableListView {

    /* renamed from: a */
    private float f11275a;

    /* renamed from: b */
    private float f11276b;

    /* renamed from: c */
    private int f11277c;

    public MyExpandableListView(Context context) {
        super(context);
        m9937a();
    }

    public MyExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9937a();
    }

    public MyExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9937a();
    }

    /* renamed from: a */
    private void m9937a() {
        this.f11277c = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.f11275a = x;
                this.f11276b = y;
                break;
            case 2:
                int i = (int) (this.f11275a - x);
                if (Math.abs(i) > this.f11277c && Math.abs(((int) (this.f11276b - y)) / i) < 1) {
                    return true;
                }
                break;
        }
        return false;
    }
}
