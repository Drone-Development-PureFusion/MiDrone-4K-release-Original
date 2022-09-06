package com.fimi.soul.module.setting.gimaltuneparameter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
/* loaded from: classes.dex */
public class GimalTuneParameterView extends View {

    /* renamed from: A */
    private AbstractC3505a f13836A;

    /* renamed from: B */
    private boolean f13837B;

    /* renamed from: C */
    private EnumC3506b f13838C;

    /* renamed from: D */
    private boolean f13839D;

    /* renamed from: E */
    private int f13840E;

    /* renamed from: F */
    private int f13841F;

    /* renamed from: G */
    private float f13842G;

    /* renamed from: H */
    private float f13843H;

    /* renamed from: a */
    int f13844a;

    /* renamed from: b */
    int f13845b;

    /* renamed from: c */
    int f13846c;

    /* renamed from: d */
    int f13847d;

    /* renamed from: e */
    int f13848e;

    /* renamed from: f */
    int f13849f;

    /* renamed from: g */
    float f13850g;

    /* renamed from: h */
    float f13851h;

    /* renamed from: i */
    float f13852i;

    /* renamed from: j */
    boolean f13853j;

    /* renamed from: k */
    private Paint f13854k;

    /* renamed from: l */
    private Paint f13855l;

    /* renamed from: m */
    private Paint f13856m;

    /* renamed from: n */
    private Paint f13857n;

    /* renamed from: o */
    private Paint f13858o;

    /* renamed from: p */
    private String f13859p;

    /* renamed from: q */
    private Bitmap f13860q;

    /* renamed from: r */
    private Bitmap f13861r;

    /* renamed from: s */
    private float f13862s;

    /* renamed from: t */
    private boolean f13863t;

    /* renamed from: u */
    private int f13864u;

    /* renamed from: v */
    private boolean f13865v;

    /* renamed from: w */
    private int f13866w;

    /* renamed from: x */
    private int f13867x;

    /* renamed from: y */
    private float f13868y;

    /* renamed from: z */
    private float f13869z;

    /* renamed from: com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterView$a */
    /* loaded from: classes.dex */
    public interface AbstractC3505a {
        /* renamed from: a */
        void mo8202a();

        /* renamed from: a */
        void mo8201a(int i, boolean z);
    }

    /* renamed from: com.fimi.soul.module.setting.gimaltuneparameter.GimalTuneParameterView$b */
    /* loaded from: classes.dex */
    public enum EnumC3506b {
        NOMAL,
        ALL_NO_OPERABLE,
        AUTO_TUNE
    }

    public GimalTuneParameterView(Context context) {
        super(context);
        this.f13854k = new Paint(1);
        this.f13855l = new Paint(1);
        this.f13856m = new Paint(1);
        this.f13857n = new Paint(1);
        this.f13858o = new Paint(1);
        this.f13863t = false;
        this.f13837B = true;
        this.f13838C = EnumC3506b.NOMAL;
        this.f13839D = false;
        this.f13840E = 80;
        this.f13841F = 120;
        this.f13853j = true;
    }

