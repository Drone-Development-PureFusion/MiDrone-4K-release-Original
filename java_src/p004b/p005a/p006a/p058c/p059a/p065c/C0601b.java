package p004b.p005a.p006a.p058c.p059a.p065c;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
/* renamed from: b.a.a.c.a.c.b */
/* loaded from: classes.dex */
public class C0601b extends AbstractC0600a {
    public C0601b(DataInput dataInput) {
        super(dataInput);
    }

    public C0601b(InputStream inputStream) {
        this((DataInput) new DataInputStream(inputStream));
    }

    /* renamed from: a */
    public String m19985a(int i, boolean z) {
        int i2;
        short readShort;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || (readShort = readShort()) == 0) {
                break;
            }
            sb.append((char) readShort);
            i = i2;
        }
        if (z) {
            skipBytes(i2 * 2);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m19988a() {
        skipBytes(4);
    }

    /* renamed from: a */
    public void m19987a(byte b) {
        byte readByte = readByte();
        if (readByte != b) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Byte.valueOf(b), Byte.valueOf(readByte)));
        }
    }

    /* renamed from: a */
    public void m19984a(short s) {
        short readShort = readShort();
        if (readShort != s) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Short.valueOf(s), Short.valueOf(readShort)));
        }
    }

    /* renamed from: a */
    public int[] m19986a(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    /* renamed from: b */
    public void m19983b(int i) {
        int readInt = readInt();
        if (readInt != i) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", Integer.valueOf(i), Integer.valueOf(readInt)));
        }
    }
}
