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
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.fimi.soul.C2300R;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes.dex */
public class EvProgressBar extends View {

    /* renamed from: A */
    private static final String f16039A = "reached_bar_color";

    /* renamed from: B */
    private static final String f16040B = "unreached_bar_height";

    /* renamed from: C */
    private static final String f16041C = "unreached_bar_color";

    /* renamed from: D */
    private static final String f16042D = "max";

    /* renamed from: E */
    private static final String f16043E = "progress";

    /* renamed from: F */
    private static final String f16044F = "suffix";

    /* renamed from: G */
    private static final String f16045G = "prefix";

    /* renamed from: H */
    private static final String f16046H = "text_visibility";

    /* renamed from: I */
    private static final int f16047I = 0;

    /* renamed from: ac */
    private static final float f16048ac = -1.0f;

    /* renamed from: ad */
    private static final int f16049ad = -1;

    /* renamed from: ae */
    private static final int f16050ae = -1;

    /* renamed from: af */
    private static final int f16051af = 2130838193;

    /* renamed from: ag */
    private static final int f16052ag = 2130838194;

    /* renamed from: w */
    private static final String f16053w = "saved_instance";

    /* renamed from: x */
    private static final String f16054x = "text_color";

    /* renamed from: y */
    private static final String f16055y = "text_size";

    /* renamed from: z */
    private static final String f16056z = "reached_bar_height";

    /* renamed from: J */
    private float f16057J;

    /* renamed from: K */
    private float f16058K;

    /* renamed from: L */
    private float f16059L;

    /* renamed from: M */
    private String f16060M;

    /* renamed from: N */
    private Paint f16061N;

    /* renamed from: O */
    private Paint f16062O;

    /* renamed from: P */
    private Paint f16063P;

    /* renamed from: Q */
    private Paint f16064Q;

    /* renamed from: R */
    private Paint f16065R;

    /* renamed from: S */
    private RectF f16066S;

    /* renamed from: T */
    private RectF f16067T;

    /* renamed from: U */
    private float f16068U;

    /* renamed from: V */
    private boolean f16069V;

    /* renamed from: W */
    private boolean f16070W;

    /* renamed from: a */
    private int f16071a;

    /* renamed from: aa */
    private AbstractC3845b f16072aa;

    /* renamed from: ab */
    private Rect f16073ab;

    /* renamed from: ah */
    private int f16074ah;

    /* renamed from: ai */
    private int f16075ai;

    /* renamed from: aj */
    private float f16076aj;

    /* renamed from: ak */
    private int f16077ak;

    /* renamed from: al */
    private int f16078al;

    /* renamed from: am */
    private C3847d f16079am;

    /* renamed from: an */
    private int f16080an;

    /* renamed from: ao */
    private float f16081ao;

    /* renamed from: ap */
    private Paint f16082ap;

    /* renamed from: aq */
    private int f16083aq;

    /* renamed from: ar */
    private float f16084ar;

    /* renamed from: as */
    private Paint f16085as;

    /* renamed from: at */
    private Paint f16086at;

    /* renamed from: au */
    private Paint f16087au;

    /* renamed from: av */
    private Paint f16088av;

    /* renamed from: aw */
    private int f16089aw;

    /* renamed from: ax */
    private Timer f16090ax;

    /* renamed from: ay */
    private final int f16091ay;

    /* renamed from: az */
    private Handler f16092az;

    /* renamed from: b */
    private float f16093b;

    /* renamed from: c */
    private int f16094c;

    /* renamed from: d */
    private int f16095d;

    /* renamed from: e */
    private int f16096e;

    /* renamed from: f */
    private int f16097f;

    /* renamed from: g */
    private int f16098g;

    /* renamed from: h */
    private float f16099h;

    /* renamed from: i */
    private float f16100i;

    /* renamed from: j */
    private float f16101j;

    /* renamed from: k */
    private String f16102k;

    /* renamed from: l */
    private String f16103l;

    /* renamed from: m */
    private String f16104m;

    /* renamed from: n */
    private final int f16105n;

    /* renamed from: o */
    private final int f16106o;

    /* renamed from: p */
    private final int f16107p;

    /* renamed from: q */
    private final float f16108q;

    /* renamed from: r */
    private final float f16109r;

    /* renamed from: s */
    private final float f16110s;

    /* renamed from: t */
    private final float f16111t;

    /* renamed from: u */
    private final float f16112u;

    /* renamed from: v */
    private final float f16113v;

    /* renamed from: com.fimi.soul.view.marknumberprogress.EvProgressBar$a */
    /* loaded from: classes.dex */
    public enum EnumC3838a {
        Visible,
        Invisible
    }

    public EvProgressBar(Context context) {
        this(context, null);
    }

