package p004b.p005a.p006a.p007a.p025n;

import java.io.Serializable;
import java.util.Comparator;
import org.p318d.AbstractC5744c;
import p004b.p005a.p006a.p007a.C0148e;
/* renamed from: b.a.a.a.n.f */
/* loaded from: classes.dex */
public class C0233f implements Serializable, Comparator<C0148e> {
    private static final long serialVersionUID = 1;

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(C0148e c0148e, C0148e c0148e2) {
        if (c0148e.mo88d().equals(c0148e2.mo88d())) {
            return 0;
        }
        if (c0148e.mo88d().equals(AbstractC5744c.f23019c)) {
            return -1;
        }
        if (!c0148e2.mo88d().equals(AbstractC5744c.f23019c)) {
            return c0148e.mo88d().compareTo(c0148e2.mo88d());
        }
        return 1;
    }
}
