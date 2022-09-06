package com.xiaomi.push.service.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.C4464b;
import com.xiaomi.channel.commonutils.android.C4467d;
import com.xiaomi.channel.commonutils.file.C4474a;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.channel.commonutils.misc.C4493k;
import com.xiaomi.channel.commonutils.network.C4497d;
import com.xiaomi.channel.commonutils.string.C4507d;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.push.service.C4609ah;
import com.xiaomi.xmpush.thrift.EnumC4803e;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: com.xiaomi.push.service.module.d */
/* loaded from: classes2.dex */
public class C4677d {

    /* renamed from: a */
    private static C4677d f19144a = null;

    /* renamed from: b */
    private Map<String, C4676c> f19145b = new HashMap();

    /* renamed from: c */
    private List<AbstractC4679b> f19146c = new ArrayList();

    /* renamed from: d */
    private Context f19147d;

    /* renamed from: e */
    private SharedPreferences f19148e;

    /* renamed from: f */
    private boolean f19149f;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.module.d$a */
    /* loaded from: classes2.dex */
    public static class RunnableC4678a implements Runnable {

        /* renamed from: a */
        private String f19150a;

        /* renamed from: b */
        private String f19151b;

        /* renamed from: c */
        private String f19152c;

        /* renamed from: d */
        private boolean f19153d;

        /* renamed from: e */
        private Context f19154e;

        /* renamed from: f */
        private boolean f19155f = false;

        public RunnableC4678a(Context context, String str, String str2, String str3, boolean z) {
            this.f19150a = null;
            this.f19151b = null;
            this.f19150a = str;
            this.f19151b = str2;
            this.f19152c = str3;
            this.f19153d = z;
            this.f19154e = context.getApplicationContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            File file;
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            if (!C4497d.m4983f(this.f19154e)) {
                return;
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f19150a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() != 200) {
                    return;
                }
                byte[] m5053b = C4474a.m5053b(httpURLConnection.getInputStream());
                if (!TextUtils.isEmpty(this.f19151b)) {
                    if (!this.f19151b.equalsIgnoreCase(C4507d.m4945a(m5053b))) {
                        m5053b = null;
                    }
                }
                if (m5053b == null) {
                    return;
                }
                try {
                    AbstractC4478b.m5038b("download apk success.");
                    try {
                        file = new File(this.f19152c + ".tmp");
                        file.delete();
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(m5053b);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (C4467d.m5088a(C4464b.m5092e(this.f19154e, file.getPath()))) {
                        AbstractC4478b.m5038b("verify signature success");
                        file.renameTo(new File(this.f19152c));
                        this.f19155f = true;
                        if (this.f19153d && !C4464b.m5098b(this.f19154e)) {
                            Process.killProcess(Process.myPid());
                        }
                    } else {
                        AbstractC4478b.m5036d("verify signature failed");
                        file.delete();
                    }
                    C4474a.m5058a((OutputStream) null);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    C4474a.m5058a(fileOutputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    C4474a.m5058a(fileOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.module.d$b */
    /* loaded from: classes2.dex */
    public interface AbstractC4679b {
        /* renamed from: a */
        void m4144a(C4681f c4681f);
    }

    private C4677d(Context context) {
        this.f19147d = context.getApplicationContext();
        this.f19148e = this.f19147d.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
    }

    /* renamed from: a */
    private C4676c m4151a(C4674a c4674a, DexClassLoader dexClassLoader) {
        if (dexClassLoader != null) {
            return new C4676c(c4674a.m4183e(), c4674a.m4182f(), dexClassLoader, c4674a.m4192b(), c4674a.m4197a());
        }
        return null;
    }

    /* renamed from: a */
    public static synchronized C4677d m4152a(Context context) {
        C4677d c4677d;
        synchronized (C4677d.class) {
            if (f19144a == null) {
                f19144a = new C4677d(context);
            }
            c4677d = f19144a;
        }
        return c4677d;
    }

    /* renamed from: a */
    private void m4149a(EnumC4680e enumC4680e, int i) {
        this.f19148e.edit().putInt("plugin_version_" + enumC4680e.f19158b, i).commit();
    }

    /* renamed from: a */
    private synchronized void m4148a(C4681f c4681f) {
        for (AbstractC4679b abstractC4679b : this.f19146c) {
            abstractC4679b.m4144a(c4681f);
        }
    }

    /* renamed from: b */
    private int m4146b(EnumC4680e enumC4680e) {
        return this.f19148e.getInt("plugin_version_" + enumC4680e.f19158b, 0);
    }

    /* renamed from: b */
    private List<C4681f> m4147b() {
        ArrayList arrayList = new ArrayList();
        C4609ah m4394a = C4609ah.m4394a(this.f19147d);
        C4681f c4681f = new C4681f();
        c4681f.f19159a = EnumC4680e.MODULE_CDATA;
        c4681f.f19160b = m4394a.m4397a(EnumC4803e.CollectionDataPluginVersion.m3437a(), 0);
        c4681f.f19161c = m4394a.m4396a(EnumC4803e.CollectionPluginDownloadUrl.m3437a(), "");
        c4681f.f19162d = m4394a.m4396a(EnumC4803e.CollectionPluginMd5.m3437a(), "");
        c4681f.f19163e = m4394a.m4395a(EnumC4803e.CollectionPluginForceStop.m3437a(), false);
        arrayList.add(c4681f);
        return arrayList;
    }

    /* renamed from: a */
    public C4676c m4150a(EnumC4680e enumC4680e) {
        C4493k.m5005a();
        if (enumC4680e == null) {
            return null;
        }
        m4153a();
        AbstractC4478b.m5038b("loadModule " + enumC4680e.f19158b);
        String str = enumC4680e.f19158b;
        if (this.f19145b.containsKey(str)) {
            return this.f19145b.get(str);
        }
        C4674a c4674a = new C4674a(this.f19147d, str);
        DexClassLoader m4187c = c4674a.m4187c();
        if (m4187c == null) {
            return null;
        }
        C4676c m4151a = m4151a(c4674a, m4187c);
        m4151a.m4154a(this.f19147d);
        this.f19145b.put(str, m4151a);
        AbstractC4478b.m5038b("module load success.");
        return m4151a;
    }

    /* renamed from: a */
    public synchronized void m4153a() {
        if (!this.f19149f) {
            this.f19149f = true;
            for (C4681f c4681f : m4147b()) {
                if (m4146b(c4681f.f19159a) < c4681f.f19160b && !TextUtils.isEmpty(c4681f.f19161c)) {
                    RunnableC4678a runnableC4678a = new RunnableC4678a(this.f19147d, c4681f.f19161c, c4681f.f19162d, C4674a.m4194a(this.f19147d, c4681f.f19159a.f19158b), c4681f.f19163e);
                    runnableC4678a.run();
                    if (runnableC4678a.f19155f) {
                        m4149a(c4681f.f19159a, c4681f.f19160b);
                        m4148a(c4681f);
                    }
                }
            }
            this.f19149f = false;
        }
    }
}
