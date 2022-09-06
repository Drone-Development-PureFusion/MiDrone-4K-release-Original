package cn.sharesdk.framework.p075b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.p075b.p076a.C0651c;
import cn.sharesdk.framework.p075b.p076a.C0652d;
import cn.sharesdk.framework.p075b.p076a.C0653e;
import cn.sharesdk.framework.p075b.p077b.AbstractC0657c;
import cn.sharesdk.framework.utils.C0683d;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.p219mi.live.openlivesdk.C4095b;
import java.util.ArrayList;
import java.util.HashMap;
import org.p248a.p249a.C5083e;
import p004b.p005a.p006a.p028b.p044i.p045a.C0413a;
/* renamed from: cn.sharesdk.framework.b.c */
/* loaded from: classes.dex */
public class C0663c {

    /* renamed from: a */
    private String f1540a;

    /* renamed from: b */
    private Context f1541b;

    /* renamed from: c */
    private C0653e f1542c;

    /* renamed from: d */
    private DeviceHelper f1543d;

    /* renamed from: e */
    private NetworkHelper f1544e = new NetworkHelper();

    /* renamed from: f */
    private Hashon f1545f = new Hashon();

    /* renamed from: g */
    private String f1546g;

    /* renamed from: h */
    private String f1547h;

    /* renamed from: i */
    private boolean f1548i;

    /* renamed from: j */
    private HashMap<String, String> f1549j;

    public C0663c(Context context, String str) {
        this.f1540a = str;
        this.f1541b = context.getApplicationContext();
        this.f1542c = C0653e.m19677a(this.f1541b);
        this.f1543d = DeviceHelper.getInstance(this.f1541b);
        try {
            this.f1549j = (HashMap) this.f1542c.m19655h("buffered_server_paths");
        } catch (Throwable th) {
            this.f1549j = new HashMap<>();
        }
        m19628g();
    }

    /* renamed from: d */
    private String m19631d(String str) {
        boolean m19670b = this.f1542c.m19670b();
        boolean m19666c = this.f1542c.m19666c();
        StringBuilder sb = new StringBuilder();
        sb.append(Data.urlEncode(this.f1543d.getPackageName(), "utf-8")).append("|");
        sb.append(Data.urlEncode(this.f1543d.getAppVersionName(), "utf-8")).append("|");
        sb.append(Data.urlEncode(String.valueOf(60070), "utf-8")).append("|");
        sb.append(Data.urlEncode(String.valueOf(this.f1543d.getPlatformCode()), "utf-8")).append("|");
        sb.append(Data.urlEncode(this.f1543d.getDetailNetworkTypeForStatic(), "utf-8")).append("|");
        if (m19670b) {
            sb.append(Data.urlEncode(String.valueOf(this.f1543d.getOSVersionInt()), "utf-8")).append("|");
            sb.append(Data.urlEncode(this.f1543d.getScreenSize(), "utf-8")).append("|");
            sb.append(Data.urlEncode(this.f1543d.getManufacturer(), "utf-8")).append("|");
            sb.append(Data.urlEncode(this.f1543d.getModel(), "utf-8")).append("|");
            sb.append(Data.urlEncode(this.f1543d.getCarrier(), "utf-8")).append("|");
        } else {
            sb.append("|||||");
        }
        if (m19666c) {
            sb.append(str);
        } else {
            sb.append(str.split("\\|")[0]);
            sb.append("|||||");
        }
        String sb2 = sb.toString();
        C0683d.m19513a().m5966i("shorLinkMsg ===>>>>", sb2);
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", this.f1543d.getDeviceKey(), this.f1540a)), sb2), 2);
    }

    /* renamed from: g */
    private void m19628g() {
        this.f1546g = (this.f1543d.getPackageName() + "/" + this.f1543d.getAppVersionName()) + " ShareSDK/2.8.1 " + ("Android/" + this.f1543d.getOSVersionInt());
        this.f1547h = "http://api.share.mob.com:80";
        this.f1548i = true;
    }

