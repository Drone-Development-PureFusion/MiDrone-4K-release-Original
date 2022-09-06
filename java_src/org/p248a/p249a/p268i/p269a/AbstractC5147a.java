package org.p248a.p249a.p268i.p269a;

import java.util.Locale;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p251b.AbstractC5014f;
import org.p248a.p249a.p251b.EnumC5013e;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC5147a implements AbstractC5014f {

    /* renamed from: a */
    private EnumC5013e f21818a;

    public AbstractC5147a() {
    }

    @Deprecated
    public AbstractC5147a(EnumC5013e enumC5013e) {
        this.f21818a = enumC5013e;
    }

    @Override // org.p248a.p249a.p251b.AbstractC5014f
    /* renamed from: a */
    public Header mo1915a(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) {
        return authenticate(credentials, httpRequest);
    }

    /* renamed from: a */
    protected abstract void mo1809a(CharArrayBuffer charArrayBuffer, int i, int i2);

    /* renamed from: a */
    public boolean m1921a() {
        return this.f21818a != null && this.f21818a == EnumC5013e.PROXY;
    }

    /* renamed from: b */
    public EnumC5013e m1920b() {
        return this.f21818a;
    }

    public void processChallenge(Header header) {
        CharArrayBuffer charArrayBuffer;
        int i;
        C5351a.m1321a(header, "Header");
        String name = header.getName();
        if (name.equalsIgnoreCase(C5083e.f21666ac)) {
            this.f21818a = EnumC5013e.TARGET;
        } else if (!name.equalsIgnoreCase(C5083e.f21649M)) {
            throw new MalformedChallengeException("Unexpected header name: " + name);
        } else {
            this.f21818a = EnumC5013e.PROXY;
        }
        if (header instanceof FormattedHeader) {
            charArrayBuffer = ((FormattedHeader) header).getBuffer();
            i = ((FormattedHeader) header).getValuePos();
        } else {
            String value = header.getValue();
            if (value == null) {
                throw new MalformedChallengeException("Header value is null");
            }
            charArrayBuffer = new CharArrayBuffer(value.length());
            charArrayBuffer.append(value);
            i = 0;
        }
        while (i < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(i))) {
            i++;
        }
        int i2 = i;
        while (i2 < charArrayBuffer.length() && !HTTP.isWhitespace(charArrayBuffer.charAt(i2))) {
            i2++;
        }
        String substring = charArrayBuffer.substring(i, i2);
        if (!substring.equalsIgnoreCase(getSchemeName())) {
            throw new MalformedChallengeException("Invalid scheme identifier: " + substring);
        }
        mo1809a(charArrayBuffer, i2, charArrayBuffer.length());
    }

    public String toString() {
        String schemeName = getSchemeName();
        return schemeName != null ? schemeName.toUpperCase(Locale.ENGLISH) : super.toString();
    }
}
