package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
/* renamed from: com.amap.api.mapcore.util.ax */
/* loaded from: classes.dex */
public class C0794ax {

    /* renamed from: a */
    public static String f2155a = "";

    /* renamed from: b */
    public static boolean f2156b = false;

    /* renamed from: d */
    public static String f2157d = "";

    /* renamed from: k */
    private static volatile C0794ax f2158k;

    /* renamed from: f */
    public C0831bb f2161f;

    /* renamed from: g */
    C0833bd f2162g;

    /* renamed from: i */
    private Context f2164i;

    /* renamed from: l */
    private AbstractC0798a f2166l;

    /* renamed from: m */
    private C0836bg f2167m;

    /* renamed from: n */
    private C0842bm f2168n;

    /* renamed from: j */
    private boolean f2165j = true;

    /* renamed from: c */
    CopyOnWriteArrayList<C0790aw> f2159c = new CopyOnWriteArrayList<>();

    /* renamed from: o */
    private ExecutorService f2169o = null;

    /* renamed from: p */
    private ExecutorService f2170p = null;

    /* renamed from: q */
    private ExecutorService f2171q = null;

    /* renamed from: e */
    HandlerC0799b f2160e = null;

    /* renamed from: h */
    C0830ba f2163h = null;

    /* renamed from: r */
    private boolean f2172r = true;

    /* renamed from: com.amap.api.mapcore.util.ax$a */
    /* loaded from: classes.dex */
    public interface AbstractC0798a {
        /* renamed from: a */
        void mo17360a();

        /* renamed from: a */
        void mo17359a(C0790aw c0790aw);

        /* renamed from: b */
        void mo17358b(C0790aw c0790aw);

