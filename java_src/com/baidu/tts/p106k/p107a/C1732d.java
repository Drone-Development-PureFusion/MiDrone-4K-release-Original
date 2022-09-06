package com.baidu.tts.p106k.p107a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.loopj.JsonHttpResponseHandler;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.baidu.tts.k.a.d */
/* loaded from: classes.dex */
public class C1732d extends JsonHttpResponseHandler {

    /* renamed from: a */
    private TtsError f6229a;

    /* renamed from: b */
    private ModelFileBags f6230b;

    /* renamed from: a */
    public ModelFileBags m14811a() {
        return this.f6230b;
    }

    @Override // com.baidu.tts.loopj.JsonHttpResponseHandler, com.baidu.tts.loopj.TextHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, String str, Throwable th) {
        LoggerProxy.m15091d("GetModelFileInfosHttpHandler", "onFailure1");
        this.f6229a = C1717c.m14880a().m14876a(EnumC1711n.MODEL_REQUEST_ERROR, i, str, th);
    }

    @Override // com.baidu.tts.loopj.JsonHttpResponseHandler
    public void onFailure(int i, Header[] headerArr, Throwable th, JSONObject jSONObject) {
        LoggerProxy.m15091d("GetModelFileInfosHttpHandler", "onFailure2");
        String str = null;
        if (jSONObject != null) {
            str = jSONObject.toString();
        }
        this.f6229a = C1717c.m14880a().m14876a(EnumC1711n.MODEL_REQUEST_ERROR, i, str, th);
    }

    @Override // com.baidu.tts.loopj.JsonHttpResponseHandler
    public void onSuccess(int i, Header[] headerArr, JSONObject jSONObject) {
        LoggerProxy.m15091d("GetModelFileInfosHttpHandler", "onSuccess response=" + jSONObject);
        int optInt = jSONObject.optInt(EnumC1704g.ERROR_NUMBER.m14898a());
        String optString = jSONObject.optString(EnumC1704g.ERROR_MESSAGE.m14898a());
        if (optInt != 0 && optInt != -4005) {
            this.f6229a = C1717c.m14880a().m14877a(EnumC1711n.MODEL_SERVER_ERROR, optInt, optString);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(EnumC1704g.DATA.m14896b());
        this.f6230b = new ModelFileBags();
        this.f6230b.parseJson(optJSONArray);
    }
}
