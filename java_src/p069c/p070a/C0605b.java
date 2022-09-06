package p069c.p070a;

import p069c.p071b.AbstractC0618i;
import p069c.p071b.C0622m;
/* renamed from: c.a.b */
/* loaded from: classes.dex */
public class C0605b extends C0606c {

    /* renamed from: b */
    private int f1378b;

    public C0605b(AbstractC0618i abstractC0618i, int i) {
        super(abstractC0618i);
        if (i < 0) {
            throw new IllegalArgumentException("Repetition count must be >= 0");
        }
        this.f1378b = i;
    }

    @Override // p069c.p070a.C0606c, p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public int mo19848a() {
        return super.mo19848a() * this.f1378b;
    }

    @Override // p069c.p070a.C0606c, p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public void mo19844a(C0622m c0622m) {
        for (int i = 0; i < this.f1378b && !c0622m.m19853f(); i++) {
            super.mo19844a(c0622m);
        }
    }

    @Override // p069c.p070a.C0606c
    public String toString() {
        return super.toString() + "(repeated)";
    }
}
