package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4478b;
import com.xiaomi.push.service.C4633aw;
/* loaded from: classes2.dex */
public class MiTinyDataClient {
    public static void init(Context context, String str) {
        if (context == null) {
            AbstractC4478b.m5036d("MiTinyDataClient.init(Context, String). Context can not be null");
        } else if (str == null) {
            AbstractC4478b.m5036d("MiTinyDataClient.init(Context, String). Channel can not be null.");
        } else {
            C4633aw.m4319a().m4310a(str);
        }
    }

    public static boolean upload(int i, String str, String str2, long j, String str3) {
        return C4633aw.m4319a().m4317a(i, str, str2, j, str3, false);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        return upload(0, str, str2, j, str3);
    }
}
