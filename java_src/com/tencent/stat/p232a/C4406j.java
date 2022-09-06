package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.stat.common.C4420k;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.j */
/* loaded from: classes2.dex */
public class C4406j extends AbstractC4401e {

    /* renamed from: a */
    Long f18400a;

    /* renamed from: l */
    String f18401l;

    /* renamed from: m */
    String f18402m;

    public C4406j(Context context, String str, String str2, int i, Long l) {
        super(context, i);
        this.f18400a = null;
        this.f18402m = str;
        this.f18401l = str2;
        this.f18400a = l;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.PAGE_VIEW;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        C4420k.m5199a(jSONObject, "pi", this.f18401l);
        C4420k.m5199a(jSONObject, "rf", this.f18402m);
        if (this.f18400a != null) {
            jSONObject.put("du", this.f18400a);
            return true;
        }
        return true;
    }
}
