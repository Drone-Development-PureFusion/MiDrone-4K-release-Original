package com.tencent.stat;

import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class NetworkMonitor {

    /* renamed from: a */
    private long f18292a = 0;

    /* renamed from: b */
    private int f18293b = 0;

    /* renamed from: c */
    private String f18294c = "";

    /* renamed from: d */
    private int f18295d = 0;

    /* renamed from: e */
    private String f18296e = "";

    public String getDomain() {
        return this.f18294c;
    }

    public long getMillisecondsConsume() {
        return this.f18292a;
    }

    public int getPort() {
        return this.f18295d;
    }

    public String getRemoteIp() {
        return this.f18296e;
    }

    public int getStatusCode() {
        return this.f18293b;
    }

    public void setDomain(String str) {
        this.f18294c = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f18292a = j;
    }

    public void setPort(int i) {
        this.f18295d = i;
    }

    public void setRemoteIp(String str) {
        this.f18296e = str;
    }

    public void setStatusCode(int i) {
        this.f18293b = i;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f18292a);
            jSONObject.put("st", this.f18293b);
            if (this.f18294c != null) {
                jSONObject.put("dm", this.f18294c);
            }
            jSONObject.put(LocaleUtil.PORTUGUESE, this.f18295d);
            if (this.f18296e != null) {
                jSONObject.put("rip", this.f18296e);
            }
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
