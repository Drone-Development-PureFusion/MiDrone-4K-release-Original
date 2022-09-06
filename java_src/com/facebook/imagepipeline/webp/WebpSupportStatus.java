package com.facebook.imagepipeline.webp;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class WebpSupportStatus {
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private static final String VP8X_WEBP_BASE64 = "UklGRkoAAABXRUJQVlA4WAoAAAAQAAAAAAAAAAAAQUxQSAwAAAARBxAR/Q9ERP8DAABWUDggGAAAABQBAJ0BKgEAAQAAAP4AAA3AAP7mtQAAAA==";
    private static final byte[] WEBP_NAME_BYTES;
    private static final byte[] WEBP_RIFF_BYTES;
    private static final byte[] WEBP_VP8L_BYTES;
    private static final byte[] WEBP_VP8X_BYTES;
    private static final byte[] WEBP_VP8_BYTES;
    public static final boolean sIsExtendedWebpSupported;
    public static final boolean sIsSimpleWebpSupported;
    public static final boolean sIsWebpSupportRequired;

    static {
        boolean z = true;
        sIsWebpSupportRequired = Build.VERSION.SDK_INT <= 17;
        if (Build.VERSION.SDK_INT < 14) {
            z = false;
        }
        sIsSimpleWebpSupported = z;
        sIsExtendedWebpSupported = isExtendedWebpSupported();
        WEBP_RIFF_BYTES = asciiBytes("RIFF");
        WEBP_NAME_BYTES = asciiBytes("WEBP");
        WEBP_VP8_BYTES = asciiBytes("VP8 ");
        WEBP_VP8L_BYTES = asciiBytes("VP8L");
        WEBP_VP8X_BYTES = asciiBytes("VP8X");
    }

    private static byte[] asciiBytes(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    public static boolean isAnimatedWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) && ((bArr[i + 20] & 2) == 2);
    }

    public static boolean isExtendedWebpHeader(byte[] bArr, int i, int i2) {
        return i2 >= 21 && matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES);
    }

    public static boolean isExtendedWebpHeaderWithAlpha(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8X_BYTES) && ((bArr[i + 20] & 16) == 16);
    }

    private static boolean isExtendedWebpSupported() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (Build.VERSION.SDK_INT == 17) {
            byte[] decode = Base64.decode(VP8X_WEBP_BASE64, 0);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
            if (options.outHeight != 1 || options.outWidth != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLosslessWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8L_BYTES);
    }

    public static boolean isSimpleWebpHeader(byte[] bArr, int i) {
        return matchBytePattern(bArr, i + 12, WEBP_VP8_BYTES);
    }

    public static boolean isWebpHeader(byte[] bArr, int i, int i2) {
        return i2 >= 20 && matchBytePattern(bArr, i, WEBP_RIFF_BYTES) && matchBytePattern(bArr, i + 8, WEBP_NAME_BYTES);
    }

    public static boolean isWebpPlatformSupported(byte[] bArr, int i, int i2) {
        if (isSimpleWebpHeader(bArr, i)) {
            return sIsSimpleWebpSupported;
        }
        if (isLosslessWebpHeader(bArr, i)) {
            return sIsExtendedWebpSupported;
        }
        if (isExtendedWebpHeader(bArr, i, i2) && !isAnimatedWebpHeader(bArr, i)) {
            return sIsExtendedWebpSupported;
        }
        return false;
    }

    private static boolean matchBytePattern(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
