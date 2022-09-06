package org.p248a.p249a.p267h;

import com.baidu.tts.loopj.RequestParams;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.C5008b;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p252c.p258f.C5078j;
import org.p248a.p249a.p278k.C5320a;
import org.p248a.p249a.p278k.C5321b;
import org.p248a.p249a.p282o.C5351a;
import org.p248a.p249a.p282o.C5356f;
@AbstractC5005b
/* renamed from: org.a.a.h.e */
/* loaded from: classes2.dex */
public final class C5140e implements Serializable {

    /* renamed from: a */
    public static final C5140e f21787a = m1944a("application/atom+xml", C5008b.f21458g);

    /* renamed from: b */
    public static final C5140e f21788b = m1944a(C5078j.f21618a, C5008b.f21458g);

    /* renamed from: c */
    public static final C5140e f21789c = m1944a(RequestParams.APPLICATION_JSON, C5008b.f21456e);

    /* renamed from: d */
    public static final C5140e f21790d = m1944a(RequestParams.APPLICATION_OCTET_STREAM, (Charset) null);

    /* renamed from: e */
    public static final C5140e f21791e = m1944a("application/svg+xml", C5008b.f21458g);

    /* renamed from: f */
    public static final C5140e f21792f = m1944a("application/xhtml+xml", C5008b.f21458g);

    /* renamed from: g */
    public static final C5140e f21793g = m1944a("application/xml", C5008b.f21458g);

    /* renamed from: h */
    public static final C5140e f21794h = m1944a("multipart/form-data", C5008b.f21458g);

    /* renamed from: i */
    public static final C5140e f21795i = m1944a("text/html", C5008b.f21458g);

    /* renamed from: j */
    public static final C5140e f21796j = m1944a("text/plain", C5008b.f21458g);

    /* renamed from: k */
    public static final C5140e f21797k = m1944a("text/xml", C5008b.f21458g);

    /* renamed from: l */
    public static final C5140e f21798l = m1944a("*/*", (Charset) null);

    /* renamed from: m */
    public static final C5140e f21799m = f21796j;

    /* renamed from: n */
    public static final C5140e f21800n = f21790d;
    private static final long serialVersionUID = -7768694718232371896L;

    /* renamed from: o */
    private final String f21801o;

    /* renamed from: p */
    private final Charset f21802p;

    /* renamed from: q */
    private final NameValuePair[] f21803q;

    C5140e(String str, Charset charset) {
        this.f21801o = str;
        this.f21802p = charset;
        this.f21803q = null;
    }

    C5140e(String str, NameValuePair[] nameValuePairArr) {
        this.f21801o = str;
        this.f21803q = nameValuePairArr;
        String m1946a = m1946a("charset");
        this.f21802p = !C5356f.m1296b(m1946a) ? Charset.forName(m1946a) : null;
    }

    /* renamed from: a */
    public static C5140e m1945a(String str, String str2) {
        return m1944a(str, !C5356f.m1296b(str2) ? Charset.forName(str2) : null);
    }

    /* renamed from: a */
    public static C5140e m1944a(String str, Charset charset) {
        String lowerCase = ((String) C5351a.m1315b(str, "MIME type")).toLowerCase(Locale.US);
        C5351a.m1319a(m1935e(lowerCase), "MIME type may not contain reserved characters");
        return new C5140e(lowerCase, charset);
    }

    /* renamed from: a */
    private static C5140e m1942a(HeaderElement headerElement) {
        String name = headerElement.getName();
        NameValuePair[] parameters = headerElement.getParameters();
        if (parameters == null || parameters.length <= 0) {
            parameters = null;
        }
        return new C5140e(name, parameters);
    }

    /* renamed from: a */
    public static C5140e m1941a(HttpEntity httpEntity) {
        Header contentType;
        if (httpEntity == null || (contentType = httpEntity.getContentType()) == null) {
            return null;
        }
        HeaderElement[] elements = contentType.getElements();
        if (elements.length <= 0) {
            return null;
        }
        return m1942a(elements[0]);
    }

    /* renamed from: b */
    public static C5140e m1939b(String str) {
        return new C5140e(str, (Charset) null);
    }

    /* renamed from: b */
    public static C5140e m1938b(HttpEntity httpEntity) {
        C5140e m1941a = m1941a(httpEntity);
        return m1941a != null ? m1941a : f21799m;
    }

    /* renamed from: c */
    public static C5140e m1937c(String str) {
        C5351a.m1321a(str, "Content type");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        HeaderElement[] parseElements = C5321b.f22329b.parseElements(charArrayBuffer, new ParserCursor(0, str.length()));
        if (parseElements.length > 0) {
            return m1942a(parseElements[0]);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    /* renamed from: e */
    private static boolean m1935e(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public String m1947a() {
        return this.f21801o;
    }

    /* renamed from: a */
    public String m1946a(String str) {
        NameValuePair[] nameValuePairArr;
        C5351a.m1322a(str, "Parameter name");
        if (this.f21803q == null) {
            return null;
        }
        for (NameValuePair nameValuePair : this.f21803q) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair.getValue();
            }
        }
        return null;
    }

    /* renamed from: a */
    public C5140e m1943a(Charset charset) {
        return m1944a(m1947a(), charset);
    }

    /* renamed from: b */
    public Charset m1940b() {
        return this.f21802p;
    }

    /* renamed from: d */
    public C5140e m1936d(String str) {
        return m1945a(m1947a(), str);
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.f21801o);
        if (this.f21803q != null) {
            charArrayBuffer.append("; ");
            C5320a.f22325b.formatParameters(charArrayBuffer, this.f21803q, false);
        } else if (this.f21802p != null) {
            charArrayBuffer.append("; charset=");
            charArrayBuffer.append(this.f21802p.name());
        }
        return charArrayBuffer.toString();
    }
}
