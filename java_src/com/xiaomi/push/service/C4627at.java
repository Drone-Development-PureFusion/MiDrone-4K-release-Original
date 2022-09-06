package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.google.p217a.p218a.C3991b;
import com.google.p217a.p218a.C3992c;
import com.xiaomi.channel.commonutils.android.C4473j;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4488h;
import com.xiaomi.push.protobuf.C4565a;
import com.xiaomi.push.protobuf.C4567b;
import com.xiaomi.smack.util.C4747e;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
/* renamed from: com.xiaomi.push.service.at */
/* loaded from: classes.dex */
public class C4627at {

    /* renamed from: a */
    private static String f19029a;

    /* renamed from: e */
    private static C4627at f19030e = new C4627at();

    /* renamed from: b */
    private List<AbstractC4628a> f19031b = new ArrayList();

    /* renamed from: c */
    private C4565a.C4566a f19032c;

    /* renamed from: d */
    private C4488h.AbstractC4490b f19033d;

    /* renamed from: com.xiaomi.push.service.at$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC4628a {
        /* renamed from: a */
        public void mo4324a(C4565a.C4566a c4566a) {
        }

        /* renamed from: a */
        public void mo3784a(C4567b.C4569b c4569b) {
        }
    }

    private C4627at() {
    }

    /* renamed from: a */
    public static C4627at m4340a() {
        return f19030e;
    }

    /* renamed from: e */
    public static synchronized String m4329e() {
        String str;
        synchronized (C4627at.class) {
            if (f19029a == null) {
                SharedPreferences sharedPreferences = C4473j.m5067a().getSharedPreferences("XMPushServiceConfig", 0);
                f19029a = sharedPreferences.getString("DeviceUUID", null);
                if (f19029a == null) {
                    f19029a = C4473j.m5065b();
                    if (f19029a != null) {
                        sharedPreferences.edit().putString("DeviceUUID", f19029a).commit();
                    }
                }
            }
            str = f19029a;
        }
        return str;
    }

    /* renamed from: f */
    private void m4328f() {
        if (this.f19032c == null) {
            m4326h();
        }
    }

    /* renamed from: g */
    private void m4327g() {
        if (this.f19033d != null) {
            return;
        }
        this.f19033d = new C4629au(this);
        C4747e.m3833a(this.f19033d);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m4326h() {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(C4473j.m5067a().openFileInput("XMCloudCfg"));
                try {
                    this.f19032c = C4565a.C4566a.m4700c(C3991b.m6302a(bufferedInputStream));
                    bufferedInputStream.close();
                    C4474a.m5059a(bufferedInputStream);
                } catch (Exception e) {
                    e = e;
                    AbstractC4478b.m5041a("load config failure: " + e.getMessage());
                    C4474a.m5059a(bufferedInputStream);
                    if (this.f19032c != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                C4474a.m5059a(bufferedInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
            C4474a.m5059a(bufferedInputStream);
            throw th;
        }
        if (this.f19032c != null) {
            this.f19032c = new C4565a.C4566a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4325i() {
        try {
            if (this.f19032c == null) {
                return;
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C4473j.m5067a().openFileOutput("XMCloudCfg", 0));
            C3992c m6267a = C3992c.m6267a(bufferedOutputStream);
            this.f19032c.mo4529a(m6267a);
            m6267a.m6279a();
            bufferedOutputStream.close();
        } catch (Exception e) {
            AbstractC4478b.m5041a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m4339a(C4567b.C4569b c4569b) {
        AbstractC4628a[] abstractC4628aArr;
        if (c4569b.m4643i() && c4569b.m4644h() > m4332c()) {
            m4327g();
        }
        synchronized (this) {
            abstractC4628aArr = (AbstractC4628a[]) this.f19031b.toArray(new AbstractC4628a[this.f19031b.size()]);
        }
        for (AbstractC4628a abstractC4628a : abstractC4628aArr) {
            abstractC4628a.mo3784a(c4569b);
        }
    }

    /* renamed from: a */
    public synchronized void m4338a(AbstractC4628a abstractC4628a) {
        this.f19031b.add(abstractC4628a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void m4334b() {
        this.f19031b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public int m4332c() {
        m4328f();
        if (this.f19032c != null) {
            return this.f19032c.m4699d();
        }
        return 0;
    }

    /* renamed from: d */
    public C4565a.C4566a m4330d() {
        m4328f();
        return this.f19032c;
    }
}
