package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.p075b.C0648a;
import cn.sharesdk.framework.utils.C0683d;
import com.facebook.common.util.UriUtil;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* renamed from: cn.sharesdk.framework.f */
/* loaded from: classes.dex */
public class C0673f extends SSDKHandlerThread {

    /* renamed from: b */
    private Context f1585b;

    /* renamed from: j */
    private String f1593j;

    /* renamed from: k */
    private boolean f1594k;

    /* renamed from: l */
    private String f1595l;

    /* renamed from: m */
    private boolean f1596m;

    /* renamed from: n */
    private boolean f1597n;

    /* renamed from: a */
    private EnumC0676a f1584a = EnumC0676a.IDLE;

    /* renamed from: c */
    private HashMap<String, HashMap<String, String>> f1586c = new HashMap<>();

    /* renamed from: d */
    private ArrayList<Platform> f1587d = new ArrayList<>();

    /* renamed from: e */
    private HashMap<String, Integer> f1588e = new HashMap<>();

    /* renamed from: f */
    private HashMap<Integer, String> f1589f = new HashMap<>();

    /* renamed from: g */
    private HashMap<Integer, CustomPlatform> f1590g = new HashMap<>();

    /* renamed from: h */
    private HashMap<Integer, HashMap<String, Object>> f1591h = new HashMap<>();

    /* renamed from: i */
    private HashMap<Integer, Service> f1592i = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.sharesdk.framework.f$a */
    /* loaded from: classes.dex */
    public enum EnumC0676a {
        IDLE,
        INITIALIZING,
        READY
    }

