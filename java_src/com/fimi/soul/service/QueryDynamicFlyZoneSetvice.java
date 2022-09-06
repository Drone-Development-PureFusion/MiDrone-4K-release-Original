package com.fimi.soul.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.base.DroidPlannerApp;
import com.fimi.soul.biz.p181j.C2496e;
import com.fimi.soul.drone.C2678d;
import com.fimi.soul.entity.DynamicDYZ_Entity;
import com.fimi.soul.entity.User;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.C3684m;
import com.fimi.soul.utils.NetUtil;
import com.tencent.open.GameAppOperation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QueryDynamicFlyZoneSetvice extends IntentService {
    public QueryDynamicFlyZoneSetvice() {
        super("QueryDynamicFlyZoneSetvice");
    }

    public QueryDynamicFlyZoneSetvice(String str) {
        super(str);
    }

    /* renamed from: a */
    public static void m7809a(Context context) {
        if (!InitAppService.m7830a()) {
            return;
        }
        context.startService(new Intent(context, QueryDynamicFlyZoneSetvice.class));
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(@Nullable Intent intent) {
        List<DynamicDYZ_Entity> m7450a = C3684m.m7449a(getApplicationContext()).m7450a(1, new Date().getTime());
        if (m7450a != null && m7450a.size() > 0) {
            m7450a.get(0).getCurrentVersion();
        }
        C2496e m11922a = C2496e.m11922a();
        if (m11922a.m11919b() == C2496e.EnumC2497a.IDEL) {
            m11922a.m11920a(C2496e.EnumC2497a.QUERY);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("commandCode", "getDynamicDNZ"));
            User m12507c = C2353b.m12507c(this);
            if (m12507c == null) {
                return;
            }
            arrayList.add(new BasicNameValuePair("userID", m12507c.getUserID()));
            String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, this);
            try {
                DroidPlannerApp droidPlannerApp = (DroidPlannerApp) getApplication();
                JSONObject jSONObject = new JSONObject(m7762b);
                if (!jSONObject.getBoolean("success")) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(jSONObject.get("data").toString());
                double d = jSONObject2.getDouble(GameAppOperation.QQFAV_DATALINE_VERSION);
                m11922a.m11921a(d);
                JSONArray jSONArray = new JSONArray(jSONObject2.get("list").toString());
                new Date().getTime();
                if (jSONArray == null) {
                    return;
                }
                if (jSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DynamicDYZ_Entity dynamicDYZ_Entity = (DynamicDYZ_Entity) C3638ah.m7703b(DynamicDYZ_Entity.class, jSONArray.getJSONObject(i).toString());
                        if (dynamicDYZ_Entity.getDeviceType() == 1) {
                            dynamicDYZ_Entity.setCurrentVersion(d);
                            arrayList2.add(dynamicDYZ_Entity);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        C3684m.m7449a(getApplicationContext()).m7447a(arrayList2);
                    } else {
                        C3684m.m7449a(getApplicationContext()).m7451a();
                    }
                } else {
                    C3684m.m7449a(getApplicationContext()).m7451a();
                }
                droidPlannerApp.f7895a.mo11220a(C2678d.EnumC2679a.QUERYDYNAMICDATA);
            } catch (Exception e) {
            }
        }
    }
}
