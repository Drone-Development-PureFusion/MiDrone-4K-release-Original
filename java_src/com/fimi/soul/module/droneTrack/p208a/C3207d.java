package com.fimi.soul.module.droneTrack.p208a;

import com.fimi.soul.module.droneTrack.AbstractC3217f;
import com.fimi.soul.module.droneTrack.C3214c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* renamed from: com.fimi.soul.module.droneTrack.a.d */
/* loaded from: classes.dex */
public class C3207d {

    /* renamed from: a */
    private C3210e f12324a = new C3210e();

    /* renamed from: b */
    private C3210e f12325b = new C3210e();

    /* renamed from: c */
    private C3210e f12326c = new C3210e();

    /* renamed from: d */
    private C3210e f12327d = new C3210e();

    /* renamed from: e */
    private AbstractC3217f f12328e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9120a(HashMap<Integer, List<Object>> hashMap, HashMap<Integer, List<Object>> hashMap2) {
        int size = hashMap.size();
        for (Map.Entry<Integer, List<Object>> entry : hashMap2.entrySet()) {
            hashMap.put(Integer.valueOf(entry.getKey().intValue() + size), entry.getValue());
        }
    }

    /* renamed from: a */
    public C3210e m9124a() {
        return this.f12327d;
    }

    /* renamed from: a */
    public void m9121a(AbstractC3217f abstractC3217f) {
        this.f12328e = abstractC3217f;
    }

    /* renamed from: b */
    public C3210e m9119b() {
        return this.f12326c;
    }

    /* renamed from: c */
    public C3210e m9117c() {
        return this.f12325b;
    }

    /* renamed from: d */
    public C3210e m9115d() {
        return this.f12324a;
    }

    /* renamed from: e */
    public void m9113e() {
        C3214c.m9086b(new Runnable() { // from class: com.fimi.soul.module.droneTrack.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                while (C3207d.this.f12324a != null && C3207d.this.f12325b != null && C3207d.this.f12326c != null && C3207d.this.f12327d != null) {
                    if (!C3207d.this.f12324a.m9109a() || !C3207d.this.f12325b.m9109a() || !C3207d.this.f12326c.m9109a() || !C3207d.this.f12327d.m9109a()) {
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        LinkedHashMap<Integer, List<Object>> m9148b = C3203b.m9155a().m9148b();
                        m9148b.putAll(C3207d.this.f12324a.m9104b());
                        C3207d.this.m9120a(m9148b, C3207d.this.f12325b.m9104b());
                        C3207d.this.m9120a(m9148b, C3207d.this.f12326c.m9104b());
                        C3207d.this.m9120a(m9148b, C3207d.this.f12327d.m9104b());
                        Collections.sort(new ArrayList(m9148b.entrySet()), new Comparator<Map.Entry<Integer, List<Object>>>() { // from class: com.fimi.soul.module.droneTrack.a.d.1.1
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(Map.Entry<Integer, List<Object>> entry, Map.Entry<Integer, List<Object>> entry2) {
                                return entry.getKey().intValue() - entry2.getKey().intValue();
                            }
                        });
                        if (C3207d.this.f12328e != null) {
                            C3207d.this.f12328e.mo9083a();
                            return;
                        }
                    }
                }
            }
        });
    }

    /* renamed from: f */
    public void m9111f() {
        this.f12324a.m9103b(true);
        this.f12325b.m9103b(true);
        this.f12326c.m9103b(true);
        this.f12327d.m9103b(true);
        this.f12324a.m9102c();
        this.f12325b.m9102c();
        this.f12326c.m9102c();
        this.f12327d.m9102c();
        this.f12324a = null;
        this.f12325b = null;
        this.f12326c = null;
        this.f12327d = null;
    }
}
