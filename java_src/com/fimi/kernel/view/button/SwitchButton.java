package com.fimi.kernel.view.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
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
import com.fimi.kernel.C2168R;
import com.fimi.kernel.utils.C2271p;
/* loaded from: classes.dex */
public class SwitchButton extends View {

    /* renamed from: b */
    private SpringSystem f7617b;

    /* renamed from: c */
    private Spring f7618c;

    /* renamed from: d */
    private float f7619d;

    /* renamed from: j */
    private Paint f7625j;

    /* renamed from: m */
    private float f7628m;

    /* renamed from: n */
    private float f7629n;

    /* renamed from: o */
    private float f7630o;

    /* renamed from: p */
    private float f7631p;

    /* renamed from: q */
    private float f7632q;

    /* renamed from: r */
    private int f7633r;

    /* renamed from: s */
    private float f7634s;

    /* renamed from: v */
    private AbstractC2291a f7637v;

    /* renamed from: e */
    private int f7620e = 0;

    /* renamed from: f */
    private int f7621f = Color.parseColor("#ffffff");

    /* renamed from: g */
    private int f7622g = Color.parseColor("#bcbcbd");

    /* renamed from: h */
    private int f7623h = Color.parseColor("#bcbcbd");

    /* renamed from: i */
    private int f7624i = Color.parseColor("#ff5400");

    /* renamed from: k */
    private boolean f7626k = false;

    /* renamed from: l */
    private int f7627l = 1;

    /* renamed from: t */
    private RectF f7635t = new RectF();

    /* renamed from: u */
    private boolean f7636u = true;

    /* renamed from: a */
    SimpleSpringListener f7616a = new SimpleSpringListener() { // from class: com.fimi.kernel.view.button.SwitchButton.2
        @Override // com.facebook.rebound.SimpleSpringListener, com.facebook.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            SwitchButton.this.m12672a(spring.getCurrentValue());
        }
    };

    /* renamed from: com.fimi.kernel.view.button.SwitchButton$a */
    /* loaded from: classes.dex */
    public interface AbstractC2291a {
        /* renamed from: a */
        void mo6579a(View view, boolean z);
    }

    private SwitchButton(Context context) {
        super(context);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setup(attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setup(attributeSet);
    }

    /* renamed from: a */
    private int m12671a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12672a(double d) {
        this.f7634s = (float) SpringUtil.mapValueFromRangeToRange(d, 0.0d, 1.0d, this.f7631p, this.f7632q);
        float mapValueFromRangeToRange = (float) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, 10.0d, this.f7633r);
        int blue = Color.blue(this.f7624i);
        int red = Color.red(this.f7624i);
        int green = Color.green(this.f7624i);
        int blue2 = Color.blue(this.f7623h);
        int red2 = Color.red(this.f7623h);
        int green2 = Color.green(this.f7623h);
        int mapValueFromRangeToRange2 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, blue, blue2);
        int mapValueFromRangeToRange3 = (int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, red, red2);
        this.f7622g = Color.rgb(m12671a(mapValueFromRangeToRange3, 0, 255), m12671a((int) SpringUtil.mapValueFromRangeToRange(1.0d - d, 0.0d, 1.0d, green, green2), 0, 255), m12671a(mapValueFromRangeToRange2, 0, 255));
        postInvalidate();
    }

    /* renamed from: a */
    private void m12668a(boolean z) {
        double d = 1.0d;
        if (z) {
            Spring spring = this.f7618c;
            if (!this.f7626k) {
                d = 0.0d;
            }
            spring.setEndValue(d);
            return;
        }
        this.f7618c.setCurrentValue(this.f7626k ? 1.0d : 0.0d);
        if (!this.f7626k) {
            d = 0.0d;
        }
        m12672a(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12666b() {
        this.f7626k = !this.f7626k;
        m12668a(true);
        setSwitchState(this.f7626k);
        if (this.f7637v != null) {
            this.f7637v.mo6579a(this, this.f7626k);
        }
    }

    /* renamed from: a */
    public void m12667a(boolean z, boolean z2) {
        this.f7626k = z;
        m12668a(z2);
    }

    /* renamed from: a */
    public boolean m12673a() {
        return this.f7636u;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f7625j.setStyle(Paint.Style.STROKE);
        this.f7625j.setAntiAlias(true);
        float m12870a = C2271p.m12870a(getContext(), 0.5f);
        this.f7635t.set(m12870a, m12870a, getWidth() - m12870a, getHeight() - m12870a);
        this.f7625j.setColor(603979775);
        this.f7625j.setStrokeWidth(C2271p.m12870a(getContext(), 0.7f));
        canvas.drawRoundRect(this.f7635t, this.f7619d, this.f7619d, this.f7625j);
        this.f7625j.setStyle(Paint.Style.FILL);
        this.f7625j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        this.f7635t.set((this.f7634s - 1.0f) - this.f7619d, this.f7628m - this.f7619d, this.f7634s + 1.1f + this.f7619d, this.f7628m + this.f7619d);
        this.f7625j.setColor(0);
        canvas.drawRoundRect(this.f7635t, this.f7619d, this.f7619d, this.f7625j);
        float f = this.f7633r * 0.45f;
        this.f7635t.set(this.f7634s - f, this.f7628m - f, this.f7634s + f, this.f7628m + f);
        this.f7625j.setColor(this.f7622g);
        canvas.drawRoundRect(this.f7635t, f, f, this.f7625j);
    }

    public boolean getToggleOn() {
        return this.f7626k;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7618c.addListener(this.f7616a);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7618c.removeListener(this.f7616a);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int width = getWidth();
        int height = getHeight();
        this.f7619d = Math.min(width, height) * 0.5f;
        this.f7628m = this.f7619d;
        this.f7629n = this.f7619d;
        this.f7630o = width - this.f7619d;
        this.f7631p = this.f7629n + this.f7627l;
        this.f7632q = this.f7630o - this.f7627l;
        this.f7633r = height - (this.f7627l * 4);
        this.f7634s = this.f7626k ? this.f7632q : this.f7631p;
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
        this.f7636u = z;
    }

    public void setOnSwitchListener(AbstractC2291a abstractC2291a) {
        this.f7637v = abstractC2291a;
    }

    public void setSwitchState(boolean z) {
        m12667a(z, true);
    }

    public void setup(AttributeSet attributeSet) {
        this.f7625j = new Paint(1);
        this.f7625j.setStyle(Paint.Style.STROKE);
        this.f7625j.setStrokeCap(Paint.Cap.ROUND);
        this.f7617b = SpringSystem.create();
        this.f7618c = this.f7617b.createSpring();
        this.f7618c.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(50.0d, 7.0d));
        setOnClickListener(new View.OnClickListener() { // from class: com.fimi.kernel.view.button.SwitchButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwitchButton.this.m12666b();
            }
        });
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2168R.styleable.SwitchButton);
        this.f7620e = obtainStyledAttributes.getColor(C2168R.styleable.SwitchButton_onColor, this.f7620e);
        this.f7623h = obtainStyledAttributes.getColor(C2168R.styleable.SwitchButton_spotColor, this.f7623h);
        this.f7627l = obtainStyledAttributes.getDimensionPixelSize(C2168R.styleable.SwitchButton_borderWidth, (int) C2271p.m12870a(getContext(), this.f7627l));
        this.f7636u = obtainStyledAttributes.getBoolean(C2168R.styleable.SwitchButton_animate, this.f7636u);
        obtainStyledAttributes.recycle();
    }
}
