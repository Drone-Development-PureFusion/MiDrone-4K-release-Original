package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.string.C4506c;
import com.xiaomi.push.service.AbstractC4618am;
import com.xiaomi.push.service.C4622ao;
import com.xiaomi.xmpush.thrift.C4766ab;
import com.xiaomi.xmpush.thrift.C4772ae;
import com.xiaomi.xmpush.thrift.C4774af;
import com.xiaomi.xmpush.thrift.C4788am;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.C4823r;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4818o;
import java.util.ArrayList;
import java.util.Iterator;
import org.p248a.p283b.AbstractC5358a;
/* renamed from: com.xiaomi.mipush.sdk.u */
/* loaded from: classes.dex */
public class C4545u {

    /* renamed from: b */
    private static C4545u f18665b;

    /* renamed from: e */
    private static final ArrayList<C4546a> f18666e = new ArrayList<>();

    /* renamed from: a */
    private boolean f18667a;

    /* renamed from: c */
    private Context f18668c;

    /* renamed from: f */
    private Handler f18670f;

    /* renamed from: g */
    private Intent f18671g = null;

    /* renamed from: h */
    private Integer f18672h = null;

    /* renamed from: d */
    private String f18669d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.u$a */
    /* loaded from: classes2.dex */
    public static class C4546a<T extends AbstractC5358a<T, ?>> {

        /* renamed from: a */
        T f18673a;

        /* renamed from: b */
        EnumC4763a f18674b;

        /* renamed from: c */
        boolean f18675c;

        C4546a() {
        }
    }

    private C4545u(Context context) {
        this.f18667a = false;
        this.f18670f = null;
        this.f18668c = context.getApplicationContext();
        this.f18667a = m4793h();
        this.f18670f = new HandlerC4547v(this, Looper.getMainLooper());
    }

    /* renamed from: a */
    public static C4545u m4818a(Context context) {
        if (f18665b == null) {
            f18665b = new C4545u(context);
        }
        return f18665b;
    }

