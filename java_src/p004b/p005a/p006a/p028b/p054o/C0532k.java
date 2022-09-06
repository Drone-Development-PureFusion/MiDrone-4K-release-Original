package p004b.p005a.p006a.p028b.p054o;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p004b.p005a.p006a.p028b.p032d.AbstractC0286c;
/* renamed from: b.a.a.b.o.k */
/* loaded from: classes.dex */
public final class C0532k<E> implements AbstractC0531j<E> {

    /* renamed from: a */
    CopyOnWriteArrayList<AbstractC0286c<E>> f1198a = new CopyOnWriteArrayList<>();

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: a */
    public void mo20165a(AbstractC0286c<E> abstractC0286c) {
        this.f1198a.add(abstractC0286c);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public EnumC0533l mo20161e(E e) {
        Iterator<AbstractC0286c<E>> it2 = this.f1198a.iterator();
        while (it2.hasNext()) {
            EnumC0533l mo21040a = it2.next().mo21040a((AbstractC0286c<E>) e);
            if (mo21040a == EnumC0533l.DENY || mo21040a == EnumC0533l.ACCEPT) {
                return mo21040a;
            }
            while (it2.hasNext()) {
            }
        }
        return EnumC0533l.NEUTRAL;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: f_ */
    public List<AbstractC0286c<E>> mo20160f_() {
        return new ArrayList(this.f1198a);
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0531j
    /* renamed from: h */
    public void mo20157h() {
        this.f1198a.clear();
    }
}
