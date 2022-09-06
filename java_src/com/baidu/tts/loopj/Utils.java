package com.baidu.tts.loopj;
/* loaded from: classes.dex */
class Utils {
    private Utils() {
    }

    public static void asserts(boolean z, String str) {
        if (!z) {
            throw new AssertionError(str);
        }
    }

    public static <T> T notNull(T t, String str) {
        if (t == null) {
            throw new IllegalArgumentException(str + " should not be null!");
        }
        return t;
    }
}
