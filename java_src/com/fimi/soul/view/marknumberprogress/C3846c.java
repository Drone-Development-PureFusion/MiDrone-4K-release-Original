package com.fimi.soul.view.marknumberprogress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.util.TypedValue;
/* renamed from: com.fimi.soul.view.marknumberprogress.c */
/* loaded from: classes.dex */
class C3846c {

    /* renamed from: r */
    private static final float f16273r = 24.0f;

    /* renamed from: a */
    private float f16274a;

    /* renamed from: b */
    private Bitmap f16275b;

    /* renamed from: c */
    private Bitmap f16276c;

    /* renamed from: d */
    private float f16277d;

    /* renamed from: e */
    private float f16278e;

    /* renamed from: f */
    private float f16279f;

    /* renamed from: g */
    private float f16280g;

    /* renamed from: h */
    private boolean f16281h;

    /* renamed from: i */
    private int f16282i;

    /* renamed from: j */
    private float f16283j;

    /* renamed from: k */
    private Paint f16284k;

    /* renamed from: l */
    private Paint f16285l;

    /* renamed from: m */
    private float f16286m;

    /* renamed from: n */
    private boolean f16287n;

    /* renamed from: o */
    private int f16288o;

    /* renamed from: p */
    private int f16289p;

    /* renamed from: q */
    private int f16290q;

    /* renamed from: s */
    private int f16291s;

    /* renamed from: t */
    private int f16292t;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3846c(Context context, int i, int i2, int i3, float f, int i4) {
        this.f16281h = false;
        Resources resources = context.getResources();
        this.f16284k = new Paint(1);
        this.f16284k.setColor(i2);
        this.f16285l = this.f16284k;
        this.f16287n = false;
        float f2 = i4;
        this.f16277d = f2;
        this.f16279f = f2;
        float f3 = i4;
        this.f16278e = f3;
        this.f16280g = f3;
        this.f16286m = i4 / 2.0f;
        this.f16274a = TypedValue.applyDimension(1, (int) Math.max((float) f16273r, f), resources.getDisplayMetrics());
        this.f16283j = this.f16277d;
        this.f16282i = i;
    }

    C3846c(Context context, int i, int i2, int i3, float f, int i4, int i5) {
        this.f16281h = false;
        Resources resources = context.getResources();
        this.f16275b = BitmapFactory.decodeResource(resources, i4);
        this.f16276c = BitmapFactory.decodeResource(resources, i5);
        if (f == -1.0f && i2 == -1 && i3 == -1) {
            this.f16287n = true;
        }
        this.f16290q = this.f16275b.getWidth();
        this.f16277d = this.f16275b.getWidth() / 2.0f;
        this.f16278e = this.f16275b.getHeight() / 2.0f;
        this.f16279f = this.f16276c.getWidth() / 2.0f;
        this.f16280g = this.f16276c.getHeight() / 2.0f;
        this.f16274a = TypedValue.applyDimension(1, (int) Math.max((float) f16273r, f), resources.getDisplayMetrics());
        this.f16283j = this.f16277d;
        this.f16282i = i;
    }

    /* renamed from: a */
    public float m6854a() {
        return this.f16282i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6853a(float f) {
        this.f16283j = f;
    }

    /* renamed from: a */
    public void m6851a(int i) {
        this.f16282i = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m6850a(Canvas canvas) {
        if (!this.f16287n) {
            if (this.f16281h) {
                canvas.drawCircle(this.f16283j, this.f16282i, this.f16286m, this.f16285l);
                return;
            } else {
                canvas.drawCircle(this.f16283j, this.f16282i, this.f16286m, this.f16284k);
                return;
            }
        }
        Bitmap bitmap = this.f16281h ? this.f16276c : this.f16275b;
        if (this.f16281h) {
            canvas.drawBitmap(bitmap, this.f16283j - this.f16279f, this.f16282i - this.f16280g, (Paint) null);
        } else {
            canvas.drawBitmap(bitmap, this.f16283j - this.f16277d, this.f16282i - this.f16278e, (Paint) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m6852a(float f, float f2) {
        Log.i("zdy", "" + (((float) this.f16291s) <= this.f16274a + f && f <= ((float) this.f16292t) + this.f16274a) + " " + (Math.abs(f2 - ((float) this.f16282i)) <= this.f16274a) + " " + this.f16291s + " " + f + " " + this.f16292t);
        return ((float) this.f16291s) - this.f16274a <= f && f <= ((float) this.f16292t) + this.f16274a && Math.abs(f2 - ((float) this.f16282i)) <= this.f16274a;
    }

    /* renamed from: b */
    public int m6849b() {
        return this.f16291s;
    }

    /* renamed from: b */
    public void m6848b(int i) {
        this.f16291s = i;
    }

    /* renamed from: c */
    public int m6847c() {
        return this.f16292t;
    }

    /* renamed from: c */
    public void m6846c(int i) {
        this.f16292t = i;
    }

    /* renamed from: d */
    public int m6845d() {
        return this.f16290q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public float m6844e() {
        return this.f16277d;
    }

    /* renamed from: f */
    float m6843f() {
        return this.f16278e;
    }

    /* renamed from: g */
    float m6842g() {
        return this.f16283j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean m6841h() {
        return this.f16281h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m6840i() {
        this.f16281h = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m6839j() {
        this.f16281h = false;
    }
}
