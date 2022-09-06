package org.p248a.p249a.p268i.p269a;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5008b;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p251b.EnumC5013e;
import org.p248a.p249a.p278k.C5321b;
@AbstractC5006c
/* renamed from: org.a.a.i.a.k */
/* loaded from: classes.dex */
public abstract class AbstractC5166k extends AbstractC5147a {

    /* renamed from: a */
    private final Map<String, String> f21917a;

    /* renamed from: b */
    private final Charset f21918b;

    public AbstractC5166k() {
        this(C5008b.f21457f);
    }

    public AbstractC5166k(Charset charset) {
        this.f21917a = new HashMap();
        this.f21918b = charset == null ? C5008b.f21457f : charset;
    }

    @Deprecated
    public AbstractC5166k(EnumC5013e enumC5013e) {
        super(enumC5013e);
        this.f21917a = new HashMap();
        this.f21918b = C5008b.f21457f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m1810a(HttpRequest httpRequest) {
        String str = (String) httpRequest.getParams().getParameter("http.auth.credential-charset");
        return str == null ? m1808g().name() : str;
    }

    @Override // org.p248a.p249a.p268i.p269a.AbstractC5147a
    /* renamed from: a */
    protected void mo1809a(CharArrayBuffer charArrayBuffer, int i, int i2) {
        HeaderElement[] parseElements = C5321b.f22329b.parseElements(charArrayBuffer, new ParserCursor(i, charArrayBuffer.length()));
        if (parseElements.length == 0) {
            throw new MalformedChallengeException("Authentication challenge is empty");
        }
        this.f21917a.clear();
        for (HeaderElement headerElement : parseElements) {
            this.f21917a.put(headerElement.getName().toLowerCase(Locale.ENGLISH), headerElement.getValue());
        }
    }

    /* renamed from: g */
    public Charset m1808g() {
        return this.f21918b;
    }

    public String getParameter(String str) {
        if (str == null) {
            return null;
        }
        return this.f21917a.get(str.toLowerCase(Locale.ENGLISH));
    }

    public String getRealm() {
        return getParameter("realm");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public Map<String, String> m1807h() {
        return this.f21917a;
    }
}
