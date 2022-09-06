package cn.sharesdk.framework.utils;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;
/* renamed from: cn.sharesdk.framework.utils.d */
/* loaded from: classes.dex */
public class C0683d extends NLog {
    private C0683d(Context context, final int i, final String str) {
        setCollector(ShareSDK.SDK_TAG, new LogsCollector(context) { // from class: cn.sharesdk.framework.utils.d.1
            @Override // com.mob.commons.logcollector.LogsCollector
            protected String getAppkey() {
                return str;
            }

            @Override // com.mob.commons.logcollector.LogsCollector
            protected String getSDKTag() {
                return ShareSDK.SDK_TAG;
            }

            @Override // com.mob.commons.logcollector.LogsCollector
            protected int getSDKVersion() {
                return i;
            }
        });
    }

    /* renamed from: a */
    public static NLog m19513a() {
        return getInstanceForSDK(ShareSDK.SDK_TAG, true);
    }

    /* renamed from: a */
    public static NLog m19512a(Context context, int i, String str) {
        return new C0683d(context, i, str);
    }

    @Override // com.mob.tools.log.NLog
    protected String getSDKTag() {
        return ShareSDK.SDK_TAG;
    }
}
