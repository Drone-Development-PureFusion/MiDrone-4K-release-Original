package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2528a;
import com.fimi.soul.entity.AddPlane;
import com.fimi.soul.entity.AddPlaneback;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.NetUtil;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.a */
/* loaded from: classes.dex */
public class C2507a implements AbstractC2528a {
    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2528a
    /* renamed from: a */
    public PlaneMsg mo11797a(AddPlane addPlane, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addPlane"));
        arrayList.add(new BasicNameValuePair("userID", addPlane.getUserID() + ""));
        arrayList.add(new BasicNameValuePair("cloud_deck_ID", addPlane.getCloud_deck_ID() == null ? "" : addPlane.getCloud_deck_ID()));
        arrayList.add(new BasicNameValuePair("receiver_control_ID", addPlane.getReceiver_control_ID()));
        arrayList.add(new BasicNameValuePair("fly_control_ID", addPlane.getFly_control_ID()));
        arrayList.add(new BasicNameValuePair("remote_control_ID", addPlane.getRemote_control_ID()));
        arrayList.add(new BasicNameValuePair("charge_count", addPlane.getCharge_count() + ""));
        arrayList.add(new BasicNameValuePair("note", addPlane.getNote() == null ? "" : addPlane.getNote()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setData((AddPlaneback) C3638ah.m7703b(AddPlaneback.class, jSONObject.getJSONObject("data").toString()));
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return planeMsg;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11796a(String str, Context context) {
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: b */
    public boolean mo11795b(String str, Context context) {
        return false;
    }
}
