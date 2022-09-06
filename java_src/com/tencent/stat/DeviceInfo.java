package com.tencent.stat;

import com.tencent.stat.common.C4420k;
import com.tencent.stat.common.StatLogger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class DeviceInfo {
    public static final int NEW_USER = 0;
    public static final int OLD_USER = 1;
    public static final String TAG_ANDROID_ID = "aid";
    public static final String TAG_FLAG = "__MTA_DEVICE_INFO__";
    public static final String TAG_IMEI = "ui";
    public static final String TAG_MAC = "mc";
    public static final String TAG_MID = "mid";
    public static final String TAG_TIMESTAMPS = "ts";
    public static final String TAG_VERSION = "ver";
    public static final int UPGRADE_USER = 2;

    /* renamed from: h */
    private static StatLogger f18284h = C4420k.m5197b();

    /* renamed from: a */
    private String f18285a;

    /* renamed from: b */
    private String f18286b;

    /* renamed from: c */
    private String f18287c;

    /* renamed from: d */
    private String f18288d;

    /* renamed from: e */
    private int f18289e;

    /* renamed from: f */
    private int f18290f;

    /* renamed from: g */
    private long f18291g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceInfo() {
        this.f18285a = null;
        this.f18286b = null;
        this.f18287c = null;
        this.f18288d = "0";
        this.f18290f = 0;
        this.f18291g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceInfo(String str, String str2, int i) {
        this.f18285a = null;
        this.f18286b = null;
        this.f18287c = null;
        this.f18288d = "0";
        this.f18290f = 0;
        this.f18291g = 0L;
        this.f18285a = str;
        this.f18286b = str2;
        this.f18289e = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static DeviceInfo m5308a(String str) {
        DeviceInfo deviceInfo = new DeviceInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TAG_IMEI)) {
                deviceInfo.m5302d(jSONObject.getString(TAG_IMEI));
            }
            if (!jSONObject.isNull(TAG_MAC)) {
                deviceInfo.m5301e(jSONObject.getString(TAG_MAC));
            }
            if (!jSONObject.isNull(TAG_MID)) {
                deviceInfo.m5303c(jSONObject.getString(TAG_MID));
            }
            if (!jSONObject.isNull(TAG_ANDROID_ID)) {
                deviceInfo.m5305b(jSONObject.getString(TAG_ANDROID_ID));
            }
            if (!jSONObject.isNull(TAG_TIMESTAMPS)) {
                deviceInfo.m5310a(jSONObject.getLong(TAG_TIMESTAMPS));
            }
            if (!jSONObject.isNull(TAG_VERSION)) {
                deviceInfo.m5311a(jSONObject.getInt(TAG_VERSION));
            }
        } catch (JSONException e) {
            f18284h.m5237e((Exception) e);
        }
        return deviceInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m5312a() {
        return this.f18290f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m5309a(DeviceInfo deviceInfo) {
        if (deviceInfo == null) {
            return 1;
        }
        String mid = getMid();
        String mid2 = deviceInfo.getMid();
        if (mid != null && mid2 != null && mid.equals(mid2)) {
            return 0;
        }
        int m5312a = m5312a();
        int m5312a2 = deviceInfo.m5312a();
        if (m5312a > m5312a2) {
            return 1;
        }
        if (m5312a != m5312a2) {
            return -1;
        }
        long m5307b = m5307b();
        long m5307b2 = deviceInfo.m5307b();
        if (m5307b > m5307b2) {
            return 1;
        }
        return m5307b == m5307b2 ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5311a(int i) {
        this.f18290f = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m5310a(long j) {
        this.f18291g = j;
    }

    /* renamed from: b */
    long m5307b() {
        return this.f18291g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m5306b(int i) {
        this.f18289e = i;
    }

    /* renamed from: b */
    void m5305b(String str) {
        this.f18287c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public JSONObject m5304c() {
        JSONObject jSONObject = new JSONObject();
        try {
            C4420k.m5199a(jSONObject, TAG_IMEI, this.f18285a);
            C4420k.m5199a(jSONObject, TAG_MAC, this.f18286b);
            C4420k.m5199a(jSONObject, TAG_MID, this.f18288d);
            C4420k.m5199a(jSONObject, TAG_ANDROID_ID, this.f18287c);
            jSONObject.put(TAG_TIMESTAMPS, this.f18291g);
            jSONObject.put(TAG_VERSION, this.f18290f);
        } catch (JSONException e) {
            f18284h.m5237e((Exception) e);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m5303c(String str) {
        this.f18288d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m5302d(String str) {
        this.f18285a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m5301e(String str) {
        this.f18286b = str;
    }

    public String getImei() {
        return this.f18285a;
    }

    public String getMac() {
        return this.f18286b;
    }

    public String getMid() {
        return this.f18288d;
    }

    public int getUserType() {
        return this.f18289e;
    }

    public String toString() {
        return m5304c().toString();
    }
}
