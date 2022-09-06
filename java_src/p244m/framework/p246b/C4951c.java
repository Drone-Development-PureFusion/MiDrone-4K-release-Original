package p244m.framework.p246b;
/* renamed from: m.framework.b.c */
/* loaded from: classes2.dex */
public class C4951c {

    /* renamed from: a */
    private static final char[] f21292a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    protected static int m2522a(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit == -1) {
            throw new RuntimeException("Illegal hexadecimal charcter " + c + " at index " + i);
        }
        return digit;
    }

    /* renamed from: a */
    public static String m2519a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static byte[] m2520a(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 != 1) {
                int i = length / 2;
                bArr = new byte[i];
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = (byte) Integer.parseInt(str.substring(i2 * 2, (i2 * 2) + 2), 16);
                }
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m2518a(char[] cArr) {
        int i = 0;
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new RuntimeException("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            i = i3 + 1;
            bArr[i2] = (byte) (((m2522a(cArr[i], i) << 4) | m2522a(cArr[i3], i3)) & 255);
            i2++;
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m2515b(byte[] bArr) {
        return new String(m2514c(bArr));
    }

    /* renamed from: b */
    public static byte[] m2516b(String str) {
        return m2518a(str.toCharArray());
    }

    /* renamed from: c */
    public static char[] m2514c(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = f21292a[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = f21292a[bArr[i2] & 15];
        }
        return cArr;
    }

    /* renamed from: a */
    public byte[] m2521a(Object obj) {
        try {
            return m2518a(obj instanceof String ? ((String) obj).toCharArray() : (char[]) obj);
        } catch (ClassCastException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* renamed from: b */
    public char[] m2517b(Object obj) {
        try {
            return m2514c(obj instanceof String ? ((String) obj).getBytes() : (byte[]) obj);
        } catch (ClassCastException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* renamed from: d */
    public byte[] m2513d(byte[] bArr) {
        return m2518a(new String(bArr).toCharArray());
    }

    /* renamed from: e */
    public byte[] m2512e(byte[] bArr) {
        return new String(m2514c(bArr)).getBytes();
    }
}
