package com.fimi.soul.biz.p182k;

import android.content.Context;
import com.fimi.soul.base.C2353b;
import com.fimi.soul.biz.p183l.AbstractC2537j;
import com.fimi.soul.entity.MessagePush;
import com.fimi.soul.entity.PlaneMsg;
import com.fimi.soul.utils.NetUtil;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.fimi.soul.biz.k.m */
/* loaded from: classes.dex */
public class C2520m implements AbstractC2537j {
    @Override // com.fimi.soul.biz.p183l.AbstractC2537j
    /* renamed from: a */
    public PlaneMsg mo11772a(MessagePush messagePush, Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("commandCode", "addPushUserRegID"));
        arrayList.add(new BasicNameValuePair("userID", messagePush.getUserID()));
        arrayList.add(new BasicNameValuePair("miRegID", messagePush.getMiRegID()));
        arrayList.add(new BasicNameValuePair("appType", messagePush.getAppType()));
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
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return planeMsg;
    }
}
