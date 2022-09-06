package p004b.p005a.p006a.p007a.p025n;

import java.util.concurrent.CopyOnWriteArrayList;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0148e;
import p004b.p005a.p006a.p007a.p026o.AbstractC0257i;
import p004b.p005a.p006a.p028b.p054o.EnumC0533l;
/* renamed from: b.a.a.a.n.t */
/* loaded from: classes.dex */
public final class C0247t extends CopyOnWriteArrayList<AbstractC0257i> {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    public EnumC0533l m21165a(AbstractC5756f abstractC5756f, C0148e c0148e, C0146d c0146d, String str, Object[] objArr, Throwable th) {
        if (size() == 1) {
            try {
                return get(0).mo21125a(abstractC5756f, c0148e, c0146d, str, objArr, th);
            } catch (IndexOutOfBoundsException e) {
                return EnumC0533l.NEUTRAL;
            }
        }
        for (Object obj : toArray()) {
            EnumC0533l mo21125a = ((AbstractC0257i) obj).mo21125a(abstractC5756f, c0148e, c0146d, str, objArr, th);
            if (mo21125a == EnumC0533l.DENY || mo21125a == EnumC0533l.ACCEPT) {
                return mo21125a;
            }
        }
        return EnumC0533l.NEUTRAL;
    }
}
