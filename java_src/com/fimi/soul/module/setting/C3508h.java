package com.fimi.soul.module.setting;

import java.io.Serializable;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: com.fimi.soul.module.setting.h */
/* loaded from: classes.dex */
public class C3508h implements Serializable {

    /* renamed from: a */
    private String f13891a;

    /* renamed from: b */
    private boolean f13892b = false;

    /* renamed from: a */
    public String m8196a() {
        return this.f13891a;
    }

    /* renamed from: a */
    public void m8195a(String str) {
        this.f13891a = str;
    }

    /* renamed from: a */
    public void m8194a(boolean z) {
        this.f13892b = z;
    }

    /* renamed from: b */
    public boolean m8193b() {
        return this.f13892b;
    }

    public String toString() {
        return "RollerItemEntity{itemName='" + this.f13891a + C0359h.f729z + ", is_able=" + this.f13892b + C0359h.f726w;
    }
}
