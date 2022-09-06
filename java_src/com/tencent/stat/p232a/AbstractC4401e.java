package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.C4436n;
import com.tencent.stat.DeviceInfo;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.C4420k;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.e */
/* loaded from: classes2.dex */
public abstract class AbstractC4401e {

    /* renamed from: a */
    private static volatile boolean f18372a = false;

    /* renamed from: b */
    protected String f18373b;

    /* renamed from: d */
    protected int f18375d;

    /* renamed from: e */
    protected DeviceInfo f18376e;

    /* renamed from: f */
    protected int f18377f;

    /* renamed from: g */
    protected String f18378g;

    /* renamed from: h */
    protected String f18379h;

    /* renamed from: i */
    protected String f18380i;

    /* renamed from: k */
    protected Context f18382k;

    /* renamed from: j */
    protected String f18381j = null;

    /* renamed from: c */
    protected long f18374c = System.currentTimeMillis() / 1000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC4401e(Context context, int i) {
        this.f18373b = null;
        this.f18376e = null;
        this.f18378g = null;
        this.f18379h = null;
        this.f18380i = null;
        this.f18382k = context;
        this.f18375d = i;
        this.f18373b = StatConfig.getAppKey(context);
        this.f18378g = StatConfig.getCustomUserId(context);
        this.f18376e = C4436n.m5134a(context).m5121b(context);
        this.f18377f = C4420k.m5164w(context).intValue();
        this.f18380i = C4420k.m5173n(context);
        this.f18379h = StatConfig.getInstallChannel(context);
    }

    /* renamed from: a */
    public abstract EnumC4402f mo5242a();

    /* renamed from: a */
    public abstract boolean mo5241a(JSONObject jSONObject);

    /* renamed from: b */
    public long m5248b() {
        return this.f18374c;
    }

    /* renamed from: b */
    public boolean m5247b(JSONObject jSONObject) {
        try {
            C4420k.m5199a(jSONObject, "ky", this.f18373b);
            jSONObject.put("et", mo5242a().m5244a());
            if (this.f18376e != null) {
                jSONObject.put(DeviceInfo.TAG_IMEI, this.f18376e.getImei());
                C4420k.m5199a(jSONObject, DeviceInfo.TAG_MAC, this.f18376e.getMac());
                jSONObject.put("ut", this.f18376e.getUserType());
            }
            C4420k.m5199a(jSONObject, "cui", this.f18378g);
            if (mo5242a() != EnumC4402f.SESSION_ENV) {
                C4420k.m5199a(jSONObject, "av", this.f18380i);
                C4420k.m5199a(jSONObject, "ch", this.f18379h);
            }
            C4420k.m5199a(jSONObject, DeviceInfo.TAG_MID, StatConfig.getMid(this.f18382k));
            jSONObject.put("idx", this.f18377f);
            jSONObject.put("si", this.f18375d);
            jSONObject.put(DeviceInfo.TAG_TIMESTAMPS, this.f18374c);
            if (this.f18376e.getUserType() == 0 && C4420k.m5208E(this.f18382k) == 1) {
                jSONObject.put("ia", 1);
            }
            return mo5241a(jSONObject);
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: c */
    public Context m5246c() {
        return this.f18382k;
    }

    /* renamed from: d */
    public String m5245d() {
        try {
            JSONObject jSONObject = new JSONObject();
            m5247b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
