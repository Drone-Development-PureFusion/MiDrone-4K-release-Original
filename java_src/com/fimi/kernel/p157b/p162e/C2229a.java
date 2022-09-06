package com.fimi.kernel.p157b.p162e;

import com.android.volley.AbstractC1333n;
import com.android.volley.C1329j;
import com.android.volley.C1341p;
import com.android.volley.toolbox.C1362h;
import com.fimi.kernel.p157b.AbstractC2228e;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.fimi.kernel.b.e.a */
/* loaded from: classes.dex */
public class C2229a<T> extends AbstractC1333n<T> {

    /* renamed from: a */
    private Map<String, String> f7447a;

    /* renamed from: b */
    private AbstractC2228e<T> f7448b;

    /* renamed from: c */
    private Class<?> f7449c;

    /* renamed from: d */
    private Gson f7450d = new Gson();

    public C2229a(int i, String str, Map<String, String> map, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
        super(i, str, null);
        this.f7448b = abstractC2228e;
        this.f7447a = map;
        this.f7449c = cls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: a */
    public C1341p<T> mo13155a(C1329j c1329j) {
        try {
            return C1341p.m16687a(this.f7450d.fromJson(new String(c1329j.f4566b, C1362h.m16634a(c1329j.f4567c)), (Class<Object>) this.f7449c), C1362h.m16636a(c1329j));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: b */
    public void mo13154b(T t) {
        if (this.f7448b != null) {
            this.f7448b.mo8307a(t);
        }
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: s */
    protected Map<String, String> mo13139s() {
        return this.f7447a;
    }
}
