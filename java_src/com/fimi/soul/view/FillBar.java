package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.View;
/* loaded from: classes.dex */
public class FillBar extends View {

    /* renamed from: a */
    SurfaceHolder f15306a;

    /* renamed from: b */
    private Paint f15307b;

    /* renamed from: c */
    private Paint f15308c;

    /* renamed from: f */
    private int f15311f;

    /* renamed from: g */
    private int f15312g;

    /* renamed from: l */
    private int f15317l;

    /* renamed from: m */
    private int f15318m;

    /* renamed from: n */
    private int f15319n;

    /* renamed from: o */
    private int f15320o;

    /* renamed from: p */
    private int f15321p;

    /* renamed from: d */
    private Path f15309d = new Path();

    /* renamed from: e */
    private Path f15310e = new Path();

    /* renamed from: h */
    private float f15313h = 0.0f;

    /* renamed from: i */
    private float f15314i = 0.5f;

    /* renamed from: j */
    private float f15315j = 0.5f;

    /* renamed from: k */
    private boolean f15316k = false;

    /* renamed from: q */
    private boolean f15322q = false;

    public FillBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7326b();
    }

    /* renamed from: b */
    private void m7326b() {
        this.f15317l = Color.parseColor("#D6D6D6");
        this.f15318m = Color.parseColor("#FFFFFF");
        this.f15319n = Color.parseColor("#F49748");
        this.f15307b = new Paint();
        this.f15307b.setAntiAlias(false);
        this.f15307b.setStyle(Paint.Style.STROKE);
        this.f15307b.setStrokeWidth(3.0f);
        this.f15308c = new Paint(this.f15307b);
        this.f15308c.setStyle(Paint.Style.FILL);
    }

    /* renamed from: a */
    public void m7328a(int i, int i2) {
        this.f15320o = i;
        this.f15321p = i2;
    }

    /* renamed from: a */
    public void m7327a(boolean z) {
        this.f15322q = z;
    }

    /* renamed from: a */
    public boolean m7329a() {
        return this.f15316k;
    }

    public int getColorBar() {
        return this.f15319n;
    }

    public int getColorMin() {
        return this.f15318m;
    }

    public int getColorOutline() {
        return this.f15317l;
    }

    public float getMax() {
        return this.f15315j;
    }

    public int getMaxValue() {
        return this.f15321p + ((int) (getMax() * (this.f15320o - this.f15321p)));
    }

    public float getMin() {
        return this.f15314i;
    }

    public int getMinValue() {
        return this.f15321p + ((int) (getMin() * (this.f15320o - this.f15321p)));
    }

    public float getPercentage() {
        return this.f15313h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f15311f < this.f15312g ? this.f15311f : this.f15311f * (1.0f - this.f15313h);
        float f2 = this.f15311f < this.f15312g ? this.f15312g * this.f15313h : this.f15312g;
        this.f15308c.setColor(this.f15317l);
        this.f15309d.reset();
        this.f15309d.moveTo(0.0f, 0.0f);
        this.f15309d.lineTo(0.0f, this.f15311f);
        this.f15309d.lineTo(this.f15312g, this.f15311f);
        this.f15309d.lineTo(this.f15312g, 0.0f);
        this.f15309d.lineTo(0.0f, 0.0f);
        canvas.drawPath(this.f15309d, this.f15308c);
        this.f15308c.setColor(this.f15319n);
        this.f15310e.reset();
        if (this.f15322q) {
            if (this.f15311f > this.f15312g) {
                this.f15310e.moveTo(0.0f, 0.0f);
                this.f15310e.lineTo(0.0f, this.f15311f - f);
                this.f15310e.lineTo(this.f15312g, this.f15311f - f);
                this.f15310e.lineTo(this.f15312g, 0.0f);
                this.f15310e.lineTo(0.0f, 0.0f);
            } else {
                this.f15310e.moveTo(0.0f, 0.0f);
                this.f15310e.lineTo(0.0f, this.f15311f);
                this.f15310e.lineTo(this.f15312g - f2, this.f15311f);
                this.f15310e.lineTo(this.f15312g - f2, 0.0f);
                this.f15310e.lineTo(0.0f, 0.0f);
            }
        } else if (this.f15311f > this.f15312g) {
            this.f15310e.moveTo(0.0f, f);
            this.f15310e.lineTo(0.0f, this.f15311f);
            this.f15310e.lineTo(f2, this.f15311f);
            this.f15310e.lineTo(f2, f);
            this.f15310e.lineTo(0.0f, f);
        } else {
            this.f15310e.moveTo(0.0f, 0.0f);
            this.f15310e.lineTo(0.0f, this.f15311f);
            this.f15310e.lineTo(f2, this.f15311f);
            this.f15310e.lineTo(f2, 0.0f);
            this.f15310e.lineTo(0.0f, 0.0f);
        }
        canvas.drawPath(this.f15310e, this.f15308c);
        this.f15307b.setColor(this.f15318m);
        if (m7329a()) {
            this.f15309d.reset();
            if (this.f15322q) {
                if (this.f15311f > this.f15312g) {
                    float f3 = this.f15311f * this.f15314i;
                    this.f15309d.reset();
                    this.f15309d.moveTo(0.0f, f3);
                    this.f15309d.lineTo(this.f15312g, f3);
                    canvas.drawPath(this.f15309d, this.f15307b);
                    this.f15309d.reset();
                    float f4 = this.f15311f * this.f15315j;
                    this.f15309d.moveTo(0.0f, f4);
                    this.f15309d.lineTo(this.f15312g, f4);
                    canvas.drawPath(this.f15309d, this.f15307b);
                } else {
                    float f5 = this.f15312g * this.f15315j;
                    this.f15309d.reset();
                    this.f15309d.moveTo(f5, 0.0f);
                    this.f15309d.lineTo(f5, this.f15311f);
                    canvas.drawPath(this.f15309d, this.f15307b);
                    float f6 = this.f15312g * this.f15314i;
                    this.f15309d.reset();
                    this.f15309d.moveTo(f6, 0.0f);
                    this.f15309d.lineTo(f6, this.f15311f);
                    canvas.drawPath(this.f15309d, this.f15307b);
                }
            } else if (this.f15311f > this.f15312g) {
                float f7 = this.f15311f * (1.0f - this.f15314i);
                this.f15309d.reset();
                this.f15309d.moveTo(0.0f, f7);
                this.f15309d.lineTo(this.f15312g, f7);
                canvas.drawPath(this.f15309d, this.f15307b);
                this.f15309d.reset();
                float f8 = this.f15311f * (1.0f - this.f15315j);
                this.f15309d.moveTo(0.0f, f8);
                this.f15309d.lineTo(this.f15312g, f8);
                canvas.drawPath(this.f15309d, this.f15307b);
            } else {
                float f9 = this.f15312g * this.f15314i;
                this.f15309d.reset();
                this.f15309d.moveTo(f9, 0.0f);
                this.f15309d.lineTo(f9, this.f15311f);
                canvas.drawPath(this.f15309d, this.f15307b);
                float f10 = this.f15312g * this.f15315j;
                this.f15309d.reset();
                this.f15309d.moveTo(f10, 0.0f);
                this.f15309d.lineTo(f10, this.f15311f);
                canvas.drawPath(this.f15309d, this.f15307b);
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15312g = i - 1;
        this.f15311f = i2 - 1;
    }

    public void setColorBar(int i) {
        this.f15319n = i;
    }

    public void setColorMin(int i) {
        this.f15318m = i;
    }

    public void setColorOutline(int i) {
        this.f15317l = i;
    }

    public void setPercentage(float f) {
        this.f15313h = f;
        this.f15314i = this.f15314i > f ? f : this.f15314i;
        if (this.f15315j >= f) {
            f = this.f15315j;
        }
        this.f15315j = f;
        invalidate();
    }

    public void setShowMinMax(boolean z) {
        this.f15316k = z;
        if (z) {
            this.f15314i = 0.5f;
            this.f15315j = 0.5f;
        }
        invalidate();
    }

    public void setValue(int i) {
        setPercentage((i - this.f15321p) / (this.f15320o - this.f15321p));
    }
}
