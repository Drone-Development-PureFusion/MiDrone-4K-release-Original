package com.fimi.soul.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
/* loaded from: classes.dex */
public class GridV extends GridView {
    public GridV(Context context) {
        super(context);
    }

    public GridV(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GridV(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
