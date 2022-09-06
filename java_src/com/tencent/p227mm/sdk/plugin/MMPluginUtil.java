package com.tencent.p227mm.sdk.plugin;

import android.content.Context;
/* renamed from: com.tencent.mm.sdk.plugin.MMPluginUtil */
/* loaded from: classes2.dex */
public class MMPluginUtil {
    public static IMMPluginAPI queryPluginMgr(Context context) {
        return new MMPluginAPIImpl(context);
    }
}
