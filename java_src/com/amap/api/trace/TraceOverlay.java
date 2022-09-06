package com.amap.api.trace;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TraceOverlay {
    public static final int TRACE_STATUS_FAILURE = 3;
    public static final int TRACE_STATUS_FINISH = 2;
    public static final int TRACE_STATUS_PREPARE = 4;
    public static final int TRACE_STATUS_PROCESSING = 1;

    /* renamed from: a */
    private Polyline f4522a;

    /* renamed from: b */
    private PolylineOptions f4523b;

    /* renamed from: c */
    private AMap f4524c;

    /* renamed from: d */
    private List<LatLng> f4525d = new ArrayList();

    /* renamed from: e */
    private int f4526e = 4;

    /* renamed from: f */
    private int f4527f;

    /* renamed from: g */
    private int f4528g;

    public TraceOverlay(AMap aMap) {
        this.f4524c = aMap;
        m16750a();
    }

    public TraceOverlay(AMap aMap, List<LatLng> list) {
        this.f4524c = aMap;
        m16750a();
        this.f4523b.addAll(list);
        this.f4522a = aMap.addPolyline(this.f4523b);
    }

    /* renamed from: a */
    private PolylineOptions m16750a() {
        if (this.f4523b == null) {
            this.f4523b = new PolylineOptions();
            this.f4523b.setCustomTexture(BitmapDescriptorFactory.fromAsset("tracelinetexture.png"));
            this.f4523b.width(40.0f);
        }
        return this.f4523b;
    }

    public void add(List<LatLng> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4525d.addAll(list);
        m16750a();
        if (this.f4522a == null) {
            this.f4522a = this.f4524c.addPolyline(this.f4523b);
        }
        this.f4522a.setPoints(this.f4525d);
    }

    public int getDistance() {
        return this.f4527f;
    }

    public int getTraceStatus() {
        return this.f4526e;
    }

    public int getWaitTime() {
        return this.f4528g;
    }

    public void remove() {
        if (this.f4522a != null) {
            this.f4522a.remove();
        }
    }

    public void setDistance(int i) {
        this.f4527f = i;
    }

    public void setProperCamera(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list == null || list.size() == 0) {
            return;
        }
        for (LatLng latLng : list) {
            builder.include(latLng);
        }
        try {
            this.f4524c.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 20));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void setTraceStatus(int i) {
        this.f4526e = i;
    }

    public void setWaitTime(int i) {
        this.f4528g = i;
    }

    public void zoopToSpan() {
        setProperCamera(this.f4523b.getPoints());
    }
}
