package com.fimi.kernel.view.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.p001v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes.dex */
public class ProgressView extends View {

    /* renamed from: a */
    private static final int[] f7682a = {-16711936, -256, SupportMenu.CATEGORY_MASK};

    /* renamed from: b */
    private float f7683b;

    /* renamed from: c */
    private float f7684c;

    /* renamed from: d */
    private Paint f7685d;

    /* renamed from: e */
    private int f7686e;

    /* renamed from: f */
    private int f7687f;

    /* renamed from: g */
    private int f7688g = 0;

    /* renamed from: h */
    private int f7689h = 0;

    public ProgressView(Context context) {
        super(context);
        m12624a(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12624a(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12624a(context);
    }

    /* renamed from: a */
    private int m12625a(int i) {
        return (int) (((i >= 0 ? 1 : -1) * 0.5f) + (i * getContext().getResources().getDisplayMetrics().density));
    }

    /* renamed from: a */
    private void m12624a(Context context) {
    }

    public float getCurrentCount() {
        return this.f7684c;
    }

    public float getMaxCount() {
        return this.f7683b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7685d = new Paint();
        this.f7685d.setAntiAlias(true);
        int i = this.f7687f / 2;
        if (this.f7689h == 0) {
            this.f7685d.setColor(771751935);
        } else {
            this.f7685d.setColor(this.f7689h);
        }
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.f7686e, this.f7687f), i, i, this.f7685d);
        RectF rectF = new RectF(0.0f, 0.0f, (this.f7684c / this.f7683b) * this.f7686e, this.f7687f);
        if (this.f7688g == 0) {
            this.f7685d.setColor(1895825407);
        } else {
            this.f7685d.setColor(this.f7688g);
        }
        canvas.drawRoundRect(rectF, i, i, this.f7685d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            this.f7686e = size;
        } else {
            this.f7686e = 0;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            this.f7687f = m12625a(15);
        } else {
            this.f7687f = size2;
        }
        setMeasuredDimension(this.f7686e, this.f7687f);
    }

    public void setBackColor(int i) {
        this.f7689h = i;
    }

    public void setCurrentCount(float f) {
        if (f > this.f7683b) {
            f = this.f7683b;
        }
        this.f7684c = f;
        invalidate();
    }

    public void setFrontColor(int i) {
        this.f7688g = i;
    }

    public void setMaxCount(float f) {
        this.f7683b = f;
    }
}
