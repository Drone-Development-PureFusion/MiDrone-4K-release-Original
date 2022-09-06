package com.fimi.soul.module.droneui;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureSupportMapFragment;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.fimi.soul.C2300R;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p185n.C2571k;
import com.fimi.soul.drone.C2657a;
import com.fimi.soul.drone.C2678d;
/* loaded from: classes.dex */
public abstract class DroneMap extends TextureSupportMapFragment implements C2571k.AbstractC2573a, C2678d.AbstractC2680b {

    /* renamed from: m */
    public static final byte f12610m = 80;

    /* renamed from: n */
    public static final byte f12611n = 82;

    /* renamed from: o */
    public static final byte f12612o = 67;

    /* renamed from: q */
    public static final int f12614q = 3;

    /* renamed from: a */
    private SensorManager f12616a;

    /* renamed from: b */
    private Sensor f12617b;

    /* renamed from: c */
    private boolean f12618c = true;

    /* renamed from: d */
    private Marker f12619d;

    /* renamed from: j */
    protected AMap f12620j;

    /* renamed from: k */
    public C2657a f12621k;

    /* renamed from: l */
    public static int f12609l = 20;

    /* renamed from: p */
    public static int f12613p = 0;

    /* renamed from: r */
    public static int f12615r = 0;

    /* renamed from: a */
    private void m8900a() {
        if (this.f12620j == null) {
            this.f12620j = getMap();
            this.f12621k.m11340a(this.f12620j);
        }
    }

    /* renamed from: a */
    private void m8899a(LatLng latLng) {
        this.f12619d = this.f12620j.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(C2300R.C2301drawable.location_map)));
        this.f12619d.setAnchor(0.5f, 0.5f);
        this.f12616a = (SensorManager) getActivity().getSystemService("sensor");
        this.f12617b = this.f12616a.getDefaultSensor(3);
        this.f12616a.registerListener(new SensorEventListener() { // from class: com.fimi.soul.module.droneui.DroneMap.1
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.sensor.getType() == 3) {
                    float f = sensorEvent.values[0];
                    float f2 = DroneMap.this.f12620j.getCameraPosition().bearing;
                    if (f + f2 > 360.0f) {
                        DroneMap.this.f12619d.setRotateAngle((((-f) + f2) - 180.0f) + 90.0f);
                    } else {
                        DroneMap.this.f12619d.setRotateAngle((-f) + f2 + 180.0f + 90.0f);
                    }
                }
            }
        }, this.f12617b, 2);
    }

    /* renamed from: c */
    private void m8896c() {
        this.f12621k.m11295f(true);
        this.f12620j.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(32.76593d, 102.523984d), 4.0f));
    }

    @Override // com.fimi.soul.biz.p185n.C2571k.AbstractC2573a
    /* renamed from: a */
    public void mo8600a(AMapLocation aMapLocation) {
        if (this.f12620j == null || aMapLocation == null || aMapLocation.getLatitude() == 0.0d || aMapLocation.getLongitude() == 0.0d) {
            return;
        }
        this.f12621k.m11341a(aMapLocation);
        LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
        if (this.f12619d == null) {
            m8899a(latLng);
            if (!this.f12621k.mo11216ac()) {
                this.f12620j.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18.0f));
            }
            this.f12621k.mo11220a(C2678d.EnumC2679a.QUERYDYNAMICDATAGPS);
            return;
        }
        if (!this.f12619d.isVisible()) {
            this.f12619d.destroy();
            m8899a(latLng);
        }
        this.f12619d.setPosition(latLng);
    }

    /* renamed from: b */
    public void m8897b() {
        super.onDestroy();
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f12621k = ((DroidPlannerApp) getActivity().getApplication()).f7895a;
        m8900a();
        C2571k.m11651a(getActivity()).m11648a(this);
        return onCreateView;
    }

    public void onDroneEvent(C2678d.EnumC2679a enumC2679a, C2657a c2657a) {
        switch (enumC2679a) {
            case MISSION_UPDATE:
            default:
                return;
            case HEARDATA:
                c2657a.mo11205t();
                f12609l = c2657a.m11312at().m10702e();
                return;
        }
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.amap.api.maps.TextureSupportMapFragment, android.support.p001v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f12621k.mo11219a(this);
        if (this.f12619d == null) {
            if (!this.f12621k.mo11216ac()) {
                m8896c();
            } else if (this.f12621k.mo11202w().m10501d() > 3) {
            } else {
                m8896c();
            }
        }
    }

    @Override // android.support.p001v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.f12621k.mo11214b(this);
    }
}
