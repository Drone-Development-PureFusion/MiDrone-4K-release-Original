package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.C0958em;
/* renamed from: com.amap.api.mapcore.util.ep */
/* loaded from: classes.dex */
class C0963ep extends LinearLayout {

    /* renamed from: a */
    private Bitmap f3004a;

    /* renamed from: b */
    private Bitmap f3005b;

    /* renamed from: c */
    private Bitmap f3006c;

    /* renamed from: d */
    private Bitmap f3007d;

    /* renamed from: e */
    private Bitmap f3008e;

    /* renamed from: f */
    private Bitmap f3009f;

    /* renamed from: g */
    private Bitmap f3010g;

    /* renamed from: h */
    private Bitmap f3011h;

    /* renamed from: i */
    private Bitmap f3012i;

    /* renamed from: j */
    private Bitmap f3013j;

    /* renamed from: k */
    private Bitmap f3014k;

    /* renamed from: l */
    private Bitmap f3015l;

    /* renamed from: m */
    private ImageView f3016m;

    /* renamed from: n */
    private ImageView f3017n;

    /* renamed from: o */
    private AbstractC1115l f3018o;

    public C0963ep(Context context, AbstractC1115l abstractC1115l) {
        super(context);
        this.f3018o = abstractC1115l;
        try {
            this.f3010g = C0945eh.m18356a(context, "zoomin_selected.png");
            this.f3004a = C0945eh.m18355a(this.f3010g, C1022g.f3199a);
            this.f3011h = C0945eh.m18356a(context, "zoomin_unselected.png");
            this.f3005b = C0945eh.m18355a(this.f3011h, C1022g.f3199a);
            this.f3012i = C0945eh.m18356a(context, "zoomout_selected.png");
            this.f3006c = C0945eh.m18355a(this.f3012i, C1022g.f3199a);
            this.f3013j = C0945eh.m18356a(context, "zoomout_unselected.png");
            this.f3007d = C0945eh.m18355a(this.f3013j, C1022g.f3199a);
            this.f3014k = C0945eh.m18356a(context, "zoomin_pressed.png");
            this.f3008e = C0945eh.m18355a(this.f3014k, C1022g.f3199a);
            this.f3015l = C0945eh.m18356a(context, "zoomout_pressed.png");
            this.f3009f = C0945eh.m18355a(this.f3015l, C1022g.f3199a);
            this.f3016m = new ImageView(context);
            this.f3016m.setImageBitmap(this.f3004a);
            this.f3016m.setClickable(true);
            this.f3017n = new ImageView(context);
            this.f3017n.setImageBitmap(this.f3006c);
            this.f3017n.setClickable(true);
            this.f3016m.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.mapcore.util.ep.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C0963ep.this.f3018o.mo17512o() < C0963ep.this.f3018o.getMaxZoomLevel() && C0963ep.this.f3018o.isMaploaded()) {
                        if (motionEvent.getAction() == 0) {
                            C0963ep.this.f3016m.setImageBitmap(C0963ep.this.f3008e);
                        } else if (motionEvent.getAction() == 1) {
                            C0963ep.this.f3016m.setImageBitmap(C0963ep.this.f3004a);
                            try {
                                C0963ep.this.f3018o.mo17532b(C0768ag.m19106a());
                            } catch (RemoteException e) {
                                C1007fo.m18012b(e, "ZoomControllerView", "zoomin ontouch");
                                e.printStackTrace();
                            }
                        }
                    }
                    return false;
                }
            });
            this.f3017n.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.mapcore.util.ep.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C0963ep.this.f3018o.mo17512o() > C0963ep.this.f3018o.getMinZoomLevel() && C0963ep.this.f3018o.isMaploaded()) {
                        if (motionEvent.getAction() == 0) {
                            C0963ep.this.f3017n.setImageBitmap(C0963ep.this.f3009f);
                        } else if (motionEvent.getAction() == 1) {
                            C0963ep.this.f3017n.setImageBitmap(C0963ep.this.f3006c);
                            try {
                                C0963ep.this.f3018o.mo17532b(C0768ag.m19094b());
                            } catch (RemoteException e) {
                                C1007fo.m18012b(e, "ZoomControllerView", "zoomout ontouch");
                                e.printStackTrace();
                            }
                        }
                    }
                    return false;
                }
            });
            this.f3016m.setPadding(0, 0, 20, -2);
            this.f3017n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f3016m);
            addView(this.f3017n);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18209a(float f) {
        try {
            if (f < this.f3018o.getMaxZoomLevel() && f > this.f3018o.getMinZoomLevel()) {
                this.f3016m.setImageBitmap(this.f3004a);
                this.f3017n.setImageBitmap(this.f3006c);
            } else if (f == this.f3018o.getMinZoomLevel()) {
                this.f3017n.setImageBitmap(this.f3007d);
                this.f3016m.setImageBitmap(this.f3004a);
            } else if (f == this.f3018o.getMaxZoomLevel()) {
                this.f3016m.setImageBitmap(this.f3005b);
                this.f3017n.setImageBitmap(this.f3006c);
            }
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18208a(int i) {
        try {
            C0958em.C0960a c0960a = (C0958em.C0960a) getLayoutParams();
            if (i == 1) {
                c0960a.f2976d = 16;
            } else if (i == 2) {
                c0960a.f2976d = 80;
            }
            setLayoutParams(c0960a);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18206a(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
