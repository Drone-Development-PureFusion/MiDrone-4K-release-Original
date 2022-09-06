package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.C4315a;
import com.tencent.open.p228a.C4331f;
import com.tencent.open.p230c.C4355c;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.tencent.open.web.security.c */
/* loaded from: classes2.dex */
public class C4367c extends C4315a.C4316a {

    /* renamed from: d */
    private static final String f18240d = C4331f.f18119d + ".SL";

    /* renamed from: e */
    private String f18241e;

    public C4367c(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.f18241e = str2;
    }

    /* renamed from: b */
    private void m5338b(String str) {
        WebView webView = this.f18064a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!").append(this.f18241e).append("){");
            stringBuffer.append(this.f18241e);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            C4331f.m5445b(C4331f.f18119d, "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.C4315a.C4316a
    /* renamed from: a */
    public void mo5341a() {
        C4331f.m5445b(f18240d, "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.C4315a.C4316a
    /* renamed from: a */
    public void mo5340a(Object obj) {
        C4331f.m5445b(f18240d, "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.C4315a.C4316a
    /* renamed from: a */
    public void mo5339a(String str) {
        C4331f.m5445b(f18240d, "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        if (!C4355c.f18171a) {
            i = -4;
        }
        try {
            jSONObject.put("result", i);
            jSONObject.put("sn", this.f18065b);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m5338b(jSONObject.toString());
    }
}
