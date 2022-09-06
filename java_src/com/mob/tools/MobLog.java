package com.mob.tools;

import com.mob.tools.log.NLog;
/* loaded from: classes.dex */
public class MobLog extends NLog {
    private MobLog() {
    }

    public static NLog getInstance() {
        return getInstanceForSDK("MOBTOOLS", true);
    }

    @Override // com.mob.tools.log.NLog
    protected String getSDKTag() {
        return "MOBTOOLS";
    }
}
