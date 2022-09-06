package com.mob.commons;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
/* loaded from: classes.dex */
public class SHARESDK implements MobProduct {
    private static String appKey;

    public static void setAppKey(String str) {
        appKey = str;
    }

    public String getDuid(Context context) {
        return DeviceAuthorizer.authorize(context, this);
    }

    @Override // com.mob.commons.MobProduct
    public String getProductAppkey() {
        return appKey;
    }

    @Override // com.mob.commons.MobProduct
    public String getProductTag() {
        return ShareSDK.SDK_TAG;
    }

    @Override // com.mob.commons.MobProduct
    public int getSdkver() {
        return 60070;
    }
}
