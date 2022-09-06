package p004b.p005a.p006a.p028b.p057r;

import com.p118d.p119a.p136c.C1947c;
import org.codehaus.jackson.org.objectweb.asm.Opcodes;
import p004b.p005a.p006a.p028b.p041h.C0409j;
/* renamed from: b.a.a.b.r.d */
/* loaded from: classes.dex */
class C0570d {
    /* renamed from: a */
    private String m20119a(int i) {
        return "\\d{" + i + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m20118a(C0569c c0569c) {
        int i = c0569c.f1272b;
        char c = c0569c.f1271a;
        switch (c0569c.f1271a) {
            case '\'':
                if (i != 1) {
                    throw new IllegalStateException("Too many single quotes");
                }
                return "";
            case '.':
                return "\\.";
            case 'D':
            case 'F':
            case C0409j.f902s /* 72 */:
            case C1947c.f6941c /* 75 */:
            case 'S':
            case 'W':
            case 'd':
            case 'h':
            case Opcodes.DMUL /* 107 */:
            case Opcodes.LDIV /* 109 */:
            case Opcodes.DREM /* 115 */:
            case Opcodes.DNEG /* 119 */:
            case Opcodes.LSHL /* 121 */:
                return m20119a(i);
            case 'E':
                return ".{2,12}";
            case 'G':
            case 'z':
                return ".*";
            case 'M':
                return i >= 3 ? ".{3,12}" : m20119a(i);
            case 'Z':
                return "(\\+|-)\\d{4}";
            case Opcodes.DUP2 /* 92 */:
                throw new IllegalStateException("Forward slashes are not allowed");
            case Opcodes.LADD /* 97 */:
                return ".{2}";
            default:
                return i == 1 ? "" + c : c + "{" + i + "}";
        }
    }
}
