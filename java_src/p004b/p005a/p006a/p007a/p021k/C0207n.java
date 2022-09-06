package p004b.p005a.p006a.p007a.p021k;

import java.util.concurrent.atomic.AtomicLong;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
/* renamed from: b.a.a.a.k.n */
/* loaded from: classes.dex */
public class C0207n extends AbstractC0198e {

    /* renamed from: a */
    AtomicLong f331a = new AtomicLong(System.currentTimeMillis());

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(AbstractC0231d abstractC0231d) {
        return Long.toString(this.f331a.getAndIncrement());
    }
}
