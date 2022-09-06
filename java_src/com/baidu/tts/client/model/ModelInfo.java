package com.baidu.tts.client.model;

import com.baidu.tts.p096e.EnumC1704g;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ModelInfo {

    /* renamed from: a */
    private String f5863a;

    /* renamed from: b */
    private String f5864b;

    /* renamed from: c */
    private String f5865c;

    /* renamed from: d */
    private String f5866d;

    /* renamed from: e */
    private String f5867e;

    /* renamed from: f */
    private String f5868f;

    /* renamed from: g */
    private String f5869g;

    /* renamed from: h */
    private String f5870h;

    /* renamed from: i */
    private String f5871i;

    /* renamed from: j */
    private String f5872j;

    /* renamed from: k */
    private String f5873k;

    public String getDomain() {
        return this.f5870h;
    }

    public String getGender() {
        return this.f5868f;
    }

    public String getLanguage() {
        return this.f5867e;
    }

    public String getName() {
        return this.f5864b;
    }

    public String getQuality() {
        return this.f5871i;
    }

    public String getServerId() {
        return this.f5863a;
    }

    public String getSpeaker() {
        return this.f5869g;
    }

    public String getSpeechDataId() {
        return this.f5873k;
    }

    public String getTextDataId() {
        return this.f5872j;
    }

    public String getVersionMax() {
        return this.f5866d;
    }

    public String getVersionMin() {
        return this.f5865c;
    }

    public void parseJson(JSONObject jSONObject) {
        this.f5863a = jSONObject.optString(EnumC1704g.ID.m14896b());
        this.f5864b = jSONObject.optString(EnumC1704g.NAME.m14896b());
        this.f5865c = jSONObject.optString(EnumC1704g.VERSION_MIN.m14896b());
        this.f5866d = jSONObject.optString(EnumC1704g.VERSION_MAX.m14896b());
        this.f5867e = jSONObject.optString(EnumC1704g.LANGUAGE.m14896b());
        this.f5868f = jSONObject.optString(EnumC1704g.GENDER.m14896b());
        this.f5869g = jSONObject.optString(EnumC1704g.SPEAKER.m14896b());
        this.f5870h = jSONObject.optString(EnumC1704g.DOMAIN.m14896b());
        this.f5871i = jSONObject.optString(EnumC1704g.QUALITY.m14896b());
        this.f5872j = jSONObject.optString(EnumC1704g.TEXT_DATA_ID.m14896b());
        this.f5873k = jSONObject.optString(EnumC1704g.SPEECH_DATA_ID.m14896b());
    }

    public void setDomain(String str) {
        this.f5870h = str;
    }

    public void setGender(String str) {
        this.f5868f = str;
    }

    public void setLanguage(String str) {
        this.f5867e = str;
    }

    public void setMap(Map<String, String> map) {
        if (map != null) {
            this.f5863a = map.get(EnumC1704g.ID.m14896b());
            this.f5864b = map.get(EnumC1704g.NAME.m14896b());
            this.f5865c = map.get(EnumC1704g.VERSION_MIN.m14896b());
            this.f5866d = map.get(EnumC1704g.VERSION_MAX.m14896b());
            this.f5867e = map.get(EnumC1704g.LANGUAGE.m14896b());
            this.f5868f = map.get(EnumC1704g.GENDER.m14896b());
            this.f5869g = map.get(EnumC1704g.SPEAKER.m14896b());
            this.f5870h = map.get(EnumC1704g.DOMAIN.m14896b());
            this.f5871i = map.get(EnumC1704g.QUALITY.m14896b());
            this.f5872j = map.get(EnumC1704g.TEXT_DATA_ID.m14896b());
            this.f5873k = map.get(EnumC1704g.SPEECH_DATA_ID.m14896b());
        }
    }

    public void setName(String str) {
        this.f5864b = str;
    }

    public void setQuality(String str) {
        this.f5871i = str;
    }

    public void setServerId(String str) {
        this.f5863a = str;
    }

    public void setSpeaker(String str) {
        this.f5869g = str;
    }

    public void setSpeechDataId(String str) {
        this.f5873k = str;
    }

    public void setTextDataId(String str) {
        this.f5872j = str;
    }

    public void setVersionMax(String str) {
        this.f5866d = str;
    }

    public void setVersionMin(String str) {
        this.f5865c = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EnumC1704g.ID.m14896b(), this.f5863a);
            jSONObject.putOpt(EnumC1704g.NAME.m14896b(), this.f5864b);
            jSONObject.putOpt(EnumC1704g.VERSION_MIN.m14896b(), this.f5865c);
            jSONObject.putOpt(EnumC1704g.VERSION_MAX.m14896b(), this.f5866d);
            jSONObject.putOpt(EnumC1704g.LANGUAGE.m14896b(), this.f5867e);
            jSONObject.putOpt(EnumC1704g.GENDER.m14896b(), this.f5868f);
            jSONObject.putOpt(EnumC1704g.SPEAKER.m14896b(), this.f5869g);
            jSONObject.putOpt(EnumC1704g.DOMAIN.m14896b(), this.f5870h);
            jSONObject.putOpt(EnumC1704g.QUALITY.m14896b(), this.f5871i);
            jSONObject.putOpt(EnumC1704g.TEXT_DATA_ID.m14896b(), this.f5872j);
            jSONObject.putOpt(EnumC1704g.SPEECH_DATA_ID.m14896b(), this.f5873k);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
