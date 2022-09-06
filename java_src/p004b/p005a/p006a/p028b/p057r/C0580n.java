package p004b.p005a.p006a.p028b.p057r;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: b.a.a.b.r.n */
/* loaded from: classes.dex */
public class C0580n {

    /* renamed from: a */
    static final long f1286a = 1024;

    /* renamed from: b */
    static final long f1287b = 1048576;

    /* renamed from: c */
    static final long f1288c = 1073741824;

    /* renamed from: e */
    private static final String f1289e = "([0-9]+)";

    /* renamed from: f */
    private static final int f1290f = 1;

    /* renamed from: g */
    private static final String f1291g = "(|kb|mb|gb)s?";

    /* renamed from: h */
    private static final int f1292h = 2;

    /* renamed from: i */
    private static final Pattern f1293i = Pattern.compile("([0-9]+)\\s*(|kb|mb|gb)s?", 2);

    /* renamed from: d */
    final long f1294d;

    C0580n(long j) {
        this.f1294d = j;
    }

    /* renamed from: a */
    public static C0580n m20091a(String str) {
        long j;
        Matcher matcher = f1293i.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            long longValue = Long.valueOf(group).longValue();
            if (group2.equalsIgnoreCase("")) {
                j = 1;
            } else if (group2.equalsIgnoreCase("kb")) {
                j = 1024;
            } else if (group2.equalsIgnoreCase("mb")) {
                j = f1287b;
            } else if (!group2.equalsIgnoreCase("gb")) {
                throw new IllegalStateException("Unexpected " + group2);
            } else {
                j = 1073741824;
            }
            return new C0580n(j * longValue);
        }
        throw new IllegalArgumentException("String value [" + str + "] is not in the expected format.");
    }

    /* renamed from: a */
    public long m20092a() {
        return this.f1294d;
    }
}
