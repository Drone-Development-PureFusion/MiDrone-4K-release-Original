package p004b.p005a.p006a.p007a.p008a;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import p004b.p005a.p006a.p028b.AbstractC0292f;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p029a.AbstractC0267a;
import p004b.p005a.p006a.p028b.p055p.AbstractC0551k;
import p004b.p005a.p006a.p028b.p055p.C0553m;
import p004b.p005a.p006a.p028b.p057r.C0585s;
/* renamed from: b.a.a.a.a.b */
/* loaded from: classes.dex */
public class C0131b {
    /* renamed from: a */
    public static void m21528a(AbstractC0292f abstractC0292f) {
        C0129a c0129a = new C0129a();
        c0129a.m21539a(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        c0129a.m21541a("manifest");
        AbstractC0551k mo20997n = abstractC0292f.mo20997n();
        InputStream resourceAsStream = C0585s.m20080a(abstractC0292f).getResourceAsStream("AndroidManifest.xml");
        if (resourceAsStream == null) {
            mo20997n.mo20188a(new C0553m("Could not find AndroidManifest.xml", abstractC0292f));
            return;
        }
        try {
            c0129a.a(resourceAsStream);
            abstractC0292f.mo21001a(C0359h.f688R, AbstractC0267a.m21099a());
            Map<String, String> m21542a = c0129a.m21542a();
            for (String str : m21542a.keySet()) {
                if (str.equals("android:versionName")) {
                    abstractC0292f.mo21001a(C0359h.f690T, m21542a.get(str));
                } else if (str.equals("android:versionCode")) {
                    abstractC0292f.mo21001a(C0359h.f691U, m21542a.get(str));
                } else if (str.equals("package")) {
                    abstractC0292f.mo21001a(C0359h.f689S, m21542a.get(str));
                }
            }
            String str2 = m21542a.get("package");
            if (str2 == null || str2.length() <= 0) {
                mo20997n.mo20188a(new C0553m("Package name not found. Some properties cannot be set.", abstractC0292f));
            } else {
                abstractC0292f.mo21001a(C0359h.f687Q, AbstractC0267a.m21098a(str2));
            }
        } finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
            }
        }
    }
}
