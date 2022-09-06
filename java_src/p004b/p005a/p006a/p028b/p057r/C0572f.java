package p004b.p005a.p006a.p028b.p057r;
/* renamed from: b.a.a.b.r.f */
/* loaded from: classes.dex */
public class C0572f {
    /* renamed from: a */
    public static boolean m20114a(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("text");
    }

    /* renamed from: b */
    public static String m20113b(String str) {
        int indexOf;
        int i;
        if (str == null || (indexOf = str.indexOf(47)) == -1 || (i = indexOf + 1) >= str.length()) {
            return null;
        }
        return str.substring(i);
    }
}
