package com.android.volley.toolbox;

import com.android.volley.AbstractC1333n;
import com.android.volley.C1329j;
import com.android.volley.C1341p;
import java.io.UnsupportedEncodingException;
/* renamed from: com.android.volley.toolbox.s */
/* loaded from: classes.dex */
public class C1382s extends AbstractC1333n<String> {

    /* renamed from: a */
    private C1341p.AbstractC1343b<String> f4713a;

    public C1382s(int i, String str, C1341p.AbstractC1343b<String> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(i, str, abstractC1342a);
        this.f4713a = abstractC1343b;
    }

    public C1382s(String str, C1341p.AbstractC1343b<String> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        this(0, str, abstractC1343b, abstractC1342a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: a */
    public C1341p<String> mo13155a(C1329j c1329j) {
        String str;
        try {
            str = new String(c1329j.f4566b, C1362h.m16634a(c1329j.f4567c));
        } catch (UnsupportedEncodingException e) {
            str = new String(c1329j.f4566b);
        }
        return C1341p.m16687a(str, C1362h.m16636a(c1329j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: d */
    public void mo13154b(String str) {
        if (this.f4713a != null) {
            this.f4713a.mo13137a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: e */
    public void mo16575e() {
        super.mo16575e();
        this.f4713a = null;
    }
}
