package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkStep;
import java.util.List;
/* loaded from: classes.dex */
public class WalkRouteOverlay extends C1157b {

    /* renamed from: a */
    private PolylineOptions f3879a;

    /* renamed from: b */
    private BitmapDescriptor f3880b = null;

    /* renamed from: c */
    private WalkPath f3881c;

    public WalkRouteOverlay(Context context, AMap aMap, WalkPath walkPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.mAMap = aMap;
        this.f3881c = walkPath;
        this.startPoint = C1156a.m17312a(latLonPoint);
        this.endPoint = C1156a.m17312a(latLonPoint2);
    }

    /* renamed from: a */
    private LatLonPoint m17316a(WalkStep walkStep) {
        return walkStep.getPolyline().get(walkStep.getPolyline().size() - 1);
    }

    /* renamed from: a */
    private void m17318a() {
        if (this.f3880b == null) {
            this.f3880b = getWalkBitmapDescriptor();
        }
        this.f3879a = null;
        this.f3879a = new PolylineOptions();
        this.f3879a.color(getDriveColor()).width(getRouteWidth());
    }

    /* renamed from: a */
    private void m17317a(LatLng latLng, LatLng latLng2) {
        this.f3879a.add(latLng, latLng2);
    }

    /* renamed from: a */
    private void m17315a(WalkStep walkStep, LatLng latLng) {
        addStationMarker(new MarkerOptions().position(latLng).title("方向:" + walkStep.getAction() + "\n道路:" + walkStep.getRoad()).snippet(walkStep.getInstruction()).visible(this.nodeIconVisible).anchor(0.5f, 0.5f).icon(this.f3880b));
    }

    /* renamed from: b */
    private void m17314b() {
        addPolyLine(this.f3879a);
    }

    /* renamed from: b */
    private void m17313b(WalkStep walkStep) {
        this.f3879a.addAll(C1156a.m17311a(walkStep.getPolyline()));
    }

    public void addToMap() {
        m17318a();
        try {
            List<WalkStep> steps = this.f3881c.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                WalkStep walkStep = steps.get(i);
                LatLng m17312a = C1156a.m17312a(walkStep.getPolyline().get(0));
                if (i >= steps.size() - 1) {
                    m17317a(C1156a.m17312a(m17316a(walkStep)), this.endPoint);
                } else if (i == 0) {
                    m17317a(this.startPoint, m17312a);
                }
                m17315a(walkStep, m17312a);
                m17313b(walkStep);
            }
            addStartAndEndMarker();
            m17314b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.overlay.C1157b
    public /* bridge */ /* synthetic */ void removeFromMap() {
        super.removeFromMap();
    }

    @Override // com.amap.api.maps.overlay.C1157b
    public /* bridge */ /* synthetic */ void setNodeIconVisibility(boolean z) {
        super.setNodeIconVisibility(z);
    }

    @Override // com.amap.api.maps.overlay.C1157b
    public /* bridge */ /* synthetic */ void zoomToSpan() {
        super.zoomToSpan();
    }
}
