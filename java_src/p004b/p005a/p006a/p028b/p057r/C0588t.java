package p004b.p005a.p006a.p028b.p057r;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
/* renamed from: b.a.a.b.r.t */
/* loaded from: classes.dex */
public class C0588t {

    /* renamed from: a */
    public static final String f1311a = "^\\p{Alpha}[\\p{Alnum}+.-]*:.*$";

    /* renamed from: b */
    public static final String f1312b = "classpath:";

    /* renamed from: a */
    public static URL m20071a(String str) {
        URL url;
        if (str == null) {
            throw new NullPointerException("location is required");
        }
        if (!str.matches(f1311a)) {
            url = C0585s.m20079a(str);
        } else if (str.startsWith(f1312b)) {
            String substring = str.substring(f1312b.length());
            if (substring.startsWith("/")) {
                substring = substring.substring(1);
            }
            if (substring.length() == 0) {
                throw new MalformedURLException("path is required");
            }
            url = C0585s.m20079a(substring);
        } else {
            url = new URL(str);
        }
        if (url != null) {
            return url;
        }
        throw new FileNotFoundException(str);
    }
}
