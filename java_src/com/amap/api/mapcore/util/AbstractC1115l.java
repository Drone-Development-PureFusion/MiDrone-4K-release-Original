package com.amap.api.mapcore.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapCore;
import com.autonavi.amap.mapcore.MapMessage;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
/* renamed from: com.amap.api.mapcore.util.l */
/* loaded from: classes.dex */
public interface AbstractC1115l extends IAMap {
    /* renamed from: A */
    int mo17558A();

    /* renamed from: a */
    float mo17553a(int i);

    /* renamed from: a */
    int mo17544a(BitmapDescriptor bitmapDescriptor);

    /* renamed from: a */
    int mo17541a(IMarkerAction iMarkerAction, Rect rect);

    /* renamed from: a */
    LatLngBounds mo17543a(LatLng latLng, float f, float f2, float f3);

    /* renamed from: a */
    MapCore mo17557a();

    /* renamed from: a */
    void mo17556a(double d, double d2, FPoint fPoint);

    /* renamed from: a */
    void mo17555a(double d, double d2, IPoint iPoint);

    /* renamed from: a */
    void mo17554a(float f, float f2, IPoint iPoint);

    /* renamed from: a */
    void mo17552a(int i, float f);

    /* renamed from: a */
    void mo17551a(int i, int i2, DPoint dPoint);

    /* renamed from: a */
    void mo17550a(int i, int i2, FPoint fPoint);

    /* renamed from: a */
    void mo17549a(int i, int i2, IPoint iPoint);

    /* renamed from: a */
    void mo17548a(Location location);

    /* renamed from: a */
    void mo17546a(AbstractC0881cr abstractC0881cr);

    /* renamed from: a */
    void mo17545a(C1125s c1125s);

    /* renamed from: a */
    void mo17542a(MapMessage mapMessage);

    /* renamed from: a */
    void mo17539a(boolean z);

    /* renamed from: a */
    boolean mo17547a(MotionEvent motionEvent);

    /* renamed from: a */
    boolean mo17540a(String str);

    /* renamed from: b */
    int mo17538b();

    /* renamed from: b */
    void mo17537b(double d, double d2, IPoint iPoint);

    /* renamed from: b */
    void mo17536b(int i);

    /* renamed from: b */
    void mo17535b(int i, int i2, DPoint dPoint);

    /* renamed from: b */
    void mo17534b(int i, int i2, FPoint fPoint);

    /* renamed from: b */
    void mo17533b(MotionEvent motionEvent);

    /* renamed from: b */
    void mo17532b(MapMessage mapMessage);

    /* renamed from: b */
    void mo17531b(boolean z);

    /* renamed from: c */
    MapProjection mo17530c();

    /* renamed from: c */
    void mo17529c(int i);

    /* renamed from: c */
    void mo17527c(boolean z);

    /* renamed from: c */
    boolean mo17528c(MotionEvent motionEvent);

    /* renamed from: d */
    void mo17526d();

    /* renamed from: d */
    void mo17525d(int i);

    /* renamed from: d */
    void mo17523d(boolean z);

    /* renamed from: d */
    boolean mo17524d(MotionEvent motionEvent);

    /* renamed from: e */
    float mo17521e(int i);

    /* renamed from: e */
    void mo17522e();

    /* renamed from: e */
    void mo17520e(boolean z);

    /* renamed from: f */
    void mo17518f(int i);

    /* renamed from: f */
    boolean mo17519f();

    /* renamed from: g */
    void mo17517g(int i);

    /* renamed from: k */
    int mo17516k();

    /* renamed from: l */
    void mo17515l();

    /* renamed from: m */
    AbstractC1118o mo17514m();

    /* renamed from: n */
    void mo17513n();

    /* renamed from: o */
    float mo17512o();

    /* renamed from: p */
    FPoint[] mo17511p();

    /* renamed from: q */
    Point mo17510q();

    /* renamed from: r */
    void mo17509r();

    /* renamed from: u */
    float mo17508u();

    /* renamed from: y */
    float mo17507y();

    /* renamed from: z */
    View mo17506z();
}
