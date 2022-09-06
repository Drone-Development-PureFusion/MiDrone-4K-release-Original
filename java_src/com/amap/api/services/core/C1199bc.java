package com.amap.api.services.core;

import java.util.Date;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.amap.api.services.core.bc */
/* loaded from: classes.dex */
public class C1199bc extends AbstractC1209bi {

    /* renamed from: a */
    private C1200a f4072a;

    /* renamed from: com.amap.api.services.core.bc$a */
    /* loaded from: classes.dex */
    class C1200a implements AbstractC1218bn {

        /* renamed from: b */
        private C1175ak f4074b;

        C1200a(C1175ak c1175ak) {
            this.f4074b = c1175ak;
        }

        @Override // com.amap.api.services.core.AbstractC1218bn
        /* renamed from: a */
        public void mo17075a(String str) {
            try {
                this.f4074b.m17227b(str, C1199bc.this.mo17148a());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected int mo17148a() {
        return 0;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected AbstractC1218bn mo17140a(C1175ak c1175ak) {
        try {
            if (this.f4072a == null) {
                this.f4072a = new C1200a(c1175ak);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f4072a;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected String mo17138a(String str) {
        return C1164ab.m17275b(str + C1210bj.m17128a(new Date().getTime()));
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: a */
    protected String mo17135a(List<C1166ad> list) {
        return null;
    }

    @Override // com.amap.api.services.core.AbstractC1209bi
    /* renamed from: b */
    protected String mo17133b() {
        return C1204bf.f4081c;
    }
}
