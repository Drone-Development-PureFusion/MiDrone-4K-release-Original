package org.p248a.p249a.p261f.p264c;

import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.NameValuePair;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p261f.p265d.C5126a;
import org.p248a.p249a.p282o.C5356f;
import org.p318d.AbstractC5756f;
@AbstractC5005b
/* renamed from: org.a.a.f.c.a */
/* loaded from: classes.dex */
public abstract class AbstractC5108a implements X509HostnameVerifier {

    /* renamed from: a */
    private static final String[] f21732a = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};

    /* renamed from: b */
    private static final String f21733b = "HttpClient";

    static {
        Arrays.sort(f21732a);
    }

    @Deprecated
    /* renamed from: a */
    public static boolean m2011a(String str) {
        String[] split = str.split("\\.");
        return (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(f21732a, split[1]) >= 0) ? false : true;
    }

    /* renamed from: a */
    public static String[] m2009a(X509Certificate x509Certificate) {
        try {
            return m2006c(x509Certificate.getSubjectX500Principal().toString());
        } catch (SSLException e) {
            return null;
        }
    }

    /* renamed from: a */
    private static String[] m2008a(X509Certificate x509Certificate, String str) {
        Collection<List<?>> collection;
        int i = m2004e(str) ? 7 : 2;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == i) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (!linkedList.isEmpty()) {
            String[] strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
            return strArr;
        }
        return null;
    }

    /* renamed from: b */
    public static String[] m2007b(X509Certificate x509Certificate) {
        return m2008a(x509Certificate, null);
    }

    /* renamed from: c */
    static String[] m2006c(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<NameValuePair> m2001a = C5111d.f21734a.m2001a(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m2001a.size()) {
                return arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            NameValuePair nameValuePair = m2001a.get(i2);
            String name = nameValuePair.getName();
            String value = nameValuePair.getValue();
            if (C5356f.m1296b(name)) {
                throw new SSLException(str + " is not a valid X500 distinguished name");
            }
            if (name.equalsIgnoreCase("cn")) {
                arrayList.add(value);
            }
            i = i2 + 1;
        }
    }

    /* renamed from: d */
    public static int m2005d(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    /* renamed from: e */
    private static boolean m2004e(String str) {
        return str != null && (C5126a.m1963a(str) || C5126a.m1959e(str));
    }

    /* renamed from: f */
    private String m2003f(String str) {
        if (str == null || !C5126a.m1959e(str)) {
            return str;
        }
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (UnknownHostException e) {
            Log.e(f21733b, "Unexpected error converting " + str, e);
            return str;
        }
    }

    /* renamed from: a */
    public final void m2010a(String str, String[] strArr, String[] strArr2, boolean z) {
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && strArr[0] != null) {
            linkedList.add(strArr[0]);
        }
        if (strArr2 != null) {
            for (String str2 : strArr2) {
                if (str2 != null) {
                    linkedList.add(str2);
                }
            }
        }
        if (linkedList.isEmpty()) {
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
        StringBuilder sb = new StringBuilder();
        String m2003f = m2003f(str.trim().toLowerCase(Locale.ENGLISH));
        Iterator it2 = linkedList.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            String lowerCase = ((String) it2.next()).toLowerCase(Locale.ENGLISH);
            sb.append(" <");
            sb.append(lowerCase);
            sb.append('>');
            if (it2.hasNext()) {
                sb.append(" OR");
            }
            String[] split = lowerCase.split("\\.");
            if (split.length >= 3 && split[0].endsWith(AbstractC5756f.f23062a) && mo2002b(lowerCase) && !m2004e(str)) {
                String str3 = split[0];
                if (str3.length() > 1) {
                    String substring = str3.substring(0, str3.length() - 1);
                    z2 = m2003f.startsWith(substring) && m2003f.substring(substring.length()).endsWith(lowerCase.substring(str3.length()));
                } else {
                    z2 = m2003f.endsWith(lowerCase.substring(1));
                }
                if (z2 && z) {
                    if (m2005d(m2003f) == m2005d(lowerCase)) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                }
            } else {
                z2 = m2003f.equals(m2003f(lowerCase));
                continue;
            }
            if (z2) {
                break;
            }
        }
        if (z2) {
            return;
        }
        throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) sb));
    }

    /* renamed from: b */
    boolean mo2002b(String str) {
        String[] split = str.split("\\.");
        return (split.length == 3 && split[2].length() == 2 && Arrays.binarySearch(f21732a, split[1]) >= 0) ? false : true;
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, X509Certificate x509Certificate) {
        verify(str, m2009a(x509Certificate), m2008a(x509Certificate, str));
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier
    public final void verify(String str, SSLSocket sSLSocket) {
        if (str == null) {
            throw new NullPointerException("host to verify is null");
        }
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            sSLSocket.getInputStream().available();
            session = sSLSocket.getSession();
            if (session == null) {
                sSLSocket.startHandshake();
                session = sSLSocket.getSession();
            }
        }
        verify(str, (X509Certificate) session.getPeerCertificates()[0]);
    }

    @Override // org.apache.http.conn.ssl.X509HostnameVerifier, javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            verify(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
            return true;
        } catch (SSLException e) {
            return false;
        }
    }
}
