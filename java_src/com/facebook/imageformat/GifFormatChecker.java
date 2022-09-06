package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public final class GifFormatChecker {
    private static final int FRAME_HEADER_SIZE = 10;
    private static final byte[] FRAME_HEADER_START = {0, SmileConstants.TOKEN_LITERAL_NULL, -7, 4};
    private static final byte[] FRAME_HEADER_END_1 = {0, 44};
    private static final byte[] FRAME_HEADER_END_2 = {0, SmileConstants.TOKEN_LITERAL_NULL};

    private GifFormatChecker() {
    }

    @VisibleForTesting
    static boolean circularBufferMatchesBytePattern(byte[] bArr, int i, byte[] bArr2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkNotNull(bArr2);
        Preconditions.checkArgument(i >= 0);
        if (bArr2.length > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[(i2 + i) % bArr.length] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnimated(InputStream inputStream) {
        byte[] bArr = new byte[10];
        try {
            inputStream.read(bArr, 0, 10);
            int i = 0;
            for (int i2 = 0; inputStream.read(bArr, i2, 1) > 0; i2 = (i2 + 1) % bArr.length) {
                if (circularBufferMatchesBytePattern(bArr, i2 + 1, FRAME_HEADER_START) && ((circularBufferMatchesBytePattern(bArr, i2 + 9, FRAME_HEADER_END_1) || circularBufferMatchesBytePattern(bArr, i2 + 9, FRAME_HEADER_END_2)) && (i = i + 1) > 1)) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
