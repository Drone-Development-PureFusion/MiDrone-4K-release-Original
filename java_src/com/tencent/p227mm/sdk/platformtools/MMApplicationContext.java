package com.tencent.p227mm.sdk.platformtools;

import android.content.Context;
import com.tencent.p227mm.sdk.plugin.MMPluginProviderConstants;
/* renamed from: com.tencent.mm.sdk.platformtools.MMApplicationContext */
/* loaded from: classes.dex */
public final class MMApplicationContext {

    /* renamed from: R */
    private static Context f17832R = null;

    /* renamed from: aE */
    private static String f17833aE = MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN;

    private MMApplicationContext() {
    }

    public static Context getContext() {
        return f17832R;
    }

    public static String getDefaultPreferencePath() {
        return f17833aE + "_preferences";
    }

    public static String getPackageName() {
        return f17833aE;
    }

    public static void setContext(Context context) {
        f17832R = context;
        f17833aE = context.getPackageName();
        Log.m5649d("MicroMsg.MMApplicationContext", "setup application context for package: " + f17833aE);
    }
}
