package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.C4420k;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.a */
/* loaded from: classes2.dex */
public class C4397a extends AbstractC4401e {

    /* renamed from: a */
    Map<String, ?> f18363a;

    public C4397a(Context context, int i, Map<String, ?> map) {
        super(context, i);
        this.f18363a = null;
        this.f18363a = map;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.ADDITION;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        C4420k.m5199a(jSONObject, "qq", StatConfig.getQQ());
        if (this.f18363a == null || this.f18363a.size() <= 0) {
            return true;
        }
        for (Map.Entry<String, ?> entry : this.f18363a.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return true;
    }
}
