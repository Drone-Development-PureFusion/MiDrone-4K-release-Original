package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.C0770ai;
import com.amap.api.mapcore.util.C1007fo;
import com.amap.api.maps.model.LatLng;
/* loaded from: classes.dex */
public class CoordinateConverter {

    /* renamed from: a */
    private Context f3588a;

    /* renamed from: b */
    private CoordType f3589b = null;

    /* renamed from: c */
    private LatLng f3590c = null;

    /* loaded from: classes.dex */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.f3588a = context;
    }

    public LatLng convert() {
        LatLng latLng = null;
        if (this.f3589b == null || this.f3590c == null) {
            return null;
        }
        try {
            switch (this.f3589b) {
                case BAIDU:
                    latLng = C0770ai.m19084a(this.f3590c);
                    break;
                case MAPBAR:
                    latLng = C0770ai.m19079b(this.f3588a, this.f3590c);
                    break;
                case MAPABC:
                case SOSOMAP:
                case ALIYUN:
                case GOOGLE:
                    latLng = this.f3590c;
                    break;
                case GPS:
                    latLng = C0770ai.m19085a(this.f3588a, this.f3590c);
                    break;
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            C1007fo.m18012b(th, "CoordinateConverter", "convert");
            return this.f3590c;
        }
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f3590c = latLng;
        return this;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f3589b = coordType;
        return this;
    }
}
