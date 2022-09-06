package com.autonavi.aps.amapapi.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.fimi.soul.utils.p211a.C3628c;
import com.p080b.C1477bs;
import com.p080b.C1514cx;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class AmapLoc implements Parcelable {
    public static final Parcelable.Creator<AmapLoc> CREATOR = new C1389a();

    /* renamed from: A */
    private String f4732A;

    /* renamed from: B */
    private String f4733B;

    /* renamed from: C */
    private int f4734C;

    /* renamed from: D */
    private String f4735D;

    /* renamed from: E */
    private String f4736E;

    /* renamed from: F */
    private String f4737F;

    /* renamed from: G */
    private boolean f4738G;

    /* renamed from: H */
    private boolean f4739H;

    /* renamed from: I */
    private JSONObject f4740I;

    /* renamed from: a */
    private String f4741a;

    /* renamed from: b */
    private double f4742b;

    /* renamed from: c */
    private double f4743c;

    /* renamed from: d */
    private double f4744d;

    /* renamed from: e */
    private float f4745e;

    /* renamed from: f */
    private float f4746f;

    /* renamed from: g */
    private float f4747g;

    /* renamed from: h */
    private long f4748h;

    /* renamed from: i */
    private String f4749i;

    /* renamed from: j */
    private int f4750j;

    /* renamed from: k */
    private String f4751k;

    /* renamed from: l */
    private int f4752l;

    /* renamed from: m */
    private String f4753m;

    /* renamed from: n */
    private String f4754n;

    /* renamed from: o */
    private String f4755o;

    /* renamed from: p */
    private String f4756p;

    /* renamed from: q */
    private String f4757q;

    /* renamed from: r */
    private String f4758r;

    /* renamed from: s */
    private String f4759s;

    /* renamed from: t */
    private String f4760t;

    /* renamed from: u */
    private String f4761u;

    /* renamed from: v */
    private String f4762v;

    /* renamed from: w */
    private String f4763w;

    /* renamed from: x */
    private String f4764x;

    /* renamed from: y */
    private String f4765y;

    /* renamed from: z */
    private String f4766z;

    public AmapLoc() {
        this.f4741a = "";
        this.f4742b = 0.0d;
        this.f4743c = 0.0d;
        this.f4744d = 0.0d;
        this.f4745e = 0.0f;
        this.f4746f = 0.0f;
        this.f4747g = 0.0f;
        this.f4748h = 0L;
        this.f4749i = "new";
        this.f4750j = 0;
        this.f4751k = "success";
        this.f4752l = 0;
        this.f4753m = "";
        this.f4754n = "";
        this.f4755o = "";
        this.f4756p = "";
        this.f4757q = "";
        this.f4758r = "";
        this.f4759s = "";
        this.f4760t = "";
        this.f4761u = "";
        this.f4762v = "";
        this.f4763w = "";
        this.f4764x = "";
        this.f4765y = "";
        this.f4766z = null;
        this.f4732A = "";
        this.f4733B = "";
        this.f4734C = -1;
        this.f4735D = "";
        this.f4736E = "";
        this.f4737F = "";
        this.f4738G = true;
        this.f4739H = true;
        this.f4740I = null;
    }

    public AmapLoc(Parcel parcel) {
        boolean z = true;
        this.f4741a = "";
        this.f4742b = 0.0d;
        this.f4743c = 0.0d;
        this.f4744d = 0.0d;
        this.f4745e = 0.0f;
        this.f4746f = 0.0f;
        this.f4747g = 0.0f;
        this.f4748h = 0L;
        this.f4749i = "new";
        this.f4750j = 0;
        this.f4751k = "success";
        this.f4752l = 0;
        this.f4753m = "";
        this.f4754n = "";
        this.f4755o = "";
        this.f4756p = "";
        this.f4757q = "";
        this.f4758r = "";
        this.f4759s = "";
        this.f4760t = "";
        this.f4761u = "";
        this.f4762v = "";
        this.f4763w = "";
        this.f4764x = "";
        this.f4765y = "";
        this.f4766z = null;
        this.f4732A = "";
        this.f4733B = "";
        this.f4734C = -1;
        this.f4735D = "";
        this.f4736E = "";
        this.f4737F = "";
        this.f4738G = true;
        this.f4739H = true;
        this.f4740I = null;
        this.f4741a = parcel.readString();
        this.f4749i = parcel.readString();
        this.f4751k = parcel.readString();
        this.f4750j = parcel.readInt();
        this.f4747g = parcel.readFloat();
        this.f4746f = parcel.readFloat();
        this.f4745e = parcel.readFloat();
        this.f4742b = parcel.readDouble();
        this.f4743c = parcel.readDouble();
        this.f4744d = parcel.readDouble();
        this.f4748h = parcel.readLong();
        this.f4754n = parcel.readString();
        this.f4755o = parcel.readString();
        this.f4756p = parcel.readString();
        this.f4757q = parcel.readString();
        this.f4758r = parcel.readString();
        this.f4759s = parcel.readString();
        this.f4760t = parcel.readString();
        this.f4761u = parcel.readString();
        this.f4762v = parcel.readString();
        this.f4763w = parcel.readString();
        this.f4764x = parcel.readString();
        this.f4765y = parcel.readString();
        this.f4766z = parcel.readString();
        this.f4732A = parcel.readString();
        this.f4733B = parcel.readString();
        this.f4735D = parcel.readString();
        this.f4753m = parcel.readString();
        this.f4734C = parcel.readInt();
        this.f4752l = parcel.readInt();
        this.f4736E = parcel.readString();
        this.f4738G = parcel.readByte() != 0;
        this.f4739H = parcel.readByte() == 0 ? false : z;
        this.f4737F = parcel.readString();
    }

    public AmapLoc(JSONObject jSONObject) {
        this.f4741a = "";
        this.f4742b = 0.0d;
        this.f4743c = 0.0d;
        this.f4744d = 0.0d;
        this.f4745e = 0.0f;
        this.f4746f = 0.0f;
        this.f4747g = 0.0f;
        this.f4748h = 0L;
        this.f4749i = "new";
        this.f4750j = 0;
        this.f4751k = "success";
        this.f4752l = 0;
        this.f4753m = "";
        this.f4754n = "";
        this.f4755o = "";
        this.f4756p = "";
        this.f4757q = "";
        this.f4758r = "";
        this.f4759s = "";
        this.f4760t = "";
        this.f4761u = "";
        this.f4762v = "";
        this.f4763w = "";
        this.f4764x = "";
        this.f4765y = "";
        this.f4766z = null;
        this.f4732A = "";
        this.f4733B = "";
        this.f4734C = -1;
        this.f4735D = "";
        this.f4736E = "";
        this.f4737F = "";
        this.f4738G = true;
        this.f4739H = true;
        this.f4740I = null;
        if (jSONObject != null) {
            try {
                if (C1477bs.m16000a(jSONObject, "provider")) {
                    m16531c(jSONObject.getString("provider"));
                }
                if (C1477bs.m16000a(jSONObject, "lon")) {
                    m16548a(jSONObject.getDouble("lon"));
                }
                if (C1477bs.m16000a(jSONObject, "lat")) {
                    m16540b(jSONObject.getDouble("lat"));
                }
                if (C1477bs.m16000a(jSONObject, "altitude")) {
                    m16534c(jSONObject.getDouble("altitude"));
                }
                if (C1477bs.m16000a(jSONObject, "acc")) {
                    m16485z(jSONObject.getString("acc"));
                }
                if (C1477bs.m16000a(jSONObject, "accuracy")) {
                    m16547a((float) jSONObject.getLong("accuracy"));
                }
                if (C1477bs.m16000a(jSONObject, "speed")) {
                    m16539b((float) jSONObject.getLong("speed"));
                }
                if (C1477bs.m16000a(jSONObject, "dir")) {
                    m16533c((float) jSONObject.getLong("dir"));
                }
                if (C1477bs.m16000a(jSONObject, "bearing")) {
                    m16533c((float) jSONObject.getLong("bearing"));
                }
                if (C1477bs.m16000a(jSONObject, "type")) {
                    m16525f(jSONObject.getString("type"));
                }
                if (C1477bs.m16000a(jSONObject, "retype")) {
                    m16523g(jSONObject.getString("retype"));
                }
                if (C1477bs.m16000a(jSONObject, "citycode")) {
                    m16519i(jSONObject.getString("citycode"));
                }
                if (C1477bs.m16000a(jSONObject, SocialConstants.PARAM_APP_DESC)) {
                    m16517j(jSONObject.getString(SocialConstants.PARAM_APP_DESC));
                }
                if (C1477bs.m16000a(jSONObject, "adcode")) {
                    m16515k(jSONObject.getString("adcode"));
                }
                if (C1477bs.m16000a(jSONObject, DistrictSearchQuery.KEYWORDS_COUNTRY)) {
                    m16513l(jSONObject.getString(DistrictSearchQuery.KEYWORDS_COUNTRY));
                }
                if (C1477bs.m16000a(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE)) {
                    m16511m(jSONObject.getString(DistrictSearchQuery.KEYWORDS_PROVINCE));
                }
                if (C1477bs.m16000a(jSONObject, DistrictSearchQuery.KEYWORDS_CITY)) {
                    m16509n(jSONObject.getString(DistrictSearchQuery.KEYWORDS_CITY));
                }
                if (C1477bs.m16000a(jSONObject, "road")) {
                    m16505p(jSONObject.getString("road"));
                }
                if (C1477bs.m16000a(jSONObject, "street")) {
                    m16503q(jSONObject.getString("street"));
                }
                if (C1477bs.m16000a(jSONObject, "number")) {
                    m16501r(jSONObject.getString("number"));
                }
                if (C1477bs.m16000a(jSONObject, "poiname")) {
                    m16499s(jSONObject.getString("poiname"));
                }
                if (C1477bs.m16000a(jSONObject, "aoiname")) {
                    m16497t(jSONObject.getString("aoiname"));
                }
                if (C1477bs.m16000a(jSONObject, "errorCode")) {
                    m16538b(jSONObject.getInt("errorCode"));
                }
                if (C1477bs.m16000a(jSONObject, "errorInfo")) {
                    m16544a(jSONObject.getString("errorInfo"));
                }
                if (C1477bs.m16000a(jSONObject, "locationType")) {
                    m16546a(jSONObject.getInt("locationType"));
                }
                if (C1477bs.m16000a(jSONObject, "locationDetail")) {
                    m16537b(jSONObject.getString("locationDetail"));
                }
                if (C1477bs.m16000a(jSONObject, "cens")) {
                    m16495u(jSONObject.getString("cens"));
                }
                if (C1477bs.m16000a(jSONObject, "poiid")) {
                    m16493v(jSONObject.getString("poiid"));
                }
                if (C1477bs.m16000a(jSONObject, "pid")) {
                    m16493v(jSONObject.getString("pid"));
                }
                if (C1477bs.m16000a(jSONObject, "floor")) {
                    m16491w(jSONObject.getString("floor"));
                }
                if (C1477bs.m16000a(jSONObject, "flr")) {
                    m16491w(jSONObject.getString("flr"));
                }
                if (C1477bs.m16000a(jSONObject, "coord")) {
                    m16489x(jSONObject.getString("coord"));
                }
                if (C1477bs.m16000a(jSONObject, "mcell")) {
                    m16487y(jSONObject.getString("mcell"));
                }
                if (C1477bs.m16000a(jSONObject, C3628c.C3629a.f14776i)) {
                    m16545a(jSONObject.getLong(C3628c.C3629a.f14776i));
                }
                if (C1477bs.m16000a(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT)) {
                    m16507o(jSONObject.getString(DistrictSearchQuery.KEYWORDS_DISTRICT));
                }
                if (C1477bs.m16000a(jSONObject, "isOffset")) {
                    m16542a(jSONObject.getBoolean("isOffset"));
                }
                if (!C1477bs.m16000a(jSONObject, "isReversegeo")) {
                    return;
                }
                m16536b(jSONObject.getBoolean("isReversegeo"));
            } catch (Throwable th) {
                C1514cx.m15728a(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    /* renamed from: A */
    private void m16556A(String str) {
        this.f4746f = Float.parseFloat(str);
        if (this.f4746f > 100.0f) {
            this.f4746f = 0.0f;
        }
    }

    /* renamed from: B */
    private void m16554B(String str) {
        this.f4747g = Float.parseFloat(str);
    }

    /* renamed from: z */
    private void m16485z(String str) {
        this.f4745e = Float.parseFloat(str);
    }

    /* renamed from: A */
    public String m16557A() {
        return this.f4732A;
    }

    /* renamed from: B */
    public int m16555B() {
        return this.f4734C;
    }

    /* renamed from: C */
    public String m16553C() {
        return this.f4735D;
    }

    /* renamed from: D */
    public AmapLoc m16552D() {
        String m16553C = m16553C();
        if (TextUtils.isEmpty(m16553C)) {
            return null;
        }
        String[] split = m16553C.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length != 3) {
            return null;
        }
        AmapLoc amapLoc = new AmapLoc();
        amapLoc.m16531c(m16524g());
        amapLoc.m16529d(split[0]);
        amapLoc.m16527e(split[1]);
        amapLoc.m16547a(Float.parseFloat(split[2]));
        amapLoc.m16519i(m16508o());
        amapLoc.m16515k(m16504q());
        amapLoc.m16513l(m16502r());
        amapLoc.m16511m(m16500s());
        amapLoc.m16509n(m16498t());
        amapLoc.m16545a(m16516k());
        amapLoc.m16525f(m16514l());
        amapLoc.m16489x(String.valueOf(m16555B()));
        if (!C1477bs.m16006a(amapLoc)) {
            return null;
        }
        return amapLoc;
    }

    /* renamed from: E */
    public JSONObject m16551E() {
        return this.f4740I;
    }

    /* renamed from: F */
    public String m16550F() {
        return m16532c(1);
    }

    /* renamed from: a */
    public int m16549a() {
        return this.f4750j;
    }

    /* renamed from: a */
    public void m16548a(double d) {
        m16529d(C1477bs.m16003a(Double.valueOf(d), "#.000000"));
    }

    /* renamed from: a */
    public void m16547a(float f) {
        m16485z(String.valueOf(Math.round(f)));
    }

    /* renamed from: a */
    public void m16546a(int i) {
        this.f4752l = i;
    }

    /* renamed from: a */
    public void m16545a(long j) {
        this.f4748h = j;
    }

    /* renamed from: a */
    public void m16544a(String str) {
        this.f4751k = str;
    }

    /* renamed from: a */
    public void m16543a(JSONObject jSONObject) {
        this.f4740I = jSONObject;
    }

    /* renamed from: a */
    public void m16542a(boolean z) {
        this.f4738G = z;
    }

    /* renamed from: b */
    public int m16541b() {
        return this.f4752l;
    }

    /* renamed from: b */
    public void m16540b(double d) {
        m16527e(C1477bs.m16003a(Double.valueOf(d), "#.000000"));
    }

    /* renamed from: b */
    public void m16539b(float f) {
        m16556A(C1477bs.m16003a(Float.valueOf(f), "#.0"));
    }

    /* renamed from: b */
    public void m16538b(int i) {
        if (this.f4750j != 0) {
            return;
        }
        switch (i) {
            case 0:
                this.f4751k = "success";
                break;
            case 1:
                this.f4751k = "重要参数为空";
                break;
            case 2:
                this.f4751k = "WIFI信息不足";
                break;
            case 3:
                this.f4751k = "请求参数获取出现异常";
                break;
            case 4:
                this.f4751k = "网络连接异常";
                break;
            case 5:
                this.f4751k = "解析XML出错";
                break;
            case 6:
                this.f4751k = "定位结果错误";
                break;
            case 7:
                this.f4751k = "KEY错误";
                break;
            case 8:
                this.f4751k = "其他错误";
                break;
            case 9:
                this.f4751k = "初始化异常";
                break;
            case 10:
                this.f4751k = "定位服务启动失败";
                break;
            case 11:
                this.f4751k = "错误的基站信息，请检查是否插入SIM卡";
                break;
            case 12:
                this.f4751k = "缺少定位权限";
                break;
        }
        this.f4750j = i;
    }

    /* renamed from: b */
    public void m16537b(String str) {
        if (this.f4753m == null || this.f4753m.length() == 0) {
            this.f4753m = str;
        }
    }

    /* renamed from: b */
    public void m16536b(boolean z) {
        this.f4739H = z;
    }

    /* renamed from: c */
    public String m16535c() {
        return this.f4751k;
    }

    /* renamed from: c */
    public String m16532c(int i) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            switch (i) {
                case 1:
                    jSONObject.put("altitude", this.f4744d);
                    jSONObject.put("speed", this.f4746f);
                    jSONObject.put("bearing", this.f4747g);
                    jSONObject.put("retype", this.f4754n);
                    jSONObject.put("citycode", this.f4756p);
                    jSONObject.put(SocialConstants.PARAM_APP_DESC, this.f4757q);
                    jSONObject.put("adcode", this.f4758r);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_COUNTRY, this.f4759s);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_PROVINCE, this.f4760t);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f4761u);
                    jSONObject.put(DistrictSearchQuery.KEYWORDS_DISTRICT, this.f4762v);
                    jSONObject.put("road", this.f4763w);
                    jSONObject.put("street", this.f4764x);
                    jSONObject.put("number", this.f4736E);
                    jSONObject.put("poiname", this.f4765y);
                    jSONObject.put("cens", this.f4766z);
                    jSONObject.put("poiid", this.f4732A);
                    jSONObject.put("floor", this.f4733B);
                    jSONObject.put("coord", this.f4734C);
                    jSONObject.put("mcell", this.f4735D);
                    jSONObject.put("errorCode", this.f4750j);
                    jSONObject.put("errorInfo", this.f4751k);
                    jSONObject.put("locationType", this.f4752l);
                    jSONObject.put("locationDetail", this.f4753m);
                    jSONObject.put("aoiname", this.f4737F);
                    if (this.f4740I != null && C1477bs.m16000a(jSONObject, "offpct")) {
                        jSONObject.put("offpct", this.f4740I.getString("offpct"));
                    }
                    break;
                case 2:
                    jSONObject.put(C3628c.C3629a.f14776i, this.f4748h);
                case 3:
                    jSONObject.put("provider", this.f4741a);
                    jSONObject.put("lon", this.f4742b);
                    jSONObject.put("lat", this.f4743c);
                    jSONObject.put("accuracy", this.f4745e);
                    jSONObject.put("type", this.f4749i);
                    jSONObject.put("isOffset", this.f4738G);
                    jSONObject.put("isReversegeo", this.f4739H);
                    break;
            }
        } catch (Throwable th) {
            C1514cx.m15728a(th, "AmapLoc", "toStr");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: c */
    public void m16534c(double d) {
        this.f4744d = d;
    }

    /* renamed from: c */
    public void m16533c(float f) {
        m16554B(C1477bs.m16003a(Float.valueOf(f), "#.0"));
    }

    /* renamed from: c */
    public void m16531c(String str) {
        this.f4741a = str;
    }

    /* renamed from: d */
    public String m16530d() {
        return this.f4753m;
    }

    /* renamed from: d */
    public void m16529d(String str) {
        this.f4742b = Double.parseDouble(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public void m16527e(String str) {
        this.f4743c = Double.parseDouble(str);
    }

    /* renamed from: e */
    public boolean m16528e() {
        return this.f4738G;
    }

    /* renamed from: f */
    public void m16525f(String str) {
        this.f4749i = str;
    }

    /* renamed from: f */
    public boolean m16526f() {
        return this.f4739H;
    }

    /* renamed from: g */
    public String m16524g() {
        return this.f4741a;
    }

    /* renamed from: g */
    public void m16523g(String str) {
        this.f4754n = str;
    }

    /* renamed from: h */
    public double m16522h() {
        return this.f4742b;
    }

    /* renamed from: h */
    public void m16521h(String str) {
        this.f4755o = str;
    }

    /* renamed from: i */
    public double m16520i() {
        return this.f4743c;
    }

    /* renamed from: i */
    public void m16519i(String str) {
        this.f4756p = str;
    }

    /* renamed from: j */
    public float m16518j() {
        return this.f4745e;
    }

    /* renamed from: j */
    public void m16517j(String str) {
        this.f4757q = str;
    }

    /* renamed from: k */
    public long m16516k() {
        return this.f4748h;
    }

    /* renamed from: k */
    public void m16515k(String str) {
        this.f4758r = str;
    }

    /* renamed from: l */
    public String m16514l() {
        return this.f4749i;
    }

    /* renamed from: l */
    public void m16513l(String str) {
        this.f4759s = str;
    }

    /* renamed from: m */
    public String m16512m() {
        return this.f4754n;
    }

    /* renamed from: m */
    public void m16511m(String str) {
        this.f4760t = str;
    }

    /* renamed from: n */
    public String m16510n() {
        return this.f4755o;
    }

    /* renamed from: n */
    public void m16509n(String str) {
        this.f4761u = str;
    }

    /* renamed from: o */
    public String m16508o() {
        return this.f4756p;
    }

    /* renamed from: o */
    public void m16507o(String str) {
        this.f4762v = str;
    }

    /* renamed from: p */
    public String m16506p() {
        return this.f4757q;
    }

    /* renamed from: p */
    public void m16505p(String str) {
        this.f4763w = str;
    }

    /* renamed from: q */
    public String m16504q() {
        return this.f4758r;
    }

    /* renamed from: q */
    public void m16503q(String str) {
        this.f4764x = str;
    }

    /* renamed from: r */
    public String m16502r() {
        return this.f4759s;
    }

    /* renamed from: r */
    public void m16501r(String str) {
        this.f4736E = str;
    }

    /* renamed from: s */
    public String m16500s() {
        return this.f4760t;
    }

    /* renamed from: s */
    public void m16499s(String str) {
        this.f4765y = str;
    }

    /* renamed from: t */
    public String m16498t() {
        return this.f4761u;
    }

    /* renamed from: t */
    public void m16497t(String str) {
        this.f4737F = str;
    }

    /* renamed from: u */
    public String m16496u() {
        return this.f4762v;
    }

    /* renamed from: u */
    public void m16495u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\*");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str2 = split[i];
            if (!TextUtils.isEmpty(str2)) {
                String[] split2 = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                m16548a(Double.parseDouble(split2[0]));
                m16540b(Double.parseDouble(split2[1]));
                m16547a(Integer.parseInt(split2[2]));
                break;
            }
            i++;
        }
        this.f4766z = str;
    }

    /* renamed from: v */
    public String m16494v() {
        return this.f4763w;
    }

    /* renamed from: v */
    public void m16493v(String str) {
        this.f4732A = str;
    }

    /* renamed from: w */
    public String m16492w() {
        return this.f4764x;
    }

    /* renamed from: w */
    public void m16491w(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                str = null;
                C1514cx.m15728a(th, "AmapLoc", "setFloor");
            }
        }
        this.f4733B = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        byte b = 1;
        parcel.writeString(this.f4741a);
        parcel.writeString(this.f4749i);
        parcel.writeString(this.f4751k);
        parcel.writeInt(this.f4750j);
        parcel.writeFloat(this.f4747g);
        parcel.writeFloat(this.f4746f);
        parcel.writeFloat(this.f4745e);
        parcel.writeDouble(this.f4742b);
        parcel.writeDouble(this.f4743c);
        parcel.writeDouble(this.f4744d);
        parcel.writeLong(this.f4748h);
        parcel.writeString(this.f4754n);
        parcel.writeString(this.f4755o);
        parcel.writeString(this.f4756p);
        parcel.writeString(this.f4757q);
        parcel.writeString(this.f4758r);
        parcel.writeString(this.f4759s);
        parcel.writeString(this.f4760t);
        parcel.writeString(this.f4761u);
        parcel.writeString(this.f4762v);
        parcel.writeString(this.f4763w);
        parcel.writeString(this.f4764x);
        parcel.writeString(this.f4765y);
        parcel.writeString(this.f4766z);
        parcel.writeString(this.f4732A);
        parcel.writeString(this.f4733B);
        parcel.writeString(this.f4735D);
        parcel.writeString(this.f4753m);
        parcel.writeInt(this.f4734C);
        parcel.writeInt(this.f4752l);
        parcel.writeString(this.f4736E);
        parcel.writeByte(this.f4738G ? (byte) 1 : (byte) 0);
        if (!this.f4739H) {
            b = 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.f4737F);
    }

    /* renamed from: x */
    public String m16490x() {
        return this.f4736E;
    }

    /* renamed from: x */
    public void m16489x(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f4734C = -1;
        } else if (this.f4741a.equals(GeocodeSearch.GPS)) {
            this.f4734C = 0;
        } else if (str.equals("0")) {
            this.f4734C = 0;
        } else if (str.equals("1")) {
            this.f4734C = 1;
        } else {
            this.f4734C = -1;
        }
    }

    /* renamed from: y */
    public String m16488y() {
        return this.f4765y;
    }

    /* renamed from: y */
    public void m16487y(String str) {
        this.f4735D = str;
    }

    /* renamed from: z */
    public String m16486z() {
        return this.f4737F;
    }
}
