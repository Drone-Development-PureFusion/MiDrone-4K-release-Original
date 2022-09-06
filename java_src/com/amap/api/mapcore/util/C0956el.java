package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
/* renamed from: com.amap.api.mapcore.util.el */
/* loaded from: classes.dex */
public class C0956el extends LinearLayout {

    /* renamed from: a */
    Bitmap f2942a;

    /* renamed from: b */
    Bitmap f2943b;

    /* renamed from: c */
    Bitmap f2944c;

    /* renamed from: d */
    Bitmap f2945d;

    /* renamed from: e */
    Bitmap f2946e;

    /* renamed from: f */
    Bitmap f2947f;

    /* renamed from: g */
    ImageView f2948g;

    /* renamed from: h */
    AbstractC1115l f2949h;

    /* renamed from: i */
    boolean f2950i = false;

    public C0956el(Context context, AbstractC1115l abstractC1115l) {
        super(context);
        this.f2949h = abstractC1115l;
        try {
            this.f2945d = C0945eh.m18356a(context, "location_selected.png");
            this.f2942a = C0945eh.m18355a(this.f2945d, C1022g.f3199a);
            this.f2946e = C0945eh.m18356a(context, "location_pressed.png");
            this.f2943b = C0945eh.m18355a(this.f2946e, C1022g.f3199a);
            this.f2947f = C0945eh.m18356a(context, "location_unselected.png");
            this.f2944c = C0945eh.m18355a(this.f2947f, C1022g.f3199a);
            this.f2948g = new ImageView(context);
            this.f2948g.setImageBitmap(this.f2942a);
            this.f2948g.setClickable(true);
            this.f2948g.setPadding(0, 20, 20, 0);
            this.f2948g.setOnTouchListener(new View.OnTouchListener() { // from class: com.amap.api.mapcore.util.el.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C0956el.this.f2950i) {
                        if (motionEvent.getAction() == 0) {
                            C0956el.this.f2948g.setImageBitmap(C0956el.this.f2943b);
                        } else if (motionEvent.getAction() == 1) {
                            try {
                                C0956el.this.f2948g.setImageBitmap(C0956el.this.f2942a);
                                C0956el.this.f2949h.setMyLocationEnabled(true);
                                Location myLocation = C0956el.this.f2949h.getMyLocation();
                                if (myLocation != null) {
                                    LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                                    C0956el.this.f2949h.mo17548a(myLocation);
                                    C0956el.this.f2949h.mo17542a(C0768ag.m19099a(latLng, C0956el.this.f2949h.mo17512o()));
                                }
                            } catch (Throwable th) {
                                C1007fo.m18012b(th, "LocationView", "onTouch");
                                th.printStackTrace();
                            }
                        }
                    }
                    return false;
                }
            });
            addView(this.f2948g);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m18272a(boolean z) {
        this.f2950i = z;
        try {
            if (z) {
                this.f2948g.setImageBitmap(this.f2942a);
            } else {
                this.f2948g.setImageBitmap(this.f2944c);
            }
            this.f2948g.invalidate();
        } catch (Throwable th) {
            C1007fo.m18012b(th, "LocationView", "showSelect");
            th.printStackTrace();
        }
    }
}
