package com.facebook.common.util;

import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class HashCodeUtil {

    /* renamed from: X */
    private static final int f6951X = 31;

    public static int hashCode(int i) {
        return i + 31;
    }

    public static int hashCode(int i, int i2) {
        return ((i + 31) * 31) + i2;
    }

    public static int hashCode(int i, int i2, int i3) {
        return ((((i + 31) * 31) + i2) * 31) + i3;
    }

    public static int hashCode(int i, int i2, int i3, int i4) {
        return ((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4;
    }

    public static int hashCode(int i, int i2, int i3, int i4, int i5) {
        return ((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5;
    }

    public static int hashCode(int i, int i2, int i3, int i4, int i5, int i6) {
        return ((((((((((i + 31) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + i5) * 31) + i6;
    }

    public static int hashCode(@Nullable Object obj) {
        return hashCode(obj == null ? 0 : obj.hashCode());
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return hashCode(hashCode, i);
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
        if (obj3 != null) {
            i = obj3.hashCode();
        }
        return hashCode(hashCode, hashCode2, i);
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
        int hashCode3 = obj3 == null ? 0 : obj3.hashCode();
        if (obj4 != null) {
            i = obj4.hashCode();
        }
        return hashCode(hashCode, hashCode2, hashCode3, i);
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
        int hashCode3 = obj3 == null ? 0 : obj3.hashCode();
        int hashCode4 = obj4 == null ? 0 : obj4.hashCode();
        if (obj5 != null) {
            i = obj5.hashCode();
        }
        return hashCode(hashCode, hashCode2, hashCode3, hashCode4, i);
    }

    public static int hashCode(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        int hashCode2 = obj2 == null ? 0 : obj2.hashCode();
        int hashCode3 = obj3 == null ? 0 : obj3.hashCode();
        int hashCode4 = obj4 == null ? 0 : obj4.hashCode();
        int hashCode5 = obj5 == null ? 0 : obj5.hashCode();
        if (obj6 != null) {
            i = obj6.hashCode();
        }
        return hashCode(hashCode, hashCode2, hashCode3, hashCode4, hashCode5, i);
    }
}
