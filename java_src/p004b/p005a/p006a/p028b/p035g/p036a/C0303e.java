package p004b.p005a.p006a.p028b.p035g.p036a;

import java.util.Properties;
import p004b.p005a.p006a.p028b.p035g.p039d.C0344k;
import p004b.p005a.p006a.p028b.p057r.C0573g;
import p004b.p005a.p006a.p028b.p057r.C0589u;
/* renamed from: b.a.a.b.g.a.e */
/* loaded from: classes.dex */
public class C0303e {

    /* renamed from: b.a.a.b.g.a.e$a */
    /* loaded from: classes.dex */
    public enum EnumC0305a {
        LOCAL,
        CONTEXT,
        SYSTEM
    }

    /* renamed from: a */
    public static EnumC0305a m20964a(String str) {
        return EnumC0305a.SYSTEM.toString().equalsIgnoreCase(str) ? EnumC0305a.SYSTEM : EnumC0305a.CONTEXT.toString().equalsIgnoreCase(str) ? EnumC0305a.CONTEXT : EnumC0305a.LOCAL;
    }

    /* renamed from: a */
    public static void m20966a(C0344k c0344k, String str, String str2, EnumC0305a enumC0305a) {
        switch (enumC0305a) {
            case LOCAL:
                c0344k.m20880a(str, str2);
                return;
            case CONTEXT:
                c0344k.h_().mo21001a(str, str2);
                return;
            case SYSTEM:
                C0589u.m20069a(c0344k, str, str2);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static void m20965a(C0344k c0344k, Properties properties, EnumC0305a enumC0305a) {
        switch (enumC0305a) {
            case LOCAL:
                c0344k.m20878a(properties);
                return;
            case CONTEXT:
                new C0573g(c0344k.h_()).m20111a(properties);
                return;
            case SYSTEM:
                C0589u.m20068a(c0344k, properties);
                return;
            default:
                return;
        }
    }
}
