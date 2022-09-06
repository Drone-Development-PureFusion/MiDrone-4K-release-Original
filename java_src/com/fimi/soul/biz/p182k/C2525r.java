package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2541n;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.SumFlyDataByMonth;
import com.fimi.soul.entity.UpdateDroneItem;
import com.fimi.soul.entity.UpdatePlannerBackdata;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.NetUtil;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.r */
/* loaded from: classes.dex */
public class C2525r implements AbstractC2541n {
    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2541n
    /* renamed from: a */
    public PlaneMsg mo11765a(UpdateDroneItem updateDroneItem, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addPlaneAction"));
        arrayList.add(new BasicNameValuePair("flyJourney", updateDroneItem.getDistance() + ""));
        arrayList.add(new BasicNameValuePair("flyTimeSum", updateDroneItem.getSportTime() + ""));
        arrayList.add(new BasicNameValuePair("flyFileUrl", updateDroneItem.getUploadurl()));
        arrayList.add(new BasicNameValuePair("planeID", updateDroneItem.getPlaneID() == null ? "123" : updateDroneItem.getPlaneID()));
        arrayList.add(new BasicNameValuePair("userID", C2353b.m12507c(context).getUserID()));
        arrayList.add(new BasicNameValuePair("startDate", updateDroneItem.getRecord_time()));
        arrayList.add(new BasicNameValuePair("endDate", updateDroneItem.getEndddata()));
        arrayList.add(new BasicNameValuePair("year", updateDroneItem.getYear() + ""));
        arrayList.add(new BasicNameValuePair("month", updateDroneItem.getMonth() + ""));
        arrayList.add(new BasicNameValuePair("maxHight", updateDroneItem.getMaxhight() + ""));
        arrayList.add(new BasicNameValuePair("latitude", updateDroneItem.getLatitude() + ""));
        arrayList.add(new BasicNameValuePair("latitude", updateDroneItem.getLongitude() + ""));
        arrayList.add(new BasicNameValuePair("fcType ", updateDroneItem.getFcType()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData((UpdatePlannerBackdata) C3638ah.m7703b(UpdatePlannerBackdata.class, jSONObject.get("data").toString()));
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

    @Override // com.fimi.soul.biz.p183l.AbstractC2541n
    /* renamed from: a */
    public PlaneMsg mo11764a(String str, String str2, int i, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getPlaneActionListByMonth"));
        arrayList.add(new BasicNameValuePair("userID", str));
        arrayList.add(new BasicNameValuePair("monthDate", str2));
        arrayList.add(new BasicNameValuePair("curPage", "1"));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            ArrayList m7706a = C3638ah.m7706a(UpdatePlannerBackdata[].class, jSONObject.get("data").toString());
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(m7706a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2541n
    /* renamed from: b */
    public PlaneMsg mo11763b(UpdateDroneItem updateDroneItem, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "delPlaneActoin"));
        arrayList.add(new BasicNameValuePair("planeActionID", updateDroneItem.getFlag() + ""));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
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

    @Override // com.fimi.soul.biz.p183l.AbstractC2541n
    /* renamed from: c */
    public PlaneMsg mo11762c(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addPlaneActionList"));
        arrayList.add(new BasicNameValuePair("jsonContent", str));
        String m7767a = NetUtil.m7767a(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7767a);
            ArrayList m7706a = C3638ah.m7706a(UpdatePlannerBackdata[].class, jSONObject.get("data").toString());
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(m7706a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2541n
    /* renamed from: d */
    public PlaneMsg mo11761d(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getPlaneActionListByUserID"));
        arrayList.add(new BasicNameValuePair("userID", str));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            ArrayList m7706a = C3638ah.m7706a(UpdatePlannerBackdata[].class, jSONObject.get("data").toString());
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(m7706a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2541n
    /* renamed from: e */
    public PlaneMsg mo11760e(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "sumFlyDataByMonth"));
        arrayList.add(new BasicNameValuePair("userID", str));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            ArrayList m7706a = C3638ah.m7706a(SumFlyDataByMonth[].class, jSONObject.get("data").toString());
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(m7706a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planeMsg;
    }
}
