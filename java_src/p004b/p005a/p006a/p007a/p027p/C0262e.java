package p004b.p005a.p006a.p007a.p027p;

import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
/* renamed from: b.a.a.a.p.e */
/* loaded from: classes.dex */
public class C0262e {
    /* renamed from: a */
    public static int m21111a(AbstractC0231d abstractC0231d) {
        C0146d mo21220b = abstractC0231d.mo21220b();
        switch (mo21220b.f208v) {
            case 5000:
            case 10000:
                return 7;
            case 20000:
                return 6;
            case 30000:
                return 4;
            case C0146d.f188b /* 40000 */:
                return 3;
            default:
                throw new IllegalArgumentException("Level " + mo21220b + " is not a valid level for a printing method");
        }
    }
}
