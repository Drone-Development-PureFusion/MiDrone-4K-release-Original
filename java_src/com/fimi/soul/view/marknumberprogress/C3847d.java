package com.fimi.soul.view.marknumberprogress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.util.TypedValue;
/* renamed from: com.fimi.soul.view.marknumberprogress.d */
/* loaded from: classes.dex */
public class C3847d {

    /* renamed from: r */
    private static final float f16293r = 24.0f;

    /* renamed from: a */
    private float f16294a;

    /* renamed from: b */
    private Bitmap f16295b;

    /* renamed from: c */
    private Bitmap f16296c;

    /* renamed from: d */
    private float f16297d;

    /* renamed from: e */
    private float f16298e;

    /* renamed from: f */
    private float f16299f;

    /* renamed from: g */
    private float f16300g;

    /* renamed from: h */
    private boolean f16301h;

    /* renamed from: i */
    private int f16302i;

    /* renamed from: j */
    private float f16303j;

    /* renamed from: k */
    private Paint f16304k;

    /* renamed from: l */
    private Paint f16305l;

    /* renamed from: m */
    private float f16306m;

    /* renamed from: n */
    private boolean f16307n;

    /* renamed from: o */
    private int f16308o;

    /* renamed from: p */
    private int f16309p;

    /* renamed from: q */
    private int f16310q;

    /* renamed from: s */
    private int f16311s;

    /* renamed from: t */
    private int f16312t;

    public C3847d(Context context, int i, int i2, int i3, float f, int i4) {
        this.f16301h = false;
        Resources resources = context.getResources();
        this.f16304k = new Paint(1);
        this.f16304k.setColor(i2);
        this.f16305l = this.f16304k;
        this.f16307n = false;
        float f2 = i4;
        this.f16297d = f2;
        this.f16299f = f2;
        float f3 = i4;
        this.f16298e = f3;
        this.f16300g = f3;
        this.f16306m = i4 / 2.0f;
        this.f16294a = TypedValue.applyDimension(1, (int) Math.max((float) f16293r, f), resources.getDisplayMetrics());
        this.f16303j = this.f16297d;
        this.f16302i = i;
    }

    C3847d(Context context, int i, int i2, int i3, float f, int i4, int i5) {
        this.f16301h = false;
        Resources resources = context.getResources();
        this.f16295b = BitmapFactory.decodeResource(resources, i4);
        this.f16296c = BitmapFactory.decodeResource(resources, i5);
        if (f == -1.0f && i2 == -1 && i3 == -1) {
            this.f16307n = true;
        }
        this.f16310q = this.f16295b.getWidth();
        this.f16297d = this.f16295b.getWidth() / 2.0f;
        this.f16298e = this.f16295b.getHeight() / 2.0f;
        this.f16299f = this.f16296c.getWidth() / 2.0f;
        this.f16300g = this.f16296c.getHeight() / 2.0f;
        this.f16294a = TypedValue.applyDimension(1, (int) Math.max((float) f16293r, f), resources.getDisplayMetrics());
        this.f16303j = this.f16297d;
        this.f16302i = i;
    }

    /* renamed from: a */
    public float m6838a() {
        return this.f16302i;
    }

    /* renamed from: a */
    public void m6837a(float f) {
        this.f16303j = f;
    }

    /* renamed from: a */
    public void m6835a(int i) {
        this.f16302i = i;
    }

    /* renamed from: a */
    public void m6834a(Canvas canvas) {
        if (!this.f16307n) {
            if (this.f16301h) {
                canvas.drawCircle(this.f16303j, this.f16302i, this.f16306m, this.f16305l);
                return;
            } else {
                canvas.drawCircle(this.f16303j, this.f16302i, this.f16306m, this.f16304k);
                return;
            }
        }
        Bitmap bitmap = this.f16301h ? this.f16296c : this.f16295b;
        if (this.f16301h) {
            canvas.drawBitmap(bitmap, this.f16303j - this.f16299f, this.f16302i - this.f16300g, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap, this.f16303j - this.f16297d, this.f16302i - this.f16298e, (Paint) null);
        }
    }

    /* renamed from: a */
    public boolean m6836a(float f, float f2) {
        Log.i("zdy", "" + (((float) this.f16311s) <= this.f16294a + f && f <= ((float) this.f16312t) + this.f16294a) + " " + (Math.abs(f2 - ((float) this.f16302i)) <= this.f16294a) + " " + this.f16311s + " " + f + " " + this.f16312t);
        return ((float) this.f16311s) - this.f16294a <= f && f <= ((float) this.f16312t) + this.f16294a && Math.abs(f2 - ((float) this.f16302i)) <= this.f16294a;
    }

    /* renamed from: b */
    public int m6833b() {
        return this.f16311s;
    }

    /* renamed from: b */
    public void m6832b(int i) {
        this.f16311s = i;
    }

    /* renamed from: c */
    public int m6831c() {
        return this.f16312t;
    }

    /* renamed from: c */
    public void m6830c(int i) {
        this.f16312t = i;
    }

    /* renamed from: d */
    public int m6829d() {
        return this.f16310q;
    }

    /* renamed from: e */
    public float m6828e() {
        return this.f16297d;
    }

    /* renamed from: f */
    public float m6827f() {
        return this.f16298e;
    }

    /* renamed from: g */
    public float m6826g() {
        return this.f16303j;
    }

    /* renamed from: h */
    public boolean m6825h() {
        return this.f16301h;
    }

    /* renamed from: i */
    public void m6824i() {
        this.f16301h = true;
    }

    /* renamed from: j */
    public void m6823j() {
        this.f16301h = false;
    }
}
