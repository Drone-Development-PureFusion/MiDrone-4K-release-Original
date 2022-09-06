package com.tencent.p227mm.sdk.openapi;

import android.content.Context;
/* renamed from: com.tencent.mm.sdk.openapi.WXAPIFactory */
/* loaded from: classes.dex */
public class WXAPIFactory {

    /* renamed from: Q */
    private static WXAPIFactory f17789Q = null;

    private WXAPIFactory() {
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        if (f17789Q == null) {
            f17789Q = new WXAPIFactory();
        }
        return new WXApiImplV10(context, str);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        if (f17789Q == null) {
            f17789Q = new WXAPIFactory();
        }
        return new WXApiImplV10(context, str, z);
    }
}