        /* renamed from: c */
        void mo17357c(C0790aw c0790aw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.mapcore.util.ax$b */
    /* loaded from: classes.dex */
    public class HandlerC0799b extends Handler {
        public HandlerC0799b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof C0790aw) {
                    C0790aw c0790aw = (C0790aw) obj;
                    C0856bu.m18754a("OfflineMapHandler handleMessage CitObj  name: " + c0790aw.getCity() + " complete: " + c0790aw.getcompleteCode() + " status: " + c0790aw.getState());
                    if (C0794ax.this.f2166l != null) {
                        C0794ax.this.f2166l.mo17359a(c0790aw);
                    }
                } else {
                    C0856bu.m18754a("Do not callback by CityObject! ");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private C0794ax(Context context) {
        this.f2164i = context;
    }

    /* renamed from: a */
    public static C0794ax m19016a(Context context) {
        if (f2158k == null) {
            synchronized (C0794ax.class) {
                if (f2158k == null && !f2156b) {
                    f2158k = new C0794ax(context.getApplicationContext());
                }
            }
        }
        return f2158k;
    }

    /* renamed from: a */
    private void m19014a(final C0790aw c0790aw, final boolean z) {
        if (this.f2162g == null) {
            this.f2162g = new C0833bd(this.f2164i);
        }
        if (this.f2170p == null) {
            this.f2170p = Executors.newSingleThreadExecutor();
        }
        try {
            this.f2170p.execute(new Runnable() { // from class: com.amap.api.mapcore.util.ax.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c0790aw.m19035c().equals(c0790aw.f2134a)) {
                            if (C0794ax.this.f2166l != null) {
                                C0794ax.this.f2166l.mo17357c(c0790aw);
                            }
                        } else if (c0790aw.getState() == 7 || c0790aw.getState() == -1) {
                            C0794ax.this.f2162g.m18853a(c0790aw);
                            if (z && C0794ax.this.f2166l != null) {
                                C0794ax.this.f2166l.mo17357c(c0790aw);
                            }
                        } else {
                            C0794ax.this.f2162g.m18853a(c0790aw);
                            if (C0794ax.this.f2166l != null) {
                                C0794ax.this.f2166l.mo17357c(c0790aw);
                            }
                        }
                    } catch (Throwable th) {
                        C1007fo.m18012b(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            C1007fo.m18012b(th, "requestDelete", "removeExcecRunnable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19007a(String str, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            try {
                if (str.charAt(i) > str2.charAt(i)) {
                    return true;
                }
                if (str.charAt(i) < str2.charAt(i)) {
                    return false;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m18988f(final C0790aw c0790aw) {
        m18980j();
        if (c0790aw == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        if (this.f2171q == null) {
            this.f2171q = Executors.newSingleThreadExecutor();
        }
        try {
            this.f2171q.execute(new Runnable() { // from class: com.amap.api.mapcore.util.ax.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (C0794ax.this.f2165j) {
                            C0794ax.this.m18980j();
                            C0800ay c = new C0801az(C0794ax.this.f2164i, C0794ax.f2157d).c();
                            if (c != null) {
                                C0794ax.this.f2165j = false;
                                if (c.m18979a()) {
                                    C0794ax.this.m19005b();
                                }
                            }
                        }
                        c0790aw.setVersion(C0794ax.f2157d);
                        c0790aw.m19032f();
                    } catch (AMapException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        C1007fo.m18012b(th, "OfflineDownloadManager", "startDownloadRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            C1007fo.m18012b(th, "startDownload", "downloadExcecRunnable");
        }
    }

    /* renamed from: g */
    private void m18986g() {
        try {
            C0837bh m18818a = this.f2168n.m18818a("000001");
            if (m18818a == null) {
                return;
            }
            this.f2168n.m18809c("000001");
            m18818a.c("100000");
            this.f2168n.m18819a(m18818a);
        } catch (Throwable th) {
            C1007fo.m18012b(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    /* renamed from: g */
    private void m18985g(String str) {
        List<OfflineMapProvince> m18753a = C0856bu.m18753a(str, this.f2164i.getApplicationContext());
        if (m18753a == null || m18753a.size() == 0) {
            return;
        }
        this.f2161f.m18871a(m18753a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0790aw m18983h(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        Iterator<C0790aw> it2 = this.f2159c.iterator();
        while (it2.hasNext()) {
            C0790aw next = it2.next();
            if (str.equals(next.getCity()) || str.equals(next.getPinyin())) {
                return next;
            }
            while (it2.hasNext()) {
            }
        }
        return null;
    }

    /* renamed from: h */
    private void m18984h() {
        if (C0945eh.m18318b(this.f2164i).equals("")) {
            return;
        }
        File file = new File(C0945eh.m18318b(this.f2164i) + "offlinemapv4.png");
        String str = null;
        if (file.exists() && (str = C0856bu.m18745c(file)) != null) {
            try {
                m18985g(str);
            } catch (JSONException e) {
                if (file.exists()) {
                    file.delete();
                }
                C1007fo.m18012b(e, "MapDownloadManager", "paseJson io");
                e.printStackTrace();
            }
        }
        if (file.exists() && this.f2161f.m18858i() != 0 && str != null) {
            return;
        }
        String m18756a = C0856bu.m18756a(this.f2164i, "offlinemapv4.png");
        if (file.exists()) {
            file.delete();
        }
        if (m18756a == null) {
            return;
        }
        try {
            m18985g(m18756a);
        } catch (JSONException e2) {
            if (file.exists()) {
                file.delete();
            }
            C1007fo.m18012b(e2, "MapDownloadManager", "paseJson io");
            e2.printStackTrace();
        }
    }

    /* renamed from: i */
    private C0790aw m18981i(String str) {
        if (str == null || str.length() < 1) {
            return null;
        }
        Iterator<C0790aw> it2 = this.f2159c.iterator();
        while (it2.hasNext()) {
            C0790aw next = it2.next();
            if (str.equals(next.getCode())) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: i */
    private void m18982i() {
        Iterator<C0837bh> it2 = this.f2168n.m18821a().iterator();
        while (it2.hasNext()) {
            C0837bh next = it2.next();
            if (next != null && next.d() != null && next.f().length() >= 1) {
                if (next.f2360l != 4 && next.f2360l != 7 && next.f2360l >= 0) {
                    next.f2360l = 3;
                }
                C0790aw m18983h = m18983h(next.d());
                if (m18983h != null) {
                    String e = next.e();
                    if (e == null || !m19007a(f2157d, e)) {
                        m18983h.m19042a(next.f2360l);
                        m18983h.setCompleteCode(next.g());
                    } else {
                        m18983h.m19042a(7);
                    }
                    if (next.e().length() > 0) {
                        m18983h.setVersion(next.e());
                    }
                    List<String> m18810b = this.f2168n.m18810b(next.f());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String str : m18810b) {
                        stringBuffer.append(str);
                        stringBuffer.append(";");
                    }
                    m18983h.m19037a(stringBuffer.toString());
                    this.f2161f.m18879a(m18983h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m18980j() {
        if (!C0945eh.m18312c(this.f2164i)) {
            throw new AMapException("http连接失败 - ConnectionException");
        }
    }

    /* renamed from: a */
    public void m19017a() {
        this.f2168n = C0842bm.m18820a(this.f2164i.getApplicationContext());
        m18986g();
        this.f2160e = new HandlerC0799b(this.f2164i.getMainLooper());
        this.f2161f = new C0831bb(this.f2164i, this.f2160e);
        this.f2167m = C0836bg.m18846a(1);
        f2155a = C0945eh.m18318b(this.f2164i);
        m18984h();
        Iterator<OfflineMapProvince> it2 = this.f2161f.m18882a().iterator();
        while (it2.hasNext()) {
            Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
            while (it3.hasNext()) {
                OfflineMapCity next = it3.next();
                if (next != null) {
                    this.f2159c.add(new C0790aw(this.f2164i, next));
                }
            }
        }
        this.f2163h = new C0830ba(this.f2164i);
        this.f2163h.start();
    }

    /* renamed from: a */
    public void m19015a(C0790aw c0790aw) {
        m19014a(c0790aw, false);
    }

    /* renamed from: a */
    public void m19013a(AbstractC0798a abstractC0798a) {
        this.f2166l = abstractC0798a;
    }

    /* renamed from: a */
    public void m19008a(final String str) {
        try {
            if (str == null) {
                if (this.f2166l == null) {
                    return;
                }
                this.f2166l.mo17358b(null);
                return;
            }
            if (this.f2169o == null) {
                this.f2169o = Executors.newSingleThreadExecutor();
            }
            this.f2169o.execute(new Runnable() { // from class: com.amap.api.mapcore.util.ax.1
                @Override // java.lang.Runnable
                public void run() {
                    C0790aw m18983h = C0794ax.this.m18983h(str);
                    if (m18983h != null) {
                        try {
                            if (m18983h.m19035c().equals(m18983h.f2136c) || m18983h.m19035c().equals(m18983h.f2138e)) {
                                if (C0794ax.this.f2166l == null) {
                                    return;
                                }
                                synchronized (C0794ax.this) {
                                    C0794ax.this.f2166l.mo17358b(m18983h);
                                }
                                return;
                            }
                            String pinyin = m18983h.getPinyin();
                            if (pinyin.length() > 0) {
                                String m18808d = C0794ax.this.f2168n.m18808d(pinyin);
                                if (m18808d == null) {
                                    m18808d = m18983h.getVersion();
                                }
                                if (C0794ax.f2157d.length() > 0 && m18808d != null && C0794ax.this.m19007a(C0794ax.f2157d, m18808d)) {
                                    m18983h.m19028j();
                                }
                            }
                        } catch (Exception e) {
                            if (C0794ax.this.f2166l == null) {
                                return;
                            }
                            synchronized (C0794ax.this) {
                                C0794ax.this.f2166l.mo17358b(m18983h);
                                return;
                            }
                        } catch (Throwable th) {
                            if (C0794ax.this.f2166l != null) {
                                synchronized (C0794ax.this) {
                                    C0794ax.this.f2166l.mo17358b(m18983h);
                                }
                            }
                            throw th;
                        }
                    }
                    C0794ax.this.m18980j();
                    C0800ay c = new C0801az(C0794ax.this.f2164i, C0794ax.f2157d).c();
                    if (C0794ax.this.f2166l != null) {
                        if (c == null) {
                            if (C0794ax.this.f2166l == null) {
                                return;
                            }
                            synchronized (C0794ax.this) {
                                C0794ax.this.f2166l.mo17358b(m18983h);
                            }
                            return;
                        } else if (c.m18979a()) {
                            C0794ax.this.m19005b();
                        }
                    }
                    if (C0794ax.this.f2166l != null) {
                        synchronized (C0794ax.this) {
                            C0794ax.this.f2166l.mo17358b(m18983h);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            C1007fo.m18012b(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    /* renamed from: a */
    public void m19006a(ArrayList<C0837bh> arrayList) {
        m18982i();
        if (this.f2166l != null) {
            try {
                this.f2166l.mo17360a();
            } catch (Throwable th) {
                C1007fo.m18012b(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    /* renamed from: b */
    protected void m19005b() {
        C0834be c0834be = new C0834be(this.f2164i, "");
        c0834be.m18850a(this.f2164i);
        List<OfflineMapProvince> c = c0834be.c();
        if (this.f2159c != null) {
            this.f2161f.m18871a(c);
        }
        Iterator<OfflineMapProvince> it2 = this.f2161f.m18882a().iterator();
        while (it2.hasNext()) {
            Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
            while (it3.hasNext()) {
                OfflineMapCity next = it3.next();
                Iterator<C0790aw> it4 = this.f2159c.iterator();
                while (it4.hasNext()) {
                    C0790aw next2 = it4.next();
                    if (next.getPinyin().equals(next2.getPinyin())) {
                        String version = next2.getVersion();
                        if (next2.getState() != 4 || f2157d.length() <= 0 || !m19007a(f2157d, version)) {
                            next2.setCity(next.getCity());
                            next2.setUrl(next.getUrl());
                            next2.setAdcode(next.getAdcode());
                            next2.setVersion(next.getVersion());
                            next2.setSize(next.getSize());
                            next2.setCode(next.getCode());
                            next2.setJianpin(next.getJianpin());
                            next2.setPinyin(next.getPinyin());
                        } else {
                            next2.m19028j();
                            next2.setUrl(next.getUrl());
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void m19004b(C0790aw c0790aw) {
        try {
            this.f2167m.m18844a(c0790aw, this.f2164i, null);
        } catch (C0975ex e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public boolean m19002b(String str) {
        return m18983h(str) != null;
    }

    /* renamed from: c */
    public void m19001c() {
        Iterator<C0790aw> it2 = this.f2159c.iterator();
        while (it2.hasNext()) {
            C0790aw next = it2.next();
            if (next.m19035c().equals(next.f2136c) || next.m19035c().equals(next.f2135b)) {
                next.m19032f();
            }
        }
    }

    /* renamed from: c */
    public void m19000c(C0790aw c0790aw) {
        this.f2161f.m18879a(c0790aw);
        if (this.f2160e != null) {
            Message obtainMessage = this.f2160e.obtainMessage();
            obtainMessage.obj = c0790aw;
            this.f2160e.sendMessage(obtainMessage);
        }
    }

    /* renamed from: c */
    public void m18998c(String str) {
        C0790aw m18983h = m18983h(str);
        if (m18983h != null) {
            m18996d(m18983h);
            m19014a(m18983h, true);
        } else if (this.f2166l == null) {
        } else {
            try {
                this.f2166l.mo17357c(m18983h);
            } catch (Throwable th) {
                C1007fo.m18012b(th, "OfflineDownloadManager", "remove");
            }
        }
    }

    /* renamed from: d */
    public void m18997d() {
        Iterator<C0790aw> it2 = this.f2159c.iterator();
        while (it2.hasNext()) {
            C0790aw next = it2.next();
            if (next.m19035c().equals(next.f2136c)) {
                next.m19031g();
                return;
            }
        }
    }

    /* renamed from: d */
    public void m18996d(C0790aw c0790aw) {
        this.f2167m.m18845a(c0790aw);
    }

    /* renamed from: d */
    public void m18994d(String str) {
        C0790aw m18983h = m18983h(str);
        if (str == null || str.length() < 1 || m18983h == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        m18988f(m18983h);
    }

    /* renamed from: e */
    public void m18993e() {
        if (this.f2169o != null && !this.f2169o.isShutdown()) {
            this.f2169o.shutdownNow();
        }
        if (this.f2171q != null && !this.f2171q.isShutdown()) {
            this.f2171q.shutdownNow();
        }
        if (this.f2163h != null) {
            if (this.f2163h.isAlive()) {
                this.f2163h.interrupt();
            }
            this.f2163h = null;
        }
        if (this.f2160e != null) {
            this.f2160e.removeCallbacksAndMessages(null);
            this.f2160e = null;
        }
        if (this.f2167m != null) {
            this.f2167m.m18842b();
        }
        if (this.f2161f != null) {
            this.f2161f.m18860g();
        }
        f2158k = null;
        f2156b = true;
        this.f2165j = true;
        m18989f();
    }

    /* renamed from: e */
    public void m18992e(C0790aw c0790aw) {
        this.f2167m.m18841b(c0790aw);
    }

    /* renamed from: e */
    public void m18990e(String str) {
        C0790aw m18981i = m18981i(str);
        if (m18981i != null) {
            m18988f(m18981i);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: f */
    public String m18987f(String str) {
        C0790aw m18983h;
        return (str == null || (m18983h = m18983h(str)) == null) ? "" : m18983h.getAdcode();
    }

    /* renamed from: f */
    public void m18989f() {
        synchronized (this) {
            this.f2166l = null;
        }
    }
}
