package org.p248a.p249a.p268i.p272d;

import com.tencent.open.GameAppOperation;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.ah */
/* loaded from: classes2.dex */
public class C5242ah extends C5235aa {
    public C5242ah() {
        this(null, false);
    }

    public C5242ah(String[] strArr, boolean z) {
        super(strArr, z);
        a("domain", new C5239ae());
        a("port", new C5240af());
        a("commenturl", new C5237ac());
        a("discard", new C5238ad());
        a(GameAppOperation.QQFAV_DATALINE_VERSION, new C5243ai());
    }

    /* renamed from: b */
    private List<Cookie> m1560b(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) {
        ArrayList arrayList = new ArrayList(headerElementArr.length);
        for (HeaderElement headerElement : headerElementArr) {
            String name = headerElement.getName();
            String value = headerElement.getValue();
            if (name == null || name.length() == 0) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            C5245c c5245c = new C5245c(name, value);
            c5245c.setPath(a(cookieOrigin));
            c5245c.setDomain(b(cookieOrigin));
            c5245c.setPorts(new int[]{cookieOrigin.getPort()});
            NameValuePair[] parameters = headerElement.getParameters();
            HashMap hashMap = new HashMap(parameters.length);
            for (int length = parameters.length - 1; length >= 0; length--) {
                NameValuePair nameValuePair = parameters[length];
                hashMap.put(nameValuePair.getName().toLowerCase(Locale.ENGLISH), nameValuePair);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                NameValuePair nameValuePair2 = (NameValuePair) entry.getValue();
                String lowerCase = nameValuePair2.getName().toLowerCase(Locale.ENGLISH);
                c5245c.a(lowerCase, nameValuePair2.getValue());
                CookieAttributeHandler a = a(lowerCase);
                if (a != null) {
                    a.parse(c5245c, nameValuePair2.getValue());
                }
            }
            arrayList.add(c5245c);
        }
        return arrayList;
    }

    /* renamed from: c */
    private static CookieOrigin m1559c(CookieOrigin cookieOrigin) {
        boolean z = false;
        String host = cookieOrigin.getHost();
        int i = 0;
        while (true) {
            if (i >= host.length()) {
                z = true;
                break;
            }
            char charAt = host.charAt(i);
            if (charAt == '.' || charAt == ':') {
                break;
            }
            i++;
        }
        return z ? new CookieOrigin(host + ".local", cookieOrigin.getPort(), cookieOrigin.getPath(), cookieOrigin.isSecure()) : cookieOrigin;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.p272d.AbstractC5261p
    /* renamed from: a */
    public List<Cookie> mo1548a(HeaderElement[] headerElementArr, CookieOrigin cookieOrigin) {
        return m1560b(headerElementArr, m1559c(cookieOrigin));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.p248a.p249a.p268i.p272d.C5235aa
    /* renamed from: a */
    public void mo1561a(CharArrayBuffer charArrayBuffer, Cookie cookie, int i) {
        String attribute;
        int[] ports;
        super.mo1561a(charArrayBuffer, cookie, i);
        if (!(cookie instanceof ClientCookie) || (attribute = ((ClientCookie) cookie).getAttribute("port")) == null) {
            return;
        }
        charArrayBuffer.append("; $Port");
        charArrayBuffer.append("=\"");
        if (attribute.trim().length() > 0 && (ports = cookie.getPorts()) != null) {
            int length = ports.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 > 0) {
                    charArrayBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                charArrayBuffer.append(Integer.toString(ports[i2]));
            }
        }
        charArrayBuffer.append("\"");
    }

    @Override // org.p248a.p249a.p268i.p272d.C5235aa
    public int getVersion() {
        return 1;
    }

    @Override // org.p248a.p249a.p268i.p272d.C5235aa
    public Header getVersionHeader() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40);
        charArrayBuffer.append("Cookie2");
        charArrayBuffer.append(": ");
        charArrayBuffer.append("$Version=");
        charArrayBuffer.append(Integer.toString(getVersion()));
        return new BufferedHeader(charArrayBuffer);
    }

    @Override // org.p248a.p249a.p268i.p272d.AbstractC5261p
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        return super.match(cookie, m1559c(cookieOrigin));
    }

    @Override // org.p248a.p249a.p268i.p272d.C5235aa
    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) {
        C5351a.m1321a(header, "Header");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie2")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
        return m1560b(header.getElements(), m1559c(cookieOrigin));
    }

    @Override // org.p248a.p249a.p268i.p272d.C5235aa
    public String toString() {
        return "rfc2965";
    }

    @Override // org.p248a.p249a.p268i.p272d.C5235aa, org.p248a.p249a.p268i.p272d.AbstractC5261p
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        super.validate(cookie, m1559c(cookieOrigin));
    }
}
