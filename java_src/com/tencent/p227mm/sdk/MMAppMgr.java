package com.tencent.p227mm.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.p227mm.sdk.plugin.IMMPluginAPI;
import com.tencent.p227mm.sdk.plugin.MMPluginUtil;
/* renamed from: com.tencent.mm.sdk.MMAppMgr */
/* loaded from: classes.dex */
public final class MMAppMgr {
    private MMAppMgr() {
    }

    public static void activate(boolean z) {
    }

    public static IMMPluginAPI getPluginMgr(Context context) {
        return MMPluginUtil.queryPluginMgr(context);
    }

    public static SharedPreferences getSharedPreferences(Context context, int i) {
        return new MMSharedPreferences(context);
    }
}
