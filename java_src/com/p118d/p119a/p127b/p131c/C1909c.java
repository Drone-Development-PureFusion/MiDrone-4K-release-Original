package com.p118d.p119a.p127b.p131c;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
import com.p118d.p119a.p127b.p133e.C1927b;
/* renamed from: com.d.a.b.c.c */
/* loaded from: classes.dex */
public class C1909c implements AbstractC1907a {

    /* renamed from: a */
    protected final int f6758a;

    /* renamed from: b */
    protected final int f6759b;

    /* renamed from: com.d.a.b.c.c$a */
    /* loaded from: classes.dex */
    public static class C1910a extends Drawable {

        /* renamed from: a */
        protected final float f6760a;

        /* renamed from: b */
        protected final int f6761b;

        /* renamed from: d */
        protected final RectF f6763d;

        /* renamed from: e */
        protected final BitmapShader f6764e;

        /* renamed from: c */
        protected final RectF f6762c = new RectF();

        /* renamed from: f */
        protected final Paint f6765f = new Paint();

        public C1910a(Bitmap bitmap, int i, int i2) {
            this.f6760a = i;
            this.f6761b = i2;
            this.f6764e = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.f6763d = new RectF(i2, i2, bitmap.getWidth() - i2, bitmap.getHeight() - i2);
            this.f6765f.setAntiAlias(true);
            this.f6765f.setShader(this.f6764e);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawRoundRect(this.f6762c, this.f6760a, this.f6760a, this.f6765f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.f6762c.set(this.f6761b, this.f6761b, rect.width() - this.f6761b, rect.height() - this.f6761b);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f6763d, this.f6762c, Matrix.ScaleToFit.FILL);
            this.f6764e.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.f6765f.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f6765f.setColorFilter(colorFilter);
        }
    }

    public C1909c(int i) {
        this(i, 0);
    }

    public C1909c(int i, int i2) {
        this.f6758a = i;
        this.f6759b = i2;
    }

    @Override // com.p118d.p119a.p127b.p131c.AbstractC1907a
    /* renamed from: a */
    public void mo14037a(Bitmap bitmap, AbstractC1926a abstractC1926a, EnumC1894f enumC1894f) {
        if (!(abstractC1926a instanceof C1927b)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        abstractC1926a.mo13925a(new C1910a(bitmap, this.f6758a, this.f6759b));
    }
}
