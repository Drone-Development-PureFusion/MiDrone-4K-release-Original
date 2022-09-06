package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.i */
/* loaded from: classes2.dex */
public class C4405i extends AbstractC4401e {

    /* renamed from: a */
    private static String f18397a = null;

    /* renamed from: l */
    private String f18398l;

    /* renamed from: m */
    private String f18399m = null;

    public C4405i(Context context, int i) {
        super(context, i);
        this.f18398l = null;
        this.f18398l = C4420k.m5171p(context);
        if (f18397a == null) {
            f18397a = C4420k.m5174m(context);
        }
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.NETWORK_MONITOR;
    }

    /* renamed from: a */
    public void m5243a(String str) {
        this.f18399m = str;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        C4420k.m5199a(jSONObject, "op", f18397a);
        C4420k.m5199a(jSONObject, "cn", this.f18398l);
        jSONObject.put("sp", this.f18399m);
        return true;
    }
}
