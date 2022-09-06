package p244m.framework.p245a;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: m.framework.a.e */
/* loaded from: classes2.dex */
public class C4942e extends AbstractC4940c {

    /* renamed from: a */
    private ArrayList<AbstractC4940c> f21280a = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: a */
    public InputStream mo2564a() {
        C4943f c4943f = new C4943f();
        Iterator<AbstractC4940c> it2 = this.f21280a.iterator();
        while (it2.hasNext()) {
            c4943f.m2577a(it2.next().mo2564a());
        }
        return c4943f;
    }

    /* renamed from: a */
    public C4942e m2579a(AbstractC4940c abstractC4940c) {
        this.f21280a.add(abstractC4940c);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: b */
    public long mo2562b() {
        long j = 0;
        Iterator<AbstractC4940c> it2 = this.f21280a.iterator();
        while (true) {
            long j2 = j;
            if (!it2.hasNext()) {
                return j2;
            }
            j = it2.next().mo2562b() + j2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<AbstractC4940c> it2 = this.f21280a.iterator();
        while (it2.hasNext()) {
            sb.append(it2.next().toString());
        }
        return sb.toString();
    }
}
