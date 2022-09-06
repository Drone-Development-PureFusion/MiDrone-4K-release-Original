package com.fimi.soul.utils;

import android.content.res.AssetManager;
/* renamed from: com.fimi.soul.utils.b */
/* loaded from: classes.dex */
public class C3672b {
    /* renamed from: a */
    public static boolean m7510a(AssetManager assetManager, String str, String str2) {
        for (String str3 : assetManager.list(str)) {
            if (str3.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
