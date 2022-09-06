package com.amap.api.maps.overlay;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class PoiOverlay {

    /* renamed from: a */
    private List<PoiItem> f3876a;

    /* renamed from: b */
    private AMap f3877b;

    /* renamed from: c */
    private ArrayList<Marker> f3878c = new ArrayList<>();

    public PoiOverlay(AMap aMap, List<PoiItem> list) {
        this.f3877b = aMap;
        this.f3876a = list;
    }

    /* renamed from: a */
    private LatLngBounds m17320a() {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3876a.size()) {
                builder.include(new LatLng(this.f3876a.get(i2).getLatLonPoint().getLatitude(), this.f3876a.get(i2).getLatLonPoint().getLongitude()));
                i = i2 + 1;
            } else {
                return builder.build();
            }
        }
    }

    /* renamed from: a */
    private MarkerOptions m17319a(int i) {
        return new MarkerOptions().position(new LatLng(this.f3876a.get(i).getLatLonPoint().getLatitude(), this.f3876a.get(i).getLatLonPoint().getLongitude())).title(getTitle(i)).snippet(getSnippet(i)).icon(getBitmapDescriptor(i));
    }

    public void addToMap() {
        for (int i = 0; i < this.f3876a.size(); i++) {
            try {
                Marker addMarker = this.f3877b.addMarker(m17319a(i));
                addMarker.setObject(Integer.valueOf(i));
                this.f3878c.add(addMarker);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    protected BitmapDescriptor getBitmapDescriptor(int i) {
        return null;
    }

    public int getPoiIndex(Marker marker) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f3878c.size()) {
                if (this.f3878c.get(i2).equals(marker)) {
                    return i2;
                }
                i = i2 + 1;
            } else {
                return -1;
            }
        }
    }

    public PoiItem getPoiItem(int i) {
        if (i < 0 || i >= this.f3876a.size()) {
            return null;
        }
        return this.f3876a.get(i);
    }

    protected String getSnippet(int i) {
        return this.f3876a.get(i).getSnippet();
    }

    protected String getTitle(int i) {
        return this.f3876a.get(i).getTitle();
    }

    public void removeFromMap() {
        Iterator<Marker> it2 = this.f3878c.iterator();
        while (it2.hasNext()) {
            it2.next().remove();
        }
    }

    public void zoomToSpan() {
        try {
            if (this.f3876a != null && this.f3876a.size() > 0 && this.f3877b != null) {
                if (this.f3876a.size() == 1) {
                    this.f3877b.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.f3876a.get(0).getLatLonPoint().getLatitude(), this.f3876a.get(0).getLatLonPoint().getLongitude()), 18.0f));
                } else {
                    this.f3877b.moveCamera(CameraUpdateFactory.newLatLngBounds(m17320a(), 5));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
