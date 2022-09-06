package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.common.C4410a;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.k */
/* loaded from: classes2.dex */
public class C4407k extends AbstractC4401e {

    /* renamed from: a */
    private C4410a f18403a;

    /* renamed from: l */
    private JSONObject f18404l;

    public C4407k(Context context, int i, JSONObject jSONObject) {
        super(context, i);
        this.f18404l = null;
        this.f18403a = new C4410a(context);
        this.f18404l = jSONObject;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.SESSION_ENV;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        if (this.f18376e != null) {
            jSONObject.put("ut", this.f18376e.getUserType());
        }
        if (this.f18404l != null) {
            jSONObject.put("cfg", this.f18404l);
        }
        this.f18403a.m5230a(jSONObject);
        return true;
    }
}
