package org.p248a.p249a.p252c.p258f;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.p248a.p249a.C5008b;
import org.p248a.p249a.p250a.AbstractC5006c;
import org.p248a.p249a.p261f.p265d.C5126a;
import p004b.p005a.p006a.p007a.p025n.C0228a;
import p004b.p005a.p006a.p028b.C0359h;
@AbstractC5006c
/* renamed from: org.a.a.c.f.h */
/* loaded from: classes.dex */
public class C5076h {

    /* renamed from: a */
    private String f21604a;

    /* renamed from: b */
    private String f21605b;

    /* renamed from: c */
    private String f21606c;

    /* renamed from: d */
    private String f21607d;

    /* renamed from: e */
    private String f21608e;

    /* renamed from: f */
    private String f21609f;

    /* renamed from: g */
    private int f21610g;

    /* renamed from: h */
    private String f21611h;

    /* renamed from: i */
    private String f21612i;

    /* renamed from: j */
    private String f21613j;

    /* renamed from: k */
    private List<NameValuePair> f21614k;

    /* renamed from: l */
    private String f21615l;

    /* renamed from: m */
    private String f21616m;

    /* renamed from: n */
    private String f21617n;

    public C5076h() {
        this.f21610g = -1;
    }

    public C5076h(String str) {
        m2133a(new URI(str));
    }

    public C5076h(URI uri) {
        m2133a(uri);
    }

