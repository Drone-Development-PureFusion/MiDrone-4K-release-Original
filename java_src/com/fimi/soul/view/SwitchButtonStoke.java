package com.fimi.soul.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.fimi.kernel.utils.C2271p;
/* loaded from: classes.dex */
public class SwitchButtonStoke extends View {

    /* renamed from: b */
    private SpringSystem f15497b;

    /* renamed from: c */
    private Spring f15498c;

    /* renamed from: d */
    private float f15499d;

    /* renamed from: k */
    private Paint f15506k;

    /* renamed from: n */
    private float f15509n;

    /* renamed from: o */
    private float f15510o;

    /* renamed from: p */
    private float f15511p;

    /* renamed from: q */
    private float f15512q;

    /* renamed from: r */
    private float f15513r;

    /* renamed from: s */
    private int f15514s;

    /* renamed from: t */
    private float f15515t;

    /* renamed from: w */
    private AbstractC3731a f15518w;

    /* renamed from: e */
    private int f15500e = 0;

    /* renamed from: f */
    private int f15501f = Color.parseColor("#63000000");

    /* renamed from: g */
    private int f15502g = Color.parseColor("#51000000");

    /* renamed from: h */
    private int f15503h = Color.parseColor("#ededed");

    /* renamed from: i */
    private int f15504i = Color.parseColor("#ededed");

    /* renamed from: j */
    private int f15505j = Color.parseColor("#ff4f00");

    /* renamed from: l */
    private boolean f15507l = false;

    /* renamed from: m */
    private int f15508m = 1;

    /* renamed from: u */
    private RectF f15516u = new RectF();

    /* renamed from: v */
    private boolean f15517v = true;

    /* renamed from: a */
    SimpleSpringListener f15496a = new SimpleSpringListener() { // from class: com.fimi.soul.view.SwitchButtonStoke.2
        @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            SwitchButtonStoke.this.m7253a(spring.getCurrentValue());
        }
    };

    /* renamed from: com.fimi.soul.view.SwitchButtonStoke$a */
    /* loaded from: classes.dex */
    public interface AbstractC3731a {
        /* renamed from: a */
        void mo7246a(View view, boolean z);
    }

    private SwitchButtonStoke(Context context) {
        super(context);
    }

    public SwitchButtonStoke(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(attributeSet);
    }

    public SwitchButtonStoke(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(attributeSet);
    }

    /* renamed from: a */
    private int m7252a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7253a(double d) {
        this.f15515t = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.f15512q, this.f15513r);
        float mapValueFromRangeToRange = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.f15514s);
        int blue = Color.blue(this.f15505j);
        int red = Color.red(this.f15505j);
        int green = Color.green(this.f15505j);
        int blue2 = Color.blue(this.f15504i);
        int red2 = Color.red(this.f15504i);
        int green2 = Color.green(this.f15504i);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange3 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.f15503h = Color.rgb(m7252a(mapValueFromRangeToRange3, 0, 255), m7252a((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), m7252a(mapValueFromRangeToRange2, 0, 255));
        postInvalidate();
    }

    /* renamed from: a */
    private void m7249a(boolean z) {
        double d = 1.0d;
        if (z) {
            Spring spring = this.f15498c;
            if (!this.f15507l) {
                d = 0.0d;
            }
            spring.setEndValue(d);
            return;
        }
        this.f15498c.setCurrentValue(this.f15507l ? 1.0d : 0.0d);
        if (!this.f15507l) {
            d = 0.0d;
        }
        m7253a(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7247b() {
        this.f15507l = !this.f15507l;
        m7249a(true);
        setSwitchState(this.f15507l);
        if (this.f15518w != null) {
            this.f15518w.mo7246a(this, this.f15507l);
        }
    }

    /* renamed from: a */
    public void m7248a(boolean z, boolean z2) {
        this.f15507l = z;
        m7249a(z2);
    }

    /* renamed from: a */
    public boolean m7254a() {
        return this.f15517v;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f15506k.setStyle(Paint.Style.STROKE);
        this.f15506k.setAntiAlias(true);
        float m12870a = C2271p.m12870a(getContext(), 0.5f);
        this.f15516u.set(m12870a, m12870a, getWidth() - m12870a, getHeight() - m12870a);
        this.f15506k.setColor(this.f15501f);
        this.f15506k.setStrokeWidth(C2271p.m12870a(getContext(), 0.7f));
        canvas.drawRoundRect(this.f15516u, this.f15499d, this.f15499d, this.f15506k);
        this.f15506k.setStyle(Paint.Style.FILL);
        this.f15506k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        this.f15516u.set((this.f15515t - this.f15499d) + 4.0f, (this.f15509n - this.f15499d) + 4.0f, (this.f15515t - 4.0f) + this.f15499d, (this.f15509n + this.f15499d) - 4.0f);
        if (this.f15507l) {
            this.f15506k.setColor(this.f15505j);
        } else {
            this.f15506k.setColor(this.f15502g);
        }
        canvas.drawRoundRect(this.f15516u, this.f15499d, this.f15499d, this.f15506k);
        float f = this.f15514s * 0.45f;
        this.f15516u.set(this.f15515t - f, this.f15509n - f, this.f15515t + f, this.f15509n + f);
        this.f15506k.setColor(this.f15503h);
        canvas.drawRoundRect(this.f15516u, f, f, this.f15506k);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f15498c.addListener(this.f15496a);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15498c.removeListener(this.f15496a);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        this.f15499d = Math.min(width, height) * 0.5f;
        this.f15509n = this.f15499d;
        this.f15510o = this.f15499d;
        this.f15511p = width - this.f15499d;
        this.f15512q = this.f15510o + this.f15508m;
        this.f15513r = this.f15511p - this.f15508m;
        this.f15514s = height - (this.f15508m * 4);
        this.f15515t = this.f15507l ? this.f15513r : this.f15512q;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        View.MeasureSpec.getSize(i);
        int size = View.MeasureSpec.getSize(i2);
        Resources system = Resources.getSystem();
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 50.0f, system.getDisplayMetrics()), 1073741824);
        }
        if (size == 0 || size == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) TypedValue.applyDimension(1, 30.0f, system.getDisplayMetrics()), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setAnimate(boolean z) {
        this.f15517v = z;
    }

    public void setOnSwitchListener(AbstractC3731a abstractC3731a) {
        this.f15518w = abstractC3731a;
    }

    public void setSwitchState(boolean z) {
        m7248a(z, true);
    }

    public void setup(AttributeSet attributeSet) {
        this.f15506k = new Paint(1);
        this.f15506k.setStyle(Paint.Style.STROKE);
        this.f15506k.setStrokeCap(Paint.Cap.ROUND);
        this.f15497b = SpringSystem.create();
        this.f15498c = this.f15497b.createSpring();
        this.f15498c.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: com.fimi.soul.view.SwitchButtonStoke.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwitchButtonStoke.this.m7247b();
            }
        });
    }
}
