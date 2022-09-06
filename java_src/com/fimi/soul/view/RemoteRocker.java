package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class RemoteRocker extends View {

    /* renamed from: h */
    private static final float f15421h = 0.2373f;

    /* renamed from: i */
    private static final float f15422i = 0.228f;

    /* renamed from: a */
    private Paint f15423a;

    /* renamed from: b */
    private Bitmap f15424b;

    /* renamed from: c */
    private Paint f15425c;

    /* renamed from: d */
    private RectF f15426d;

    /* renamed from: e */
    private RectF f15427e;

    /* renamed from: f */
    private RectF f15428f;

    /* renamed from: g */
    private RectF f15429g;

    /* renamed from: k */
    private EnumC3728a f15431k;

    /* renamed from: j */
    private float f15430j = -90.0f;

    /* renamed from: l */
    private float f15432l = 0.0f;

    /* renamed from: m */
    private float f15433m = 0.0f;

    /* renamed from: n */
    private float f15434n = 0.0f;

    /* renamed from: o */
    private float f15435o = 0.0f;

    /* renamed from: com.fimi.soul.view.RemoteRocker$a */
    /* loaded from: classes.dex */
    public enum EnumC3728a {
        LEFT,
        RIGHT
    }

    public RemoteRocker(Context context) {
        super(context);
        m7262b();
    }

    public RemoteRocker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7262b();
    }

    public RemoteRocker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7262b();
    }

    /* renamed from: b */
    private void m7262b() {
        this.f15423a = new Paint();
        this.f15425c = new Paint();
    }

    /* renamed from: a */
    public void m7263a() {
        if (this.f15424b != null) {
            this.f15424b.recycle();
            this.f15424b = null;
            System.gc();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        if (this.f15424b == null) {
            setRemoteRocker(this.f15431k);
        }
        canvas.drawBitmap(this.f15424b, (Rect) null, rectF, this.f15423a);
        canvas.drawArc(this.f15426d, this.f15430j, this.f15432l, false, this.f15425c);
        canvas.drawArc(this.f15427e, this.f15430j, this.f15433m, false, this.f15425c);
        canvas.drawArc(this.f15428f, this.f15430j, this.f15435o, false, this.f15425c);
        canvas.drawArc(this.f15429g, this.f15430j, this.f15434n, false, this.f15425c);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15425c.setStrokeWidth(getWidth() * 0.0046499968f);
        this.f15425c.setColor(-14172853);
        this.f15425c.setAntiAlias(true);
        this.f15425c.setStyle(Paint.Style.STROKE);
        this.f15426d = new RectF((getWidth() / 2) - ((getWidth() * f15422i) / 2.0f), (getWidth() * 0.0092999935f) / 2.0f, (getWidth() / 2) + ((getWidth() * f15422i) / 2.0f), getWidth() * 0.23265f);
        this.f15427e = new RectF((getWidth() * 0.0092999935f) / 2.0f, (getWidth() / 2) - ((getWidth() * f15422i) / 2.0f), getWidth() * 0.23265f, (getWidth() / 2.0f) + ((getWidth() * f15422i) / 2.0f));
        this.f15428f = new RectF(getWidth() - (getWidth() * 0.23265f), (getWidth() / 2) - ((getWidth() * f15422i) / 2.0f), getWidth() - (getWidth() * 0.0046499968f), (getWidth() / 2.0f) + ((getWidth() * f15422i) / 2.0f));
        this.f15429g = new RectF((getWidth() / 2) - ((getWidth() * f15422i) / 2.0f), getWidth() - (getWidth() * 0.23265f), (getWidth() / 2) + ((getWidth() * f15422i) / 2.0f), getWidth() - ((getWidth() * 0.0092999935f) / 2.0f));
    }

    public void setBottomSweepAngle(float f) {
        this.f15435o = f;
        if (this.f15433m < 360.0f) {
            this.f15433m = 0.0f;
        }
        if (this.f15434n < 360.0f) {
            this.f15434n = 0.0f;
        }
        if (this.f15432l < 360.0f) {
            this.f15432l = 0.0f;
        }
        invalidate();
    }

    public void setLeftSweepAngle(float f) {
        this.f15433m = f;
        if (this.f15432l < 360.0f) {
            this.f15432l = 0.0f;
        }
        if (this.f15434n < 360.0f) {
            this.f15434n = 0.0f;
        }
        if (this.f15435o < 360.0f) {
            this.f15435o = 0.0f;
        }
        invalidate();
    }

    public void setRemoteRocker(EnumC3728a enumC3728a) {
        this.f15431k = enumC3728a;
        switch (enumC3728a) {
            case LEFT:
                this.f15424b = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.newbie_left_rocker_bg);
                return;
            case RIGHT:
                this.f15424b = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.newbie_right_rocker_bg);
                return;
            default:
                return;
        }
    }

    public void setRightSweepAngle(float f) {
        this.f15434n = f;
        if (this.f15433m < 360.0f) {
            this.f15433m = 0.0f;
        }
        if (this.f15432l < 360.0f) {
            this.f15432l = 0.0f;
        }
        if (this.f15435o < 360.0f) {
            this.f15435o = 0.0f;
        }
        invalidate();
    }

    public void setTopSweepAngle(float f) {
        this.f15432l = f;
        if (this.f15433m < 360.0f) {
            this.f15433m = 0.0f;
        }
        if (this.f15434n < 360.0f) {
            this.f15434n = 0.0f;
        }
        if (this.f15435o < 360.0f) {
            this.f15435o = 0.0f;
        }
        invalidate();
    }
}
