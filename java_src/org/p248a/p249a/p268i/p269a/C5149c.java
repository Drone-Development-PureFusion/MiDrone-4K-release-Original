package org.p248a.p249a.p268i.p269a;

import android.util.Base64;
import java.nio.charset.Charset;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.Credentials;
import org.apache.http.message.BufferedHeader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;
import org.p248a.p249a.C5008b;
import org.p248a.p249a.C5083e;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p251b.EnumC5013e;
import org.p248a.p249a.p281n.C5339a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.a.c */
/* loaded from: classes.dex */
public class C5149c extends AbstractC5166k {

    /* renamed from: a */
    private boolean f21820a;

    public C5149c() {
        this(C5008b.f21457f);
    }

    public C5149c(Charset charset) {
        super(charset);
        this.f21820a = false;
    }

    @Deprecated
    public C5149c(EnumC5013e enumC5013e) {
        super(enumC5013e);
    }

    @Deprecated
    /* renamed from: a */
    public static Header m1919a(Credentials credentials, String str, boolean z) {
        C5351a.m1321a(credentials, "Credentials");
        C5351a.m1321a(str, "charset");
        StringBuilder sb = new StringBuilder();
        sb.append(credentials.getUserPrincipal().getName());
        sb.append(":");
        sb.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] encode = Base64.encode(EncodingUtils.getBytes(sb.toString(), str), 2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (z) {
            charArrayBuffer.append(C5083e.f21650N);
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(encode, 0, encode.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Override // org.p248a.p249a.p268i.p269a.AbstractC5147a, org.p248a.p249a.p251b.AbstractC5014f
    /* renamed from: a */
    public Header mo1915a(Credentials credentials, HttpRequest httpRequest, HttpContext httpContext) {
        C5351a.m1321a(credentials, "Credentials");
        C5351a.m1321a(httpRequest, "HTTP request");
        StringBuilder sb = new StringBuilder();
        sb.append(credentials.getUserPrincipal().getName());
        sb.append(":");
        sb.append(credentials.getPassword() == null ? "null" : credentials.getPassword());
        byte[] encode = Base64.encode(EncodingUtils.getBytes(sb.toString(), a(httpRequest)), 2);
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        if (a()) {
            charArrayBuffer.append(C5083e.f21650N);
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Basic ");
        charArrayBuffer.append(encode, 0, encode.length);
        return new BufferedHeader(charArrayBuffer);
    }

    @Deprecated
    public Header authenticate(Credentials credentials, HttpRequest httpRequest) {
        return mo1915a(credentials, httpRequest, new C5339a());
    }

    public String getSchemeName() {
        return "basic";
    }

    public boolean isComplete() {
        return this.f21820a;
    }

    public boolean isConnectionBased() {
        return false;
    }

    @Override // org.p248a.p249a.p268i.p269a.AbstractC5147a
    public void processChallenge(Header header) {
        super.processChallenge(header);
        this.f21820a = true;
    }
}
