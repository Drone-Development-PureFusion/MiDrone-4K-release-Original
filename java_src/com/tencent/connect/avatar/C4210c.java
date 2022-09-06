package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
/* renamed from: com.tencent.connect.avatar.c */
/* loaded from: classes.dex */
public class C4210c extends ImageView {

    /* renamed from: h */
    private Bitmap f17469h;

    /* renamed from: j */
    private float f17471j;

    /* renamed from: k */
    private float f17472k;

    /* renamed from: c */
    private Matrix f17464c = new Matrix();

    /* renamed from: d */
    private Matrix f17465d = new Matrix();

    /* renamed from: e */
    private int f17466e = 0;

    /* renamed from: f */
    private float f17467f = 1.0f;

    /* renamed from: g */
    private float f17468g = 1.0f;

    /* renamed from: i */
    private boolean f17470i = false;

    /* renamed from: a */
    final String f17462a = "TouchView";

    /* renamed from: l */
    private PointF f17473l = new PointF();

    /* renamed from: m */
    private PointF f17474m = new PointF();

    /* renamed from: n */
    private float f17475n = 1.0f;

    /* renamed from: o */
    private float f17476o = 0.0f;

    /* renamed from: b */
    public boolean f17463b = false;

    /* renamed from: p */
    private Rect f17477p = new Rect();

    public C4210c(Context context) {
        super(context);
        getDrawingRect(this.f17477p);
        m5855a();
    }

    /* renamed from: a */
    private float m5852a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    /* renamed from: a */
    private void m5855a() {
    }

