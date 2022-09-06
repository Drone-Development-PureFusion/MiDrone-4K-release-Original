package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class BatteryView extends View {

    /* renamed from: a */
    Paint f15196a;

    /* renamed from: b */
    Paint f15197b;

    /* renamed from: c */
    Rect f15198c;

    /* renamed from: d */
    double f15199d;

    /* renamed from: e */
    int f15200e;

    /* renamed from: f */
    double f15201f;

    /* renamed from: g */
    double f15202g;

    /* renamed from: h */
    int f15203h;

    /* renamed from: i */
    int f15204i;

    /* renamed from: j */
    int f15205j;

    /* renamed from: k */
    int f15206k;

    /* renamed from: l */
    private int f15207l;

    /* renamed from: m */
    private float f15208m;

    public BatteryView(Context context) {
        super(context);
        this.f15207l = 100;
        this.f15196a = null;
        this.f15197b = null;
        this.f15198c = null;
        this.f15199d = 100.0d;
    }

    public BatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15207l = 100;
        this.f15196a = null;
        this.f15197b = null;
        this.f15198c = null;
        this.f15199d = 100.0d;
        this.f15208m = getContext().getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    public void m7357a(int i, double d) {
        this.f15207l = i;
        if (this.f15199d > 0.0d) {
            this.f15199d = d;
        }
        if (this.f15207l < 0) {
            this.f15207l = 0;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (float) (this.f15207l / this.f15199d);
        float f2 = f * 360.0f;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C2300R.color.battery));
        paint.setAntiAlias(true);
        canvas.drawCircle(this.f15208m * 12.0f, this.f15208m * 12.0f, this.f15208m * 12.0f, paint);
        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(C2300R.color.black));
        paint2.setAntiAlias(true);
        canvas.drawCircle(this.f15208m * 12.0f, this.f15208m * 12.0f, 11.0f * this.f15208m, paint2);
        Paint paint3 = new Paint();
        if (f <= 0.25d) {
            paint3.setColor(getResources().getColor(C2300R.color.battery_red));
        } else if (f > 0.25d && f <= 0.5d) {
            paint3.setColor(getResources().getColor(C2300R.color.battery_orange));
        } else if (f <= 0.5d || f > 0.75d) {
            paint3.setColor(getResources().getColor(C2300R.color.battery_green));
        } else {
            paint3.setColor(getResources().getColor(C2300R.color.battery_yellow));
        }
        paint3.setAntiAlias(true);
        canvas.drawArc(new RectF(this.f15208m * 3.0f, this.f15208m * 3.0f, 21.0f * this.f15208m, 21.0f * this.f15208m), 270.0f - f2, f2, true, paint3);
    }
}
