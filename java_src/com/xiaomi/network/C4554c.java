package com.xiaomi.network;

import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.xiaomi.network.c */
/* loaded from: classes.dex */
class C4554c implements Comparable<C4554c> {

    /* renamed from: a */
    String f18709a;

    /* renamed from: b */
    protected int f18710b;

    /* renamed from: c */
    private final LinkedList<AccessHistory> f18711c;

    /* renamed from: d */
    private long f18712d;

    public C4554c() {
        this(null, 0);
    }

    public C4554c(String str, int i) {
        this.f18711c = new LinkedList<>();
        this.f18712d = 0L;
        this.f18709a = str;
        this.f18710b = i;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C4554c c4554c) {
        if (c4554c == null) {
            return 1;
        }
        return c4554c.f18710b - this.f18710b;
    }

    /* renamed from: a */
    public synchronized C4554c m4732a(JSONObject jSONObject) {
        this.f18712d = jSONObject.getLong("tt");
        this.f18710b = jSONObject.getInt("wt");
        this.f18709a = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("ah");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f18711c.add(new AccessHistory().m4777a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* renamed from: a */
    public synchronized JSONObject m4735a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("tt", this.f18712d);
        jSONObject.put("wt", this.f18710b);
        jSONObject.put("host", this.f18709a);
        JSONArray jSONArray = new JSONArray();
        Iterator<AccessHistory> it2 = this.f18711c.iterator();
        while (it2.hasNext()) {
            jSONArray.put(it2.next().m4776b());
        }
        jSONObject.put("ah", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void m4734a(AccessHistory accessHistory) {
        if (accessHistory != null) {
            this.f18711c.add(accessHistory);
            int m4778a = accessHistory.m4778a();
            if (m4778a > 0) {
                this.f18710b += accessHistory.m4778a();
            } else {
                int i = 0;
                for (int size = this.f18711c.size() - 1; size >= 0 && this.f18711c.get(size).m4778a() < 0; size--) {
                    i++;
                }
                this.f18710b += m4778a * i;
            }
            if (this.f18711c.size() > 30) {
                this.f18710b -= this.f18711c.remove().m4778a();
            }
        }
    }

    public String toString() {
        return this.f18709a + ":" + this.f18710b;
    }
}
