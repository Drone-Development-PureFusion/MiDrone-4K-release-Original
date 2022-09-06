package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2534g;
import com.fimi.soul.entity.HomePage;
import com.fimi.soul.entity.PageHomeIndexImage;
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
/* renamed from: com.fimi.soul.biz.k.j */
/* loaded from: classes.dex */
public class C2517j implements AbstractC2534g {
    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2534g
    /* renamed from: a */
    public PlaneMsg mo11777a(HomePage homePage, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getBroadCastNumber"));
        arrayList.add(new BasicNameValuePair("userID", homePage.getUserID()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData((HomePage) C3638ah.m7703b(HomePage.class, jSONObject.getJSONObject("data").toString()));
            }
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

    @Override // com.fimi.soul.biz.p183l.AbstractC2534g
    /* renamed from: b */
    public PlaneMsg mo11776b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getIndexImages"));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData(C3638ah.m7706a(PageHomeIndexImage[].class, jSONObject.getJSONArray("data").toString()));
            }
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

    @Override // com.fimi.soul.biz.p183l.AbstractC2534g
    /* renamed from: b */
    public PlaneMsg mo11775b(HomePage homePage, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "getUserByUserId"));
        arrayList.add(new BasicNameValuePair("userID", homePage.getUserID()));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            if (!jSONObject.isNull("data")) {
                planeMsg.setData((HomePage) C3638ah.m7703b(HomePage.class, jSONObject.getJSONObject("data").toString()));
            }
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
    /* renamed from: b */
    public boolean mo11795b(String str, Context context) {
        return false;
    }
}
