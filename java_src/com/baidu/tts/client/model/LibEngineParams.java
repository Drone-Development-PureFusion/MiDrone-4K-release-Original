package com.baidu.tts.client.model;

import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.tools.JsonTool;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class LibEngineParams {

    /* renamed from: a */
    private String f5848a;

    /* renamed from: b */
    private String f5849b;

    /* renamed from: c */
    private String[] f5850c;

    /* renamed from: d */
    private String[] f5851d;

    /* renamed from: e */
    private String[] f5852e;

    public LibEngineParams(String str) {
        this.f5848a = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f5849b = jSONObject.optString(EnumC1704g.VERSION.m14896b());
            this.f5850c = JsonTool.getStringarray(jSONObject.optJSONArray(EnumC1704g.DOMAIN.m14896b()));
            this.f5851d = JsonTool.getStringarray(jSONObject.optJSONArray(EnumC1704g.LANGUAGE.m14896b()));
            this.f5852e = JsonTool.getStringarray(jSONObject.optJSONArray(EnumC1704g.QUALITY.m14896b()));
        } catch (Exception e) {
        }
    }

    public String[] getDomain() {
        return this.f5850c;
    }

    public JSONObject getJsonResult() {
        try {
            return new JSONObject(this.f5848a);
        } catch (JSONException e) {
            return null;
        }
    }

    public String[] getLanguage() {
        return this.f5851d;
    }

    public String[] getQuality() {
        return this.f5852e;
    }

    public String getResult() {
        return this.f5848a;
    }

    public String getVersion() {
        return this.f5849b;
    }

    public void setDomain(String[] strArr) {
        this.f5850c = strArr;
    }

    public void setLanguage(String[] strArr) {
        this.f5851d = strArr;
    }

    public void setQuality(String[] strArr) {
        this.f5852e = strArr;
    }

    public void setVersion(String str) {
        this.f5849b = str;
    }
}
