package com.xiaomi.infra.galaxy.fds.android.util;
/* loaded from: classes2.dex */
public class Args {
    public static void check(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void check(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, obj));
        }
    }

    public static void check(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends CharSequence> T notEmpty(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        if (t.length() != 0) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be empty");
    }

    public static int notNegative(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException(str + " may not be negative");
        }
        return i;
    }

    public static long notNegative(long j, String str) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " may not be negative");
        }
        return j;
    }

    public static <T> T notNull(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " may not be null");
        }
        return t;
    }

    public static int positive(int i, String str) {
        if (i <= 0) {
            throw new IllegalArgumentException(str + " may not be negative or zero");
        }
        return i;
    }

    public static long positive(long j, String str) {
        if (j <= 0) {
            throw new IllegalArgumentException(str + " may not be negative or zero");
        }
        return j;
    }
}