    /* renamed from: a */
    private List<NameValuePair> m2134a(String str, Charset charset) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return C5078j.m2091a(str, charset);
    }

    /* renamed from: a */
    private void m2133a(URI uri) {
        this.f21604a = uri.getScheme();
        this.f21605b = uri.getRawSchemeSpecificPart();
        this.f21606c = uri.getRawAuthority();
        this.f21609f = uri.getHost();
        this.f21610g = uri.getPort();
        this.f21608e = uri.getRawUserInfo();
        this.f21607d = uri.getUserInfo();
        this.f21612i = uri.getRawPath();
        this.f21611h = uri.getPath();
        this.f21613j = uri.getRawQuery();
        this.f21614k = m2134a(uri.getRawQuery(), C5008b.f21456e);
        this.f21617n = uri.getRawFragment();
        this.f21616m = uri.getFragment();
    }

    /* renamed from: c */
    private String m2123c(List<NameValuePair> list) {
        return C5078j.m2093a(list, C5008b.f21456e);
    }

    /* renamed from: h */
    private String m2113h(String str) {
        return C5078j.m2080b(str, C5008b.f21456e);
    }

    /* renamed from: i */
    private String m2111i(String str) {
        return C5078j.m2077d(str, C5008b.f21456e);
    }

    /* renamed from: j */
    private String m2109j(String str) {
        return C5078j.m2078c(str, C5008b.f21456e);
    }

    /* renamed from: k */
    private static String m2107k(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    /* renamed from: m */
    private String m2105m() {
        StringBuilder sb = new StringBuilder();
        if (this.f21604a != null) {
            sb.append(this.f21604a).append(C0359h.f671A);
        }
        if (this.f21605b != null) {
            sb.append(this.f21605b);
        } else {
            if (this.f21606c != null) {
                sb.append("//").append(this.f21606c);
            } else if (this.f21609f != null) {
                sb.append("//");
                if (this.f21608e != null) {
                    sb.append(this.f21608e).append("@");
                } else if (this.f21607d != null) {
                    sb.append(m2113h(this.f21607d)).append("@");
                }
                if (C5126a.m1959e(this.f21609f)) {
                    sb.append("[").append(this.f21609f).append("]");
                } else {
                    sb.append(this.f21609f);
                }
                if (this.f21610g >= 0) {
                    sb.append(":").append(this.f21610g);
                }
            }
            if (this.f21612i != null) {
                sb.append(m2107k(this.f21612i));
            } else if (this.f21611h != null) {
                sb.append(m2111i(m2107k(this.f21611h)));
            }
            if (this.f21613j != null) {
                sb.append(C0228a.f351a).append(this.f21613j);
            } else if (this.f21614k != null) {
                sb.append(C0228a.f351a).append(m2123c(this.f21614k));
            } else if (this.f21615l != null) {
                sb.append(C0228a.f351a).append(m2109j(this.f21615l));
            }
        }
        if (this.f21617n != null) {
            sb.append("#").append(this.f21617n);
        } else if (this.f21616m != null) {
            sb.append("#").append(m2109j(this.f21616m));
        }
        return sb.toString();
    }

    /* renamed from: a */
    public URI m2138a() {
        return new URI(m2105m());
    }

    /* renamed from: a */
    public C5076h m2137a(int i) {
        if (i < 0) {
            i = -1;
        }
        this.f21610g = i;
        this.f21605b = null;
        this.f21606c = null;
        return this;
    }

    /* renamed from: a */
    public C5076h m2136a(String str) {
        this.f21604a = str;
        return this;
    }

    /* renamed from: a */
    public C5076h m2135a(String str, String str2) {
        return m2129b(str + C0359h.f671A + str2);
    }

    /* renamed from: a */
    public C5076h m2132a(List<NameValuePair> list) {
        if (this.f21614k == null) {
            this.f21614k = new ArrayList();
        } else {
            this.f21614k.clear();
        }
        this.f21614k.addAll(list);
        this.f21613j = null;
        this.f21605b = null;
        this.f21615l = null;
        return this;
    }

    /* renamed from: a */
    public C5076h m2131a(NameValuePair... nameValuePairArr) {
        if (this.f21614k == null) {
            this.f21614k = new ArrayList();
        } else {
            this.f21614k.clear();
        }
        for (NameValuePair nameValuePair : nameValuePairArr) {
            this.f21614k.add(nameValuePair);
        }
        this.f21613j = null;
        this.f21605b = null;
        this.f21615l = null;
        return this;
    }

    /* renamed from: b */
    public C5076h m2130b() {
        this.f21614k = null;
        this.f21615l = null;
        this.f21613j = null;
        this.f21605b = null;
        return this;
    }

    /* renamed from: b */
    public C5076h m2129b(String str) {
        this.f21607d = str;
        this.f21605b = null;
        this.f21606c = null;
        this.f21608e = null;
        return this;
    }

    /* renamed from: b */
    public C5076h m2128b(String str, String str2) {
        if (this.f21614k == null) {
            this.f21614k = new ArrayList();
        }
        this.f21614k.add(new BasicNameValuePair(str, str2));
        this.f21613j = null;
        this.f21605b = null;
        this.f21615l = null;
        return this;
    }

    /* renamed from: b */
    public C5076h m2127b(List<NameValuePair> list) {
        if (this.f21614k == null) {
            this.f21614k = new ArrayList();
        }
        this.f21614k.addAll(list);
        this.f21613j = null;
        this.f21605b = null;
        this.f21615l = null;
        return this;
    }

    /* renamed from: c */
    public C5076h m2126c() {
        this.f21614k = null;
        this.f21613j = null;
        this.f21605b = null;
        return this;
    }

    /* renamed from: c */
    public C5076h m2125c(String str) {
        this.f21609f = str;
        this.f21605b = null;
        this.f21606c = null;
        return this;
    }

    /* renamed from: c */
    public C5076h m2124c(String str, String str2) {
        if (this.f21614k == null) {
            this.f21614k = new ArrayList();
        }
        if (!this.f21614k.isEmpty()) {
            Iterator<NameValuePair> it2 = this.f21614k.iterator();
            while (it2.hasNext()) {
                if (it2.next().getName().equals(str)) {
                    it2.remove();
                }
            }
        }
        this.f21614k.add(new BasicNameValuePair(str, str2));
        this.f21613j = null;
        this.f21605b = null;
        this.f21615l = null;
        return this;
    }

    /* renamed from: d */
    public C5076h m2121d(String str) {
        this.f21611h = str;
        this.f21605b = null;
        this.f21612i = null;
        return this;
    }

    /* renamed from: d */
    public boolean m2122d() {
        return this.f21604a != null;
    }

    @Deprecated
    /* renamed from: e */
    public C5076h m2119e(String str) {
        this.f21614k = m2134a(str, C5008b.f21456e);
        this.f21615l = null;
        this.f21613j = null;
        this.f21605b = null;
        return this;
    }

    /* renamed from: e */
    public boolean m2120e() {
        return this.f21611h == null;
    }

    /* renamed from: f */
    public String m2118f() {
        return this.f21604a;
    }

    /* renamed from: f */
    public C5076h m2117f(String str) {
        this.f21615l = str;
        this.f21613j = null;
        this.f21605b = null;
        this.f21614k = null;
        return this;
    }

    /* renamed from: g */
    public String m2116g() {
        return this.f21607d;
    }

    /* renamed from: g */
    public C5076h m2115g(String str) {
        this.f21616m = str;
        this.f21617n = null;
        return this;
    }

    /* renamed from: h */
    public String m2114h() {
        return this.f21609f;
    }

    /* renamed from: i */
    public int m2112i() {
        return this.f21610g;
    }

    /* renamed from: j */
    public String m2110j() {
        return this.f21611h;
    }

    /* renamed from: k */
    public List<NameValuePair> m2108k() {
        return this.f21614k != null ? new ArrayList(this.f21614k) : new ArrayList();
    }

    /* renamed from: l */
    public String m2106l() {
        return this.f21616m;
    }

    public String toString() {
        return m2105m();
    }
}
