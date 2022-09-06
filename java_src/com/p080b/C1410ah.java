package com.p080b;
/* renamed from: com.b.ah */
/* loaded from: classes.dex */
public class C1410ah {
    /* renamed from: a */
    public static int m16402a(String str, String str2) {
        int i = 0;
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            for (int i2 = 0; i2 < min; i2++) {
                i = split[i2].length() - split2[i2].length();
                if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                    break;
                }
            }
            return i != 0 ? i : split.length - split2.length;
        } catch (Exception e) {
            C1450b.m16187a(e, "Utils", "compareVersion");
            return -1;
        }
    }
}