    public C0673f(Context context, String str) {
        this.f1593j = str;
        this.f1585b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m19559a(C0648a c0648a, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2) {
        boolean z;
        try {
            if (hashMap.containsKey(XiaomiOAuthConstants.EXTRA_ERROR_CODE_2)) {
                C0683d.m19513a().m5966i("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(hashMap));
                z = false;
            } else if (!hashMap.containsKey(UriUtil.LOCAL_RESOURCE_SCHEME)) {
                C0683d.m19513a().m5972d("ShareSDK platform config result ==>>", "SNS configuration is empty");
                z = false;
            } else {
                String str = (String) hashMap.get(UriUtil.LOCAL_RESOURCE_SCHEME);
                if (str == null) {
                    z = false;
                } else {
                    hashMap2.putAll(c0648a.m19694b(str));
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            return false;
        }
    }

    /* renamed from: f */
    private void m19534f() {
        HashMap<String, String> remove;
        synchronized (this.f1586c) {
            this.f1586c.clear();
            m19533g();
            if (this.f1586c.containsKey("ShareSDK") && (remove = this.f1586c.remove("ShareSDK")) != null) {
                if (this.f1593j == null) {
                    this.f1593j = remove.get("AppKey");
                }
                this.f1595l = remove.containsKey("UseVersion") ? remove.get("UseVersion") : "latest";
            }
        }
    }

    /* renamed from: g */
    private void m19533g() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            InputStream open = this.f1585b.getAssets().open("ShareSDK.xml");
            newPullParser.setInput(open, "utf-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    HashMap<String, String> hashMap = new HashMap<>();
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        hashMap.put(newPullParser.getAttributeName(i), newPullParser.getAttributeValue(i).trim());
                    }
                    this.f1586c.put(name, hashMap);
                }
            }
            open.close();
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.f$1] */
    /* renamed from: h */
    private void m19532h() {
        new Thread() { // from class: cn.sharesdk.framework.f.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    if (C0673f.this.m19538d() || !C0673f.this.m19551a(hashMap)) {
                        return;
                    }
                    C0673f.this.m19544b(hashMap);
                } catch (Throwable th) {
                    C0683d.m19513a().m5959w(th);
                }
            }
        }.start();
    }

    /* renamed from: i */
    private void m19531i() {
        this.f1587d.clear();
        ArrayList<Platform> m19581a = new C0671e(this.f1585b, this.f1593j).m19581a();
        if (m19581a != null) {
            this.f1587d.addAll(m19581a);
        }
        synchronized (this.f1588e) {
            synchronized (this.f1589f) {
                Iterator<Platform> it2 = this.f1587d.iterator();
                while (it2.hasNext()) {
                    Platform next = it2.next();
                    this.f1589f.put(Integer.valueOf(next.getPlatformId()), next.getName());
                    this.f1588e.put(next.getName(), Integer.valueOf(next.getPlatformId()));
                }
            }
        }
    }

    /* renamed from: j */
    private void m19530j() {
        C0671e c0671e = new C0671e(this.f1585b, this.f1593j);
        c0671e.m19575a(this);
        c0671e.m19576a(this.handler, this.f1594k, 70);
    }

    /* renamed from: a */
    public Platform m19556a(String str) {
        Platform[] m19565a;
        if (str == null || (m19565a = m19565a()) == null) {
            return null;
        }
        for (Platform platform : m19565a) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m19561a(int i, String str) {
        String m19578a;
        synchronized (this.f1591h) {
            m19578a = new C0671e(this.f1585b, this.f1593j).m19578a(i, str, this.f1591h);
        }
        return m19578a;
    }

    /* renamed from: a */
    public String m19560a(Bitmap bitmap) {
        if (EnumC0676a.READY != this.f1584a) {
            return null;
        }
        return new C0671e(this.f1585b, this.f1593j).m19577a(bitmap);
    }

    /* renamed from: a */
    public String m19552a(String str, boolean z, int i, String str2) {
        return EnumC0676a.READY != this.f1584a ? str : new C0671e(this.f1585b, this.f1593j).m19572a(str, z, i, str2);
    }

    /* renamed from: a */
    public void m19564a(int i) {
        NetworkHelper.connectionTimeout = i;
    }

    /* renamed from: a */
    public void m19563a(int i, int i2) {
        synchronized (this.f1591h) {
            new C0671e(this.f1585b, this.f1593j).m19580a(i, i2, this.f1591h);
        }
    }

    /* renamed from: a */
    public void m19562a(int i, Platform platform) {
        new C0671e(this.f1585b, this.f1593j).m19579a(i, platform);
    }

    /* renamed from: a */
    public void m19557a(Class<? extends Service> cls) {
        synchronized (this.f1592i) {
            if (this.f1592i.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            Service newInstance = cls.newInstance();
            this.f1592i.put(Integer.valueOf(cls.hashCode()), newInstance);
            newInstance.m19770a(this.f1585b);
            newInstance.m19768a(this.f1593j);
            newInstance.onBind();
        }
    }

    /* renamed from: a */
    public void m19555a(String str, int i) {
        new C0671e(this.f1585b, this.f1593j).m19573a(str, i);
    }

    /* renamed from: a */
    public void m19554a(String str, String str2) {
        synchronized (this.f1586c) {
            this.f1586c.put(str2, this.f1586c.get(str));
        }
    }

    /* renamed from: a */
    public void m19553a(String str, HashMap<String, Object> hashMap) {
        synchronized (this.f1586c) {
            HashMap<String, String> hashMap2 = this.f1586c.get(str);
            HashMap<String, String> hashMap3 = hashMap2 == null ? new HashMap<>() : hashMap2;
            synchronized (hashMap3) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        hashMap3.put(key, String.valueOf(value));
                    }
                }
            }
            this.f1586c.put(str, hashMap3);
        }
        synchronized (this.f1587d) {
            if (this.f1584a == EnumC0676a.INITIALIZING) {
                this.f1587d.wait();
            }
            Iterator<Platform> it2 = this.f1587d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Platform next = it2.next();
                if (next != null && next.getName().equals(str)) {
                    next.m19772a();
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public void m19550a(boolean z) {
        this.f1594k = z;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [cn.sharesdk.framework.f$2] */
    /* renamed from: a */
    public boolean m19551a(HashMap<String, Object> hashMap) {
        if (EnumC0676a.READY != this.f1584a) {
            C0683d.m19513a().m5972d("Statistics module unopened", new Object[0]);
            return false;
        }
        final C0648a m19708a = C0648a.m19708a(this.f1585b, this.f1593j);
        boolean m19559a = m19559a(m19708a, m19708a.m19691d(), hashMap);
        if (m19559a) {
            this.f1597n = true;
            new Thread() { // from class: cn.sharesdk.framework.f.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        HashMap<String, Object> m19689e = m19708a.m19689e();
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        if (C0673f.this.m19559a(m19708a, m19689e, hashMap2)) {
                            C0673f.this.m19544b(hashMap2);
                        }
                        m19708a.m19697a(m19689e);
                    } catch (Throwable th) {
                        C0683d.m19513a().m5959w(th);
                    }
                }
            }.start();
            return m19559a;
        }
        try {
            HashMap<String, Object> m19689e = m19708a.m19689e();
            m19559a = m19559a(m19708a, m19689e, hashMap);
            if (m19559a) {
                m19708a.m19697a(m19689e);
            }
            this.f1597n = true;
            return m19559a;
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            this.f1597n = false;
            return m19559a;
        }
    }

    /* renamed from: a */
    public Platform[] m19565a() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f1587d) {
            if (this.f1584a == EnumC0676a.IDLE) {
                return null;
            }
            if (this.f1584a == EnumC0676a.INITIALIZING) {
                this.f1587d.wait();
            }
            ArrayList<Platform> arrayList = new ArrayList<>();
            Iterator<Platform> it2 = this.f1587d.iterator();
            while (it2.hasNext()) {
                Platform next = it2.next();
                if (next != null && next.m19771b()) {
                    next.m19772a();
                    arrayList.add(next);
                }
            }
            new C0671e(this.f1585b, this.f1593j).m19571a(arrayList);
            for (Map.Entry<Integer, CustomPlatform> entry : this.f1590g.entrySet()) {
                CustomPlatform value = entry.getValue();
                if (value != null && value.m19771b()) {
                    arrayList.add(value);
                }
            }
            if (arrayList.size() <= 0) {
                return null;
            }
            Platform[] platformArr = new Platform[arrayList.size()];
            for (int i = 0; i < platformArr.length; i++) {
                platformArr[i] = arrayList.get(i);
            }
            C0683d.m19513a().m5966i("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return platformArr;
        }
    }

    /* renamed from: b */
    public int m19546b(String str) {
        int intValue;
        synchronized (this.f1588e) {
            intValue = this.f1588e.containsKey(str) ? this.f1588e.get(str).intValue() : 0;
        }
        return intValue;
    }

    /* renamed from: b */
    public String m19549b() {
        try {
            return new C0671e(this.f1585b, this.f1593j).m19568c();
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            return "2.8.1";
        }
    }

    /* renamed from: b */
    public String m19545b(String str, String str2) {
        String str3;
        synchronized (this.f1586c) {
            HashMap<String, String> hashMap = this.f1586c.get(str);
            str3 = hashMap == null ? null : hashMap.get(str2);
        }
        return str3;
    }

    /* renamed from: b */
    public void m19548b(int i) {
        NetworkHelper.readTimout = i;
    }

    /* renamed from: b */
    public void m19547b(Class<? extends Service> cls) {
        synchronized (this.f1592i) {
            int hashCode = cls.hashCode();
            if (this.f1592i.containsKey(Integer.valueOf(hashCode))) {
                this.f1592i.get(Integer.valueOf(hashCode)).onUnbind();
                this.f1592i.remove(Integer.valueOf(hashCode));
            }
        }
    }

    /* renamed from: b */
    public void m19543b(boolean z) {
        this.f1596m = z;
    }

    /* renamed from: b */
    public boolean m19544b(HashMap<String, Object> hashMap) {
        boolean m19570a;
        synchronized (this.f1591h) {
            this.f1591h.clear();
            m19570a = new C0671e(this.f1585b, this.f1593j).m19570a(hashMap, this.f1591h);
        }
        return m19570a;
    }

    /* renamed from: c */
    public <T extends Service> T m19540c(Class<T> cls) {
        synchronized (this.f1592i) {
            if (this.f1584a == EnumC0676a.IDLE) {
                return null;
            }
            if (this.f1584a == EnumC0676a.INITIALIZING) {
                this.f1592i.wait();
            }
            return cls.cast(this.f1592i.get(Integer.valueOf(cls.hashCode())));
        }
    }

    /* renamed from: c */
    public String m19541c(int i) {
        String str;
        synchronized (this.f1589f) {
            str = this.f1589f.get(Integer.valueOf(i));
        }
        return str;
    }

    /* renamed from: c */
    public String m19539c(String str) {
        if (EnumC0676a.READY != this.f1584a) {
            return null;
        }
        return new C0671e(this.f1585b, this.f1593j).m19574a(str);
    }

    /* renamed from: c */
    public boolean m19542c() {
        return this.f1596m;
    }

    /* renamed from: d */
    public void m19537d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f1590g) {
            if (this.f1590g.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            CustomPlatform newInstance = cls.getConstructor(Context.class).newInstance(this.f1585b);
            this.f1590g.put(Integer.valueOf(cls.hashCode()), newInstance);
            synchronized (this.f1588e) {
                synchronized (this.f1589f) {
                    if (newInstance != null && newInstance.b()) {
                        this.f1589f.put(Integer.valueOf(newInstance.getPlatformId()), newInstance.getName());
                        this.f1588e.put(newInstance.getName(), Integer.valueOf(newInstance.getPlatformId()));
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public boolean m19538d() {
        boolean z;
        synchronized (this.f1591h) {
            z = (this.f1591h == null || this.f1591h.size() <= 0) ? this.f1597n : true;
        }
        return z;
    }

    /* renamed from: e */
    public void m19536e() {
        try {
            ResHelper.clearCache(this.f1585b);
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
        }
    }

    /* renamed from: e */
    public void m19535e(Class<? extends CustomPlatform> cls) {
        int hashCode = cls.hashCode();
        synchronized (this.f1590g) {
            this.f1590g.remove(Integer.valueOf(hashCode));
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f1584a = EnumC0676a.IDLE;
                this.handler.getLooper().quit();
                return;
            default:
                return;
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onStart(Message message) {
        synchronized (this.f1592i) {
            synchronized (this.f1587d) {
                try {
                    String checkRecord = EventRecorder.checkRecord("ShareSDK");
                    if (!TextUtils.isEmpty(checkRecord)) {
                        C0648a.m19708a(this.f1585b, this.f1593j).m19697a((HashMap<String, Object>) null);
                        C0683d.m19513a().m5960w("EventRecorder checkRecord result ==" + checkRecord, new Object[0]);
                        m19536e();
                    }
                    EventRecorder.clear();
                } catch (Throwable th) {
                    C0683d.m19513a().m5959w(th);
                }
                m19531i();
                m19530j();
                this.f1584a = EnumC0676a.READY;
                this.f1587d.notify();
                this.f1592i.notify();
                m19532h();
            }
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    protected void onStop(Message message) {
        synchronized (this.f1592i) {
            for (Map.Entry<Integer, Service> entry : this.f1592i.entrySet()) {
                entry.getValue().onUnbind();
            }
            this.f1592i.clear();
        }
        synchronized (this.f1590g) {
            this.f1590g.clear();
        }
        try {
            new C0671e(this.f1585b, this.f1593j).m19569b();
        } catch (Throwable th) {
            C0683d.m19513a().m5959w(th);
            this.handler.getLooper().quit();
            this.f1584a = EnumC0676a.IDLE;
        }
    }

    @Override // com.mob.tools.SSDKHandlerThread
    public void startThread() {
        this.f1584a = EnumC0676a.INITIALIZING;
        C0683d.m19512a(this.f1585b, 60070, this.f1593j);
        EventRecorder.prepare(this.f1585b);
        m19534f();
        super.startThread();
    }
}
