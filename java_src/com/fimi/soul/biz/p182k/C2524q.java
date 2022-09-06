package com.fimi.soul.biz.p182k;

import android.content.Context;
import android.text.TextUtils;
import com.fimi.kernel.C2238c;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2544q;
import com.fimi.soul.entity.AppVersion;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.UpdateVersonBean;
import com.fimi.soul.entity.UpgradeResultInfo;
import com.fimi.soul.entity.User;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.NetUtil;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.q */
/* loaded from: classes.dex */
public class C2524q implements AbstractC2544q {
    @Override // com.fimi.soul.biz.p183l.AbstractC2544q, com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getDeviceNewVersion"));
        String m7766a = NetUtil.m7766a(C2353b.f7951i, arrayList, context, false);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7766a);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            ArrayList m7706a = C3638ah.m7706a(UpdateVersonBean[].class, jSONObject.getJSONArray("data").toString());
            planeMsg.setCommandCode(string2);
            planeMsg.setData(m7706a);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2544q
    /* renamed from: a */
    public PlaneMsg mo11738a(Context context, UpgradeResultInfo upgradeResultInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "commitDeviceVersion"));
        arrayList.add(new BasicNameValuePair("userID", upgradeResultInfo.getUserID()));
        arrayList.add(new BasicNameValuePair("jsonStr", upgradeResultInfo.getJsonStr()));
        String m7766a = NetUtil.m7766a(C2353b.f7951i, arrayList, context, false);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7766a);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("errorMessage");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(jSONObject.getString("commandCode"));
            planeMsg.setErrorCode(string2);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2544q
    /* renamed from: a */
    public PlaneMsg mo11737a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getVersionContent"));
        arrayList.add(new BasicNameValuePair("appversion", str));
        String m7766a = NetUtil.m7766a(C2353b.f7951i, arrayList, context, false);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7766a);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("errorMessage");
            boolean z = jSONObject.getBoolean("success");
            String string3 = jSONObject.getString("commandCode");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData((AppVersion) C3638ah.m7703b(AppVersion.class, jSONObject.getJSONObject("data").toString()));
            }
            planeMsg.setCommandCode(string3);
            planeMsg.setErrorCode(string2);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11796a(String str, Context context) {
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2544q
    /* renamed from: b */
    public PlaneMsg mo11736b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getDeviceNewVersion"));
        User m12507c = C2353b.m12507c(C2238c.m13131a());
        if (m12507c != null && !TextUtils.isEmpty(m12507c.getUserID())) {
            arrayList.add(new BasicNameValuePair("userID", m12507c.getUserID()));
        }
        String m7766a = NetUtil.m7766a(C2353b.f7951i, arrayList, context, false);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7766a);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            String string3 = jSONObject.getString("commandCode");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData(C3638ah.m7706a(UpdateVersonBean[].class, jSONObject.getJSONArray("data").toString()));
            }
            planeMsg.setCommandCode(string3);
            planeMsg.setErrorCode(string2);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: b */
    public boolean mo11795b(String str, Context context) {
        return false;
    }
}
