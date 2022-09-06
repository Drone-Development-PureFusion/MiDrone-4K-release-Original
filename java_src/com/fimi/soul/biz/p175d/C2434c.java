package com.fimi.soul.biz.p175d;

import com.fimi.soul.base.LoadKey;
/* renamed from: com.fimi.soul.biz.d.c */
/* loaded from: classes.dex */
public class C2434c {

    /* renamed from: a */
    private String f8401a;

    /* renamed from: com.fimi.soul.biz.d.c$a */
    /* loaded from: classes.dex */
    public static class C2436a {

        /* renamed from: a */
        private static C2434c f8402a = new C2434c();
    }

    private C2434c() {
        this.f8401a = LoadKey.getKeyToken();
    }

    /* renamed from: a */
    public static C2434c m12195a() {
        return C2436a.f8402a;
    }

    /* renamed from: b */
    public String m12194b() {
        return this.f8401a;
    }
}
