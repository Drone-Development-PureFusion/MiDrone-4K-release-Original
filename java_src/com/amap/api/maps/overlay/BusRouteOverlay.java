package com.amap.api.maps.overlay;

import android.content.Context;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.WalkStep;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class BusRouteOverlay extends C1157b {

    /* renamed from: a */
    private BusPath f3868a;

    /* renamed from: b */
    private LatLng f3869b;

    public BusRouteOverlay(Context context, AMap aMap, BusPath busPath, LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        super(context);
        this.f3868a = busPath;
        this.startPoint = C1156a.m17312a(latLonPoint);
        this.endPoint = C1156a.m17312a(latLonPoint2);
        this.mAMap = aMap;
    }

    /* renamed from: a */
    private void m17348a(LatLng latLng, LatLng latLng2) {
        addPolyLine(new PolylineOptions().add(latLng, latLng2).width(getRouteWidth()).color(getWalkColor()));
    }

    /* renamed from: a */
    private void m17347a(LatLng latLng, String str, String str2) {
        addStationMarker(new MarkerOptions().position(latLng).title(str).snippet(str2).anchor(0.5f, 0.5f).visible(this.nodeIconVisible).icon(getWalkBitmapDescriptor()));
    }

    /* renamed from: a */
    private void m17346a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        m17348a(C1156a.m17312a(latLonPoint), C1156a.m17312a(latLonPoint2));
    }

    /* renamed from: a */
    private void m17345a(BusStep busStep) {
        List<WalkStep> steps = busStep.getWalk().getSteps();
        for (int i = 0; i < steps.size(); i++) {
            WalkStep walkStep = steps.get(i);
            if (i == 0) {
                m17347a(C1156a.m17312a(walkStep.getPolyline().get(0)), walkStep.getRoad(), m17334c(steps));
            }
            List<LatLng> m17311a = C1156a.m17311a(walkStep.getPolyline());
            this.f3869b = m17311a.get(m17311a.size() - 1);
            m17338b(m17311a);
            if (i < steps.size() - 1) {
                LatLng latLng = m17311a.get(m17311a.size() - 1);
                LatLng m17312a = C1156a.m17312a(steps.get(i + 1).getPolyline().get(0));
                if (!latLng.equals(m17312a)) {
                    m17348a(latLng, m17312a);
                }
            }
        }
    }

    /* renamed from: a */
    private void m17344a(BusStep busStep, BusStep busStep2) {
        LatLng m17312a = C1156a.m17312a(m17332e(busStep));
        LatLng m17312a2 = C1156a.m17312a(m17331f(busStep2));
        if (m17312a2.latitude - m17312a.latitude > 1.0E-4d || m17312a2.longitude - m17312a.longitude > 1.0E-4d) {
            drawLineArrow(m17312a, m17312a2);
        }
    }

    /* renamed from: a */
    private void m17343a(RouteBusLineItem routeBusLineItem) {
        m17342a(routeBusLineItem.getPolyline());
    }

    /* renamed from: a */
    private void m17342a(List<LatLonPoint> list) {
        if (list.size() < 1) {
            return;
        }
        addPolyLine(new PolylineOptions().width(getRouteWidth()).color(getBusColor()).addAll(C1156a.m17311a(list)));
    }

    /* renamed from: b */
    private void m17341b(BusStep busStep) {
        LatLonPoint m17333d = m17333d(busStep);
        LatLonPoint m17331f = m17331f(busStep);
        if (!m17333d.equals(m17331f)) {
            m17346a(m17333d, m17331f);
        }
    }

    /* renamed from: b */
    private void m17340b(BusStep busStep, BusStep busStep2) {
        LatLng m17312a = C1156a.m17312a(m17332e(busStep));
        LatLng m17312a2 = C1156a.m17312a(m17331f(busStep2));
        if (!m17312a.equals(m17312a2)) {
            drawLineArrow(m17312a, m17312a2);
        }
    }

    /* renamed from: b */
    private void m17339b(RouteBusLineItem routeBusLineItem) {
        LatLng m17312a = C1156a.m17312a(routeBusLineItem.getDepartureBusStation().getLatLonPoint());
        String busLineName = routeBusLineItem.getBusLineName();
        addStationMarker(new MarkerOptions().position(m17312a).title(busLineName).snippet(m17335c(routeBusLineItem)).anchor(0.5f, 0.5f).visible(this.nodeIconVisible).icon(getBusBitmapDescriptor()));
    }

    /* renamed from: b */
    private void m17338b(List<LatLng> list) {
        addPolyLine(new PolylineOptions().addAll(list).color(getWalkColor()).width(getRouteWidth()));
    }

    /* renamed from: c */
    private LatLonPoint m17337c(BusStep busStep) {
        return busStep.getWalk().getSteps().get(0).getPolyline().get(0);
    }

    /* renamed from: c */
    private String m17335c(RouteBusLineItem routeBusLineItem) {
        return "(" + routeBusLineItem.getDepartureBusStation().getBusStationName() + "-->" + routeBusLineItem.getArrivalBusStation().getBusStationName() + ") 经过" + (routeBusLineItem.getPassStationNum() + 1) + "站";
    }

    /* renamed from: c */
    private String m17334c(List<WalkStep> list) {
        float f = 0.0f;
        Iterator<WalkStep> it2 = list.iterator();
        while (true) {
            float f2 = f;
            if (it2.hasNext()) {
                f = it2.next().getDistance() + f2;
            } else {
                return "步行" + f2 + "米";
            }
        }
    }

    /* renamed from: c */
    private void m17336c(BusStep busStep, BusStep busStep2) {
        LatLonPoint m17332e = m17332e(busStep);
        LatLonPoint m17337c = m17337c(busStep2);
        if (!m17332e.equals(m17337c)) {
            m17346a(m17332e, m17337c);
        }
    }

    /* renamed from: d */
    private LatLonPoint m17333d(BusStep busStep) {
        List<WalkStep> steps = busStep.getWalk().getSteps();
        List<LatLonPoint> polyline = steps.get(steps.size() - 1).getPolyline();
        return polyline.get(polyline.size() - 1);
    }

    /* renamed from: e */
    private LatLonPoint m17332e(BusStep busStep) {
        List<LatLonPoint> polyline = busStep.getBusLine().getPolyline();
        return polyline.get(polyline.size() - 1);
    }

    /* renamed from: f */
    private LatLonPoint m17331f(BusStep busStep) {
        return busStep.getBusLine().getPolyline().get(0);
    }

    public void addToMap() {
        try {
            List<BusStep> steps = this.f3868a.getSteps();
            for (int i = 0; i < steps.size(); i++) {
                BusStep busStep = steps.get(i);
                if (i < steps.size() - 1) {
                    BusStep busStep2 = steps.get(i + 1);
                    if (busStep.getWalk() != null && busStep.getBusLine() != null) {
                        m17341b(busStep);
                    }
                    if (busStep.getBusLine() != null && busStep2.getWalk() != null) {
                        m17336c(busStep, busStep2);
                    }
                    if (busStep.getBusLine() != null && busStep2.getWalk() == null && busStep2.getBusLine() != null) {
                        m17340b(busStep, busStep2);
                    }
                    if (busStep.getBusLine() != null && busStep2.getWalk() == null && busStep2.getBusLine() != null) {
                        m17344a(busStep, busStep2);
                    }
                }
                if (busStep.getWalk() != null && busStep.getWalk().getSteps().size() > 0) {
                    m17345a(busStep);
                } else if (busStep.getBusLine() == null) {
                    m17348a(this.f3869b, this.endPoint);
                }
                if (busStep.getBusLine() != null) {
                    RouteBusLineItem busLine = busStep.getBusLine();
                    m17343a(busLine);
                    m17339b(busLine);
                }
            }
            addStartAndEndMarker();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void drawLineArrow(LatLng latLng, LatLng latLng2) {
        addPolyLine(new PolylineOptions().add(latLng, latLng2).width(3.0f).color(getBusColor()).width(getRouteWidth()));
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
