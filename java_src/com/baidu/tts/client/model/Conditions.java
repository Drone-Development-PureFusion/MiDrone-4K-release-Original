package com.baidu.tts.client.model;

import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.JsonTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class Conditions {

    /* renamed from: a */
    private Set<String> f5836a;

    /* renamed from: b */
    private String f5837b;

    /* renamed from: c */
    private Set<String> f5838c;

    /* renamed from: d */
    private Set<String> f5839d;

    /* renamed from: e */
    private Set<String> f5840e;

    /* renamed from: f */
    private Set<String> f5841f;

    /* renamed from: g */
    private Set<String> f5842g;

    public void appendDomain(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5841f == null) {
            this.f5841f = new HashSet();
        }
        this.f5841f.add(str);
    }

    public void appendGender(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5839d == null) {
            this.f5839d = new HashSet();
        }
        this.f5839d.add(str);
    }

    public void appendId(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5836a == null) {
            this.f5836a = new HashSet();
        }
        this.f5836a.add(str);
    }

    public void appendLanguage(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5838c == null) {
            this.f5838c = new HashSet();
        }
        this.f5838c.add(str);
    }

    public void appendQuality(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5842g == null) {
            this.f5842g = new HashSet();
        }
        this.f5842g.add(str);
    }

    public void appendSpeaker(String str) {
        if (StringTool.isEmpty(str)) {
            return;
        }
        if (this.f5840e == null) {
            this.f5840e = new HashSet();
        }
        this.f5840e.add(str);
    }

    public String[] getDomainArray() {
        return DataTool.fromSetToArray(this.f5841f);
    }

    public Set<String> getDomains() {
        return this.f5841f;
    }

    public String[] getGenderArray() {
        return DataTool.fromSetToArray(this.f5839d);
    }

    public JSONArray getGenderJA() {
        return JsonTool.fromSetToJson(this.f5839d);
    }

    public Set<String> getGenders() {
        return this.f5839d;
    }

    public JSONObject getJSONConditions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EnumC1704g.ID.m14896b(), JsonTool.fromSetToJson(this.f5836a));
            jSONObject.put(EnumC1704g.VERSION.m14896b(), this.f5837b);
            jSONObject.put(EnumC1704g.LANGUAGE.m14896b(), JsonTool.fromSetToJson(this.f5838c));
            jSONObject.put(EnumC1704g.GENDER.m14896b(), JsonTool.fromSetToJson(this.f5839d));
            jSONObject.put(EnumC1704g.SPEAKER.m14896b(), JsonTool.fromSetToJson(this.f5840e));
            jSONObject.put(EnumC1704g.DOMAIN.m14896b(), JsonTool.fromSetToJson(this.f5841f));
            jSONObject.put(EnumC1704g.QUALITY.m14896b(), JsonTool.fromSetToJson(this.f5842g));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String[] getLanguageArray() {
        return DataTool.fromSetToArray(this.f5838c);
    }

    public Set<String> getLanguages() {
        return this.f5838c;
    }

    public Set<String> getModelIds() {
        return this.f5836a;
    }

    public String[] getModelIdsArray() {
        return DataTool.fromSetToArray(this.f5836a);
    }

    public String[] getQualityArray() {
        return DataTool.fromSetToArray(this.f5842g);
    }

    public Set<String> getQualitys() {
        return this.f5842g;
    }

    public String[] getSpeakerArray() {
        return DataTool.fromSetToArray(this.f5840e);
    }

    public JSONArray getSpeakerJA() {
        return JsonTool.fromSetToJson(this.f5840e);
    }

    public Set<String> getSpeakers() {
        return this.f5840e;
    }

    public String getVersion() {
        return this.f5837b;
    }

    public void setDomains(Set<String> set) {
        this.f5841f = set;
    }

    public void setDomains(String[] strArr) {
        this.f5841f = DataTool.fromArrayToSet(strArr);
    }

    public void setGenders(Set<String> set) {
        this.f5839d = set;
    }

    public void setLanguages(Set<String> set) {
        this.f5838c = set;
    }

    public void setLanguages(String[] strArr) {
        this.f5838c = DataTool.fromArrayToSet(strArr);
    }

    public void setModelIds(Set<String> set) {
        this.f5836a = set;
    }

    public void setQualitys(Set<String> set) {
        this.f5842g = set;
    }

    public void setQualitys(String[] strArr) {
        this.f5842g = DataTool.fromArrayToSet(strArr);
    }

    public void setSpeakers(Set<String> set) {
        this.f5840e = set;
    }

    public void setVersion(String str) {
        this.f5837b = str;
    }
}
