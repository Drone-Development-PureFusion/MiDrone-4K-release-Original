package com.fimi.soul.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.fimi.kernel.utils.C2271p;
import com.fimi.soul.C2300R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TranslationView extends View {

    /* renamed from: q */
    private static final float f15524q = 0.25f;

    /* renamed from: s */
    private static final String f15525s = "TranslationView";

    /* renamed from: a */
    private Camera f15526a;

    /* renamed from: b */
    private Matrix f15527b;

    /* renamed from: c */
    private float f15528c;

    /* renamed from: d */
    private float f15529d;

    /* renamed from: e */
    private float f15530e;

    /* renamed from: f */
    private int f15531f;

    /* renamed from: g */
    private Paint f15532g;

    /* renamed from: h */
    private Paint f15533h;

    /* renamed from: i */
    private Paint f15534i;

    /* renamed from: j */
    private Bitmap f15535j;

    /* renamed from: k */
    private int f15536k;

    /* renamed from: l */
    private AnimatorSet f15537l;

    /* renamed from: m */
    private Bitmap f15538m;

    /* renamed from: n */
    private Bitmap f15539n;

    /* renamed from: o */
    private float f15540o;

    /* renamed from: p */
    private float f15541p;

    /* renamed from: r */
    private HashMap<String, WeakReference<Bitmap>> f15542r;

    public TranslationView(Context context) {
        this(context, null);
    }

    public TranslationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f15526a = new Camera();
        this.f15527b = new Matrix();
        new BitmapFactory.Options();
        float m12860b = C2271p.m12860b(context) < ((float) C2271p.m12871a(context)) ? C2271p.m12860b(context) : C2271p.m12871a(context);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.usb_plane_start);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.usb_plane_end);
        float width = ((m12860b * 1004.0f) / 1080.0f) / decodeResource2.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(width, width);
        if (this.f15538m == null) {
            this.f15542r.put("bitmapstart", new WeakReference<>(Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true)));
            this.f15538m = this.f15542r.get("bitmapstart").get();
        }
        if (this.f15539n == null) {
            this.f15542r.put("bitmapend", new WeakReference<>(Bitmap.createBitmap(decodeResource2, 0, 0, decodeResource2.getWidth(), decodeResource2.getHeight(), matrix, true)));
            this.f15539n = this.f15542r.get("bitmapend").get();
        }
        this.f15526a.save();
        this.f15526a.translate(0.0f, 0.0f, 500.0f);
        this.f15526a.getMatrix(this.f15527b);
        this.f15526a.restore();
        if (this.f15538m != null) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f15538m, 0, 0, this.f15538m.getWidth(), this.f15538m.getHeight(), this.f15527b, true);
            this.f15540o = createBitmap.getWidth();
            this.f15541p = this.f15538m.getWidth() / createBitmap.getWidth();
        }
        this.f15532g = new Paint();
        this.f15534i = new Paint();
        this.f15534i.setAlpha(255);
        this.f15533h = new Paint();
        if (decodeResource.isRecycled()) {
            decodeResource.recycle();
        }
        if (decodeResource2.isRecycled()) {
            decodeResource2.recycle();
        }
    }

    public TranslationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15530e = 0.0f;
        this.f15531f = 0;
        this.f15536k = 500;
        this.f15542r = new HashMap<>();
    }

    /* renamed from: a */
    public void m7244a() {
        this.f15528c = (-getMeasuredHeight()) * f15524q;
        this.f15529d = 0.0f;
        this.f15530e = 0.0f;
        this.f15531f = 0;
        this.f15534i.setAlpha(0);
        this.f15532g.setAlpha(255);
        invalidate();
    }

    /* renamed from: a */
    public void m7243a(int i) {
        this.f15536k = i;
        ValueAnimator ofFloat = ValueAnimator.ofFloat((-getMeasuredHeight()) * f15524q, ((getMeasuredWidth() / 2) - (this.f15540o / 2.0f)) * this.f15541p);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.TranslationView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TranslationView.this.f15528c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TranslationView.this.invalidate();
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, (-getHeight()) * 0.2444f);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.TranslationView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TranslationView.this.f15529d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 500.0f);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.TranslationView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TranslationView.this.f15530e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.fimi.soul.view.TranslationView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TranslationView.this.f15531f = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                TranslationView.this.f15534i.setAlpha(TranslationView.this.f15531f / 2);
                TranslationView.this.f15532g.setAlpha(255 - TranslationView.this.f15531f);
            }
        });
        this.f15537l = new AnimatorSet();
        this.f15537l.setDuration(this.f15536k);
        this.f15537l.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofInt);
        this.f15537l.start();
    }

    /* renamed from: b */
    public void m7239b() {
        if (this.f15537l.isStarted()) {
            this.f15537l.cancel();
            m7244a();
        }
    }

    /* renamed from: c */
    public void m7236c() {
        for (Map.Entry<String, WeakReference<Bitmap>> entry : this.f15542r.entrySet()) {
            Bitmap bitmap = entry.getValue().get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15526a.save();
        this.f15526a.translate(this.f15528c, this.f15529d, this.f15530e);
        this.f15526a.getMatrix(this.f15527b);
        this.f15526a.restore();
        Log.d(f15525s, "onDraw: " + this.f15531f);
        if (this.f15538m != null) {
            canvas.drawBitmap(this.f15538m, this.f15527b, this.f15532g);
        }
        if (this.f15539n != null) {
            canvas.drawBitmap(this.f15539n, this.f15527b, this.f15534i);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f15528c = (-getMeasuredHeight()) * f15524q;
        this.f15529d = 0.0f;
        this.f15530e = 0.0f;
    }

    public void setDuration(int i) {
        this.f15536k = i;
    }
}
