package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.tools.DataTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ModelFileBags {

    /* renamed from: a */
    private TtsError f5855a;

    /* renamed from: b */
    private List<ModelFileInfo> f5856b;

    public void addFileInfo(ModelFileInfo modelFileInfo) {
        if (this.f5856b == null) {
            this.f5856b = new ArrayList();
        }
        this.f5856b.add(modelFileInfo);
    }

    public void generateAbsPath(Context context) {
        if (this.f5856b != null) {
            for (ModelFileInfo modelFileInfo : this.f5856b) {
                modelFileInfo.generateAbsPath(context);
            }
        }
    }

    public ModelFileInfo getModelFileInfo(int i) {
        if (this.f5856b != null) {
            return this.f5856b.get(i);
        }
        return null;
    }

    public List<ModelFileInfo> getModelFileInfos() {
        return this.f5856b;
    }

    public TtsError getTtsError() {
        return this.f5855a;
    }

    public String getUrl(int i) {
        ModelFileInfo modelFileInfo = getModelFileInfo(i);
        if (modelFileInfo != null) {
            return modelFileInfo.getUrl();
        }
        return null;
    }

    public boolean isEmpty() {
        return DataTool.isListEmpty(this.f5856b);
    }

    public void parseJson(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            ModelFileInfo modelFileInfo = new ModelFileInfo();
            modelFileInfo.parseJson(optJSONObject);
            addFileInfo(modelFileInfo);
        }
    }

    public void setList(List<Map<String, String>> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            ModelFileInfo modelFileInfo = new ModelFileInfo();
            modelFileInfo.setMap(map);
            arrayList.add(modelFileInfo);
        }
        this.f5856b = arrayList;
    }

    public void setModelFileInfos(List<ModelFileInfo> list) {
        this.f5856b = list;
    }

    public void setTtsError(TtsError ttsError) {
        this.f5855a = ttsError;
    }

    public JSONArray toJson() {
        JSONArray jSONArray = new JSONArray();
        if (!isEmpty()) {
            for (ModelFileInfo modelFileInfo : this.f5856b) {
                jSONArray.put(modelFileInfo.toJson());
            }
        }
        return jSONArray;
    }
}
