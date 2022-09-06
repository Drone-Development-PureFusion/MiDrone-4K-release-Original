package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.fimi.soul.drone.p193d.p194a.p195a.C2760r;
import com.fimi.soul.module.droneui.DroneMap;
import com.fimi.soul.module.setting.newhand.C3531c;
import java.io.IOException;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes.dex */
public class EmptyJpegGenerator {
    private static final byte[] EMPTY_JPEG_PREFIX = {-1, -40, -1, -37, 0, DroneMap.f12612o, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8};
    private static final byte[] EMPTY_JPEG_SUFFIX = {3, 1, SmileConstants.TOKEN_LITERAL_FALSE, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, SmileConstants.TOKEN_LITERAL_NULL, 49, 65, 6, 19, 81, 97, 7, SmileConstants.TOKEN_LITERAL_FALSE, 113, 20, 50, -127, -111, -95, 8, SmileConstants.TOKEN_LITERAL_TRUE, 66, -79, -63, 21, DroneMap.f12611n, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, SmileConstants.HEADER_BYTE_2, 42, SmileConstants.TOKEN_KEY_LONG_STRING, 53, 54, 55, 56, 57, SmileConstants.HEADER_BYTE_1, DroneMap.f12612o, 68, 69, 70, 71, 72, 73, 74, 83, 84, C3531c.f14197f, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, C2760r.f10172a, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, C3531c.f14198g, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, SmileConstants.TOKEN_LITERAL_NULL, 49, 6, 18, 65, 81, 7, 97, 113, 19, SmileConstants.TOKEN_LITERAL_FALSE, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, SmileConstants.TOKEN_LITERAL_TRUE, 51, DroneMap.f12611n, -16, 21, 98, 114, -47, 10, 22, 36, SmileConstants.TOKEN_KEY_LONG_STRING, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, SmileConstants.HEADER_BYTE_2, 42, 53, 54, 55, 56, 57, SmileConstants.HEADER_BYTE_1, DroneMap.f12612o, 68, 69, 70, 71, 72, 73, 74, 83, 84, C3531c.f14197f, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, C2760r.f10172a, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, C3531c.f14198g, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, 15, -1, -39};
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public EmptyJpegGenerator(PooledByteBufferFactory pooledByteBufferFactory) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public CloseableReference<PooledByteBuffer> generate(short s, short s2) {
        PooledByteBufferOutputStream pooledByteBufferOutputStream = null;
        try {
            try {
                pooledByteBufferOutputStream = this.mPooledByteBufferFactory.mo21796newOutputStream(EMPTY_JPEG_PREFIX.length + EMPTY_JPEG_SUFFIX.length + 4);
                pooledByteBufferOutputStream.write(EMPTY_JPEG_PREFIX);
                pooledByteBufferOutputStream.write((byte) (s2 >> 8));
                pooledByteBufferOutputStream.write((byte) (s2 & 255));
                pooledByteBufferOutputStream.write((byte) (s >> 8));
                pooledByteBufferOutputStream.write((byte) (s & 255));
                pooledByteBufferOutputStream.write(EMPTY_JPEG_SUFFIX);
                return CloseableReference.m13749of(pooledByteBufferOutputStream.mo21797toByteBuffer());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            if (pooledByteBufferOutputStream != null) {
                pooledByteBufferOutputStream.close();
            }
        }
    }
}
