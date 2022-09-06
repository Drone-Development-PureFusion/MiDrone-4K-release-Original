package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4479a;
import com.xiaomi.channel.commonutils.misc.C4484f;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.string.C4506c;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.log.C4556b;
import com.xiaomi.push.service.C4612ak;
import com.xiaomi.push.service.C4633aw;
import com.xiaomi.push.service.C4663i;
import com.xiaomi.push.service.timers.C4691a;
import com.xiaomi.slim.C4707b;
import com.xiaomi.slim.C4711f;
import com.xiaomi.smack.AbstractC4713a;
import com.xiaomi.smack.AbstractC4717d;
import com.xiaomi.smack.AbstractC4720f;
import com.xiaomi.smack.C4715b;
import com.xiaomi.smack.C4722g;
import com.xiaomi.smack.C4727l;
import com.xiaomi.smack.packet.AbstractC4732d;
import com.xiaomi.smack.packet.C4728a;
import com.xiaomi.smack.packet.C4729b;
import com.xiaomi.smack.packet.C4731c;
import com.xiaomi.smack.packet.C4734f;
import com.xiaomi.smack.util.C4746d;
import com.xiaomi.stats.C4758f;
import com.xiaomi.stats.C4761h;
import com.xiaomi.xmpush.thrift.C4766ab;
import com.xiaomi.xmpush.thrift.C4774af;
import com.xiaomi.xmpush.thrift.C4796aq;
import com.xiaomi.xmpush.thrift.EnumC4763a;
import com.xiaomi.xmpush.thrift.EnumC4803e;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.p248a.p283b.C5389f;
/* loaded from: classes.dex */
public class XMPushService extends Service implements AbstractC4717d {

    /* renamed from: c */
    private C4715b f18890c;

    /* renamed from: d */
    private C4625ar f18891d;

    /* renamed from: e */
    private C4586e f18892e;

    /* renamed from: h */
    private C4711f f18894h;

    /* renamed from: i */
    private AbstractC4713a f18895i;

    /* renamed from: j */
    private C4643b f18896j;

    /* renamed from: g */
    private static final int f18888g = Process.myPid();

    /* renamed from: b */
    public static int f18887b = 1;

    /* renamed from: f */
    private long f18893f = 0;

    /* renamed from: k */
    private PacketSync f18897k = null;

    /* renamed from: l */
    private C4663i f18898l = null;

    /* renamed from: m */
    private AbstractC4720f f18899m = new C4642az(this);

