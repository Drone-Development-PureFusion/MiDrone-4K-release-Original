package com.fimi.x1bh.module.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
/* loaded from: classes.dex */
public class CloudBatteryVoltageView extends View {

    /* renamed from: m */
    private static final int f16661m = Color.parseColor("#19ffffff");

    /* renamed from: n */
    private static final int f16662n = Color.parseColor("#00000000");

    /* renamed from: o */
    private static final int f16663o = Color.parseColor("#30b0e5");

    /* renamed from: a */
    private Context f16664a;

    /* renamed from: b */
    private Paint f16665b;

    /* renamed from: c */
    private RectF f16666c;

    /* renamed from: d */
    private Paint f16667d;

    /* renamed from: e */
    private RectF f16668e;

    /* renamed from: f */
    private Bitmap f16669f;

    /* renamed from: g */
    private Bitmap f16670g;

    /* renamed from: h */
    private Bitmap f16671h;

    /* renamed from: i */
    private Bitmap f16672i;

    /* renamed from: j */
    private int f16673j = 0;

    /* renamed from: k */
    private boolean f16674k = false;

    /* renamed from: l */
    private EnumC3912a f16675l = EnumC3912a.NOMAL;

    /* renamed from: com.fimi.x1bh.module.main.CloudBatteryVoltageView$a */
    /* loaded from: classes.dex */
    public enum EnumC3912a {
        NOMAL,
        LOW,
        SERIOUS_LOW
    }

    public CloudBatteryVoltageView(Context context) {
        super(context);
        m6574a(context);
    }

    public CloudBatteryVoltageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6574a(context);
    }

    public CloudBatteryVoltageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6574a(context);
    }

    /* renamed from: a */
    private Bitmap m6575a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.f16670g.getWidth(), this.f16670g.getHeight(), Bitmap.Config.ARGB_8888);
        int width = (int) (8.0f + ((this.f16670g.getWidth() - 10) - ((this.f16673j / 100.0f) * (this.f16670g.getWidth() - 10))));
        Canvas canvas = new Canvas(createBitmap);
        if (this.f16675l == EnumC3912a.NOMAL) {
            canvas.drawBitmap(this.f16670g, 0.0f, 0.0f, paint);
        } else if (this.f16675l == EnumC3912a.LOW) {
            canvas.drawBitmap(this.f16671h, 0.0f, 0.0f, paint);
        } else {
            canvas.drawBitmap(this.f16672i, 0.0f, 0.0f, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setColor(f16662n);
        canvas.drawRect(getWidth() - width, 0.0f, getWidth(), getHeight(), paint);
        return createBitmap;
    }

    /* renamed from: a */
    public void m6574a(Context context) {
        this.f16664a = context;
        this.f16665b = new Paint();
        this.f16665b.setAntiAlias(true);
        this.f16666c = new RectF();
        this.f16667d = new Paint();
        this.f16669f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.cloud_battery_bg);
        this.f16670g = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.cloud_battery_normal);
        this.f16671h = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.cloud_battery_low);
        this.f16672i = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.cloud_battery_serious_low);
    }

    /* renamed from: a */
    public void m6573a(EnumC3912a enumC3912a) {
        this.f16675l = enumC3912a;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f16669f, 0.0f, 0.0f, this.f16665b);
        canvas.drawBitmap(m6575a(), 0.0f, 0.0f, this.f16665b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f16670g.getWidth(), this.f16670g.getHeight());
    }

    public void setPercent(int i) {
        this.f16673j = i;
        invalidate();
    }
}
