package com.facebook.imageformat;
/* loaded from: classes.dex */
public class ImageFileExtensionMap {
    private ImageFileExtensionMap() {
    }

    public static String getFileExtension(ImageFormat imageFormat) {
        switch (imageFormat) {
            case WEBP_SIMPLE:
            case WEBP_LOSSLESS:
            case WEBP_EXTENDED:
            case WEBP_EXTENDED_WITH_ALPHA:
            case WEBP_ANIMATED:
                return "webp";
            case JPEG:
                return "jpeg";
            case PNG:
                return "png";
            case GIF:
                return "gif";
            case BMP:
                return "bmp";
            default:
                throw new UnsupportedOperationException("Unknown image format " + imageFormat.name());
        }
    }
}
