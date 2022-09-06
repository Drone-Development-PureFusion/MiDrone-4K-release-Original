package p004b.p005a.p006a.p028b.p044i.p047c;

import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import org.p248a.p249a.p261f.p264c.C5122l;
/* renamed from: b.a.a.b.i.c.d */
/* loaded from: classes.dex */
public class C0447d implements AbstractC0446c {
    /* renamed from: b */
    public static String m20495b(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                i = i2 + 1;
                charAt = str.charAt(i2);
                if (charAt == 'n') {
                    charAt = '\n';
                } else if (charAt == 'r') {
                    charAt = C5122l.f21761a;
                } else if (charAt == 't') {
                    charAt = '\t';
                } else if (charAt == 'f') {
                    charAt = '\f';
                }
            } else {
                i = i2;
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    String m20496a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(", \\").append(str.charAt(i));
        }
        return sb.toString();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p047c.AbstractC0446c
    /* renamed from: a */
    public void mo20494a(String str, StringBuffer stringBuffer, char c, int i) {
        if (str.indexOf(c) >= 0) {
            stringBuffer.append(c);
            return;
        }
        switch (c) {
            case Opcodes.DUP2 /* 92 */:
                stringBuffer.append(c);
                return;
            case Opcodes.SWAP /* 95 */:
                return;
            case 'n':
                stringBuffer.append('\n');
                return;
            case 'r':
                stringBuffer.append(C5122l.f21761a);
                return;
            case Opcodes.INEG /* 116 */:
                stringBuffer.append('\t');
                return;
            default:
                throw new IllegalArgumentException("Illegal char '" + c + " at column " + i + ". Only \\\\, \\_" + m20496a(str) + ", \\t, \\n, \\r combinations are allowed as escape characters.");
        }
    }
}
