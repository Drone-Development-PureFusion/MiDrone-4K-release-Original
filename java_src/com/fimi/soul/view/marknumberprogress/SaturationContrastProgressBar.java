package com.fimi.soul.view.marknumberprogress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.fimi.soul.C2300R;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class SaturationContrastProgressBar extends View {

    /* renamed from: A */
    private static final String f16188A = "progress";

    /* renamed from: B */
    private static final String f16189B = "suffix";

    /* renamed from: C */
    private static final String f16190C = "prefix";

    /* renamed from: D */
    private static final String f16191D = "text_visibility";

    /* renamed from: E */
    private static final int f16192E = 0;

    /* renamed from: aa */
    private static final float f16193aa = -1.0f;

    /* renamed from: ab */
    private static final int f16194ab = -1;

    /* renamed from: ac */
    private static final int f16195ac = -1;

    /* renamed from: ad */
    private static final int f16196ad = 2130838193;

    /* renamed from: ae */
    private static final int f16197ae = 2130838194;

    /* renamed from: s */
    private static final String f16198s = "saved_instance";

    /* renamed from: t */
    private static final String f16199t = "text_color";

    /* renamed from: u */
    private static final String f16200u = "text_size";

    /* renamed from: v */
    private static final String f16201v = "reached_bar_height";

    /* renamed from: w */
    private static final String f16202w = "reached_bar_color";

    /* renamed from: x */
    private static final String f16203x = "unreached_bar_height";

    /* renamed from: y */
    private static final String f16204y = "unreached_bar_color";

    /* renamed from: z */
    private static final String f16205z = "max";

    /* renamed from: F */
    private float f16206F;

    /* renamed from: G */
    private float f16207G;

    /* renamed from: H */
    private float f16208H;

    /* renamed from: I */
    private String f16209I;

    /* renamed from: J */
    private Paint f16210J;

    /* renamed from: K */
    private Paint f16211K;

    /* renamed from: L */
    private Paint f16212L;

    /* renamed from: M */
    private Paint f16213M;

    /* renamed from: N */
    private Paint f16214N;

    /* renamed from: O */
    private RectF f16215O;

    /* renamed from: P */
    private RectF f16216P;

    /* renamed from: Q */
    private float f16217Q;

    /* renamed from: R */
    private boolean f16218R;

    /* renamed from: S */
    private boolean f16219S;

    /* renamed from: T */
    private boolean f16220T;

    /* renamed from: U */
    private AbstractC3845b f16221U;

    /* renamed from: V */
    private int f16222V;

    /* renamed from: W */
    private Rect f16223W;

    /* renamed from: a */
    private int f16224a;

    /* renamed from: af */
    private int f16225af;

    /* renamed from: ag */
    private int f16226ag;

    /* renamed from: ah */
    private float f16227ah;

    /* renamed from: ai */
    private int f16228ai;

    /* renamed from: aj */
    private int f16229aj;

    /* renamed from: ak */
    private C3847d f16230ak;

    /* renamed from: al */
    private int f16231al;

    /* renamed from: am */
    private float f16232am;

    /* renamed from: an */
    private boolean f16233an;

    /* renamed from: ao */
    private float f16234ao;

    /* renamed from: ap */
    private int f16235ap;

    /* renamed from: aq */
    private Timer f16236aq;

    /* renamed from: ar */
    private final int f16237ar;

    /* renamed from: as */
    private Handler f16238as;

    /* renamed from: b */
    private int f16239b;

    /* renamed from: c */
    private int f16240c;

    /* renamed from: d */
    private int f16241d;

    /* renamed from: e */
    private int f16242e;

    /* renamed from: f */
    private float f16243f;

    /* renamed from: g */
    private float f16244g;

    /* renamed from: h */
    private float f16245h;

    /* renamed from: i */
    private String f16246i;

    /* renamed from: j */
    private String f16247j;

    /* renamed from: k */
    private String f16248k;

    /* renamed from: l */
    private final int f16249l;

    /* renamed from: m */
    private final int f16250m;

    /* renamed from: n */
    private final int f16251n;

    /* renamed from: o */
    private final float f16252o;

    /* renamed from: p */
    private final float f16253p;

    /* renamed from: q */
    private final float f16254q;

    /* renamed from: r */
    private final float f16255r;

    /* renamed from: com.fimi.soul.view.marknumberprogress.SaturationContrastProgressBar$a */
    /* loaded from: classes.dex */
    public enum EnumC3842a {
        Visible,
        Invisible
    }

    public SaturationContrastProgressBar(Context context) {
        this(context, null);
    }

    public SaturationContrastProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SaturationContrastProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16224a = 256;
        this.f16239b = 0;
        this.f16246i = "%";
        this.f16247j = "";
        this.f16248k = "";
        this.f16249l = Color.rgb(66, 145, 241);
        this.f16250m = Color.rgb(66, 145, 241);
        this.f16251n = Color.rgb(204, 204, 204);
        this.f16209I = "";
        this.f16215O = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16216P = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16218R = true;
        this.f16219S = true;
        this.f16220T = false;
        this.f16225af = C2300R.C2301drawable.seek_thumb_normal;
        this.f16226ag = C2300R.C2301drawable.seek_thumb_pressed;
        this.f16227ah = -1.0f;
        this.f16228ai = -1;
        this.f16229aj = -1;
        this.f16232am = 10.0f;
        this.f16233an = true;
        this.f16237ar = 0;
        this.f16238as = new Handler() { // from class: com.fimi.soul.view.marknumberprogress.SaturationContrastProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        if (SaturationContrastProgressBar.this.f16221U == null) {
                            return;
                        }
                        SaturationContrastProgressBar.this.f16221U.mo6855b(SaturationContrastProgressBar.this.getProgress(), SaturationContrastProgressBar.this.f16224a);
                        return;
                    default:
                        return;
                }
            }
        };
        this.f16234ao = m6881a(6.0f);
        this.f16254q = m6881a(2.0f);
        this.f16255r = m6881a(2.0f);
        this.f16253p = m6872b(10.0f);
        this.f16252o = m6881a(3.0f);
        Resources resources = context.getResources();
        this.f16240c = resources.getColor(C2300R.color.progress_reached_color);
        this.f16241d = resources.getColor(C2300R.color.progress_unreached_color);
        this.f16242e = resources.getColor(C2300R.color.progress_text_color);
        this.f16243f = resources.getDimensionPixelSize(C2300R.dimen.progress_text_tile_size);
        this.f16244g = resources.getDimensionPixelSize(C2300R.dimen.progress_reached_bar_height);
        this.f16245h = resources.getDimensionPixelSize(C2300R.dimen.progress_unreached_bar_height);
        this.f16217Q = this.f16252o;
        setProgress(0);
        setMax(this.f16224a);
        int color = resources.getColor(C2300R.color.progress_reached_color);
        this.f16228ai = color;
        this.f16229aj = color;
        this.f16222V = resources.getDimensionPixelSize(C2300R.dimen.progress_circle_diameter);
        if (this.f16230ak == null) {
            this.f16230ak = new C3847d(getContext(), getHeight() / 2, this.f16228ai, this.f16229aj, this.f16227ah, this.f16222V);
            this.f16231al = (int) this.f16230ak.m6828e();
            this.f16230ak.m6837a(this.f16231al);
            this.f16230ak.m6832b(this.f16231al);
        }
        m6873b();
    }

    /* renamed from: a */
    private int m6878a(int i, boolean z) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int paddingLeft = z ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();
        if (mode == 1073741824) {
            return size;
        }
        int suggestedMinimumWidth = (z ? getSuggestedMinimumWidth() : getSuggestedMinimumHeight()) + paddingLeft;
        return mode == Integer.MIN_VALUE ? z ? Math.max(suggestedMinimumWidth, size) : Math.min(suggestedMinimumWidth, size) : suggestedMinimumWidth;
    }

    /* renamed from: a */
    private void m6880a(float f, float f2) {
        if (this.f16230ak.m6825h()) {
            this.f16230ak.m6823j();
            invalidate();
        }
    }

    /* renamed from: a */
    private void m6875a(C3847d c3847d) {
        c3847d.m6824i();
        invalidate();
    }

    /* renamed from: a */
    private void m6874a(C3847d c3847d, float f) {
        int width = ((((int) f) - this.f16231al) * this.f16224a) / (getWidth() - (this.f16231al * 2));
        if (width > this.f16224a) {
            width = this.f16224a;
        }
        if (width < 0) {
            width = 0;
        }
        this.f16239b = width;
        m6875a(this.f16230ak);
        invalidate();
    }

    /* renamed from: b */
    private void m6873b() {
        this.f16210J = new Paint(1);
        this.f16210J.setColor(this.f16240c);
        this.f16211K = new Paint(1);
        this.f16211K.setColor(this.f16241d);
        this.f16212L = new Paint(1);
        this.f16212L.setColor(this.f16242e);
        this.f16212L.setTextSize(this.f16243f);
        this.f16213M = new Paint(1);
        this.f16213M.setColor(this.f16240c);
        this.f16213M.setStrokeWidth(this.f16255r);
        this.f16214N = new Paint(1);
        this.f16214N.setColor(this.f16241d);
        this.f16214N.setStrokeWidth(this.f16255r);
    }

    /* renamed from: b */
    private void m6871b(float f, float f2) {
        int width = ((((int) f) - this.f16231al) * this.f16224a) / (getWidth() - (this.f16231al * 2));
        if (width > this.f16224a) {
            width = this.f16224a;
        }
        if (width < 0) {
            width = 0;
        }
        if (this.f16230ak.m6825h() || !this.f16230ak.m6836a(f, f2)) {
            return;
        }
        this.f16239b = width;
        m6875a(this.f16230ak);
    }

    /* renamed from: c */
    private void m6868c() {
        this.f16216P.left = this.f16231al;
        this.f16216P.top = (getHeight() / 2.0f) - (this.f16244g / 2.0f);
        this.f16216P.right = ((((getWidth() - this.f16231al) - this.f16231al) / (getMax() * 1.0f)) * getProgress()) + this.f16231al;
        this.f16216P.bottom = (getHeight() / 2.0f) + (this.f16244g / 2.0f);
        this.f16215O.left = this.f16216P.right;
        this.f16215O.right = getWidth() - this.f16231al;
        this.f16215O.top = (getHeight() / 2.0f) + ((-this.f16245h) / 2.0f);
        this.f16215O.bottom = (getHeight() / 2.0f) + (this.f16245h / 2.0f);
    }

    /* renamed from: c */
    private void m6867c(float f) {
        if (this.f16230ak.m6825h()) {
            m6874a(this.f16230ak, f);
        }
    }

    /* renamed from: d */
    private void m6864d() {
        this.f16209I = String.format("%d", Integer.valueOf((getProgress() * this.f16224a) / getMax()));
        this.f16209I = this.f16247j + this.f16209I + this.f16246i;
        this.f16206F = this.f16212L.measureText(this.f16209I);
        if (getProgress() == 0) {
            this.f16219S = false;
            this.f16207G = this.f16231al;
        } else {
            this.f16219S = true;
            this.f16216P.left = this.f16231al;
            this.f16216P.top = (getHeight() / 2.0f) - (this.f16244g / 2.0f);
            this.f16216P.right = (((((getWidth() - this.f16231al) - this.f16231al) / (getMax() * 1.0f)) * getProgress()) - this.f16217Q) + this.f16231al;
            this.f16216P.bottom = (getHeight() / 2.0f) + (this.f16244g / 2.0f);
            this.f16207G = this.f16216P.right + this.f16217Q;
        }
        this.f16208H = (int) ((getHeight() / 2.0f) - ((this.f16212L.descent() + this.f16212L.ascent()) / 2.0f));
        if (this.f16207G + this.f16206F >= getWidth() - this.f16231al) {
            this.f16207G = (getWidth() - this.f16231al) - this.f16206F;
            this.f16216P.right = this.f16207G - this.f16217Q;
        }
        float f = this.f16207G + this.f16206F + this.f16217Q;
        if (f >= getWidth() - this.f16231al) {
            this.f16218R = false;
            return;
        }
        this.f16218R = true;
        this.f16215O.left = f;
        this.f16215O.right = getWidth() - this.f16231al;
        this.f16215O.top = (getHeight() / 2.0f) + ((-this.f16245h) / 2.0f);
        this.f16215O.bottom = (getHeight() / 2.0f) + (this.f16245h / 2.0f);
    }

    /* renamed from: a */
    public float m6881a(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    /* renamed from: a */
    public void m6882a() {
        this.f16238as.removeMessages(0);
        if (this.f16236aq != null) {
            this.f16236aq.cancel();
            this.f16236aq = null;
        }
        if (this.f16236aq == null) {
            this.f16236aq = new Timer();
        }
        this.f16236aq.schedule(new TimerTask() { // from class: com.fimi.soul.view.marknumberprogress.SaturationContrastProgressBar.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SaturationContrastProgressBar.this.f16238as.sendEmptyMessage(0);
            }
        }, 200L);
    }

    /* renamed from: a */
    public void m6879a(int i) {
        if (i > 0) {
            setProgress(getProgress() + i);
        }
        if (this.f16221U != null) {
            this.f16221U.mo6856a(getProgress(), getMax());
        }
    }

    /* renamed from: a */
    public void m6877a(Canvas canvas) {
        this.f16230ak.m6837a(this.f16215O.left);
        this.f16230ak.m6835a(getHeight() / 2);
        this.f16230ak.m6830c(getWidth() - this.f16231al);
        this.f16230ak.m6834a(canvas);
    }

    /* renamed from: b */
    public float m6872b(float f) {
        return getResources().getDisplayMetrics().scaledDensity * f;
    }

    /* renamed from: b */
    public void m6870b(Canvas canvas) {
        this.f16209I = String.format("%d", Integer.valueOf((getProgress() * this.f16224a) / getMax()));
        this.f16209I = this.f16247j + this.f16209I + this.f16246i;
        if (this.f16223W == null) {
            this.f16223W = new Rect();
        }
        this.f16212L.getTextBounds(this.f16248k + this.f16209I, 0, (this.f16248k + this.f16209I).length(), this.f16223W);
        canvas.drawText(this.f16248k + this.f16209I, (getWidth() / 2) - (this.f16223W.width() / 2), getHeight() / 4, this.f16212L);
    }

    /* renamed from: c */
    public void m6866c(Canvas canvas) {
        canvas.drawLine(this.f16231al, (getHeight() / 2) - this.f16234ao, this.f16231al, this.f16234ao + (getHeight() / 2), this.f16211K);
        canvas.drawLine(getWidth() - this.f16231al, (getHeight() / 2) - this.f16234ao, getWidth() - this.f16231al, this.f16234ao + (getHeight() / 2), this.f16211K);
    }

    /* renamed from: d */
    public void m6863d(Canvas canvas) {
        float width = (getWidth() - (this.f16231al * 2)) / this.f16232am;
        for (float f = this.f16216P.left; f < getWidth(); f += width) {
            if (f <= this.f16216P.right) {
                canvas.drawLine(f, (getHeight() / 2) - this.f16253p, f, (getHeight() / 2) + (this.f16244g / 2.0f), this.f16213M);
            } else {
                canvas.drawLine(f, (getHeight() / 2) - this.f16253p, f, (getHeight() / 2) + (this.f16245h / 2.0f), this.f16214N);
            }
        }
    }

    public int getMax() {
        return this.f16224a;
    }

    public String getPrefix() {
        return this.f16247j;
    }

    public int getProgress() {
        return this.f16239b;
    }

    public float getProgressTextSize() {
        return this.f16243f;
    }

    public boolean getProgressTextVisibility() {
        return this.f16220T;
    }

    public int getReachedBarColor() {
        return this.f16240c;
    }

    public float getReachedBarHeight() {
        return this.f16244g;
    }

    public String getSuffix() {
        return this.f16246i;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) this.f16243f, Math.max((int) this.f16244g, (int) this.f16245h));
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) this.f16243f;
    }

    public int getTextColor() {
        return this.f16242e;
    }

    public int getUnreachedBarColor() {
        return this.f16241d;
    }

    public float getUnreachedBarHeight() {
        return this.f16245h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f16220T) {
            m6864d();
        } else {
            m6868c();
        }
        if (this.f16219S) {
            canvas.drawRect(this.f16216P, this.f16210J);
        }
        if (this.f16218R) {
            canvas.drawRect(this.f16215O, this.f16211K);
        }
        if (this.f16220T) {
            canvas.drawText(this.f16209I, this.f16207G, this.f16208H, this.f16212L);
        }
        m6866c(canvas);
        m6877a(canvas);
        if (this.f16221U == null || this.f16235ap == this.f16239b) {
            return;
        }
        this.f16235ap = this.f16239b;
        this.f16221U.mo6856a(getProgress(), this.f16224a);
        this.f16238as.removeMessages(0);
        m6882a();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m6878a(i, true), m6878a(i2, false));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f16242e = bundle.getInt(f16199t);
        this.f16243f = bundle.getFloat(f16200u);
        this.f16244g = bundle.getFloat(f16201v);
        this.f16245h = bundle.getFloat(f16203x);
        this.f16240c = bundle.getInt(f16202w);
        this.f16241d = bundle.getInt(f16204y);
        m6873b();
        setMax(bundle.getInt(f16205z));
        setProgress(bundle.getInt("progress"));
        setPrefix(bundle.getString(f16190C));
        setSuffix(bundle.getString(f16189B));
        super.onRestoreInstanceState(bundle.getParcelable(f16198s));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f16198s, super.onSaveInstanceState());
        bundle.putInt(f16199t, getTextColor());
        bundle.putFloat(f16200u, getProgressTextSize());
        bundle.putFloat(f16201v, getReachedBarHeight());
        bundle.putFloat(f16203x, getUnreachedBarHeight());
        bundle.putInt(f16202w, getReachedBarColor());
        bundle.putInt(f16204y, getUnreachedBarColor());
        bundle.putInt(f16205z, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString(f16189B, getSuffix());
        bundle.putString(f16190C, getPrefix());
        bundle.putBoolean(f16191D, getProgressTextVisibility());
        return bundle;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m6871b(motionEvent.getX(), motionEvent.getY());
                if (this.f16221U != null) {
                    this.f16221U.mo6857a(0);
                }
                return true;
            case 1:
                if (this.f16221U != null) {
                    this.f16221U.mo6857a(1);
                    break;
                }
                break;
            case 2:
                m6867c(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                break;
            default:
                return false;
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        m6880a(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f16224a = i;
            invalidate();
        }
    }

    public void setOnProgressBarListener(AbstractC3845b abstractC3845b) {
        this.f16221U = abstractC3845b;
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.f16247j = "";
        } else {
            this.f16247j = str;
        }
    }

    public void setProgress(int i) {
        if (i > getMax() || i < 0) {
            return;
        }
        this.f16239b = i;
        this.f16235ap = this.f16239b;
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.f16242e = i;
        this.f16212L.setColor(this.f16242e);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.f16243f = f;
        this.f16212L.setTextSize(this.f16243f);
        invalidate();
    }

    public void setProgressTextVisibility(EnumC3842a enumC3842a) {
        invalidate();
    }

    public void setReachedBarColor(int i) {
        this.f16240c = i;
        this.f16210J.setColor(this.f16240c);
        invalidate();
    }

    public void setReachedBarHeight(float f) {
        this.f16244g = f;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.f16246i = "";
        } else {
            this.f16246i = str;
        }
    }

    public void setTitle(String str) {
        this.f16248k = str;
        invalidate();
    }

    public void setUnreachedBarColor(int i) {
        this.f16241d = i;
        this.f16211K.setColor(this.f16241d);
        invalidate();
    }

    public void setUnreachedBarHeight(float f) {
        this.f16245h = f;
    }
}