    public EvProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EvProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16071a = 12;
        this.f16093b = 12.0f;
        this.f16094c = 6;
        this.f16095d = 0;
        this.f16102k = "";
        this.f16103l = "";
        this.f16104m = "";
        this.f16105n = Color.rgb(66, 145, 241);
        this.f16106o = Color.rgb(66, 145, 241);
        this.f16107p = Color.rgb(204, 204, 204);
        this.f16060M = "";
        this.f16066S = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16067T = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f16069V = true;
        this.f16070W = true;
        this.f16074ah = C2300R.C2301drawable.seek_thumb_normal;
        this.f16075ai = C2300R.C2301drawable.seek_thumb_pressed;
        this.f16076aj = -1.0f;
        this.f16077ak = -1;
        this.f16078al = -1;
        this.f16091ay = 0;
        this.f16092az = new Handler() { // from class: com.fimi.soul.view.marknumberprogress.EvProgressBar.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 0:
                        if (EvProgressBar.this.f16072aa == null) {
                            return;
                        }
                        EvProgressBar.this.f16072aa.mo6855b(EvProgressBar.this.getProgress(), EvProgressBar.this.f16071a);
                        return;
                    default:
                        return;
                }
            }
        };
        this.f16110s = m6914a(1.5f);
        this.f16111t = m6914a(1.0f);
        this.f16109r = m6905b(10.0f);
        this.f16108q = m6914a(3.0f);
        this.f16084ar = m6914a(0.75f);
        this.f16113v = m6914a(6.0f);
        this.f16112u = m6914a(0.75f);
        Resources resources = context.getResources();
        this.f16096e = resources.getColor(C2300R.color.progress_reached_color);
        this.f16097f = resources.getColor(C2300R.color.progress_unreached_color);
        this.f16098g = resources.getColor(C2300R.color.progress_text_color);
        this.f16099h = resources.getDimensionPixelSize(C2300R.dimen.progress_text_tile_size);
        this.f16100i = resources.getDimensionPixelSize(C2300R.dimen.progress_reached_bar_height);
        this.f16101j = resources.getDimensionPixelSize(C2300R.dimen.progress_unreached_bar_height);
        this.f16068U = this.f16108q;
        setProgress(0);
        setMax(this.f16071a);
        int color = resources.getColor(C2300R.color.progress_reached_color);
        this.f16077ak = color;
        this.f16078al = color;
        this.f16083aq = resources.getDimensionPixelSize(C2300R.dimen.progress_circle_diameter);
        if (this.f16079am == null) {
            this.f16079am = new C3847d(getContext(), getHeight() / 2, this.f16077ak, this.f16078al, this.f16076aj, this.f16083aq);
            this.f16080an = (int) this.f16079am.m6828e();
            this.f16079am.m6837a(this.f16080an);
            this.f16079am.m6832b(this.f16080an);
        }
        m6906b();
    }

    /* renamed from: a */
    private int m6911a(int i, boolean z) {
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
    private void m6913a(float f, float f2) {
        if (this.f16079am.m6825h()) {
            this.f16079am.m6823j();
            invalidate();
        }
    }

    /* renamed from: a */
    private void m6908a(C3847d c3847d) {
        c3847d.m6824i();
        invalidate();
    }

    /* renamed from: a */
    private void m6907a(C3847d c3847d, float f) {
        int width = ((((int) f) - this.f16080an) * this.f16071a) / (getWidth() - (this.f16080an * 2));
        if (width > this.f16071a) {
            width = this.f16071a;
        }
        if (width < 0) {
            width = 0;
        }
        this.f16095d = width;
        Log.i("zdy", "" + width);
        m6908a(this.f16079am);
        invalidate();
    }

    /* renamed from: b */
    private void m6906b() {
        this.f16061N = new Paint(1);
        this.f16061N.setColor(this.f16096e);
        this.f16062O = new Paint(1);
        this.f16062O.setColor(this.f16097f);
        this.f16063P = new Paint(1);
        this.f16063P.setColor(this.f16098g);
        this.f16063P.setTextSize(this.f16099h);
        this.f16064Q = new Paint(1);
        this.f16064Q.setColor(this.f16096e);
        this.f16064Q.setStrokeWidth(this.f16084ar);
        this.f16065R = new Paint(1);
        this.f16065R.setColor(this.f16097f);
        this.f16065R.setStrokeWidth(this.f16084ar);
        this.f16082ap = new Paint(1);
        this.f16082ap.setColor(this.f16097f);
        this.f16082ap.setStrokeWidth(this.f16112u);
        this.f16085as = new Paint(1);
        this.f16085as.setColor(this.f16097f);
        this.f16085as.setStrokeWidth(this.f16084ar);
        this.f16086at = new Paint(1);
        this.f16086at.setColor(this.f16097f);
        this.f16086at.setStrokeWidth(1.0f);
        this.f16087au = new Paint(1);
        this.f16087au.setColor(this.f16096e);
        this.f16087au.setStrokeWidth(1.0f);
    }

    /* renamed from: b */
    private void m6904b(float f, float f2) {
        int width = ((((int) f) - this.f16080an) * this.f16071a) / (getWidth() - (this.f16080an * 2));
        if (width > this.f16071a) {
            width = this.f16071a;
        }
        if (width < 0) {
            width = 0;
        }
        if (this.f16079am.m6825h() || !this.f16079am.m6836a(f, f2)) {
            return;
        }
        this.f16095d = width;
        m6908a(this.f16079am);
    }

    /* renamed from: c */
    private void m6901c() {
        this.f16081ao = (getWidth() - (this.f16080an * 2)) / this.f16093b;
        if (getProgress() - this.f16094c >= 0) {
            float f = this.f16081ao * this.f16094c;
            this.f16067T.left = f + this.f16080an;
            this.f16067T.right = (getProgress() * this.f16081ao) + this.f16080an;
        } else {
            float f2 = this.f16081ao * this.f16094c;
            this.f16067T.left = (getProgress() * this.f16081ao) + this.f16080an;
            this.f16067T.right = f2 + this.f16080an;
        }
        this.f16067T.top = (getHeight() / 2.0f) - (this.f16100i / 2.0f);
        this.f16067T.bottom = (getHeight() / 2.0f) + (this.f16100i / 2.0f);
        this.f16066S.left = this.f16080an;
        this.f16066S.right = getWidth() - this.f16080an;
        this.f16066S.top = (getHeight() / 2.0f) + ((-this.f16101j) / 2.0f);
        this.f16066S.bottom = (getHeight() / 2.0f) + (this.f16101j / 2.0f);
    }

    /* renamed from: c */
    private void m6900c(float f) {
        if (this.f16079am.m6825h()) {
            m6907a(this.f16079am, f);
        }
    }

    /* renamed from: a */
    public float m6914a(float f) {
        return (getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    /* renamed from: a */
    public void m6915a() {
        this.f16092az.removeMessages(0);
        if (this.f16090ax != null) {
            this.f16090ax.cancel();
            this.f16090ax = null;
        }
        if (this.f16090ax == null) {
            this.f16090ax = new Timer();
        }
        this.f16090ax.schedule(new TimerTask() { // from class: com.fimi.soul.view.marknumberprogress.EvProgressBar.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                EvProgressBar.this.f16092az.sendEmptyMessage(0);
            }
        }, 200L);
    }

    /* renamed from: a */
    public void m6912a(int i) {
        if (i > 0) {
            setProgress(getProgress() + i);
        }
        if (this.f16072aa != null) {
            this.f16072aa.mo6856a(getProgress(), getMax());
        }
    }

    /* renamed from: a */
    public void m6910a(Canvas canvas) {
        if (getProgress() - this.f16094c >= 0) {
            this.f16079am.m6837a(this.f16067T.right);
        } else {
            this.f16079am.m6837a(this.f16067T.left);
        }
        this.f16079am.m6835a(getHeight() / 2);
        this.f16079am.m6830c(getWidth() - this.f16080an);
        this.f16079am.m6834a(canvas);
    }

    /* renamed from: b */
    public float m6905b(float f) {
        return getResources().getDisplayMetrics().scaledDensity * f;
    }

    /* renamed from: b */
    public void m6903b(Canvas canvas) {
        this.f16088av = this.f16086at;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f16071a + 1) {
                float f = this.f16080an + (this.f16081ao * i2);
                float f2 = (this.f16067T.bottom - this.f16067T.top) / 2.0f;
                if (i2 == this.f16094c) {
                    this.f16088av = this.f16064Q;
                } else if (i2 > this.f16094c) {
                    if (getProgress() - i2 >= 0) {
                        if (i2 % 3 == 0) {
                            this.f16088av = this.f16064Q;
                        } else {
                            this.f16088av = this.f16087au;
                        }
                    } else if (i2 % 3 == 0) {
                        this.f16088av = this.f16085as;
                    } else {
                        this.f16088av = this.f16086at;
                    }
                } else if (i2 - getProgress() >= 0) {
                    if (i2 % 3 == 0) {
                        this.f16088av = this.f16064Q;
                    } else {
                        this.f16088av = this.f16087au;
                    }
                } else if (i2 % 3 == 0) {
                    this.f16088av = this.f16085as;
                } else {
                    this.f16088av = this.f16086at;
                }
                canvas.drawLine(f, (getHeight() / 2) - this.f16113v, f, (getHeight() / 2) + f2, this.f16088av);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public int getMax() {
        return this.f16071a;
    }

    public String getPrefix() {
        return this.f16103l;
    }

    public int getProgress() {
        return this.f16095d;
    }

    public float getProgressTextSize() {
        return this.f16099h;
    }

    public int getReachedBarColor() {
        return this.f16096e;
    }

    public float getReachedBarHeight() {
        return this.f16100i;
    }

    public String getSuffix() {
        return this.f16102k;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max((int) this.f16099h, Math.max((int) this.f16100i, (int) this.f16101j));
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return (int) this.f16099h;
    }

    public int getTextColor() {
        return this.f16098g;
    }

    public int getUnreachedBarColor() {
        return this.f16097f;
    }

    public float getUnreachedBarHeight() {
        return this.f16101j;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        m6901c();
        if (this.f16069V) {
            canvas.drawRect(this.f16066S, this.f16062O);
        }
        if (this.f16070W) {
            canvas.drawRect(this.f16067T, this.f16061N);
        }
        m6903b(canvas);
        m6910a(canvas);
        if (this.f16072aa == null || this.f16089aw == this.f16095d) {
            return;
        }
        this.f16089aw = this.f16095d;
        this.f16072aa.mo6856a(getProgress(), this.f16071a);
        this.f16092az.removeMessages(0);
        m6915a();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m6911a(i, true), m6911a(i2, false));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f16098g = bundle.getInt(f16054x);
        this.f16099h = bundle.getFloat(f16055y);
        this.f16100i = bundle.getFloat(f16056z);
        this.f16101j = bundle.getFloat(f16040B);
        this.f16096e = bundle.getInt(f16039A);
        this.f16097f = bundle.getInt(f16041C);
        m6906b();
        setMax(bundle.getInt(f16042D));
        setProgress(bundle.getInt("progress"));
        setPrefix(bundle.getString(f16045G));
        setSuffix(bundle.getString(f16044F));
        super.onRestoreInstanceState(bundle.getParcelable(f16053w));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f16053w, super.onSaveInstanceState());
        bundle.putInt(f16054x, getTextColor());
        bundle.putFloat(f16055y, getProgressTextSize());
        bundle.putFloat(f16056z, getReachedBarHeight());
        bundle.putFloat(f16040B, getUnreachedBarHeight());
        bundle.putInt(f16039A, getReachedBarColor());
        bundle.putInt(f16041C, getUnreachedBarColor());
        bundle.putInt(f16042D, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString(f16044F, getSuffix());
        bundle.putString(f16045G, getPrefix());
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
                m6904b(motionEvent.getX(), motionEvent.getY());
                if (this.f16072aa != null) {
                    this.f16072aa.mo6857a(0);
                }
                return true;
            case 1:
                if (this.f16072aa != null) {
                    this.f16072aa.mo6857a(1);
                }
                if (this.f16072aa != null && this.f16089aw != this.f16095d) {
                    this.f16089aw = this.f16095d;
                    this.f16072aa.mo6856a(getProgress(), getMax());
                    break;
                }
                break;
            case 2:
                m6900c(motionEvent.getX());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            case 3:
                break;
            default:
                return false;
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        m6913a(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f16071a = i;
            invalidate();
        }
    }

    public void setOnProgressBarListener(AbstractC3845b abstractC3845b) {
        this.f16072aa = abstractC3845b;
    }

    public void setPrefix(String str) {
        if (str == null) {
            this.f16103l = "";
        } else {
            this.f16103l = str;
        }
    }

    public void setProgress(int i) {
        if (i > getMax() || i < 0) {
            return;
        }
        this.f16095d = i;
        this.f16089aw = i;
        invalidate();
    }

    public void setProgressTextColor(int i) {
        this.f16098g = i;
        this.f16063P.setColor(this.f16098g);
        invalidate();
    }

    public void setProgressTextSize(float f) {
        this.f16099h = f;
        this.f16063P.setTextSize(this.f16099h);
        invalidate();
    }

    public void setProgressTextVisibility(EnumC3838a enumC3838a) {
        invalidate();
    }

    public void setReachedBarColor(int i) {
        this.f16096e = i;
        this.f16061N.setColor(this.f16096e);
        invalidate();
    }

    public void setReachedBarHeight(float f) {
        this.f16100i = f;
    }

    public void setSuffix(String str) {
        if (str == null) {
            this.f16102k = "";
        } else {
            this.f16102k = str;
        }
    }

    public void setTitle(String str) {
        this.f16104m = str;
        invalidate();
    }

    public void setUnreachedBarColor(int i) {
        this.f16097f = i;
        this.f16062O.setColor(this.f16097f);
        invalidate();
    }

    public void setUnreachedBarHeight(float f) {
        this.f16101j = f;
    }
}
