package com.tencent.stat.common;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.tencent.stat.common.a */
/* loaded from: classes2.dex */
public class C4410a {

    /* renamed from: a */
    static C4412c f18413a;

    /* renamed from: d */
    private static StatLogger f18414d = C4420k.m5197b();

    /* renamed from: e */
    private static JSONObject f18415e = null;

    /* renamed from: b */
    Integer f18416b;

    /* renamed from: c */
    String f18417c;

    public C4410a(Context context) {
        this.f18416b = null;
        this.f18417c = null;
        try {
            m5232a(context);
            this.f18416b = C4420k.m5170q(context.getApplicationContext());
            this.f18417c = C4420k.m5171p(context);
        } catch (Throwable th) {
            f18414d.m5236e(th);
        }
    }

    /* renamed from: a */
    static synchronized C4412c m5232a(Context context) {
        C4412c c4412c;
        synchronized (C4410a.class) {
            if (f18413a == null) {
                f18413a = new C4412c(context.getApplicationContext());
            }
            c4412c = f18413a;
        }
        return c4412c;
    }

    /* renamed from: a */
    public static void m5231a(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        if (f18415e == null) {
            f18415e = new JSONObject();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            f18415e.put((String) entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    public void m5230a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (f18413a != null) {
                f18413a.m5229a(jSONObject2);
            }
            C4420k.m5199a(jSONObject2, "cn", this.f18417c);
            if (this.f18416b != null) {
                jSONObject2.put("tn", this.f18416b);
            }
            jSONObject.put("ev", jSONObject2);
            if (f18415e == null || f18415e.length() <= 0) {
                return;
            }
            jSONObject.put("eva", f18415e);
        } catch (Throwable th) {
            f18414d.m5236e(th);
        }
    }
}
