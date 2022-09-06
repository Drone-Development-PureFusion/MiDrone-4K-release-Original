package com.fimi.soul.view;

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
public class BatteryVoltageView extends View {

    /* renamed from: m */
    private static final int f15209m = Color.parseColor("#19ffffff");

    /* renamed from: n */
    private static final int f15210n = Color.parseColor("#222225");

    /* renamed from: o */
    private static final int f15211o = Color.parseColor("#30b0e5");

    /* renamed from: a */
    private Context f15212a;

    /* renamed from: b */
    private Paint f15213b;

    /* renamed from: c */
    private RectF f15214c;

    /* renamed from: d */
    private Paint f15215d;

    /* renamed from: e */
    private RectF f15216e;

    /* renamed from: f */
    private Bitmap f15217f;

    /* renamed from: g */
    private Bitmap f15218g;

    /* renamed from: h */
    private Bitmap f15219h;

    /* renamed from: i */
    private Bitmap f15220i;

    /* renamed from: j */
    private int f15221j = 0;

    /* renamed from: k */
    private boolean f15222k = false;

    /* renamed from: l */
    private EnumC3712a f15223l = EnumC3712a.NOMAL;

    /* renamed from: com.fimi.soul.view.BatteryVoltageView$a */
    /* loaded from: classes.dex */
    public enum EnumC3712a {
        NOMAL,
        EXCEPT,
        DAMAGE
    }

    public BatteryVoltageView(Context context) {
        super(context);
        m7355a(context);
    }

    public BatteryVoltageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7355a(context);
    }

    public BatteryVoltageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7355a(context);
    }

    /* renamed from: a */
    private Bitmap m7356a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createBitmap = Bitmap.createBitmap(this.f15218g.getWidth(), this.f15218g.getHeight(), Bitmap.Config.ARGB_8888);
        int height = (int) (8.0f + ((this.f15218g.getHeight() - 10) - ((this.f15221j / 100.0f) * (this.f15218g.getHeight() - 10))));
        Canvas canvas = new Canvas(createBitmap);
        if (this.f15223l == EnumC3712a.NOMAL) {
            canvas.drawBitmap(this.f15218g, 0.0f, 0.0f, paint);
        } else if (this.f15223l == EnumC3712a.EXCEPT) {
            canvas.drawBitmap(this.f15219h, 0.0f, 0.0f, paint);
        } else {
            canvas.drawBitmap(this.f15220i, 0.0f, 0.0f, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        paint.setColor(f15210n);
        canvas.drawRect(0.0f, 0.0f, getWidth(), height, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public void m7355a(Context context) {
        this.f15212a = context;
        this.f15213b = new Paint();
        this.f15213b.setAntiAlias(true);
        this.f15214c = new RectF();
        this.f15215d = new Paint();
        this.f15217f = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_battery_frame);
        this.f15218g = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_battery_blue);
        this.f15219h = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_battery_orange);
        this.f15220i = BitmapFactory.decodeResource(getResources(), C2300R.C2301drawable.img_battery_red);
    }

    /* renamed from: a */
    public void m7354a(EnumC3712a enumC3712a) {
        this.f15223l = enumC3712a;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f15217f, 0.0f, 0.0f, this.f15213b);
        canvas.drawBitmap(m7356a(), 0.0f, 0.0f, this.f15213b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f15218g.getWidth(), this.f15218g.getHeight());
    }

    public void setPercent(int i) {
        this.f15221j = i;
        invalidate();
    }
}
