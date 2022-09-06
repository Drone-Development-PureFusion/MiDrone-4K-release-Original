package com.fimi.soul.module.droneui;

import android.content.res.Resources;
import com.amap.api.location.DPoint;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.List;
/* renamed from: com.fimi.soul.module.droneui.c */
/* loaded from: classes.dex */
public class C3302c {

    /* renamed from: b */
    private static final int f12831b = -1;

    /* renamed from: c */
    private static final int f12832c = 2;

    /* renamed from: a */
    public Polyline f12833a;

    /* renamed from: d */
    private MapView f12834d;

    /* renamed from: e */
    private float f12835e;

    /* renamed from: f */
    private int f12836f;

    /* renamed from: com.fimi.soul.module.droneui.c$a */
    /* loaded from: classes.dex */
    public interface AbstractC3303a {
        /* renamed from: a */
        List<DPoint> m8785a();
    }

    private C3302c(MapView mapView, int i, float f, Resources resources) {
        this.f12834d = mapView;
        this.f12836f = i;
        this.f12835e = m8787a(f, resources);
    }

    public C3302c(MapView mapView, int i, Resources resources) {
        this(mapView, i, 2.0f, resources);
    }

    public C3302c(MapView mapView, Resources resources) {
        this(mapView, -1, resources);
    }

    /* renamed from: a */
    private int m8787a(double d, Resources resources) {
        return (int) Math.round(resources.getDisplayMetrics().density * d);
    }

    /* renamed from: a */
    private void m8788a() {
        if (this.f12833a == null) {
            new PolylineOptions().color(this.f12836f).width(this.f12835e);
        }
    }

    /* renamed from: a */
    public void m8786a(AbstractC3303a abstractC3303a) {
    }
}
