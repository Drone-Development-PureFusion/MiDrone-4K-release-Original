package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p004b.p005a.p006a.p028b.p054o.AbstractC0517a;
/* renamed from: com.amap.api.mapcore.util.eu */
/* loaded from: classes.dex */
public class C0970eu extends AbstractC0968es<List<TraceLocation>, List<LatLng>> {

    /* renamed from: i */
    private List<TraceLocation> f3030i;

    public C0970eu(Context context, List<TraceLocation> list, int i) {
        super(context, list);
        this.f3030i = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.mapcore.util.AbstractC0967er
    /* renamed from: b */
    public List<LatLng> mo18188a(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("points");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.amap.api.mapcore.util.AbstractC0968es
    /* renamed from: f */
    protected String mo18186f() {
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f3030i.size()) {
                this.f3027e = c() + "&" + jSONArray.toString();
                return jSONArray.toString();
            }
            TraceLocation traceLocation = this.f3030i.get(i2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i2 == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - AbstractC0517a.f1169e) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                    j = time;
                } else if (time == 0 || time - j <= 0) {
                    jSONObject.put("tm", 1);
                    j = time;
                } else {
                    jSONObject.put("tm", (time - j) / 1000);
                    j = time;
                }
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
            i = i2 + 1;
        }
    }
}
