package com.baidu.tts.p106k.p107a;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C1691a;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
/* renamed from: com.baidu.tts.k.a.b */
/* loaded from: classes.dex */
public class CallableC1730b implements Callable<ModelFileBags> {

    /* renamed from: a */
    private Set<String> f6225a;

    /* renamed from: b */
    private C1691a f6226b;

    public CallableC1730b(C1691a c1691a, Set<String> set) {
        this.f6225a = set;
        this.f6226b = c1691a;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public ModelFileBags call() {
        List<Map<String, String>> m14915a = this.f6226b.m14915a(this.f6225a);
        ModelFileBags modelFileBags = new ModelFileBags();
        modelFileBags.setList(m14915a);
        return modelFileBags;
    }
}
