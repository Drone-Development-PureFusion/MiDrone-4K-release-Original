package com.fimi.soul.biz.p169b;

import android.content.Context;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2595s;
import com.fimi.soul.entity.BatteryOverDischange;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3674d;
import com.tencent.open.GameAppOperation;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.b.a */
/* loaded from: classes.dex */
public class C2370a {

    /* renamed from: a */
    private C3674d f8030a;

    /* renamed from: b */
    private Context f8031b;

    /* renamed from: c */
    private C2595s f8032c;

    public C2370a(Context context) {
        this.f8031b = context;
        this.f8030a = C3674d.m7498a(this.f8031b);
        this.f8032c = C2595s.m11584a(this.f8031b);
    }

    /* renamed from: a */
    public void m12431a() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (!C3658ar.m7601b(C2370a.this.f8031b)) {
                    return;
                }
                List<BatteryOverDischange> m7499a = C2370a.this.f8030a.m7499a();
                if (m7499a.size() <= 0) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                try {
                    for (BatteryOverDischange batteryOverDischange : m7499a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("userID", batteryOverDischange.getUserId());
                        jSONObject.put("batteryId", batteryOverDischange.getBatteryId());
                        jSONObject.put("battery_level", batteryOverDischange.getBatteryLevel());
                        jSONObject.put("voltage", batteryOverDischange.getVoltage());
                        jSONObject.put("battery_current", batteryOverDischange.getBatteryCurrent());
                        jSONObject.put("temperature", batteryOverDischange.getTemperature());
                        jSONObject.put("battery_full", batteryOverDischange.getBatteryFull());
                        jSONObject.put("battery_one", batteryOverDischange.getBatteryOne());
                        jSONObject.put("battery_two", batteryOverDischange.getBatteryTwo());
                        jSONObject.put("battery_three", batteryOverDischange.getBatteryThree());
                        jSONObject.put("battery_four", batteryOverDischange.getBatteryFour());
                        jSONObject.put("battery_recyle", batteryOverDischange.getBatteryRecyle());
                        jSONObject.put(GameAppOperation.QQFAV_DATALINE_VERSION, batteryOverDischange.getVersion());
                        jSONObject.put("appType", batteryOverDischange.getAppType());
                        jSONObject.put("accidentType", batteryOverDischange.getAccidentType());
                        jSONObject.put("updateTimes", batteryOverDischange.getUpdateTimes());
                        jSONObject.put("curElectric ", batteryOverDischange.getCurElectric());
                        jSONObject.put("fcVersion", batteryOverDischange.getFcVersion());
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                C2370a.this.f8032c.m11580b(jSONArray.toString(), new AbstractC2538k() { // from class: com.fimi.soul.biz.b.a.1.1
                    @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                    /* renamed from: a */
                    public void mo6501a(PlaneMsg planeMsg, File file) {
                        if (planeMsg.isSuccess()) {
                            C2370a.this.f8030a.m7496b();
                        }
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void m12429a(final BatteryOverDischange batteryOverDischange) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userID", batteryOverDischange.getUserId());
            jSONObject.put("batteryId", batteryOverDischange.getBatteryId());
            jSONObject.put("battery_level", batteryOverDischange.getBatteryLevel());
            jSONObject.put("voltage", batteryOverDischange.getVoltage());
            jSONObject.put("battery_current", batteryOverDischange.getBatteryCurrent());
            jSONObject.put("temperature", batteryOverDischange.getTemperature());
            jSONObject.put("battery_full", batteryOverDischange.getBatteryFull());
            jSONObject.put("battery_one", batteryOverDischange.getBatteryOne());
            jSONObject.put("battery_two", batteryOverDischange.getBatteryTwo());
            jSONObject.put("battery_three", batteryOverDischange.getBatteryThree());
            jSONObject.put("battery_four", batteryOverDischange.getBatteryFour());
            jSONObject.put("battery_recyle", batteryOverDischange.getBatteryRecyle());
            jSONObject.put(GameAppOperation.QQFAV_DATALINE_VERSION, batteryOverDischange.getVersion());
            jSONObject.put("appType", batteryOverDischange.getAppType());
            jSONObject.put("accidentType", batteryOverDischange.getAccidentType());
            jSONObject.put("updateTimes", batteryOverDischange.getUpdateTimes());
            jSONObject.put("curElectric ", batteryOverDischange.getCurElectric());
            jSONObject.put("fcVersion", batteryOverDischange.getFcVersion());
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (C3658ar.m7601b(this.f8031b)) {
            this.f8032c.m11580b(jSONArray.toString(), new AbstractC2538k() { // from class: com.fimi.soul.biz.b.a.2
                @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                /* renamed from: a */
                public void mo6501a(PlaneMsg planeMsg, File file) {
                    if (planeMsg.isSuccess()) {
                        return;
                    }
                    C2370a.this.f8030a.m7497a(batteryOverDischange);
                }
            });
        } else {
            this.f8030a.m7497a(batteryOverDischange);
        }
    }
}
