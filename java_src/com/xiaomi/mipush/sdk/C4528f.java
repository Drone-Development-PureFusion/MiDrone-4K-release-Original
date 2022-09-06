package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.C4659e;
import com.xiaomi.push.service.C4661g;
import com.xiaomi.push.service.C4662h;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4809j;
import com.xiaomi.xmpush.thrift.C4825s;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import org.p248a.p283b.C5389f;
/* renamed from: com.xiaomi.mipush.sdk.f */
/* loaded from: classes2.dex */
public class C4528f {

    /* renamed from: a */
    private static volatile C4528f f18635a;

    /* renamed from: b */
    private final String f18636b = "GeoFenceRegMessageProcessor.";

    /* renamed from: c */
    private Context f18637c;

    private C4528f(Context context) {
        this.f18637c = context;
    }

    /* renamed from: a */
    public static C4528f m4867a(Context context) {
        if (f18635a == null) {
            synchronized (C4528f.class) {
                if (f18635a == null) {
                    f18635a = new C4528f(context);
                }
            }
        }
        return f18635a;
    }

    /* renamed from: a */
    private C4825s m4868a() {
        ArrayList<C4809j> m4275a = C4659e.m4274a(this.f18637c).m4275a();
        C4825s c4825s = new C4825s();
        TreeSet treeSet = new TreeSet();
        Iterator<C4809j> it2 = m4275a.iterator();
        while (it2.hasNext()) {
            treeSet.add(it2.next());
        }
        c4825s.m3262a(treeSet);
        return c4825s;
    }

    /* renamed from: a */
    private void m4865a(C4809j c4809j) {
        byte[] m3471a = C4796aq.m3471a(c4809j);
        C4772ae c4772ae = new C4772ae("-1", false);
        c4772ae.m3695c(EnumC4818o.GeoPackageUninstalled.f20376N);
        c4772ae.m3701a(m3471a);
        C4545u.m4818a(this.f18637c).m4807a(c4772ae, EnumC4763a.Notification, true, null);
        AbstractC4478b.m5041a("GeoFenceRegMessageProcessor.report package not exist geo_fencing id:" + c4809j.m3417a());
    }

    /* renamed from: a */
    private void m4864a(C4809j c4809j, boolean z) {
        byte[] m3471a = C4796aq.m3471a(c4809j);
        C4772ae c4772ae = new C4772ae("-1", false);
        c4772ae.m3695c(z ? EnumC4818o.GeoRegsiterResult.f20376N : EnumC4818o.GeoUnregsiterResult.f20376N);
        c4772ae.m3701a(m3471a);
        C4545u.m4818a(this.f18637c).m4807a(c4772ae, EnumC4763a.Notification, true, null);
        AbstractC4478b.m5041a("GeoFenceRegMessageProcessor.report geo_fencing id:" + c4809j.m3417a() + " " + (z ? "geo_reg" : "geo_unreg"));
    }

    /* renamed from: d */
    private C4809j m4861d(C4772ae c4772ae) {
        if (C4662h.m4251a(this.f18637c) && C4662h.m4248b(this.f18637c)) {
            try {
                C4809j c4809j = new C4809j();
                C4796aq.m3470a(c4809j, c4772ae.m3684m());
                return c4809j;
            } catch (C5389f e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m4866a(C4772ae c4772ae) {
        C4809j m4861d = m4861d(c4772ae);
        if (m4861d == null) {
            AbstractC4478b.m5036d("registration convert geofence object failed notification_id:" + c4772ae.m3696c());
        } else if (!C4464b.m5091f(this.f18637c, m4861d.m3396g())) {
            m4865a(m4861d);
        } else {
            if (C4659e.m4274a(this.f18637c).m4271a(m4861d) == -1) {
                AbstractC4478b.m5041a("GeoFenceRegMessageProcessor. insert a new geofence failed about geo_id:" + m4861d.m3417a());
            }
            new C4529g(this.f18637c).m4859a(m4861d);
            m4864a(m4861d, true);
            AbstractC4478b.m5041a("receive geo reg notification");
        }
    }

    /* renamed from: b */
    public void m4863b(C4772ae c4772ae) {
        C4809j m4861d = m4861d(c4772ae);
        if (m4861d == null) {
            AbstractC4478b.m5036d("unregistration convert geofence object failed notification_id:" + c4772ae.m3696c());
        } else if (!C4464b.m5091f(this.f18637c, m4861d.m3396g())) {
            m4865a(m4861d);
        } else {
            if (C4659e.m4274a(this.f18637c).m4262d(m4861d.m3417a()) == 0) {
                AbstractC4478b.m5041a("GeoFenceRegMessageProcessor. delete a geofence about geo_id:" + m4861d.m3417a() + " falied");
            }
            if (C4661g.m4257a(this.f18637c).m4253b(m4861d.m3417a()) == 0) {
                AbstractC4478b.m5041a("GeoFenceRegMessageProcessor. delete all geofence messages about geo_id:" + m4861d.m3417a() + " failed");
            }
            new C4529g(this.f18637c).m4858a(m4861d.m3417a());
            m4864a(m4861d, false);
            AbstractC4478b.m5041a("receive geo unreg notification");
        }
    }

    /* renamed from: c */
    public void m4862c(C4772ae c4772ae) {
        if (C4662h.m4251a(this.f18637c) && C4662h.m4248b(this.f18637c) && C4464b.m5091f(this.f18637c, c4772ae.f19691i)) {
            C4825s m4868a = m4868a();
            byte[] m3471a = C4796aq.m3471a(m4868a);
            C4772ae c4772ae2 = new C4772ae("-1", false);
            c4772ae2.m3695c(EnumC4818o.GeoUpload.f20376N);
            c4772ae2.m3701a(m3471a);
            C4545u.m4818a(this.f18637c).m4807a(c4772ae2, EnumC4763a.Notification, true, null);
            AbstractC4478b.m5037c("GeoFenceRegMessageProcessor.sync_geo_data. geos size:" + m4868a.m3264a().size());
        }
    }
}
