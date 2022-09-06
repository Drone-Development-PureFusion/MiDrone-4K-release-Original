package com.fimi.soul.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.fimi.soul.p167b.C2331f;
/* loaded from: classes.dex */
public class MyGridView extends GridView {

    /* renamed from: a */
    private C2331f f15413a;

    public MyGridView(Context context) {
        super(context);
    }

    public MyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f15413a != null) {
            this.f15413a.m12573a();
        }
        super.onMeasure(i, i2);
    }

    public void setAdapter(C2331f c2331f) {
        this.f15413a = c2331f;
        super.setAdapter((ListAdapter) c2331f);
    }
}
