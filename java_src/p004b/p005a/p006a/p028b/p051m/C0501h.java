package p004b.p005a.p006a.p028b.p051m;

import com.fimi.soul.media.player.FimiMediaMeta;
import java.io.File;
import p004b.p005a.p006a.p028b.p057r.C0580n;
import p004b.p005a.p006a.p028b.p057r.C0584r;
/* renamed from: b.a.a.b.m.h */
/* loaded from: classes.dex */
public class C0501h<E> extends AbstractC0506m<E> {

    /* renamed from: a */
    public static final String f1122a = "http://logback.qos.ch/codes.html#sbtp_size_format";

    /* renamed from: b */
    public static final long f1123b = 10485760;

    /* renamed from: d */
    C0580n f1125d;

    /* renamed from: c */
    String f1124c = Long.toString(f1123b);

    /* renamed from: e */
    private C0584r f1126e = new C0584r();

    public C0501h() {
    }

    public C0501h(String str) {
        m20328a(str);
    }

    /* renamed from: a */
    public String m20329a() {
        return this.f1124c;
    }

    /* renamed from: a */
    public void m20328a(String str) {
        this.f1124c = str;
        this.f1125d = C0580n.m20091a(str);
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0505l
    /* renamed from: a */
    public boolean mo20305a(File file, E e) {
        if (this.f1126e.m20084a()) {
            return false;
        }
        this.f1126e.m20083a(System.currentTimeMillis());
        return file.length() >= this.f1125d.m20092a();
    }

    /* renamed from: b */
    long m20327b(String str) {
        if (str == null) {
            return f1123b;
        }
        String upperCase = str.trim().toUpperCase();
        long j = 1;
        int indexOf = upperCase.indexOf("KB");
        if (indexOf != -1) {
            j = FimiMediaMeta.AV_CH_SIDE_RIGHT;
            upperCase = upperCase.substring(0, indexOf);
        } else {
            int indexOf2 = upperCase.indexOf("MB");
            if (indexOf2 != -1) {
                j = 1048576;
                upperCase = upperCase.substring(0, indexOf2);
            } else {
                int indexOf3 = upperCase.indexOf("GB");
                if (indexOf3 != -1) {
                    j = FimiMediaMeta.AV_CH_STEREO_RIGHT;
                    upperCase = upperCase.substring(0, indexOf3);
                }
            }
        }
        if (upperCase == null) {
            return f1123b;
        }
        try {
            return Long.valueOf(upperCase).longValue() * j;
        } catch (NumberFormatException e) {
            c("[" + upperCase + "] is not in proper int format. Please refer to " + f1122a);
            a("[" + str + "] not in expected format.", e);
            return f1123b;
        }
    }
}
