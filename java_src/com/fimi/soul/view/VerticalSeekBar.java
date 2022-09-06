package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class VerticalSeekBar extends View {

    /* renamed from: d */
    private int f15695d;

    /* renamed from: a */
    private int f15692a = 1;

    /* renamed from: e */
    private float f15696e = 1.0f;

    /* renamed from: b */
    private Bitmap f15693b = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.gimbal_measure);

    /* renamed from: c */
    private Bitmap f15694c = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.gimbal_measure_bg);

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f15694c, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(this.f15693b, 0.0f, this.f15696e, (Paint) null);
        super.onDraw(canvas);
    }

    public void setScale(int i) {
        int i2 = 100;
        this.f15692a = i;
        this.f15695d = this.f15694c.getHeight() - this.f15693b.getHeight();
        if (this.f15692a < 1) {
            this.f15692a = 1;
            this.f15696e = 1.0f;
        } else {
            if (this.f15692a <= 100) {
                i2 = this.f15692a;
            }
            this.f15696e = (i2 * this.f15695d) / 100;
        }
        invalidate();
    }
}