    /* renamed from: a */
    private void m4817a(Intent intent) {
        try {
            this.f18668c.startService(intent);
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public final void m4810a(String str, boolean z) {
        C4772ae c4772ae;
        int i = 0;
        if (!C4520a.m4909a(this.f18668c).m4903b() || !C4497d.m4985d(this.f18668c)) {
            return;
        }
        C4772ae c4772ae2 = new C4772ae();
        Intent m4792i = m4792i();
        if (TextUtils.isEmpty(str)) {
            str = MiPushClient.generatePacketID();
            c4772ae2.m3706a(str);
            c4772ae = new C4772ae(str, true);
            synchronized (C4540p.class) {
                C4540p.m4845a(this.f18668c).m4844a(str);
            }
        } else {
            c4772ae2.m3706a(str);
            c4772ae = new C4772ae(str, true);
        }
        if (z) {
            c4772ae2.m3695c(EnumC4818o.DisablePushMessage.f20376N);
            c4772ae.m3695c(EnumC4818o.DisablePushMessage.f20376N);
            m4792i.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
        } else {
            c4772ae2.m3695c(EnumC4818o.EnablePushMessage.f20376N);
            c4772ae.m3695c(EnumC4818o.EnablePushMessage.f20376N);
            m4792i.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
        }
        c4772ae2.m3698b(C4520a.m4909a(this.f18668c).m4901c());
        c4772ae2.m3693d(this.f18668c.getPackageName());
        m4807a(c4772ae2, EnumC4763a.Notification, false, null);
        c4772ae.m3698b(C4520a.m4909a(this.f18668c).m4901c());
        c4772ae.m3693d(this.f18668c.getPackageName());
        byte[] m3471a = C4796aq.m3471a(C4541q.m4836a(this.f18668c, c4772ae, EnumC4763a.Notification, false, this.f18668c.getPackageName(), C4520a.m4909a(this.f18668c).m4901c()));
        if (m3471a != null) {
            m4792i.putExtra("mipush_payload", m3471a);
            m4792i.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            m4792i.putExtra("mipush_app_id", C4520a.m4909a(this.f18668c).m4901c());
            m4792i.putExtra("mipush_app_token", C4520a.m4909a(this.f18668c).m4900d());
            m4817a(m4792i);
        }
        Message obtain = Message.obtain();
        if (z) {
            i = 1;
        }
        obtain.obj = str;
        obtain.arg1 = i;
        this.f18670f.sendMessageDelayed(obtain, 5000L);
    }

    /* renamed from: h */
    private boolean m4793h() {
        try {
            PackageInfo packageInfo = this.f18668c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: i */
    private Intent m4792i() {
        Intent intent = new Intent();
        String packageName = this.f18668c.getPackageName();
        if (!m4798c() || "com.xiaomi.xmsf".equals(packageName)) {
            m4789l();
            intent.setComponent(new ComponentName(this.f18668c, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
        } else {
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m4791j());
            intent.putExtra("mipush_app_package", packageName);
            m4790k();
        }
        return intent;
    }

    /* renamed from: j */
    private String m4791j() {
        return this.f18668c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* renamed from: k */
    private void m4790k() {
        try {
            this.f18668c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f18668c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: l */
    private void m4789l() {
        try {
            this.f18668c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f18668c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: m */
    private boolean m4788m() {
        String packageName = this.f18668c.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f18668c.getApplicationInfo().flags & 1) != 0;
    }

    /* renamed from: a */
    public void m4820a() {
        m4817a(m4792i());
    }

    /* renamed from: a */
    public void m4819a(int i) {
        Intent m4792i = m4792i();
        m4792i.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m4792i.putExtra(AbstractC4618am.f19008y, this.f18668c.getPackageName());
        m4792i.putExtra(AbstractC4618am.f19009z, i);
        m4817a(m4792i);
    }

    /* renamed from: a */
    public final void m4813a(C4774af c4774af, boolean z) {
        this.f18671g = null;
        Intent m4792i = m4792i();
        byte[] m3471a = C4796aq.m3471a(C4541q.m4837a(this.f18668c, c4774af, EnumC4763a.Registration));
        if (m3471a == null) {
            AbstractC4478b.m5041a("register fail, because msgBytes is null.");
            return;
        }
        m4792i.setAction("com.xiaomi.mipush.REGISTER_APP");
        m4792i.putExtra("mipush_app_id", C4520a.m4909a(this.f18668c).m4901c());
        m4792i.putExtra("mipush_payload", m3471a);
        m4792i.putExtra("mipush_session", this.f18669d);
        m4792i.putExtra("mipush_env_chanage", z);
        m4792i.putExtra("mipush_env_type", C4520a.m4909a(this.f18668c).m4891m());
        if (!C4497d.m4985d(this.f18668c) || !m4794g()) {
            this.f18671g = m4792i;
        } else {
            m4817a(m4792i);
        }
    }

    /* renamed from: a */
    public final void m4812a(C4788am c4788am) {
        Intent m4792i = m4792i();
        byte[] m3471a = C4796aq.m3471a(C4541q.m4837a(this.f18668c, c4788am, EnumC4763a.UnRegistration));
        if (m3471a == null) {
            AbstractC4478b.m5041a("unregister fail, because msgBytes is null.");
            return;
        }
        m4792i.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m4792i.putExtra("mipush_app_id", C4520a.m4909a(this.f18668c).m4901c());
        m4792i.putExtra("mipush_payload", m3471a);
        m4817a(m4792i);
    }

    /* renamed from: a */
    public void m4811a(String str, String str2) {
        Intent m4792i = m4792i();
        m4792i.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m4792i.putExtra(AbstractC4618am.f19008y, this.f18668c.getPackageName());
        m4792i.putExtra(AbstractC4618am.f18979D, str);
        m4792i.putExtra(AbstractC4618am.f18980E, str2);
        m4817a(m4792i);
    }

    /* renamed from: a */
    public final <T extends AbstractC5358a<T, ?>> void m4809a(T t, EnumC4763a enumC4763a, C4823r c4823r) {
        m4807a(t, enumC4763a, !enumC4763a.equals(EnumC4763a.Registration), c4823r);
    }

    /* renamed from: a */
    public <T extends AbstractC5358a<T, ?>> void m4808a(T t, EnumC4763a enumC4763a, boolean z) {
        C4546a c4546a = new C4546a();
        c4546a.f18673a = t;
        c4546a.f18674b = enumC4763a;
        c4546a.f18675c = z;
        synchronized (f18666e) {
            f18666e.add(c4546a);
            if (f18666e.size() > 10) {
                f18666e.remove(0);
            }
        }
    }

    /* renamed from: a */
    public final <T extends AbstractC5358a<T, ?>> void m4807a(T t, EnumC4763a enumC4763a, boolean z, C4823r c4823r) {
        m4805a(t, enumC4763a, z, true, c4823r, true);
    }

    /* renamed from: a */
    public final <T extends AbstractC5358a<T, ?>> void m4806a(T t, EnumC4763a enumC4763a, boolean z, C4823r c4823r, boolean z2) {
        m4805a(t, enumC4763a, z, true, c4823r, z2);
    }

    /* renamed from: a */
    public final <T extends AbstractC5358a<T, ?>> void m4805a(T t, EnumC4763a enumC4763a, boolean z, boolean z2, C4823r c4823r, boolean z3) {
        m4804a(t, enumC4763a, z, z2, c4823r, z3, this.f18668c.getPackageName(), C4520a.m4909a(this.f18668c).m4901c());
    }

    /* renamed from: a */
    public final <T extends AbstractC5358a<T, ?>> void m4804a(T t, EnumC4763a enumC4763a, boolean z, boolean z2, C4823r c4823r, boolean z3, String str, String str2) {
        if (!C4520a.m4909a(this.f18668c).m4895i()) {
            if (z2) {
                m4808a((C4545u) t, enumC4763a, z);
                return;
            } else {
                AbstractC4478b.m5041a("drop the message before initialization.");
                return;
            }
        }
        Intent m4792i = m4792i();
        C4766ab m4836a = C4541q.m4836a(this.f18668c, t, enumC4763a, z, str, str2);
        if (c4823r != null) {
            m4836a.m3748a(c4823r);
        }
        byte[] m3471a = C4796aq.m3471a(m4836a);
        if (m3471a == null) {
            AbstractC4478b.m5041a("send message fail, because msgBytes is null.");
            return;
        }
        m4792i.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m4792i.putExtra("mipush_payload", m3471a);
        m4792i.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        m4817a(m4792i);
    }

    /* renamed from: a */
    public final void m4803a(boolean z) {
        m4802a(z, (String) null);
    }

    /* renamed from: a */
    public final void m4802a(boolean z, String str) {
        if (z) {
            C4540p.m4845a(this.f18668c).m4839f("disable_syncing");
        } else {
            C4540p.m4845a(this.f18668c).m4839f("enable_syncing");
        }
        m4810a(str, z);
    }

    /* renamed from: b */
    public final void m4801b() {
        Intent m4792i = m4792i();
        m4792i.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        m4817a(m4792i);
    }

    /* renamed from: b */
    public void m4800b(int i) {
        Intent m4792i = m4792i();
        m4792i.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m4792i.putExtra(AbstractC4618am.f19008y, this.f18668c.getPackageName());
        m4792i.putExtra(AbstractC4618am.f18976A, i);
        m4792i.putExtra(AbstractC4618am.f18978C, C4506c.m4950b(this.f18668c.getPackageName() + i));
        m4817a(m4792i);
    }

    /* renamed from: c */
    public boolean m4798c() {
        return this.f18667a && 1 == C4520a.m4909a(this.f18668c).m4891m();
    }

    /* renamed from: d */
    public void m4797d() {
        if (this.f18671g != null) {
            m4817a(this.f18671g);
            this.f18671g = null;
        }
    }

    /* renamed from: e */
    public void m4796e() {
        synchronized (f18666e) {
            Iterator<C4546a> it2 = f18666e.iterator();
            while (it2.hasNext()) {
                C4546a next = it2.next();
                m4805a(next.f18673a, next.f18674b, next.f18675c, false, null, true);
            }
            f18666e.clear();
        }
    }

    /* renamed from: f */
    public void m4795f() {
        Intent m4792i = m4792i();
        m4792i.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m4792i.putExtra(AbstractC4618am.f19008y, this.f18668c.getPackageName());
        m4792i.putExtra(AbstractC4618am.f18978C, C4506c.m4950b(this.f18668c.getPackageName()));
        m4817a(m4792i);
    }

    /* renamed from: g */
    public boolean m4794g() {
        if (!m4798c() || !m4788m()) {
            return true;
        }
        if (this.f18672h == null) {
            this.f18672h = Integer.valueOf(C4622ao.m4356a(this.f18668c).m4355b());
            if (this.f18672h.intValue() == 0) {
                this.f18668c.getContentResolver().registerContentObserver(C4622ao.m4356a(this.f18668c).m4354c(), false, new C4548w(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f18672h.intValue() != 0;
    }
}
