package org.p248a.p249a.p282o;

import java.util.Collection;
/* renamed from: org.a.a.o.a */
/* loaded from: classes2.dex */
public class C5351a {
    /* renamed from: a */
    public static int m1324a(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str + " may not be negative or zero");
        }
        return i;
    }

    /* renamed from: a */
    public static long m1323a(long j, String str) {
        if (j <= 0) {
            throw new IllegalArgumentException(str + " may not be negative or zero");
        }
        return j;
    }

    /* renamed from: a */
    public static <T extends CharSequence> T m1322a(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!C5356f.m1297a(t)) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be empty");
    }

    /* renamed from: a */
    public static <T> T m1321a(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        return t;
    }

    /* renamed from: a */
    public static <E, T extends Collection<E>> T m1320a(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!t.isEmpty()) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be empty");
    }

    /* renamed from: a */
    public static void m1319a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m1318a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* renamed from: b */
    public static int m1317b(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(str + " may not be negative");
        }
        return i;
    }

    /* renamed from: b */
    public static long m1316b(long j, String str) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " may not be negative");
        }
        return j;
    }

    /* renamed from: b */
    public static <T extends CharSequence> T m1315b(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (!C5356f.m1296b(t)) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be blank");
    }
}
