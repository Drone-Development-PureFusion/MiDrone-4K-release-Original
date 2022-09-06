package com.fimi.kernel.p157b.p162e;

import com.android.volley.AbstractC1333n;
import com.android.volley.AbstractC1345r;
import com.android.volley.C1321d;
import com.android.volley.C1337o;
import com.android.volley.C1341p;
import com.android.volley.C1384u;
import com.android.volley.toolbox.C1377n;
import com.android.volley.toolbox.C1382s;
import com.android.volley.toolbox.C1383t;
import com.fimi.kernel.C2238c;
import com.fimi.kernel.p157b.AbstractC2182a;
import com.fimi.kernel.p157b.AbstractC2228e;
import java.util.Map;
import org.json.JSONObject;
/* renamed from: com.fimi.kernel.b.e.b */
/* loaded from: classes.dex */
public class C2230b implements AbstractC2182a {

    /* renamed from: a */
    C1337o f7451a;

    public C2230b() {
        this.f7451a = null;
        this.f7451a = C1383t.m16574a(C2238c.m13131a());
    }

    /* renamed from: a */
    private void m13153a(int i, String str, final AbstractC2228e<String> abstractC2228e) {
        C1382s c1382s = new C1382s(i, str, new C1341p.AbstractC1343b<String>() { // from class: com.fimi.kernel.b.e.b.4
            @Override // com.android.volley.C1341p.AbstractC1343b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo13137a(String str2) {
                if (abstractC2228e != null) {
                    abstractC2228e.mo8307a(str2);
                }
            }
        }, new C1341p.AbstractC1342a() { // from class: com.fimi.kernel.b.e.b.5
            @Override // com.android.volley.C1341p.AbstractC1342a
            /* renamed from: a */
            public void mo7531a(C1384u c1384u) {
                abstractC2228e.mo8305b(c1384u.getMessage());
            }
        });
        c1382s.a((AbstractC1345r) new C1321d(3000, 1, 1.0f));
        this.f7451a.m16700a((AbstractC1333n) c1382s);
    }

    /* renamed from: a */
    private <T> void m13152a(int i, String str, Map<String, String> map, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
        this.f7451a.m16700a((AbstractC1333n) new C2229a(i, str, map, abstractC2228e, cls));
    }

    /* renamed from: a */
    private void m13151a(int i, String str, JSONObject jSONObject, final AbstractC2228e<JSONObject> abstractC2228e) {
        this.f7451a.m16700a((AbstractC1333n) new C1377n(i, str, jSONObject, new C1341p.AbstractC1343b<JSONObject>() { // from class: com.fimi.kernel.b.e.b.6
            @Override // com.android.volley.C1341p.AbstractC1343b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo13137a(JSONObject jSONObject2) {
                if (abstractC2228e != null) {
                    abstractC2228e.mo8307a(jSONObject2);
                }
            }
        }, (C1341p.AbstractC1342a) null));
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public void mo13150a(String str, AbstractC2228e<String> abstractC2228e) {
        m13153a(0, str, abstractC2228e);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public <T> void mo13149a(String str, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
        m13152a(0, str, null, abstractC2228e, cls);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public void mo13148a(String str, final Map<String, String> map, final AbstractC2228e<String> abstractC2228e) {
        this.f7451a.m16700a((AbstractC1333n) new C1382s(1, str, new C1341p.AbstractC1343b<String>() { // from class: com.fimi.kernel.b.e.b.1
            @Override // com.android.volley.C1341p.AbstractC1343b
            /* renamed from: a  reason: avoid collision after fix types in other method */
            public void mo13137a(String str2) {
                if (abstractC2228e != null) {
                    abstractC2228e.mo8307a(str2);
                }
            }
        }, new C1341p.AbstractC1342a() { // from class: com.fimi.kernel.b.e.b.2
            @Override // com.android.volley.C1341p.AbstractC1342a
            /* renamed from: a */
            public void mo7531a(C1384u c1384u) {
                abstractC2228e.mo8305b(c1384u.getMessage());
            }
        }) { // from class: com.fimi.kernel.b.e.b.3
            @Override // com.android.volley.AbstractC1333n
            /* renamed from: s */
            protected Map<String, String> mo13139s() {
                return map;
            }
        });
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public <T> void mo13147a(String str, Map<String, String> map, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
        m13152a(1, str, map, abstractC2228e, cls);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: a */
    public void mo13146a(String str, JSONObject jSONObject, AbstractC2228e<JSONObject> abstractC2228e) {
        m13151a(1, str, jSONObject, abstractC2228e);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: b */
    public void mo13145b(String str, AbstractC2228e<String> abstractC2228e) {
        m13153a(1, str, abstractC2228e);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: b */
    public <T> void mo13144b(String str, AbstractC2228e<T> abstractC2228e, Class<?> cls) {
        m13152a(1, str, null, abstractC2228e, cls);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: b */
    public void mo13143b(String str, JSONObject jSONObject, AbstractC2228e<JSONObject> abstractC2228e) {
        m13151a(0, str, jSONObject, abstractC2228e);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: c */
    public void mo13142c(String str, AbstractC2228e<JSONObject> abstractC2228e) {
        m13151a(1, str, (JSONObject) null, abstractC2228e);
    }

    @Override // com.fimi.kernel.p157b.AbstractC2182a
    /* renamed from: d */
    public void mo13141d(String str, AbstractC2228e<JSONObject> abstractC2228e) {
        m13151a(0, str, (JSONObject) null, abstractC2228e);
    }
}
