package com.fimi.soul.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.fimi.kernel.utils.C2277v;
import com.fimi.soul.entity.User;
import com.fimi.soul.utils.NetUtil;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.loopj.android.http.AsyncHttpClient;
import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.contact.RContact;
/* renamed from: com.fimi.soul.base.b */
/* loaded from: classes.dex */
public class C2353b {

    /* renamed from: A */
    public static final String f7910A = "f423350548790693b784577448fd7d15";

    /* renamed from: B */
    public static final String f7911B = "miserver_preferen_";

    /* renamed from: C */
    public static final String f7912C = "temp_update.apk";

    /* renamed from: D */
    public static final int f7913D = 0;

    /* renamed from: E */
    public static final int f7914E = 1;

    /* renamed from: F */
    public static final String f7915F = "check_firmware_model";

    /* renamed from: G */
    public static final int f7916G = 0;

    /* renamed from: H */
    public static final int f7917H = 1;

    /* renamed from: I */
    public static final String f7918I = "connect_success";

    /* renamed from: J */
    public static final int f7919J = 0;

    /* renamed from: K */
    public static final String f7920K = "is_setting_enter";

    /* renamed from: L */
    public static final int f7921L = 1;

    /* renamed from: M */
    public static final int f7922M = 2;

    /* renamed from: N */
    public static final String f7923N = "wifiDistanceFile";

    /* renamed from: O */
    public static final String f7924O = "ispopDialog";

    /* renamed from: P */
    public static final String f7925P = "isdeleteTF";

    /* renamed from: Q */
    public static final String f7926Q = "isdirectcalicompass";

    /* renamed from: R */
    public static final String f7927R = "sava_flight_all_time";

    /* renamed from: S */
    public static final String f7928S = "save_total_flight_time";

    /* renamed from: T */
    public static final String f7929T = "sava_flight_cur_time";

    /* renamed from: U */
    public static final String f7930U = "sava_flight_cur_count";

    /* renamed from: V */
    public static final String f7931V = "sava_flight_cur_range";

    /* renamed from: W */
    public static final String f7932W = "sava_flight_all_range";

    /* renamed from: X */
    public static final int f7933X = 4;

    /* renamed from: Y */
    public static final String f7934Y = "sp_upgrade_xml";

    /* renamed from: Z */
    public static final int f7935Z = 5;

    /* renamed from: a */
    public static final boolean f7936a = false;

    /* renamed from: aa */
    public static final int f7937aa = 2;

    /* renamed from: ab */
    public static final int f7938ab = 4;

    /* renamed from: ac */
    public static final int f7939ac = 10;

    /* renamed from: ad */
    public static final int f7940ad = 5;

    /* renamed from: ae */
    public static final int f7941ae = 3;

    /* renamed from: af */
    public static final String f7942af = "www.baidu.com";

    /* renamed from: ag */
    private static User f7943ag = new User();

    /* renamed from: b */
    public static final int f7944b = 1;

    /* renamed from: c */
    public static final int f7945c = 2;

    /* renamed from: d */
    public static final String f7946d = "MiPlaneApp";

    /* renamed from: e */
    public static final boolean f7947e = false;

    /* renamed from: f */
    public static final String f7948f = "https://drone.fimi.com";

    /* renamed from: g */
    public static final String f7949g = "https://drone.fimi.com/statement.html";

    /* renamed from: h */
    public static final String f7950h = "https://drone.fimi.com/privacy.html";

    /* renamed from: i */
    public static final String f7951i = "https://drone.fimi.com/android/fimi.service";

    /* renamed from: j */
    public static final String f7952j = "";

    /* renamed from: k */
    public static final String f7953k = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: l */
    public static final String f7954l = "MM-dd HH:mm";

    /* renamed from: m */
    public static final String f7955m = "https://files.fds.api.xiaomi.com";

    /* renamed from: n */
    public static final String f7956n = "dronedata";

    /* renamed from: o */
    public static final String f7957o = "HmacSHA1";

    /* renamed from: p */
    public static final String f7958p = "2882303761517328945";

    /* renamed from: q */
    public static final String f7959q = "5101732874945";

    /* renamed from: r */
    public static final String f7960r = "sp_new_hand";

    /* renamed from: s */
    public static final String f7961s = "wx63bc994fd4e454c2";

    /* renamed from: t */
    public static final String f7962t = "18665971360";

    /* renamed from: u */
    public static final String f7963u = "fimi12345";

    /* renamed from: v */
    public static final String f7964v = "b2d5437b351877d9";

    /* renamed from: w */
    public static final String f7965w = "5c4873e37f2de34e4900cff10349ce6c";

    /* renamed from: x */
    public static final String f7966x = "XiaoMi";

    /* renamed from: y */
    public static final String f7967y = "2882303761517328945";

    /* renamed from: z */
    public static final String f7968z = "1465961173";

    /* renamed from: a */
    public static void m12513a(Context context) {
        C2277v m12784a = C2277v.m12784a(context);
        m12784a.m12761f("name");
        m12784a.m12761f(RContact.COL_NICKNAME);
        m12784a.m12761f("sex");
        m12784a.m12761f("device");
        m12784a.m12761f(GameAppOperation.GAME_SIGNATURE);
        m12784a.m12761f("userIDs");
        m12784a.m12761f("phone");
        m12784a.m12761f("xiaomiId");
        m12784a.m12761f("isfirstloading");
        m12784a.m12761f("userID");
        m12784a.m12761f("userImgUrl");
        m12784a.m12761f("objectName");
        m12784a.m12761f("curLongitude");
        m12784a.m12761f("curLatitude");
    }

