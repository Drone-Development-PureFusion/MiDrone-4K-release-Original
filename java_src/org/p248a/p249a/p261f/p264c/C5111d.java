package org.p248a.p249a.p261f.p264c;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.f.c.d */
/* loaded from: classes2.dex */
final class C5111d {

    /* renamed from: a */
    public static final C5111d f21734a = new C5111d();

    /* renamed from: b */
    private static final BitSet f21735b = C5122l.m1967a(61, 44, 43);

    /* renamed from: c */
    private static final BitSet f21736c = C5122l.m1967a(44, 43);

    /* renamed from: d */
    private final C5122l f21737d = new C5112a();

    /* renamed from: org.a.a.f.c.d$a */
    /* loaded from: classes2.dex */
    static class C5112a extends C5122l {
        C5112a() {
        }

        @Override // org.p248a.p249a.p261f.p264c.C5122l
        /* renamed from: a */
        public void mo1968a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb) {
            int pos = parserCursor.getPos();
            int pos2 = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            int i = pos;
            int i2 = pos2;
            boolean z = false;
            while (i2 < upperBound) {
                char charAt = charArrayBuffer.charAt(i2);
                if (!z) {
                    if ((bitSet != null && bitSet.get(charAt)) || C5122l.m1972a(charAt) || charAt == '\"') {
                        break;
                    } else if (charAt == '\\') {
                        z = true;
                    } else {
                        sb.append(charAt);
                    }
                } else {
                    sb.append(charAt);
                    z = false;
                }
                i2++;
                i++;
            }
            parserCursor.updatePos(i);
        }
    }

    C5111d() {
    }

    /* renamed from: a */
    String m1999a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        return this.f21737d.m1969a(charArrayBuffer, parserCursor, bitSet);
    }

    /* renamed from: a */
    public List<NameValuePair> m2001a(String str) {
        if (str == null) {
            return null;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        return m1998b(charArrayBuffer, new ParserCursor(0, str.length()));
    }

    /* renamed from: a */
    NameValuePair m2000a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        String m1999a = m1999a(charArrayBuffer, parserCursor, f21735b);
        if (parserCursor.atEnd()) {
            return new BasicNameValuePair(m1999a, (String) null);
        }
        char charAt = charArrayBuffer.charAt(parserCursor.getPos());
        parserCursor.updatePos(parserCursor.getPos() + 1);
        if (charAt == ',') {
            return new BasicNameValuePair(m1999a, (String) null);
        }
        String m1997b = m1997b(charArrayBuffer, parserCursor, f21736c);
        if (!parserCursor.atEnd()) {
            parserCursor.updatePos(parserCursor.getPos() + 1);
        }
        return new BasicNameValuePair(m1999a, m1997b);
    }

    /* renamed from: b */
    String m1997b(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        return this.f21737d.m1966b(charArrayBuffer, parserCursor, bitSet);
    }

    /* renamed from: b */
    public List<NameValuePair> m1998b(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        ArrayList arrayList = new ArrayList();
        this.f21737d.m1971a(charArrayBuffer, parserCursor);
        while (!parserCursor.atEnd()) {
            arrayList.add(m2000a(charArrayBuffer, parserCursor));
        }
        return arrayList;
    }
}
