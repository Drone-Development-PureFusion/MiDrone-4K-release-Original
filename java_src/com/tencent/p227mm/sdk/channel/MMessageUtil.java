package com.tencent.p227mm.sdk.channel;

import com.tencent.p227mm.algorithm.MD5;
/* renamed from: com.tencent.mm.sdk.channel.MMessageUtil */
/* loaded from: classes.dex */
public class MMessageUtil {
    private MMessageUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static byte[] m5662a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(553844737);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return MD5.getMessageDigest(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
