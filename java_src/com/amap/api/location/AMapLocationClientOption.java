package com.amap.api.location;

import com.p080b.C1514cx;
/* loaded from: classes.dex */
public class AMapLocationClientOption implements Cloneable {

    /* renamed from: a */
    private long f1990a = 2000;

    /* renamed from: b */
    private long f1991b = C1514cx.f5415j;

    /* renamed from: c */
    private boolean f1992c = false;

    /* renamed from: d */
    private boolean f1993d = false;

    /* renamed from: e */
    private boolean f1994e = true;

    /* renamed from: f */
    private boolean f1995f = true;

    /* renamed from: g */
    private AMapLocationMode f1996g = AMapLocationMode.Hight_Accuracy;

    /* renamed from: h */
    private boolean f1997h = false;

    /* renamed from: i */
    private boolean f1998i = false;

    /* renamed from: j */
    private boolean f1999j = true;

    /* loaded from: classes.dex */
    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    /* renamed from: a */
    private AMapLocationClientOption m19119a(AMapLocationClientOption aMapLocationClientOption) {
        this.f1990a = aMapLocationClientOption.f1990a;
        this.f1992c = aMapLocationClientOption.f1992c;
        this.f1996g = aMapLocationClientOption.f1996g;
        this.f1993d = aMapLocationClientOption.f1993d;
        this.f1997h = aMapLocationClientOption.f1997h;
        this.f1998i = aMapLocationClientOption.f1998i;
        this.f1994e = aMapLocationClientOption.f1994e;
        this.f1995f = aMapLocationClientOption.f1995f;
        this.f1991b = aMapLocationClientOption.f1991b;
        return this;
    }

    /* renamed from: clone */
    public AMapLocationClientOption m21701clone() {
        return new AMapLocationClientOption().m19119a(this);
    }

    public long getHttpTimeOut() {
        return this.f1991b;
    }

    public long getInterval() {
        return this.f1990a;
    }

    public AMapLocationMode getLocationMode() {
        return this.f1996g;
    }

    public boolean isGpsFirst() {
        return this.f1998i;
    }

    public boolean isKillProcess() {
        return this.f1997h;
    }

    public boolean isMockEnable() {
        return this.f1993d;
    }

    public boolean isNeedAddress() {
        return this.f1994e;
    }

    public boolean isOffset() {
        return this.f1999j;
    }

    public boolean isOnceLocation() {
        return this.f1992c;
    }

    public boolean isWifiActiveScan() {
        return this.f1995f;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.f1998i = z;
        return this;
    }

    public void setHttpTimeOut(long j) {
        this.f1991b = j;
    }

    public AMapLocationClientOption setInterval(long j) {
        if (j < 1000) {
            j = 1000;
        }
        this.f1990a = j;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.f1997h = z;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.f1996g = aMapLocationMode;
        return this;
    }

    public void setMockEnable(boolean z) {
        this.f1993d = z;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f1994e = z;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.f1999j = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.f1992c = z;
        return this;
    }

    public void setWifiActiveScan(boolean z) {
        this.f1995f = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("interval:").append(String.valueOf(this.f1990a)).append("#");
        sb.append("isOnceLocation:").append(String.valueOf(this.f1992c)).append("#");
        sb.append("locationMode:").append(String.valueOf(this.f1996g)).append("#");
        sb.append("isMockEnable:").append(String.valueOf(this.f1993d)).append("#");
        sb.append("isKillProcess:").append(String.valueOf(this.f1997h)).append("#");
        sb.append("isGpsFirst:").append(String.valueOf(this.f1998i)).append("#");
        sb.append("isNeedAddress:").append(String.valueOf(this.f1994e)).append("#");
        sb.append("isWifiActiveScan:").append(String.valueOf(this.f1995f)).append("#");
        sb.append("httpTimeOut:").append(String.valueOf(this.f1991b)).append("#");
        sb.append("isOffset:").append(String.valueOf(this.f1999j));
        return sb.toString();
    }
}
