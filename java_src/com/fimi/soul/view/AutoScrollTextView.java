package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p001v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class AutoScrollTextView extends TextView implements View.OnClickListener {

    /* renamed from: a */
    public static final String f15144a = AutoScrollTextView.class.getSimpleName();

    /* renamed from: c */
    String f15146c;

    /* renamed from: d */
    private float f15147d = 0.0f;

    /* renamed from: e */
    private float f15148e = 0.0f;

    /* renamed from: f */
    private float f15149f = 0.0f;

    /* renamed from: g */
    private float f15150g = 0.0f;

    /* renamed from: h */
    private float f15151h = 0.0f;

    /* renamed from: i */
    private float f15152i = 0.0f;

    /* renamed from: b */
    public boolean f15145b = false;

    /* renamed from: j */
    private Paint f15153j = null;

    /* renamed from: k */
    private CharSequence f15154k = "";

    /* renamed from: l */
    private float f15155l = 0.5f;

    /* renamed from: m */
    private int f15156m = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: n */
    private int f15157n = 0;

    public AutoScrollTextView(Context context) {
        super(context);
        m7378c();
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7378c();
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7378c();
    }

    /* renamed from: c */
    private void m7378c() {
        setOnClickListener(this);
    }

    /* renamed from: a */
    public void m7381a() {
        this.f15145b = true;
        invalidate();
    }

    /* renamed from: a */
    public void m7380a(float f) {
        this.f15154k = super.getText();
        this.f15153j = super.getPaint();
        this.f15154k = getText().toString();
        this.f15147d = this.f15153j.measureText(this.f15154k.toString());
        this.f15148e = getWidth();
        this.f15148e = f;
        this.f15149f = this.f15147d;
        this.f15151h = this.f15148e + this.f15147d;
        this.f15152i = this.f15148e + (this.f15147d * 1.5f);
        this.f15150g = getTextSize() + getPaddingTop();
        this.f15153j.setColor(this.f15156m);
    }

    /* renamed from: b */
    public void m7379b() {
        this.f15145b = false;
        invalidate();
    }

    public float getSpeed() {
        return this.f15155l;
    }

    public int getTextColor() {
        return this.f15156m;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f15145b) {
            m7379b();
        } else {
            m7381a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f15153j != null) {
            canvas.drawText(this.f15154k, 0, this.f15154k.length(), this.f15151h - this.f15149f, this.f15150g, this.f15153j);
            if (!this.f15145b) {
                return;
            }
            this.f15149f += this.f15155l;
            if (this.f15149f > this.f15152i) {
                this.f15157n++;
                if (this.f15157n == this.f15154k.length()) {
                    this.f15157n = 0;
                }
                m7380a(0.0f);
                this.f15149f = this.f15147d;
            }
            invalidate();
        }
    }

    public void setSpeed(float f) {
        this.f15155l = f;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        m7380a(0.0f);
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.f15156m = i;
    }
}
