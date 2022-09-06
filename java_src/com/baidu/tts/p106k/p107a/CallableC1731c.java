package com.baidu.tts.p106k.p107a;

import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.database.C1691a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
/* renamed from: com.baidu.tts.k.a.c */
/* loaded from: classes.dex */
public class CallableC1731c implements Callable<ModelBags> {

    /* renamed from: a */
    private Conditions f6227a;

    /* renamed from: b */
    private C1691a f6228b;

    public CallableC1731c(C1691a c1691a, Conditions conditions) {
        this.f6227a = conditions;
        this.f6228b = c1691a;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public ModelBags call() {
        List<Map<String, String>> m14922a = this.f6228b.m14922a(this.f6227a);
        ModelBags modelBags = new ModelBags();
        modelBags.setList(m14922a);
        return modelBags;
    }
}
