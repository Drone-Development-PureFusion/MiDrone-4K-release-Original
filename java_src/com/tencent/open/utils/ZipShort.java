package com.tencent.open.utils;

import android.support.p001v4.view.MotionEventCompat;
import org.codehaus.jackson.smile.SmileConstants;
/* loaded from: classes2.dex */
public final class ZipShort implements Cloneable {

    /* renamed from: a */
    private int f18233a;

    public ZipShort(int i) {
        this.f18233a = i;
    }

    public ZipShort(byte[] bArr) {
        this(bArr, 0);
    }

    public ZipShort(byte[] bArr, int i) {
        this.f18233a = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f18233a += bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ZipShort) && this.f18233a == ((ZipShort) obj).getValue();
    }

    public byte[] getBytes() {
        return new byte[]{(byte) (this.f18233a & 255), (byte) ((this.f18233a & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int getValue() {
        return this.f18233a;
    }

    public int hashCode() {
        return this.f18233a;
    }
}
