package com.fimi.soul.biz.p175d;

import com.fimi.soul.drone.p193d.p194a.C2770c;
import java.util.HashMap;
/* renamed from: com.fimi.soul.biz.d.a */
/* loaded from: classes.dex */
public class C2429a {

    /* renamed from: a */
    public static C2429a f8382a;

    /* renamed from: b */
    private volatile HashMap<Integer, C2770c> f8383b = new HashMap<>();

    /* renamed from: a */
    public static C2429a m12215a() {
        if (f8382a == null) {
            synchronized (C2429a.class) {
                if (f8382a == null) {
                    f8382a = new C2429a();
                }
            }
        }
        return f8382a;
    }

    /* renamed from: a */
    public void m12214a(HashMap<Integer, C2770c> hashMap) {
        this.f8383b = hashMap;
    }

    /* renamed from: b */
    public HashMap<Integer, C2770c> m12213b() {
        return this.f8383b;
    }
}
