package com.baidu.tts.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.fimi.soul.module.droneui.DroneMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
/* loaded from: classes.dex */
public class CommonUtility {
    /* renamed from: a */
    private static int[] m14678a(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i = 0;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            while (i > 0 && bArr[i] != bArr[i2]) {
                i = iArr[i - 1];
            }
            if (bArr[i] == bArr[i2]) {
                i++;
            }
            iArr[i2] = i;
        }
        return iArr;
    }

    public static byte[] addCAFHeaderForPCMData(byte[] bArr) {
        long j;
        long length;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        long length2 = ((16 * (44 + bArr.length)) * 1) / 8;
        byte[] bArr2 = {DroneMap.f12611n, 73, 70, 70, (byte) (255 & length), (byte) ((length >> 8) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, 16, 0, 0, 0, 1, 0, (byte) 1, 0, (byte) (255 & 16000), (byte) ((16000 >> 8) & 255), (byte) ((16000 >> 16) & 255), (byte) ((16000 >> 24) & 255), (byte) (255 & length2), (byte) ((length2 >> 8) & 255), (byte) ((length2 >> 16) & 255), (byte) ((length2 >> 24) & 255), 2, 0, 16, 0, 100, 97, 116, 97, (byte) (255 & j), (byte) ((j >> 8) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 24) & 255)};
        byte[] bArr3 = new byte[bArr2.length + bArr.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
        return bArr3;
    }

    public static byte[] copyBytesOfRange(byte[] bArr, int i, int i2) {
        if (i > i2 || i < 0 || i2 < 0 || i2 > bArr.length) {
            return null;
        }
        byte[] bArr2 = new byte[i2 - i];
        for (int i3 = i; i3 < i2; i3++) {
            bArr2[i3 - i] = bArr[i3];
        }
        return bArr2;
    }

    public static String generateSerialNumber() {
        return UUID.randomUUID().toString();
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int indexOf(byte[] bArr, byte[] bArr2, int i) {
        try {
            int[] m14678a = m14678a(bArr2);
            int i2 = 0;
            if (bArr.length == 0 || i >= bArr.length) {
                return -1;
            }
            while (i < bArr.length) {
                while (i2 > 0 && bArr2[i2] != bArr[i]) {
                    i2 = m14678a[i2 - 1];
                }
                if (bArr2[i2] == bArr[i]) {
                    i2++;
                }
                if (i2 == bArr2.length) {
                    return (i - bArr2.length) + 1;
                }
                i++;
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    public static byte[] shortArrayToByteArray(short[] sArr) {
        int length = sArr.length;
        ByteBuffer allocate = ByteBuffer.allocate(sArr.length * 2);
        allocate.clear();
        allocate.order(ByteOrder.nativeOrder());
        for (int i = 0; i < length; i++) {
            allocate.putShort(i * 2, sArr[i]);
        }
        return allocate.array();
    }
}
