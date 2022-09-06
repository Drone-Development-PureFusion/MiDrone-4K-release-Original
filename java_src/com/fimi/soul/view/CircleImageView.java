package com.fimi.soul.view;

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
/* loaded from: classes.dex */
public class CircleImageView extends ImageView {

    /* renamed from: a */
    private static final ImageView.ScaleType f15257a = ImageView.ScaleType.CENTER_CROP;

    /* renamed from: b */
    private static final Bitmap.Config f15258b = Bitmap.Config.ARGB_8888;

    /* renamed from: c */
    private static final int f15259c = 2;

    /* renamed from: d */
    private static final int f15260d = 0;

    /* renamed from: e */
    private static final int f15261e = -16777216;

    /* renamed from: f */
    private final RectF f15262f;

    /* renamed from: g */
    private final RectF f15263g;

    /* renamed from: h */
    private final Matrix f15264h;

    /* renamed from: i */
    private final Paint f15265i;

    /* renamed from: j */
    private final Paint f15266j;

    /* renamed from: k */
    private int f15267k;

    /* renamed from: l */
    private int f15268l;

    /* renamed from: m */
    private Bitmap f15269m;

    /* renamed from: n */
    private BitmapShader f15270n;

    /* renamed from: o */
    private int f15271o;

    /* renamed from: p */
    private int f15272p;

    /* renamed from: q */
    private float f15273q;

    /* renamed from: r */
    private float f15274r;

    /* renamed from: s */
    private boolean f15275s;

    /* renamed from: t */
    private boolean f15276t;

    public CircleImageView(Context context) {
        super(context);
        this.f15262f = new RectF();
        this.f15263g = new RectF();
        this.f15264h = new Matrix();
        this.f15265i = new Paint();
        this.f15266j = new Paint();
        this.f15267k = -16777216;
        this.f15268l = 0;
        m7344a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15262f = new RectF();
        this.f15263g = new RectF();
        this.f15264h = new Matrix();
        this.f15265i = new Paint();
        this.f15266j = new Paint();
        this.f15267k = -16777216;
        this.f15268l = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2300R.styleable.CircleImageView, i, 0);
        this.f15268l = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f15267k = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        m7344a();
    }

    /* renamed from: a */
    private Bitmap m7343a(Drawable drawable) {
        if (drawable == null) {
            return BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.defaultavatar);
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, f15258b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f15258b);
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
    private void m7344a() {
        super.setScaleType(f15257a);
        this.f15275s = true;
        if (this.f15276t) {
            m7342b();
            this.f15276t = false;
        }
    }

    /* renamed from: b */
    private void m7342b() {
        if (!this.f15275s) {
            this.f15276t = true;
        } else if (this.f15269m == null) {
        } else {
            this.f15270n = new BitmapShader(this.f15269m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f15265i.setAntiAlias(true);
            this.f15265i.setShader(this.f15270n);
            this.f15266j.setStyle(Paint.Style.STROKE);
            this.f15266j.setAntiAlias(true);
            this.f15266j.setColor(this.f15267k);
            this.f15266j.setStrokeWidth(this.f15268l);
            this.f15272p = this.f15269m.getHeight();
            this.f15271o = this.f15269m.getWidth();
            this.f15263g.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f15274r = Math.min((this.f15263g.height() - this.f15268l) / 2.0f, (this.f15263g.width() - this.f15268l) / 2.0f);
            this.f15262f.set(this.f15268l, this.f15268l, this.f15263g.width() - this.f15268l, this.f15263g.height() - this.f15268l);
            this.f15273q = Math.min(this.f15262f.height() / 2.0f, this.f15262f.width() / 2.0f);
            m7341c();
            invalidate();
        }
    }

    /* renamed from: c */
    private void m7341c() {
        float width;
        float f;
        float f2 = 0.0f;
        this.f15264h.set(null);
        if (this.f15271o * this.f15262f.height() > this.f15262f.width() * this.f15272p) {
            width = this.f15262f.height() / this.f15272p;
            f = (this.f15262f.width() - (this.f15271o * width)) * 0.5f;
        } else {
            width = this.f15262f.width() / this.f15271o;
            f = 0.0f;
            f2 = (this.f15262f.height() - (this.f15272p * width)) * 0.5f;
        }
        this.f15264h.setScale(width, width);
        this.f15264h.postTranslate(((int) (f + 0.5f)) + this.f15268l, ((int) (f2 + 0.5f)) + this.f15268l);
        this.f15270n.setLocalMatrix(this.f15264h);
    }

    public int getBorderColor() {
        return this.f15267k;
    }

    public int getBorderWidth() {
        return this.f15268l;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return f15257a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f15273q, this.f15265i);
        if (this.f15268l == 0) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f15274r, this.f15266j);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m7342b();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i == this.f15267k) {
            return;
        }
        this.f15267k = i;
        this.f15266j.setColor(this.f15267k);
        invalidate();
    }

    public void setBorderWidth(int i) {
        if (i == this.f15268l) {
            return;
        }
        this.f15268l = i;
        m7342b();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f15269m = bitmap;
        m7342b();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f15269m = m7343a(drawable);
        m7342b();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f15269m = m7343a(getDrawable());
        m7342b();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f15269m = m7343a(getDrawable());
        m7342b();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != f15257a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }
}
