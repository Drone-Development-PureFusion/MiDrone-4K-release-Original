package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.slim.C4707b;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.packet.C4729b;
import com.xiaomi.smack.packet.C4731c;
import com.xiaomi.smack.packet.C4734f;
import java.util.Collection;
import java.util.Iterator;
/* renamed from: com.xiaomi.push.service.b */
/* loaded from: classes.dex */
public class C4643b {

    /* renamed from: a */
    private C4689s f19061a = new C4689s();

    /* renamed from: a */
    public static String m4285a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* renamed from: a */
    private static void m4293a(Context context, Intent intent, String str) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, m4285a(str));
        }
    }

    /* renamed from: a */
    C4612ak.C4614b m4287a(C4707b c4707b) {
        Collection<C4612ak.C4614b> m4372c = C4612ak.m4383a().m4372c(Integer.toString(c4707b.m4023c()));
        if (m4372c.isEmpty()) {
            return null;
        }
        Iterator<C4612ak.C4614b> it2 = m4372c.iterator();
        if (m4372c.size() == 1) {
            return it2.next();
        }
        String m4013j = c4707b.m4013j();
        while (it2.hasNext()) {
            C4612ak.C4614b next = it2.next();
            if (TextUtils.equals(m4013j, next.f18955b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    C4612ak.C4614b m4286a(AbstractC4732d abstractC4732d) {
        Collection<C4612ak.C4614b> m4372c = C4612ak.m4383a().m4372c(abstractC4732d.m3884l());
        if (m4372c.isEmpty()) {
            return null;
        }
        Iterator<C4612ak.C4614b> it2 = m4372c.iterator();
        if (m4372c.size() == 1) {
            return it2.next();
        }
        String m3880n = abstractC4732d.m3880n();
        String m3882m = abstractC4732d.m3882m();
        while (it2.hasNext()) {
            C4612ak.C4614b next = it2.next();
            if (TextUtils.equals(m3880n, next.f18955b) || TextUtils.equals(m3882m, next.f18955b)) {
                return next;
            }
            while (it2.hasNext()) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m4294a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public void m4292a(Context context, C4612ak.C4614b c4614b, int i) {
        if ("5".equalsIgnoreCase(c4614b.f18961h)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(c4614b.f18954a);
        intent.putExtra(AbstractC4618am.f19000q, c4614b.f18961h);
        intent.putExtra("ext_reason", i);
        intent.putExtra(AbstractC4618am.f18999p, c4614b.f18955b);
        intent.putExtra(AbstractC4618am.f18977B, c4614b.f18963j);
        m4293a(context, intent, c4614b.f18954a);
    }

    /* renamed from: a */
    public void m4291a(Context context, C4612ak.C4614b c4614b, String str, String str2) {
        if ("5".equalsIgnoreCase(c4614b.f18961h)) {
            AbstractC4478b.m5036d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(c4614b.f18954a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", c4614b.f18961h);
        intent.putExtra(AbstractC4618am.f18999p, c4614b.f18955b);
        intent.putExtra(AbstractC4618am.f18977B, c4614b.f18963j);
        m4293a(context, intent, c4614b.f18954a);
    }

    /* renamed from: a */
    public void m4290a(Context context, C4612ak.C4614b c4614b, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(c4614b.f18961h)) {
            this.f19061a.m4110a(context, c4614b, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(c4614b.f18954a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", c4614b.f18961h);
        intent.putExtra(AbstractC4618am.f18999p, c4614b.f18955b);
        intent.putExtra(AbstractC4618am.f18977B, c4614b.f18963j);
        m4293a(context, intent, c4614b.f18954a);
    }

    /* renamed from: a */
    public void m4289a(XMPushService xMPushService, String str, C4707b c4707b) {
        C4612ak.C4614b m4287a = m4287a(c4707b);
        if (m4287a == null) {
            AbstractC4478b.m5036d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f19061a.m4106a(xMPushService, c4707b, m4287a);
        } else {
            AbstractC4478b.m5041a("don't support binary yet");
        }
    }

    /* renamed from: a */
    public void m4288a(XMPushService xMPushService, String str, AbstractC4732d abstractC4732d) {
        String str2;
        C4612ak.C4614b m4286a = m4286a(abstractC4732d);
        if (m4286a == null) {
            AbstractC4478b.m5036d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f19061a.m4105a(xMPushService, abstractC4732d, m4286a);
        } else {
            String str3 = m4286a.f18954a;
            if (abstractC4732d instanceof C4731c) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (abstractC4732d instanceof C4729b) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (!(abstractC4732d instanceof C4734f)) {
                AbstractC4478b.m5036d("unknown packet type, drop it");
                return;
            } else {
                str2 = "com.xiaomi.push.new_pres";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", abstractC4732d.mo3863b());
            intent.putExtra(AbstractC4618am.f18977B, m4286a.f18963j);
            intent.putExtra(AbstractC4618am.f19004u, m4286a.f18962i);
            m4293a(xMPushService, intent, str3);
        }
    }
}
