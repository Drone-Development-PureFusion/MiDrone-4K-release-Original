package org.p248a.p249a.p261f.p265d;

import java.util.regex.Pattern;
import org.p248a.p249a.p250a.AbstractC5005b;
@AbstractC5005b
/* renamed from: org.a.a.f.d.a */
/* loaded from: classes2.dex */
public class C5126a {

    /* renamed from: a */
    private static final String f21768a = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";

    /* renamed from: b */
    private static final Pattern f21769b = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    /* renamed from: c */
    private static final Pattern f21770c = Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");

    /* renamed from: d */
    private static final Pattern f21771d = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");

    /* renamed from: e */
    private static final Pattern f21772e = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");

    /* renamed from: f */
    private static final char f21773f = ':';

    /* renamed from: g */
    private static final int f21774g = 7;

    private C5126a() {
    }

    /* renamed from: a */
    public static boolean m1963a(String str) {
        return f21769b.matcher(str).matches();
    }

    /* renamed from: b */
    public static boolean m1962b(String str) {
        return f21770c.matcher(str).matches();
    }

    /* renamed from: c */
    public static boolean m1961c(String str) {
        return f21771d.matcher(str).matches();
    }

    /* renamed from: d */
    public static boolean m1960d(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == ':') {
                i++;
            }
        }
        return i <= 7 && f21772e.matcher(str).matches();
    }

    /* renamed from: e */
    public static boolean m1959e(String str) {
        return m1961c(str) || m1960d(str);
    }
}
