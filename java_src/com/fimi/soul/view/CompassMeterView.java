package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class CompassMeterView extends View {

    /* renamed from: c */
    private static final float f15277c = 1.8f;

    /* renamed from: b */
    private int f15279b;

    /* renamed from: d */
    private boolean f15280d;

    /* renamed from: e */
    private RectF f15281e;

    /* renamed from: f */
    private Bitmap f15282f;

    /* renamed from: g */
    private Bitmap f15283g;

    /* renamed from: h */
    private Bitmap f15284h;

    /* renamed from: j */
    private Rect f15286j;

    /* renamed from: k */
    private float f15287k;

    /* renamed from: l */
    private float f15288l;

    /* renamed from: m */
    private float f15289m;

    /* renamed from: n */
    private String f15290n;

    /* renamed from: p */
    private int f15292p;

    /* renamed from: q */
    private float f15293q;

    /* renamed from: r */
    private Paint f15294r;

    /* renamed from: s */
    private float f15295s;

    /* renamed from: t */
    private Paint f15296t;

    /* renamed from: u */
    private Paint f15297u;

    /* renamed from: a */
    private float f15278a = 90.0f;

    /* renamed from: i */
    private int f15285i = 18;

    /* renamed from: o */
    private boolean f15291o = false;

    /* renamed from: v */
    private float f15298v = 0.0f;

    public CompassMeterView(Context context) {
        super(context);
        m7340a();
    }

    public CompassMeterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7340a();
    }

    public CompassMeterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7340a();
    }

    private void setCurrentAngle(float f) {
        this.f15278a = f;
    }

    /* renamed from: a */
    public float m7339a(float f) {
        return getResources().getDisplayMetrics().density * f;
    }

    /* renamed from: a */
    public float m7338a(float f, float f2, float f3) {
        return (float) (f + (f2 * Math.sin(((180.0f + f3) * 3.141592653589793d) / 180.0d)));
    }

    /* renamed from: a */
    public float m7337a(int i, float f, float f2) {
        return (float) ((i / 2.0d) + (f * Math.cos(((180.0f + f2) * 3.141592653589793d) / 180.0d)));
    }

    /* renamed from: a */
    public void m7340a() {
        this.f15294r = new Paint();
        this.f15294r.setAntiAlias(true);
        this.f15297u = new Paint();
        this.f15297u.setAntiAlias(true);
        this.f15282f = ((BitmapDrawable) getResources().getDrawable(C2300R.C2301drawable.chart_compass_connected)).getBitmap();
        this.f15283g = ((BitmapDrawable) getResources().getDrawable(C2300R.C2301drawable.chart_compass_connected_no)).getBitmap();
        this.f15284h = ((BitmapDrawable) getResources().getDrawable(C2300R.C2301drawable.chart_point)).getBitmap();
        this.f15287k = m7339a(34.0f);
        this.f15289m = m7339a(50.0f);
        this.f15293q = m7339a(47.0f);
        this.f15288l = m7339a(6.0f);
        this.f15292p = getResources().getColor(C2300R.color.meter_text);
        this.f15298v = m7339a(2.0f);
    }

    /* renamed from: a */
    public void m7336a(int i, float f, float f2, int i2, Canvas canvas) {
        float m7337a = m7337a(i, this.f15289m, f2);
        float m7338a = m7338a(f, this.f15289m, f2);
        float m7337a2 = m7337a(i, this.f15287k, f2);
        float m7338a2 = m7338a(f, this.f15287k, f2);
        float m7337a3 = m7337a(i, this.f15293q, f2);
        float m7338a3 = m7338a(f, this.f15293q, f2);
        Rect rect = new Rect();
        String str = "" + i2;
        this.f15288l = m7339a(6.0f);
        this.f15297u.setTextSize(this.f15288l);
        this.f15297u.setColor(this.f15292p);
        this.f15297u.getTextBounds(str, 0, str.length(), rect);
        if (f2 == 0.0f) {
            canvas.drawText(str, m7337a - (rect.width() / 3.0f), m7338a, this.f15297u);
        } else if (f2 <= 90.0f) {
            canvas.drawText(str, m7337a - (rect.width() / 2.0f), m7338a, this.f15297u);
        } else {
            canvas.drawText(str, m7337a - (rect.width() / 3.0f), m7338a, this.f15297u);
        }
        canvas.drawLine(m7337a2, m7338a2, m7337a3, m7338a3, this.f15297u);
    }

    /* renamed from: a */
    public void m7335a(int i, float f, Canvas canvas) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f15278a - 90.0f, this.f15284h.getWidth() / 2.0f, this.f15284h.getHeight() / 2.0f);
        matrix.postTranslate((i - this.f15284h.getWidth()) / 2.0f, f - (this.f15284h.getHeight() / 2.0f));
        Log.i("zdy", "" + this.f15284h.getWidth() + " " + this.f15284h.getHeight());
        canvas.drawBitmap(this.f15284h, matrix, this.f15294r);
        matrix.reset();
    }

    /* renamed from: a */
    public void m7334a(int i, int i2, Canvas canvas) {
        float m7337a = m7337a(i, this.f15287k, this.f15278a);
        float m7338a = m7338a(i2, this.f15287k, this.f15278a);
        Matrix matrix = new Matrix();
        float width = m7337a - (this.f15284h.getWidth() / 2.0f);
        float height = m7338a - (this.f15284h.getHeight() / 2.0f);
        matrix.postRotate(this.f15278a - 90.0f, this.f15284h.getWidth() / 2.0f, this.f15284h.getHeight() / 2.0f);
        matrix.postTranslate(width, height);
        canvas.drawBitmap(this.f15284h, matrix, this.f15294r);
        matrix.reset();
    }

    public float getCurrentAngle() {
        return this.f15278a;
    }

    public int getCurrentProgress() {
        return this.f15279b;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        float height = getHeight() - this.f15298v;
        int height2 = this.f15282f.getHeight();
        int width2 = (width - this.f15282f.getWidth()) / 2;
        m7336a(width, height, 36.0f, 20, canvas);
        m7336a(width, height, 72.0f, 40, canvas);
        m7336a(width, height, 0.0f, 0, canvas);
        m7336a(width, height, 180.0f, 100, canvas);
        if (this.f15291o) {
            canvas.drawBitmap(this.f15282f, width2, height - height2, this.f15294r);
        } else {
            canvas.drawBitmap(this.f15283g, width2, height - height2, this.f15294r);
            this.f15278a = 90.0f;
        }
        m7335a(width, height, canvas);
        Rect rect = new Rect();
        this.f15288l = m7339a(9.0f);
        this.f15297u.setTextSize(this.f15288l);
        this.f15297u.setColor(this.f15292p);
        this.f15297u.getTextBounds(this.f15290n, 0, this.f15290n.length(), rect);
        canvas.drawText(this.f15290n, (width - rect.width()) / 2, height, this.f15297u);
    }

    public void setCurrentProgress(int i) {
        if (this.f15279b == i) {
            return;
        }
        this.f15279b = i;
        setCurrentAngle(i * f15277c);
        postInvalidate();
    }

    public void setEngine(boolean z) {
        if (this.f15291o == z) {
            return;
        }
        this.f15291o = z;
        postInvalidate();
    }

    public void setTitle(String str) {
        this.f15290n = str;
    }
}
