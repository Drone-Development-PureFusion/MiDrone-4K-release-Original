package com.p080b;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.b.dx */
/* loaded from: classes.dex */
class C1553dx extends AbstractC1428aq {

    /* renamed from: e */
    private String f5540e;

    /* renamed from: d */
    private Map<String, String> f5539d = new HashMap();

    /* renamed from: f */
    private Map<String, String> f5541f = new HashMap();

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: a */
    public Map<String, String> mo15505a() {
        return this.f5539d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m15549a(String str) {
        this.f5540e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m15548a(Map<String, String> map) {
        this.f5539d.clear();
        this.f5539d.putAll(map);
    }

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: b */
    public Map<String, String> mo15504b() {
        return this.f5541f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m15547b(Map<String, String> map) {
        this.f5541f.clear();
        this.f5541f.putAll(map);
    }

    @Override // com.p080b.AbstractC1428aq
    /* renamed from: c */
    public String mo15503c() {
        return this.f5540e;
    }
}
