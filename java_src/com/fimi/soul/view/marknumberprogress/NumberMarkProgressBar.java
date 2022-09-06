package com.fimi.soul.view.marknumberprogress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class NumberMarkProgressBar extends View {

    /* renamed from: A */
    private static final String f16119A = "progress";

    /* renamed from: B */
    private static final String f16120B = "suffix";

    /* renamed from: C */
    private static final String f16121C = "prefix";

    /* renamed from: D */
    private static final String f16122D = "text_visibility";

    /* renamed from: E */
    private static final int f16123E = 0;

    /* renamed from: ac */
    private static final float f16124ac = -1.0f;

    /* renamed from: ad */
    private static final int f16125ad = -1;

    /* renamed from: ae */
    private static final int f16126ae = -1;

    /* renamed from: af */
    private static final int f16127af = 2130838193;

    /* renamed from: ag */
    private static final int f16128ag = 2130838194;

    /* renamed from: s */
    private static final String f16129s = "saved_instance";

    /* renamed from: t */
    private static final String f16130t = "text_color";

    /* renamed from: u */
    private static final String f16131u = "text_size";

    /* renamed from: v */
    private static final String f16132v = "reached_bar_height";

    /* renamed from: w */
    private static final String f16133w = "reached_bar_color";

    /* renamed from: x */
    private static final String f16134x = "unreached_bar_height";

    /* renamed from: y */
    private static final String f16135y = "unreached_bar_color";

    /* renamed from: z */
    private static final String f16136z = "max";

    /* renamed from: F */
    private float f16137F;

    /* renamed from: G */
    private float f16138G;

    /* renamed from: H */
    private float f16139H;

    /* renamed from: I */
    private String f16140I;

    /* renamed from: J */
    private Paint f16141J;

    /* renamed from: K */
    private Paint f16142K;

    /* renamed from: L */
    private Paint f16143L;

    /* renamed from: M */
    private Paint f16144M;

    /* renamed from: N */
    private Paint f16145N;

    /* renamed from: O */
    private Paint f16146O;

    /* renamed from: P */
    private Paint f16147P;

    /* renamed from: Q */
    private RectF f16148Q;

    /* renamed from: R */
    private RectF f16149R;

    /* renamed from: S */
    private float f16150S;

    /* renamed from: T */
    private boolean f16151T;

    /* renamed from: U */
    private boolean f16152U;

    /* renamed from: V */
    private boolean f16153V;

    /* renamed from: W */
    private AbstractC3845b f16154W;

    /* renamed from: a */
    private int f16155a;

    /* renamed from: aa */
    private int f16156aa;

    /* renamed from: ab */
    private Rect f16157ab;

    /* renamed from: ah */
    private int f16158ah;

    /* renamed from: ai */
    private int f16159ai;

    /* renamed from: aj */
    private float f16160aj;

    /* renamed from: ak */
    private int f16161ak;

    /* renamed from: al */
    private int f16162al;

    /* renamed from: am */
    private C3846c f16163am;

    /* renamed from: an */
    private int f16164an;

    /* renamed from: ao */
    private float f16165ao;

    /* renamed from: ap */
    private float f16166ap;

    /* renamed from: aq */
    private boolean f16167aq;

    /* renamed from: b */
    private int f16168b;

    /* renamed from: c */
    private int f16169c;

    /* renamed from: d */
    private int f16170d;

    /* renamed from: e */
    private int f16171e;

    /* renamed from: f */
    private float f16172f;

    /* renamed from: g */
    private float f16173g;

    /* renamed from: h */
    private float f16174h;

    /* renamed from: i */
    private String f16175i;

    /* renamed from: j */
    private String f16176j;

    /* renamed from: k */
    private String f16177k;

    /* renamed from: l */
    private final int f16178l;

    /* renamed from: m */
    private final int f16179m;

    /* renamed from: n */
    private final int f16180n;

    /* renamed from: o */
    private final float f16181o;

    /* renamed from: p */
    private final float f16182p;

    /* renamed from: q */
    private final float f16183q;

    /* renamed from: r */
    private final float f16184r;

    /* renamed from: com.fimi.soul.view.marknumberprogress.NumberMarkProgressBar$a */
    /* loaded from: classes.dex */
    public enum EnumC3839a {
        Visible,
        Invisible
    }

    public NumberMarkProgressBar(Context context) {
        this(context, null);
    }

    public NumberMarkProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NumberMarkProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16155a = 100;
        this.f16168b = 0;
        this.f16175i = "%";
        this.f16176j = "";
        this.f16177k = "";
        this.f16178l = Color.rgb(66, 145, 241);
        this.f16179m = Color.rgb(66, 145, 241);
        this.f16180n = Color.rgb(204, 204, 204);
        this.f16140I = "";
        this.f16148Q = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16149R = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16151T = true;
        this.f16152U = true;
        this.f16153V = false;
        this.f16158ah = C2300R.C2301drawable.seek_thumb_normal;
        this.f16159ai = C2300R.C2301drawable.seek_thumb_pressed;
        this.f16160aj = -1.0f;
        this.f16161ak = -1;
        this.f16162al = -1;
        this.f16165ao = 10.0f;
        this.f16167aq = true;
        this.f16166ap = m6897a(6.0f);
        this.f16183q = m6897a(1.5f);
        this.f16184r = m6897a(1.0f);
        this.f16182p = m6889b(10.0f);
        this.f16181o = m6897a(3.0f);
        Resources resources = context.getResources();
        this.f16169c = resources.getColor(C2300R.color.progress_reached_color);
        this.f16170d = resources.getColor(C2300R.color.progress_unreached_color);
        this.f16171e = resources.getColor(C2300R.color.progress_text_color);
        this.f16172f = resources.getDimensionPixelSize(C2300R.dimen.progress_text_tile_size);
        this.f16173g = resources.getDimensionPixelSize(C2300R.dimen.progress_reached_bar_height);
        this.f16174h = resources.getDimensionPixelSize(C2300R.dimen.progress_unreached_bar_height);
        this.f16150S = this.f16181o;
        setMax(this.f16155a);
        int color = resources.getColor(C2300R.color.progress_reached_color);
        this.f16161ak = color;
        this.f16162al = color;
        this.f16156aa = resources.getDimensionPixelSize(C2300R.dimen.progress_circle_diameter);
        if (this.f16163am == null) {
            this.f16163am = new C3846c(getContext(), getHeight() / 2, this.f16161ak, this.f16162al, this.f16160aj, this.f16156aa);
            this.f16164an = (int) this.f16163am.m6844e();
            this.f16163am.m6853a(this.f16164an);
            this.f16163am.m6848b(this.f16164an);
        }
        m6898a();
    }

    /* renamed from: a */
    private int m6894a(int i, boolean z) {
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
    private void m6898a() {
        float m6897a = m6897a(1.3333334f);
        float m6897a2 = m6897a(0.6666667f);
        this.f16141J = new Paint(1);
        this.f16141J.setColor(this.f16169c);
        this.f16142K = new Paint(1);
        this.f16142K.setColor(this.f16170d);
        this.f16143L = new Paint(1);
        this.f16143L.setColor(this.f16169c);
        this.f16144M = new Paint(1);
        this.f16144M.setColor(this.f16170d);
        this.f16143L.setStrokeWidth(m6897a);
        this.f16144M.setStrokeWidth(m6897a);
        this.f16145N = new Paint(1);
        this.f16145N.setColor(this.f16171e);
        this.f16145N.setTextSize(this.f16172f);
        this.f16146O = new Paint(1);
        this.f16146O.setColor(this.f16169c);
        this.f16146O.setStrokeWidth(m6897a2);
        this.f16147P = new Paint(1);
        this.f16147P.setColor(this.f16170d);
        this.f16147P.setStrokeWidth(m6897a2);
    }

    /* renamed from: a */
    private void m6896a(float f, float f2) {
        if (this.f16163am.m6841h()) {
            this.f16163am.m6839j();
            invalidate();
        }
    }

    /* renamed from: a */
    private void m6892a(C3846c c3846c) {
        c3846c.m6840i();
        invalidate();
    }

    /* renamed from: a */
    private void m6891a(C3846c c3846c, float f) {
        int width = ((((int) f) - this.f16164an) * this.f16155a) / (getWidth() - (this.f16164an * 2));
        if (width > this.f16155a) {
            width = this.f16155a;
        }
        if (width < 0) {
            width = 0;
        }
        this.f16168b = width;
        m6892a(this.f16163am);
        invalidate();
    }

    /* renamed from: b */
    private void m6890b() {
        this.f16149R.left = this.f16164an;
        this.f16149R.top = (getHeight() / 2.0f) - (this.f16173g / 2.0f);
        this.f16149R.right = ((((getWidth() - this.f16164an) - this.f16164an) / (getMax() * 1.0f)) * getProgress()) + this.f16164an;
        this.f16149R.bottom = (getHeight() / 2.0f) + (this.f16173g / 2.0f);
        this.f16148Q.left = this.f16149R.right;
        this.f16148Q.right = getWidth() - this.f16164an;
        this.f16148Q.top = (getHeight() / 2.0f) + ((-this.f16174h) / 2.0f);
        this.f16148Q.bottom = (getHeight() / 2.0f) + (this.f16174h / 2.0f);
    }

    /* renamed from: b */
    private void m6888b(float f, float f2) {
        int width = ((((int) f) - this.f16164an) * this.f16155a) / (getWidth() - (this.f16164an * 2));
        if (width > this.f16155a) {
            width = this.f16155a;
        }
        if (width < 0) {
            width = 0;
        }
        if (this.f16163am.m6841h() || !this.f16163am.m6852a(f, f2)) {
            return;
        }
        this.f16168b = width;
        m6892a(this.f16163am);
    }

    /* renamed from: c */
    private void m6886c() {
        this.f16140I = String.format("%d", Integer.valueOf((getProgress() * this.f16155a) / getMax()));
        this.f16140I = this.f16176j + this.f16140I + this.f16175i;
        this.f16137F = this.f16145N.measureText(this.f16140I);
        if (getProgress() == 0) {
            this.f16152U = false;
            this.f16138G = this.f16164an;
        } else {
            this.f16152U = true;
            this.f16149R.left = this.f16164an;
            this.f16149R.top = (getHeight() / 2.0f) - (this.f16173g / 2.0f);
            this.f16149R.right = (((((getWidth() - this.f16164an) - this.f16164an) / (getMax() * 1.0f)) * getProgress()) - this.f16150S) + this.f16164an;
            this.f16149R.bottom = (getHeight() / 2.0f) + (this.f16173g / 2.0f);
            this.f16138G = this.f16149R.right + this.f16150S;
        }
        this.f16139H = (int) ((getHeight() / 2.0f) - ((this.f16145N.descent() + this.f16145N.ascent()) / 2.0f));
        if (this.f16138G + this.f16137F >= getWidth() - this.f16164an) {
            this.f16138G = (getWidth() - this.f16164an) - this.f16137F;
            this.f16149R.right = this.f16138G - this.f16150S;
        }
        float f = this.f16138G + this.f16137F + this.f16150S;
        if (f >= getWidth() - this.f16164an) {
            this.f16151T = false;
            return;
        }
        this.f16151T = true;
        this.f16148Q.left = f;
        this.f16148Q.right = getWidth() - this.f16164an;
        this.f16148Q.top = (getHeight() / 2.0f) + ((-this.f16174h) / 2.0f);
        this.f16148Q.bottom = (getHeight() / 2.0f) + (this.f16174h / 2.0f);
    }

    /* renamed from: c */
    private void m6885c(float f) {
        if (this.f16163am.m6841h()) {
            m6891a(this.f16163am, f);
        }
    }

    /* renamed from: a */
    public float m6897a(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    /* renamed from: a */
    public void m6895a(int i) {
        if (i > 0) {
            setProgress(getProgress() + i);
        }
        if (this.f16154W != null) {
            this.f16154W.mo6856a(getProgress(), getMax());
        }
    }

    /* renamed from: a */
    public void m6893a(Canvas canvas) {
        this.f16163am.m6853a(this.f16148Q.left);
        this.f16163am.m6851a(getHeight() / 2);
        this.f16163am.m6846c(getWidth() - this.f16164an);
        this.f16163am.m6850a(canvas);
    }

    /* renamed from: b */
    public float m6889b(float f) {
        return getResources().getDisplayMetrics().scaledDensity * f;
    }

    /* renamed from: b */
    public void m6887b(Canvas canvas) {
        this.f16140I = String.format("%d", Integer.valueOf((getProgress() * this.f16155a) / getMax()));
        this.f16140I = this.f16176j + this.f16140I + this.f16175i;
        if (this.f16157ab == null) {
            this.f16157ab = new Rect();
        }
        this.f16145N.getTextBounds(this.f16177k + this.f16140I, 0, (this.f16177k + this.f16140I).length(), this.f16157ab);
        canvas.drawText(this.f16177k + this.f16140I, (getWidth() / 2) - (this.f16157ab.width() / 2), getHeight() / 4, this.f16145N);
    }

    /* renamed from: c */
    public void m6884c(Canvas canvas) {
        canvas.drawLine(this.f16164an, (getHeight() / 2) - this.f16166ap, this.f16164an, this.f16166ap + (getHeight() / 2), this.f16142K);
        canvas.drawLine(getWidth() - this.f16164an, (getHeight() / 2) - this.f16166ap, getWidth() - this.f16164an, this.f16166ap + (getHeight() / 2), this.f16142K);
    }

    /* renamed from: d */
    public void m6883d(Canvas canvas) {
        float width = (getWidth() - (this.f16164an * 2)) / this.f16165ao;
        for (float f = this.f16149R.left; f < getWidth(); f += width) {
            if (f <= this.f16149R.right) {
                canvas.drawLine(f, (getHeight() / 2) - this.f16182p, f, (getHeight() / 2) + (this.f16173g / 2.0f), this.f16146O);
            } else {
                canvas.drawLine(f, (getHeight() / 2) - this.f16182p, f, (getHeight() / 2) + (this.f16174h / 2.0f), this.f16147P);
            }
        }
    }

    public int getMax() {
        return this.f16155a;
    }

    public String getPrefix() {
        return this.f16176j;
    }

    public int getProgress() {
        return this.f16168b;
    }

    public float getProgressTextSize() {
        return this.f16172f;
    }

    public boolean getProgressTextVisibility() {
        return this.f16153V;
    }

    public int getReachedBarColor() {
        return this.f16169c;
    }

    public float getReachedBarHeight() {
        return this.f16173g;
    }

    public String getSuffix() {
        return this.f16175i;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) this.f16172f, Math.max((int) this.f16173g, (int) this.f16174h));
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) this.f16172f;
    }

    public int getTextColor() {
        return this.f16171e;
    }

    public int getUnreachedBarColor() {
        return this.f16170d;
    }

    public float getUnreachedBarHeight() {
        return this.f16174h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f16153V) {
            m6886c();
        } else {
            m6890b();
        }
        if (this.f16151T) {
            canvas.drawLine(this.f16164an, getHeight() / 2.0f, getWidth() - this.f16164an, getHeight() / 2.0f, this.f16144M);
        }
        if (this.f16152U) {
            canvas.drawLine(this.f16164an, getHeight() / 2.0f, this.f16149R.right, getHeight() / 2.0f, this.f16143L);
        }
        if (this.f16153V) {
            canvas.drawText(this.f16140I, this.f16138G, this.f16139H, this.f16145N);
        }
        m6884c(canvas);
        m6893a(canvas);
        if (this.f16154W != null && !this.f16167aq) {
            this.f16154W.mo6856a(getProgress(), this.f16155a);
        }
        this.f16167aq = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m6894a(i, true), m6894a(i2, false));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f16171e = bundle.getInt(f16130t);
        this.f16172f = bundle.getFloat(f16131u);
        this.f16173g = bundle.getFloat(f16132v);
        this.f16174h = bundle.getFloat(f16134x);
        this.f16169c = bundle.getInt(f16133w);
        this.f16170d = bundle.getInt(f16135y);
        m6898a();
        setMax(bundle.getInt(f16136z));
        setProgress(bundle.getInt("progress"));
        setPrefix(bundle.getString(f16121C));
        setSuffix(bundle.getString(f16120B));
        super.onRestoreInstanceState(bundle.getParcelable(f16129s));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f16129s, super.onSaveInstanceState());
        bundle.putInt(f16130t, getTextColor());
        bundle.putFloat(f16131u, getProgressTextSize());
        bundle.putFloat(f16132v, getReachedBarHeight());
        bundle.putFloat(f16134x, getUnreachedBarHeight());
        bundle.putInt(f16133w, getReachedBarColor());
        bundle.putInt(f16135y, getUnreachedBarColor());
        bundle.putInt(f16136z, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString(f16120B, getSuffix());
        bundle.putString(f16121C, getPrefix());
        bundle.putBoolean(f16122D, getProgressTextVisibility());
        return bundle;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                m6888b(motionEvent.getX(), motionEvent.getY());
                return true;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                m6896a(motionEvent.getX(), motionEvent.getY());
                return true;
            case 2:
                m6885c(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f16155a = i;
        }
    }

    public void setOnProgressBarListener(AbstractC3845b abstractC3845b) {
        this.f16154W = abstractC3845b;
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.f16176j = "";
        } else {
            this.f16176j = str;
        }
    }

    public void setProgress(int i) {
        if (i > getMax() || i < 0) {
            return;
        }
        this.f16168b = i;
    }

    public void setProgressAndInvalidate(int i) {
        if (i > getMax() || i < 0) {
            return;
        }
        this.f16168b = i;
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.f16171e = i;
        this.f16145N.setColor(this.f16171e);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.f16172f = f;
        this.f16145N.setTextSize(this.f16172f);
        invalidate();
    }

    public void setProgressTextVisibility(EnumC3839a enumC3839a) {
        invalidate();
    }

    public void setReachedBarColor(int i) {
        this.f16169c = i;
        this.f16141J.setColor(this.f16169c);
        invalidate();
    }

    public void setReachedBarHeight(float f) {
        this.f16173g = f;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.f16175i = "";
        } else {
            this.f16175i = str;
        }
    }

    public void setTitle(String str) {
        this.f16177k = str;
        invalidate();
    }

    public void setUnreachedBarColor(int i) {
        this.f16170d = i;
        this.f16142K.setColor(this.f16170d);
        invalidate();
    }

    public void setUnreachedBarHeight(float f) {
        this.f16174h = f;
    }
}
