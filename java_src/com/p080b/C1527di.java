package com.p080b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import org.json.JSONObject;
/* renamed from: com.b.di */
/* loaded from: classes.dex */
public class C1527di {

    /* renamed from: e */
    private static C1527di f5470e;

    /* renamed from: a */
    Context f5471a;

    /* renamed from: b */
    SharedPreferences f5472b = null;

    /* renamed from: c */
    SharedPreferences.Editor f5473c = null;

    /* renamed from: d */
    private String f5474d;

    private C1527di(Context context) {
        this.f5474d = null;
        this.f5471a = context;
        if (this.f5474d == null) {
            this.f5474d = C1456bd.m16134a("MD5", this.f5471a.getPackageName());
        }
    }

    /* renamed from: a */
    public static C1527di m15690a(Context context) {
        if (f5470e == null) {
            f5470e = new C1527di(context);
        }
        return f5470e;
    }

    /* renamed from: a */
    public AMapLocation m15691a() {
        SharedPreferences sharedPreferences;
        String str;
        if (this.f5471a == null || (sharedPreferences = this.f5471a.getSharedPreferences("pref", 0)) == null) {
            return null;
        }
        String str2 = "lastfix" + C1514cx.f5411f;
        if (sharedPreferences.contains(str2)) {
            try {
                String string = sharedPreferences.getString(str2, null);
                str = string != null ? new String(C1456bd.m16126d(C1544dr.m15603b(string), this.f5474d), "UTF-8") : string;
            } catch (Throwable th) {
                C1514cx.m15728a(th, "LastLocationManager", "getLastFix part1");
                sharedPreferences.edit().remove(str2).commit();
                str = null;
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return C1514cx.m15727a(new JSONObject(str));
        } catch (Throwable th2) {
            C1514cx.m15728a(th2, "LastLocationManager", "getLastFix part2");
            return null;
        }
    }

    /* renamed from: a */
    public void m15689a(AMapLocation aMapLocation) {
        String str = null;
        byte[] bArr = null;
        if (this.f5471a == null || !C1477bs.m16007a(aMapLocation) || aMapLocation.getLocationType() == 2) {
            return;
        }
        if (this.f5472b == null) {
            this.f5472b = this.f5471a.getSharedPreferences("pref", 0);
        }
        if (this.f5473c == null) {
            this.f5473c = this.f5472b.edit();
        }
        if (!TextUtils.isEmpty(aMapLocation.toStr())) {
            try {
                bArr = C1456bd.m16127c(aMapLocation.toStr().getBytes("UTF-8"), this.f5474d);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "LastLocationManager", "setLastFix");
            }
            str = C1544dr.m15602b(bArr);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5473c.putString("lastfix" + C1514cx.f5411f, str);
        C1476br.m16023a(this.f5473c);
    }
}
