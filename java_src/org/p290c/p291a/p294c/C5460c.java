package org.p290c.p291a.p294c;

import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5430k;
import org.p287b.AbstractC5435p;
/* renamed from: org.c.a.c.c */
/* loaded from: classes2.dex */
public class C5460c {
    /* renamed from: a */
    public static AbstractC5430k<C5459b> m1003a() {
        return m1002a(0);
    }

    /* renamed from: a */
    public static AbstractC5430k<C5459b> m1002a(final int i) {
        return new AbstractC5435p<C5459b>() { // from class: org.c.a.c.c.1
            @Override // org.p287b.AbstractC5432m
            /* renamed from: a */
            public void mo905a(AbstractC5425g abstractC5425g) {
                abstractC5425g.mo1086a("has " + i + " failures");
            }

            @Override // org.p287b.AbstractC5435p
            /* renamed from: a */
            public boolean mo903b(C5459b c5459b) {
                return c5459b.m1006a() == i;
            }
        };
    }

    /* renamed from: a */
    public static AbstractC5430k<Object> m1001a(final String str) {
        return new AbstractC5412b<Object>() { // from class: org.c.a.c.c.2
            @Override // org.p287b.AbstractC5432m
            /* renamed from: a */
            public void mo905a(AbstractC5425g abstractC5425g) {
                abstractC5425g.mo1086a("has single failure containing " + str);
            }

            @Override // org.p287b.AbstractC5430k
            /* renamed from: a */
            public boolean mo900a(Object obj) {
                return obj.toString().contains(str) && C5460c.m1002a(1).mo900a(obj);
            }
        };
    }

    /* renamed from: b */
    public static AbstractC5430k<C5459b> m1000b(final String str) {
        return new AbstractC5412b<C5459b>() { // from class: org.c.a.c.c.3
            @Override // org.p287b.AbstractC5432m
            /* renamed from: a */
            public void mo905a(AbstractC5425g abstractC5425g) {
                abstractC5425g.mo1086a("has failure containing " + str);
            }

            @Override // org.p287b.AbstractC5430k
            /* renamed from: a */
            public boolean mo900a(Object obj) {
                return obj.toString().contains(str);
            }
        };
    }
}
