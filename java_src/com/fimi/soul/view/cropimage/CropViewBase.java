package com.fimi.soul.view.cropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
/* loaded from: classes.dex */
public abstract class CropViewBase extends ImageView {

    /* renamed from: g */
    public static final int f15849g = 0;

    /* renamed from: h */
    public static final int f15850h = 1;

    /* renamed from: i */
    public static final int f15851i = 2;

    /* renamed from: n */
    static final float f15852n = 1.25f;

    /* renamed from: o */
    private static final String f15853o = "ImageViewTouchBase";

    /* renamed from: a */
    protected Matrix f15854a;

    /* renamed from: b */
    protected Matrix f15855b;

    /* renamed from: c */
    public final C3792a f15856c;

    /* renamed from: d */
    int f15857d;

    /* renamed from: e */
    int f15858e;

    /* renamed from: f */
    float f15859f;

    /* renamed from: j */
    protected int f15860j;

    /* renamed from: k */
    protected Handler f15861k;

    /* renamed from: l */
    protected int f15862l;

    /* renamed from: m */
    protected int f15863m;

    /* renamed from: p */
    private final Matrix f15864p;

    /* renamed from: q */
    private final float[] f15865q;

    /* renamed from: r */
    private AbstractC3791a f15866r;

    /* renamed from: s */
    private Runnable f15867s;

    /* renamed from: com.fimi.soul.view.cropimage.CropViewBase$a */
    /* loaded from: classes.dex */
    public interface AbstractC3791a {
        /* renamed from: a */
        void m7063a(Bitmap bitmap);
    }

    public CropViewBase(Context context) {
        super(context);
        this.f15854a = new Matrix();
        this.f15855b = new Matrix();
        this.f15864p = new Matrix();
        this.f15865q = new float[9];
        this.f15856c = new C3792a(null);
        this.f15857d = -1;
        this.f15858e = -1;
        this.f15860j = 0;
        this.f15861k = new Handler();
        this.f15867s = null;
        m7064e();
    }

