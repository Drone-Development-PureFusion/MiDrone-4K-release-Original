package com.fimi.soul.module.droneFragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3678g;
import java.util.Iterator;
/* loaded from: classes.dex */
public class SectorProgressBar extends View {

    /* renamed from: d */
    private static int f11608d = 944;

    /* renamed from: e */
    private static final int f11609e = 10;

    /* renamed from: c */
    ObjectAnimator f11612c;

    /* renamed from: k */
    private Paint f11618k;

    /* renamed from: m */
    private int f11620m;

    /* renamed from: n */
    private int f11621n;

    /* renamed from: p */
    private Context f11623p;

    /* renamed from: s */
    private AnimatorSet f11626s;

    /* renamed from: f */
    private Bitmap f11613f = null;

    /* renamed from: g */
    private float f11614g = 0.0f;

    /* renamed from: h */
    private float f11615h = 40.0f;

    /* renamed from: i */
    private RectF f11616i = null;

    /* renamed from: j */
    private PorterDuffXfermode f11617j = null;

    /* renamed from: l */
    private EnumC3102a f11619l = EnumC3102a.LeftBottom;

    /* renamed from: o */
    private boolean f11622o = false;

    /* renamed from: q */
    private float f11624q = 0.0f;

    /* renamed from: r */
    private float f11625r = 0.0f;

    /* renamed from: a */
    boolean f11610a = true;

    /* renamed from: b */
    float f11611b = 0.0f;

    /* renamed from: com.fimi.soul.module.droneFragment.SectorProgressBar$a */
    /* loaded from: classes.dex */
    public enum EnumC3102a {
        LeftTop,
        LeftBottom,
        RightTop,
        RightBottom,
        RightToplow,
        RightBottomSatt
    }

    public SectorProgressBar(Context context) {
        super(context);
        this.f11623p = context;
        m9653c();
    }

