package com.tencent.stat.p232a;

import android.content.Context;
import com.tencent.p227mm.sdk.platformtools.LocaleUtil;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.a.b */
/* loaded from: classes2.dex */
public class C4398b extends AbstractC4401e {

    /* renamed from: a */
    protected C4399c f18364a = new C4399c();

    /* renamed from: l */
    private long f18365l = -1;

    public C4398b(Context context, int i, String str) {
        super(context, i);
        this.f18364a.f18366a = str;
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public EnumC4402f mo5242a() {
        return EnumC4402f.CUSTOM;
    }

    /* renamed from: a */
    public void m5252a(long j) {
        this.f18365l = j;
    }

    /* renamed from: a */
    public void m5251a(Properties properties) {
        if (properties != null) {
            this.f18364a.f18368c = (Properties) properties.clone();
        }
    }

    /* renamed from: a */
    public void m5250a(String[] strArr) {
        if (strArr != null) {
            this.f18364a.f18367b = (String[]) strArr.clone();
        }
    }

    @Override // com.tencent.stat.p232a.AbstractC4401e
    /* renamed from: a */
    public boolean mo5241a(JSONObject jSONObject) {
        Object jSONObject2;
        jSONObject.put("ei", this.f18364a.f18366a);
        if (this.f18365l > 0) {
            jSONObject.put("du", this.f18365l);
        }
        if (this.f18364a.f18368c == null && this.f18364a.f18367b == null) {
            jSONObject.put("kv", new JSONObject());
        }
        if (this.f18364a.f18367b != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.f18364a.f18367b) {
                jSONArray.put(str);
            }
            jSONObject.put(LocaleUtil.ARABIC, jSONArray);
        }
        if (this.f18364a.f18368c != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                for (Map.Entry entry : this.f18364a.f18368c.entrySet()) {
                    jSONObject3.put(entry.getKey().toString(), entry.getValue().toString());
                }
                jSONObject2 = jSONObject3;
            } catch (Exception e) {
                jSONObject2 = new JSONObject(this.f18364a.f18368c);
            }
            jSONObject.put("kv", jSONObject2);
            return true;
        }
        return true;
    }
}
