package org.p287b.p288a;

import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.g */
/* loaded from: classes.dex */
public class C5400g<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private final String f22478a;

    public C5400g() {
        this("ANYTHING");
    }

    public C5400g(String str) {
        this.f22478a = str;
    }

    @AbstractC5428i
    /* renamed from: a */
    public static AbstractC5430k<Object> m1173a(String str) {
        return new C5400g(str);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static AbstractC5430k<Object> m1172b() {
        return new C5400g();
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1086a(this.f22478a);
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return true;
    }
}
