package com.fimi.soul.drone.p193d.p194a;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.soul.drone.d.a.d */
/* loaded from: classes.dex */
public class C2771d {

    /* renamed from: a */
    public static final int f10266a = 512;

    /* renamed from: b */
    public ByteBuffer f10267b = ByteBuffer.allocate(512);

    /* renamed from: c */
    public int f10268c;

    /* renamed from: a */
    public ByteBuffer m11064a() {
        return this.f10267b;
    }

    /* renamed from: a */
    public void m11063a(byte b) {
        this.f10267b.put(b);
    }

    /* renamed from: a */
    public void m11062a(char c) {
        m11063a((byte) (c >> 0));
        m11063a((byte) (c >> '\b'));
    }

    /* renamed from: a */
    public void m11061a(double d) {
        m11053b(Double.doubleToLongBits(d));
    }

    /* renamed from: a */
    public void m11060a(float f) {
        m11054b(Float.floatToIntBits(f));
    }

    /* renamed from: a */
    public void m11059a(int i) {
        m11063a((byte) (i >> 0));
        m11063a((byte) (i >> 8));
        m11063a((byte) (i >> 16));
    }

    /* renamed from: a */
    public void m11058a(long j) {
        m11063a((byte) (j >> 0));
        m11063a((byte) (j >> 8));
        m11063a((byte) (j >> 16));
        m11063a((byte) (j >> 24));
    }

    /* renamed from: a */
    public void m11057a(short s) {
        m11063a((byte) (s >> 0));
        m11063a((byte) (s >> 8));
    }

    /* renamed from: b */
    public int m11056b() {
        return this.f10267b.position() + 1;
    }

    /* renamed from: b */
    public void m11055b(byte b) {
        m11063a(b);
    }

    /* renamed from: b */
    public void m11054b(int i) {
        m11063a((byte) (i >> 0));
        m11063a((byte) (i >> 8));
        m11063a((byte) (i >> 16));
        m11063a((byte) (i >> 24));
    }

    /* renamed from: b */
    public void m11053b(long j) {
        m11063a((byte) (j >> 0));
        m11063a((byte) (j >> 8));
        m11063a((byte) (j >> 16));
        m11063a((byte) (j >> 24));
        m11063a((byte) (j >> 32));
        m11063a((byte) (j >> 40));
        m11063a((byte) (j >> 48));
        m11063a((byte) (j >> 56));
    }

    /* renamed from: c */
    public void m11052c() {
        this.f10268c = 0;
    }

    /* renamed from: c */
    public void m11051c(int i) {
        this.f10268c = i;
    }

    /* renamed from: d */
    public byte m11050d() {
        byte b = (byte) (0 | (this.f10267b.get(this.f10268c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f10268c++;
        return b;
    }

    /* renamed from: e */
    public short m11049e() {
        short s = (short) (((short) (0 | ((this.f10267b.get(this.f10268c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8))) | (this.f10267b.get(this.f10268c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f10268c += 2;
        return s;
    }

    /* renamed from: f */
    public int m11048f() {
        int i = 0 | ((this.f10267b.get(this.f10268c + 3) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((this.f10267b.get(this.f10268c + 2) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.f10267b.get(this.f10268c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f10267b.get(this.f10268c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f10268c += 4;
        return i;
    }

    /* renamed from: g */
    public long m11047g() {
        long j = 0 | ((this.f10267b.get(this.f10268c + 7) & 255) << 56) | ((this.f10267b.get(this.f10268c + 6) & 255) << 48) | ((this.f10267b.get(this.f10268c + 5) & 255) << 40) | ((this.f10267b.get(this.f10268c + 4) & 255) << 32) | ((this.f10267b.get(this.f10268c + 3) & 255) << 24) | ((this.f10267b.get(this.f10268c + 2) & 255) << 16) | ((this.f10267b.get(this.f10268c + 1) & 255) << 8) | (this.f10267b.get(this.f10268c + 0) & 255);
        this.f10268c += 8;
        return j;
    }

    /* renamed from: h */
    public long m11046h() {
        long j = 0 | ((this.f10267b.get(this.f10268c + 0) & 255) << 56) | ((this.f10267b.get(this.f10268c + 1) & 255) << 48) | ((this.f10267b.get(this.f10268c + 2) & 255) << 40) | ((this.f10267b.get(this.f10268c + 3) & 255) << 32) | ((this.f10267b.get(this.f10268c + 4) & 255) << 24) | ((this.f10267b.get(this.f10268c + 5) & 255) << 16) | ((this.f10267b.get(this.f10268c + 6) & 255) << 8) | (this.f10267b.get(this.f10268c + 7) & 255);
        this.f10268c += 8;
        return j;
    }

    /* renamed from: i */
    public float m11045i() {
        return Float.intBitsToFloat(m11048f());
    }

    /* renamed from: j */
    public float m11044j() {
        BigInteger bigInteger = new BigInteger(1, new byte[]{(byte) ((this.f10267b.get(this.f10268c + 2) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0), (byte) ((this.f10267b.get(this.f10268c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0), (byte) ((this.f10267b.get(this.f10268c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0)});
        this.f10268c += 3;
        return Float.parseFloat(bigInteger.toString());
    }

    /* renamed from: k */
    public Double m11043k() {
        return Double.valueOf(Double.longBitsToDouble(m11047g()));
    }

    /* renamed from: l */
    public char m11042l() {
        char c = (char) (((char) (0 | ((this.f10267b.get(this.f10268c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8))) | (this.f10267b.get(this.f10268c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f10268c += 2;
        return c;
    }

    /* renamed from: m */
    public long m11041m() {
        long j = 0 | ((this.f10267b.get(this.f10268c + 3) & 255) << 24) | ((this.f10267b.get(this.f10268c + 2) & 255) << 16) | ((this.f10267b.get(this.f10268c + 1) & 255) << 8) | (this.f10267b.get(this.f10268c + 0) & 255);
        this.f10268c += 4;
        return j;
    }
}