    /* renamed from: a */
    final BroadcastReceiver f18889a = new C4650bg(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$a */
    /* loaded from: classes.dex */
    public class C4582a extends AbstractC4589h {

        /* renamed from: b */
        C4612ak.C4614b f18900b;

        public C4582a(C4612ak.C4614b c4614b) {
            super(9);
            this.f18900b = null;
            this.f18900b = c4614b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            try {
                if (!XMPushService.this.m4457f()) {
                    AbstractC4478b.m5036d("trying bind while the connection is not created, quit!");
                } else {
                    C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(this.f18900b.f18961h, this.f18900b.f18955b);
                    if (m4374b == null) {
                        AbstractC4478b.m5041a("ignore bind because the channel " + this.f18900b.f18961h + " is removed ");
                    } else if (m4374b.f18966m == C4612ak.EnumC4616c.unbind) {
                        m4374b.m4364a(C4612ak.EnumC4616c.binding, 0, 0, null, null);
                        XMPushService.this.f18895i.mo3989a(m4374b);
                        C4761h.m3778a(XMPushService.this, m4374b);
                    } else {
                        AbstractC4478b.m5041a("trying duplicate bind, ingore! " + m4374b.f18966m);
                    }
                }
            } catch (C4727l e) {
                AbstractC4478b.m5039a(e);
                XMPushService.this.m4499a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "bind the client. " + this.f18900b.f18961h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$b */
    /* loaded from: classes.dex */
    public static class C4583b extends AbstractC4589h {

        /* renamed from: b */
        private final C4612ak.C4614b f18902b;

        public C4583b(C4612ak.C4614b c4614b) {
            super(12);
            this.f18902b = c4614b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            this.f18902b.m4364a(C4612ak.EnumC4616c.unbind, 1, 21, null, null);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "bind time out. chid=" + this.f18902b.f18961h;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4583b)) {
                return false;
            }
            return TextUtils.equals(((C4583b) obj).f18902b.f18961h, this.f18902b.f18961h);
        }

        public int hashCode() {
            return this.f18902b.f18961h.hashCode();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$c */
    /* loaded from: classes.dex */
    class C4584c extends AbstractC4589h {

        /* renamed from: c */
        private C4707b f18904c;

        public C4584c(C4707b c4707b) {
            super(8);
            this.f18904c = null;
            this.f18904c = c4707b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            XMPushService.this.f18897k.m4508a(this.f18904c);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "receive a message.";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$d */
    /* loaded from: classes.dex */
    public class C4585d extends AbstractC4589h {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C4585d() {
            super(1);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            if (XMPushService.this.m4473b()) {
                XMPushService.this.m4446o();
            } else {
                AbstractC4478b.m5041a("should not connect. quit the job.");
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "do reconnect..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$e */
    /* loaded from: classes.dex */
    public class C4586e extends BroadcastReceiver {
        C4586e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            XMPushService.this.m4450k();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$f */
    /* loaded from: classes.dex */
    public class C4587f extends AbstractC4589h {

        /* renamed from: b */
        public int f18907b;

        /* renamed from: c */
        public Exception f18908c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4587f(int i, Exception exc) {
            super(2);
            this.f18907b = i;
            this.f18908c = exc;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            XMPushService.this.m4499a(this.f18907b, this.f18908c);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "disconnect the connection.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$g */
    /* loaded from: classes.dex */
    public class C4588g extends AbstractC4589h {

        /* renamed from: c */
        private Intent f18911c;

        public C4588g(Intent intent) {
            super(15);
            this.f18911c = null;
            this.f18911c = intent;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            XMPushService.this.m4465c(this.f18911c);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "Handle intent action = " + this.f18911c.getAction();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$h */
    /* loaded from: classes.dex */
    public static abstract class AbstractC4589h extends C4663i.AbstractRunnableC4665b {
        public AbstractC4589h(int i) {
            super(i);
        }

        /* renamed from: a */
        public abstract void mo3811a();

        /* renamed from: b */
        public abstract String mo3810b();

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19100a != 4 && this.f19100a != 8) {
                AbstractC4478b.m5041a("JOB: " + mo3810b());
            }
            mo3811a();
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$i */
    /* loaded from: classes.dex */
    class C4590i extends AbstractC4589h {
        public C4590i() {
            super(5);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            XMPushService.this.f18898l.m4242b();
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "ask the job queue to quit";
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$j */
    /* loaded from: classes.dex */
    public class BinderC4591j extends Binder {
        public BinderC4591j() {
        }
    }

    /* renamed from: com.xiaomi.push.service.XMPushService$k */
    /* loaded from: classes.dex */
    class C4592k extends AbstractC4589h {

        /* renamed from: c */
        private AbstractC4732d f18915c;

        public C4592k(AbstractC4732d abstractC4732d) {
            super(8);
            this.f18915c = null;
            this.f18915c = abstractC4732d;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            XMPushService.this.f18897k.m4506a(this.f18915c);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "receive a message.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$l */
    /* loaded from: classes.dex */
    public class C4593l extends AbstractC4589h {

        /* renamed from: b */
        boolean f18916b;

        public C4593l(boolean z) {
            super(4);
            this.f18916b = z;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            if (XMPushService.this.m4457f()) {
                try {
                    if (!this.f18916b) {
                        C4761h.m3783a();
                    }
                    XMPushService.this.f18895i.mo3933b(this.f18916b);
                } catch (C4727l e) {
                    AbstractC4478b.m5039a(e);
                    XMPushService.this.m4499a(10, e);
                }
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "send ping..";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$m */
    /* loaded from: classes.dex */
    public class C4594m extends AbstractC4589h {

        /* renamed from: b */
        C4612ak.C4614b f18918b;

        public C4594m(C4612ak.C4614b c4614b) {
            super(4);
            this.f18918b = null;
            this.f18918b = c4614b;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            try {
                this.f18918b.m4364a(C4612ak.EnumC4616c.unbind, 1, 16, null, null);
                XMPushService.this.f18895i.mo3984a(this.f18918b.f18961h, this.f18918b.f18955b);
                this.f18918b.m4364a(C4612ak.EnumC4616c.binding, 1, 16, null, null);
                XMPushService.this.f18895i.mo3989a(this.f18918b);
            } catch (C4727l e) {
                AbstractC4478b.m5039a(e);
                XMPushService.this.m4499a(10, e);
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "rebind the client. " + this.f18918b.f18961h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$n */
    /* loaded from: classes.dex */
    public class C4595n extends AbstractC4589h {
        C4595n() {
            super(3);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            XMPushService.this.m4499a(11, (Exception) null);
            if (XMPushService.this.m4473b()) {
                XMPushService.this.m4446o();
            }
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "reset the connection.";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.XMPushService$o */
    /* loaded from: classes.dex */
    public class C4596o extends AbstractC4589h {

        /* renamed from: b */
        C4612ak.C4614b f18921b;

        /* renamed from: c */
        int f18922c;

        /* renamed from: d */
        String f18923d;

        /* renamed from: e */
        String f18924e;

        public C4596o(C4612ak.C4614b c4614b, int i, String str, String str2) {
            super(9);
            this.f18921b = null;
            this.f18921b = c4614b;
            this.f18922c = i;
            this.f18923d = str;
            this.f18924e = str2;
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: a */
        public void mo3811a() {
            if (this.f18921b.f18966m != C4612ak.EnumC4616c.unbind && XMPushService.this.f18895i != null) {
                try {
                    XMPushService.this.f18895i.mo3984a(this.f18921b.f18961h, this.f18921b.f18955b);
                } catch (C4727l e) {
                    AbstractC4478b.m5039a(e);
                    XMPushService.this.m4499a(10, e);
                }
            }
            this.f18921b.m4364a(C4612ak.EnumC4616c.unbind, this.f18922c, 0, this.f18924e, this.f18923d);
        }

        @Override // com.xiaomi.push.service.XMPushService.AbstractC4589h
        /* renamed from: b */
        public String mo3810b() {
            return "unbind the channel. " + this.f18921b.f18961h;
        }
    }

    static {
        HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
        HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2:443");
        HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
    }

    @TargetApi(11)
    /* renamed from: a */
    public static Notification m4496a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (Build.VERSION.SDK_INT < 11) {
            Notification notification = new Notification();
            notification.setLatestEventInfo(context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
            return notification;
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(context.getApplicationInfo().icon);
        builder.setContentTitle("Push Service");
        builder.setContentText("Push Service");
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
        return builder.getNotification();
    }

    /* renamed from: a */
    private C4731c m4485a(C4731c c4731c, String str) {
        byte[] m4350a = C4624aq.m4350a(str, c4731c.k());
        C4731c c4731c2 = new C4731c();
        c4731c2.n(c4731c.n());
        c4731c2.m(c4731c.m());
        c4731c2.k(c4731c.k());
        c4731c2.l(c4731c.l());
        c4731c2.m3905b(true);
        String m4347a = C4624aq.m4347a(m4350a, C4746d.m3834c(c4731c.mo3862c()));
        C4728a c4728a = new C4728a("s", null, null, null);
        c4728a.m3918b(m4347a);
        c4731c2.a(c4728a);
        return c4731c2;
    }

    /* renamed from: a */
    private AbstractC4732d m4483a(AbstractC4732d abstractC4732d, String str, String str2, boolean z) {
        C4612ak m4383a = C4612ak.m4383a();
        List<String> m4375b = m4383a.m4375b(str);
        if (m4375b.isEmpty()) {
            AbstractC4478b.m5041a("open channel should be called first before sending a packet, pkg=" + str);
        } else {
            abstractC4732d.m3877o(str);
            String m3884l = abstractC4732d.m3884l();
            if (TextUtils.isEmpty(m3884l)) {
                m3884l = m4375b.get(0);
                abstractC4732d.m3883l(m3884l);
            }
            C4612ak.C4614b m4374b = m4383a.m4374b(m3884l, abstractC4732d.m3880n());
            if (!m4457f()) {
                AbstractC4478b.m5041a("drop a packet as the channel is not connected, chid=" + m3884l);
            } else if (m4374b == null || m4374b.f18966m != C4612ak.EnumC4616c.binded) {
                AbstractC4478b.m5041a("drop a packet as the channel is not opened, chid=" + m3884l);
            } else if (TextUtils.equals(str2, m4374b.f18963j)) {
                return (!(abstractC4732d instanceof C4731c) || !z) ? abstractC4732d : m4485a((C4731c) abstractC4732d, m4374b.f18962i);
            } else {
                AbstractC4478b.m5041a("invalid session. " + str2);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m4495a(Intent intent) {
        AbstractC4713a m4453h;
        String stringExtra = intent.getStringExtra(AbstractC4618am.f19008y);
        String stringExtra2 = intent.getStringExtra(AbstractC4618am.f18977B);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
        C4731c c4731c = (C4731c) m4483a((AbstractC4732d) new C4731c(bundleExtra), stringExtra, stringExtra2, false);
        if (c4731c == null) {
            return;
        }
        C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(c4731c.l(), c4731c.n());
        if (booleanExtra && "3".equals(c4731c.l()) && (m4453h = m4453h()) != null && m4453h.mo3993a()) {
            m4464c(new C4626as(this, C4707b.m4032a(c4731c, m4374b.f18962i)));
            return;
        }
        if (booleanExtra) {
            c4731c = m4485a(c4731c, m4374b.f18962i);
        }
        if (c4731c == null) {
            return;
        }
        m4464c(new C4626as(this, c4731c));
    }

    /* renamed from: a */
    private void m4482a(String str, int i) {
        Collection<C4612ak.C4614b> m4372c = C4612ak.m4383a().m4372c(str);
        if (m4372c != null) {
            for (C4612ak.C4614b c4614b : m4372c) {
                if (c4614b != null) {
                    m4494a(new C4596o(c4614b, i, null, null));
                }
            }
        }
        C4612ak.m4383a().m4378a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4478a(String str, byte[] bArr, boolean z) {
        Collection<C4612ak.C4614b> m4372c = C4612ak.m4383a().m4372c("5");
        if (m4372c.isEmpty()) {
            if (!z) {
                return;
            }
            C4687r.m4115b(str, bArr);
        } else if (m4372c.iterator().next().f18966m == C4612ak.EnumC4616c.binded) {
            m4464c(new C4656bm(this, 4, str, bArr));
        } else if (!z) {
        } else {
            C4687r.m4115b(str, bArr);
        }
    }

    /* renamed from: a */
    public static boolean m4498a(int i, String str) {
        if (!TextUtils.equals(str, "Enter") || i != 1) {
            return TextUtils.equals(str, "Leave") && i == 2;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m4481a(String str, Intent intent) {
        C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(str, intent.getStringExtra(AbstractC4618am.f18999p));
        boolean z = false;
        if (m4374b == null || str == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(AbstractC4618am.f18977B);
        String stringExtra2 = intent.getStringExtra(AbstractC4618am.f19004u);
        if (!TextUtils.isEmpty(m4374b.f18963j) && !TextUtils.equals(stringExtra, m4374b.f18963j)) {
            AbstractC4478b.m5041a("session changed. old session=" + m4374b.f18963j + ", new session=" + stringExtra + " chid = " + str);
            z = true;
        }
        if (stringExtra2.equals(m4374b.f18962i)) {
            return z;
        }
        AbstractC4478b.m5041a("security changed. chid = " + str + " sechash = " + C4506c.m4951a(stringExtra2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4479a(String str, String str2, Context context) {
        if (!TextUtils.equals("Leave", str) || TextUtils.equals("Enter", C4659e.m4274a(context).m4264c(str2))) {
            if (C4659e.m4274a(context).m4269a(str2, str) != 0) {
                return true;
            }
            AbstractC4478b.m5041a("update geofence statue failed geo_id:" + str2);
            return false;
        }
        return false;
    }

    /* renamed from: b */
    private C4612ak.C4614b m4468b(String str, Intent intent) {
        C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(str, intent.getStringExtra(AbstractC4618am.f18999p));
        if (m4374b == null) {
            m4374b = new C4612ak.C4614b(this);
        }
        m4374b.f18961h = intent.getStringExtra(AbstractC4618am.f19000q);
        m4374b.f18955b = intent.getStringExtra(AbstractC4618am.f18999p);
        m4374b.f18956c = intent.getStringExtra(AbstractC4618am.f19002s);
        m4374b.f18954a = intent.getStringExtra(AbstractC4618am.f19008y);
        m4374b.f18959f = intent.getStringExtra(AbstractC4618am.f19006w);
        m4374b.f18960g = intent.getStringExtra(AbstractC4618am.f19007x);
        m4374b.f18958e = intent.getBooleanExtra(AbstractC4618am.f19005v, false);
        m4374b.f18962i = intent.getStringExtra(AbstractC4618am.f19004u);
        m4374b.f18963j = intent.getStringExtra(AbstractC4618am.f18977B);
        m4374b.f18957d = intent.getStringExtra(AbstractC4618am.f19003t);
        m4374b.f18964k = this.f18896j;
        m4374b.f18965l = getApplicationContext();
        C4612ak.m4383a().m4379a(m4374b);
        return m4374b;
    }

    /* renamed from: b */
    private void m4471b(Intent intent) {
        AbstractC4713a m4453h;
        int i = 0;
        String stringExtra = intent.getStringExtra(AbstractC4618am.f19008y);
        String stringExtra2 = intent.getStringExtra(AbstractC4618am.f18977B);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        C4731c[] c4731cArr = new C4731c[parcelableArrayExtra.length];
        boolean booleanExtra = intent.getBooleanExtra("ext_encrypt", true);
        for (int i2 = 0; i2 < parcelableArrayExtra.length; i2++) {
            c4731cArr[i2] = new C4731c((Bundle) parcelableArrayExtra[i2]);
            c4731cArr[i2] = (C4731c) m4483a((AbstractC4732d) c4731cArr[i2], stringExtra, stringExtra2, false);
            if (c4731cArr[i2] == null) {
                return;
            }
        }
        C4612ak m4383a = C4612ak.m4383a();
        if (!booleanExtra || !"3".equals(c4731cArr[0].l()) || (m4453h = m4453h()) == null || !m4453h.mo3993a()) {
            while (i < c4731cArr.length) {
                c4731cArr[i] = booleanExtra ? m4485a(c4731cArr[i], m4383a.m4374b(c4731cArr[i].l(), c4731cArr[i].n()).f18962i) : c4731cArr[i];
                i++;
            }
            m4464c(new C4597a(this, c4731cArr));
            return;
        }
        C4707b[] c4707bArr = new C4707b[c4731cArr.length];
        while (i < c4731cArr.length) {
            C4731c c4731c = c4731cArr[i];
            c4707bArr[i] = C4707b.m4032a(c4731c, m4383a.m4374b(c4731c.l(), c4731c.n()).f18962i);
            i++;
        }
        m4464c(new C4597a(this, c4707bArr));
    }

    /* renamed from: b */
    private void m4467b(boolean z) {
        this.f18893f = System.currentTimeMillis();
        if (this.f18898l.m4238d()) {
            AbstractC4478b.m5036d("ERROR, the job controller is blocked.");
            C4612ak.m4383a().m4381a(this, 14);
            stopSelf();
        } else if (!m4457f()) {
            m4477a(true);
        } else if (this.f18895i.m3968o() || C4497d.m4983f(this)) {
            m4494a(new C4593l(z));
        } else {
            m4494a(new C4587f(17, null));
            m4477a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m4465c(Intent intent) {
        String m4950b;
        int i;
        C4612ak.C4614b c4614b = null;
        boolean z = true;
        boolean z2 = false;
        C4612ak m4383a = C4612ak.m4383a();
        if (AbstractC4618am.f18987d.equalsIgnoreCase(intent.getAction()) || AbstractC4618am.f18993j.equalsIgnoreCase(intent.getAction())) {
            String stringExtra = intent.getStringExtra(AbstractC4618am.f19000q);
            if (TextUtils.isEmpty(intent.getStringExtra(AbstractC4618am.f19004u))) {
                AbstractC4478b.m5041a("security is empty. ignore.");
            } else if (stringExtra == null) {
                AbstractC4478b.m5036d("channel id is empty, do nothing!");
            } else {
                boolean m4481a = m4481a(stringExtra, intent);
                C4612ak.C4614b m4468b = m4468b(stringExtra, intent);
                if (!C4497d.m4985d(this)) {
                    this.f18896j.m4290a(this, m4468b, false, 2, null);
                } else if (!m4457f()) {
                    m4477a(true);
                } else if (m4468b.f18966m == C4612ak.EnumC4616c.unbind) {
                    m4464c(new C4582a(m4468b));
                } else if (m4481a) {
                    m4464c(new C4594m(m4468b));
                } else if (m4468b.f18966m == C4612ak.EnumC4616c.binding) {
                    AbstractC4478b.m5041a(String.format("the client is binding. %1$s %2$s.", m4468b.f18961h, m4468b.f18955b));
                } else if (m4468b.f18966m == C4612ak.EnumC4616c.binded) {
                    this.f18896j.m4290a(this, m4468b, true, 0, null);
                }
            }
        } else if (AbstractC4618am.f18992i.equalsIgnoreCase(intent.getAction())) {
            String stringExtra2 = intent.getStringExtra(AbstractC4618am.f19008y);
            String stringExtra3 = intent.getStringExtra(AbstractC4618am.f19000q);
            String stringExtra4 = intent.getStringExtra(AbstractC4618am.f18999p);
            AbstractC4478b.m5041a("Service called closechannel chid = " + stringExtra3 + " userId = " + stringExtra4);
            if (TextUtils.isEmpty(stringExtra3)) {
                for (String str : m4383a.m4375b(stringExtra2)) {
                    m4482a(str, 2);
                }
            } else if (TextUtils.isEmpty(stringExtra4)) {
                m4482a(stringExtra3, 2);
            } else {
                m4480a(stringExtra3, stringExtra4, 2, null, null);
            }
        } else if (AbstractC4618am.f18988e.equalsIgnoreCase(intent.getAction())) {
            m4495a(intent);
        } else if (AbstractC4618am.f18990g.equalsIgnoreCase(intent.getAction())) {
            m4471b(intent);
        } else if (AbstractC4618am.f18989f.equalsIgnoreCase(intent.getAction())) {
            String stringExtra5 = intent.getStringExtra(AbstractC4618am.f19008y);
            String stringExtra6 = intent.getStringExtra(AbstractC4618am.f18977B);
            C4729b c4729b = new C4729b(intent.getBundleExtra("ext_packet"));
            if (m4483a((AbstractC4732d) c4729b, stringExtra5, stringExtra6, false) == null) {
                return;
            }
            m4464c(new C4626as(this, c4729b));
        } else if (AbstractC4618am.f18991h.equalsIgnoreCase(intent.getAction())) {
            String stringExtra7 = intent.getStringExtra(AbstractC4618am.f19008y);
            String stringExtra8 = intent.getStringExtra(AbstractC4618am.f18977B);
            C4734f c4734f = new C4734f(intent.getBundleExtra("ext_packet"));
            if (m4483a((AbstractC4732d) c4734f, stringExtra7, stringExtra8, false) == null) {
                return;
            }
            m4464c(new C4626as(this, c4734f));
        } else if (AbstractC4618am.f18994k.equals(intent.getAction())) {
            String stringExtra9 = intent.getStringExtra(AbstractC4618am.f19000q);
            String stringExtra10 = intent.getStringExtra(AbstractC4618am.f18999p);
            if (stringExtra9 == null) {
                return;
            }
            AbstractC4478b.m5041a("request reset connection from chid = " + stringExtra9);
            C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(stringExtra9, stringExtra10);
            if (m4374b == null || !m4374b.f18962i.equals(intent.getStringExtra(AbstractC4618am.f19004u)) || m4374b.f18966m != C4612ak.EnumC4616c.binded) {
                return;
            }
            AbstractC4713a m4453h = m4453h();
            if (m4453h != null && m4453h.m3990a(System.currentTimeMillis() - 15000)) {
                return;
            }
            m4464c(new C4595n());
        } else if (AbstractC4618am.f18995l.equals(intent.getAction())) {
            String stringExtra11 = intent.getStringExtra(AbstractC4618am.f19008y);
            List<String> m4375b = m4383a.m4375b(stringExtra11);
            if (m4375b.isEmpty()) {
                AbstractC4478b.m5041a("open channel should be called first before update info, pkg=" + stringExtra11);
                return;
            }
            String stringExtra12 = intent.getStringExtra(AbstractC4618am.f19000q);
            String stringExtra13 = intent.getStringExtra(AbstractC4618am.f18999p);
            if (TextUtils.isEmpty(stringExtra12)) {
                stringExtra12 = m4375b.get(0);
            }
            if (TextUtils.isEmpty(stringExtra13)) {
                Collection<C4612ak.C4614b> m4372c = m4383a.m4372c(stringExtra12);
                if (m4372c != null && !m4372c.isEmpty()) {
                    c4614b = m4372c.iterator().next();
                }
            } else {
                c4614b = m4383a.m4374b(stringExtra12, stringExtra13);
            }
            if (c4614b == null) {
                return;
            }
            if (intent.hasExtra(AbstractC4618am.f19006w)) {
                c4614b.f18959f = intent.getStringExtra(AbstractC4618am.f19006w);
            }
            if (!intent.hasExtra(AbstractC4618am.f19007x)) {
                return;
            }
            c4614b.f18960g = intent.getStringExtra(AbstractC4618am.f19007x);
        } else if ("com.xiaomi.mipush.REGISTER_APP".equals(intent.getAction())) {
            if (C4622ao.m4356a(getApplicationContext()).m4357a() && C4622ao.m4356a(getApplicationContext()).m4355b() == 0) {
                AbstractC4478b.m5041a("register without being provisioned. " + intent.getStringExtra("mipush_app_package"));
                return;
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            String stringExtra14 = intent.getStringExtra("mipush_app_package");
            boolean booleanExtra = intent.getBooleanExtra("mipush_env_chanage", false);
            int intExtra = intent.getIntExtra("mipush_env_type", 1);
            C4685p.m4130a(this).m4123g(stringExtra14);
            if (!booleanExtra || "com.xiaomi.xmsf".equals(getPackageName())) {
                m4476a(byteArrayExtra, stringExtra14);
            } else {
                m4464c(new C4654bk(this, 14, intExtra, byteArrayExtra, stringExtra14));
            }
        } else if ("com.xiaomi.mipush.SEND_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
            String stringExtra15 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra2 = intent.getBooleanExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
            if ("com.xiaomi.mipush.UNREGISTER_APP".equals(intent.getAction())) {
                C4685p.m4130a(this).m4126d(stringExtra15);
            }
            m4478a(stringExtra15, byteArrayExtra2, booleanExtra2);
        } else if (AbstractC4623ap.f19015a.equals(intent.getAction())) {
            String stringExtra16 = intent.getStringExtra("uninstall_pkg_name");
            if (stringExtra16 == null || TextUtils.isEmpty(stringExtra16.trim())) {
                return;
            }
            try {
                getPackageManager().getPackageInfo(stringExtra16, 8192);
                z = false;
            } catch (PackageManager.NameNotFoundException e) {
            }
            if ("com.xiaomi.channel".equals(stringExtra16) && !C4612ak.m4383a().m4372c("1").isEmpty() && z) {
                m4482a("1", 0);
                AbstractC4478b.m5041a("close the miliao channel as the app is uninstalled.");
                return;
            }
            SharedPreferences sharedPreferences = getSharedPreferences("pref_registered_pkg_names", 0);
            String string = sharedPreferences.getString(stringExtra16, null);
            if (TextUtils.isEmpty(string) || !z) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(stringExtra16);
            edit.commit();
            if (C4600ac.m4411e(this, stringExtra16)) {
                C4600ac.m4412d(this, stringExtra16);
            }
            C4600ac.m4416b(this, stringExtra16);
            if (!m4457f() || string == null) {
                return;
            }
            try {
                C4598aa.m4440a(this, C4598aa.m4436a(stringExtra16, string));
                AbstractC4478b.m5041a("uninstall " + stringExtra16 + " msg sent");
            } catch (C4727l e2) {
                AbstractC4478b.m5036d("Fail to send Message: " + e2.getMessage());
                m4499a(10, e2);
            }
        } else if ("com.xiaomi.mipush.CLEAR_NOTIFICATION".equals(intent.getAction())) {
            String stringExtra17 = intent.getStringExtra(AbstractC4618am.f19008y);
            int intExtra2 = intent.getIntExtra(AbstractC4618am.f19009z, -2);
            if (TextUtils.isEmpty(stringExtra17)) {
                return;
            }
            if (intExtra2 >= -1) {
                C4600ac.m4425a(this, stringExtra17, intExtra2);
            } else {
                C4600ac.m4423a(this, stringExtra17, intent.getStringExtra(AbstractC4618am.f18979D), intent.getStringExtra(AbstractC4618am.f18980E));
            }
        } else if ("com.xiaomi.mipush.SET_NOTIFICATION_TYPE".equals(intent.getAction())) {
            String stringExtra18 = intent.getStringExtra(AbstractC4618am.f19008y);
            String stringExtra19 = intent.getStringExtra(AbstractC4618am.f18978C);
            if (intent.hasExtra(AbstractC4618am.f18976A)) {
                i = intent.getIntExtra(AbstractC4618am.f18976A, 0);
                m4950b = C4506c.m4950b(stringExtra18 + i);
            } else {
                m4950b = C4506c.m4950b(stringExtra18);
                i = 0;
                z2 = true;
            }
            if (TextUtils.isEmpty(stringExtra18) || !TextUtils.equals(stringExtra19, m4950b)) {
                AbstractC4478b.m5036d("invalid notification for " + stringExtra18);
            } else if (z2) {
                C4600ac.m4412d(this, stringExtra18);
            } else {
                C4600ac.m4415b(this, stringExtra18, i);
            }
        } else if ("com.xiaomi.mipush.DISABLE_PUSH".equals(intent.getAction())) {
            String stringExtra20 = intent.getStringExtra("mipush_app_package");
            if (!TextUtils.isEmpty(stringExtra20)) {
                C4685p.m4130a(this).m4125e(stringExtra20);
            }
            if ("com.xiaomi.xmsf".equals(getPackageName())) {
                return;
            }
            if (this.f18892e != null) {
                unregisterReceiver(this.f18892e);
                this.f18892e = null;
            }
            this.f18898l.m4239c();
            m4494a(new C4655bl(this, 2));
            C4612ak.m4383a().m4369e();
            C4612ak.m4383a().m4381a(this, 0);
            C4612ak.m4383a().m4371d();
            C4627at.m4340a().m4334b();
            C4691a.m4087a();
        } else if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction()) || "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
            String stringExtra21 = intent.getStringExtra("mipush_app_package");
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            String stringExtra22 = intent.getStringExtra("mipush_app_id");
            String stringExtra23 = intent.getStringExtra("mipush_app_token");
            if ("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                C4685p.m4130a(this).m4124f(stringExtra21);
            }
            if ("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction())) {
                C4685p.m4130a(this).m4122h(stringExtra21);
                C4685p.m4130a(this).m4121i(stringExtra21);
            }
            if (byteArrayExtra3 == null) {
                C4687r.m4119a(this, stringExtra21, byteArrayExtra3, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
                return;
            }
            C4687r.m4115b(stringExtra21, byteArrayExtra3);
            m4494a(new C4686q(this, stringExtra21, stringExtra22, stringExtra23, byteArrayExtra3));
            if (!"com.xiaomi.mipush.ENABLE_PUSH_MESSAGE".equals(intent.getAction()) || this.f18892e != null) {
                return;
            }
            this.f18892e = new C4586e();
            registerReceiver(this.f18892e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* renamed from: c */
    private void m4464c(AbstractC4589h abstractC4589h) {
        this.f18898l.m4244a(abstractC4589h);
    }

    /* renamed from: c */
    private void m4462c(boolean z) {
        try {
            if (C4473j.m5062d()) {
                if (z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                } else {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
                }
            }
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
        }
    }

    /* renamed from: j */
    private C4633aw.AbstractC4635b m4451j() {
        return new C4652bi(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m4450k() {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
            networkInfo = null;
        }
        if (networkInfo != null) {
            AbstractC4478b.m5041a("network changed, " + networkInfo.toString());
        } else {
            AbstractC4478b.m5041a("network changed, no active network");
        }
        if (C4758f.m3791b() != null) {
            C4758f.m3791b().m3800b();
        }
        this.f18894h.p();
        if (C4497d.m4985d(this)) {
            if (m4457f() && m4449l()) {
                m4467b(false);
            }
            if (!m4457f() && !m4455g()) {
                this.f18898l.m4241b(1);
                m4494a(new C4585d());
            }
            C4556b.m4723a(this).m4725a();
        } else {
            m4494a(new C4587f(2, null));
        }
        m4447n();
    }

    /* renamed from: l */
    private boolean m4449l() {
        if (System.currentTimeMillis() - this.f18893f < 30000) {
            return false;
        }
        return C4497d.m4984e(this);
    }

    /* renamed from: m */
    private boolean m4448m() {
        return "com.xiaomi.xmsf".equals(getPackageName()) || !C4685p.m4130a(this).m4128b(getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m4447n() {
        if (!m4473b()) {
            C4691a.m4087a();
        } else if (C4691a.m4084b()) {
        } else {
            C4691a.m4085a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m4446o() {
        if (this.f18895i != null && this.f18895i.m3973j()) {
            AbstractC4478b.m5036d("try to connect while connecting.");
        } else if (this.f18895i != null && this.f18895i.m3972k()) {
            AbstractC4478b.m5036d("try to connect while is connected.");
        } else {
            this.f18890c.m3963a(C4497d.m4978k(this));
            m4445p();
            if (this.f18895i != null) {
                return;
            }
            C4612ak.m4383a().m4382a(this);
            m4462c(false);
        }
    }

    /* renamed from: p */
    private void m4445p() {
        try {
            this.f18894h.a(this.f18899m, new C4645bb(this));
            this.f18894h.r();
            this.f18895i = this.f18894h;
        } catch (C4727l e) {
            AbstractC4478b.m5040a("fail to create Slim connection", e);
            this.f18894h.b(3, e);
        }
    }

    /* renamed from: q */
    private boolean m4444q() {
        if (TextUtils.equals(getPackageName(), "com.xiaomi.xmsf")) {
            return false;
        }
        return C4609ah.m4394a(this).m4395a(EnumC4803e.ForegroundServiceSwitch.m3437a(), false);
    }

    /* renamed from: r */
    private void m4443r() {
        if (Build.VERSION.SDK_INT < 18) {
            startForeground(f18888g, new Notification());
        } else {
            bindService(new Intent(this, XMJobService.class), new ServiceConnectionC4646bc(this), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4501a() {
        if (System.currentTimeMillis() - this.f18893f >= C4722g.m3946c() && C4497d.m4984e(this)) {
            m4467b(true);
        }
    }

    /* renamed from: a */
    public void m4500a(int i) {
        this.f18898l.m4241b(i);
    }

    /* renamed from: a */
    public void m4499a(int i, Exception exc) {
        AbstractC4478b.m5041a("disconnect " + hashCode() + ", " + (this.f18895i == null ? null : Integer.valueOf(this.f18895i.hashCode())));
        if (this.f18895i != null) {
            this.f18895i.mo3935b(i, exc);
            this.f18895i = null;
        }
        m4500a(7);
        m4500a(4);
        C4612ak.m4383a().m4381a(this, i);
    }

    /* renamed from: a */
    public void m4497a(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.metok.geofencing.state_change");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    /* renamed from: a */
    public void m4494a(AbstractC4589h abstractC4589h) {
        m4493a(abstractC4589h, 0L);
    }

    /* renamed from: a */
    public void m4493a(AbstractC4589h abstractC4589h, long j) {
        try {
            this.f18898l.m4243a(abstractC4589h, j);
        } catch (IllegalStateException e) {
        }
    }

    /* renamed from: a */
    public void m4487a(C4612ak.C4614b c4614b) {
        if (c4614b != null) {
            long m4368a = c4614b.m4368a();
            AbstractC4478b.m5041a("schedule rebind job in " + (m4368a / 1000));
            m4493a(new C4582a(c4614b), m4368a);
        }
    }

    /* renamed from: a */
    public void m4486a(C4707b c4707b) {
        if (this.f18895i != null) {
            this.f18895i.mo3982b(c4707b);
            return;
        }
        throw new C4727l("try send msg while connection is null.");
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3803a(AbstractC4713a abstractC4713a) {
        C4758f.m3791b().mo3803a(abstractC4713a);
        m4462c(true);
        this.f18891d.m4343a();
        Iterator<C4612ak.C4614b> it2 = C4612ak.m4383a().m4376b().iterator();
        while (it2.hasNext()) {
            m4494a(new C4582a(it2.next()));
        }
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3802a(AbstractC4713a abstractC4713a, int i, Exception exc) {
        C4758f.m3791b().mo3802a(abstractC4713a, i, exc);
        m4477a(false);
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: a */
    public void mo3801a(AbstractC4713a abstractC4713a, Exception exc) {
        C4758f.m3791b().mo3801a(abstractC4713a, exc);
        m4462c(false);
        m4477a(false);
    }

    /* renamed from: a */
    public void m4484a(AbstractC4732d abstractC4732d) {
        if (this.f18895i != null) {
            this.f18895i.mo3986a(abstractC4732d);
            return;
        }
        throw new C4727l("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void m4480a(String str, String str2, int i, String str3, String str4) {
        C4612ak.C4614b m4374b = C4612ak.m4383a().m4374b(str, str2);
        if (m4374b != null) {
            m4494a(new C4596o(m4374b, i, str4, str3));
        }
        C4612ak.m4383a().m4377a(str, str2);
    }

    /* renamed from: a */
    public void m4477a(boolean z) {
        this.f18891d.m4342a(z);
    }

    /* renamed from: a */
    public void m4476a(byte[] bArr, String str) {
        if (bArr == null) {
            C4687r.m4119a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            AbstractC4478b.m5041a("register request without payload");
            return;
        }
        C4766ab c4766ab = new C4766ab();
        try {
            C4796aq.m3470a(c4766ab, bArr);
            if (c4766ab.f19624a == EnumC4763a.Registration) {
                C4774af c4774af = new C4774af();
                try {
                    C4796aq.m3470a(c4774af, c4766ab.m3734f());
                    C4687r.m4117a(c4766ab.m3730j(), bArr);
                    m4494a(new C4686q(this, c4766ab.m3730j(), c4774af.m3665d(), c4774af.m3656h(), bArr));
                } catch (C5389f e) {
                    AbstractC4478b.m5039a(e);
                    C4687r.m4119a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                }
            } else {
                C4687r.m4119a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
                AbstractC4478b.m5041a("register request with invalid payload");
            }
        } catch (C5389f e2) {
            AbstractC4478b.m5039a(e2);
            C4687r.m4119a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    /* renamed from: a */
    public void m4475a(C4707b[] c4707bArr) {
        if (this.f18895i != null) {
            this.f18895i.mo3938a(c4707bArr);
            return;
        }
        throw new C4727l("try send msg while connection is null.");
    }

    /* renamed from: a */
    public void m4474a(AbstractC4732d[] abstractC4732dArr) {
        if (this.f18895i != null) {
            this.f18895i.mo3937a(abstractC4732dArr);
            return;
        }
        throw new C4727l("try send msg while connection is null.");
    }

    /* renamed from: b */
    public void m4470b(AbstractC4589h abstractC4589h) {
        this.f18898l.m4245a(abstractC4589h.f19100a, abstractC4589h);
    }

    @Override // com.xiaomi.smack.AbstractC4717d
    /* renamed from: b */
    public void mo3799b(AbstractC4713a abstractC4713a) {
        AbstractC4478b.m5037c("begin to connect...");
        C4758f.m3791b().mo3799b(abstractC4713a);
    }

    /* renamed from: b */
    public boolean m4473b() {
        return C4497d.m4985d(this) && C4612ak.m4383a().m4373c() > 0 && !m4466c() && m4448m();
    }

    /* renamed from: b */
    public boolean m4472b(int i) {
        return this.f18898l.m4246a(i);
    }

    /* renamed from: c */
    public boolean m4466c() {
        try {
            Class<?> cls = Class.forName("miui.os.Build");
            Field field = cls.getField("IS_CM_CUSTOMIZATION_TEST");
            Field field2 = cls.getField("IS_CU_CUSTOMIZATION_TEST");
            Field field3 = cls.getField("IS_CT_CUSTOMIZATION_TEST");
            if (!field.getBoolean(null) && !field2.getBoolean(null)) {
                if (!field3.getBoolean(null)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: d */
    public C4643b m4461d() {
        return new C4643b();
    }

    /* renamed from: e */
    public C4643b m4459e() {
        return this.f18896j;
    }

    /* renamed from: f */
    public boolean m4457f() {
        return this.f18895i != null && this.f18895i.m3972k();
    }

    /* renamed from: g */
    public boolean m4455g() {
        return this.f18895i != null && this.f18895i.m3973j();
    }

    /* renamed from: h */
    public AbstractC4713a m4453h() {
        return this.f18895i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new BinderC4591j();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C4473j.m5066a(this);
        C4682n m4137a = C4683o.m4137a(this);
        if (m4137a != null) {
            C4479a.m5033a(m4137a.f19170g);
        }
        C4619an.m4359a(this);
        this.f18890c = new C4647bd(this, null, 5222, "xiaomi.com", null);
        this.f18890c.m3961a(true);
        this.f18894h = new C4711f(this, this.f18890c);
        this.f18896j = m4461d();
        try {
            if (C4473j.m5062d()) {
                this.f18896j.m4294a(this);
            }
        } catch (Exception e) {
            AbstractC4478b.m5039a(e);
        }
        C4691a.m4086a(this);
        this.f18894h.a(this);
        this.f18897k = new PacketSync(this);
        this.f18891d = new C4625ar(this);
        new C4657c().m4279a();
        C4758f.m3796a().m3793a(this);
        this.f18898l = new C4663i("Connection Controller Thread");
        if (m4448m()) {
            m4494a(new C4648be(this, 11));
        }
        C4612ak m4383a = C4612ak.m4383a();
        m4383a.m4369e();
        m4383a.m4380a(new C4649bf(this));
        if (m4448m()) {
            this.f18892e = new C4586e();
            registerReceiver(this.f18892e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (m4444q()) {
            m4443r();
        }
        if (!getPackageName().equals(C4464b.m5096c(this))) {
            C4633aw m4319a = C4633aw.m4319a();
            if (m4319a.m4308b()) {
                m4319a.m4316a(this);
            }
            m4319a.m4314a(m4451j(), "UPLOADER_FROM_XMPUSHSERVICE");
        }
        m4497a(this.f18889a);
        C4484f.m5025a(this).m5023a((C4484f.AbstractRunnableC4485a) new C4658d(this), 86400);
        AbstractC4478b.m5041a("XMPushService created pid = " + f18888g);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.f18892e != null) {
            unregisterReceiver(this.f18892e);
        }
        unregisterReceiver(this.f18889a);
        this.f18898l.m4239c();
        m4494a(new C4644ba(this, 2));
        m4494a(new C4590i());
        C4612ak.m4383a().m4369e();
        C4612ak.m4383a().m4381a(this, 15);
        C4612ak.m4383a().m4371d();
        this.f18894h.b(this);
        C4627at.m4340a().m4334b();
        C4691a.m4087a();
        super.onDestroy();
        AbstractC4478b.m5041a("Service destroyed");
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        if (intent == null) {
            AbstractC4478b.m5036d("onStart() with intent NULL");
        } else {
            AbstractC4478b.m5037c(String.format("onStart() with intent.Action = %s, chid = %s", intent.getAction(), intent.getStringExtra(AbstractC4618am.f19000q)));
        }
        if (intent == null || intent.getAction() == null) {
            return;
        }
        if ("com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
            AbstractC4478b.m5041a("Service called on timer");
            if (!m4449l()) {
                return;
            }
            m4467b(false);
        } else if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
            if ("com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                return;
            }
            m4494a(new C4588g(intent));
        } else {
            AbstractC4478b.m5041a("Service called on check alive.");
            if (!m4449l()) {
                return;
            }
            m4467b(false);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return f18887b;
    }
}