    public GimalTuneParameterView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GimalTuneParameterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13854k = new Paint(1);
        this.f13855l = new Paint(1);
        this.f13856m = new Paint(1);
        this.f13857n = new Paint(1);
        this.f13858o = new Paint(1);
        this.f13863t = false;
        this.f13837B = true;
        this.f13838C = EnumC3506b.NOMAL;
        this.f13839D = false;
        this.f13840E = 80;
        this.f13841F = 120;
        this.f13853j = true;
        m8212a();
    }

    /* renamed from: a */
    private void m8212a() {
        this.f13860q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.button_setup_parameter_adjust_automatic);
        this.f13856m.setTextAlign(Paint.Align.CENTER);
        this.f13856m.setColor(getResources().getColor(C2300R.color.gimal_tune_para_tune_text));
        this.f13856m.setTypeface(C3658ar.m7615a(getResources().getAssets()));
        this.f13856m.setFakeBoldText(true);
        this.f13856m.setTextSize(getResources().getDimension(C2300R.dimen.gimal_tune_para_text_size));
        this.f13854k.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle));
        this.f13854k.setStyle(Paint.Style.STROKE);
        this.f13868y = getResources().getDimension(C2300R.dimen.gimal_tune_para_arc);
        this.f13854k.setStrokeWidth(getResources().getDimension(C2300R.dimen.gimal_tune_para_arc));
        this.f13855l.setColor(getResources().getColor(C2300R.color.gimal_tune_para_text));
        this.f13855l.setStyle(Paint.Style.STROKE);
        this.f13855l.setStrokeWidth(getResources().getDimension(C2300R.dimen.gimal_tune_para_arc));
        this.f13857n.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle));
        this.f13857n.setStyle(Paint.Style.STROKE);
        this.f13857n.setTextSize(getResources().getDimension(C2300R.dimen.gimal_tune_para_scale_text_size));
        this.f13857n.setTypeface(C3658ar.m7615a(getResources().getAssets()));
        this.f13858o.setTextAlign(Paint.Align.CENTER);
        this.f13858o.setColor(getResources().getColor(C2300R.color.gimal_tune_para_tune_text));
        this.f13858o.setTypeface(C3658ar.m7615a(getResources().getAssets()));
        this.f13858o.setTextSize(getResources().getDimension(C2300R.dimen.gimal_tune_para_text_progress_size));
        this.f13859p = getResources().getText(C2300R.C2303string.gimal_tune_para_auto_tune).toString();
        this.f13852i = getResources().getDimension(C2300R.dimen.gimal_tune_para_arc_radius);
        this.f13862s = getResources().getDimension(C2300R.dimen.gimal_tune_para_inner_circle_radius);
        this.f13869z = getResources().getDimension(C2300R.dimen.gimal_tune_para_arc_text_distance);
        this.f13861r = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.icon_setup_parameter_adjust_slider);
        this.f13864u = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    /* renamed from: a */
    private void m8210a(float f, float f2, boolean z) {
        float sqrt = (float) Math.sqrt(Math.pow(f - (this.f13848e / 2), 2.0d) + Math.pow(f2 - (this.f13849f / 2), 2.0d));
        if (this.f13843H > (this.f13849f / 2) + this.f13846c + (this.f13861r.getHeight() / 2)) {
            return;
        }
        if (f2 > (this.f13849f / 2) + this.f13846c + (this.f13861r.getHeight() / 2)) {
            if (f < (this.f13848e / 2) + this.f13844a) {
                this.f13866w = getMinValue();
            } else {
                this.f13866w = getMaxValue();
            }
            this.f13850g = (float) (this.f13844a + (this.f13848e / 2) + (this.f13852i * Math.cos(3.141592653589793d - ((this.f13866w * 3.141592653589793d) / (this.f13841F - this.f13840E)))));
            this.f13851h = (float) (this.f13846c + (this.f13849f / 2) + (this.f13852i * Math.sin((-3.141592653589793d) + ((this.f13866w * 3.141592653589793d) / (this.f13841F - this.f13840E)))));
            invalidate();
        } else if (sqrt >= this.f13852i + 100.0f || sqrt <= this.f13852i - 100.0f || z) {
            invalidate();
        } else {
            this.f13851h = (float) ((this.f13849f / 2) + (this.f13852i * Math.sin(Math.atan2(f - (this.f13848e / 2), (this.f13849f / 2) - f2) - 1.5707963267948966d)));
            if (this.f13851h > this.f13846c + (this.f13849f / 2)) {
                this.f13851h = this.f13846c + (this.f13849f / 2);
                if (f < this.f13844a + (this.f13848e / 2)) {
                    this.f13850g = (this.f13844a + (this.f13848e / 2)) - this.f13852i;
                } else {
                    this.f13850g = this.f13844a + (this.f13848e / 2) + this.f13852i;
                }
            } else {
                this.f13850g = (float) ((this.f13848e / 2) + (this.f13852i * Math.cos(Math.atan2(f - (this.f13848e / 2), (this.f13849f / 2) - f2) - 1.5707963267948966d)));
            }
            invalidate();
        }
    }

    /* renamed from: a */
    private void m8209a(Canvas canvas) {
        canvas.drawText(String.valueOf(this.f13840E), ((((this.f13848e / 2) - this.f13852i) - this.f13868y) - this.f13869z) - this.f13857n.measureText(String.valueOf(this.f13840E)), this.f13846c + (this.f13849f / 2), this.f13857n);
        canvas.drawText(String.valueOf(this.f13841F), this.f13844a + (this.f13848e / 2) + this.f13852i + this.f13868y + this.f13869z, this.f13846c + (this.f13849f / 2), this.f13857n);
    }

    /* renamed from: b */
    private void m8208b() {
        this.f13844a = getPaddingLeft();
        this.f13845b = getPaddingRight();
        this.f13846c = getPaddingTop();
        this.f13847d = getPaddingBottom();
        this.f13848e = (getWidth() - this.f13844a) - this.f13845b;
        this.f13849f = (getWidth() - this.f13846c) - this.f13847d;
        if (this.f13853j) {
            this.f13853j = false;
            this.f13850g = (float) (this.f13844a + (this.f13848e / 2) + (this.f13852i * Math.cos(3.141592653589793d - ((this.f13866w * 3.141592653589793d) / (this.f13841F - this.f13840E)))));
            this.f13851h = (float) (this.f13846c + (this.f13849f / 2) + (this.f13852i * Math.sin((-3.141592653589793d) + ((this.f13866w * 3.141592653589793d) / (this.f13841F - this.f13840E)))));
        }
    }

    /* renamed from: b */
    private void m8207b(Canvas canvas) {
        canvas.drawBitmap(this.f13860q, (this.f13844a + (this.f13848e / 2)) - (this.f13860q.getWidth() / 2), (this.f13846c + (this.f13849f / 2)) - (this.f13860q.getHeight() / 2), (Paint) null);
    }

    /* renamed from: c */
    private void m8206c() {
        this.f13865v = false;
    }

    /* renamed from: c */
    private void m8205c(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f13856m.getFontMetrics();
        float f = fontMetrics.top;
        float f2 = fontMetrics.bottom;
        if (this.f13838C != EnumC3506b.AUTO_TUNE) {
            this.f13856m.setColor(getResources().getColor(C2300R.color.gimal_tune_para_text));
            canvas.drawText(this.f13859p, this.f13844a + (this.f13848e / 2), ((this.f13846c + (this.f13849f / 2)) - (f / 2.0f)) - (f2 / 2.0f), this.f13856m);
            return;
        }
        this.f13856m.setColor(getResources().getColor(C2300R.color.gimal_tune_para_tune_text));
        canvas.drawText(this.f13859p, this.f13844a + (this.f13848e / 2), ((this.f13846c + (this.f13849f / 2)) - (f * 3.0f)) - (f2 * 3.0f), this.f13856m);
        canvas.drawText(String.valueOf(this.f13867x) + "%", this.f13844a + (this.f13848e / 2), this.f13846c + (this.f13849f / 2), this.f13858o);
    }

    /* renamed from: d */
    private void m8204d(Canvas canvas) {
        RectF rectF = new RectF();
        rectF.left = (this.f13844a + (this.f13848e / 2)) - this.f13852i;
        rectF.top = (this.f13846c + (this.f13849f / 2)) - this.f13852i;
        rectF.right = this.f13844a + (this.f13848e / 2) + this.f13852i;
        rectF.bottom = this.f13846c + (this.f13849f / 2) + this.f13852i;
        canvas.drawArc(rectF, 180.0f, 180.0f, false, this.f13854k);
        if (this.f13866w > getMaxValue()) {
            this.f13866w = getMinValue();
        }
        int minValue = ((this.f13866w - getMinValue()) * Opcodes.GETFIELD) / (getMaxValue() - getMinValue());
        if (this.f13838C == EnumC3506b.NOMAL) {
            canvas.drawArc(rectF, 180.0f, minValue, false, this.f13855l);
        }
    }

    /* renamed from: e */
    private void m8203e(Canvas canvas) {
        canvas.drawBitmap(this.f13861r, this.f13850g - (this.f13861r.getWidth() / 2), this.f13851h - (this.f13861r.getHeight() / 2), (Paint) null);
        this.f13866w = (int) Math.round(this.f13841F + (((this.f13841F - this.f13840E) * Math.atan2(this.f13851h - (this.f13849f / 2), this.f13850g - (this.f13848e / 2))) / 3.141592653589793d));
        if (this.f13866w == 160) {
            this.f13866w = 80;
        }
        if (this.f13836A != null) {
            this.f13836A.mo8201a(this.f13866w, this.f13839D);
            this.f13839D = false;
        }
    }

    /* renamed from: a */
    public boolean m8211a(float f, float f2, float f3) {
        return f >= (((float) (this.f13844a + (this.f13848e / 2))) - this.f13862s) - f3 && f2 >= (((float) (this.f13846c + (this.f13849f / 2))) - this.f13862s) - f3 && f < (((float) (this.f13844a + (this.f13848e / 2))) + this.f13862s) + f3 && f2 < (((float) (this.f13846c + (this.f13849f / 2))) + this.f13862s) + f3;
    }

    public int getMaxValue() {
        return this.f13841F;
    }

    public int getMinValue() {
        return this.f13840E;
    }

    public int getProgress() {
        return this.f13866w;
    }

    public EnumC3506b getState() {
        return this.f13838C;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m8208b();
        m8207b(canvas);
        m8205c(canvas);
        m8204d(canvas);
        m8203e(canvas);
        m8209a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(200, 200);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(200, size2);
        } else if (mode2 != Integer.MIN_VALUE) {
        } else {
            setMeasuredDimension(size, 200);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f13837B) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    if (Math.pow((x - (this.f13848e / 2)) - this.f13844a, 2.0d) + Math.pow((y - (this.f13849f / 2)) - this.f13846c, 2.0d) >= Math.pow(this.f13862s - this.f13869z, 2.0d)) {
                        this.f13842G = x;
                        this.f13843H = y;
                        m8210a(x, y, false);
                        break;
                    } else {
                        this.f13863t = true;
                        this.f13865v = true;
                        setIsCenterBtnState(true);
                        break;
                    }
                case 1:
                    if (!this.f13863t) {
                        this.f13839D = true;
                        m8210a(x, y, true);
                        break;
                    } else {
                        if (this.f13865v && this.f13836A != null) {
                            this.f13836A.mo8202a();
                        }
                        this.f13863t = false;
                        setIsCenterBtnState(false);
                        break;
                    }
                    break;
                case 2:
                    if (!this.f13863t) {
                        m8210a(x, y, false);
                        break;
                    } else if (!m8211a(x, y, this.f13864u)) {
                        m8206c();
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    public void setCenterBtnText(String str) {
        this.f13859p = str;
    }

    public void setGimalTuneParameterListerner(AbstractC3505a abstractC3505a) {
        this.f13836A = abstractC3505a;
    }

    public void setIsCenterBtnState(boolean z) {
        if (z) {
            this.f13860q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.button_setup_parameter_adjust_automatic_click);
        } else {
            this.f13860q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.button_setup_parameter_adjust_automatic);
        }
        invalidate();
    }

    public void setMaxValue(int i) {
        if (i != this.f13840E) {
            this.f13841F = i;
            invalidate();
        }
    }

    public void setMinValue(int i) {
        if (i != this.f13840E) {
            this.f13840E = i;
            invalidate();
        }
    }

    public void setProgress(int i) {
        this.f13866w = i;
        if (this.f13848e == 0 || this.f13849f == 0) {
            return;
        }
        this.f13850g = (float) (this.f13844a + (this.f13848e / 2) + (this.f13852i * Math.cos(3.141592653589793d - ((this.f13866w * 3.141592653589793d) / (this.f13841F - this.f13840E)))));
        this.f13851h = (float) (this.f13846c + (this.f13849f / 2) + (this.f13852i * Math.sin((-3.141592653589793d) + ((this.f13866w * 3.141592653589793d) / (this.f13841F - this.f13840E)))));
        invalidate();
    }

    public void setState(EnumC3506b enumC3506b) {
        this.f13838C = enumC3506b;
        if (enumC3506b == EnumC3506b.NOMAL) {
            this.f13860q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.button_setup_parameter_adjust_automatic);
            this.f13854k.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle));
            this.f13855l.setColor(getResources().getColor(C2300R.color.gimal_tune_para_text));
            this.f13857n.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle));
            this.f13837B = true;
        } else if (enumC3506b == EnumC3506b.ALL_NO_OPERABLE) {
            this.f13860q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.button_setup_parameter_adjust_automatic_no);
            this.f13854k.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle_gray));
            this.f13855l.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle_gray));
            this.f13857n.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle_gray));
            this.f13837B = false;
        } else if (enumC3506b == EnumC3506b.AUTO_TUNE) {
            this.f13860q = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.button_setup_parameter_adjust_automatic_no);
            this.f13854k.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle_gray));
            this.f13855l.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle_gray));
            this.f13857n.setColor(getResources().getColor(C2300R.color.gimal_tune_para_outer_circle_gray));
            this.f13837B = false;
        }
        invalidate();
    }

    public void setTuneProgress(int i) {
        this.f13867x = i;
        invalidate();
    }
}
