package com.baidu.tts.p106k.p107a;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.loopj.RequestHandle;
import com.baidu.tts.loopj.RequestParams;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1713o;
import com.baidu.tts.tools.JsonTool;
import java.util.Set;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.baidu.tts.k.a.f */
/* loaded from: classes.dex */
public class CallableC1734f implements Callable<ModelFileBags> {

    /* renamed from: a */
    private RequestHandle f6232a;

    /* renamed from: b */
    private Set<String> f6233b;

    public CallableC1734f(Set<String> set) {
        this.f6233b = set;
    }

    /* renamed from: b */
    private StringEntity m14807b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EnumC1704g.FUNCTION.m14898a(), "getURL");
            jSONObject.put(EnumC1704g.IVERSION.m14896b(), "1");
            jSONObject.put(EnumC1704g.ID.m14896b(), JsonTool.fromSetToJson(this.f6233b));
            String jSONObject2 = jSONObject.toString();
            LoggerProxy.m15091d("GetServerModelFileInfosWork", "geturl params=" + jSONObject2);
            return new StringEntity(jSONObject2);
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public ModelFileBags call() {
        SyncHttpClient syncHttpClient = new SyncHttpClient();
        String m14884a = EnumC1713o.MODEL_SERVER.m14884a();
        HttpEntity m14807b = m14807b();
        C1732d c1732d = new C1732d();
        this.f6232a = syncHttpClient.post(null, m14884a, m14807b, RequestParams.APPLICATION_JSON, c1732d);
        return c1732d.m14811a();
    }
}