    public SectorProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11623p = context;
        m9653c();
    }

    public SectorProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11623p = context;
        m9653c();
    }

    /* renamed from: c */
    private void m9653c() {
        this.f11625r = getResources().getDisplayMetrics().density;
        this.f11618k = new Paint();
        this.f11618k.setAntiAlias(true);
        setLayerType(2, this.f11618k);
        f11608d = (getResources().getDisplayMetrics().widthPixels / 2) - C3678g.m7486b(this.f11623p, 16.0f);
        setSectorProgressBarType(this.f11619l);
    }

    /* renamed from: a */
    public void m9658a() {
        if (this.f11626s != null) {
            Iterator<Animator> it2 = this.f11626s.getChildAnimations().iterator();
            while (it2.hasNext()) {
                it2.next().cancel();
            }
            this.f11626s.cancel();
            this.f11626s = null;
        }
    }

    /* renamed from: a */
    public void m9657a(float f) {
        if (this.f11612c == null) {
            this.f11612c = new ObjectAnimator();
            this.f11612c.setTarget(this);
            this.f11612c.setPropertyName("float");
            this.f11612c.setEvaluator(new FloatEvaluator());
            this.f11612c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.module.droneFragment.SectorProgressBar.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SectorProgressBar.this.f11624q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SectorProgressBar.this.postInvalidate();
                }
            });
        }
        if (!this.f11612c.isRunning()) {
            this.f11612c.setObjectValues(Float.valueOf(this.f11611b), Float.valueOf(f));
            this.f11611b = f;
            this.f11612c.setDuration(200L);
            this.f11612c.start();
        }
    }

    /* renamed from: a */
    public void m9656a(int i, int i2) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this, "float", new FloatEvaluator(), Integer.valueOf(i2), 100);
        this.f11611b = this.f11624q;
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.module.droneFragment.SectorProgressBar.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SectorProgressBar.this.f11624q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SectorProgressBar.this.invalidate();
            }
        });
        ObjectAnimator ofObject2 = ObjectAnimator.ofObject(this, "float", new FloatEvaluator(), 100, Integer.valueOf(i2));
        ofObject2.setInterpolator(new OvershootInterpolator());
        ofObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.module.droneFragment.SectorProgressBar.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SectorProgressBar.this.f11624q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SectorProgressBar.this.invalidate();
            }
        });
        this.f11626s = new AnimatorSet();
        this.f11626s.play(ofObject2).after(ofObject);
        this.f11626s.setDuration(i);
        this.f11626s.start();
    }

    /* renamed from: b */
    public void m9654b() {
        if (this.f11612c != null) {
            this.f11612c.cancel();
            this.f11612c = null;
        }
    }

    public float getProgress() {
        return this.f11624q;
    }

    public EnumC3102a getSectorProgressBarType() {
        return this.f11619l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        this.f11620m = canvas.getWidth();
        this.f11621n = canvas.getHeight();
        if (!this.f11622o) {
            m9653c();
            this.f11622o = true;
        }
        switch (this.f11619l) {
            case RightToplow:
                this.f11617j = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
                f = (((-this.f11624q) / 100.0f) * 50.0f) + 50.0f;
                break;
            case LeftBottom:
                this.f11617j = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
                f = (((-this.f11624q) / 100.0f) * 50.0f) + 50.0f;
                break;
            case RightBottomSatt:
                this.f11617j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
                f = (this.f11624q / 100.0f) * 50.0f;
                break;
            case RightBottom:
                this.f11617j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
                f = (this.f11624q / 100.0f) * 50.0f;
                break;
            case RightTop:
                this.f11617j = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
                f = (((-this.f11624q) / 100.0f) * 50.0f) + 50.0f;
                break;
            case LeftTop:
                this.f11617j = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
                f = (this.f11624q / 100.0f) * 50.0f;
                break;
            default:
                f = 0.0f;
                break;
        }
        RectF rectF = new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.drawArc(this.f11616i, this.f11614g, this.f11615h + f, true, this.f11618k);
        this.f11618k.setXfermode(this.f11617j);
        canvas.drawBitmap(this.f11613f, (Rect) null, rectF, this.f11618k);
        if (this.f11613f != null && this.f11613f.isRecycled()) {
            this.f11613f.recycle();
        }
        this.f11618k.setXfermode(null);
        if (this.f11610a) {
            this.f11610a = false;
            m9657a(100.0f);
        }
    }

    public void setProgress(float f) {
        this.f11624q = f;
    }

    public void setSectorProgressBarType(EnumC3102a enumC3102a) {
        switch (enumC3102a) {
            case RightToplow:
                this.f11616i = new RectF((this.f11620m - 10) - (f11608d * 2), (-f11608d) + this.f11621n, this.f11620m - 10, f11608d + this.f11621n);
                this.f11613f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.lowpower);
                this.f11614g = -90.0f;
                this.f11615h = 40.0f;
                break;
            case LeftBottom:
                this.f11616i = new RectF(10.0f, -f11608d, (f11608d * 2) + 10, f11608d);
                this.f11613f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.distance);
                this.f11614g = 90.0f;
                this.f11615h = 40.0f;
                break;
            case RightBottomSatt:
                this.f11616i = new RectF((this.f11620m - 10) - (f11608d * 2), -f11608d, this.f11620m - 10, f11608d);
                this.f11613f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.gpssign);
                this.f11614g = 0.0f;
                this.f11615h = 0.0f;
                break;
            case RightBottom:
                this.f11616i = new RectF((this.f11620m - 10) - (f11608d * 2), -f11608d, this.f11620m - 10, f11608d);
                this.f11613f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.sign);
                this.f11614g = 0.0f;
                this.f11615h = 0.0f;
                break;
            case RightTop:
                this.f11616i = new RectF((this.f11620m - 10) - (f11608d * 2), (-f11608d) + this.f11621n, this.f11620m - 10, f11608d + this.f11621n);
                this.f11613f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.fullpower);
                this.f11614g = -90.0f;
                this.f11615h = 40.0f;
                break;
            case LeftTop:
                this.f11616i = new RectF(10.0f, (-f11608d) + this.f11621n, (f11608d * 2) + 10, this.f11621n + f11608d);
                this.f11613f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.hight);
                this.f11614g = 180.0f;
                this.f11615h = 0.0f;
                break;
        }
        this.f11619l = enumC3102a;
    }
}
