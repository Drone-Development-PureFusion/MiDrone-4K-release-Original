package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.github.moduth.blockcanary.p215b.C3947a;
import com.p219mi.live.openlivesdk.C4095b;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xiaomi.channel.commonutils.android.C4468e;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4479a;
import com.xiaomi.channel.commonutils.network.C4495b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.smack.C4715b;
import java.util.TreeMap;
import org.json.JSONObject;
/* renamed from: com.xiaomi.push.service.o */
/* loaded from: classes.dex */
public class C4683o {

    /* renamed from: a */
    private static C4682n f19171a;

    /* renamed from: b */
    private static AbstractC4684a f19172b;

    /* renamed from: com.xiaomi.push.service.o$a */
    /* loaded from: classes2.dex */
    public interface AbstractC4684a {
        /* renamed from: a */
        void m4131a();
    }

    /* renamed from: a */
    public static synchronized C4682n m4137a(Context context) {
        C4682n c4682n = null;
        synchronized (C4683o.class) {
            if (f19171a != null) {
                c4682n = f19171a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString("uuid", null);
                String string2 = sharedPreferences.getString(Constants.EXTRA_KEY_TOKEN, null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString("app_id", null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString("package_name", null);
                String string7 = sharedPreferences.getString("device_id", null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && string7.startsWith("a-")) {
                    string7 = C4468e.m5080e(context);
                    sharedPreferences.edit().putString("device_id", string7).commit();
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    String m5080e = C4468e.m5080e(context);
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) || TextUtils.isEmpty(m5080e) || TextUtils.isEmpty(string7) || string7.equals(m5080e)) {
                        f19171a = new C4682n(string, string2, string3, string4, string5, string6, i);
                        c4682n = f19171a;
                    } else {
                        AbstractC4478b.m5036d("erase the old account.");
                        m4133b(context);
                    }
                }
            }
        }
        return c4682n;
    }

    /* renamed from: a */
    public static synchronized C4682n m4135a(Context context, String str, String str2, String str3) {
        PackageInfo packageInfo;
        C4682n c4682n = null;
        synchronized (C4683o.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", C4468e.m5085a(context));
            String str4 = m4132c(context) ? "1000271" : str2;
            String str5 = m4132c(context) ? "420100086271" : str3;
            String str6 = m4132c(context) ? "com.xiaomi.xmsf" : str;
            treeMap.put("appid", str4);
            treeMap.put("apptoken", str5);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str6, 16384);
            } catch (Exception e) {
                AbstractC4478b.m5039a(e);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo != null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(26));
            treeMap.put(C4095b.f17106g, str6);
            treeMap.put(C3947a.f16893d, Build.MODEL);
            treeMap.put(Constants.EXTRA_KEY_IMEI_MD5, C4507d.m4948a(C4468e.m5082c(context)));
            treeMap.put("os", Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            int m5084b = C4468e.m5084b();
            if (m5084b >= 0) {
                treeMap.put("space_id", Integer.toString(m5084b));
            }
            String m4948a = C4507d.m4948a(C4468e.m5078g(context));
            if (!TextUtils.isEmpty(m4948a)) {
                treeMap.put("mac_address", m4948a);
            }
            treeMap.put("android_id", C4468e.m5083b(context));
            C4495b m4998a = C4497d.m4998a(context, m4138a(), treeMap);
            String str7 = "";
            if (m4998a != null) {
                str7 = m4998a.m5003a();
            }
            if (!TextUtils.isEmpty(str7)) {
                JSONObject jSONObject = new JSONObject(str7);
                if (jSONObject.getInt(XiaomiOAuthConstants.EXTRA_CODE_2) == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    c4682n = new C4682n(jSONObject2.getString("userId") + "@xiaomi.com/an" + C4507d.m4949a(6), jSONObject2.getString(Constants.EXTRA_KEY_TOKEN), jSONObject2.getString("ssecurity"), str4, str5, str6, C4479a.m5031c());
                    m4136a(context, c4682n);
                    f19171a = c4682n;
                } else {
                    C4687r.m4120a(context, jSONObject.getInt(XiaomiOAuthConstants.EXTRA_CODE_2), jSONObject.optString("description"));
                    AbstractC4478b.m5041a(str7);
                }
            }
        }
        return c4682n;
    }

    /* renamed from: a */
    public static String m4138a() {
        if (C4479a.m5032b()) {
            return "http://" + C4715b.f19378c + ":9085/pass/register";
        }
        return "https://" + (C4479a.m5034a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/register";
    }

    /* renamed from: a */
    public static void m4136a(Context context, C4682n c4682n) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", c4682n.f19164a);
        edit.putString("security", c4682n.f19166c);
        edit.putString(Constants.EXTRA_KEY_TOKEN, c4682n.f19165b);
        edit.putString("app_id", c4682n.f19167d);
        edit.putString("package_name", c4682n.f19169f);
        edit.putString("app_token", c4682n.f19168e);
        edit.putString("device_id", C4468e.m5080e(context));
        edit.putInt("env_type", c4682n.f19170g);
        edit.commit();
        m4134b();
    }

    /* renamed from: b */
    public static void m4134b() {
        if (f19172b != null) {
            f19172b.m4131a();
        }
    }

    /* renamed from: b */
    public static void m4133b(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f19171a = null;
        m4134b();
    }

    /* renamed from: c */
    private static boolean m4132c(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
