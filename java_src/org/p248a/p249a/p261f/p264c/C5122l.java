package org.p248a.p249a.p261f.p264c;

import java.util.BitSet;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
/* renamed from: org.a.a.f.c.l */
/* loaded from: classes2.dex */
class C5122l {

    /* renamed from: a */
    public static final char f21761a = '\r';

    /* renamed from: b */
    public static final char f21762b = '\n';

    /* renamed from: c */
    public static final char f21763c = ' ';

    /* renamed from: d */
    public static final char f21764d = '\t';

    /* renamed from: e */
    public static final char f21765e = '\"';

    /* renamed from: f */
    public static final char f21766f = '\\';

    /* renamed from: g */
    public static final C5122l f21767g = new C5122l();

    /* renamed from: a */
    public static BitSet m1967a(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i : iArr) {
            bitSet.set(i);
        }
        return bitSet;
    }

    /* renamed from: a */
    public static boolean m1972a(char c) {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }

    /* renamed from: a */
    public String m1969a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!parserCursor.atEnd()) {
            char charAt = charArrayBuffer.charAt(parserCursor.getPos());
            if (bitSet != null && bitSet.get(charAt)) {
                break;
            } else if (m1972a(charAt)) {
                m1971a(charArrayBuffer, parserCursor);
                z = true;
            } else {
                if (z && sb.length() > 0) {
                    sb.append(f21763c);
                }
                m1965b(charArrayBuffer, parserCursor, bitSet, sb);
                z = false;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public void m1971a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound && m1972a(charArrayBuffer.charAt(pos2)); pos2++) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    /* renamed from: a */
    public void m1970a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, StringBuilder sb) {
        int i;
        if (parserCursor.atEnd()) {
            return;
        }
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        if (charArrayBuffer.charAt(pos) != '\"') {
            return;
        }
        int i2 = pos + 1;
        int i3 = pos2 + 1;
        boolean z = false;
        while (true) {
            if (i3 >= upperBound) {
                i = i2;
                break;
            }
            char charAt = charArrayBuffer.charAt(i3);
            if (z) {
                if (charAt != '\"' && charAt != '\\') {
                    sb.append('\\');
                }
                sb.append(charAt);
                z = false;
            } else if (charAt == '\"') {
                i = i2 + 1;
                break;
            } else if (charAt == '\\') {
                z = true;
            } else if (charAt != '\r' && charAt != '\n') {
                sb.append(charAt);
            }
            i3++;
            i2++;
        }
        parserCursor.updatePos(i);
    }

    /* renamed from: a */
    public void mo1968a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char charAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(charAt)) || m1972a(charAt) || charAt == '\"') {
                break;
            }
            pos++;
            sb.append(charAt);
        }
        parserCursor.updatePos(pos);
    }

    /* renamed from: b */
    public String m1966b(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        while (!parserCursor.atEnd()) {
            char charAt = charArrayBuffer.charAt(parserCursor.getPos());
            if (bitSet != null && bitSet.get(charAt)) {
                break;
            } else if (m1972a(charAt)) {
                m1971a(charArrayBuffer, parserCursor);
                z = true;
            } else if (charAt == '\"') {
                if (z && sb.length() > 0) {
                    sb.append(f21763c);
                }
                m1970a(charArrayBuffer, parserCursor, sb);
                z = false;
            } else {
                if (z && sb.length() > 0) {
                    sb.append(f21763c);
                }
                mo1968a(charArrayBuffer, parserCursor, bitSet, sb);
                z = false;
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    public void m1965b(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char charAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(charAt)) || m1972a(charAt)) {
                break;
            }
            pos++;
            sb.append(charAt);
        }
        parserCursor.updatePos(pos);
    }
}
