package com.fimi.kernel.view.percent;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.fimi.kernel.view.percent.C2296a;
/* loaded from: classes.dex */
public class PercentLinearLayout extends LinearLayout {

    /* renamed from: a */
    private static final String f7654a = "PercentLinearLayout";

    /* renamed from: b */
    private C2296a f7655b = new C2296a(this);

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams implements C2296a.AbstractC2299b {

        /* renamed from: a */
        private C2296a.C2297a f7656a;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7656a = C2296a.m12646a(context, attributeSet);
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
            return this.f7656a;
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            C2296a.m12642a(this, typedArray, i, i2);
        }
    }

    public PercentLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int getScreenHeight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams mo21808generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7655b.m12649a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), View.MeasureSpec.getMode(i));
        Log.d(f7654a, View.MeasureSpec.toString(i2));
        if (mode == 0 && getParent() != null && (getParent() instanceof ScrollView)) {
            Context context = getContext();
            if (context instanceof Activity) {
                screenHeight = ((Activity) context).findViewById(16908290).getMeasuredHeight();
                Log.d(f7654a, "measuredHeight = " + screenHeight);
            } else {
                screenHeight = getScreenHeight();
                Log.d(f7654a, "scHeight = " + screenHeight);
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(screenHeight, mode);
        }
        this.f7655b.m12648a(makeMeasureSpec2, makeMeasureSpec);
        super.onMeasure(i, i2);
        if (this.f7655b.m12638b()) {
            super.onMeasure(i, i2);
        }
    }
}
