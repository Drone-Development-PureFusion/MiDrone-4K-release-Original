package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.tools.ResourceTools;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ModelFileInfo {

    /* renamed from: a */
    private String f5857a;

    /* renamed from: b */
    private String f5858b;

    /* renamed from: c */
    private String f5859c;

    /* renamed from: d */
    private String f5860d;

    /* renamed from: e */
    private String f5861e;

    /* renamed from: f */
    private String f5862f;

    public void generateAbsPath(Context context) {
        this.f5861e = ResourceTools.getModelFileAbsName(context, this.f5860d);
    }

    public String getAbsPath() {
        return this.f5861e;
    }

    public String getLength() {
        return this.f5858b;
    }

    public String getMd5() {
        return this.f5859c;
    }

    public String getName() {
        return this.f5860d;
    }

    public String getServerid() {
        return this.f5857a;
    }

    public String getUrl() {
        return this.f5862f;
    }

    public void parseJson(JSONObject jSONObject) {
        this.f5857a = jSONObject.optString(EnumC1704g.ID.m14896b());
        this.f5858b = jSONObject.optString(EnumC1704g.LENGTH.m14896b());
        this.f5859c = jSONObject.optString(EnumC1704g.MD5.m14896b());
        this.f5860d = jSONObject.optString(EnumC1704g.NAME.m14896b());
        this.f5862f = jSONObject.optString(EnumC1704g.URL.m14896b());
    }

    public void setAbsPath(String str) {
        this.f5861e = str;
    }

    public void setLength(String str) {
        this.f5858b = str;
    }

    public void setMap(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f5857a = map.get(EnumC1704g.ID.m14896b());
        this.f5858b = map.get(EnumC1704g.LENGTH.m14896b());
        this.f5859c = map.get(EnumC1704g.MD5.m14896b());
        this.f5860d = map.get(EnumC1704g.NAME.m14896b());
        this.f5861e = map.get(EnumC1704g.ABS_PATH.m14896b());
    }

    public void setMd5(String str) {
        this.f5859c = str;
    }

    public void setName(String str) {
        this.f5860d = str;
    }

    public void setServerid(String str) {
        this.f5857a = str;
    }

    public void setUrl(String str) {
        this.f5862f = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EnumC1704g.ID.m14896b(), this.f5857a);
            jSONObject.putOpt(EnumC1704g.LENGTH.m14896b(), this.f5858b);
            jSONObject.putOpt(EnumC1704g.MD5.m14896b(), this.f5859c);
            jSONObject.putOpt(EnumC1704g.NAME.m14896b(), this.f5860d);
            jSONObject.putOpt(EnumC1704g.ABS_PATH.m14896b(), this.f5861e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
