package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.C1036gn;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
/* renamed from: com.amap.api.mapcore.util.gs */
/* loaded from: classes.dex */
public class C1045gs {
    /* renamed from: a */
    public static int m17832a(String str, String str2) {
        int i = 0;
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            for (int i2 = 0; i2 < min; i2++) {
                i = split[i2].length() - split2[i2].length();
                if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                    break;
                }
            }
            return i != 0 ? i : split.length - split2.length;
        } catch (Exception e) {
            C1002fl.m18028a(e, "Utils", "compareVersion");
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static PublicKey m17836a() {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(C0991fd.m18099b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream)).getPublicKey();
                try {
                    return publicKey;
                } catch (Throwable th) {
                    return publicKey;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    m17831a(th, "DyLoader", "init");
                    try {
                        m17833a(byteArrayInputStream);
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                    return null;
                } finally {
                    try {
                        m17833a(byteArrayInputStream);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17833a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17831a(Throwable th, String str, String str2) {
        C1002fl.m18028a(th, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m17830a(List<C1043gr> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size() - 1) {
                int i3 = i2 + 1;
                while (true) {
                    int i4 = i3;
                    if (i4 < list.size()) {
                        C1043gr c1043gr = list.get(i2);
                        C1043gr c1043gr2 = list.get(i4);
                        if (m17832a(c1043gr2.m17846e(), c1043gr.m17846e()) > 0) {
                            list.set(i2, c1043gr2);
                            list.set(i4, c1043gr);
                        }
                        i3 = i4 + 1;
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m17835a(Context context, C1016fu c1016fu, String str, C0996fh c0996fh) {
        return m17834a(c1016fu, str, C1036gn.m17887a(context, str), c0996fh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m17834a(C1016fu c1016fu, String str, String str2, C0996fh c0996fh) {
        C1043gr m17877a = C1036gn.C1038a.m17877a(c1016fu, str);
        return m17877a != null && c0996fh.m18070b().equals(m17877a.m17847d()) && m17829b(str2, m17877a.m17852b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m17829b(String str, String str2) {
        String m18095a = C0992fe.m18095a(str);
        return m18095a != null && m18095a.equalsIgnoreCase(str2);
    }
}
