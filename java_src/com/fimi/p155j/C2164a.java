package com.fimi.p155j;

import java.util.regex.Pattern;
/* renamed from: com.fimi.j.a */
/* loaded from: classes.dex */
public class C2164a {

    /* renamed from: a */
    private String f7280a;

    /* renamed from: b */
    private String f7281b;

    /* renamed from: a */
    public String m13349a() {
        return this.f7280a;
    }

    /* renamed from: a */
    public void m13348a(String str) {
        this.f7280a = Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
    }

    /* renamed from: b */
    public String m13347b() {
        return this.f7281b;
    }

    /* renamed from: b */
    public void m13346b(String str) {
        this.f7281b = Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
    }

    public String toString() {
        return "" + m13349a() + " " + m13347b();
    }
}
