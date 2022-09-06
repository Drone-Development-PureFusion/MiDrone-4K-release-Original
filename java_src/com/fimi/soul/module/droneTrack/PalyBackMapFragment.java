package com.fimi.soul.module.droneTrack;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.fimi.soul.C2300R;
import com.fimi.soul.drone.p202h.C2854c;
import com.fimi.soul.drone.p203i.C2877ah;
import com.fimi.soul.drone.p203i.C2886aq;
import com.fimi.soul.drone.p203i.p204a.C2864c;
import com.fimi.soul.module.droneTrack.p208a.C3203b;
import com.fimi.soul.utils.C3633ac;
import com.fimi.soul.utils.C3639ai;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class PalyBackMapFragment extends SupportMapFragment implements AMap.InfoWindowAdapter {

    /* renamed from: a */
    protected AMap f12190a;

    /* renamed from: b */
    private SharedPreferences f12191b;

    /* renamed from: c */
    private AbstractC3216e f12192c;

    /* renamed from: d */
    private Marker f12193d;

    /* renamed from: e */
    private Marker f12194e;

    /* renamed from: f */
    private Polyline f12195f;

    /* renamed from: g */
    private boolean f12196g = true;

    /* renamed from: h */
    private List<Circle> f12197h = new CopyOnWriteArrayList();

    /* renamed from: i */
    private Circle f12198i;

    /* renamed from: j */
    private Circle f12199j;

    /* renamed from: a */
    private Marker m9254a(LatLng latLng) {
        return this.f12190a.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(C2300R.C2301drawable.icon_fly_handpiece_location)).position(latLng));
    }

    /* renamed from: a */
    private void m9253a(LatLng latLng, int i, int i2) {
        int i3 = this.f12191b.getInt(C2854c.f10631s, 1);
        if (i2 == 3) {
            if (this.f12199j != null) {
                this.f12199j.setCenter(latLng);
                if (i != this.f12199j.getRadius()) {
                    this.f12199j.setRadius(i + 100);
                }
            } else {
                this.f12199j = this.f12190a.addCircle(new CircleOptions().center(latLng).radius(i + 100).strokeColor(Color.argb(127, 0, 0, 0)).strokeWidth(2.0f).fillColor(1 == i3 ? Color.argb(204, 198, 200, 203) : Color.argb(204, 101, 104, 106)));
            }
        } else if (this.f12199j != null) {
            this.f12199j.remove();
            this.f12199j = null;
        }
        if (this.f12198i == null || !this.f12197h.contains(this.f12198i)) {
            this.f12198i = this.f12190a.addCircle(new CircleOptions().center(latLng).radius(i).strokeColor(Color.argb(127, 255, 54, 0)).strokeWidth(2.0f).fillColor(Color.argb(51, 255, 54, 0)).zIndex(100.0f));
        } else {
            this.f12198i.setCenter(latLng);
            if (i != this.f12198i.getRadius()) {
                this.f12198i.setRadius(i);
            }
        }
        if (!this.f12197h.contains(this.f12198i)) {
            this.f12197h.add(this.f12198i);
        }
    }

    /* renamed from: b */
    private Polyline m9245b(List<LatLng> list) {
        return this.f12190a.addPolyline(new PolylineOptions().addAll(list).color(Color.rgb(255, 42, 92)).width(3.0f));
    }

    /* renamed from: d */
    private void m9243d() {
        if (this.f12190a == null) {
            this.f12190a = getMap();
        }
        this.f12190a.setMapType(this.f12191b.getInt(C2854c.f10585bK, 1));
        if (this.f12192c != null) {
            this.f12192c.mo9084a(this.f12190a.getMapType());
        }
        this.f12190a.setTrafficEnabled(false);
        UiSettings uiSettings = this.f12190a.getUiSettings();
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setScaleControlsEnabled(false);
        this.f12190a.setInfoWindowAdapter(this);
    }

    /* renamed from: e */
    private synchronized float m9242e() {
        float f = 0.0f;
        synchronized (this) {
            try {
                CameraPosition cameraPosition = this.f12190a.getCameraPosition();
                if (cameraPosition != null) {
                    f = cameraPosition.bearing;
                }
            } catch (Exception e) {
            }
        }
        return f;
    }

    /* renamed from: a */
    public int m9256a() {
        int i = 2;
        if (this.f12191b.getInt(C2854c.f10585bK, 1) == 1) {
            this.f12191b.edit().putInt(C2854c.f10585bK, 2).commit();
        } else {
            this.f12191b.edit().putInt(C2854c.f10585bK, 1).commit();
            i = 1;
        }
        this.f12190a.setMapType(i);
        return i;
    }

    /* renamed from: a */
    public void m9255a(float f) {
        if (this.f12194e != null) {
            this.f12194e.setRotateAngle(m9242e() + (-f));
        }
    }

    /* renamed from: a */
    public void m9252a(LatLng latLng, List<LatLng> list) {
        if (latLng == null || list == null) {
            return;
        }
        if (this.f12194e != null) {
            this.f12194e.setPosition(latLng);
        } else {
            this.f12194e = m9254a(latLng);
            this.f12194e.setAnchor(0.5f, 0.5f);
        }
        if (this.f12194e != null) {
            this.f12194e.setTitle(latLng.latitude + "，" + latLng.longitude);
            this.f12194e.showInfoWindow();
        }
        m9248a(list);
    }

    /* renamed from: a */
    public void m9251a(C2864c c2864c) {
        C3639ai m7726a = C3633ac.m7726a(c2864c.m10716f(), c2864c.m10715g());
        m9253a(new LatLng(m7726a.m7702a(), m7726a.m7700b()), c2864c.m10719c() * 10, c2864c.m10717e());
    }

    /* renamed from: a */
    public void m9250a(C2877ah c2877ah) {
        C3639ai m7726a = C3633ac.m7726a(c2877ah.m10612b(), c2877ah.m10611c());
        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        if (this.f12193d == null) {
            this.f12193d = this.f12190a.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(C2300R.C2301drawable.home_point)).position(latLng));
        } else {
            this.f12193d.setPosition(latLng);
        }
    }

    /* renamed from: a */
    public void m9249a(C2886aq c2886aq) {
        C3639ai m7726a = C3633ac.m7726a(c2886aq.m10499f(), c2886aq.m10500e());
        LatLng latLng = new LatLng(m7726a.m7702a(), m7726a.m7700b());
        List<LatLng> m9145c = C3203b.m9155a().m9145c();
        if (!m9145c.contains(latLng)) {
            m9145c.add(latLng);
        }
        if (this.f12194e == null) {
            this.f12194e = m9254a(latLng);
            this.f12194e.setAnchor(0.5f, 0.5f);
        } else {
            this.f12194e.setPosition(latLng);
        }
        if (this.f12194e != null) {
            this.f12194e.setTitle(latLng.latitude + "，" + latLng.longitude);
            this.f12194e.showInfoWindow();
        }
        m9248a(m9145c);
    }

    /* renamed from: a */
    public void m9248a(List<LatLng> list) {
        if (list == null) {
            return;
        }
        if (this.f12195f == null) {
            this.f12195f = m9245b(list);
        } else {
            this.f12195f.setPoints(list);
        }
        if (!this.f12196g) {
            return;
        }
        m9247a(false);
        this.f12190a.moveCamera(CameraUpdateFactory.newLatLngZoom(list.get(0), 18.0f));
    }

    /* renamed from: a */
    public void m9247a(boolean z) {
        this.f12196g = z;
    }

    /* renamed from: b */
    public void m9246b() {
        if (this.f12193d != null) {
            this.f12193d.remove();
            this.f12193d = null;
        }
        if (this.f12194e != null) {
            this.f12194e.remove();
            this.f12194e = null;
        }
        if (this.f12195f != null) {
            this.f12195f.remove();
            this.f12195f = null;
        }
    }

    /* renamed from: c */
    public boolean m9244c() {
        return this.f12196g;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override // com.amap.api.maps.AMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        View inflate = LayoutInflater.from(getActivity()).inflate(C2300R.layout.play_back_inforwindow, (ViewGroup) null);
        ((TextView) inflate.findViewById(C2300R.C2302id.drone_location)).setText(marker.getTitle());
        return inflate;
    }

    @Override // com.amap.api.maps.SupportMapFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12192c = (AbstractC3216e) activity;
    }

    @Override // com.amap.api.maps.SupportMapFragment, android.support.p001v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12191b = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override // com.amap.api.maps.SupportMapFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        m9243d();
        return onCreateView;
    }

    @Override // com.amap.api.maps.SupportMapFragment, android.support.p001v4.app.Fragment
    public void onDestroy() {
        if (this.f12192c != null) {
            this.f12192c = null;
        }
        if (this.f12193d != null) {
            this.f12193d.remove();
            this.f12193d = null;
        }
        if (this.f12194e != null) {
            this.f12194e.remove();
            this.f12194e = null;
        }
        if (this.f12195f != null) {
            this.f12195f.remove();
            this.f12195f = null;
        }
        if (this.f12198i != null) {
            this.f12198i.remove();
            this.f12198i = null;
        }
        if (this.f12199j != null) {
            this.f12199j.remove();
            this.f12199j = null;
        }
        this.f12197h.clear();
        super.onDestroy();
    }

    @Override // com.amap.api.maps.SupportMapFragment, android.support.p001v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
