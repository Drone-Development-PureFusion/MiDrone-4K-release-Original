package org.p318d.p319a;

import org.p248a.p249a.p252c.p255c.C5050o;
/* renamed from: org.d.a.c */
/* loaded from: classes2.dex */
public enum EnumC5724c {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, C5050o.f21556a);
    

    /* renamed from: f */
    private int f22978f;

    /* renamed from: g */
    private String f22979g;

    EnumC5724c(int i, String str) {
        this.f22978f = i;
        this.f22979g = str;
    }

    /* renamed from: a */
    public int m185a() {
        return this.f22978f;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f22979g;
    }
}
