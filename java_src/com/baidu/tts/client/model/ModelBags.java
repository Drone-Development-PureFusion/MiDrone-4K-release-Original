package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ModelBags {

    /* renamed from: a */
    private TtsError f5853a;

    /* renamed from: b */
    private List<ModelInfo> f5854b;

    public void addModelInfo(ModelInfo modelInfo) {
        if (this.f5854b == null) {
            this.f5854b = new ArrayList();
        }
        this.f5854b.add(modelInfo);
    }

    public List<ModelInfo> getModelInfos() {
        return this.f5854b;
    }

    public TtsError getTtsError() {
        return this.f5853a;
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.f5854b);
    }

    public void parseJson(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            ModelInfo modelInfo = new ModelInfo();
            modelInfo.parseJson(optJSONObject);
            addModelInfo(modelInfo);
        }
    }

    public void setList(List<Map<String, String>> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Map<String, String> map : list) {
                ModelInfo modelInfo = new ModelInfo();
                modelInfo.setMap(map);
                arrayList.add(modelInfo);
            }
            this.f5854b = arrayList;
        }
    }

    public void setModelInfos(List<ModelInfo> list) {
        this.f5854b = list;
    }

    public void setTtsError(TtsError ttsError) {
        this.f5853a = ttsError;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            for (ModelInfo modelInfo : this.f5854b) {
                jSONArray.put(modelInfo.toJson());
            }
        }
        return jSONArray;
    }
}
