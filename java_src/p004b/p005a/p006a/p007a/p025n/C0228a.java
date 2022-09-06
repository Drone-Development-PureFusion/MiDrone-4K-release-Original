package p004b.p005a.p006a.p007a.p025n;

import java.util.List;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: b.a.a.a.n.a */
/* loaded from: classes.dex */
public class C0228a {

    /* renamed from: a */
    public static final String f351a = "?";

    /* renamed from: b */
    public static final int f352b = -1;

    /* renamed from: c */
    public static final String f353c = "?#?:?" + C0359h.f706c;

    /* renamed from: d */
    public static final StackTraceElement[] f354d = new StackTraceElement[0];

    /* renamed from: e */
    private static final String f355e = "org.apache.log4j.Category";

    /* renamed from: f */
    private static final String f356f = "org.slf4j.Logger";

    /* renamed from: a */
    public static StackTraceElement m21260a() {
        return new StackTraceElement(f351a, f351a, f351a, -1);
    }

    /* renamed from: a */
    static boolean m21259a(String str, String str2, List<String> list) {
        return str.equals(str2) || str.equals(f355e) || str.startsWith(f356f) || m21258a(str, list);
    }

    /* renamed from: a */
    private static boolean m21258a(String str, List<String> list) {
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static StackTraceElement[] m21257a(Throwable th, String str, int i, List<String> list) {
        if (th == null) {
            return null;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int i2 = -1;
        for (int i3 = 0; i3 < stackTrace.length; i3++) {
            if (m21259a(stackTrace[i3].getClassName(), str, list)) {
                i2 = i3 + 1;
            } else if (i2 != -1) {
                break;
            }
        }
        if (i2 == -1) {
            return f354d;
        }
        int length = stackTrace.length - i2;
        if (i >= length) {
            i = length;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i];
        for (int i4 = 0; i4 < i; i4++) {
            stackTraceElementArr[i4] = stackTrace[i2 + i4];
        }
        return stackTraceElementArr;
    }
}
