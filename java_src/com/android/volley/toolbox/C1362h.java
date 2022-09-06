package com.android.volley.toolbox;

import com.android.volley.AbstractC1317b;
import com.android.volley.C1329j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.p248a.p249a.C5083e;
/* renamed from: com.android.volley.toolbox.h */
/* loaded from: classes.dex */
public class C1362h {
    /* renamed from: a */
    public static long m16635a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }

    /* renamed from: a */
    public static AbstractC1317b.C1318a m16636a(C1329j c1329j) {
        boolean z;
        boolean z2;
        long j;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = c1329j.f4567c;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = map.get("Date");
        if (str != null) {
            j3 = m16635a(str);
        }
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            String[] split = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            z = false;
            long j6 = 0;
            long j7 = 0;
            for (String str3 : split) {
                String trim = str3.trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j7 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
            }
            j4 = j7;
            j5 = j6;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        String str4 = map.get("Expires");
        long m16635a = str4 != null ? m16635a(str4) : 0L;
        String str5 = map.get("Last-Modified");
        long m16635a2 = str5 != null ? m16635a(str5) : 0L;
        String str6 = map.get(C5083e.f21687v);
        if (z2) {
            j2 = currentTimeMillis + (1000 * j4);
            j = z ? j2 : (1000 * j5) + j2;
        } else if (j3 <= 0 || m16635a < j3) {
            j = 0;
            j2 = 0;
        } else {
            j = (m16635a - j3) + currentTimeMillis;
            j2 = j;
        }
        AbstractC1317b.C1318a c1318a = new AbstractC1317b.C1318a();
        c1318a.f4530a = c1329j.f4566b;
        c1318a.f4531b = str6;
        c1318a.f4535f = j2;
        c1318a.f4534e = j;
        c1318a.f4532c = j3;
        c1318a.f4533d = m16635a2;
        c1318a.f4536g = map;
        return c1318a;
    }

    /* renamed from: a */
    public static String m16634a(Map<String, String> map) {
        return m16633a(map, "ISO-8859-1");
    }

    /* renamed from: a */
    public static String m16633a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
            return str;
        }
        return str;
    }
}
