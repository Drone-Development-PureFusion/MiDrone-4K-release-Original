package com.xiaomi.push.service;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.tencent.tauth.AuthActivity;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.android.C4469f;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C4600ac;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.packet.C4728a;
import com.xiaomi.smack.packet.C4731c;
import com.xiaomi.smack.util.C4749g;
import com.xiaomi.xmpush.thrift.C4766ab;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4823r;
import com.xiaomi.xmpush.thrift.C4832w;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* renamed from: com.xiaomi.push.service.s */
/* loaded from: classes2.dex */
public class C4689s {
    /* renamed from: a */
    public static Intent m4094a(byte[] bArr, long j) {
        C4766ab m4095a = m4095a(bArr);
        if (m4095a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(m4095a.f19629f);
        return intent;
    }

    /* renamed from: a */
    public static C4766ab m4109a(Context context, C4766ab c4766ab) {
        return m4108a(context, c4766ab, false, false, false);
    }

    /* renamed from: a */
    public static C4766ab m4108a(Context context, C4766ab c4766ab, boolean z, boolean z2, boolean z3) {
        C4832w c4832w = new C4832w();
        c4832w.m3225b(c4766ab.m3732h());
        C4823r m3727m = c4766ab.m3727m();
        if (m3727m != null) {
            c4832w.m3230a(m3727m.m3298b());
            c4832w.m3232a(m3727m.m3289d());
            if (!TextUtils.isEmpty(m3727m.m3284f())) {
                c4832w.m3221c(m3727m.m3284f());
            }
        }
        c4832w.m3229a(C4796aq.m3472a(context, c4766ab));
        c4832w.m3224b(C4796aq.m3469a(z, z2, z3));
        C4766ab m4435a = C4598aa.m4435a(c4766ab.m3730j(), c4766ab.m3732h(), c4832w, EnumC4763a.AckMessage);
        C4823r m3305a = c4766ab.m3727m().m3305a();
        m3305a.m3301a("mat", Long.toString(System.currentTimeMillis()));
        m4435a.m3748a(m3305a);
        return m4435a;
    }

    /* renamed from: a */
    public static C4766ab m4095a(byte[] bArr) {
        C4766ab c4766ab = new C4766ab();
        try {
            C4796aq.m3470a(c4766ab, bArr);
            return c4766ab;
        } catch (Throwable th) {
            AbstractC4478b.m5039a(th);
            return null;
        }
    }

    /* renamed from: a */
    private static void m4104a(XMPushService xMPushService, C4766ab c4766ab) {
        xMPushService.m4494a(new C4690t(4, xMPushService, c4766ab));
    }

    /* renamed from: a */
    private static void m4103a(XMPushService xMPushService, C4766ab c4766ab, String str) {
        xMPushService.m4494a(new C4698x(4, xMPushService, c4766ab, str));
    }

    /* renamed from: a */
    private static void m4102a(XMPushService xMPushService, C4766ab c4766ab, String str, String str2) {
        xMPushService.m4494a(new C4699y(4, xMPushService, c4766ab, str, str2));
    }

    /* renamed from: a */
    public static void m4101a(XMPushService xMPushService, C4766ab c4766ab, boolean z, boolean z2, boolean z3) {
        xMPushService.m4494a(new C4700z(4, xMPushService, c4766ab, z, z2, z3));
    }

    /* renamed from: a */
    public static void m4099a(XMPushService xMPushService, String str, byte[] bArr, Intent intent, boolean z) {
        C4766ab m4095a = m4095a(bArr);
        C4823r m3727m = m4095a.m3727m();
        if (m4090c(m4095a) && m4107a(xMPushService, str)) {
            m4089d(xMPushService, m4095a);
        } else if (m4097a(m4095a) && !m4107a(xMPushService, str) && !m4092b(m4095a)) {
            m4088e(xMPushService, m4095a);
        } else if ((!C4600ac.m4414b(m4095a) || !C4464b.m5091f(xMPushService, m4095a.f19629f)) && !m4111a(xMPushService, intent)) {
            if (!C4464b.m5091f(xMPushService, m4095a.f19629f)) {
                m4104a(xMPushService, m4095a);
            } else {
                AbstractC4478b.m5041a("receive a mipush message, we can see the app, but we can't see the receiver.");
            }
        } else {
            if (EnumC4763a.Registration == m4095a.m3751a()) {
                String m3730j = m4095a.m3730j();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(m3730j, m4095a.f19628e);
                edit.commit();
                C4633aw.m4319a().m4305b("Registe Success, package name is " + m3730j);
            }
            if (m3727m != null && !TextUtils.isEmpty(m3727m.m3282h()) && !TextUtils.isEmpty(m3727m.m3280j()) && m3727m.f20458h != 1 && (C4600ac.m4418a(m3727m.m3271s()) || !C4600ac.m4426a(xMPushService, m4095a.f19629f))) {
                boolean z2 = false;
                String str2 = null;
                if (m3727m != null) {
                    if (m3727m.f20460j != null) {
                        str2 = m3727m.f20460j.get("jobkey");
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = m3727m.m3298b();
                    }
                    z2 = C4603ad.m4409a(xMPushService, m4095a.f19629f, str2);
                }
                if (z2) {
                    AbstractC4478b.m5041a("drop a duplicate message, key=" + str2);
                } else {
                    C4600ac.C4602b m4429a = C4600ac.m4429a(xMPushService, m4095a, bArr);
                    if (m4429a.f18935b > 0 && !TextUtils.isEmpty(m4429a.f18934a)) {
                        C4749g.m3827a(xMPushService, m4429a.f18934a, m4429a.f18935b, true, System.currentTimeMillis());
                    }
                    if (!C4600ac.m4414b(m4095a)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(m4095a.f19629f);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, C4643b.m4285a(m4095a.f19629f));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, C4643b.m4285a(m4095a.f19629f));
                        }
                    }
                }
                if (z) {
                    m4101a(xMPushService, m4095a, false, true, false);
                } else {
                    m4091c(xMPushService, m4095a);
                }
            } else if (!"com.xiaomi.xmsf".contains(m4095a.f19629f) || m4095a.m3739c() || m3727m == null || m3727m.m3271s() == null || !m3727m.m3271s().containsKey("ab")) {
                xMPushService.sendBroadcast(intent, C4643b.m4285a(m4095a.f19629f));
            } else {
                m4091c(xMPushService, m4095a);
                AbstractC4478b.m5037c("receive abtest message. ack it." + m3727m.m3298b());
            }
            if (m4095a.m3751a() != EnumC4763a.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    /* renamed from: a */
    private static void m4098a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m3271s;
        C4766ab m4095a = m4095a(bArr);
        if (m4095a == null) {
            return;
        }
        if (TextUtils.isEmpty(m4095a.f19629f)) {
            AbstractC4478b.m5041a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent m4094a = m4094a(bArr, valueOf.longValue());
        String m4421a = C4600ac.m4421a(m4095a);
        C4749g.m3827a(xMPushService, m4421a, j, true, System.currentTimeMillis());
        C4823r m3727m = m4095a.m3727m();
        if (m3727m != null) {
            m3727m.m3301a("mrt", Long.toString(valueOf.longValue()));
        }
        if (EnumC4763a.SendMessage == m4095a.m3751a() && C4685p.m4130a(xMPushService).m4129a(m4095a.f19629f) && !C4600ac.m4414b(m4095a)) {
            String str = "";
            if (m3727m != null) {
                str = m3727m.m3298b();
            }
            AbstractC4478b.m5041a("Drop a message for unregistered, msgid=" + str);
            m4103a(xMPushService, m4095a, m4095a.f19629f);
        } else if (EnumC4763a.SendMessage == m4095a.m3751a() && C4685p.m4130a(xMPushService).m4127c(m4095a.f19629f) && !C4600ac.m4414b(m4095a)) {
            String str2 = "";
            if (m3727m != null) {
                str2 = m3727m.m3298b();
            }
            AbstractC4478b.m5041a("Drop a message for push closed, msgid=" + str2);
            m4103a(xMPushService, m4095a, m4095a.f19629f);
        } else if (EnumC4763a.SendMessage == m4095a.m3751a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), m4095a.f19629f)) {
            AbstractC4478b.m5041a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + m4095a.f19629f);
            m4102a(xMPushService, m4095a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + m4095a.f19629f);
        } else {
            if (m3727m != null && m3727m.m3298b() != null) {
                AbstractC4478b.m5041a(String.format("receive a message, appid=%1$s, msgid= %2$s", m4095a.m3732h(), m3727m.m3298b()));
            }
            if (m3727m != null && (m3271s = m3727m.m3271s()) != null && m3271s.containsKey("hide") && "true".equalsIgnoreCase(m3271s.get("hide"))) {
                m4091c(xMPushService, m4095a);
                return;
            }
            if (m3727m != null && m3727m.m3271s() != null && m3727m.m3271s().containsKey("__miid")) {
                String str3 = m3727m.m3271s().get("__miid");
                Account m5076a = C4469f.m5076a(xMPushService);
                if ((m5076a == null) | (!TextUtils.equals(str3, m5076a.name))) {
                    AbstractC4478b.m5041a(new StringBuilder().append(str3).append(" should be login, but got ").append(m5076a).toString() == null ? "nothing" : m5076a.name);
                    m4102a(xMPushService, m4095a, "miid already logout or anther already login", new StringBuilder().append(str3).append(" should be login, but got ").append(m5076a).toString() == null ? "nothing" : m5076a.name);
                    return;
                }
            }
            boolean z = m3727m != null && m4096a(m3727m.m3271s());
            if (z) {
                if (!m4093b(xMPushService, m4095a)) {
                    return;
                }
                boolean m4100a = m4100a(xMPushService, m3727m, bArr);
                m4101a(xMPushService, m4095a, true, false, false);
                if (!m4100a) {
                    return;
                }
            }
            m4099a(xMPushService, m4421a, bArr, m4094a, z);
        }
    }

    /* renamed from: a */
    private static boolean m4111a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m4107a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m4100a(XMPushService xMPushService, C4823r c4823r, byte[] bArr) {
        Map<String, String> m3271s = c4823r.m3271s();
        String[] split = m3271s.get("__geo_ids").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        ArrayList<ContentValues> arrayList = new ArrayList<>();
        for (String str : split) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("geo_id", str);
            contentValues.put("message_id", c4823r.m3298b());
            int parseInt = Integer.parseInt(m3271s.get("__geo_action"));
            contentValues.put(AuthActivity.ACTION_KEY, Integer.valueOf(parseInt));
            contentValues.put("content", bArr);
            contentValues.put("deadline", Long.valueOf(Long.parseLong(m3271s.get("__geo_deadline"))));
            if (TextUtils.equals(C4659e.m4274a(xMPushService).m4264c(str), "Enter") && parseInt == 1) {
                return true;
            }
            arrayList.add(contentValues);
        }
        if (!C4661g.m4257a(xMPushService).m4254a(arrayList)) {
            AbstractC4478b.m5037c("geofence added some new geofence message failed messagi_id:" + c4823r.m3298b());
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m4097a(C4766ab c4766ab) {
        return "com.xiaomi.xmsf".equals(c4766ab.f19629f) && c4766ab.m3727m() != null && c4766ab.m3727m().m3271s() != null && c4766ab.m3727m().m3271s().containsKey("miui_package_name");
    }

    /* renamed from: a */
    private static boolean m4096a(Map<String, String> map) {
        return map != null && map.containsKey("__geo_ids");
    }

    /* renamed from: b */
    private static boolean m4093b(XMPushService xMPushService, C4766ab c4766ab) {
        if (C4662h.m4251a(xMPushService) && C4662h.m4248b(xMPushService)) {
            if (!C4464b.m5091f(xMPushService, c4766ab.f19629f)) {
                m4104a(xMPushService, c4766ab);
                return false;
            }
            Map<String, String> m3271s = c4766ab.m3727m().m3271s();
            return m3271s != null && "12".contains(m3271s.get("__geo_action")) && !TextUtils.isEmpty(m3271s.get("__geo_ids"));
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m4092b(C4766ab c4766ab) {
        Map<String, String> m3271s = c4766ab.m3727m().m3271s();
        return m3271s != null && m3271s.containsKey("notify_effect");
    }

    /* renamed from: c */
    private static void m4091c(XMPushService xMPushService, C4766ab c4766ab) {
        xMPushService.m4494a(new C4695u(4, xMPushService, c4766ab));
    }

    /* renamed from: c */
    private static boolean m4090c(C4766ab c4766ab) {
        if (c4766ab.m3727m() == null || c4766ab.m3727m().m3271s() == null) {
            return false;
        }
        return "1".equals(c4766ab.m3727m().m3271s().get("obslete_ads_message"));
    }

    /* renamed from: d */
    private static void m4089d(XMPushService xMPushService, C4766ab c4766ab) {
        xMPushService.m4494a(new C4696v(4, xMPushService, c4766ab));
    }

    /* renamed from: e */
    private static void m4088e(XMPushService xMPushService, C4766ab c4766ab) {
        xMPushService.m4494a(new C4697w(4, xMPushService, c4766ab));
    }

    /* renamed from: a */
    public void m4110a(Context context, C4612ak.C4614b c4614b, boolean z, int i, String str) {
        C4682n m4137a;
        if (z || (m4137a = C4683o.m4137a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            C4683o.m4135a(context, m4137a.f19167d, m4137a.f19168e, m4137a.f19169f);
        } catch (IOException e) {
            AbstractC4478b.m5039a(e);
        } catch (JSONException e2) {
            AbstractC4478b.m5039a(e2);
        }
    }

    /* renamed from: a */
    public void m4106a(XMPushService xMPushService, C4707b c4707b, C4612ak.C4614b c4614b) {
        try {
            m4098a(xMPushService, c4707b.m4019d(c4614b.f18962i), c4707b.m4011l());
        } catch (IllegalArgumentException e) {
            AbstractC4478b.m5039a(e);
        }
    }

    /* renamed from: a */
    public void m4105a(XMPushService xMPushService, AbstractC4732d abstractC4732d, C4612ak.C4614b c4614b) {
        if (!(abstractC4732d instanceof C4731c)) {
            AbstractC4478b.m5041a("not a mipush message");
            return;
        }
        C4731c c4731c = (C4731c) abstractC4732d;
        C4728a p = c4731c.p("s");
        if (p == null) {
            return;
        }
        try {
            m4098a(xMPushService, C4624aq.m4344b(C4624aq.m4350a(c4614b.f18962i, c4731c.k()), p.m3917c()), C4749g.m3824a(abstractC4732d.mo3862c()));
        } catch (IllegalArgumentException e) {
            AbstractC4478b.m5039a(e);
        }
    }
}
