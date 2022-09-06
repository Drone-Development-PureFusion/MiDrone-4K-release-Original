package com.fimi.soul.view.circle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.C2353b;
/* loaded from: classes.dex */
public class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f15823a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f15824b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f15825c = 2;

    /* renamed from: d */
    private static final int f15826d = 0;

    /* renamed from: e */
    private static final int f15827e = -16777216;

    /* renamed from: f */
    private final RectF f15828f;

    /* renamed from: g */
    private final RectF f15829g;

    /* renamed from: h */
    private final Matrix f15830h;

    /* renamed from: i */
    private final Paint f15831i;

    /* renamed from: j */
    private final Paint f15832j;

    /* renamed from: k */
    private int f15833k;

    /* renamed from: l */
    private int f15834l;

    /* renamed from: m */
    private Bitmap f15835m;

    /* renamed from: n */
    private BitmapShader f15836n;

    /* renamed from: o */
    private int f15837o;

    /* renamed from: p */
    private int f15838p;

    /* renamed from: q */
    private float f15839q;

    /* renamed from: r */
    private float f15840r;

    /* renamed from: s */
    private boolean f15841s;

    /* renamed from: t */
    private boolean f15842t;

    public CircleImageView(Context context) {
        super(context);
        this.f15828f = new RectF();
        this.f15829g = new RectF();
        this.f15830h = new Matrix();
        this.f15831i = new Paint();
        this.f15832j = new Paint();
        this.f15833k = -16777216;
        this.f15834l = 0;
        m7088a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15828f = new RectF();
        this.f15829g = new RectF();
        this.f15830h = new Matrix();
        this.f15831i = new Paint();
        this.f15832j = new Paint();
        this.f15833k = -16777216;
        this.f15834l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.CircleImageView, i, 0);
        this.f15834l = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f15833k = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        m7088a();
    }

    /* renamed from: a */
    private Bitmap m7087a(Drawable drawable) {
        C2353b.m12509a((drawable instanceof BitmapDrawable) + "|drawable=" + drawable, CircleImageView.class);
        if (drawable == null) {
            return BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.defaultavatar);
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f15824b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f15824b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m7088a() {
        super.setScaleType(f15823a);
        this.f15841s = true;
        if (this.f15842t) {
            m7086b();
            this.f15842t = false;
        }
    }

    /* renamed from: b */
    private void m7086b() {
        if (!this.f15841s) {
            this.f15842t = true;
        } else if (this.f15835m == null) {
        } else {
            this.f15836n = new BitmapShader(this.f15835m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f15831i.setAntiAlias(true);
            this.f15831i.setShader(this.f15836n);
            this.f15832j.setStyle(Paint.Style.STROKE);
            this.f15832j.setAntiAlias(true);
            this.f15832j.setColor(this.f15833k);
            this.f15832j.setStrokeWidth(this.f15834l);
            this.f15838p = this.f15835m.getHeight();
            this.f15837o = this.f15835m.getWidth();
            this.f15829g.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f15840r = Math.min((this.f15829g.height() - this.f15834l) / 2.0f, (this.f15829g.width() - this.f15834l) / 2.0f);
            this.f15828f.set(this.f15834l, this.f15834l, this.f15829g.width() - this.f15834l, this.f15829g.height() - this.f15834l);
            this.f15839q = Math.min(this.f15828f.height() / 2.0f, this.f15828f.width() / 2.0f);
            m7085c();
            invalidate();
        }
    }

    /* renamed from: c */
    private void m7085c() {
        float width;
        float f;
        float f2 = 0.0f;
        this.f15830h.set(null);
        if (this.f15837o * this.f15828f.height() > this.f15828f.width() * this.f15838p) {
            width = this.f15828f.height() / this.f15838p;
            f = (this.f15828f.width() - (this.f15837o * width)) * 0.5f;
        } else {
            width = this.f15828f.width() / this.f15837o;
            f = 0.0f;
            f2 = (this.f15828f.height() - (this.f15838p * width)) * 0.5f;
        }
        this.f15830h.setScale(width, width);
        this.f15830h.postTranslate(((int) (f + 0.5f)) + this.f15834l, ((int) (f2 + 0.5f)) + this.f15834l);
        this.f15836n.setLocalMatrix(this.f15830h);
    }

    public int getBorderColor() {
        return this.f15833k;
    }

    public int getBorderWidth() {
        return this.f15834l;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f15823a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f15839q, this.f15831i);
        if (this.f15834l == 0) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f15840r, this.f15832j);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m7086b();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i == this.f15833k) {
            return;
        }
        this.f15833k = i;
        this.f15832j.setColor(this.f15833k);
        invalidate();
    }

    public void setBorderWidth(int i) {
        if (i == this.f15834l) {
            return;
        }
        this.f15834l = i;
        m7086b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f15835m = bitmap;
        m7086b();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f15835m = m7087a(drawable);
        m7086b();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f15835m = m7087a(getDrawable());
        m7086b();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f15835m = m7087a(getDrawable());
        m7086b();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f15823a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }
}
