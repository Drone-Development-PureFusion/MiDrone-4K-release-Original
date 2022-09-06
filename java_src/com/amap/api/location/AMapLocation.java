package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.fimi.soul.utils.p211a.C3628c;
import com.p080b.C1514cx;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AMapLocation extends Location {
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;

    /* renamed from: a */
    private String f1963a;

    /* renamed from: b */
    private String f1964b;

    /* renamed from: c */
    private String f1965c;

    /* renamed from: d */
    private String f1966d;

    /* renamed from: e */
    private String f1967e;

    /* renamed from: f */
    private String f1968f;

    /* renamed from: g */
    private String f1969g;

    /* renamed from: h */
    private String f1970h;

    /* renamed from: i */
    private String f1971i;

    /* renamed from: j */
    private String f1972j;

    /* renamed from: k */
    private String f1973k;

    /* renamed from: l */
    private boolean f1974l;

    /* renamed from: m */
    private int f1975m;

    /* renamed from: n */
    private String f1976n;

    /* renamed from: o */
    private String f1977o;

    /* renamed from: p */
    private int f1978p;

    /* renamed from: q */
    private double f1979q;

    /* renamed from: r */
    private double f1980r;

    /* renamed from: s */
    private int f1981s;

    /* renamed from: t */
    private String f1982t;

    public AMapLocation(Location location) {
        super(location);
        this.f1963a = "";
        this.f1964b = "";
        this.f1965c = "";
        this.f1966d = "";
        this.f1967e = "";
        this.f1968f = "";
        this.f1969g = "";
        this.f1970h = "";
        this.f1971i = "";
        this.f1972j = "";
        this.f1973k = "";
        this.f1974l = true;
        this.f1975m = 0;
        this.f1976n = "success";
        this.f1977o = "";
        this.f1978p = 0;
        this.f1979q = 0.0d;
        this.f1980r = 0.0d;
        this.f1981s = 0;
        this.f1982t = "";
        this.f1979q = location.getLatitude();
        this.f1980r = location.getLongitude();
    }

    public AMapLocation(String str) {
        super(str);
        this.f1963a = "";
        this.f1964b = "";
        this.f1965c = "";
        this.f1966d = "";
        this.f1967e = "";
        this.f1968f = "";
        this.f1969g = "";
        this.f1970h = "";
        this.f1971i = "";
        this.f1972j = "";
        this.f1973k = "";
        this.f1974l = true;
        this.f1975m = 0;
        this.f1976n = "success";
        this.f1977o = "";
        this.f1978p = 0;
        this.f1979q = 0.0d;
        this.f1980r = 0.0d;
        this.f1981s = 0;
        this.f1982t = "";
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.f1967e;
    }

    public String getAddress() {
        return this.f1968f;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return super.getAltitude();
    }

    public String getAoiName() {
        return this.f1982t;
    }

    @Override // android.location.Location
    public float getBearing() {
        return super.getBearing();
    }

    public String getCity() {
        return this.f1964b;
    }

    public String getCityCode() {
        return this.f1966d;
    }

    public String getCountry() {
        return this.f1970h;
    }

    public String getDistrict() {
        return this.f1965c;
    }

    public int getErrorCode() {
        return this.f1975m;
    }

    public String getErrorInfo() {
        return this.f1976n;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.f1979q;
    }

    public String getLocationDetail() {
        return this.f1977o;
    }

    public int getLocationType() {
        return this.f1978p;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.f1980r;
    }

    public String getPoiName() {
        return this.f1969g;
    }

    @Override // android.location.Location
    public String getProvider() {
        return super.getProvider();
    }

    public String getProvince() {
        return this.f1963a;
    }

    public String getRoad() {
        return this.f1971i;
    }

    public int getSatellites() {
        return this.f1981s;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return super.getSpeed();
    }

    public String getStreet() {
        return this.f1972j;
    }

    public String getStreetNum() {
        return this.f1973k;
    }

    public boolean isOffset() {
        return this.f1974l;
    }

    public void setAdCode(String str) {
        this.f1967e = str;
    }

    public void setAddress(String str) {
        this.f1968f = str;
    }

    public void setAoiName(String str) {
        this.f1982t = str;
    }

    public void setCity(String str) {
        this.f1964b = str;
    }

    public void setCityCode(String str) {
        this.f1966d = str;
    }

    public void setCountry(String str) {
        this.f1970h = str;
    }

    public void setDistrict(String str) {
        this.f1965c = str;
    }

    public void setErrorCode(int i) {
        if (this.f1975m != 0) {
            return;
        }
        switch (i) {
            case 0:
                this.f1976n = "success";
                break;
            case 1:
                this.f1976n = "重要参数为空";
                break;
            case 2:
                this.f1976n = "WIFI信息不足";
                break;
            case 3:
                this.f1976n = "请求参数获取出现异常";
                break;
            case 4:
                this.f1976n = "网络连接异常";
                break;
            case 5:
                this.f1976n = "解析XML出错";
                break;
            case 6:
                this.f1976n = "定位结果错误";
                break;
            case 7:
                this.f1976n = "KEY错误";
                break;
            case 8:
                this.f1976n = "其他错误";
                break;
            case 9:
                this.f1976n = "初始化异常";
                break;
            case 10:
                this.f1976n = "定位服务启动失败";
                break;
            case 11:
                this.f1976n = "错误的基站信息，请检查是否插入SIM卡";
                break;
            case 12:
                this.f1976n = "缺少定位权限";
                break;
        }
        this.f1975m = i;
    }

    public void setErrorInfo(String str) {
        this.f1976n = str;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        this.f1979q = d;
    }

    public void setLocationDetail(String str) {
        this.f1977o = str;
    }

    public void setLocationType(int i) {
        this.f1978p = i;
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        this.f1980r = d;
    }

    public void setNumber(String str) {
        this.f1973k = str;
    }

    public void setOffset(boolean z) {
        this.f1974l = z;
    }

    public void setPoiName(String str) {
        this.f1969g = str;
    }

    public void setProvince(String str) {
        this.f1963a = str;
    }

    public void setRoad(String str) {
        this.f1971i = str;
    }

    public void setSatellites(int i) {
        this.f1981s = i;
    }

    public void setStreet(String str) {
        this.f1972j = str;
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int i) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject();
            switch (i) {
                case 1:
                    jSONObject2.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.f1970h);
                    jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.f1963a);
                    jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, this.f1964b);
                    jSONObject2.put("cityCode", this.f1966d);
                    jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f1965c);
                    jSONObject2.put("adCode", this.f1967e);
                    jSONObject2.put("address", this.f1968f);
                    jSONObject2.put("road", this.f1971i);
                    jSONObject2.put("street", this.f1972j);
                    jSONObject2.put("number", this.f1973k);
                    jSONObject2.put("poiName", this.f1969g);
                    jSONObject2.put("errorCode", this.f1975m);
                    jSONObject2.put("errorInfo", this.f1976n);
                    jSONObject2.put("locationDetail", this.f1977o);
                    jSONObject2.put("altitude", getAltitude());
                    jSONObject2.put("bearing", getBearing());
                    jSONObject2.put("speed", getSpeed());
                    jSONObject2.put("satellites", this.f1981s);
                    jSONObject2.put("aoiName", this.f1982t);
                    Bundle extras = getExtras();
                    if (extras != null && extras.containsKey(SocialConstants.PARAM_APP_DESC)) {
                        jSONObject2.put(SocialConstants.PARAM_APP_DESC, extras.getString(SocialConstants.PARAM_APP_DESC));
                    }
                    break;
                case 2:
                    jSONObject2.put(C3628c.C3629a.f14776i, getTime());
                case 3:
                    jSONObject2.put("locationType", this.f1978p);
                    jSONObject2.put("accuracy", getAccuracy());
                    jSONObject2.put("latitude", getLatitude());
                    jSONObject2.put("longitude", getLongitude());
                    jSONObject2.put("provider", getProvider());
                default:
                    jSONObject = jSONObject2;
                    break;
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AMapLocation", "toStr part2");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("latitude=" + this.f1979q);
        stringBuffer.append("longitude=" + this.f1980r);
        stringBuffer.append("province=" + this.f1963a + "#");
        stringBuffer.append("city=" + this.f1964b + "#");
        stringBuffer.append("district=" + this.f1965c + "#");
        stringBuffer.append("cityCode=" + this.f1966d + "#");
        stringBuffer.append("adCode=" + this.f1967e + "#");
        stringBuffer.append("address=" + this.f1968f + "#");
        stringBuffer.append("country=" + this.f1970h + "#");
        stringBuffer.append("road=" + this.f1971i + "#");
        stringBuffer.append("poiName=" + this.f1969g + "#");
        stringBuffer.append("street=" + this.f1972j + "#");
        stringBuffer.append("streetNum=" + this.f1973k + "#");
        stringBuffer.append("aoiName=" + this.f1982t + "#");
        stringBuffer.append("errorCode=" + this.f1975m + "#");
        stringBuffer.append("errorInfo=" + this.f1976n + "#");
        stringBuffer.append("locationDetail=" + this.f1977o + "#");
        stringBuffer.append("locationType=" + this.f1978p);
        return stringBuffer.toString();
    }
}
