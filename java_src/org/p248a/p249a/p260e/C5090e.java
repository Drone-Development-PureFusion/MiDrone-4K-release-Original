package org.p248a.p249a.p260e;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.e.e */
/* loaded from: classes2.dex */
public final class C5090e<I> {

    /* renamed from: a */
    private final Map<String, I> f21711a = new HashMap();

    C5090e() {
    }

    /* renamed from: a */
    public static <I> C5090e<I> m2042a() {
        return new C5090e<>();
    }

    /* renamed from: a */
    public C5090e<I> m2041a(String str, I i) {
        C5351a.m1322a(str, "ID");
        C5351a.m1321a(i, "Item");
        this.f21711a.put(str.toLowerCase(Locale.US), i);
        return this;
    }

    /* renamed from: b */
    public C5089d<I> m2040b() {
        return new C5089d<>(this.f21711a);
    }

    public String toString() {
        return this.f21711a.toString();
    }
}
