package com.fimi.soul.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.kernel.utils.C2271p;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class BreathLeapView extends View {

    /* renamed from: a */
    private float f15228a;

    /* renamed from: b */
    private float f15229b;

    /* renamed from: c */
    private Paint f15230c;

    /* renamed from: d */
    private Paint f15231d;

    /* renamed from: e */
    private Paint f15232e;

    /* renamed from: f */
    private Paint f15233f;

    /* renamed from: g */
    private Paint f15234g;

    /* renamed from: h */
    private Paint f15235h;

    /* renamed from: i */
    private Paint f15236i;

    /* renamed from: j */
    private Paint f15237j;

    /* renamed from: k */
    private Paint f15238k;

    /* renamed from: l */
    private Paint f15239l;

    /* renamed from: m */
    private Bitmap f15240m;

    /* renamed from: n */
    private Bitmap f15241n;

    /* renamed from: o */
    private Bitmap f15242o;

    /* renamed from: p */
    private int f15243p;

    /* renamed from: q */
    private float f15244q;

    public BreathLeapView(Context context) {
        super(context, null);
        this.f15243p = 0;
        this.f15244q = 0.0f;
    }

    public BreathLeapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f15230c = new Paint();
        this.f15231d = new Paint();
        this.f15232e = new Paint();
        this.f15233f = new Paint();
        this.f15234g = new Paint();
        this.f15235h = new Paint();
        this.f15236i = new Paint();
        this.f15237j = new Paint();
        this.f15238k = new Paint();
        this.f15239l = new Paint();
        setBackgroundResource(C2300R.C2301drawable.check_connect_bg);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.connent_on);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.round);
        Bitmap decodeResource3 = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.connent);
        float m12860b = ((C2271p.m12860b(context) < ((float) C2271p.m12871a(context)) ? C2271p.m12860b(context) : C2271p.m12871a(context)) * 0.4925f) / decodeResource3.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(m12860b, m12860b);
        this.f15240m = Bitmap.createBitmap(decodeResource3, 0, 0, decodeResource3.getWidth(), decodeResource3.getWidth(), matrix, true);
        this.f15241n = Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getWidth(), matrix, true);
        this.f15242o = Bitmap.createBitmap(decodeResource2, 0, 0, decodeResource2.getWidth(), decodeResource2.getWidth(), matrix, true);
        this.f15244q = context.getResources().getDimension(C2300R.dimen.unit);
        if (decodeResource != null && !decodeResource.isRecycled()) {
            decodeResource.isRecycled();
        }
        if (decodeResource2 != null && !decodeResource2.isRecycled()) {
            decodeResource2.isRecycled();
        }
        if (decodeResource3 == null || decodeResource3.isRecycled()) {
            return;
        }
        decodeResource3.isRecycled();
    }

    public BreathLeapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15243p = 0;
        this.f15244q = 0.0f;
    }

    /* renamed from: b */
    private void m7350b() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255, 0);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.BreathLeapView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BreathLeapView.this.f15243p = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BreathLeapView.this.invalidate();
            }
        });
        ofInt.setDuration(400L);
        ofInt.start();
    }

    /* renamed from: c */
    private void m7348c() {
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 255, 50);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.BreathLeapView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i = 50;
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BreathLeapView.this.f15234g.setAlpha(intValue + (-155) > 50 ? intValue - 155 : 50);
                BreathLeapView.this.f15235h.setAlpha(intValue + (-105) > 50 ? intValue - 100 : 50);
                BreathLeapView.this.f15236i.setAlpha(intValue + (-55) > 50 ? intValue - 50 : 50);
                Paint paint = BreathLeapView.this.f15237j;
                if (intValue > 50) {
                    i = intValue;
                }
                paint.setAlpha(i);
                BreathLeapView.this.invalidate();
            }
        });
        ofInt.setDuration(300L);
        ofInt.start();
    }

    /* renamed from: a */
    public void m7353a() {
        if (this.f15241n != null && !this.f15241n.isRecycled()) {
            this.f15241n.recycle();
            this.f15241n = null;
        }
        if (this.f15242o != null && !this.f15242o.isRecycled()) {
            this.f15242o.recycle();
            this.f15242o = null;
        }
        if (this.f15240m == null || this.f15240m.isRecycled()) {
            return;
        }
        this.f15240m.recycle();
        this.f15240m = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15239l.setAlpha(this.f15243p);
        canvas.drawBitmap(this.f15241n, (this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15241n.getHeight() / 2), this.f15239l);
        canvas.drawBitmap(this.f15240m, (this.f15228a / 2.0f) - (this.f15240m.getWidth() / 2), this.f15229b * 0.15f, this.f15238k);
        canvas.drawBitmap(this.f15242o, ((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15237j);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 10.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15236i);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 20.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15235h);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 30.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15234g);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 40.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15233f);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 50.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15232e);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 60.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15231d);
        canvas.drawBitmap(this.f15242o, (((this.f15228a / 2.0f) - (this.f15241n.getWidth() / 2)) - (this.f15244q * 8.0f)) - (this.f15244q * 70.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15230c);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15237j);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 10.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15236i);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 20.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15235h);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 30.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15234g);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 40.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15233f);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 50.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2.0f)) - (this.f15242o.getHeight() / 2), this.f15232e);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 60.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2.0f)) - (this.f15242o.getHeight() / 2), this.f15231d);
        canvas.drawBitmap(this.f15242o, (this.f15228a / 2.0f) + (this.f15241n.getWidth() / 2) + (this.f15244q * 3.0f) + (this.f15244q * 70.0f), ((this.f15229b * 0.15f) + (this.f15240m.getHeight() / 2)) - (this.f15242o.getHeight() / 2), this.f15230c);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f15228a = getMeasuredWidth();
        this.f15229b = getMeasuredHeight();
    }

    public void setting(int i) {
        switch (i) {
            case 0:
                this.f15230c.setAlpha(255);
                this.f15231d.setAlpha(50);
                this.f15232e.setAlpha(50);
                this.f15233f.setAlpha(50);
                this.f15234g.setAlpha(50);
                this.f15235h.setAlpha(50);
                this.f15236i.setAlpha(50);
                this.f15237j.setAlpha(50);
                break;
            case 1:
                this.f15230c.setAlpha(200);
                this.f15231d.setAlpha(255);
                this.f15232e.setAlpha(50);
                this.f15233f.setAlpha(50);
                this.f15234g.setAlpha(50);
                this.f15235h.setAlpha(50);
                this.f15236i.setAlpha(50);
                this.f15237j.setAlpha(50);
                break;
            case 2:
                this.f15230c.setAlpha(150);
                this.f15231d.setAlpha(200);
                this.f15232e.setAlpha(255);
                this.f15233f.setAlpha(50);
                this.f15234g.setAlpha(50);
                this.f15235h.setAlpha(50);
                this.f15236i.setAlpha(50);
                this.f15237j.setAlpha(50);
                break;
            case 3:
                this.f15230c.setAlpha(100);
                this.f15231d.setAlpha(150);
                this.f15232e.setAlpha(200);
                this.f15233f.setAlpha(255);
                this.f15234g.setAlpha(50);
                this.f15235h.setAlpha(50);
                this.f15236i.setAlpha(50);
                this.f15237j.setAlpha(50);
                break;
            case 4:
                this.f15230c.setAlpha(50);
                this.f15231d.setAlpha(100);
                this.f15232e.setAlpha(150);
                this.f15233f.setAlpha(200);
                this.f15234g.setAlpha(255);
                this.f15235h.setAlpha(50);
                this.f15236i.setAlpha(50);
                this.f15237j.setAlpha(50);
                break;
            case 5:
                this.f15230c.setAlpha(50);
                this.f15231d.setAlpha(50);
                this.f15232e.setAlpha(100);
                this.f15233f.setAlpha(150);
                this.f15234g.setAlpha(200);
                this.f15235h.setAlpha(250);
                this.f15236i.setAlpha(50);
                this.f15237j.setAlpha(50);
                break;
            case 6:
                this.f15230c.setAlpha(50);
                this.f15231d.setAlpha(50);
                this.f15232e.setAlpha(50);
                this.f15233f.setAlpha(100);
                this.f15234g.setAlpha(150);
                this.f15235h.setAlpha(200);
                this.f15236i.setAlpha(255);
                this.f15237j.setAlpha(50);
                break;
            case 7:
                this.f15230c.setAlpha(50);
                this.f15231d.setAlpha(50);
                this.f15232e.setAlpha(50);
                this.f15233f.setAlpha(50);
                this.f15234g.setAlpha(100);
                this.f15235h.setAlpha(150);
                this.f15236i.setAlpha(200);
                this.f15237j.setAlpha(255);
                m7350b();
                m7348c();
                break;
        }
        invalidate();
    }
}
