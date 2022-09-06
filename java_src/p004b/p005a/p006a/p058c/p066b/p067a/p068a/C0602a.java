package p004b.p005a.p006a.p058c.p066b.p067a.p068a;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;
import org.codehaus.jackson.smile.SmileConstants;
/* renamed from: b.a.a.c.b.a.a.a */
/* loaded from: classes.dex */
public final class C0602a implements DataInput {

    /* renamed from: d */
    private static final String f1370d = "copyright (c) 1999-2010 Roedy Green, Canadian Mind Products, http://mindprod.com";

    /* renamed from: a */
    protected final DataInputStream f1371a;

    /* renamed from: b */
    protected final InputStream f1372b;

    /* renamed from: c */
    protected final byte[] f1373c = new byte[8];

    public C0602a(InputStream inputStream) {
        this.f1372b = inputStream;
        this.f1371a = new DataInputStream(inputStream);
    }

    /* renamed from: a */
    public static String m19981a(DataInput dataInput) {
        return DataInputStream.readUTF(dataInput);
    }

    /* renamed from: a */
    public final int m19980a(byte[] bArr, int i, int i2) {
        return this.f1372b.read(bArr, i, i2);
    }

    /* renamed from: a */
    public final void m19982a() {
        this.f1371a.close();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        return this.f1371a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        return this.f1371a.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f1371a.readFully(this.f1373c, 0, 2);
        return (char) (((this.f1373c[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f1373c[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        this.f1371a.readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        this.f1371a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        this.f1371a.readFully(this.f1373c, 0, 4);
        return (this.f1373c[3] << 24) | ((this.f1373c[2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.f1373c[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f1373c[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        return this.f1371a.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() {
        this.f1371a.readFully(this.f1373c, 0, 8);
        return (this.f1373c[7] << 56) | ((this.f1373c[6] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 48) | ((this.f1373c[5] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 40) | ((this.f1373c[4] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 32) | ((this.f1373c[3] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 24) | ((this.f1373c[2] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 16) | ((this.f1373c[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f1373c[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    @Override // java.io.DataInput
    public final short readShort() {
        this.f1371a.readFully(this.f1373c, 0, 2);
        return (short) (((this.f1373c[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f1373c[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT));
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        return this.f1371a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        return this.f1371a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        this.f1371a.readFully(this.f1373c, 0, 2);
        return ((this.f1373c[1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (this.f1373c[0] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        return this.f1371a.skipBytes(i);
    }
}
