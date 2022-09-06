package com.fimi.soul.module.droneTrack;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.regex.Pattern;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.soul.module.droneTrack.g */
/* loaded from: classes.dex */
public class C3218g {

    /* renamed from: c */
    public static final int f12343c = 256;

    /* renamed from: a */
    public ByteBuffer f12344a;

    /* renamed from: b */
    public int f12345b;

    /* renamed from: d */
    StringBuilder f12346d = new StringBuilder();

    public C3218g() {
    }

    public C3218g(char[] cArr) {
        try {
            this.f12344a = ByteBuffer.allocate(256);
            if (cArr == null) {
                return;
            }
            for (int i = 0; i < cArr.length - 1; i += 2) {
                this.f12344a.put((byte) Integer.parseInt(cArr[i] + "" + cArr[i + 1], 16));
            }
            this.f12345b = 0;
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public byte m9081a() {
        byte b = (byte) (0 | (this.f12344a.get(this.f12345b + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f12345b++;
        return b;
    }

    /* renamed from: a */
    public boolean m9080a(String str) {
        return Pattern.compile("[0-9a-zA-Z]*").matcher(str).matches();
    }

    /* renamed from: a */
    public boolean m9079a(char[] cArr) {
        try {
            this.f12344a = ByteBuffer.allocate(256);
            if (cArr == null) {
                return false;
            }
            for (int i = 0; i < cArr.length - 1; i += 2) {
                this.f12346d.append(cArr[i]).append("").append(cArr[i + 1]);
                this.f12344a.put((byte) Integer.parseInt(this.f12346d.toString(), 16));
                this.f12346d.delete(0, this.f12346d.length());
            }
            this.f12345b = 0;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    public short m9078b() {
        short s = (short) (((short) (0 | ((this.f12344a.get(this.f12345b + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8))) | (this.f12344a.get(this.f12345b + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f12345b += 2;
        return s;
    }

    /* renamed from: c */
    public int m9077c() {
        int i = 0 | ((this.f12344a.get(this.f12345b + 3) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((this.f12344a.get(this.f12345b + 2) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.f12344a.get(this.f12345b + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f12344a.get(this.f12345b + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f12345b += 4;
        return i;
    }

    /* renamed from: d */
    public long m9076d() {
        long j = 0 | ((this.f12344a.get(this.f12345b + 7) & 255) << 56) | ((this.f12344a.get(this.f12345b + 6) & 255) << 48) | ((this.f12344a.get(this.f12345b + 5) & 255) << 40) | ((this.f12344a.get(this.f12345b + 4) & 255) << 32) | ((this.f12344a.get(this.f12345b + 3) & 255) << 24) | ((this.f12344a.get(this.f12345b + 2) & 255) << 16) | ((this.f12344a.get(this.f12345b + 1) & 255) << 8) | (this.f12344a.get(this.f12345b + 0) & 255);
        this.f12345b += 8;
        return j;
    }

    /* renamed from: e */
    public long m9075e() {
        long j = 0 | ((this.f12344a.get(this.f12345b + 0) & 255) << 56) | ((this.f12344a.get(this.f12345b + 1) & 255) << 48) | ((this.f12344a.get(this.f12345b + 2) & 255) << 40) | ((this.f12344a.get(this.f12345b + 3) & 255) << 32) | ((this.f12344a.get(this.f12345b + 4) & 255) << 24) | ((this.f12344a.get(this.f12345b + 5) & 255) << 16) | ((this.f12344a.get(this.f12345b + 6) & 255) << 8) | (this.f12344a.get(this.f12345b + 7) & 255);
        this.f12345b += 8;
        return j;
    }

    /* renamed from: f */
    public float m9074f() {
        return Float.intBitsToFloat(m9077c());
    }

    /* renamed from: g */
    public float m9073g() {
        BigInteger bigInteger = new BigInteger(1, new byte[]{(byte) ((this.f12344a.get(this.f12345b + 2) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0), (byte) ((this.f12344a.get(this.f12345b + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0), (byte) ((this.f12344a.get(this.f12345b + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0)});
        this.f12345b += 3;
        return Float.parseFloat(bigInteger.toString());
    }

    /* renamed from: h */
    public void m9072h() {
        if (this.f12344a != null) {
            this.f12344a = null;
        }
    }

    /* renamed from: i */
    public Double m9071i() {
        return Double.valueOf(Double.longBitsToDouble(m9076d()));
    }
}
