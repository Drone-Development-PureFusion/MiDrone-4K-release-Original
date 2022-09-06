package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class Vjampan extends View {

    /* renamed from: e */
    private Bitmap f15701e;

    /* renamed from: g */
    private int f15703g;

    /* renamed from: d */
    private int f15700d = 0;

    /* renamed from: h */
    private float f15704h = 1.0f;

    /* renamed from: c */
    float f15699c = getResources().getDisplayMetrics().density;

    /* renamed from: f */
    private Bitmap f15702f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.jampan);

    /* renamed from: a */
    int f15697a = this.f15702f.getHeight();

    /* renamed from: b */
    int f15698b = this.f15702f.getWidth();

    public Vjampan(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f15702f, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(-256);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(100);
        if (this.f15700d >= this.f15697a / 2) {
            canvas.drawRoundRect(new RectF(0.0f, this.f15697a - this.f15700d, this.f15698b, this.f15697a / 2), 20.0f, 20.0f, paint);
        } else if (this.f15700d >= 0 && this.f15700d < this.f15697a / 2) {
            canvas.drawRoundRect(new RectF(0.0f, this.f15697a / 2, this.f15698b, this.f15697a - this.f15700d), 20.0f, 20.0f, paint);
        }
        super.onDraw(canvas);
    }

    public void setScale(int i) {
        if (this.f15699c == 1.5d) {
            this.f15700d = i * 2;
        } else if (this.f15699c == 2.0f) {
            this.f15700d = i * 3;
        } else if (this.f15699c == 3.0f) {
            this.f15700d = (int) (i * 4.5d);
        }
        invalidate();
    }
}
