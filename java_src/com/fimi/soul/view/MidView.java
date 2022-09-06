package com.fimi.soul.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class MidView extends View {

    /* renamed from: c */
    public static final int f15384c = 1;

    /* renamed from: d */
    public static final int f15385d = 2;

    /* renamed from: A */
    private int f15386A;

    /* renamed from: a */
    float f15387a = 50.0f;

    /* renamed from: b */
    float f15388b = 50.0f;

    /* renamed from: e */
    private Bitmap f15389e;

    /* renamed from: f */
    private Bitmap f15390f;

    /* renamed from: g */
    private Bitmap f15391g;

    /* renamed from: h */
    private Bitmap f15392h;

    /* renamed from: i */
    private int f15393i;

    /* renamed from: j */
    private int f15394j;

    /* renamed from: k */
    private int f15395k;

    /* renamed from: l */
    private int f15396l;

    /* renamed from: m */
    private int f15397m;

    /* renamed from: n */
    private int f15398n;

    /* renamed from: o */
    private float f15399o;

    /* renamed from: p */
    private float f15400p;

    /* renamed from: q */
    private float f15401q;

    /* renamed from: r */
    private Point f15402r;

    /* renamed from: s */
    private Point f15403s;

    /* renamed from: t */
    private Point f15404t;

    /* renamed from: u */
    private int f15405u;

    /* renamed from: v */
    private int f15406v;

    /* renamed from: w */
    private int f15407w;

    /* renamed from: x */
    private int f15408x;

    /* renamed from: y */
    private int f15409y;

    /* renamed from: z */
    private int f15410z;

    public MidView(Context context) {
        super(context);
    }

    public MidView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.mycircleView);
        this.f15405u = obtainStyledAttributes.getInteger(0, 0);
        setType(this.f15405u);
        obtainStyledAttributes.recycle();
    }

    public MidView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public void m7267a(float f, float f2) {
        if (this.f15387a == f && this.f15388b == f2) {
            return;
        }
        this.f15399o = ((this.f15393i / 2) - (this.f15395k / 2)) / 50.0f;
        this.f15387a = f;
        this.f15388b = f2;
        invalidate();
    }

    /* renamed from: a */
    public void m7266a(Bitmap... bitmapArr) {
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap != null && bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(-1);
        canvas.drawBitmap(this.f15389e, 0.0f, 0.0f, paint);
        canvas.drawBitmap(this.f15391g, (this.f15393i / 2) - (this.f15397m / 2), (this.f15394j / 2) - (this.f15398n / 2), paint);
        this.f15408x = C3819g.m6956a(this.f15393i / 2, this.f15393i / 2, (this.f15387a * this.f15400p) + this.f15395k, (this.f15388b * this.f15401q) + this.f15395k);
        if (this.f15408x <= this.f15409y) {
            canvas.drawBitmap(this.f15390f, ((this.f15387a * this.f15400p) + (this.f15393i / 2)) - (this.f15392h.getWidth() / 2), ((this.f15388b * this.f15401q) + (this.f15393i / 2)) - (this.f15392h.getHeight() / 2), paint);
            return;
        }
        this.f15403s = C3819g.m6953a(this.f15402r, new Point((int) ((this.f15387a * this.f15400p) + this.f15395k), (int) ((this.f15388b * this.f15401q) + this.f15395k)), this.f15409y);
        if (this.f15403s.x < (this.f15393i / 2) - (this.f15392h.getWidth() / 2)) {
            this.f15403s.x = (this.f15393i / 2) - (this.f15392h.getWidth() / 2);
        }
        if (this.f15405u == 1 && this.f15403s.x > this.f15392h.getWidth() - (this.f15395k / 2)) {
            this.f15403s.x = this.f15392h.getWidth() - (this.f15395k / 2);
        }
        if (this.f15403s.y < (this.f15393i / 2) - (this.f15392h.getHeight() / 2)) {
            this.f15403s.y = (this.f15393i / 2) - (this.f15392h.getHeight() / 2);
        }
        canvas.drawBitmap(this.f15390f, this.f15403s.x, this.f15403s.y, paint);
        m7266a(this.f15389e, this.f15390f, this.f15391g, this.f15392h);
    }

    public void setType(int i) {
        if (i == 1) {
            this.f15389e = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.icon_calibration_remote_control_samll);
            this.f15390f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.icon_calibration_annulus_samll);
            this.f15391g = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.icon_calibration_circle_samll);
            this.f15392h = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.bg_calibration_remote_control_square_samll);
        } else if (i == 2) {
            this.f15389e = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.bg_calibration_remote_control_square_line);
            this.f15390f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.calibration_annulus);
            this.f15391g = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.calibration_circle);
            this.f15392h = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.remoterocefbg);
        }
        this.f15397m = this.f15391g.getWidth();
        this.f15398n = this.f15391g.getHeight();
        this.f15393i = this.f15389e.getWidth();
        this.f15394j = this.f15389e.getHeight();
        this.f15395k = this.f15390f.getWidth();
        this.f15396l = this.f15390f.getHeight();
        this.f15409y = ((int) Math.sqrt(Math.pow(this.f15392h.getWidth() / 2, 2.0d) + Math.pow(this.f15392h.getHeight() / 2, 2.0d))) - (this.f15395k / 2);
        this.f15402r = new Point((this.f15393i / 2) - (this.f15395k / 2), (this.f15394j / 2) - (this.f15395k / 2));
        this.f15410z = C3819g.m6956a(this.f15395k / 2, this.f15396l / 2, this.f15393i / 2, this.f15394j / 2);
        this.f15400p = ((this.f15392h.getWidth() / 2) - (this.f15395k / 2)) / 50.0f;
        this.f15401q = ((this.f15392h.getHeight() / 2) - (this.f15395k / 2)) / 50.0f;
    }
}
