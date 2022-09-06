package com.github.moduth.blockcanary.p216ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* renamed from: com.github.moduth.blockcanary.ui.DisplayLeakConnectorView */
/* loaded from: classes.dex */
public final class DisplayLeakConnectorView extends View {

    /* renamed from: a */
    private static final Paint f17030a = new Paint(1);

    /* renamed from: b */
    private static final Paint f17031b = new Paint(1);

    /* renamed from: c */
    private static final Paint f17032c = new Paint(1);

    /* renamed from: d */
    private static final Paint f17033d = new Paint(1);

    /* renamed from: e */
    private EnumC3986a f17034e = EnumC3986a.NODE;

    /* renamed from: f */
    private Bitmap f17035f;

    /* renamed from: com.github.moduth.blockcanary.ui.DisplayLeakConnectorView$a */
    /* loaded from: classes.dex */
    public enum EnumC3986a {
        START,
        NODE,
        END
    }

    static {
        f17030a.setColor(-4539718);
        f17031b.setColor(-8083771);
        f17032c.setColor(-5155506);
        f17033d.setColor(0);
        f17033d.setXfermode(C3988b.f17055d);
    }

    public DisplayLeakConnectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (this.f17035f != null && (this.f17035f.getWidth() != width || this.f17035f.getHeight() != height)) {
            this.f17035f.recycle();
            this.f17035f = null;
        }
        if (this.f17035f == null) {
            this.f17035f = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(this.f17035f);
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            float f3 = width / 3.0f;
            float m6312a = C3988b.m6312a(4.0f, getResources());
            f17030a.setStrokeWidth(m6312a);
            f17031b.setStrokeWidth(m6312a);
            switch (this.f17034e) {
                case NODE:
                    canvas2.drawLine(f, 0.0f, f, height, f17030a);
                    canvas2.drawCircle(f, f2, f, f17030a);
                    canvas2.drawCircle(f, f2, f3, f17033d);
                    break;
                case START:
                    float f4 = f - (m6312a / 2.0f);
                    canvas2.drawRect(0.0f, 0.0f, width, f4, f17031b);
                    canvas2.drawCircle(0.0f, f4, f4, f17033d);
                    canvas2.drawCircle(width, f4, f4, f17033d);
                    canvas2.drawLine(f, 0.0f, f, f2, f17031b);
                    canvas2.drawLine(f, f2, f, height, f17030a);
                    canvas2.drawCircle(f, f2, f, f17030a);
                    canvas2.drawCircle(f, f2, f3, f17033d);
                    break;
                default:
                    canvas2.drawLine(f, 0.0f, f, f2, f17030a);
                    canvas2.drawCircle(f, f2, f3, f17032c);
                    break;
            }
        }
        canvas.drawBitmap(this.f17035f, 0.0f, 0.0f, (Paint) null);
    }

    public void setType(EnumC3986a enumC3986a) {
        if (enumC3986a != this.f17034e) {
            this.f17034e = enumC3986a;
            if (this.f17035f != null) {
                this.f17035f.recycle();
                this.f17035f = null;
            }
            invalidate();
        }
    }
}
