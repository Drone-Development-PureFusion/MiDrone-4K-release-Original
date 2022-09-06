package com.p080b;

import android.content.Context;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AmapLoc;
import com.fimi.soul.utils.p211a.C3628c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONObject;
/* renamed from: com.b.bi */
/* loaded from: classes.dex */
public class C1463bi {

    /* renamed from: a */
    private static C1463bi f5083a = null;

    /* renamed from: b */
    private Hashtable<String, JSONObject> f5084b = new Hashtable<>();

    /* renamed from: c */
    private boolean f5085c = false;

    private C1463bi() {
    }

    /* renamed from: a */
    public static synchronized C1463bi m16090a() {
        C1463bi c1463bi;
        synchronized (C1463bi.class) {
            if (f5083a == null) {
                f5083a = new C1463bi();
            }
            c1463bi = f5083a;
        }
        return c1463bi;
    }

    /* renamed from: d */
    private void m16084d() {
        if (!this.f5084b.isEmpty()) {
            this.f5084b.clear();
        }
    }

    /* renamed from: a */
    public void m16089a(Context context) {
        if (C1443av.f5007a && !this.f5085c) {
            C1477bs.m15997b();
            try {
                C1461bg.m16100a().m16094b(context);
            } catch (Throwable th) {
                C1514cx.m15728a(th, "HeatMap", "loadDB");
            }
            this.f5085c = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (r9.f5084b.containsKey(r3) != false) goto L13;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void m16088a(Context context, String str, AmapLoc amapLoc) {
        String str2 = null;
        if (C1477bs.m16006a(amapLoc) && context != null && C1443av.f5007a) {
            if (this.f5084b.size() > 500) {
                str2 = C1448ay.m16213a(amapLoc.m16520i(), amapLoc.m16522h());
            }
            if (str2 == null) {
                str2 = C1448ay.m16213a(amapLoc.m16520i(), amapLoc.m16522h());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", str);
            jSONObject.put("lat", amapLoc.m16520i());
            jSONObject.put("lon", amapLoc.m16522h());
            m16087a(context, str2, jSONObject.toString(), 1, C1477bs.m16020a(), true);
        }
    }

    /* renamed from: a */
    public synchronized void m16087a(Context context, String str, String str2, int i, long j, boolean z) {
        if (context != null) {
            if (!TextUtils.isEmpty(str) && C1443av.f5007a) {
                JSONObject jSONObject = this.f5084b.get(str);
                JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
                jSONObject2.put("x", str2);
                jSONObject2.put(C3628c.C3629a.f14776i, j);
                if (this.f5084b.containsKey(str)) {
                    jSONObject2.put("num", jSONObject2.getInt("num") + i);
                } else {
                    jSONObject2.put("num", i);
                }
                this.f5084b.put(str, jSONObject2);
                if (z) {
                    C1461bg.m16100a().m16097a(context, str, str2, j);
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized ArrayList<C1462bh> m16086b() {
        ArrayList<C1462bh> arrayList;
        ArrayList<C1462bh> arrayList2 = new ArrayList<>();
        if (this.f5084b.isEmpty()) {
            arrayList = arrayList2;
        } else {
            Hashtable<String, JSONObject> hashtable = this.f5084b;
            ArrayList arrayList3 = new ArrayList(hashtable.keySet());
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                JSONObject jSONObject = hashtable.get(str);
                int i = jSONObject.getInt("num");
                String string = jSONObject.getString("x");
                long j = jSONObject.getLong(C3628c.C3629a.f14776i);
                if (i >= 120) {
                    arrayList2.add(new C1462bh(str, j, i, string));
                }
            }
            Collections.sort(arrayList2, new Comparator<C1462bh>() { // from class: com.b.bi.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(C1462bh c1462bh, C1462bh c1462bh2) {
                    return c1462bh2.m16091b() - c1462bh.m16091b();
                }
            });
            arrayList3.clear();
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m16085c() {
        m16090a().m16084d();
        this.f5085c = false;
    }
}
