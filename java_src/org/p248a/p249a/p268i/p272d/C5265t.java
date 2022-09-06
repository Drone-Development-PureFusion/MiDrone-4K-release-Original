package org.p248a.p249a.p268i.p272d;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.i.d.t */
/* loaded from: classes2.dex */
public class C5265t {

    /* renamed from: a */
    public static final C5265t f22165a = new C5265t();

    /* renamed from: b */
    private NameValuePair m1544b(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        String str;
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (true) {
            if (pos < upperBound) {
                char charAt = charArrayBuffer.charAt(pos);
                if (charAt == '=') {
                    break;
                } else if (charAt == ';') {
                    z3 = true;
                    break;
                } else {
                    pos++;
                }
            } else {
                break;
            }
        }
        if (pos == upperBound) {
            str = charArrayBuffer.substringTrimmed(pos2, upperBound);
            z = true;
        } else {
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, pos);
            pos++;
            str = substringTrimmed;
            z = z3;
        }
        if (z) {
            parserCursor.updatePos(pos);
            return new BasicNameValuePair(str, (String) null);
        }
        int i = pos;
        while (true) {
            if (i >= upperBound) {
                z2 = z;
                break;
            } else if (charArrayBuffer.charAt(i) == ';') {
                break;
            } else {
                i++;
            }
        }
        while (pos < i && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        int i2 = i;
        while (i2 > pos && HTTP.isWhitespace(charArrayBuffer.charAt(i2 - 1))) {
            i2--;
        }
        String substring = charArrayBuffer.substring(pos, i2);
        parserCursor.updatePos(z2 ? i + 1 : i);
        return new BasicNameValuePair(str, substring);
    }

    /* renamed from: a */
    public HeaderElement m1545a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        NameValuePair m1544b = m1544b(charArrayBuffer, parserCursor);
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(m1544b(charArrayBuffer, parserCursor));
        }
        return new BasicHeaderElement(m1544b.getName(), m1544b.getValue(), (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]));
    }
}
