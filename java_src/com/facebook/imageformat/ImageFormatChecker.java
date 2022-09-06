package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imagepipeline.webp.WebpSupportStatus;
import com.fimi.soul.module.droneui.DroneMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class ImageFormatChecker {
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final int GIF_HEADER_LENGTH = 6;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    private static final byte[] JPEG_HEADER = {-1, -40, -1};
    private static final byte[] PNG_HEADER = {-119, DroneMap.f12610m, 78, 71, 13, 10, 26, 10};
    private static final byte[] GIF_HEADER_87A = asciiBytes("GIF87a");
    private static final byte[] GIF_HEADER_89A = asciiBytes("GIF89a");
    private static final byte[] BMP_HEADER = asciiBytes("BM");
    private static final int MAX_HEADER_LENGTH = Ints.max(21, 20, JPEG_HEADER.length, PNG_HEADER.length, 6, BMP_HEADER.length);

    private ImageFormatChecker() {
    }

    private static byte[] asciiBytes(String str) {
        Preconditions.checkNotNull(str);
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    private static ImageFormat doGetImageFormat(byte[] bArr, int i) {
        Preconditions.checkNotNull(bArr);
        return WebpSupportStatus.isWebpHeader(bArr, 0, i) ? getWebpFormat(bArr, i) : isJpegHeader(bArr, i) ? ImageFormat.JPEG : isPngHeader(bArr, i) ? ImageFormat.PNG : isGifHeader(bArr, i) ? ImageFormat.GIF : isBmpHeader(bArr, i) ? ImageFormat.BMP : ImageFormat.UNKNOWN;
    }

    public static ImageFormat getImageFormat(InputStream inputStream) {
        Preconditions.checkNotNull(inputStream);
        byte[] bArr = new byte[MAX_HEADER_LENGTH];
        return doGetImageFormat(bArr, readHeaderFromStream(inputStream, bArr));
    }

    public static ImageFormat getImageFormat(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        ImageFormat imageFormat;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    imageFormat = getImageFormat(fileInputStream);
                    Closeables.closeQuietly(fileInputStream);
                } catch (IOException e) {
                    imageFormat = ImageFormat.UNKNOWN;
                    Closeables.closeQuietly(fileInputStream);
                    return imageFormat;
                }
            } catch (Throwable th2) {
                th = th2;
                Closeables.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (IOException e2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            Closeables.closeQuietly(fileInputStream);
            throw th;
        }
        return imageFormat;
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

    private static ImageFormat getWebpFormat(byte[] bArr, int i) {
        Preconditions.checkArgument(WebpSupportStatus.isWebpHeader(bArr, 0, i));
        return WebpSupportStatus.isSimpleWebpHeader(bArr, 0) ? ImageFormat.WEBP_SIMPLE : WebpSupportStatus.isLosslessWebpHeader(bArr, 0) ? ImageFormat.WEBP_LOSSLESS : WebpSupportStatus.isExtendedWebpHeader(bArr, 0, i) ? WebpSupportStatus.isAnimatedWebpHeader(bArr, 0) ? ImageFormat.WEBP_ANIMATED : WebpSupportStatus.isExtendedWebpHeaderWithAlpha(bArr, 0) ? ImageFormat.WEBP_EXTENDED_WITH_ALPHA : ImageFormat.WEBP_EXTENDED : ImageFormat.UNKNOWN;
    }

    private static boolean isBmpHeader(byte[] bArr, int i) {
        if (i < BMP_HEADER.length) {
            return false;
        }
        return matchBytePattern(bArr, 0, BMP_HEADER);
    }

    private static boolean isGifHeader(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return matchBytePattern(bArr, 0, GIF_HEADER_87A) || matchBytePattern(bArr, 0, GIF_HEADER_89A);
    }

    private static boolean isJpegHeader(byte[] bArr, int i) {
        return i >= JPEG_HEADER.length && matchBytePattern(bArr, 0, JPEG_HEADER);
    }

    private static boolean isPngHeader(byte[] bArr, int i) {
        return i >= PNG_HEADER.length && matchBytePattern(bArr, 0, PNG_HEADER);
    }

    private static boolean matchBytePattern(byte[] bArr, int i, byte[] bArr2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        Preconditions.checkArgument(i >= 0);
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

    private static int readHeaderFromStream(InputStream inputStream, byte[] bArr) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length >= MAX_HEADER_LENGTH);
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(MAX_HEADER_LENGTH);
                return ByteStreams.read(inputStream, bArr, 0, MAX_HEADER_LENGTH);
            } finally {
                inputStream.reset();
            }
        }
        return ByteStreams.read(inputStream, bArr, 0, MAX_HEADER_LENGTH);
    }
}
