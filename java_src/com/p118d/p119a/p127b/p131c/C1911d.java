package com.p118d.p119a.p127b.p131c;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.p118d.p119a.p127b.p128a.EnumC1894f;
import com.p118d.p119a.p127b.p131c.C1909c;
import com.p118d.p119a.p127b.p133e.AbstractC1926a;
import com.p118d.p119a.p127b.p133e.C1927b;
/* renamed from: com.d.a.b.c.d */
/* loaded from: classes.dex */
public class C1911d extends C1909c {

    /* renamed from: com.d.a.b.c.d$a */
    /* loaded from: classes.dex */
    protected static class C1912a extends C1909c.C1910a {
        C1912a(Bitmap bitmap, int i, int i2) {
            super(bitmap, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.p118d.p119a.p127b.p131c.C1909c.C1910a, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RadialGradient radialGradient = new RadialGradient(this.f6762c.centerX(), (this.f6762c.centerY() * 1.0f) / 0.7f, this.f6762c.centerX() * 1.3f, new int[]{0, 0, 2130706432}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.f6765f.setShader(new ComposeShader(this.f6764e, radialGradient, PorterDuff.Mode.SRC_OVER));
        }
    }

    public C1911d(int i, int i2) {
        super(i, i2);
    }

    @Override // com.p118d.p119a.p127b.p131c.C1909c, com.p118d.p119a.p127b.p131c.AbstractC1907a
    /* renamed from: a */
    public void mo14037a(Bitmap bitmap, AbstractC1926a abstractC1926a, EnumC1894f enumC1894f) {
        if (!(abstractC1926a instanceof C1927b)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        abstractC1926a.mo13925a(new C1912a(bitmap, this.f6758a, this.f6759b));
    }
}
