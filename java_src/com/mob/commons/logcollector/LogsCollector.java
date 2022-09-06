package com.mob.commons.logcollector;

import android.content.Context;
import android.content.Intent;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.MobLog;
import com.mob.tools.log.LogCollector;
import com.tencent.open.SocialConstants;
/* loaded from: classes.dex */
public abstract class LogsCollector implements LogCollector {

    /* renamed from: a */
    private C4154c f17320a;

    /* renamed from: b */
    private boolean f17321b;

    public LogsCollector(Context context) {
        this.f17320a = C4154c.m6000a(context);
        this.f17320a.m6002a(getSDKVersion(), getSDKTag(), getAppkey());
        try {
            if (context.getPackageManager().getPackageInfo("cn.sharesdk.log", 64) != null) {
                this.f17321b = true;
            }
        } catch (Throwable th) {
        }
        this.f17321b = false;
    }

    /* renamed from: a */
    final int m6010a(int i, String str) {
        if (this.f17320a.m6004a() == null || !this.f17321b) {
            return 0;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("cn.sharesdk.log");
            intent.putExtra("package", this.f17320a.m6004a().getPackageName());
            intent.putExtra("priority", i);
            intent.putExtra(SocialConstants.PARAM_SEND_MSG, str);
            this.f17320a.m6004a().sendBroadcast(intent);
            return 0;
        } catch (Throwable th) {
            MobLog.getInstance().m5959w(th);
            return 0;
        }
    }

    protected abstract String getAppkey();

    protected abstract String getSDKTag();

    protected abstract int getSDKVersion();

    @Override // com.mob.tools.log.LogCollector
    public final void log(String str, int i, int i2, String str2, String str3) {
        m6010a(i, str3);
        if (str == null || !str.equals(getSDKTag())) {
            return;
        }
        if (ShareSDK.SDK_TAG.equals(str) && (!str3.contains("com.mob.") || !str3.contains("cn.sharesdk."))) {
            return;
        }
        if (i2 == 1) {
            this.f17320a.m5995b(getSDKVersion(), i2, str, getAppkey(), str3);
        } else if (i2 == 2) {
            this.f17320a.m6003a(getSDKVersion(), i2, str, getAppkey(), str3);
        } else if (i != 5) {
        } else {
            this.f17320a.m6003a(getSDKVersion(), i2, str, getAppkey(), str3);
        }
    }
}
