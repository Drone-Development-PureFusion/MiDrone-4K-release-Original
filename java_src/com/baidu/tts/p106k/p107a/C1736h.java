package com.baidu.tts.p106k.p107a;

import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.p106k.C1728a;
import java.util.Set;
import java.util.concurrent.FutureTask;
/* renamed from: com.baidu.tts.k.a.h */
/* loaded from: classes.dex */
public class C1736h {

    /* renamed from: a */
    private C1728a f6236a;

    public C1736h(C1728a c1728a) {
        this.f6236a = c1728a;
    }

    /* renamed from: a */
    public BasicHandler<ModelBags> m14803a(Conditions conditions) {
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new CallableC1735g(conditions)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: a */
    public BasicHandler<ModelFileBags> m14802a(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler<>(new FutureTask(new CallableC1734f(set)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: a */
    public LibEngineParams m14804a() {
        return new LibEngineParams(EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
    }

    /* renamed from: b */
    public BasicHandler<ModelBags> m14801b() {
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new CallableC1733e()));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: b */
    public BasicHandler<ModelBags> m14800b(Conditions conditions) {
        BasicHandler<ModelBags> basicHandler = new BasicHandler<>(new FutureTask(new CallableC1731c(this.f6236a.m14816e(), conditions)));
        basicHandler.start();
        return basicHandler;
    }

    /* renamed from: b */
    public BasicHandler<ModelFileBags> m14799b(Set<String> set) {
        BasicHandler<ModelFileBags> basicHandler = new BasicHandler<>(new FutureTask(new CallableC1730b(this.f6236a.m14816e(), set)));
        basicHandler.start();
        return basicHandler;
    }
}
