package com.fimi.soul.view.circle;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
/* renamed from: com.fimi.soul.view.circle.a */
/* loaded from: classes.dex */
public class C3788a extends Drawable {

    /* renamed from: a */
    public static final String f15843a = "CircleDrawable";

    /* renamed from: b */
    protected final Paint f15844b;

    /* renamed from: c */
    protected final int f15845c;

    /* renamed from: d */
    protected final BitmapShader f15846d;

    /* renamed from: e */
    protected float f15847e;

    /* renamed from: f */
    protected Bitmap f15848f;

    public C3788a(Bitmap bitmap) {
        this(bitmap, 0);
    }

    public C3788a(Bitmap bitmap, int i) {
        this.f15845c = i;
        this.f15848f = bitmap;
        this.f15846d = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.f15844b = new Paint();
        this.f15844b.setAntiAlias(true);
        this.f15844b.setShader(this.f15846d);
    }

    /* renamed from: a */
    public void m7084a() {
        Rect bounds = getBounds();
        if (bounds == null) {
            return;
        }
        Matrix matrix = new Matrix();
        float width = bounds.width() / this.f15848f.getWidth();
        float height = bounds.height() / this.f15848f.getHeight();
        if (width <= height) {
            width = height;
        }
        matrix.postScale(width, width);
        this.f15846d.setLocalMatrix(matrix);
    }

    /* renamed from: b */
    public void m7083b() {
        Rect bounds = getBounds();
        this.f15847e = bounds.width() < bounds.height() ? (bounds.width() / 2.0f) - this.f15845c : (bounds.height() / 2.0f) - this.f15845c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.width() / 2.0f, bounds.height() / 2.0f, this.f15847e, this.f15844b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m7084a();
        m7083b();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f15844b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15844b.setColorFilter(colorFilter);
    }
}
