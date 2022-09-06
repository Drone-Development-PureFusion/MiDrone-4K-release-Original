package org.p248a.p283b.p285b;

import org.p248a.p283b.C5389f;
/* renamed from: org.a.b.b.h */
/* loaded from: classes2.dex */
public class C5376h {

    /* renamed from: a */
    private static int f22446a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m1228a(AbstractC5373e abstractC5373e, byte b) {
        m1227a(abstractC5373e, b, f22446a);
    }

    /* renamed from: a */
    public static void m1227a(AbstractC5373e abstractC5373e, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new C5389f("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                abstractC5373e.mo1235q();
                return;
            case 3:
                abstractC5373e.mo1234r();
                return;
            case 4:
                abstractC5373e.mo1230v();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                abstractC5373e.mo1233s();
                return;
            case 8:
                abstractC5373e.mo1232t();
                return;
            case 10:
                abstractC5373e.mo1231u();
                return;
            case 11:
                abstractC5373e.mo1222x();
                return;
            case 12:
                abstractC5373e.mo1242g();
                while (true) {
                    C5370b mo1240i = abstractC5373e.mo1240i();
                    if (mo1240i.f22437b == 0) {
                        abstractC5373e.mo1241h();
                        return;
                    } else {
                        m1227a(abstractC5373e, mo1240i.f22437b, i - 1);
                        abstractC5373e.mo1239j();
                    }
                }
            case 13:
                C5372d mo1226k = abstractC5373e.mo1226k();
                while (i2 < mo1226k.f22443c) {
                    m1227a(abstractC5373e, mo1226k.f22441a, i - 1);
                    m1227a(abstractC5373e, mo1226k.f22442b, i - 1);
                    i2++;
                }
                abstractC5373e.mo1238l();
                return;
            case 14:
                C5377i mo1224o = abstractC5373e.mo1224o();
                while (i2 < mo1224o.f22448b) {
                    m1227a(abstractC5373e, mo1224o.f22447a, i - 1);
                    i2++;
                }
                abstractC5373e.mo1236p();
                return;
            case 15:
                C5371c mo1225m = abstractC5373e.mo1225m();
                while (i2 < mo1225m.f22440b) {
                    m1227a(abstractC5373e, mo1225m.f22439a, i - 1);
                    i2++;
                }
                abstractC5373e.mo1237n();
                return;
        }
    }
}
