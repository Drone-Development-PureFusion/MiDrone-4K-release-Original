package p004b.p005a.p006a.p028b.p044i;
/* renamed from: b.a.a.b.i.m */
/* loaded from: classes.dex */
public class C0458m {

    /* renamed from: a */
    static final String[] f1014a = {" ", "  ", "    ", "        ", "                ", "                                "};

    /* renamed from: a */
    public static final void m20458a(StringBuilder sb, int i) {
        while (i >= 32) {
            sb.append(f1014a[5]);
            i -= 32;
        }
        for (int i2 = 4; i2 >= 0; i2--) {
            if (((1 << i2) & i) != 0) {
                sb.append(f1014a[i2]);
            }
        }
    }

    /* renamed from: a */
    public static final void m20457a(StringBuilder sb, String str, int i) {
        int i2 = 0;
        if (str != null) {
            i2 = str.length();
        }
        if (i2 < i) {
            m20458a(sb, i - i2);
        }
        if (str != null) {
            sb.append(str);
        }
    }

    /* renamed from: b */
    public static final void m20456b(StringBuilder sb, String str, int i) {
        int i2 = 0;
        if (str != null) {
            i2 = str.length();
        }
        if (str != null) {
            sb.append(str);
        }
        if (i2 < i) {
            m20458a(sb, i - i2);
        }
    }
}
