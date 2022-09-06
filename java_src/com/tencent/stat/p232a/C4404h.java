package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.StatAppMonitor;
import com.tencent.stat.common.C4420k;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.h */
/* loaded from: classes2.dex */
public class C4404h extends AbstractC4401e {

    /* renamed from: l */
    private static String f18394l = null;

    /* renamed from: m */
    private static String f18395m = null;

    /* renamed from: a */
    private StatAppMonitor f18396a;

    public C4404h(Context context, int i, StatAppMonitor statAppMonitor) {
        super(context, i);
        this.f18396a = null;
        this.f18396a = statAppMonitor.m21864clone();
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.MONITOR_STAT;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        if (this.f18396a == null) {
            return false;
        }
        jSONObject.put("na", this.f18396a.getInterfaceName());
        jSONObject.put("rq", this.f18396a.getReqSize());
        jSONObject.put("rp", this.f18396a.getRespSize());
        jSONObject.put("rt", this.f18396a.getResultType());
        jSONObject.put("tm", this.f18396a.getMillisecondsConsume());
        jSONObject.put("rc", this.f18396a.getReturnCode());
        jSONObject.put("sp", this.f18396a.getSampling());
        if (f18395m == null) {
            f18395m = C4420k.m5169r(this.f18382k);
        }
        C4420k.m5199a(jSONObject, "av", f18395m);
        if (f18394l == null) {
            f18394l = C4420k.m5174m(this.f18382k);
        }
        C4420k.m5199a(jSONObject, "op", f18394l);
        jSONObject.put("cn", C4420k.m5171p(this.f18382k));
        return true;
    }
}
