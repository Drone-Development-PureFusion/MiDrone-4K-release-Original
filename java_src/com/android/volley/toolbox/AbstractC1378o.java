package com.android.volley.toolbox;

import com.android.volley.AbstractC1333n;
import com.android.volley.C1329j;
import com.android.volley.C1341p;
import com.android.volley.C1385v;
import java.io.UnsupportedEncodingException;
/* renamed from: com.android.volley.toolbox.o */
/* loaded from: classes.dex */
public abstract class AbstractC1378o<T> extends AbstractC1333n<T> {

    /* renamed from: a */
    protected static final String f4703a = "utf-8";

    /* renamed from: b */
    private static final String f4704b = String.format("application/json; charset=%s", f4703a);

    /* renamed from: c */
    private C1341p.AbstractC1343b<T> f4705c;

    /* renamed from: d */
    private final String f4706d;

    public AbstractC1378o(int i, String str, String str2, C1341p.AbstractC1343b<T> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(i, str, abstractC1342a);
        this.f4705c = abstractC1343b;
        this.f4706d = str2;
    }

    public AbstractC1378o(String str, String str2, C1341p.AbstractC1343b<T> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        this(-1, str, str2, abstractC1343b, abstractC1342a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: a */
    public abstract C1341p<T> mo13155a(C1329j c1329j);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: b */
    public void mo13154b(T t) {
        if (this.f4705c != null) {
            this.f4705c.mo13137a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.AbstractC1333n
    /* renamed from: e */
    public void mo16575e() {
        super.mo16575e();
        this.f4705c = null;
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: q */
    public String mo16590q() {
        return mo16588u();
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: r */
    public byte[] mo16589r() {
        return mo16587v();
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: u */
    public String mo16588u() {
        return f4704b;
    }

    @Override // com.android.volley.AbstractC1333n
    /* renamed from: v */
    public byte[] mo16587v() {
        try {
            if (this.f4706d != null) {
                return this.f4706d.getBytes(f4703a);
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            C1385v.m16562d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f4706d, f4703a);
            return null;
        }
    }
}
