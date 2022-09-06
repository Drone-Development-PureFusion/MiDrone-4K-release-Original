package org.p290c;

import java.util.Arrays;
import org.p287b.AbstractC5430k;
import org.p287b.C5422d;
/* renamed from: org.c.d */
/* loaded from: classes2.dex */
public class C5564d {
    /* renamed from: a */
    public static <T> void m690a(T t, AbstractC5430k<T> abstractC5430k) {
        if (!abstractC5430k.mo900a(t)) {
            throw new C5592e(t, abstractC5430k);
        }
    }

    /* renamed from: a */
    public static <T> void m689a(String str, T t, AbstractC5430k<T> abstractC5430k) {
        if (!abstractC5430k.mo900a(t)) {
            throw new C5592e(str, t, abstractC5430k);
        }
    }

    /* renamed from: a */
    public static void m688a(String str, Throwable th) {
        m689a(str, th, C5422d.m1115b());
    }

    /* renamed from: a */
    public static void m687a(String str, boolean z) {
        if (!z) {
            throw new C5592e(str);
        }
    }

    /* renamed from: a */
    public static void m686a(Throwable th) {
        m690a(th, (AbstractC5430k<Throwable>) C5422d.m1115b());
    }

    /* renamed from: a */
    public static void m685a(boolean z) {
        m690a(Boolean.valueOf(z), C5422d.m1126a(true));
    }

    /* renamed from: a */
    public static void m684a(Object... objArr) {
        m690a(Arrays.asList(objArr), C5422d.m1099c((AbstractC5430k) C5422d.m1103c()));
    }

    /* renamed from: b */
    public static void m683b(String str, boolean z) {
        m687a(str, !z);
    }

    /* renamed from: b */
    public static void m682b(boolean z) {
        m685a(!z);
    }
}
