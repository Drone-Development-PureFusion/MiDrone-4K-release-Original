package p004b.p005a.p006a.p007a.p019j;

import p004b.p005a.p006a.p028b.p054o.AbstractC0534m;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.a.j.b */
/* loaded from: classes.dex */
public abstract class AbstractC0180b extends C0527f implements AbstractC0534m {

    /* renamed from: a */
    private boolean f281a;

    /* renamed from: a */
    protected abstract boolean mo21337a();

    /* renamed from: b */
    protected abstract void mo21331b();

    /* renamed from: d */
    protected abstract Runnable mo21327d();

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public final boolean mo20158g_() {
        return this.f281a;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public final void mo20156j() {
        if (mo20158g_()) {
            return;
        }
        if (h_() == null) {
            throw new IllegalStateException("context not set");
        }
        if (!mo21337a()) {
            return;
        }
        h_().mo20993s().execute(mo21327d());
        this.f281a = true;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public final void mo20155k() {
        if (!mo20158g_()) {
            return;
        }
        try {
            mo21331b();
        } catch (RuntimeException e) {
            a("on stop: " + e, e);
        }
        this.f281a = false;
    }
}
