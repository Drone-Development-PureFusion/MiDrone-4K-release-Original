package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2535h;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.entity.User;
import com.fimi.soul.module.update.p210a.C3579a;
import com.fimi.soul.utils.NetUtil;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.k */
/* loaded from: classes.dex */
public class C2518k implements AbstractC2535h {
    @Override // com.fimi.soul.biz.p183l.AbstractC2529b
    /* renamed from: a */
    public PlaneMsg mo11739a(Context context) {
        return null;
    }

    @Override // com.fimi.soul.biz.p183l.AbstractC2535h
    /* renamed from: a */
    public PlaneMsg mo11774a(User user, String str, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "applyX2"));
        arrayList.add(new BasicNameValuePair("userID", user.getUserID()));
        arrayList.add(new BasicNameValuePair("planeID", C3579a.m7971a().m7970a(0).m7905i()));
        arrayList.add(new BasicNameValuePair("sign", str));
        String m7762b = NetUtil.m7762b(C2353b.f7951i, arrayList, context);
        PlaneMsg planeMsg = new PlaneMsg();
        try {
            JSONObject jSONObject = new JSONObject(m7762b);
            String string = jSONObject.getString("errorMessage");
            String string2 = jSONObject.getString("commandCode");
            String string3 = jSONObject.getString("errorCode");
            boolean z = jSONObject.getBoolean("success");
            int i = jSONObject.getInt("data");
            planeMsg.setCommandCode(string2);
            planeMsg.setErrorCode(string3);
            planeMsg.setErrorMessage(string);
            planeMsg.setSuccess(z);
            planeMsg.setData(Integer.valueOf(i));
        } catch (JSONException e) {
            e.printStackTrace();
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
