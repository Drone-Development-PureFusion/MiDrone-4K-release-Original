package p004b.p005a.p006a.p058c.p059a.p065c;

import java.io.DataInput;
/* renamed from: b.a.a.c.a.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC0600a implements DataInput {

    /* renamed from: a */
    protected final DataInput f1369a;

    public AbstractC0600a(DataInput dataInput) {
        this.f1369a = dataInput;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() {
        return this.f1369a.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() {
        return this.f1369a.readByte();
    }

    @Override // java.io.DataInput
    public char readChar() {
        return this.f1369a.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() {
        return this.f1369a.readDouble();
    }

    @Override // java.io.DataInput
    public float readFloat() {
        return this.f1369a.readFloat();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) {
        this.f1369a.readFully(bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) {
        this.f1369a.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() {
        return this.f1369a.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() {
        return this.f1369a.readLine();
    }

    @Override // java.io.DataInput
    public long readLong() {
        return this.f1369a.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() {
        return this.f1369a.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() {
        return this.f1369a.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() {
        return this.f1369a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() {
        return this.f1369a.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) {
        return this.f1369a.skipBytes(i);
    }
}
