package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class EVview extends View {

    /* renamed from: a */
    private Paint f15299a;

    /* renamed from: b */
    private Paint f15300b;

    /* renamed from: c */
    private Paint f15301c;

    /* renamed from: d */
    private int f15302d = 6;

    /* renamed from: e */
    private float f15303e = 0.0f;

    /* renamed from: f */
    private Context f15304f;

    /* renamed from: g */
    private Typeface f15305g;

    public EVview(Context context) {
        super(context);
        this.f15304f = context;
        m7333a();
    }

    public EVview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15304f = context;
        m7333a();
    }

    /* renamed from: b */
    private void m7331b(float f) {
        if (f == -2.0f) {
            this.f15302d = 0;
        } else if (f == -1.7f) {
            this.f15302d = 1;
        } else if (f == -1.3f) {
            this.f15302d = 2;
        } else if (f == -1.0f) {
            this.f15302d = 3;
        } else if (f == -0.7f) {
            this.f15302d = 4;
        } else if (f == -0.3f) {
            this.f15302d = 5;
        } else if (f == 0.0f) {
            this.f15302d = 6;
        } else if (f == 0.3f) {
            this.f15302d = 7;
        } else if (f == 0.7f) {
            this.f15302d = 8;
        } else if (f == 1.0f) {
            this.f15302d = 9;
        } else if (f == 1.3f) {
            this.f15302d = 10;
        } else if (f == 1.7f) {
            this.f15302d = 11;
        } else if (f != 2.0f) {
        } else {
            this.f15302d = 12;
        }
    }

    /* renamed from: c */
    private void m7330c(float f) {
        if (f == -2.0f) {
            this.f15302d = 0;
        } else if (f == -1.3f) {
            this.f15302d = 2;
        } else if (f == -0.7f) {
            this.f15302d = 4;
        } else if (f == 0.0f) {
            this.f15302d = 6;
        } else if (f == 0.7f) {
            this.f15302d = 8;
        } else if (f == 1.3f) {
            this.f15302d = 10;
        } else if (f != 2.0f) {
        } else {
            this.f15302d = 12;
        }
    }

    /* renamed from: a */
    void m7333a() {
        this.f15299a = new Paint();
        this.f15299a.setColor(-1);
        this.f15299a.setAlpha(80);
        this.f15299a.setStrokeWidth(3.0f);
        this.f15299a.setStyle(Paint.Style.FILL);
        this.f15299a.setAntiAlias(true);
        this.f15299a.setTextSize(25.0f);
        this.f15300b = new Paint();
        this.f15300b.setColor(getResources().getColor(C2300R.color.changebetery));
        this.f15300b.setStrokeWidth(3.0f);
        this.f15300b.setAntiAlias(true);
        this.f15300b.setStyle(Paint.Style.FILL);
        if (this.f15305g == null) {
            this.f15305g = Typeface.createFromAsset(this.f15304f.getAssets(), "DIN Alternate Bold.ttf");
        }
        this.f15300b.setTypeface(this.f15305g);
        this.f15299a.setTypeface(this.f15305g);
    }

    /* renamed from: a */
    public void m7332a(float f) {
        this.f15303e = f;
        m7331b(f);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15299a.setColor(-1);
        canvas.drawLine(this.f15304f.getResources().getDimension(C2300R.dimen.dp50), this.f15304f.getResources().getDimension(C2300R.dimen.dp28) + getY(), getWidth() - this.f15304f.getResources().getDimension(C2300R.dimen.dp50), this.f15304f.getResources().getDimension(C2300R.dimen.dp28) + getY(), this.f15299a);
        float dimension = this.f15304f.getResources().getDimension(C2300R.dimen.dp50);
        float width = (getWidth() - this.f15304f.getResources().getDimension(C2300R.dimen.dp100)) / 12.0f;
        for (int i = 0; i <= 12; i++) {
            this.f15299a.setColor(-1);
            if (i % 2 != 0) {
                canvas.drawLine(dimension + (i * width), this.f15304f.getResources().getDimension(C2300R.dimen.dp23) + getY(), dimension + (i * width), this.f15304f.getResources().getDimension(C2300R.dimen.dp33) + getY(), this.f15299a);
            } else {
                canvas.drawLine(dimension + (i * width), 13.0f + getY(), dimension + (i * width), this.f15304f.getResources().getDimension(C2300R.dimen.dp43) + getY(), this.f15299a);
            }
            if (i == 0) {
                if (this.f15302d != 0) {
                    canvas.drawText("-2", ((i * width) + dimension) - (this.f15299a.getTextSize() / 3.0f), getY() + this.f15304f.getResources().getDimension(C2300R.dimen.dp70), this.f15299a);
                }
            } else if (i == 6) {
                if (this.f15302d != 6) {
                    canvas.drawText("0", ((i * width) + dimension) - (this.f15299a.getTextSize() / 3.0f), getY() + this.f15304f.getResources().getDimension(C2300R.dimen.dp70), this.f15299a);
                }
            } else if (i == 12 && this.f15302d != 12) {
                canvas.drawText("2", ((i * width) + dimension) - (this.f15299a.getTextSize() / 3.0f), getY() + this.f15304f.getResources().getDimension(C2300R.dimen.dp70), this.f15299a);
            }
        }
        canvas.drawCircle((this.f15302d * width) + dimension, getY() + this.f15304f.getResources().getDimension(C2300R.dimen.dp28), this.f15304f.getResources().getDimension(C2300R.dimen.dp_ev_20), this.f15300b);
        this.f15299a.setColor(this.f15304f.getResources().getColor(C2300R.color.ev_color));
        canvas.drawText(String.valueOf(this.f15303e), ((this.f15302d * width) + dimension) - (this.f15299a.getTextSize() / 2.0f), getY() + this.f15304f.getResources().getDimension(C2300R.dimen.dp70), this.f15299a);
    }
}
