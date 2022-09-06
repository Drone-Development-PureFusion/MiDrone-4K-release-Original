package p004b.p005a.p006a.p028b.p057r;

import java.util.ArrayList;
/* renamed from: b.a.a.b.r.l */
/* loaded from: classes.dex */
public class C0578l {
    /* renamed from: a */
    public static boolean m20100a() {
        String m20056c = C0589u.m20056c("os.name");
        String m20067a = C0589u.m20067a("ANDROID_ROOT");
        String m20067a2 = C0589u.m20067a("ANDROID_DATA");
        return m20056c != null && m20056c.contains("Linux") && m20067a != null && m20067a.contains("/system") && m20067a2 != null && m20067a2.contains("/data");
    }

    /* renamed from: a */
    private static boolean m20099a(int i) {
        ArrayList<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            arrayList.add("1." + (i + i2));
        }
        String property = System.getProperty("java.version");
        if (property == null) {
            return false;
        }
        for (String str : arrayList) {
            if (property.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m20098b() {
        return m20099a(5);
    }

    /* renamed from: c */
    public static boolean m20097c() {
        return m20099a(6);
    }

    /* renamed from: d */
    public static boolean m20096d() {
        return m20099a(7);
    }

    /* renamed from: e */
    public static boolean m20095e() {
        return System.getProperty("os.name").startsWith("Windows");
    }
}
