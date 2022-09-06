package p004b.p005a.p006a.p028b.p041h.p042a;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: b.a.a.b.h.a.g */
/* loaded from: classes.dex */
public class C0370g extends AbstractRunnableC0365d<AbstractC0368e> {

    /* renamed from: a */
    private final int f749a;

    public C0370g(AbstractC0373j<AbstractC0368e> abstractC0373j, Executor executor, int i) {
        super(abstractC0373j, executor);
        this.f749a = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p004b.p005a.p006a.p028b.p041h.p042a.AbstractRunnableC0365d
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo20761a(AbstractC0368e abstractC0368e) {
        abstractC0368e.a(h_());
        abstractC0368e.mo20757a((BlockingQueue<Serializable>) new ArrayBlockingQueue(this.f749a));
        return true;
    }
}
