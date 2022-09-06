package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;
@Deprecated
/* renamed from: com.amap.api.mapcore.util.fj */
/* loaded from: classes.dex */
class C1000fj extends AbstractC1075hd {

    /* renamed from: b */
    private String f3153b;

    /* renamed from: a */
    private Map<String, String> f3152a = new HashMap();

    /* renamed from: c */
    private Map<String, String> f3154c = new HashMap();

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: a */
    public Map<String, String> mo17702a() {
        return this.f3152a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m18031a(String str) {
        this.f3153b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m18030a(Map<String, String> map) {
        this.f3152a.clear();
        this.f3152a.putAll(map);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: b */
    public Map<String, String> mo17699b() {
        return this.f3154c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m18029b(Map<String, String> map) {
        this.f3154c.clear();
        this.f3154c.putAll(map);
    }

    @Override // com.amap.api.mapcore.util.AbstractC1075hd
    /* renamed from: c */
    public String mo17697c() {
        return this.f3153b;
    }
}
