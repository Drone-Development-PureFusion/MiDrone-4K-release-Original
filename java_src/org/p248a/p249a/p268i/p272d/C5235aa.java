package org.p248a.p249a.p268i.p272d;

import com.tencent.open.GameAppOperation;
import com.tencent.p227mm.sdk.contact.RContact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookiePathComparator;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p252c.p258f.C5068b;
import org.p248a.p249a.p266g.C5134a;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5006c
/* renamed from: org.a.a.i.d.aa */
/* loaded from: classes2.dex */
public class C5235aa extends AbstractC5261p {

    /* renamed from: a */
    private static final CookiePathComparator f22129a = new CookiePathComparator();

    /* renamed from: b */
    private static final String[] f22130b = {C5068b.f21586a, C5068b.f21587b, C5068b.f21588c};

    /* renamed from: c */
    private final String[] f22131c;

    /* renamed from: d */
    private final boolean f22132d;

    public C5235aa() {
        this(null, false);
    }

    public C5235aa(String[] strArr, boolean z) {
        if (strArr != null) {
            this.f22131c = (String[]) strArr.clone();
        } else {
            this.f22131c = f22130b;
        }
        this.f22132d = z;
        a(GameAppOperation.QQFAV_DATALINE_VERSION, new C5236ab());
        a("path", new C5251i());
        a("domain", new C5270y());
        a("max-age", new C5250h());
        a("secure", new C5252j());
        a("comment", new C5247e());
        a("expires", new C5249g(this.f22131c));
    }

    /* renamed from: a */
    private List<Header> m1567a(List<Cookie> list) {
        int i;
        int i2 = Integer.MAX_VALUE;
        Iterator<Cookie> it2 = list.iterator();
        while (true) {
            i = i2;
            if (!it2.hasNext()) {
                break;
            }
            Cookie next = it2.next();
            i2 = next.getVersion() < i ? next.getVersion() : i;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 40);
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        charArrayBuffer.append("$Version=");
        charArrayBuffer.append(Integer.toString(i));
        for (Cookie cookie : list) {
            charArrayBuffer.append("; ");
            mo1561a(charArrayBuffer, cookie, i);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }

    /* renamed from: b */
    private List<Header> m1565b(List<Cookie> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Cookie cookie : list) {
            int version = cookie.getVersion();
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(40);
            charArrayBuffer.append("Cookie: ");
            charArrayBuffer.append("$Version=");
            charArrayBuffer.append(Integer.toString(version));
            charArrayBuffer.append("; ");
            mo1561a(charArrayBuffer, cookie, version);
            arrayList.add(new BufferedHeader(charArrayBuffer));
        }
        return arrayList;
    }

    /* renamed from: a */
    protected void m1566a(CharArrayBuffer charArrayBuffer, String str, String str2, int i) {
        charArrayBuffer.append(str);
        charArrayBuffer.append("=");
        if (str2 != null) {
            if (i <= 0) {
                charArrayBuffer.append(str2);
                return;
            }
            charArrayBuffer.append('\"');
            charArrayBuffer.append(str2);
            charArrayBuffer.append('\"');
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1561a(CharArrayBuffer charArrayBuffer, Cookie cookie, int i) {
        m1566a(charArrayBuffer, cookie.getName(), cookie.getValue(), i);
        if (cookie.getPath() != null && (cookie instanceof ClientCookie) && ((ClientCookie) cookie).containsAttribute("path")) {
            charArrayBuffer.append("; ");
            m1566a(charArrayBuffer, "$Path", cookie.getPath(), i);
        }
        if (cookie.getDomain() == null || !(cookie instanceof ClientCookie) || !((ClientCookie) cookie).containsAttribute("domain")) {
            return;
        }
        charArrayBuffer.append("; ");
        m1566a(charArrayBuffer, "$Domain", cookie.getDomain(), i);
    }

    public List<Header> formatCookies(List<Cookie> list) {
        C5351a.m1320a(list, "List of cookies");
        if (list.size() > 1) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, f22129a);
            list = arrayList;
        }
        return this.f22132d ? m1567a(list) : m1565b(list);
    }

    public int getVersion() {
        return 1;
    }

    public Header getVersionHeader() {
        return null;
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) {
        C5351a.m1321a(header, "Header");
        C5351a.m1321a(cookieOrigin, "Cookie origin");
        if (!header.getName().equalsIgnoreCase("Set-Cookie")) {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
        return a(header.getElements(), cookieOrigin);
    }

    public String toString() {
        return "rfc2109";
    }

    @Override // org.p248a.p249a.p268i.p272d.AbstractC5261p
    public void validate(Cookie cookie, CookieOrigin cookieOrigin) {
        C5351a.m1321a(cookie, "Cookie");
        String name = cookie.getName();
        if (name.indexOf(32) != -1) {
            throw new C5134a("Cookie name may not contain blanks");
        }
        if (name.startsWith(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR)) {
            throw new C5134a("Cookie name may not start with $");
        }
        super.validate(cookie, cookieOrigin);
    }
}
