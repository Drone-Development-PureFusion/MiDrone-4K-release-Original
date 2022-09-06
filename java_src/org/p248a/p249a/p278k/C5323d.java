package org.p248a.p249a.p278k;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicRequestLine;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.k.d */
/* loaded from: classes.dex */
public class C5323d implements LineParser {
    @Deprecated

    /* renamed from: a */
    public static final C5323d f22335a = new C5323d();

    /* renamed from: b */
    public static final C5323d f22336b = new C5323d();

    /* renamed from: c */
    protected final ProtocolVersion f22337c;

    public C5323d() {
        this(null);
    }

    public C5323d(ProtocolVersion protocolVersion) {
        this.f22337c = protocolVersion == null ? HttpVersion.HTTP_1_1 : protocolVersion;
    }

    /* renamed from: a */
    public static ProtocolVersion m1434a(String str, LineParser lineParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = f22336b;
        }
        return lineParser.parseProtocolVersion(charArrayBuffer, parserCursor);
    }

    /* renamed from: b */
    public static RequestLine m1431b(String str, LineParser lineParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = f22336b;
        }
        return lineParser.parseRequestLine(charArrayBuffer, parserCursor);
    }

    /* renamed from: c */
    public static StatusLine m1430c(String str, LineParser lineParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = f22336b;
        }
        return lineParser.parseStatusLine(charArrayBuffer, parserCursor);
    }

    /* renamed from: d */
    public static Header m1429d(String str, LineParser lineParser) {
        C5351a.m1321a(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        if (lineParser == null) {
            lineParser = f22336b;
        }
        return lineParser.parseHeader(charArrayBuffer);
    }

    /* renamed from: a */
    protected ProtocolVersion m1436a(int i, int i2) {
        return this.f22337c.forVersion(i, i2);
    }

    /* renamed from: a */
    protected RequestLine m1435a(String str, String str2, ProtocolVersion protocolVersion) {
        return new BasicRequestLine(str, str2, protocolVersion);
    }

    /* renamed from: a */
    protected StatusLine m1433a(ProtocolVersion protocolVersion, int i, String str) {
        return new BasicStatusLine(protocolVersion, i, str);
    }

    /* renamed from: a */
    protected void m1432a(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        boolean z = true;
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        String protocol = this.f22337c.getProtocol();
        int length = protocol.length();
        if (charArrayBuffer.length() < length + 4) {
            return false;
        }
        if (pos < 0) {
            pos = (charArrayBuffer.length() - 4) - length;
        } else if (pos == 0) {
            while (pos < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                pos++;
            }
        }
        if (pos + length + 4 > charArrayBuffer.length()) {
            return false;
        }
        boolean z2 = true;
        for (int i = 0; z2 && i < length; i++) {
            z2 = charArrayBuffer.charAt(pos + i) == protocol.charAt(i);
        }
        if (!z2) {
            z = z2;
        } else if (charArrayBuffer.charAt(pos + length) != '/') {
            z = false;
        }
        return z;
    }

    public Header parseHeader(CharArrayBuffer charArrayBuffer) {
        return new BufferedHeader(charArrayBuffer);
    }

    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        boolean z = true;
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        String protocol = this.f22337c.getProtocol();
        int length = protocol.length();
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        m1432a(charArrayBuffer, parserCursor);
        int pos2 = parserCursor.getPos();
        if (pos2 + length + 4 > upperBound) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        boolean z2 = true;
        for (int i = 0; z2 && i < length; i++) {
            z2 = charArrayBuffer.charAt(pos2 + i) == protocol.charAt(i);
        }
        if (!z2) {
            z = z2;
        } else if (charArrayBuffer.charAt(pos2 + length) != '/') {
            z = false;
        }
        if (!z) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        int i2 = length + 1 + pos2;
        int indexOf = charArrayBuffer.indexOf(46, i2, upperBound);
        if (indexOf == -1) {
            throw new ParseException("Invalid protocol version number: " + charArrayBuffer.substring(pos, upperBound));
        }
        try {
            int parseInt = Integer.parseInt(charArrayBuffer.substringTrimmed(i2, indexOf));
            int i3 = indexOf + 1;
            int indexOf2 = charArrayBuffer.indexOf(32, i3, upperBound);
            if (indexOf2 == -1) {
                indexOf2 = upperBound;
            }
            try {
                int parseInt2 = Integer.parseInt(charArrayBuffer.substringTrimmed(i3, indexOf2));
                parserCursor.updatePos(indexOf2);
                return m1436a(parseInt, parseInt2);
            } catch (NumberFormatException e) {
                throw new ParseException("Invalid protocol minor version number: " + charArrayBuffer.substring(pos, upperBound));
            }
        } catch (NumberFormatException e2) {
            throw new ParseException("Invalid protocol major version number: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            m1432a(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            if (indexOf < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
            parserCursor.updatePos(indexOf);
            m1432a(charArrayBuffer, parserCursor);
            int pos3 = parserCursor.getPos();
            int indexOf2 = charArrayBuffer.indexOf(32, pos3, upperBound);
            if (indexOf2 < 0) {
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            String substringTrimmed2 = charArrayBuffer.substringTrimmed(pos3, indexOf2);
            parserCursor.updatePos(indexOf2);
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            m1432a(charArrayBuffer, parserCursor);
            if (parserCursor.atEnd()) {
                return m1435a(substringTrimmed, substringTrimmed2, parseProtocolVersion);
            }
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        } catch (IndexOutOfBoundsException e) {
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        C5351a.m1321a(charArrayBuffer, "Char array buffer");
        C5351a.m1321a(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            m1432a(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            int i = indexOf < 0 ? upperBound : indexOf;
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, i);
            for (int i2 = 0; i2 < substringTrimmed.length(); i2++) {
                if (!Character.isDigit(substringTrimmed.charAt(i2))) {
                    throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
                }
            }
            try {
                return m1433a(parseProtocolVersion, Integer.parseInt(substringTrimmed), i < upperBound ? charArrayBuffer.substringTrimmed(i, upperBound) : "");
            } catch (NumberFormatException e) {
                throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
            }
        } catch (IndexOutOfBoundsException e2) {
            throw new ParseException("Invalid status line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }
}
