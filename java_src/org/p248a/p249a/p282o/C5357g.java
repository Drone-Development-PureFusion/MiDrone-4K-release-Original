package org.p248a.p249a.p282o;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import org.apache.http.util.VersionInfo;
import p004b.p005a.p006a.p028b.C0359h;
/* renamed from: org.a.a.o.g */
/* loaded from: classes2.dex */
public class C5357g {

    /* renamed from: a */
    public static final String f22396a = "UNAVAILABLE";

    /* renamed from: b */
    public static final String f22397b = "version.properties";

    /* renamed from: c */
    public static final String f22398c = "info.module";

    /* renamed from: d */
    public static final String f22399d = "info.release";

    /* renamed from: e */
    public static final String f22400e = "info.timestamp";

    /* renamed from: f */
    private final String f22401f;

    /* renamed from: g */
    private final String f22402g;

    /* renamed from: h */
    private final String f22403h;

    /* renamed from: i */
    private final String f22404i;

    /* renamed from: j */
    private final String f22405j;

    protected C5357g(String str, String str2, String str3, String str4, String str5) {
        C5351a.m1321a(str, "Package identifier");
        this.f22401f = str;
        this.f22402g = str2 == null ? f22396a : str2;
        this.f22403h = str3 == null ? f22396a : str3;
        this.f22404i = str4 == null ? f22396a : str4;
        this.f22405j = str5 == null ? f22396a : str5;
    }

    /* renamed from: a */
    public static String m1293a(String str, String str2, Class<?> cls) {
        C5357g m1294a = m1294a(str2, cls.getClassLoader());
        return str + "/" + (m1294a != null ? m1294a.m1289c() : f22396a) + " (Java 1.5 minimum; Java/" + System.getProperty("java.version") + ")";
    }

    /* renamed from: a */
    public static C5357g m1294a(String str, ClassLoader classLoader) {
        Properties properties;
        C5351a.m1321a(str, "Package identifier");
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(str.replace(C0359h.f677G, '/') + "/" + f22397b);
            if (resourceAsStream != null) {
                properties = new Properties();
                properties.load(resourceAsStream);
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                }
            } else {
                properties = null;
            }
        } catch (IOException e2) {
            properties = null;
        }
        if (properties != null) {
            return m1292a(str, properties, classLoader);
        }
        return null;
    }

    /* renamed from: a */
    protected static C5357g m1292a(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        C5351a.m1321a(str, "Package identifier");
        if (map != null) {
            String str6 = (String) map.get(f22398c);
            String str7 = (str6 == null || str6.length() >= 1) ? str6 : null;
            String str8 = (String) map.get(f22399d);
            String str9 = (str8 == null || (str8.length() >= 1 && !str8.equals("${pom.version}"))) ? str8 : null;
            String str10 = (String) map.get(f22400e);
            if (str10 == null || (str10.length() >= 1 && !str10.equals("${mvn.timestamp}"))) {
                str2 = str10;
                str3 = str9;
                str4 = str7;
            } else {
                str2 = null;
                str3 = str9;
                str4 = str7;
            }
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        if (classLoader != null) {
            str5 = classLoader.toString();
        }
        return new C5357g(str, str4, str3, str2, str5);
    }

    /* renamed from: a */
    public static VersionInfo[] m1291a(String[] strArr, ClassLoader classLoader) {
        C5351a.m1321a(strArr, "Package identifier array");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            C5357g m1294a = m1294a(str, classLoader);
            if (m1294a != null) {
                arrayList.add(m1294a);
            }
        }
        return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
    }

    /* renamed from: a */
    public final String m1295a() {
        return this.f22401f;
    }

    /* renamed from: b */
    public final String m1290b() {
        return this.f22402g;
    }

    /* renamed from: c */
    public final String m1289c() {
        return this.f22403h;
    }

    /* renamed from: d */
    public final String m1288d() {
        return this.f22404i;
    }

    /* renamed from: e */
    public final String m1287e() {
        return this.f22405j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f22401f.length() + 20 + this.f22402g.length() + this.f22403h.length() + this.f22404i.length() + this.f22405j.length());
        sb.append("VersionInfo(").append(this.f22401f).append(C0359h.f671A).append(this.f22402g);
        if (!f22396a.equals(this.f22403h)) {
            sb.append(C0359h.f671A).append(this.f22403h);
        }
        if (!f22396a.equals(this.f22404i)) {
            sb.append(C0359h.f671A).append(this.f22404i);
        }
        sb.append(C0359h.f723t);
        if (!f22396a.equals(this.f22405j)) {
            sb.append('@').append(this.f22405j);
        }
        return sb.toString();
    }
}
