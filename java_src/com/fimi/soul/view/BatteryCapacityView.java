package com.fimi.soul.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
import com.fimi.soul.utils.C3658ar;
/* loaded from: classes.dex */
public class BatteryCapacityView extends View {

    /* renamed from: i */
    private static final int f15181i = -90;

    /* renamed from: j */
    private static final int f15182j = Color.parseColor("#19ffffff");

    /* renamed from: k */
    private static final int f15183k = Color.parseColor("#30b0e5");

    /* renamed from: l */
    private static final int f15184l = Color.parseColor("#fe5400");

    /* renamed from: m */
    private static final int f15185m = Color.parseColor("#f62f14");

    /* renamed from: n */
    private static final int f15186n = Color.parseColor("#FFFFFFFF");

    /* renamed from: o */
    private static final int f15187o = Color.parseColor("#7fFFFFFF");

    /* renamed from: a */
    float f15188a;

    /* renamed from: b */
    private Paint f15189b;

    /* renamed from: c */
    private Paint f15190c;

    /* renamed from: d */
    private int f15191d;

    /* renamed from: e */
    private int f15192e;

    /* renamed from: f */
    private Context f15193f;

    /* renamed from: g */
    private int f15194g = -1;

    /* renamed from: h */
    private Rect f15195h;

    public BatteryCapacityView(Context context) {
        super(context);
        m7358a(context);
    }

    public BatteryCapacityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7358a(context);
    }

    public BatteryCapacityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7358a(context);
    }

    /* renamed from: a */
    private void m7358a(Context context) {
        this.f15193f = context;
        this.f15188a = this.f15193f.getResources().getDimension(C2300R.dimen.battery_capacity);
        this.f15189b = new Paint();
        this.f15189b.setAntiAlias(true);
        this.f15189b.setColor(f15182j);
        this.f15189b.setStyle(Paint.Style.STROKE);
        this.f15189b.setStrokeWidth(this.f15188a);
        this.f15189b.setStrokeCap(Paint.Cap.ROUND);
        this.f15195h = new Rect();
        this.f15190c = new Paint();
        this.f15190c.setStrokeWidth(this.f15188a);
        this.f15190c.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f15189b.setColor(f15182j);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - this.f15188a, this.f15189b);
        if (this.f15194g == -1) {
            this.f15189b.setColor(f15183k);
            this.f15190c.setColor(f15186n);
        } else if (this.f15194g < 15) {
            this.f15189b.setColor(f15185m);
            this.f15190c.setColor(f15185m);
        } else if (this.f15194g < 30) {
            this.f15189b.setColor(f15184l);
            this.f15190c.setColor(f15184l);
        } else {
            this.f15189b.setColor(f15183k);
            this.f15190c.setColor(f15186n);
        }
        RectF rectF = new RectF();
        rectF.left = this.f15188a;
        rectF.top = this.f15188a;
        rectF.right = getWidth() - this.f15188a;
        rectF.bottom = getHeight() - this.f15188a;
        canvas.drawArc(rectF, -90.0f, this.f15194g == -1 ? 0.0f : (this.f15194g * 360) / 100, false, this.f15189b);
        String string = this.f15194g == -1 ? this.f15193f.getResources().getString(C2300R.C2303string.no_use) : String.valueOf(this.f15194g + "%");
        this.f15190c.setTextSize(this.f15193f.getResources().getDimension(C2300R.dimen.battery_capacity_font));
        this.f15190c.setTypeface(C3658ar.m7599b(this.f15193f.getAssets()));
        this.f15190c.getTextBounds(string, 0, string.length(), this.f15195h);
        float height = this.f15195h.height();
        canvas.drawText(string, (getWidth() / 2) - (this.f15195h.width() / 2.0f), (getHeight() * 0.32f) + height, this.f15190c);
        String string2 = this.f15193f.getString(C2300R.C2303string.battery_remaining);
        this.f15190c.setTypeface(C3658ar.m7615a(this.f15193f.getAssets()));
        this.f15190c.setColor(f15187o);
        this.f15190c.setTextSize(this.f15193f.getResources().getDimension(C2300R.dimen.battery_capacity_font_child));
        this.f15190c.getTextBounds(string2, 0, string2.length(), this.f15195h);
        canvas.drawText(string2, (getWidth() / 2) - (this.f15195h.width() / 2.0f), height + (getHeight() * 0.32f) + this.f15195h.height() + (getHeight() * 0.06f), this.f15190c);
    }

    public void setPercent(int i) {
        this.f15194g = i;
        invalidate();
    }
}
