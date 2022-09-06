package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.C0977ez;
import com.tencent.open.GameAppOperation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.amap.api.mapcore.util.az */
/* loaded from: classes.dex */
public class C0801az extends AbstractC0861by<String, C0800ay> {

    /* renamed from: d */
    private final String f2183d = "update";

    /* renamed from: e */
    private final String f2184e = "1";

    /* renamed from: f */
    private final String f2185f = "0";

    /* renamed from: g */
    private final String f2186g = GameAppOperation.QQFAV_DATALINE_VERSION;

    public C0801az(Context context, String str) {
        super(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: a */
    public C0800ay mo18729b(JSONObject jSONObject) {
        C0800ay c0800ay = new C0800ay();
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("update", "");
            if (optString.equals("0")) {
                c0800ay.m18977a(false);
            } else if (optString.equals("1")) {
                c0800ay.m18977a(true);
            }
            c0800ay.m18978a(jSONObject.optString(GameAppOperation.QQFAV_DATALINE_VERSION, ""));
            return c0800ay;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "OfflineInitHandler", "loadData parseJson");
            return c0800ay;
        }
    }

    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: a */
    protected String mo18733a() {
        return "010";
    }

    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: a */
    protected JSONObject mo18731a(C0977ez.C0978a c0978a) {
        return c0978a.f3066o;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0861by
    /* renamed from: b */
    protected Map<String, String> mo18730b() {
        HashMap hashMap = new HashMap();
        hashMap.put("mapver", this.f2402a);
        return hashMap;
    }
}
