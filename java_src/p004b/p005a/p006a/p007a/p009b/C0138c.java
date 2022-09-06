package p004b.p005a.p006a.p007a.p009b;

import java.util.ArrayList;
import java.util.List;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.p030b.AbstractC0272c;
/* renamed from: b.a.a.a.b.c */
/* loaded from: classes.dex */
public class C0138c extends AbstractC0272c<AbstractC0231d> {

    /* renamed from: a */
    List<String> f153a = new ArrayList();

    /* renamed from: a */
    public void m21499a(String str) {
        this.f153a.add(str);
    }

    @Override // p004b.p005a.p006a.p028b.p030b.AbstractC0271b
    /* renamed from: a */
    public boolean mo21090a(AbstractC0231d abstractC0231d) {
        AbstractC5756f mo21211k = abstractC0231d.mo21211k();
        if (mo21211k == null) {
            return false;
        }
        for (String str : this.f153a) {
            if (mo21211k.mo10a(str)) {
                return true;
            }
        }
        return false;
    }
}
