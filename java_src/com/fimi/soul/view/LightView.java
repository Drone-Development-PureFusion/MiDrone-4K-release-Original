package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class LightView extends View {

    /* renamed from: b */
    private Paint f15376b;

    /* renamed from: c */
    private Paint f15377c;

    /* renamed from: f */
    private Context f15380f;

    /* renamed from: g */
    private Bitmap f15381g;

    /* renamed from: d */
    private int f15378d = 0;

    /* renamed from: e */
    private int f15379e = 0;

    /* renamed from: a */
    Typeface f15375a = null;

    public LightView(Context context) {
        super(context);
        this.f15380f = context;
        m7271a();
    }

    public LightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15380f = context;
        m7271a();
    }

    /* renamed from: a */
    void m7271a() {
        this.f15376b = new Paint();
        this.f15376b.setColor(-1);
        this.f15376b.setAlpha(80);
        this.f15376b.setStrokeWidth(3.0f);
        this.f15376b.setStyle(Paint.Style.FILL);
        this.f15376b.setAntiAlias(true);
        this.f15376b.setTextSize(25.0f);
        this.f15377c = new Paint();
        this.f15377c.setColor(getResources().getColor(C2300R.color.changebetery));
        this.f15377c.setStrokeWidth(3.0f);
        this.f15377c.setTextSize(25.0f);
        this.f15377c.setAntiAlias(true);
        this.f15377c.setStyle(Paint.Style.FILL);
        if (this.f15375a == null) {
            this.f15375a = Typeface.createFromAsset(this.f15380f.getAssets(), "DIN Alternate Bold.ttf");
        }
        this.f15377c.setTypeface(this.f15375a);
        this.f15376b.setTypeface(this.f15375a);
        this.f15381g = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.icon_brightness_circle);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float dimension = this.f15380f.getResources().getDimension(C2300R.dimen.dp50);
        float width = (getWidth() - this.f15380f.getResources().getDimension(C2300R.dimen.dp100)) / 100.0f;
        canvas.drawLine(this.f15380f.getResources().getDimension(C2300R.dimen.dp50), this.f15380f.getResources().getDimension(C2300R.dimen.dp28) + getY(), getWidth() - this.f15380f.getResources().getDimension(C2300R.dimen.dp50), this.f15380f.getResources().getDimension(C2300R.dimen.dp28) + getY(), this.f15376b);
        canvas.drawLine(dimension + (0.0f * width), 8.0f + getY(), dimension + (0.0f * width), this.f15380f.getResources().getDimension(C2300R.dimen.dp20) + getY(), this.f15376b);
        canvas.drawLine(dimension + (100.0f * width), 8.0f + getY(), dimension + (100.0f * width), this.f15380f.getResources().getDimension(C2300R.dimen.dp20) + getY(), this.f15376b);
        if (this.f15379e != 0) {
            canvas.drawText(String.valueOf(1) + "%", dimension - (this.f15376b.getTextSize() / 2.0f), getY() + this.f15380f.getResources().getDimension(C2300R.dimen.dp70), this.f15376b);
        }
        if (this.f15379e != 100) {
            canvas.drawText("100%", ((100.0f * width) + dimension) - this.f15376b.getTextSize(), getY() + this.f15380f.getResources().getDimension(C2300R.dimen.dp70), this.f15376b);
        }
        canvas.drawBitmap(this.f15381g, ((this.f15378d * width) + dimension) - (this.f15377c.getTextSize() / 2.0f), getY() + this.f15380f.getResources().getDimension(C2300R.dimen.dp12_v), this.f15377c);
        this.f15377c.setColor(this.f15380f.getResources().getColor(C2300R.color.ev_color));
        canvas.drawText(String.valueOf(this.f15379e + "%"), ((this.f15378d * width) + dimension) - (this.f15376b.getTextSize() / 2.0f), getY() + this.f15380f.getResources().getDimension(C2300R.dimen.dp70), this.f15377c);
    }

    public void setLightPercent(int i) {
        this.f15379e = Math.abs(i) <= 0 ? 1 : Math.abs(i);
        this.f15378d = Math.abs(i);
        invalidate();
    }
}
