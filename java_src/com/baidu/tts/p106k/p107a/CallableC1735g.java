package com.baidu.tts.p106k.p107a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.RequestParams;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1713o;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.baidu.tts.k.a.g */
/* loaded from: classes.dex */
public class CallableC1735g implements Callable<ModelBags> {

    /* renamed from: a */
    private Conditions f6234a;

    /* renamed from: b */
    private RequestHandle f6235b;

    public CallableC1735g(Conditions conditions) {
        this.f6234a = conditions;
    }

    /* renamed from: b */
    private StringEntity m14805b() {
        JSONObject jSONConditions = this.f6234a.getJSONConditions();
        try {
            jSONConditions.put(EnumC1704g.IVERSION.m14896b(), "1");
            jSONConditions.put(EnumC1704g.FUNCTION.m14898a(), "getList");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject = jSONConditions.toString();
        LoggerProxy.m15091d("GetServerModelsWork", "getlist params=" + jSONObject);
        return new StringEntity(jSONObject);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public ModelBags call() {
        SyncHttpClient syncHttpClient = new SyncHttpClient();
        String m14884a = EnumC1713o.MODEL_SERVER.m14884a();
        HttpEntity m14805b = m14805b();
        C1729a c1729a = new C1729a();
        this.f6235b = syncHttpClient.post(null, m14884a, m14805b, RequestParams.APPLICATION_JSON, c1729a);
        return c1729a.m14814a();
    }
}
