package com.android.volley.toolbox;

import com.android.volley.C1329j;
import com.android.volley.C1331l;
import com.android.volley.C1341p;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.android.volley.toolbox.m */
/* loaded from: classes.dex */
public class C1376m extends AbstractC1378o<JSONArray> {
    public C1376m(int i, String str, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(i, str, null, abstractC1343b, abstractC1342a);
    }

    public C1376m(int i, String str, String str2, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(i, str, str2, abstractC1343b, abstractC1342a);
    }

    public C1376m(int i, String str, JSONArray jSONArray, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), abstractC1343b, abstractC1342a);
    }

    public C1376m(int i, String str, JSONObject jSONObject, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), abstractC1343b, abstractC1342a);
    }

    public C1376m(String str, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        super(0, str, null, abstractC1343b, abstractC1342a);
    }

    public C1376m(String str, JSONArray jSONArray, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        this(jSONArray == null ? 0 : 1, str, jSONArray, abstractC1343b, abstractC1342a);
    }

    public C1376m(String str, JSONObject jSONObject, C1341p.AbstractC1343b<JSONArray> abstractC1343b, C1341p.AbstractC1342a abstractC1342a) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, abstractC1343b, abstractC1342a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.toolbox.AbstractC1378o, com.android.volley.AbstractC1333n
    /* renamed from: a */
    public C1341p<JSONArray> mo13155a(C1329j c1329j) {
        try {
            return C1341p.m16687a(new JSONArray(new String(c1329j.f4566b, C1362h.m16633a(c1329j.f4567c, "utf-8"))), C1362h.m16636a(c1329j));
        } catch (UnsupportedEncodingException e) {
            return C1341p.m16688a(new C1331l(e));
        } catch (JSONException e2) {
            return C1341p.m16688a(new C1331l(e2));
        }
    }
}
