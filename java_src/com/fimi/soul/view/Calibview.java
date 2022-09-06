package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.utils.C3678g;
/* loaded from: classes.dex */
public class Calibview extends View {

    /* renamed from: a */
    Context f15247a;

    /* renamed from: b */
    RectF f15248b;

    /* renamed from: c */
    private float f15249c;

    /* renamed from: d */
    private int f15250d;

    /* renamed from: e */
    private int f15251e;

    /* renamed from: f */
    private int f15252f;

    /* renamed from: g */
    private int f15253g;

    /* renamed from: h */
    private int f15254h;

    /* renamed from: i */
    private int f15255i;

    /* renamed from: j */
    private int f15256j;

    public Calibview(Context context) {
        super(context);
        this.f15250d = 10;
        this.f15251e = 100;
        this.f15252f = 60;
        this.f15247a = context;
    }

    public Calibview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15250d = 10;
        this.f15251e = 100;
        this.f15252f = 60;
        this.f15247a = context;
        this.f15249c = getResources().getDisplayMetrics().density;
        if (this.f15249c == 1.5d) {
            this.f15251e = C3678g.m7487a(context, 65.0f);
            this.f15250d = C3678g.m7487a(context, 5.0f);
            this.f15252f = C3678g.m7487a(context, 40.0f);
        } else if (this.f15249c == 2.0f) {
            this.f15251e = C3678g.m7487a(context, 50.0f);
            this.f15250d = C3678g.m7487a(context, 5.0f);
            this.f15252f = C3678g.m7487a(context, 30.0f);
        } else if (this.f15249c != 3.0f) {
        } else {
            this.f15251e = C3678g.m7487a(context, 33.0f);
            this.f15250d = C3678g.m7487a(context, 3.0f);
            this.f15252f = C3678g.m7487a(context, 20.0f);
        }
    }

    /* renamed from: a */
    public void m7345a(int i, int i2, int i3, int i4) {
        this.f15253g = i;
        this.f15254h = i2;
        this.f15255i = i3;
        this.f15256j = i4;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Paint paint = new Paint();
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        canvas.drawCircle(this.f15251e * this.f15249c, this.f15251e * this.f15249c, this.f15252f * this.f15249c, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(this.f15251e * this.f15249c, this.f15251e * this.f15249c, this.f15250d * this.f15249c, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setStrokeWidth(3.0f);
        this.f15248b = new RectF((this.f15251e - this.f15252f) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        this.f15248b = new RectF((this.f15251e - this.f15250d) * this.f15249c, (this.f15251e - this.f15252f) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        this.f15248b = new RectF((this.f15251e + this.f15250d) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c, (this.f15251e + this.f15252f) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        this.f15248b = new RectF((this.f15251e - this.f15250d) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c, (this.f15251e + this.f15252f) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        Paint paint2 = new Paint();
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint2.setTextSize(15.0f * this.f15249c);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        canvas.drawText((this.f15254h * 2) + "%", ((this.f15251e - this.f15252f) - 20) * this.f15249c, (this.f15251e + 2) * this.f15249c, paint2);
        canvas.drawText((this.f15253g * 2) + "%", this.f15251e * this.f15249c, ((this.f15251e - this.f15252f) - 5) * this.f15249c, paint2);
        canvas.drawText((this.f15255i * 2) + "%", (this.f15251e + this.f15252f + 20) * this.f15249c, (this.f15251e + 2) * this.f15249c, paint2);
        canvas.drawText((this.f15256j * 2) + "%", this.f15251e * this.f15249c, (this.f15251e + this.f15252f + 15) * this.f15249c, paint2);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-16711936);
        this.f15248b = new RectF(((this.f15251e - this.f15250d) - this.f15254h) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        this.f15248b = new RectF((this.f15251e - this.f15250d) * this.f15249c, ((this.f15251e - this.f15250d) - this.f15253g) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        this.f15248b = new RectF((this.f15251e + this.f15250d) * this.f15249c, (this.f15251e - this.f15250d) * this.f15249c, (this.f15251e + this.f15250d + this.f15255i) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
        this.f15248b = new RectF((this.f15251e - this.f15250d) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c, (this.f15251e + this.f15250d) * this.f15249c, (this.f15251e + this.f15250d + this.f15256j) * this.f15249c);
        canvas.drawRoundRect(this.f15248b, this.f15249c * 10.0f, this.f15249c * 10.0f, paint);
    }
}
