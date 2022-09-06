package com.mining.app.zxing.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.fimi.soul.C2300R;
import com.google.zxing.ResultPoint;
import com.mining.app.zxing.p221a.C4103c;
import java.util.Collection;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class ViewfinderView extends View {

    /* renamed from: b */
    private static final int[] f17233b = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: c */
    private static final String f17234c = "log";

    /* renamed from: d */
    private static final long f17235d = 10;

    /* renamed from: e */
    private static final int f17236e = 255;

    /* renamed from: g */
    private static final int f17237g = 10;

    /* renamed from: h */
    private static final int f17238h = 6;

    /* renamed from: i */
    private static final int f17239i = 2;

    /* renamed from: j */
    private static final int f17240j = 2;

    /* renamed from: k */
    private static float f17241k = 0.0f;

    /* renamed from: l */
    private static final int f17242l = 16;

    /* renamed from: m */
    private static final int f17243m = 30;

    /* renamed from: a */
    boolean f17244a;

    /* renamed from: o */
    private int f17247o;

    /* renamed from: p */
    private int f17248p;

    /* renamed from: q */
    private Bitmap f17249q;

    /* renamed from: r */
    private final int f17250r;

    /* renamed from: s */
    private final int f17251s;

    /* renamed from: t */
    private final int f17252t;

    /* renamed from: v */
    private Collection<ResultPoint> f17254v;

    /* renamed from: w */
    private int f17255w;

    /* renamed from: x */
    private int f17256x;

    /* renamed from: z */
    private int f17258z;

    /* renamed from: f */
    private int f17245f = (int) (20.0f * f17241k);

    /* renamed from: n */
    private Paint f17246n = new Paint();

    /* renamed from: u */
    private Collection<ResultPoint> f17253u = new HashSet(5);

    /* renamed from: y */
    private Paint f17257y = new Paint();

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f17241k = context.getResources().getDisplayMetrics().density;
        Resources resources = getResources();
        this.f17250r = resources.getColor(C2300R.color.viewfinder_mask);
        this.f17251s = resources.getColor(C2300R.color.result_view);
        this.f17255w = resources.getColor(C2300R.color.viewfinder_laser);
        this.f17258z = resources.getColor(C2300R.color.kuang);
        this.f17252t = resources.getColor(C2300R.color.possible_result_points);
        this.f17257y.setStyle(Paint.Style.STROKE);
        this.f17257y.setColor(this.f17258z);
        int i = (int) ((4.0f * f17241k) / 3.0f);
        this.f17257y.setStrokeWidth(i);
        this.f17246n.setStrokeWidth(i);
    }

    /* renamed from: a */
    public void m6147a() {
        this.f17249q = null;
        invalidate();
    }

    /* renamed from: a */
    public void m6146a(Bitmap bitmap) {
        this.f17249q = bitmap;
        invalidate();
    }

    /* renamed from: a */
    public void m6145a(ResultPoint resultPoint) {
        this.f17253u.add(resultPoint);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect m6177e = C4103c.m6188a().m6177e();
        if (m6177e == null) {
            return;
        }
        if (!this.f17244a) {
            this.f17244a = true;
            this.f17247o = m6177e.top;
            this.f17248p = m6177e.bottom;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f17246n.setColor(this.f17249q != null ? this.f17251s : this.f17250r);
        canvas.drawRect(0.0f, 0.0f, width, m6177e.top, this.f17246n);
        canvas.drawRect(0.0f, m6177e.top, m6177e.left, m6177e.bottom + 1, this.f17246n);
        canvas.drawRect(m6177e.right + 1, m6177e.top, width, m6177e.bottom + 1, this.f17246n);
        canvas.drawRect(0.0f, m6177e.bottom + 1, width, height, this.f17246n);
        canvas.drawRect(m6177e.left, m6177e.top, m6177e.right, m6177e.bottom, this.f17257y);
        if (this.f17249q != null) {
            this.f17246n.setAlpha(255);
            canvas.drawBitmap(this.f17249q, m6177e.left, m6177e.top, this.f17246n);
            return;
        }
        this.f17247o += 2;
        if (this.f17247o >= m6177e.bottom) {
            this.f17247o = m6177e.top;
        }
        this.f17246n.setColor(this.f17255w);
        canvas.drawRect(m6177e.left + 2, this.f17247o - 3, m6177e.right - 2, this.f17247o + 3, this.f17246n);
        postInvalidateDelayed(f17235d, m6177e.left, m6177e.top, m6177e.right, m6177e.bottom);
    }
}
