package com.amap.api.services.core;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.be */
/* loaded from: classes.dex */
public class C1202be extends AbstractC1209bi {

    /* renamed from: a */
    private C1203a f4076a;

    /* renamed from: com.amap.api.services.core.be$a */
    /* loaded from: classes.dex */
    class C1203a implements AbstractC1218bn {

        /* renamed from: b */
        private C1175ak f4078b;

        C1203a(C1175ak c1175ak) {
            this.f4078b = c1175ak;
        }

        @Override // com.amap.api.services.core.AbstractC1218bn
        /* renamed from: a */
        public void mo17075a(String str) {
            try {
                this.f4078b.m17227b(str, C1202be.this.mo17148a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected int mo17148a() {
        return 1;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected AbstractC1218bn mo17140a(C1175ak c1175ak) {
        try {
            if (this.f4076a == null) {
                this.f4076a = new C1203a(c1175ak);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f4076a;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected String mo17138a(String str) {
        return C1164ab.m17275b(str);
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected String mo17135a(List<C1166ad> list) {
        return null;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: b */
    protected String mo17133b() {
        return C1204bf.f4080b;
    }
}
