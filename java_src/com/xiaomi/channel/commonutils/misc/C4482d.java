package com.xiaomi.channel.commonutils.misc;

import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.xiaomi.channel.commonutils.misc.d */
/* loaded from: classes2.dex */
public class C4482d {

    /* renamed from: a */
    static final char[] f18548a = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public static String m5029a(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder(i2 * 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i + i3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
            sb.append(f18548a[i4 >> 4]);
            sb.append(f18548a[i4 & 15]);
        }
        return sb.toString();
    }
}
