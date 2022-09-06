package com.amap.api.location;

import android.content.Context;
import com.p080b.C1514cx;
import com.p080b.C1528dj;
/* loaded from: classes.dex */
public class CoordinateConverter {

    /* renamed from: b */
    private Context f2004b;

    /* renamed from: c */
    private CoordType f2005c = null;

    /* renamed from: d */
    private DPoint f2006d = null;

    /* renamed from: a */
    DPoint f2003a = null;

    /* loaded from: classes.dex */
    public enum CoordType {
        BAIDU,
        MAPBAR,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE,
        GPS
    }

    public CoordinateConverter(Context context) {
        this.f2004b = context;
    }

    public synchronized DPoint convert() {
        if (this.f2005c == null) {
            throw new IllegalArgumentException("转换坐标类型不能为空");
        }
        if (this.f2006d == null) {
            throw new IllegalArgumentException("转换坐标源不能为空");
        }
        if (this.f2006d.getLongitude() > 180.0d || this.f2006d.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        }
        if (this.f2006d.getLatitude() > 90.0d || this.f2006d.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        }
        switch (this.f2005c) {
            case BAIDU:
                this.f2003a = C1528dj.m15682a(this.f2006d);
                break;
            case MAPBAR:
                this.f2003a = C1528dj.m15677b(this.f2004b, this.f2006d);
                break;
            case MAPABC:
            case SOSOMAP:
            case ALIYUN:
            case GOOGLE:
                this.f2003a = this.f2006d;
                break;
            case GPS:
                this.f2003a = C1528dj.m15683a(this.f2004b, this.f2006d);
                break;
        }
        return this.f2003a;
    }

    public synchronized CoordinateConverter coord(DPoint dPoint) {
        if (dPoint == null) {
            throw new IllegalArgumentException("传入经纬度对象为空");
        }
        if (dPoint.getLongitude() > 180.0d || dPoint.getLongitude() < -180.0d) {
            throw new IllegalArgumentException("请传入合理经度");
        }
        if (dPoint.getLatitude() > 90.0d || dPoint.getLatitude() < -90.0d) {
            throw new IllegalArgumentException("请传入合理纬度");
        }
        this.f2006d = dPoint;
        return this;
    }

    public synchronized CoordinateConverter from(CoordType coordType) {
        this.f2005c = coordType;
        return this;
    }

    public boolean isAMapDataAvailable(double d, double d2) {
        return C1514cx.m15732a(d, d2);
    }
}