    /* renamed from: a */
    private void m5854a(PointF pointF) {
        float f = 1.0f;
        if (this.f17469h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f17464c.getValues(fArr);
        float f2 = fArr[2];
        float f3 = fArr[5];
        float f4 = fArr[0];
        float width = this.f17469h.getWidth() * f4;
        float height = this.f17469h.getHeight() * f4;
        float f5 = this.f17477p.left - f2;
        if (f5 <= 1.0f) {
            f5 = 1.0f;
        }
        float f6 = (f2 + width) - this.f17477p.right;
        if (f6 <= 1.0f) {
            f6 = 1.0f;
        }
        float width2 = ((f5 * this.f17477p.width()) / (f6 + f5)) + this.f17477p.left;
        float f7 = this.f17477p.top - f3;
        float f8 = (f3 + height) - this.f17477p.bottom;
        if (f7 <= 1.0f) {
            f7 = 1.0f;
        }
        if (f8 > 1.0f) {
            f = f8;
        }
        pointF.set(width2, ((this.f17477p.height() * f7) / (f7 + f)) + this.f17477p.top);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5849b() {
        if (this.f17469h == null) {
            return;
        }
        float width = this.f17477p.width();
        float height = this.f17477p.height();
        float[] fArr = new float[9];
        this.f17464c.getValues(fArr);
        float f = fArr[2];
        float f2 = fArr[5];
        float f3 = fArr[0];
        Animation animation = null;
        if (f3 > this.f17467f) {
            this.f17476o = this.f17467f / f3;
            this.f17464c.postScale(this.f17476o, this.f17476o, this.f17474m.x, this.f17474m.y);
            setImageMatrix(this.f17464c);
            animation = new ScaleAnimation(1.0f / this.f17476o, 1.0f, 1.0f / this.f17476o, 1.0f, this.f17474m.x, this.f17474m.y);
        } else if (f3 < this.f17468g) {
            this.f17476o = this.f17468g / f3;
            this.f17464c.postScale(this.f17476o, this.f17476o, this.f17474m.x, this.f17474m.y);
            animation = new ScaleAnimation(1.0f, this.f17476o, 1.0f, this.f17476o, this.f17474m.x, this.f17474m.y);
        } else {
            boolean z = false;
            float width2 = this.f17469h.getWidth() * f3;
            float height2 = f3 * this.f17469h.getHeight();
            float f4 = this.f17477p.left - f;
            float f5 = this.f17477p.top - f2;
            if (f4 < 0.0f) {
                f = this.f17477p.left;
                z = true;
            }
            if (f5 < 0.0f) {
                f2 = this.f17477p.top;
                z = true;
            }
            float f6 = height2 - f5;
            if (width2 - f4 < width) {
                f = this.f17477p.left - (width2 - width);
                z = true;
            }
            if (f6 < height) {
                f2 = this.f17477p.top - (height2 - height);
                z = true;
            }
            if (z) {
                float f7 = fArr[2] - f;
                float f8 = fArr[5] - f2;
                fArr[2] = f;
                fArr[5] = f2;
                this.f17464c.setValues(fArr);
                setImageMatrix(this.f17464c);
                animation = new TranslateAnimation(f7, 0.0f, f8, 0.0f);
            } else {
                setImageMatrix(this.f17464c);
            }
        }
        if (animation == null) {
            return;
        }
        this.f17470i = true;
        animation.setDuration(300L);
        startAnimation(animation);
        new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                C4210c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C4210c.this.clearAnimation();
                        C4210c.this.m5849b();
                    }
                });
                C4210c.this.f17470i = false;
            }
        }).start();
    }

    /* renamed from: c */
    private void m5848c() {
        if (this.f17469h == null) {
            return;
        }
        this.f17464c.getValues(r0);
        float max = Math.max(this.f17477p.width() / this.f17469h.getWidth(), this.f17477p.height() / this.f17469h.getHeight());
        this.f17471j = this.f17477p.left - (((this.f17469h.getWidth() * max) - this.f17477p.width()) / 2.0f);
        this.f17472k = this.f17477p.top - (((this.f17469h.getHeight() * max) - this.f17477p.height()) / 2.0f);
        float[] fArr = {max, 0.0f, this.f17471j, 0.0f, max, this.f17472k};
        this.f17464c.setValues(fArr);
        this.f17467f = Math.min(2048.0f / this.f17469h.getWidth(), 2048.0f / this.f17469h.getHeight());
        this.f17468g = max;
        if (this.f17467f < this.f17468g) {
            this.f17467f = this.f17468g;
        }
        setImageMatrix(this.f17464c);
    }

    /* renamed from: a */
    public void m5853a(Rect rect) {
        this.f17477p = rect;
        if (this.f17469h != null) {
            m5848c();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f17470i) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f17464c.set(getImageMatrix());
                    this.f17465d.set(this.f17464c);
                    this.f17473l.set(motionEvent.getX(), motionEvent.getY());
                    this.f17466e = 1;
                    break;
                case 1:
                case 6:
                    m5849b();
                    this.f17466e = 0;
                    break;
                case 2:
                    if (this.f17466e != 1) {
                        if (this.f17466e == 2) {
                            this.f17464c.set(this.f17464c);
                            float m5852a = m5852a(motionEvent);
                            if (m5852a > 10.0f) {
                                this.f17464c.set(this.f17465d);
                                float f = m5852a / this.f17475n;
                                this.f17464c.postScale(f, f, this.f17474m.x, this.f17474m.y);
                            }
                            setImageMatrix(this.f17464c);
                            break;
                        }
                    } else {
                        this.f17464c.set(this.f17465d);
                        this.f17464c.postTranslate(motionEvent.getX() - this.f17473l.x, motionEvent.getY() - this.f17473l.y);
                        setImageMatrix(this.f17464c);
                        break;
                    }
                    break;
                case 5:
                    this.f17475n = m5852a(motionEvent);
                    if (this.f17475n > 10.0f) {
                        this.f17465d.set(this.f17464c);
                        m5854a(this.f17474m);
                        this.f17466e = 2;
                        break;
                    }
                    break;
            }
            this.f17463b = true;
        }
        return true;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f17469h = bitmap;
        if (bitmap != null) {
            this.f17469h = bitmap;
        }
    }
}
