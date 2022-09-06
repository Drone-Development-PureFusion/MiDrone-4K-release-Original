package com.baidu.tts.p085b.p086a.p088b;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.RequestParams;
import com.baidu.tts.p081a.p082a.C1582a;
import com.baidu.tts.p081a.p082a.C1583b;
import com.baidu.tts.p085b.p086a.p088b.C1634f;
import com.baidu.tts.p096e.EnumC1695a;
import com.baidu.tts.p096e.EnumC1701d;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p096e.EnumC1711n;
import com.baidu.tts.p099g.p100a.C1717c;
import com.baidu.tts.p108l.C1744h;
import com.baidu.tts.tools.CommonUtility;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.baidu.tts.b.a.b.h */
/* loaded from: classes.dex */
public class C1639h extends AbstractC1638g {

    /* renamed from: a */
    private C1582a<byte[], byte[]> f5780a = new C1582a<>();

    /* renamed from: b */
    private C1634f.C1636b f5781b;

    /* renamed from: c */
    private C1744h f5782c;

    public C1639h(C1744h c1744h) {
        this.f5782c = c1744h;
        this.f5780a.m15409a(new C1583b());
        this.f5780a.m15410a();
    }

    /* renamed from: a */
    private void m15154a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt(EnumC1704g.ERROR_NUMBER.m14898a());
            LoggerProxy.m15091d("TtsResponseHandler", "parseJSON errNo=" + optInt);
            this.f5782c.m14760a(optInt);
            if (optInt != 0) {
                this.f5782c.m14759a(C1717c.m14880a().m14877a(EnumC1711n.ONLINE_ENGINE_REQUEST_RESULT_ERROR, optInt, jSONObject.getString(EnumC1704g.ERROR_MESSAGE.m14898a())));
            } else {
                this.f5782c.m14754a(jSONObject.optString(EnumC1704g.SERIAL_NUMBER.m14898a()));
                this.f5782c.m14751b(jSONObject.optInt(EnumC1704g.INDEX.m14898a()));
                this.f5782c.m14747c(jSONObject.optInt(EnumC1704g.PERCENT.m14896b()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m15153b(HttpEntity httpEntity) {
        byte[] bArr;
        byte[] bArr2 = null;
        try {
            bArr = ("----BD**TTS++LIB").getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        try {
            bArr2 = EntityUtils.toByteArray(httpEntity);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        int indexOf = CommonUtility.indexOf(bArr2, bArr, 0);
        if (indexOf < 0) {
            this.f5782c.m14759a(C1717c.m14880a().m14873b(EnumC1711n.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR));
            return;
        }
        int indexOf2 = CommonUtility.indexOf(bArr2, bArr, bArr.length + indexOf);
        if (indexOf2 < 0) {
            this.f5782c.m14759a(C1717c.m14880a().m14873b(EnumC1711n.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR));
            return;
        }
        try {
            m15154a(new String(CommonUtility.copyBytesOfRange(bArr2, indexOf + bArr.length, indexOf2), "utf-8"));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        int indexOf3 = CommonUtility.indexOf(bArr2, bArr, bArr.length + indexOf2);
        if (indexOf3 < 0) {
            return;
        }
        this.f5782c.m14753a(this.f5780a.m15408a((C1582a<byte[], byte[]>) CommonUtility.copyBytesOfRange(bArr2, bArr.length + indexOf2, indexOf3)));
        this.f5782c.m14758a(EnumC1695a.PCM);
    }

    /* renamed from: c */
    private void m15152c(HttpEntity httpEntity) {
        String str = null;
        try {
            str = EntityUtils.toString(httpEntity, EnumC1701d.UTF8.m14902a());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        m15154a(str);
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1638g
    /* renamed from: a */
    public void mo15157a(int i, Header[] headerArr, String str, HttpEntity httpEntity) {
        if (RequestParams.APPLICATION_JSON.equals(str)) {
            m15152c(httpEntity);
        } else {
            m15153b(httpEntity);
        }
    }

    @Override // com.baidu.tts.p085b.p086a.p088b.AbstractC1638g
    /* renamed from: a */
    public void mo15156a(int i, Header[] headerArr, String str, HttpEntity httpEntity, Throwable th) {
        LoggerProxy.m15091d("TtsResponseHandler", "onFailure error = " + th.getMessage());
        this.f5782c.m14759a(C1717c.m14880a().m14876a(EnumC1711n.ONLINE_ENGINE_HTTP_REQUEST_FAILURE, i, null, th));
    }

    /* renamed from: a */
    public void m15155a(C1634f.C1636b c1636b) {
        this.f5781b = c1636b;
    }
}
