package p004b.p005a.p006a.p028b.p057r;

import java.util.ArrayList;
import java.util.List;
/* renamed from: b.a.a.b.r.h */
/* loaded from: classes.dex */
public class C0574h {

    /* renamed from: a */
    final String f1273a;

    /* renamed from: b */
    final int f1274b;

    /* renamed from: c */
    final C0570d f1275c = new C0570d();

    public C0574h(String str) {
        this.f1273a = str;
        this.f1274b = str.length();
    }

    /* renamed from: b */
    private List<C0569c> m20109b() {
        ArrayList arrayList = new ArrayList();
        C0569c c0569c = null;
        for (int i = 0; i < this.f1274b; i++) {
            char charAt = this.f1273a.charAt(i);
            if (c0569c == null || c0569c.f1271a != charAt) {
                c0569c = new C0569c(charAt);
                arrayList.add(c0569c);
            } else {
                c0569c.m20120a();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public String m20110a() {
        List<C0569c> m20109b = m20109b();
        StringBuilder sb = new StringBuilder();
        for (C0569c c0569c : m20109b) {
            sb.append(this.f1275c.m20118a(c0569c));
        }
        return sb.toString();
    }
}
