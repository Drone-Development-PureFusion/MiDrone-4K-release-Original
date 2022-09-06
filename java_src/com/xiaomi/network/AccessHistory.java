package com.xiaomi.network;

import com.tencent.stat.DeviceInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AccessHistory {

    /* renamed from: a */
    private int f18680a;

    /* renamed from: b */
    private long f18681b;

    /* renamed from: c */
    private long f18682c;

    /* renamed from: d */
    private String f18683d;

    /* renamed from: e */
    private long f18684e;

    public AccessHistory() {
        this(0, 0L, 0L, null);
    }

    public AccessHistory(int i, long j, long j2, Exception exc) {
        this.f18680a = i;
        this.f18681b = j;
        this.f18684e = j2;
        this.f18682c = System.currentTimeMillis();
        if (exc != null) {
            this.f18683d = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a */
    public int m4778a() {
        return this.f18680a;
    }

    /* renamed from: a */
    public AccessHistory m4777a(JSONObject jSONObject) {
        this.f18681b = jSONObject.getLong("cost");
        this.f18684e = jSONObject.getLong("size");
        this.f18682c = jSONObject.getLong(DeviceInfo.TAG_TIMESTAMPS);
        this.f18680a = jSONObject.getInt("wt");
        this.f18683d = jSONObject.optString("expt");
        return this;
    }

    /* renamed from: b */
    public JSONObject m4776b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f18681b);
        jSONObject.put("size", this.f18684e);
        jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.f18682c);
        jSONObject.put("wt", this.f18680a);
        jSONObject.put("expt", this.f18683d);
        return jSONObject;
    }
}
