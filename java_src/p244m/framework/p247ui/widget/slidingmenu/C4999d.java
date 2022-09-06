package p244m.framework.p247ui.widget.slidingmenu;

import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: m.framework.ui.widget.slidingmenu.d */
/* loaded from: classes2.dex */
final class C4999d {

    /* renamed from: a */
    int f21426a;

    /* renamed from: b */
    String f21427b;

    /* renamed from: c */
    private ArrayList<C5000e> f21428c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m2327a() {
        if (this.f21428c == null) {
            return 0;
        }
        return this.f21428c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C5000e m2326a(int i) {
        if (this.f21428c == null) {
            return null;
        }
        Iterator<C5000e> it2 = this.f21428c.iterator();
        while (it2.hasNext()) {
            C5000e next = it2.next();
            if (next != null && next.f21430b == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2325a(C5000e c5000e) {
        if (c5000e == null) {
            return;
        }
        C5000e m2326a = m2326a(c5000e.f21430b);
        c5000e.f21429a = this.f21426a;
        if (m2326a == null) {
            this.f21428c.add(c5000e);
            return;
        }
        int indexOf = this.f21428c.indexOf(m2326a);
        this.f21428c.remove(indexOf);
        this.f21428c.add(indexOf, c5000e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public C5000e m2324b(int i) {
        return this.f21428c.get(i);
    }
}
