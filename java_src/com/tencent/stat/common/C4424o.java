package com.tencent.stat.common;

import java.io.File;
/* renamed from: com.tencent.stat.common.o */
/* loaded from: classes2.dex */
class C4424o {

    /* renamed from: a */
    private static int f18467a = -1;

    /* renamed from: a */
    public static boolean m5156a() {
        if (f18467a == 1) {
            return true;
        }
        if (f18467a == 0) {
            return false;
        }
        String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < strArr.length; i++) {
            try {
                File file = new File(strArr[i] + "su");
                if (file != null && file.exists()) {
                    f18467a = 1;
                    return true;
                }
            } catch (Exception e) {
            }
        }
        f18467a = 0;
        return false;
    }
}
