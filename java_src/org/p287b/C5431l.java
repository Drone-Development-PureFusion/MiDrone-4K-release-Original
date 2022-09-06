package org.p287b;
/* renamed from: org.b.l */
/* loaded from: classes2.dex */
public class C5431l {
    /* renamed from: a */
    public static <T> void m1078a(T t, AbstractC5430k<? super T> abstractC5430k) {
        m1077a("", t, abstractC5430k);
    }

    /* renamed from: a */
    public static <T> void m1077a(String str, T t, AbstractC5430k<? super T> abstractC5430k) {
        if (!abstractC5430k.mo900a(t)) {
            C5433n c5433n = new C5433n();
            c5433n.mo1086a(str).mo1086a("\nExpected: ").mo1083a((AbstractC5432m) abstractC5430k).mo1086a("\n     but: ");
            abstractC5430k.mo1070a(t, c5433n);
            throw new AssertionError(c5433n.toString());
        }
    }

    /* renamed from: a */
    public static void m1076a(String str, boolean z) {
        if (!z) {
            throw new AssertionError(str);
        }
    }
}
