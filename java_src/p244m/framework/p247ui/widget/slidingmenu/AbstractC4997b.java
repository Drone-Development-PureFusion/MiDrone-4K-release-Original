package p244m.framework.p247ui.widget.slidingmenu;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: m.framework.ui.widget.slidingmenu.b */
/* loaded from: classes2.dex */
public abstract class AbstractC4997b {

    /* renamed from: a */
    private ArrayList<C4999d> f21413a = new ArrayList<>();

    public AbstractC4997b(SlidingMenu slidingMenu) {
    }

    /* renamed from: c */
    private C4999d m2328c(int i) {
        if (this.f21413a == null) {
            return null;
        }
        Iterator<C4999d> it2 = this.f21413a.iterator();
        while (it2.hasNext()) {
            C4999d next = it2.next();
            if (next != null && next.f21426a == i) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    public View m2342a() {
        return null;
    }

    /* renamed from: a */
    public abstract View m2339a(int i, ViewGroup viewGroup);

    /* renamed from: a */
    public abstract View m2334a(C5000e c5000e, ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C4999d m2341a(int i) {
        return this.f21413a.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C5000e m2340a(int i, int i2) {
        return this.f21413a.get(i).m2324b(i2);
    }

    /* renamed from: a */
    public void m2338a(int i, String str) {
        C4999d m2328c = m2328c(i);
        if (m2328c == null) {
            m2328c = new C4999d();
            m2328c.f21426a = i;
            this.f21413a.add(m2328c);
        }
        m2328c.f21427b = str;
    }

    /* renamed from: a */
    public void m2337a(int i, C5000e c5000e) {
        C4999d m2328c;
        if (c5000e == null || (m2328c = m2328c(i)) == null) {
            return;
        }
        m2328c.m2325a(c5000e);
    }

    /* renamed from: a */
    void m2336a(C4999d c4999d) {
        if (c4999d == null) {
            return;
        }
        C4999d m2328c = m2328c(c4999d.f21426a);
        if (m2328c == null) {
            this.f21413a.add(c4999d);
            return;
        }
        int indexOf = this.f21413a.indexOf(m2328c);
        this.f21413a.remove(indexOf);
        this.f21413a.add(indexOf, c4999d);
    }

    /* renamed from: a */
    public void m2335a(C5000e c5000e) {
    }

    /* renamed from: a */
    public void m2333a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public int m2332b() {
        if (this.f21413a == null) {
            return 0;
        }
        return this.f21413a.size();
    }

    /* renamed from: b */
    protected String m2331b(int i) {
        return this.f21413a.get(i).f21427b;
    }

    /* renamed from: b */
    public C5000e m2330b(int i, int i2) {
        C4999d m2328c = m2328c(i);
        if (m2328c == null) {
            return null;
        }
        return m2328c.m2326a(i2);
    }

    /* renamed from: b */
    public boolean m2329b(C5000e c5000e) {
        return false;
    }
}
