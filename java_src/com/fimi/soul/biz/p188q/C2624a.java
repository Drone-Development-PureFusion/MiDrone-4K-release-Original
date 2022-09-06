package com.fimi.soul.biz.p188q;

import android.content.Context;
import com.fimi.kernel.utils.C2281x;
import com.fimi.soul.biz.p183l.AbstractC2538k;
import com.fimi.soul.biz.p185n.C2595s;
import com.fimi.soul.entity.FlyModeLog;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.C3658ar;
import com.fimi.soul.utils.C3705v;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.q.a */
/* loaded from: classes.dex */
public class C2624a {

    /* renamed from: c */
    private static C2624a f9093c = null;

    /* renamed from: a */
    private C2595s f9094a;

    /* renamed from: b */
    private Context f9095b;

    /* renamed from: d */
    private C3705v f9096d;

    private C2624a(Context context) {
        this.f9094a = C2595s.m11584a(context);
        this.f9095b = context;
        this.f9096d = C3705v.m7415a(this.f9095b);
    }

    /* renamed from: a */
    public static C2624a m11460a(Context context) {
        if (f9093c == null) {
            f9093c = new C2624a(context.getApplicationContext());
        }
        return f9093c;
    }

    /* renamed from: a */
    public void m11461a() {
        C2281x.m12702b(new Runnable() { // from class: com.fimi.soul.biz.q.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!C3658ar.m7601b(C2624a.this.f9095b)) {
                    return;
                }
                List<FlyModeLog> m7416a = C2624a.this.f9096d.m7416a();
                if (m7416a.size() <= 0) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                try {
                    for (FlyModeLog flyModeLog : m7416a) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("userID", flyModeLog.getUserID());
                        jSONObject.put("fcVersion", flyModeLog.getFcVersion());
                        jSONObject.put("openType", flyModeLog.getOpenType());
                        jSONObject.put("applyTime", flyModeLog.getInsertTime());
                        jSONObject.put("x2Version", flyModeLog.getX2Version());
                        jSONObject.put("appType", flyModeLog.getAppType());
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                C2624a.this.f9094a.m11582a(jSONArray.toString(), new AbstractC2538k() { // from class: com.fimi.soul.biz.q.a.2.1
                    @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                    /* renamed from: a */
                    public void mo6501a(PlaneMsg planeMsg, File file) {
                        if (planeMsg.isSuccess()) {
                            C2624a.this.f9096d.m7413b();
                        }
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public void m11458a(final FlyModeLog flyModeLog) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userID", flyModeLog.getUserID());
            jSONObject.put("fcVersion", flyModeLog.getFcVersion());
            jSONObject.put("openType", flyModeLog.getOpenType());
            jSONObject.put("applyTime", flyModeLog.getApplyTime());
            jSONObject.put("x2Version", flyModeLog.getX2Version());
            jSONObject.put("appType", flyModeLog.getAppType());
            jSONArray.put(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (C3658ar.m7601b(this.f9095b)) {
            this.f9094a.m11582a(jSONArray.toString(), new AbstractC2538k() { // from class: com.fimi.soul.biz.q.a.1
                @Override // com.fimi.soul.biz.p183l.AbstractC2538k
                /* renamed from: a */
                public void mo6501a(PlaneMsg planeMsg, File file) {
                    if (!planeMsg.isSuccess()) {
                        C2624a.this.f9096d.m7414a(flyModeLog);
                    }
                }
            });
        } else {
            this.f9096d.m7414a(flyModeLog);
        }
    }
}
