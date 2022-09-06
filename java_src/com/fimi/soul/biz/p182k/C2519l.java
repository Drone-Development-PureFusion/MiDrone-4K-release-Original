package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2536i;
import com.fimi.soul.entity.Plane;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.User;
import com.fimi.soul.utils.C3638ah;
import com.fimi.soul.utils.NetUtil;
import com.tencent.open.GameAppOperation;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.l */
/* loaded from: classes.dex */
public class C2519l implements AbstractC2536i {
    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getAllPlane"));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            ArrayList m7706a = C3638ah.m7706a(Plane[].class, jSONObject.getJSONArray("data").toString());
            planeMsg.setCommandCode(string2);
            planeMsg.setData(m7706a);
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

    @Override // com.fimi.soul.biz.p183l.AbstractC2536i
    /* renamed from: a */
    public PlaneMsg mo11773a(Plane plane, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addPlane"));
        arrayList.add(new BasicNameValuePair(GameAppOperation.QQFAV_DATALINE_VERSION, plane.getVersion()));
        arrayList.add(new BasicNameValuePair("flyControlID", plane.getFlyControlID()));
        arrayList.add(new BasicNameValuePair("rcIC", plane.getRcIC()));
        arrayList.add(new BasicNameValuePair("userId", plane.getUser().getUserIDs() + ""));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            planeMsg.setCommandCode(string2);
            planeMsg.setData((User) C3638ah.m7703b(User.class, jSONObject.getJSONObject("data").toString()));
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
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getPlaneById"));
        arrayList.add(new BasicNameValuePair("planeid", str));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                String jSONObject2 = jSONObject.getJSONObject("data").toString();
                planeMsg.setData((Plane) C3638ah.m7703b(Plane.class, jSONObject2));
                m7762b = jSONObject2;
            }
            planeMsg.setCommandCode(string2);
            planeMsg.setData((User) C3638ah.m7703b(User.class, m7762b));
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
    /* renamed from: b */
    public boolean mo11795b(String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "delPlaneById"));
        arrayList.add(new BasicNameValuePair("planeid", str));
        try {
            return new JSONObject(NetUtil.m7762b(C2353b.f7951i, arrayList, context)).getBoolean("success");
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
