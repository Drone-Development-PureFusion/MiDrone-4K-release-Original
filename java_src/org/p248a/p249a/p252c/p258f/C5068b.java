package org.p248a.p249a.p252c.p258f;

import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.p248a.p249a.p250a.AbstractC5005b;
import org.p248a.p249a.p282o.C5351a;
@AbstractC5005b
/* renamed from: org.a.a.c.f.b */
/* loaded from: classes2.dex */
public final class C5068b {

    /* renamed from: f */
    private static final Date f21591f;

    /* renamed from: a */
    public static final String f21586a = "EEE, dd MMM yyyy HH:mm:ss zzz";

    /* renamed from: b */
    public static final String f21587b = "EEE, dd-MMM-yy HH:mm:ss zzz";

    /* renamed from: c */
    public static final String f21588c = "EEE MMM d HH:mm:ss yyyy";

    /* renamed from: e */
    private static final String[] f21590e = {f21586a, f21587b, f21588c};

    /* renamed from: d */
    public static final TimeZone f21589d = TimeZone.getTimeZone("GMT");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.a.a.c.f.b$a */
    /* loaded from: classes2.dex */
    public static final class C5069a {

        /* renamed from: a */
        private static final ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>> f21592a = new ThreadLocal<SoftReference<Map<String, SimpleDateFormat>>>() { // from class: org.a.a.c.f.b.a.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public SoftReference<Map<String, SimpleDateFormat>> initialValue() {
                return new SoftReference<>(new HashMap());
            }
        };

        C5069a() {
        }

        /* renamed from: a */
        public static SimpleDateFormat m2148a(String str) {
            HashMap hashMap;
            Map<String, SimpleDateFormat> map = f21592a.get().get();
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                f21592a.set(new SoftReference<>(hashMap2));
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            SimpleDateFormat simpleDateFormat = hashMap.get(str);
            if (simpleDateFormat == null) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.US);
                simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
                hashMap.put(str, simpleDateFormat2);
                return simpleDateFormat2;
            }
            return simpleDateFormat;
        }

        /* renamed from: a */
        public static void m2149a() {
            f21592a.remove();
        }
    }

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(f21589d);
        calendar.set(2000, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        f21591f = calendar.getTime();
    }

    private C5068b() {
    }

    /* renamed from: a */
    public static String m2151a(Date date) {
        return m2150a(date, f21586a);
    }

    /* renamed from: a */
    public static String m2150a(Date date, String str) {
        C5351a.m1321a(date, "Date");
        C5351a.m1321a(str, "Pattern");
        return C5069a.m2148a(str).format(date);
    }

    /* renamed from: a */
    public static Date m2154a(String str) {
        return m2152a(str, null, null);
    }

    /* renamed from: a */
    public static Date m2153a(String str, String[] strArr) {
        return m2152a(str, strArr, null);
    }

    /* renamed from: a */
    public static Date m2152a(String str, String[] strArr, Date date) {
        C5351a.m1321a(str, "Date value");
        if (strArr == null) {
            strArr = f21590e;
        }
        if (date == null) {
            date = f21591f;
        }
        if (str.length() > 1 && str.startsWith("'") && str.endsWith("'")) {
            str = str.substring(1, str.length() - 1);
        }
        for (String str2 : strArr) {
            SimpleDateFormat m2148a = C5069a.m2148a(str2);
            m2148a.set2DigitYearStart(date);
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = m2148a.parse(str, parsePosition);
            if (parsePosition.getIndex() != 0) {
                return parse;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m2155a() {
        C5069a.m2149a();
    }
}
