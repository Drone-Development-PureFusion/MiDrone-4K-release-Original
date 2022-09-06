package com.fimi.soul.view;

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
import com.fimi.kernel.utils.C2271p;
import com.fimi.soul.C2300R;
import it.p235a.p236a.AbstractC4863e;
/* loaded from: classes.dex */
public class RemoteRollerView extends View {

    /* renamed from: A */
    private static final float f15440A = 0.1718f;

    /* renamed from: B */
    private static final float f15441B = 0.35f;

    /* renamed from: C */
    private static final float f15442C = 0.522f;

    /* renamed from: D */
    private static final int f15443D = 21;

    /* renamed from: E */
    private static final int f15444E = 22;

    /* renamed from: a */
    public static final int f15445a = 0;

    /* renamed from: b */
    public static final int f15446b = 1;

    /* renamed from: c */
    public static final int f15447c = 2;

    /* renamed from: d */
    public static final int f15448d = 3;

    /* renamed from: e */
    public static final int f15449e = 51;

    /* renamed from: f */
    public static final int f15450f = 1;

    /* renamed from: g */
    public static final int f15451g = 50;

    /* renamed from: m */
    private static final int f15452m = -14671840;

    /* renamed from: w */
    private static final float f15453w = 0.2229f;

    /* renamed from: x */
    private static final float f15454x = 0.3851f;

    /* renamed from: y */
    private static final float f15455y = 0.175f;

    /* renamed from: z */
    private static final float f15456z = 0.4685f;

    /* renamed from: h */
    private Bitmap f15457h;

    /* renamed from: i */
    private Bitmap f15458i;

    /* renamed from: j */
    private Bitmap f15459j;

    /* renamed from: k */
    private Bitmap f15460k;

    /* renamed from: l */
    private Paint f15461l;

    /* renamed from: n */
    private int f15462n;

    /* renamed from: o */
    private RectF f15463o;

    /* renamed from: p */
    private RectF f15464p;

    /* renamed from: q */
    private Bitmap f15465q;

    /* renamed from: r */
    private int f15466r;

    /* renamed from: s */
    private float f15467s;

    /* renamed from: t */
    private float f15468t;

    /* renamed from: u */
    private float f15469u;

    /* renamed from: v */
    private Context f15470v;

    public RemoteRollerView(Context context) {
        this(context, null);
    }

    public RemoteRollerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f15470v = context;
        this.f15457h = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_left_up_empty);
        this.f15458i = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_left_down_empty);
        this.f15459j = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_right_up_empty);
        this.f15460k = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_right_down_empty);
        this.f15461l = new Paint();
        this.f15461l.setAntiAlias(true);
        this.f15461l.setColor(f15452m);
        this.f15461l.setStrokeWidth(C2271p.m12860b(context) * 0.092f);
        this.f15461l.setStyle(Paint.Style.STROKE);
        setLayerType(2, this.f15461l);
    }

    public RemoteRollerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15462n = 0;
        this.f15466r = 0;
        this.f15467s = 0.0f;
    }

    /* renamed from: a */
    private void m7261a(int i, Canvas canvas) {
        switch (i) {
            case 0:
                canvas.drawBitmap(this.f15457h, getWidth() * f15453w, getHeight() * f15454x, this.f15461l);
                this.f15463o = new RectF(getWidth() * f15440A, getHeight() * f15441B, (getWidth() * f15440A) + this.f15469u, (getHeight() * f15441B) + this.f15469u);
                this.f15464p = new RectF(getWidth() * f15453w, getHeight() * f15454x, (getWidth() * f15453w) + this.f15457h.getWidth(), (getHeight() * f15454x) + this.f15457h.getHeight());
                this.f15466r = AbstractC4863e.f20783D;
                this.f15467s = ((this.f15468t - 50.0f) / 50.0f) * 21.0f;
                return;
            case 1:
                canvas.drawBitmap(this.f15458i, getWidth() * f15455y, getHeight() * f15456z, this.f15461l);
                this.f15463o = new RectF(getWidth() * f15440A, getHeight() * f15441B, (getWidth() * f15440A) + this.f15469u, (getHeight() * f15441B) + this.f15469u);
                this.f15464p = new RectF(getWidth() * f15455y, getHeight() * f15456z, (getWidth() * f15455y) + this.f15458i.getWidth(), (getHeight() * f15456z) + this.f15458i.getHeight());
                this.f15466r = 215;
                this.f15467s = ((-this.f15468t) / 50.0f) * 22.0f;
                return;
            case 2:
                canvas.drawBitmap(this.f15459j, (getWidth() - this.f15459j.getWidth()) - (getWidth() * f15453w), getHeight() * f15454x, this.f15461l);
                this.f15463o = new RectF((getWidth() - (getWidth() * f15440A)) - this.f15469u, getHeight() * f15441B, getWidth() - (getWidth() * f15440A), (getHeight() * f15441B) + this.f15469u);
                this.f15464p = new RectF((getWidth() - this.f15459j.getWidth()) - (getWidth() * f15453w), getHeight() * f15454x, getWidth() - (getWidth() * f15453w), (getHeight() * f15454x) + this.f15457h.getHeight());
                this.f15466r = 314;
                this.f15467s = ((-(this.f15468t - 50.0f)) / 50.0f) * 21.0f;
                return;
            case 3:
                canvas.drawBitmap(this.f15460k, (getWidth() - this.f15460k.getWidth()) - (getWidth() * f15455y), getHeight() * f15456z, this.f15461l);
                this.f15463o = new RectF((getWidth() - (getWidth() * f15440A)) - this.f15469u, getHeight() * f15441B, getWidth() - (getWidth() * f15440A), (getHeight() * f15441B) + this.f15469u);
                this.f15464p = new RectF((getWidth() - this.f15460k.getWidth()) - (getWidth() * f15455y), getHeight() * f15456z, getWidth() - (getWidth() * f15455y), (getHeight() * f15456z) + this.f15460k.getHeight());
                this.f15466r = 325;
                this.f15467s = (this.f15468t / 50.0f) * 22.0f;
                return;
            default:
                return;
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        m7261a(this.f15462n, canvas);
        canvas.drawArc(this.f15463o, this.f15466r, this.f15467s, false, this.f15461l);
        this.f15461l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.f15465q, (Rect) null, this.f15464p, this.f15461l);
        this.f15461l.setXfermode(null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f15469u = C2271p.m12860b(this.f15470v) * f15442C;
    }

    public void setInitView(int i) {
        this.f15462n = i;
        switch (i) {
            case 0:
                this.f15465q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_left_up_full);
                return;
            case 1:
                this.f15465q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_left_down_full);
                return;
            case 2:
                this.f15465q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_right_up_full);
                return;
            case 3:
                this.f15465q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.arrow_right_down_full);
                return;
            default:
                return;
        }
    }

    public void setSweep(float f) {
        this.f15468t = f;
        invalidate();
    }
}
