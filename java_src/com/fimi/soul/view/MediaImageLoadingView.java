package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class MediaImageLoadingView extends View {

    /* renamed from: a */
    private Paint f15382a;

    /* renamed from: b */
    private float f15383b;

    public MediaImageLoadingView(Context context) {
        this(context, null);
        m7268c();
    }

    public MediaImageLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m7268c();
    }

    public MediaImageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7268c();
    }

    /* renamed from: c */
    private void m7268c() {
        setBackgroundResource(C2300R.C2301drawable.download_circle_bg);
        this.f15382a = new Paint();
        this.f15382a.setAntiAlias(true);
        this.f15382a.setStrokeWidth(2.0f);
        this.f15382a.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void m7270a() {
        this.f15382a.setColor(getResources().getColor(C2300R.color.loading_blue));
        invalidate();
    }

    /* renamed from: b */
    public void m7269b() {
        this.f15382a.setColor(getResources().getColor(C2300R.color.loading_hot));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(new RectF(2.0f, 2.0f, getWidth() - 2, getWidth() - 2), -90.0f, this.f15383b, false, this.f15382a);
    }

    public void setPaintColor(int i) {
        this.f15382a.setColor(i);
    }

    public void setSweepAngle(float f) {
        this.f15383b = 3.6f * f;
        invalidate();
    }
}
