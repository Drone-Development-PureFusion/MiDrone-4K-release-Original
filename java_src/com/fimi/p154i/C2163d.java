package com.fimi.p154i;

import java.util.HashMap;
import java.util.Map;
/* renamed from: com.fimi.i.d */
/* loaded from: classes.dex */
public class C2163d {

    /* renamed from: a */
    private static C2163d f7278a = new C2163d();

    /* renamed from: b */
    private Map<Integer, C2161b> f7279b = new HashMap();

    /* renamed from: a */
    public static C2163d m13353a() {
        return f7278a;
    }

    /* renamed from: a */
    public C2161b m13352a(int i) {
        return this.f7279b.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void m13351a(C2161b c2161b) {
        this.f7279b.put(Integer.valueOf(c2161b.m13378a()), c2161b);
    }

    /* renamed from: b */
    public void m13350b() {
        this.f7279b.clear();
    }
}
