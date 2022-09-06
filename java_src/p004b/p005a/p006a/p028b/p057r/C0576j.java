package p004b.p005a.p006a.p028b.p057r;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: b.a.a.b.r.j */
/* loaded from: classes.dex */
public class C0576j {

    /* renamed from: a */
    static final long f1276a = 1000;

    /* renamed from: b */
    static final long f1277b = 60000;

    /* renamed from: c */
    static final long f1278c = 3600000;

    /* renamed from: d */
    static final long f1279d = 86400000;

    /* renamed from: f */
    private static final String f1280f = "([0-9]*(.[0-9]+)?)";

    /* renamed from: g */
    private static final int f1281g = 1;

    /* renamed from: h */
    private static final String f1282h = "(|milli(second)?|second(e)?|minute|hour|day)s?";

    /* renamed from: i */
    private static final int f1283i = 3;

    /* renamed from: j */
    private static final Pattern f1284j = Pattern.compile("([0-9]*(.[0-9]+)?)\\s*(|milli(second)?|second(e)?|minute|hour|day)s?", 2);

    /* renamed from: e */
    final long f1285e;

    public C0576j(long j) {
        this.f1285e = j;
    }

    /* renamed from: a */
    public static C0576j m20108a() {
        return new C0576j(Long.MAX_VALUE);
    }

    /* renamed from: a */
    public static C0576j m20107a(double d) {
        return new C0576j((long) d);
    }

    /* renamed from: a */
    public static C0576j m20106a(String str) {
        Matcher matcher = f1284j.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(3);
            double doubleValue = Double.valueOf(group).doubleValue();
            if (group2.equalsIgnoreCase("milli") || group2.equalsIgnoreCase("millisecond") || group2.length() == 0) {
                return m20107a(doubleValue);
            }
            if (group2.equalsIgnoreCase("second") || group2.equalsIgnoreCase("seconde")) {
                return m20104b(doubleValue);
            }
            if (group2.equalsIgnoreCase("minute")) {
                return m20103c(doubleValue);
            }
            if (group2.equalsIgnoreCase("hour")) {
                return m20102d(doubleValue);
            }
            if (!group2.equalsIgnoreCase("day")) {
                throw new IllegalStateException("Unexpected " + group2);
            }
            return m20101e(doubleValue);
        }
        throw new IllegalArgumentException("String value [" + str + "] is not in the expected format.");
    }

    /* renamed from: b */
    public static C0576j m20104b(double d) {
        return new C0576j((long) (1000.0d * d));
    }

    /* renamed from: c */
    public static C0576j m20103c(double d) {
        return new C0576j((long) (60000.0d * d));
    }

    /* renamed from: d */
    public static C0576j m20102d(double d) {
        return new C0576j((long) (3600000.0d * d));
    }

    /* renamed from: e */
    public static C0576j m20101e(double d) {
        return new C0576j((long) (8.64E7d * d));
    }

    /* renamed from: b */
    public long m20105b() {
        return this.f1285e;
    }

    public String toString() {
        return this.f1285e < 1000 ? this.f1285e + " milliseconds" : this.f1285e < 60000 ? (this.f1285e / 1000) + " seconds" : this.f1285e < 3600000 ? (this.f1285e / 60000) + " minutes" : (this.f1285e / 3600000) + " hours";
    }
}
