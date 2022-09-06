package com.facebook.imageutils;

import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class JfifUtil {
    public static final int APP1_EXIF_MAGIC = 1165519206;
    public static final int MARKER_APP1 = 225;
    public static final int MARKER_EOI = 217;
    public static final int MARKER_ESCAPE_BYTE = 0;
    public static final int MARKER_FIRST_BYTE = 255;
    public static final int MARKER_RST0 = 208;
    public static final int MARKER_RST7 = 215;
    public static final int MARKER_SOFn = 192;
    public static final int MARKER_SOI = 216;
    public static final int MARKER_SOS = 218;
    public static final int MARKER_TEM = 1;

    private JfifUtil() {
    }

    public static int getAutoRotateAngleFromOrientation(int i) {
        return TiffUtil.getAutoRotateAngleFromOrientation(i);
    }

    public static int getOrientation(InputStream inputStream) {
        try {
            int moveToAPP1EXIF = moveToAPP1EXIF(inputStream);
            if (moveToAPP1EXIF != 0) {
                return TiffUtil.readOrientationFromTIFF(inputStream, moveToAPP1EXIF);
            }
            return 0;
        } catch (IOException e) {
            return 0;
        }
    }

    public static int getOrientation(byte[] bArr) {
        return getOrientation(new ByteArrayInputStream(bArr));
    }

    private static boolean isSOFn(int i) {
        switch (i) {
            case 192:
            case 193:
            case 194:
            case Opcodes.MONITOREXIT /* 195 */:
            case 197:
            case 198:
            case 199:
            case 201:
            case 202:
            case 203:
            case 205:
            case 206:
            case 207:
                return true;
            case SmileConstants.MIN_BUFFER_FOR_POSSIBLE_SHORT_STRING /* 196 */:
            case 200:
            case 204:
            default:
                return false;
        }
    }

    private static int moveToAPP1EXIF(InputStream inputStream) {
        int readPackedInt;
        if (moveToMarker(inputStream, 225) && StreamProcessor.readPackedInt(inputStream, 2, false) - 2 > 6) {
            int readPackedInt2 = StreamProcessor.readPackedInt(inputStream, 4, false);
            int readPackedInt3 = StreamProcessor.readPackedInt(inputStream, 2, false);
            int i = (readPackedInt - 4) - 2;
            if (readPackedInt2 == 1165519206 && readPackedInt3 == 0) {
                return i;
            }
        }
        return 0;
    }

    public static boolean moveToMarker(InputStream inputStream, int i) {
        Preconditions.checkNotNull(inputStream);
        while (StreamProcessor.readPackedInt(inputStream, 1, false) == 255) {
            int i2 = 255;
            while (i2 == 255) {
                i2 = StreamProcessor.readPackedInt(inputStream, 1, false);
            }
            if ((i == 192 && isSOFn(i2)) || i2 == i) {
                return true;
            }
            if (i2 != 216 && i2 != 1) {
                if (i2 == 217 || i2 == 218) {
                    return false;
                }
                inputStream.skip(StreamProcessor.readPackedInt(inputStream, 2, false) - 2);
            }
        }
        return false;
    }
}
