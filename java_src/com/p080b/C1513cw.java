package com.p080b;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.CellLocation;
import java.util.List;
/* renamed from: com.b.cw */
/* loaded from: classes.dex */
public final class C1513cw {

    /* renamed from: c */
    private static int f5400c = 10;

    /* renamed from: d */
    private static int f5401d = 100;

    /* renamed from: f */
    private static float f5402f = 0.5f;

    /* renamed from: a */
    protected C1519db f5403a = new C1519db(this);

    /* renamed from: b */
    protected C1515cy f5404b = new C1515cy(this);

    /* renamed from: e */
    private C1499ci f5405e;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1513cw(C1499ci c1499ci) {
        this.f5405e = c1499ci;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m15738a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m15737a(int i) {
        f5400c = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public static void m15735b(int i) {
        f5401d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m15736a(Location location) {
        List m15775j;
        boolean z = false;
        if (this.f5405e != null && (m15775j = this.f5405e.m15775j()) != null && location != null) {
            String str = "cell.list.size: " + m15775j.size();
            C1516cz c1516cz = null;
            if (m15775j.size() >= 2) {
                C1516cz c1516cz2 = new C1516cz((CellLocation) m15775j.get(1));
                if (this.f5404b.f5427b == null) {
                    c1516cz = c1516cz2;
                    z = true;
                } else {
                    boolean z2 = location.distanceTo(this.f5404b.f5427b) > ((float) f5401d);
                    if (!z2) {
                        C1516cz c1516cz3 = this.f5404b.f5426a;
                        z2 = !(c1516cz2.f5432e == c1516cz3.f5432e && c1516cz2.f5431d == c1516cz3.f5431d && c1516cz2.f5430c == c1516cz3.f5430c && c1516cz2.f5429b == c1516cz3.f5429b && c1516cz2.f5428a == c1516cz3.f5428a);
                    }
                    String str2 = "collect cell?: " + z2;
                    z = z2;
                    c1516cz = c1516cz2;
                }
            }
            if (z) {
                this.f5404b.f5426a = c1516cz;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean m15734b(Location location) {
        List list;
        boolean z;
        boolean z2;
        int i;
        if (this.f5405e == null) {
            return false;
        }
        List m15813a = this.f5405e.m15813a(false);
        if (m15813a.size() >= 2) {
            List list2 = (List) m15813a.get(1);
            if (this.f5403a.f5440b == null) {
                z = true;
            } else if (list2 == null || list2.size() <= 0) {
                list = list2;
                z = false;
            } else {
                z = location.distanceTo(this.f5403a.f5440b) > ((float) f5400c);
                if (!z) {
                    List list3 = this.f5403a.f5439a;
                    float f = f5402f;
                    if (list2 == null || list3 == null) {
                        z2 = false;
                    } else if (list2 == null || list3 == null) {
                        z2 = false;
                    } else {
                        int size = list2.size();
                        int size2 = list3.size();
                        float f2 = size + size2;
                        if (size == 0 && size2 == 0) {
                            z2 = true;
                        } else if (size == 0 || size2 == 0) {
                            z2 = false;
                        } else {
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < size) {
                                String str = ((ScanResult) list2.get(i2)).BSSID;
                                if (str != null) {
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        if (str.equals(((C1518da) list3.get(i4)).f5438a)) {
                                            i = i3 + 1;
                                            break;
                                        }
                                    }
                                }
                                i = i3;
                                i2++;
                                i3 = i;
                            }
                            z2 = ((float) (i3 << 1)) >= f2 * f;
                        }
                    }
                    z = !z2;
                } else {
                    list = list2;
                }
            }
            list = list2;
        } else {
            list = null;
            z = false;
        }
        if (z) {
            this.f5403a.f5439a.clear();
            int size3 = list.size();
            for (int i5 = 0; i5 < size3; i5++) {
                this.f5403a.f5439a.add(new C1518da(((ScanResult) list.get(i5)).BSSID));
            }
        }
        return z;
    }
}
