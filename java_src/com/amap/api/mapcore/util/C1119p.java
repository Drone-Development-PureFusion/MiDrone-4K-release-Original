package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;
/* renamed from: com.amap.api.mapcore.util.p */
/* loaded from: classes.dex */
public class C1119p implements IMapFragmentDelegate {

    /* renamed from: a */
    public static volatile Context f3495a;

    /* renamed from: c */
    private IAMap f3497c;

    /* renamed from: d */
    private int f3498d;

    /* renamed from: f */
    private AMapOptions f3500f;

    /* renamed from: b */
    public int f3496b = 0;

    /* renamed from: e */
    private String f3499e = "MapFragmentDelegateImp";

    public C1119p(int i) {
        int i2 = 0;
        this.f3498d = 0;
        this.f3498d = i > 0 ? 1 : i2;
    }

    /* renamed from: a */
    void m17505a(AMapOptions aMapOptions) {
        if (aMapOptions == null || this.f3497c == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f3497c.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings aMapUiSettings = this.f3497c.getAMapUiSettings();
        aMapUiSettings.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled().booleanValue());
        aMapUiSettings.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled().booleanValue());
        aMapUiSettings.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled().booleanValue());
        aMapUiSettings.setZoomControlsEnabled(aMapOptions.getZoomControlsEnabled().booleanValue());
        aMapUiSettings.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled().booleanValue());
        aMapUiSettings.setCompassEnabled(aMapOptions.getCompassEnabled().booleanValue());
        aMapUiSettings.setScaleControlsEnabled(aMapOptions.getScaleControlsEnabled().booleanValue());
        aMapUiSettings.setLogoPosition(aMapOptions.getLogoPosition());
        this.f3497c.setMapType(aMapOptions.getMapType());
        this.f3497c.setZOrderOnTop(aMapOptions.getZOrderOnTop().booleanValue());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public IAMap getMap() {
        if (this.f3497c == null) {
            if (f3495a == null) {
                Log.w(this.f3499e, "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
                return null;
            }
            int i = f3495a.getResources().getDisplayMetrics().densityDpi;
            if (i <= 120) {
                C1022g.f3199a = 0.5f;
            } else if (i <= 160) {
                C1022g.f3199a = 0.8f;
            } else if (i <= 240) {
                C1022g.f3199a = 0.87f;
            } else if (i <= 320) {
                C1022g.f3199a = 1.0f;
            } else if (i <= 480) {
                C1022g.f3199a = 1.5f;
            } else if (i <= 640) {
                C1022g.f3199a = 1.8f;
            } else {
                C1022g.f3199a = 0.9f;
            }
            if (this.f3498d == 0) {
                this.f3497c = new C0863c(f3495a).m18726a();
            } else {
                this.f3497c = new C0890d(f3495a).m18670a();
            }
        }
        return this.f3497c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public boolean isReady() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onCreate(Bundle bundle) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        byte[] byteArray;
        if (f3495a == null && layoutInflater != null) {
            f3495a = layoutInflater.getContext().getApplicationContext();
        }
        try {
            this.f3497c = getMap();
            this.f3497c.setVisibilityEx(this.f3496b);
            if (this.f3500f == null && bundle != null && (byteArray = bundle.getByteArray("MapOptions")) != null) {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f3500f = AMapOptions.CREATOR.mo21702createFromParcel(obtain);
            }
            m17505a(this.f3500f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f3497c.getView();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroy() {
        if (this.f3497c != null) {
            this.f3497c.clear();
            this.f3497c.destroy();
            this.f3497c = null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onDestroyView() {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onInflate(Activity activity, AMapOptions aMapOptions, Bundle bundle) {
        f3495a = activity.getApplicationContext();
        this.f3500f = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onLowMemory() {
        Log.d("onLowMemory", "onLowMemory run");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onPause() {
        if (this.f3497c != null) {
            this.f3497c.onActivityPause();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onResume() {
        if (this.f3497c != null) {
            this.f3497c.onActivityResume();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void onSaveInstanceState(Bundle bundle) {
        if (this.f3497c != null) {
            if (this.f3500f == null) {
                this.f3500f = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                this.f3500f = this.f3500f.camera(getMap().getCameraPosition());
                this.f3500f.writeToParcel(obtain, 0);
                bundle.putByteArray("MapOptions", obtain.marshall());
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setContext(Context context) {
        if (context != null) {
            f3495a = context.getApplicationContext();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setOptions(AMapOptions aMapOptions) {
        this.f3500f = aMapOptions;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate
    public void setVisibility(int i) {
        this.f3496b = i;
        if (this.f3497c != null) {
            this.f3497c.setVisibilityEx(i);
        }
    }
}