    /* renamed from: h */
    private String m19627h() {
        return this.f1547h + "/conn";
    }

    /* renamed from: i */
    private String m19626i() {
        return (this.f1549j == null || !this.f1549j.containsKey("/date")) ? this.f1547h + "/date" : this.f1549j.get("/date") + "/date";
    }

    /* renamed from: j */
    private String m19625j() {
        return this.f1547h + "/conf5";
    }

    /* renamed from: k */
    private String m19624k() {
        return "http://up.sharesdk.cn/upload/image";
    }

    /* renamed from: l */
    private String m19623l() {
        return (this.f1549j == null || !this.f1549j.containsKey("/log4")) ? this.f1547h + "/log4" : this.f1549j.get("/log4") + "/log4";
    }

    /* renamed from: m */
    private String m19622m() {
        return "http://l.mob.com/url/ShareSdkMapping.do";
    }

    /* renamed from: n */
    private String m19621n() {
        return (this.f1549j == null || !this.f1549j.containsKey("/snsconf")) ? this.f1547h + "/snsconf" : this.f1549j.get("/snsconf") + "/snsconf";
    }

    /* renamed from: a */
    public HashMap<String, Object> m19644a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(C4095b.f17105f, this.f1540a));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(C5083e.f21661Y, this.f1546g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 30000;
        networkTimeOut.connectionTimeout = 30000;
        String httpPost = this.f1544e.httpPost(m19627h(), arrayList, null, arrayList2, networkTimeOut);
        C0683d.m19513a().m5966i(" isConnectToServer response == %s", httpPost);
        return this.f1545f.fromJson(httpPost);
    }

    /* renamed from: a */
    public HashMap<String, Object> m19641a(String str, ArrayList<String> arrayList, int i, String str2) {
        if (!this.f1548i) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("key", this.f1540a));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(new KVPair<>("urls", arrayList.get(i2).toString()));
        }
        arrayList2.add(new KVPair<>("deviceid", this.f1543d.getDeviceKey()));
        arrayList2.add(new KVPair<>("snsplat", String.valueOf(i)));
        String m19631d = m19631d(str2);
        if (TextUtils.isEmpty(m19631d)) {
            return null;
        }
        arrayList2.add(new KVPair<>(C0413a.f922b, m19631d));
        ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
        arrayList3.add(new KVPair<>(C5083e.f21661Y, this.f1546g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 5000;
        networkTimeOut.connectionTimeout = 5000;
        String httpPost = this.f1544e.httpPost(m19622m(), arrayList2, null, arrayList3, networkTimeOut);
        C0683d.m19513a().m5966i("> SERVER_SHORT_LINK_URL  resp: %s", httpPost);
        if (TextUtils.isEmpty(httpPost)) {
            this.f1548i = false;
            return null;
        }
        HashMap<String, Object> fromJson = this.f1545f.fromJson(httpPost);
        if (((Integer) fromJson.get("status")).intValue() != 200) {
            return null;
        }
        return fromJson;
    }

    /* renamed from: a */
    public void m19643a(AbstractC0657c abstractC0657c) {
        C0652d.m19682a(this.f1541b, abstractC0657c.toString(), abstractC0657c.f1506e);
    }

    /* renamed from: a */
    public void m19642a(String str) {
        this.f1547h = str;
    }

    /* renamed from: a */
    public void m19639a(ArrayList<String> arrayList) {
        C0652d.m19680a(this.f1541b, arrayList);
    }

    /* renamed from: a */
    public void m19638a(HashMap<String, String> hashMap) {
        this.f1549j = hashMap;
        this.f1542c.m19673a("buffered_server_paths", this.f1549j);
    }

    /* renamed from: a */
    public boolean m19640a(String str, boolean z) {
        try {
            if ("none".equals(this.f1543d.getDetailNetworkTypeForStatic())) {
                throw new IllegalStateException("network is disconnected!");
            }
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>(C0413a.f922b, str));
            arrayList.add(new KVPair<>("t", z ? "1" : "0"));
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>(C5083e.f21661Y, this.f1546g));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            String httpPost = this.f1544e.httpPost(m19623l(), arrayList, null, arrayList2, networkTimeOut);
            C0683d.m19513a().m5966i("> Upload All Log  resp: %s", httpPost);
            return TextUtils.isEmpty(httpPost) || ((Integer) this.f1545f.fromJson(httpPost).get("status")).intValue() == 200;
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
            return false;
        }
    }

    /* renamed from: b */
    public long m19637b() {
        if (!this.f1542c.m19658g()) {
            return 0L;
        }
        String str = "{}";
        try {
            str = this.f1544e.httpGet(m19626i(), null, null, null);
        } catch (Throwable th) {
            C0683d.m19513a().m5971d(th);
        }
        HashMap fromJson = this.f1545f.fromJson(str);
        if (!fromJson.containsKey("timestamp")) {
            return this.f1542c.m19679a();
        }
        try {
            long currentTimeMillis = System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(fromJson.get("timestamp")));
            this.f1542c.m19674a("service_time", Long.valueOf(currentTimeMillis));
            return currentTimeMillis;
        } catch (Throwable th2) {
            C0683d.m19513a().m5971d(th2);
            return this.f1542c.m19679a();
        }
    }

    /* renamed from: b */
    public HashMap<String, Object> m19636b(String str) {
        KVPair<String> kVPair = new KVPair<>("file", str);
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(C5083e.f21661Y, this.f1546g));
        String httpPost = this.f1544e.httpPost(m19624k(), null, kVPair, arrayList, null);
        C0683d.m19513a().m5966i("upload file response == %s", httpPost);
        return this.f1545f.fromJson(httpPost);
    }

    /* renamed from: b */
    public void m19635b(HashMap<String, Object> hashMap) {
        this.f1542c.m19672a(this.f1540a, this.f1545f.fromHashMap(hashMap));
    }

    /* renamed from: c */
    public HashMap<String, Object> m19634c() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(C4095b.f17105f, this.f1540a));
        arrayList.add(new KVPair<>("device", this.f1543d.getDeviceKey()));
        arrayList.add(new KVPair<>("plat", String.valueOf(this.f1543d.getPlatformCode())));
        arrayList.add(new KVPair<>("apppkg", this.f1543d.getPackageName()));
        arrayList.add(new KVPair<>("appver", String.valueOf(this.f1543d.getAppVersion())));
        arrayList.add(new KVPair<>("sdkver", String.valueOf(60070)));
        arrayList.add(new KVPair<>("networktype", this.f1543d.getDetailNetworkTypeForStatic()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(C5083e.f21661Y, this.f1546g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        String httpPost = this.f1544e.httpPost(m19625j(), arrayList, null, arrayList2, networkTimeOut);
        C0683d.m19513a().m5966i(" get server config response == %s", httpPost);
        return this.f1545f.fromJson(httpPost);
    }

    /* renamed from: c */
    public HashMap<String, Object> m19633c(String str) {
        return this.f1545f.fromJson(new String(Data.AES128Decode(Data.rawMD5(this.f1540a + ":" + this.f1543d.getDeviceKey()), Base64.decode(str, 2)), "UTF-8").trim());
    }

    /* renamed from: d */
    public HashMap<String, Object> m19632d() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(C4095b.f17105f, this.f1540a));
        arrayList.add(new KVPair<>("device", this.f1543d.getDeviceKey()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(C5083e.f21661Y, this.f1546g));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        return this.f1545f.fromJson(this.f1544e.httpPost(m19621n(), arrayList, null, arrayList2, networkTimeOut));
    }

    /* renamed from: e */
    public ArrayList<C0651c> m19630e() {
        ArrayList<C0651c> m19683a = C0652d.m19683a(this.f1541b);
        return m19683a == null ? new ArrayList<>() : m19683a;
    }

    /* renamed from: f */
    public HashMap<String, Object> m19629f() {
        return this.f1545f.fromJson(this.f1542c.m19661e(this.f1540a));
    }
}
