package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class StrokeTextView extends TextView {

    /* renamed from: a */
    private TextView f15495a;

    public StrokeTextView(Context context) {
        super(context);
        this.f15495a = null;
        this.f15495a = new TextView(context);
        C3658ar.m7612a(context.getAssets(), this.f15495a, this);
        m7255a();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15495a = null;
        this.f15495a = new TextView(context, attributeSet);
        C3658ar.m7612a(context.getAssets(), this.f15495a, this);
        m7255a();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15495a = null;
        this.f15495a = new TextView(context, attributeSet, i);
        C3658ar.m7612a(context.getAssets(), this.f15495a, this);
        m7255a();
    }

    /* renamed from: a */
    public void m7255a() {
        TextPaint paint = this.f15495a.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.STROKE);
        this.f15495a.setTextColor(1275068416);
        this.f15495a.setGravity(getGravity());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f15495a.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f15495a.layout(i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        CharSequence text = this.f15495a.getText();
        if (text == null || !text.equals(getText())) {
            this.f15495a.setText(getText());
            postInvalidate();
        }
        super.onMeasure(i, i2);
        this.f15495a.measure(i, i2);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f15495a.setLayoutParams(layoutParams);
    }
}
