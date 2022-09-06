package org.p287b.p288a;

import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.q */
/* loaded from: classes.dex */
public class C5410q extends AbstractC5411r {
    public C5410q(String str) {
        super(str);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static AbstractC5430k<String> m1145b(String str) {
        return new C5410q(str);
    }

    @Override // org.p287b.p288a.AbstractC5411r
    /* renamed from: a */
    protected boolean mo1144a(String str) {
        return str.startsWith(this.f22486a);
    }

    @Override // org.p287b.p288a.AbstractC5411r
    /* renamed from: b */
    protected String mo1142b() {
        return "starting with";
    }
}