    /* renamed from: a */
    public static void m12512a(Context context, User user) {
        m12511a(user);
        C2277v m12784a = C2277v.m12784a(context);
        m12784a.m12781a("name", f7943ag.getName());
        m12784a.m12781a(RContact.COL_NICKNAME, f7943ag.getNickName());
        m12784a.m12781a("sex", f7943ag.getSex());
        m12784a.m12781a("device", f7943ag.getDevice());
        m12784a.m12781a(GameAppOperation.GAME_SIGNATURE, f7943ag.getSignature());
        m12784a.m12781a("userIDs", f7943ag.getUserIDs());
        m12784a.m12781a("phone", f7943ag.getPhone());
        m12784a.m12781a("xiaomiId", f7943ag.getXiaomiID());
        m12784a.m12781a("userID", f7943ag.getUserID());
        m12784a.m12781a("isfirstloading", "");
        m12784a.m12781a("userImgUrl", f7943ag.getUserImgUrl());
        m12784a.m12781a("objectName", f7943ag.getObjectName());
        m12784a.m12781a("curLongitude", f7943ag.getCurLongitude());
        m12784a.m12781a("curLatitude", f7943ag.getCurLatitude());
    }

    /* renamed from: a */
    public static void m12511a(User user) {
        f7943ag.setCountry(user.getCountry());
        f7943ag.setCurLatitude(user.getCurLatitude());
        f7943ag.setCurLongitude(user.getCurLongitude());
        f7943ag.setDevice(user.getDevice());
        f7943ag.setPhone(user.getPhone());
        f7943ag.setName(user.getName());
        f7943ag.setNickName(user.getNickName());
        f7943ag.setSex(user.getSex());
        f7943ag.setSignature(user.getSignature());
        f7943ag.setUserIDs(user.getUserIDs());
        f7943ag.setUserImgUrl(user.getUserImgUrl());
        f7943ag.setXiaomiID(user.getXiaomiID());
        f7943ag.setUserID(user.getUserID());
        f7943ag.setCurLatitude(user.getCurLatitude());
        f7943ag.setCurLongitude(user.getCurLongitude());
    }

    /* renamed from: a */
    public static void m12510a(AsyncHttpClient asyncHttpClient, SharedPreferences sharedPreferences) {
        asyncHttpClient.addHeader("Cookie", "name=" + sharedPreferences.getString("cookie_name", ""));
        asyncHttpClient.addHeader("Cookie", "password=" + sharedPreferences.getString("cookie_password", ""));
        asyncHttpClient.addHeader("Cookie", "JSESSIONID=" + NetUtil.f14748a);
        asyncHttpClient.addHeader("Cookie", "key=" + sharedPreferences.getString("cookie_key", ""));
        asyncHttpClient.addHeader("Cookie", "datasourceName=" + sharedPreferences.getString("cookie_datasourceName", ""));
    }

    /* renamed from: a */
    public static void m12509a(String str, Class cls) {
    }

    /* renamed from: b */
    public static void m12508b(Context context) {
        C2277v m12784a = C2277v.m12784a(context);
        String m12758g = m12784a.m12758g("name");
        if (m12758g == null || "".equals(m12758g)) {
            f7943ag.setName("小飞");
        } else {
            f7943ag.setName(m12758g);
        }
        String m12758g2 = m12784a.m12758g(RContact.COL_NICKNAME);
        if (m12758g2 == null || "".equals(m12758g2)) {
            f7943ag.setNickName("飞飞");
        } else {
            f7943ag.setNickName(m12758g2);
        }
        String m12758g3 = m12784a.m12758g("sex");
        if (m12758g3 == null || "".equals(m12758g3)) {
            f7943ag.setSex("男");
        } else {
            f7943ag.setSex(m12758g3);
        }
        f7943ag.setSignature(m12784a.m12758g(GameAppOperation.GAME_SIGNATURE));
        f7943ag.setXiaomiID(m12784a.m12758g("xiaomiId"));
        f7943ag.setUserIDs(m12784a.m12758g("userIDs"));
        f7943ag.setUserID(m12784a.m12758g("userID"));
        f7943ag.setUserImgUrl(m12784a.m12758g("userImgUrl"));
        f7943ag.setCurLatitude(m12784a.m12758g("curLatitude"));
        f7943ag.setCurLongitude(m12784a.m12758g("curLongitude"));
        f7943ag.setPhone(m12784a.m12758g("phone"));
    }

    /* renamed from: c */
    public static User m12507c(Context context) {
        if (TextUtils.isEmpty(f7943ag.getUserID())) {
            m12508b(context);
        }
        return f7943ag;
    }

    /* renamed from: d */
    public static void m12506d(Context context) {
        C2277v.m12784a(context).m12787a().edit().remove("userID").commit();
        f7943ag.setUserID("");
        f7943ag.setName("");
        f7943ag.setNickName("");
        f7943ag.setSignature("");
        f7943ag.setCountry("");
    }

    /* renamed from: e */
    public static final boolean m12505e(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled(GeocodeSearch.GPS) || locationManager.isProviderEnabled(C3947a.f16908s);
    }
}
