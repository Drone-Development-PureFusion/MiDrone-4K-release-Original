package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
/* renamed from: com.amap.api.mapcore.util.ef */
/* loaded from: classes.dex */
public class C0943ef {

    /* renamed from: a */
    private static boolean f2896a;

    static {
        f2896a = false;
        f2896a = new File("/system/framework/amap.jar").exists();
    }

    /* renamed from: a */
    public static AssetManager m18372a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (!f2896a) {
            return assets;
        }
        try {
            assets.getClass().getDeclaredMethod("addAssetPath", String.class).invoke(assets, "/system/framework/amap.jar");
            return assets;
        } catch (Throwable th) {
            C1007fo.m18012b(th, "ResourcesUtil", "getSelfAssets");
            return assets;
        }
    }
}
