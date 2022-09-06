package com.tencent.open.utils;

import android.support.p001v4.view.MotionEventCompat;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes2.dex */
public final class ZipLong implements Cloneable {

    /* renamed from: a */
    private long f18232a;

    public ZipLong(long j) {
        this.f18232a = j;
    }

    public ZipLong(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipLong(byte[] bArr, int i) {
        this.f18232a = (bArr[i + 3] << 24) & 4278190080L;
        this.f18232a += (bArr[i + 2] << 16) & 16711680;
        this.f18232a += (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f18232a += bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipLong) && this.f18232a == ((ZipLong) obj).getValue();
    }

    public byte[] getBytes() {
        return new byte[]{(byte) (this.f18232a & 255), (byte) ((this.f18232a & 65280) >> 8), (byte) ((this.f18232a & 16711680) >> 16), (byte) ((this.f18232a & 4278190080L) >> 24)};
    }

    public long getValue() {
        return this.f18232a;
    }

    public int hashCode() {
        return (int) this.f18232a;
    }
}
