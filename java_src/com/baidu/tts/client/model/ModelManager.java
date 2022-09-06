package com.baidu.tts.client.model;

import android.content.Context;
import com.baidu.tts.p093d.C1680b;
import com.baidu.tts.p096e.EnumC1704g;
import com.baidu.tts.p106k.C1728a;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public class ModelManager {

    /* renamed from: a */
    private C1728a f5874a;

    public ModelManager(Context context) {
        this.f5874a = new C1728a(context);
    }

    /* renamed from: a */
    private Conditions m15052a() {
        Conditions conditions = new Conditions();
        LibEngineParams engineParams = getEngineParams();
        conditions.setVersion(engineParams.getVersion());
        conditions.setDomains(engineParams.getDomain());
        conditions.setLanguages(engineParams.getLanguage());
        conditions.setQualitys(engineParams.getQuality());
        return conditions;
    }

    /* renamed from: a */
    private Conditions m15051a(AvailableConditions availableConditions) {
        Conditions m15052a = m15052a();
        if (m15052a != null && availableConditions != null) {
            m15052a.setSpeakers(availableConditions.getSpeakers());
            m15052a.setGenders(availableConditions.getGenders());
        }
        return m15052a;
    }

    public DownloadHandler download(String str, OnDownloadListener onDownloadListener) {
        C1680b c1680b = new C1680b();
        c1680b.m15015a(str);
        c1680b.m15016a(onDownloadListener);
        return this.f5874a.m14826a(c1680b);
    }

    public LibEngineParams getEngineParams() {
        return this.f5874a.m14828a();
    }

    public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> set) {
        return this.f5874a.m14819b(set);
    }

    public BasicHandler<ModelBags> getLocalModels(Conditions conditions) {
        return this.f5874a.m14821b(conditions);
    }

    public BasicHandler<ModelBags> getLocalModelsAvailable(AvailableConditions availableConditions) {
        BasicHandler<ModelBags> localModels = getLocalModels(m15051a(availableConditions));
        ModelBags modelBags = localModels.get();
        if (modelBags != null) {
            Iterator<ModelInfo> it2 = modelBags.getModelInfos().iterator();
            while (it2.hasNext()) {
                if (!isModelValid(it2.next().getServerId())) {
                    it2.remove();
                }
            }
        }
        return localModels;
    }

    public BasicHandler<ModelBags> getServerDefaultModels() {
        return this.f5874a.m14822b();
    }

    public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> set) {
        return this.f5874a.m14823a(set);
    }

    public BasicHandler<ModelBags> getServerModels(Conditions conditions) {
        return this.f5874a.m14827a(conditions);
    }

    public BasicHandler<ModelBags> getServerModelsAvailable(AvailableConditions availableConditions) {
        return getServerModels(m15051a(availableConditions));
    }

    public String getSpeechModelFileAbsPath(String str) {
        return this.f5874a.m14824a(EnumC1704g.SPEECH_DATA_ID.m14896b(), str);
    }

    public String getTextModelFileAbsPath(String str) {
        return this.f5874a.m14824a(EnumC1704g.TEXT_DATA_ID.m14896b(), str);
    }

    public boolean isModelFileValid(String str) {
        return this.f5874a.m14825a(str);
    }

    public boolean isModelValid(String str) {
        return this.f5874a.m14820b(str);
    }

    public int stop() {
        this.f5874a.m14818c();
        return 0;
    }
}
