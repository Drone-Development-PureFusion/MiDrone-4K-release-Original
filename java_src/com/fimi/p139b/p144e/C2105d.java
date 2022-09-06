package com.fimi.p139b.p144e;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: com.fimi.b.e.d */
/* loaded from: classes.dex */
public class C2105d {

    /* renamed from: a */
    public static final int f7034a = 512;

    /* renamed from: b */
    public ByteBuffer f7035b = ByteBuffer.allocate(512);

    /* renamed from: c */
    public int f7036c;

    /* renamed from: a */
    public ByteBuffer m13701a() {
        return this.f7035b;
    }

    /* renamed from: a */
    public void m13700a(byte b) {
        this.f7035b.put(b);
    }

    /* renamed from: a */
    public void m13699a(char c) {
        m13700a((byte) (c >> 0));
        m13700a((byte) (c >> '\b'));
    }

    /* renamed from: a */
    public void m13698a(double d) {
        m13689b(Double.doubleToLongBits(d));
    }

    /* renamed from: a */
    public void m13697a(float f) {
        m13690b(Float.floatToIntBits(f));
    }

    /* renamed from: a */
    public void m13696a(int i) {
        m13700a((byte) (i >> 0));
        m13700a((byte) (i >> 8));
        m13700a((byte) (i >> 16));
    }

    /* renamed from: a */
    public void m13695a(long j) {
        m13700a((byte) (j >> 0));
        m13700a((byte) (j >> 8));
        m13700a((byte) (j >> 16));
        m13700a((byte) (j >> 24));
    }

    /* renamed from: a */
    public void m13694a(short s) {
        m13700a((byte) (s >> 0));
        m13700a((byte) (s >> 8));
    }

    /* renamed from: a */
    public void m13693a(byte[] bArr) {
        this.f7035b.put(bArr);
    }

    /* renamed from: b */
    public int m13692b() {
        return this.f7035b.position();
    }

    /* renamed from: b */
    public void m13691b(byte b) {
        m13700a(b);
    }

    /* renamed from: b */
    public void m13690b(int i) {
        m13700a((byte) (i >> 0));
        m13700a((byte) (i >> 8));
        m13700a((byte) (i >> 16));
        m13700a((byte) (i >> 24));
    }

    /* renamed from: b */
    public void m13689b(long j) {
        m13700a((byte) (j >> 0));
        m13700a((byte) (j >> 8));
        m13700a((byte) (j >> 16));
        m13700a((byte) (j >> 24));
        m13700a((byte) (j >> 32));
        m13700a((byte) (j >> 40));
        m13700a((byte) (j >> 48));
        m13700a((byte) (j >> 56));
    }

    /* renamed from: c */
    public void m13688c() {
        this.f7036c = 0;
    }

    /* renamed from: c */
    public void m13687c(int i) {
        this.f7036c = i;
    }

    /* renamed from: d */
    public byte m13686d() {
        byte b = (byte) (0 | (this.f7035b.get(this.f7036c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f7036c++;
        return b;
    }

    /* renamed from: e */
    public short m13685e() {
        short s = (short) (((short) (0 | ((this.f7035b.get(this.f7036c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8))) | (this.f7035b.get(this.f7036c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f7036c += 2;
        return s;
    }

    /* renamed from: f */
    public int m13684f() {
        int i = 0 | ((this.f7035b.get(this.f7036c + 3) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((this.f7035b.get(this.f7036c + 2) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.f7035b.get(this.f7036c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f7035b.get(this.f7036c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
        this.f7036c += 4;
        return i;
    }

    /* renamed from: g */
    public long m13683g() {
        long j = 0 | ((this.f7035b.get(this.f7036c + 7) & 255) << 56) | ((this.f7035b.get(this.f7036c + 6) & 255) << 48) | ((this.f7035b.get(this.f7036c + 5) & 255) << 40) | ((this.f7035b.get(this.f7036c + 4) & 255) << 32) | ((this.f7035b.get(this.f7036c + 3) & 255) << 24) | ((this.f7035b.get(this.f7036c + 2) & 255) << 16) | ((this.f7035b.get(this.f7036c + 1) & 255) << 8) | (this.f7035b.get(this.f7036c + 0) & 255);
        this.f7036c += 8;
        return j;
    }

    /* renamed from: h */
    public long m13682h() {
        long j = 0 | ((this.f7035b.get(this.f7036c + 0) & 255) << 56) | ((this.f7035b.get(this.f7036c + 1) & 255) << 48) | ((this.f7035b.get(this.f7036c + 2) & 255) << 40) | ((this.f7035b.get(this.f7036c + 3) & 255) << 32) | ((this.f7035b.get(this.f7036c + 4) & 255) << 24) | ((this.f7035b.get(this.f7036c + 5) & 255) << 16) | ((this.f7035b.get(this.f7036c + 6) & 255) << 8) | (this.f7035b.get(this.f7036c + 7) & 255);
        this.f7036c += 8;
        return j;
    }

    /* renamed from: i */
    public float m13681i() {
        return Float.intBitsToFloat(m13684f());
    }

    /* renamed from: j */
    public float m13680j() {
        BigInteger bigInteger = new BigInteger(1, new byte[]{(byte) ((this.f7035b.get(this.f7036c + 2) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0), (byte) ((this.f7035b.get(this.f7036c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0), (byte) ((this.f7035b.get(this.f7036c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) | 0)});
        this.f7036c += 3;
        return Float.parseFloat(bigInteger.toString());
    }

    /* renamed from: k */
    public Double m13679k() {
        return Double.valueOf(Double.longBitsToDouble(m13683g()));
    }

    /* renamed from: l */
    public char m13678l() {
        char c = (char) (((char) (0 | ((this.f7035b.get(this.f7036c + 1) & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8))) | (this.f7035b.get(this.f7036c + 0) & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
        this.f7036c += 2;
        return c;
    }

    /* renamed from: m */
    public long m13677m() {
        long j = 0 | ((this.f7035b.get(this.f7036c + 3) & 255) << 24) | ((this.f7035b.get(this.f7036c + 2) & 255) << 16) | ((this.f7035b.get(this.f7036c + 1) & 255) << 8) | (this.f7035b.get(this.f7036c + 0) & 255);
        this.f7036c += 4;
        return j;
    }
}
