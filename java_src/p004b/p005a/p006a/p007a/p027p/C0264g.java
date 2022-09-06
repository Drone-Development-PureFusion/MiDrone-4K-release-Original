package p004b.p005a.p006a.p007a.p027p;
/* renamed from: b.a.a.a.p.g */
/* loaded from: classes.dex */
public class C0264g {
    /* renamed from: a */
    public static int m21105a(String str) {
        return m21104a(str, 0);
    }

    /* renamed from: a */
    public static int m21104a(String str, int i) {
        int indexOf = str.indexOf(46, i);
        int indexOf2 = str.indexOf(36, i);
        if (indexOf == -1 && indexOf2 == -1) {
            return -1;
        }
        return indexOf == -1 ? indexOf2 : (indexOf2 == -1 || indexOf < indexOf2) ? indexOf : indexOf2;
    }
}
