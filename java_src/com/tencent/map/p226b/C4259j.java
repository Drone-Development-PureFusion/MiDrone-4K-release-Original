package com.tencent.map.p226b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.tencent.map.b.j */
/* loaded from: classes.dex */
public final class C4259j {
    /* renamed from: a */
    public static String m5688a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString(b & SmileConstants.BYTE_MARKER_END_OF_CONTENT)).append("");
            }
            return sb.toString();
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: a */
    public static byte[] m5687a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m5686b(byte[] bArr) {
        byte[] bArr2;
        int i = 0;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = new byte[1024];
        while (true) {
            try {
                int read = inflaterInputStream.read(bArr4);
                if (read > 0) {
                    i += read;
                    bArr2 = new byte[i];
                    System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
                    System.arraycopy(bArr4, 0, bArr2, bArr3.length, read);
                } else {
                    bArr2 = bArr3;
                }
                if (read <= 0) {
                    try {
                        byteArrayInputStream.close();
                        inflaterInputStream.close();
                        return bArr2;
                    } catch (IOException e) {
                        return null;
                    }
                }
                bArr3 = bArr2;
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
