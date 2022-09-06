package org.p287b.p288a;

import java.lang.reflect.Array;
import org.p287b.AbstractC5412b;
import org.p287b.AbstractC5425g;
import org.p287b.AbstractC5428i;
import org.p287b.AbstractC5430k;
/* renamed from: org.b.a.i */
/* loaded from: classes.dex */
public class C5402i<T> extends AbstractC5412b<T> {

    /* renamed from: a */
    private final Object f22480a;

    public C5402i(T t) {
        this.f22480a = t;
    }

    /* renamed from: a */
    private static boolean m1166a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : (obj2 == null || !m1163c(obj)) ? obj.equals(obj2) : m1163c(obj2) && m1164b(obj, obj2);
    }

    @AbstractC5428i
    /* renamed from: b */
    public static <T> AbstractC5430k<T> m1165b(T t) {
        return new C5402i(t);
    }

    /* renamed from: b */
    private static boolean m1164b(Object obj, Object obj2) {
        return m1162c(obj, obj2) && m1161d(obj, obj2);
    }

    /* renamed from: c */
    private static boolean m1163c(Object obj) {
        return obj.getClass().isArray();
    }

    /* renamed from: c */
    private static boolean m1162c(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    /* renamed from: d */
    private static boolean m1161d(Object obj, Object obj2) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            if (!m1166a(Array.get(obj, i), Array.get(obj2, i))) {
                return false;
            }
        }
        return true;
    }

    @Override // org.p287b.AbstractC5432m
    /* renamed from: a */
    public void mo905a(AbstractC5425g abstractC5425g) {
        abstractC5425g.mo1087a(this.f22480a);
    }

    @Override // org.p287b.AbstractC5430k
    /* renamed from: a */
    public boolean mo900a(Object obj) {
        return m1166a(obj, this.f22480a);
    }
}
