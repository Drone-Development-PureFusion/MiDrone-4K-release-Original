package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.p001v4.view.ViewCompat;
import android.view.View;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
/* renamed from: com.amap.api.mapcore.util.en */
/* loaded from: classes.dex */
public class C0961en extends View {

    /* renamed from: c */
    private AbstractC1115l f2979c;

    /* renamed from: a */
    private String f2977a = "";

    /* renamed from: b */
    private int f2978b = 0;

    /* renamed from: g */
    private final int[] f2983g = {10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 5};

    /* renamed from: d */
    private Paint f2980d = new Paint();

    /* renamed from: f */
    private Rect f2982f = new Rect();

    /* renamed from: e */
    private Paint f2981e = new Paint();

    public C0961en(Context context, AbstractC1115l abstractC1115l) {
        super(context);
        this.f2979c = abstractC1115l;
        this.f2980d.setAntiAlias(true);
        this.f2980d.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2980d.setStrokeWidth(2.0f * C1022g.f3199a);
        this.f2980d.setStyle(Paint.Style.STROKE);
        this.f2981e.setAntiAlias(true);
        this.f2981e.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2981e.setTextSize(20.0f * C1022g.f3199a);
    }

    /* renamed from: a */
    public void m18225a() {
        if (this.f2979c == null) {
            return;
        }
        try {
            CameraPosition cameraPosition = this.f2979c.getCameraPosition();
            if (cameraPosition == null) {
                return;
            }
            LatLng latLng = cameraPosition.target;
            float mo17512o = this.f2979c.mo17512o();
            float mo17508u = this.f2979c.mo17508u();
            int cos = (int) (this.f2983g[(int) mo17512o] / (mo17508u * ((float) ((((Math.cos((latLng.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, mo17512o))))));
            String m18319b = C0945eh.m18319b(this.f2983g[(int) mo17512o]);
            m18224a(cos);
            m18223a(m18319b);
            invalidate();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18224a(int i) {
        this.f2978b = i;
    }

    /* renamed from: a */
    public void m18223a(String str) {
        this.f2977a = str;
    }

    /* renamed from: a */
    public void m18222a(boolean z) {
        if (z) {
            setVisibility(0);
            m18225a();
            return;
        }
        m18223a("");
        m18224a(0);
        setVisibility(8);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Point mo17510q;
        if (this.f2977a == null || this.f2977a.equals("") || this.f2978b == 0 || (mo17510q = this.f2979c.mo17510q()) == null) {
            return;
        }
        this.f2981e.getTextBounds(this.f2977a, 0, this.f2977a.length(), this.f2982f);
        int i = mo17510q.x;
        int height = (mo17510q.y - this.f2982f.height()) + 5;
        canvas.drawText(this.f2977a, i, height, this.f2981e);
        int height2 = height + (this.f2982f.height() - 5);
        canvas.drawLine(i, height2 - 2, i, height2 + 2, this.f2980d);
        canvas.drawLine(i, height2, this.f2978b + i, height2, this.f2980d);
        canvas.drawLine(this.f2978b + i, height2 - 2, this.f2978b + i, height2 + 2, this.f2980d);
    }
}
