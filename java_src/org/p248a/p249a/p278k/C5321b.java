package org.p248a.p249a.p278k;

import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderElement;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.k.b */
/* loaded from: classes.dex */
public class C5321b implements HeaderValueParser {

    /* renamed from: d */
    private static final char f22331d = ',';
    @Deprecated

    /* renamed from: a */
    public static final C5321b f22328a = new C5321b();

    /* renamed from: b */
    public static final C5321b f22329b = new C5321b();

    /* renamed from: c */
    private static final char f22330c = ';';

    /* renamed from: e */
    private static final char[] f22332e = {f22330c, ','};

    /* renamed from: a */
    private static boolean m1453a(char c, char[] cArr) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c == c2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static HeaderElement[] m1450a(String str, HeaderValueParser headerValueParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = f22329b;
        }
        return headerValueParser.parseElements(charArrayBuffer, parserCursor);
    }

    /* renamed from: b */
    public static HeaderElement m1448b(String str, HeaderValueParser headerValueParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = f22329b;
        }
        return headerValueParser.parseHeaderElement(charArrayBuffer, parserCursor);
    }

    /* renamed from: c */
    public static NameValuePair[] m1447c(String str, HeaderValueParser headerValueParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = f22329b;
        }
        return headerValueParser.parseParameters(charArrayBuffer, parserCursor);
    }

    /* renamed from: d */
    public static NameValuePair m1446d(String str, HeaderValueParser headerValueParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (headerValueParser == null) {
            headerValueParser = f22329b;
        }
        return headerValueParser.parseNameValuePair(charArrayBuffer, parserCursor);
    }

    /* renamed from: a */
    protected HeaderElement m1451a(String str, String str2, NameValuePair[] nameValuePairArr) {
        return new BasicHeaderElement(str, str2, nameValuePairArr);
    }

    /* renamed from: a */
    protected NameValuePair m1452a(String str, String str2) {
        return new BasicNameValuePair(str, str2);
    }

    /* renamed from: a */
    public NameValuePair m1449a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, char[] cArr) {
        boolean z;
        String str;
        boolean z2;
        boolean z3 = true;
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (true) {
            if (pos >= upperBound) {
                z = false;
                break;
            }
            char charAt = charArrayBuffer.charAt(pos);
            if (charAt == '=') {
                z = false;
                break;
            } else if (m1453a(charAt, cArr)) {
                z = true;
                break;
            } else {
                pos++;
            }
        }
        if (pos == upperBound) {
            str = charArrayBuffer.substringTrimmed(pos2, upperBound);
            z = true;
        } else {
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, pos);
            pos++;
            str = substringTrimmed;
        }
        if (z) {
            parserCursor.updatePos(pos);
            return m1452a(str, (String) null);
        }
        boolean z4 = false;
        boolean z5 = false;
        int i = pos;
        while (true) {
            if (i < upperBound) {
                char charAt2 = charArrayBuffer.charAt(i);
                if (charAt2 != '\"' || z4) {
                    z2 = z5;
                } else {
                    z2 = !z5;
                }
                if (!z2 && !z4 && m1453a(charAt2, cArr)) {
                    break;
                }
                i++;
                z4 = z4 ? false : z2 && charAt2 == '\\';
                z5 = z2;
            } else {
                z3 = z;
                break;
            }
        }
        int i2 = pos;
        while (i2 < i && HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
            i2++;
        }
        int i3 = i;
        while (i3 > i2 && HTTP.isWhitespace(charArrayBuffer.charAt(i3 - 1))) {
            i3--;
        }
        if (i3 - i2 >= 2 && charArrayBuffer.charAt(i2) == '\"' && charArrayBuffer.charAt(i3 - 1) == '\"') {
            i2++;
            i3--;
        }
        String substring = charArrayBuffer.substring(i2, i3);
        parserCursor.updatePos(z3 ? i + 1 : i);
        return m1452a(str, substring);
    }

    public HeaderElement[] parseElements(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            HeaderElement parseHeaderElement = parseHeaderElement(charArrayBuffer, parserCursor);
            if (parseHeaderElement.getName().length() != 0 || parseHeaderElement.getValue() != null) {
                arrayList.add(parseHeaderElement);
            }
        }
        return (HeaderElement[]) arrayList.toArray(new HeaderElement[arrayList.size()]);
    }

    public HeaderElement parseHeaderElement(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        NameValuePair parseNameValuePair = parseNameValuePair(charArrayBuffer, parserCursor);
        NameValuePair[] nameValuePairArr = null;
        if (!parserCursor.atEnd() && charArrayBuffer.charAt(parserCursor.getPos() - 1) != ',') {
            nameValuePairArr = parseParameters(charArrayBuffer, parserCursor);
        }
        return m1451a(parseNameValuePair.getName(), parseNameValuePair.getValue(), nameValuePairArr);
    }

    public NameValuePair parseNameValuePair(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        return m1449a(charArrayBuffer, parserCursor, f22332e);
    }

    public NameValuePair[] parseParameters(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
        if (parserCursor.atEnd()) {
            return new NameValuePair[0];
        }
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            arrayList.add(parseNameValuePair(charArrayBuffer, parserCursor));
            if (charArrayBuffer.charAt(parserCursor.getPos() - 1) == ',') {
                break;
            }
        }
        return (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]);
    }
}
