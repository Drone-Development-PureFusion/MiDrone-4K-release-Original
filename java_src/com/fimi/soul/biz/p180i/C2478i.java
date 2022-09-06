package com.fimi.soul.biz.p180i;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import java.util.List;
/* renamed from: com.fimi.soul.biz.i.i */
/* loaded from: classes.dex */
public class C2478i {
    /* renamed from: a */
    public static MarkerOptions m12018a(LatLng latLng, int i) {
        return new MarkerOptions().position(latLng).icon(C2479j.m12014a(i)).draggable(true);
    }

    /* renamed from: a */
    public static MarkerOptions m12017a(LatLng latLng, Context context, int i, boolean z, int i2) {
        return new MarkerOptions().position(latLng).icon(C2479j.m12013a(context, i2, i, z)).draggable(true);
    }

    /* renamed from: a */
    public static PolylineOptions m12016a(List<LatLng> list, int i, int i2) {
        return new PolylineOptions().addAll(list).color(i2).width(i);
    }
}
