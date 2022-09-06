package p004b.p005a.p006a.p058c.p059a.p060a.p061a.p062a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.smile.SmileConstants;
import org.p248a.p249a.p261f.p264c.C5122l;
import p004b.p005a.p006a.p058c.p059a.p060a.p061a.p063b.C0598a;
import p004b.p005a.p006a.p058c.p059a.p065c.C0601b;
/* renamed from: b.a.a.c.a.a.a.a.c */
/* loaded from: classes.dex */
public class C0597c {

    /* renamed from: f */
    private static final CharsetDecoder f1359f = Charset.forName("UTF-16LE").newDecoder();

    /* renamed from: g */
    private static final CharsetDecoder f1360g = Charset.forName("UTF-8").newDecoder();

    /* renamed from: h */
    private static final Logger f1361h = Logger.getLogger(C0597c.class.getName());

    /* renamed from: i */
    private static final int f1362i = 1835009;

    /* renamed from: j */
    private static final int f1363j = 256;

    /* renamed from: a */
    private int[] f1364a;

    /* renamed from: b */
    private byte[] f1365b;

    /* renamed from: c */
    private int[] f1366c;

    /* renamed from: d */
    private int[] f1367d;

    /* renamed from: e */
    private boolean f1368e;

    private C0597c() {
    }

    /* renamed from: a */
    private static final int m20001a(byte[] bArr, int i) {
        return ((bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT) << 8) | (bArr[i] & SmileConstants.BYTE_MARKER_END_OF_CONTENT);
    }

