package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.webp.WebpSupportStatus;
import java.io.InputStream;
import java.io.OutputStream;
@DoNotStrip
/* loaded from: classes.dex */
public class WebpTranscoder {
    static {
        ImagePipelineNativeLoader.load();
    }

    public static boolean isWebpNativelySupported(ImageFormat imageFormat) {
        switch (imageFormat) {
            case WEBP_SIMPLE:
                return Build.VERSION.SDK_INT >= 14;
            case WEBP_LOSSLESS:
            case WEBP_EXTENDED:
            case WEBP_EXTENDED_WITH_ALPHA:
                return WebpSupportStatus.sIsExtendedWebpSupported;
            case WEBP_ANIMATED:
                return false;
            default:
                Preconditions.checkArgument(false);
                return false;
        }
    }

    @DoNotStrip
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i);

    @DoNotStrip
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream);

    public static void transcodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i) {
        nativeTranscodeWebpToJpeg((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream), i);
    }

    public static void transcodeWebpToPng(InputStream inputStream, OutputStream outputStream) {
        nativeTranscodeWebpToPng((InputStream) Preconditions.checkNotNull(inputStream), (OutputStream) Preconditions.checkNotNull(outputStream));
    }
}
