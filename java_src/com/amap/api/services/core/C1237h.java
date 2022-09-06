package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.amap.api.services.core.h */
/* loaded from: classes.dex */
public class C1237h extends AbstractC1254r<C1238i, ArrayList<Tip>> {
    public C1237h(Context context, C1238i c1238i) {
        super(context, c1238i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a */
    public ArrayList<Tip> mo16811b(String str) {
        try {
            return C1239j.m16973o(new JSONObject(str));
        } catch (JSONException e) {
            C1233d.m17031a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.services.core.AbstractC1254r
    /* renamed from: a_ */
    protected String mo16814a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&keywords=").append(c(((C1238i) this.f4183a).f4156a));
        String str = ((C1238i) this.f4183a).f4157b;
        if (!C1239j.m16985h(str)) {
            stringBuffer.append("&city=").append(c(str));
        }
        stringBuffer.append("&key=").append(C1259w.m16920f(this.f4186d));
        stringBuffer.append("&language=").append(C1232c.m17036b());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.services.core.AbstractC1227bt
    /* renamed from: b */
    public String mo16813b() {
        return C1232c.m17038a() + "/assistant/inputtips?";
    }
}