    /* renamed from: a */
    private static final int m20000a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }

    /* renamed from: a */
    public static C0597c m20004a(C0601b c0601b) {
        c0601b.m19983b(f1362i);
        int readInt = c0601b.readInt();
        int readInt2 = c0601b.readInt();
        int readInt3 = c0601b.readInt();
        int readInt4 = c0601b.readInt();
        int readInt5 = c0601b.readInt();
        int readInt6 = c0601b.readInt();
        C0597c c0597c = new C0597c();
        c0597c.f1368e = (readInt4 & 256) != 0;
        c0597c.f1364a = c0601b.m19986a(readInt2);
        if (readInt3 != 0) {
            c0597c.f1366c = c0601b.m19986a(readInt3);
        }
        int i = (readInt6 == 0 ? readInt : readInt6) - readInt5;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        c0597c.f1365b = new byte[i];
        c0601b.readFully(c0597c.f1365b);
        if (readInt6 != 0) {
            int i2 = readInt - readInt6;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            c0597c.f1367d = c0601b.m19986a(i2 / 4);
        }
        return c0597c;
    }

    /* renamed from: a */
    private String m20005a(int i, int i2) {
        String str = null;
        try {
            str = (this.f1368e ? f1360g : f1359f).decode(ByteBuffer.wrap(this.f1365b, i, i2)).toString();
            return str;
        } catch (CharacterCodingException e) {
            f1361h.log(Level.WARNING, str, (Throwable) e);
            return str;
        }
    }

    /* renamed from: a */
    private void m20002a(String str, StringBuilder sb, boolean z) {
        String substring;
        sb.append('<');
        if (z) {
            sb.append('/');
        }
        int indexOf = str.indexOf(59);
        if (indexOf == -1) {
            sb.append(str);
        } else {
            sb.append(str.substring(0, indexOf));
            if (!z) {
                boolean z2 = true;
                while (z2) {
                    int indexOf2 = str.indexOf(61, indexOf + 1);
                    sb.append(C5122l.f21763c).append(str.substring(indexOf + 1, indexOf2)).append("=\"");
                    int indexOf3 = str.indexOf(59, indexOf2 + 1);
                    if (indexOf3 != -1) {
                        substring = str.substring(indexOf2 + 1, indexOf3);
                    } else {
                        substring = str.substring(indexOf2 + 1);
                        z2 = false;
                    }
                    sb.append(C0598a.m19994a(substring)).append('\"');
                    indexOf = indexOf3;
                }
            }
        }
        sb.append('>');
    }

    /* renamed from: b */
    private static final int[] m19998b(byte[] bArr, int i) {
        byte b = bArr[i];
        boolean z = (b & 128) != 0;
        int i2 = b & Byte.MAX_VALUE;
        return !z ? new int[]{i2, 1} : new int[]{(i2 << 8) | (bArr[i + 1] & SmileConstants.BYTE_MARKER_END_OF_CONTENT), 2};
    }

    /* renamed from: d */
    private int[] m19996d(int i) {
        int i2 = 0;
        if (this.f1366c == null || this.f1367d == null || i >= this.f1366c.length) {
            return null;
        }
        int i3 = this.f1366c[i] / 4;
        int i4 = 0;
        for (int i5 = i3; i5 < this.f1367d.length && this.f1367d[i5] != -1; i5++) {
            i4++;
        }
        if (i4 == 0 || i4 % 3 != 0) {
            return null;
        }
        int[] iArr = new int[i4];
        while (i3 < this.f1367d.length && this.f1367d[i3] != -1) {
            iArr[i2] = this.f1367d[i3];
            i2++;
            i3++;
        }
        return iArr;
    }

    /* renamed from: a */
    public int m20007a() {
        if (this.f1364a != null) {
            return this.f1364a.length;
        }
        return 0;
    }

    /* renamed from: a */
    public int m20003a(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i != this.f1364a.length; i++) {
            int i2 = this.f1364a[i];
            int m20001a = m20001a(this.f1365b, i2);
            if (m20001a == str.length()) {
                int i3 = i2;
                int i4 = 0;
                while (i4 != m20001a) {
                    i3 += 2;
                    if (str.charAt(i4) != m20001a(this.f1365b, i3)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == m20001a) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public String m20006a(int i) {
        int i2;
        int i3;
        if (i < 0 || this.f1364a == null || i >= this.f1364a.length) {
            return null;
        }
        int i4 = this.f1364a[i];
        if (!this.f1368e) {
            i3 = m20001a(this.f1365b, i4) * 2;
            i2 = i4 + 2;
        } else {
            int i5 = m19998b(this.f1365b, i4)[1] + i4;
            int[] m19998b = m19998b(this.f1365b, i5);
            i2 = m19998b[1] + i5;
            i3 = m19998b[0];
        }
        return m20005a(i2, i3);
    }

    /* renamed from: b */
    public CharSequence m19999b(int i) {
        return m20006a(i);
    }

    /* renamed from: c */
    public String m19997c(int i) {
        String m20006a = m20006a(i);
        if (m20006a == null) {
            return m20006a;
        }
        int[] m19996d = m19996d(i);
        if (m19996d == null) {
            return C0598a.m19994a(m20006a);
        }
        StringBuilder sb = new StringBuilder(m20006a.length() + 32);
        int[] iArr = new int[m19996d.length / 3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = -1;
            for (int i5 = 0; i5 != m19996d.length; i5 += 3) {
                if (m19996d[i5 + 1] != -1 && (i4 == -1 || m19996d[i4 + 1] > m19996d[i5 + 1])) {
                    i4 = i5;
                }
            }
            int length = i4 != -1 ? m19996d[i4 + 1] : m20006a.length();
            int i6 = i2 - 1;
            int i7 = i3;
            int i8 = i6;
            while (i8 >= 0) {
                int i9 = iArr[i8];
                int i10 = m19996d[i9 + 2];
                if (i10 >= length) {
                    break;
                }
                if (i7 <= i10) {
                    sb.append(C0598a.m19994a(m20006a.substring(i7, i10 + 1)));
                    i7 = i10 + 1;
                }
                m20002a(m20006a(m19996d[i9]), sb, true);
                i8--;
            }
            int i11 = i8 + 1;
            if (i7 < length) {
                sb.append(C0598a.m19994a(m20006a.substring(i7, length)));
                i3 = length;
            } else {
                i3 = i7;
            }
            if (i4 == -1) {
                return sb.toString();
            }
            m20002a(m20006a(m19996d[i4]), sb, false);
            m19996d[i4 + 1] = -1;
            i2 = i11 + 1;
            iArr[i11] = i4;
        }
    }
}
