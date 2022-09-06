package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class ImageLoadingView extends ImageView {

    /* renamed from: a */
    private Paint f15370a;

    /* renamed from: b */
    private float f15371b;

    public ImageLoadingView(Context context) {
        this(context, null);
        m7273c();
    }

    public ImageLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m7273c();
    }

    public ImageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7273c();
    }

    /* renamed from: c */
    private void m7273c() {
        setBackgroundResource(C2300R.C2301drawable.download_circle_bg);
        this.f15370a = new Paint();
        this.f15370a.setAntiAlias(true);
        this.f15370a.setStrokeWidth(2.0f);
        this.f15370a.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void m7275a() {
        this.f15370a.setColor(getResources().getColor(C2300R.color.loading_blue));
        invalidate();
    }

    /* renamed from: b */
    public void m7274b() {
        this.f15370a.setColor(getResources().getColor(C2300R.color.loading_hot));
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(new RectF(2.0f, 2.0f, getWidth() - 2, getWidth() - 2), -90.0f, this.f15371b, false, this.f15370a);
    }

    public void setPaintColor(int i) {
        this.f15370a.setColor(i);
    }

    public void setSweepAngle(float f) {
        this.f15371b = 3.6f * f;
        invalidate();
    }
}
