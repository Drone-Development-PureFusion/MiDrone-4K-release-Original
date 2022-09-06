package com.xiaomi.network;

import android.text.TextUtils;
import com.amap.api.services.district.DistrictSearchQuery;
import com.tencent.p227mm.sdk.platformtools.Util;
import com.tencent.stat.DeviceInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Fallback {

    /* renamed from: a */
    public String f18685a;

    /* renamed from: b */
    public String f18686b;

    /* renamed from: c */
    public String f18687c;

    /* renamed from: d */
    public String f18688d;

    /* renamed from: e */
    public String f18689e;

    /* renamed from: f */
    public String f18690f;

    /* renamed from: g */
    public String f18691g;

    /* renamed from: h */
    protected String f18692h;

    /* renamed from: i */
    private long f18693i;

    /* renamed from: k */
    private String f18695k;

    /* renamed from: j */
    private ArrayList<C4554c> f18694j = new ArrayList<>();

    /* renamed from: l */
    private double f18696l = 0.1d;

    /* renamed from: m */
    private String f18697m = "s.mi1.cc";

    /* renamed from: n */
    private long f18698n = Util.MILLSECONDS_OF_DAY;

    public Fallback(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f18693i = System.currentTimeMillis();
        this.f18694j.add(new C4554c(str, -1));
        this.f18685a = HostManager.getInstance().getActiveNetworkLabel();
        this.f18686b = str;
    }

    /* renamed from: c */
    private synchronized void m4760c(String str) {
        Iterator<C4554c> it2 = this.f18694j.iterator();
        while (it2.hasNext()) {
            if (TextUtils.equals(it2.next().f18709a, str)) {
                it2.remove();
            }
        }
    }

    /* renamed from: a */
    public synchronized Fallback m4766a(JSONObject jSONObject) {
        this.f18685a = jSONObject.optString("net");
        this.f18698n = jSONObject.getLong("ttl");
        this.f18696l = jSONObject.getDouble("pct");
        this.f18693i = jSONObject.getLong(DeviceInfo.TAG_TIMESTAMPS);
        this.f18688d = jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY);
        this.f18687c = jSONObject.optString("prv");
        this.f18691g = jSONObject.optString("cty");
        this.f18689e = jSONObject.optString("isp");
        this.f18690f = jSONObject.optString("ip");
        this.f18686b = jSONObject.optString("host");
        this.f18692h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            m4771a(new C4554c().m4732a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public ArrayList<String> m4770a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (!TextUtils.equals(url.getHost(), this.f18686b)) {
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it2 = mo4737a(true).iterator();
        while (it2.hasNext()) {
            Host m4755a = Host.m4755a(it2.next(), url.getPort());
            arrayList.add(new URL(url.getProtocol(), m4755a.m4754b(), m4755a.m4756a(), url.getFile()).toString());
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized ArrayList<String> mo4737a(boolean z) {
        ArrayList<String> arrayList;
        synchronized (this) {
            C4554c[] c4554cArr = new C4554c[this.f18694j.size()];
            this.f18694j.toArray(c4554cArr);
            Arrays.sort(c4554cArr);
            arrayList = new ArrayList<>();
            for (C4554c c4554c : c4554cArr) {
                if (z) {
                    arrayList.add(c4554c.f18709a);
                } else {
                    int indexOf = c4554c.f18709a.indexOf(":");
                    if (indexOf != -1) {
                        arrayList.add(c4554c.f18709a.substring(0, indexOf));
                    } else {
                        arrayList.add(c4554c.f18709a);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m4774a(double d) {
        this.f18696l = d;
    }

    /* renamed from: a */
    public void m4773a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("the duration is invalid " + j);
        }
        this.f18698n = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m4771a(C4554c c4554c) {
        m4760c(c4554c.f18709a);
        this.f18694j.add(c4554c);
    }

    /* renamed from: a */
    public void m4769a(String str, int i, long j, long j2, Exception exc) {
        mo4738a(str, new AccessHistory(i, j, j2, exc));
    }

    /* renamed from: a */
    public void m4768a(String str, long j, long j2) {
        try {
            m4763b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException e) {
        }
    }

    /* renamed from: a */
    public void m4767a(String str, long j, long j2, Exception exc) {
        try {
            m4762b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException e) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
        r0.m4734a(r5);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void mo4738a(String str, AccessHistory accessHistory) {
        Iterator<C4554c> it2 = this.f18694j.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            C4554c next = it2.next();
            if (TextUtils.equals(str, next.f18709a)) {
                break;
            }
        }
    }

    /* renamed from: a */
    public synchronized void m4765a(String[] strArr) {
        for (int size = this.f18694j.size() - 1; size >= 0; size--) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f18694j.get(size).f18709a, strArr[i])) {
                        this.f18694j.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
        Iterator<C4554c> it2 = this.f18694j.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            C4554c next = it2.next();
            i2 = next.f18710b > i2 ? next.f18710b : i2;
        }
        for (int i3 = 0; i3 < strArr.length; i3++) {
            m4771a(new C4554c(strArr[i3], (strArr.length + i2) - i3));
        }
    }

    /* renamed from: a */
    public boolean m4775a() {
        return TextUtils.equals(this.f18685a, HostManager.getInstance().getActiveNetworkLabel());
    }

    /* renamed from: a */
    public boolean m4772a(Fallback fallback) {
        return TextUtils.equals(this.f18685a, fallback.f18685a);
    }

    /* renamed from: b */
    public void m4764b(String str) {
        this.f18697m = str;
    }

    /* renamed from: b */
    public void m4763b(String str, long j, long j2) {
        m4769a(str, 0, j, j2, null);
    }

    /* renamed from: b */
    public void m4762b(String str, long j, long j2, Exception exc) {
        m4769a(str, -1, j, j2, exc);
    }

    /* renamed from: b */
    public boolean mo4736b() {
        return System.currentTimeMillis() - this.f18693i < this.f18698n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m4761c() {
        long j = 864000000;
        if (864000000 < this.f18698n) {
            j = this.f18698n;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.f18693i > j || (currentTimeMillis - this.f18693i > this.f18698n && this.f18685a.startsWith("WIFI-"));
    }

    /* renamed from: d */
    public synchronized ArrayList<String> m4759d() {
        return mo4737a(false);
    }

    /* renamed from: e */
    public synchronized String m4758e() {
        String str;
        if (!TextUtils.isEmpty(this.f18695k)) {
            str = this.f18695k;
        } else if (TextUtils.isEmpty(this.f18689e)) {
            str = "hardcode_isp";
        } else {
            this.f18695k = HostManager.join(new String[]{this.f18689e, this.f18687c, this.f18688d, this.f18691g, this.f18690f}, "_");
            str = this.f18695k;
        }
        return str;
    }

    /* renamed from: f */
    public synchronized JSONObject m4757f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f18685a);
        jSONObject.put("ttl", this.f18698n);
        jSONObject.put("pct", this.f18696l);
        jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.f18693i);
        jSONObject.put(DistrictSearchQuery.KEYWORDS_CITY, this.f18688d);
        jSONObject.put("prv", this.f18687c);
        jSONObject.put("cty", this.f18691g);
        jSONObject.put("isp", this.f18689e);
        jSONObject.put("ip", this.f18690f);
        jSONObject.put("host", this.f18686b);
        jSONObject.put("xf", this.f18692h);
        JSONArray jSONArray = new JSONArray();
        Iterator<C4554c> it2 = this.f18694j.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().m4735a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18685a);
        sb.append("\n");
        sb.append(m4758e());
        Iterator<C4554c> it2 = this.f18694j.iterator();
        while (it2.hasNext()) {
            sb.append("\n");
            sb.append(it2.next().toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
