package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.MapProjection;
/* renamed from: com.amap.api.mapcore.util.ej */
/* loaded from: classes.dex */
public class C0947ej extends LinearLayout {

    /* renamed from: a */
    Bitmap f2907a;

    /* renamed from: b */
    Bitmap f2908b;

    /* renamed from: c */
    Bitmap f2909c;

    /* renamed from: d */
    ImageView f2910d;

    /* renamed from: e */
    AbstractC1115l f2911e;

    /* renamed from: f */
    Matrix f2912f = new Matrix();

    public C0947ej(Context context, AbstractC1115l abstractC1115l) {
        super(context);
        this.f2911e = abstractC1115l;
        try {
            this.f2909c = C0945eh.m18356a(context, "maps_dav_compass_needle_large.png");
            this.f2908b = C0945eh.m18355a(this.f2909c, C1022g.f3199a * 0.8f);
            this.f2909c = C0945eh.m18355a(this.f2909c, C1022g.f3199a * 0.7f);
            if (this.f2908b == null && this.f2909c == null) {
                return;
            }
            this.f2907a = Bitmap.createBitmap(this.f2908b.getWidth(), this.f2908b.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f2907a);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(this.f2909c, (this.f2908b.getWidth() - this.f2909c.getWidth()) / 2.0f, (this.f2908b.getHeight() - this.f2909c.getHeight()) / 2.0f, paint);
            this.f2910d = new ImageView(context);
            this.f2910d.setScaleType(ImageView.ScaleType.MATRIX);
            this.f2910d.setImageBitmap(this.f2907a);
            this.f2910d.setClickable(true);
            m18307a();
            this.f2910d.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.mapcore.util.ej.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (C0947ej.this.f2911e.isMaploaded()) {
                            if (motionEvent.getAction() == 0) {
                                C0947ej.this.f2910d.setImageBitmap(C0947ej.this.f2908b);
                            } else if (motionEvent.getAction() == 1) {
                                C0947ej.this.f2910d.setImageBitmap(C0947ej.this.f2907a);
                                CameraPosition cameraPosition = C0947ej.this.f2911e.getCameraPosition();
                                C0947ej.this.f2911e.mo17532b(C0768ag.m19101a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                            }
                        }
                    } catch (Throwable th) {
                        C1007fo.m18012b(th, "CompassView", "onTouch");
                        th.printStackTrace();
                    }
                    return false;
                }
            });
            addView(this.f2910d);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18307a() {
        try {
            MapProjection mo17530c = this.f2911e.mo17530c();
            if (mo17530c == null || this.f2910d == null) {
                return;
            }
            float mapAngle = mo17530c.getMapAngle();
            float cameraHeaderAngle = mo17530c.getCameraHeaderAngle();
            if (this.f2912f == null) {
                this.f2912f = new Matrix();
            }
            this.f2912f.reset();
            this.f2912f.postRotate(-mapAngle, this.f2910d.getDrawable().getBounds().width() / 2.0f, this.f2910d.getDrawable().getBounds().height() / 2.0f);
            this.f2912f.postScale(1.0f, (float) Math.cos((cameraHeaderAngle * 3.141592653589793d) / 180.0d), this.f2910d.getDrawable().getBounds().width() / 2.0f, this.f2910d.getDrawable().getBounds().height() / 2.0f);
            this.f2910d.setImageMatrix(this.f2912f);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18306a(boolean z) {
        if (!z) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        m18307a();
    }
}
