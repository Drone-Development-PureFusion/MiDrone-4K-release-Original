package com.fimi.kernel.utils;

import java.io.File;
import java.io.IOException;
/* renamed from: com.fimi.kernel.utils.u */
/* loaded from: classes.dex */
public class C2276u {
    /* renamed from: a */
    public static String m12789a(File file) {
        try {
            return C2268m.m12905a(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m12788a(String str) {
        return m12789a(new File(str));
    }
}