    public CropViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15854a = new Matrix();
        this.f15855b = new Matrix();
        this.f15864p = new Matrix();
        this.f15865q = new float[9];
        this.f15856c = new C3792a(null);
        this.f15857d = -1;
        this.f15858e = -1;
        this.f15860j = 0;
        this.f15861k = new Handler();
        this.f15867s = null;
        m7064e();
    }

    /* renamed from: a */
    private void m7077a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap m7059b = this.f15856c.m7059b();
        this.f15856c.m7060a(bitmap);
        this.f15856c.m7061a(i);
        if (m7059b == null || m7059b == bitmap || this.f15866r == null) {
            return;
        }
        this.f15866r.m7063a(m7059b);
    }

    /* renamed from: a */
    private void m7073a(C3792a c3792a, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        float m7055f = c3792a.m7055f();
        float m7056e = c3792a.m7056e();
        matrix.reset();
        float min = Math.min(Math.min(width / m7055f, 2.0f), Math.min(height / m7056e, 2.0f));
        matrix.postConcat(c3792a.m7058c());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (m7055f * min)) / 2.0f, (height - (m7056e * min)) / 2.0f);
    }

    /* renamed from: e */
    private void m7064e() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: a */
    protected float m7075a(Matrix matrix) {
        return m7074a(matrix, 0);
    }

    /* renamed from: a */
    protected float m7074a(Matrix matrix, int i) {
        matrix.getValues(this.f15865q);
        return this.f15865q[i];
    }

    /* renamed from: a */
    public void m7082a() {
        m7076a((Bitmap) null, true);
    }

    /* renamed from: a */
    protected void m7081a(float f) {
        m7079a(f, getWidth() / 2.0f, getHeight() / 2.0f);
    }

    /* renamed from: a */
    protected void m7080a(float f, float f2) {
        this.f15855b.postTranslate(f, f2);
    }

    /* renamed from: a */
    protected void m7079a(float f, float f2, float f3) {
        if (f > this.f15859f) {
            f = this.f15859f;
        }
        float scale = f / getScale();
        this.f15855b.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        m7071a(true, true);
    }

    /* renamed from: a */
    protected void m7078a(float f, final float f2, final float f3, final float f4) {
        final float scale = (f - getScale()) / f4;
        final float scale2 = getScale();
        final long currentTimeMillis = System.currentTimeMillis();
        this.f15861k.post(new Runnable() { // from class: com.fimi.soul.view.cropimage.CropViewBase.2
            @Override // java.lang.Runnable
            public void run() {
                float min = Math.min(f4, (float) (System.currentTimeMillis() - currentTimeMillis));
                CropViewBase.this.m7079a(scale2 + (scale * min), f2, f3);
                if (min < f4) {
                    CropViewBase.this.f15861k.post(this);
                }
            }
        });
    }

    /* renamed from: a */
    public void m7076a(Bitmap bitmap, boolean z) {
        m7072a(new C3792a(bitmap), z);
    }

    /* renamed from: a */
    public void m7072a(final C3792a c3792a, final boolean z) {
        if (getWidth() <= 0) {
            this.f15867s = new Runnable() { // from class: com.fimi.soul.view.cropimage.CropViewBase.1
                @Override // java.lang.Runnable
                public void run() {
                    CropViewBase.this.m7072a(c3792a, z);
                }
            };
            return;
        }
        if (c3792a.m7059b() != null) {
            m7073a(c3792a, this.f15854a);
            m7077a(c3792a.m7059b(), c3792a.m7062a());
        } else {
            this.f15854a.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f15855b.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.f15859f = m7070b();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m7071a(boolean z, boolean z2) {
        float f;
        float f2 = 0.0f;
        if (this.f15856c.m7059b() == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, this.f15856c.m7059b().getWidth(), this.f15856c.m7059b().getHeight());
        imageViewMatrix.mapRect(rectF);
        float height = rectF.height();
        float width = rectF.width();
        if (z2) {
            int height2 = getHeight();
            if (height < height2) {
                f = ((height2 - height) / 2.0f) - rectF.top;
            } else if (rectF.top > 0.0f) {
                f = -rectF.top;
            } else if (rectF.bottom < height2) {
                f = getHeight() - rectF.bottom;
            }
            if (z) {
                int width2 = getWidth();
                if (width < width2) {
                    f2 = ((width2 - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f2 = -rectF.left;
                } else if (rectF.right < width2) {
                    f2 = width2 - rectF.right;
                }
            }
            m7080a(f2, f);
            setImageMatrix(getImageViewMatrix());
        }
        f = 0.0f;
        if (z) {
        }
        m7080a(f2, f);
        setImageMatrix(getImageViewMatrix());
    }

    /* renamed from: b */
    protected float m7070b() {
        if (this.f15856c.m7059b() == null) {
            return 1.0f;
        }
        float max = Math.max(this.f15856c.m7055f() / this.f15857d, this.f15856c.m7056e() / this.f15858e) * 4.0f;
        if (max < 1.0f) {
            return 1.0f;
        }
        return max;
    }

    /* renamed from: b */
    protected void m7069b(float f) {
        if (getScale() < this.f15859f && this.f15856c.m7059b() != null) {
            this.f15855b.postScale(f, f, getWidth() / 2.0f, getHeight() / 2.0f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    /* renamed from: b */
    protected void m7068b(float f, float f2) {
        m7080a(f, f2);
        setImageMatrix(getImageViewMatrix());
    }

    /* renamed from: c */
    protected void m7067c() {
        m7069b(f15852n);
    }

    /* renamed from: c */
    protected void m7066c(float f) {
        if (this.f15856c.m7059b() == null) {
            return;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        Matrix matrix = new Matrix(this.f15855b);
        matrix.postScale(1.0f / f, 1.0f / f, width, height);
        if (m7075a(matrix) < 1.0f) {
            this.f15855b.setScale(1.0f, 1.0f, width, height);
        } else {
            this.f15855b.postScale(1.0f / f, 1.0f / f, width, height);
        }
        setImageMatrix(getImageViewMatrix());
        m7071a(true, true);
    }

    /* renamed from: d */
    protected void m7065d() {
        m7066c(f15852n);
    }

    protected Matrix getImageViewMatrix() {
        this.f15864p.set(this.f15854a);
        this.f15864p.postConcat(this.f15855b);
        return this.f15864p;
    }

    public float getScale() {
        return m7075a(this.f15855b);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || getScale() <= 1.0f) {
            return super.onKeyDown(i, keyEvent);
        }
        m7081a(1.0f);
        return true;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f15857d = i3 - i;
        this.f15858e = i4 - i2;
        Runnable runnable = this.f15867s;
        if (runnable != null) {
            this.f15867s = null;
            runnable.run();
        }
        if (this.f15856c.m7059b() != null) {
            m7073a(this.f15856c, this.f15854a);
            setImageMatrix(getImageViewMatrix());
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m7077a(bitmap, 0);
    }

    public void setRecycler(AbstractC3791a abstractC3791a) {
        this.f15866r = abstractC3791a;
    }
}
