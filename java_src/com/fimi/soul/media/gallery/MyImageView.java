package com.fimi.soul.media.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class MyImageView extends ImageView {

    /* renamed from: a */
    private AbstractC2978a f11278a;

    /* renamed from: com.fimi.soul.media.gallery.MyImageView$a */
    /* loaded from: classes.dex */
    public interface AbstractC2978a {
        /* renamed from: a */
        void m9936a(int i, int i2);
    }

    public MyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f11278a != null) {
            this.f11278a.m9936a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setOnMeasureListener(AbstractC2978a abstractC2978a) {
        this.f11278a = abstractC2978a;
    }
}
