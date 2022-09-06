package com.baidu.tts.p106k.p107a;

import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
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
/* renamed from: com.baidu.tts.k.a.e */
/* loaded from: classes.dex */
public class CallableC1733e implements Callable<ModelBags> {

    /* renamed from: a */
    private RequestHandle f6231a;

    /* renamed from: b */
    private StringEntity m14809b() {
        try {
            JSONObject jSONObject = new JSONObject(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
            jSONObject.put(EnumC1704g.FUNCTION.m14898a(), "getDefaultList");
            return new StringEntity(jSONObject.toString());
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public ModelBags call() {
        SyncHttpClient syncHttpClient = new SyncHttpClient();
        String m14884a = EnumC1713o.MODEL_SERVER.m14884a();
        HttpEntity m14809b = m14809b();
        C1729a c1729a = new C1729a();
        this.f6231a = syncHttpClient.post(null, m14884a, m14809b, RequestParams.APPLICATION_JSON, c1729a);
        return c1729a.m14814a();
    }
}
