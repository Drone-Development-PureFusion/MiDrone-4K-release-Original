package com.fimi.kernel.view.percent;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fimi.kernel.view.percent.C2296a;
/* loaded from: classes.dex */
public class PercentRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    private final C2296a f7657a = new C2296a(this);

    /* loaded from: classes.dex */
    public static class LayoutParams extends RelativeLayout.LayoutParams implements C2296a.AbstractC2299b {

        /* renamed from: a */
        private C2296a.C2297a f7658a;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7658a = C2296a.m12646a(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // com.fimi.kernel.view.percent.C2296a.AbstractC2299b
        /* renamed from: a */
        public C2296a.C2297a mo12626a() {
            return this.f7658a;
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            C2296a.m12642a(this, typedArray, i, i2);
        }
    }

    public PercentRelativeLayout(Context context) {
        super(context);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PercentRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams mo21809generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7657a.m12649a();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.f7657a.m12648a(i, i2);
        super.onMeasure(i, i2);
        if (this.f7657a.m12638b()) {
            super.onMeasure(i, i2);
        }
    }
}
