package p004b.p005a.p006a.p028b.p035g.p039d;

import java.util.ArrayList;
import java.util.List;
import p004b.p005a.p006a.p028b.p035g.p037b.C0325a;
import p004b.p005a.p006a.p028b.p035g.p037b.C0326b;
import p004b.p005a.p006a.p028b.p035g.p037b.C0328d;
import p004b.p005a.p006a.p028b.p035g.p037b.C0330f;
/* renamed from: b.a.a.b.g.d.i */
/* loaded from: classes.dex */
public class C0342i {

    /* renamed from: a */
    final C0345l f635a;

    /* renamed from: b */
    List<C0328d> f636b;

    /* renamed from: c */
    int f637c;

    public C0342i(C0345l c0345l) {
        this.f635a = c0345l;
    }

    /* renamed from: a */
    public List<C0328d> m20890a() {
        return new ArrayList(this.f636b);
    }

    /* renamed from: a */
    public void m20889a(List<C0328d> list) {
        this.f636b = list;
        this.f637c = 0;
        while (this.f637c < this.f636b.size()) {
            C0328d c0328d = this.f636b.get(this.f637c);
            if (c0328d instanceof C0330f) {
                this.f635a.m20862a((C0330f) c0328d);
                this.f635a.m20850c().m20882a(c0328d);
            }
            if (c0328d instanceof C0325a) {
                this.f635a.m20850c().m20882a(c0328d);
                this.f635a.m20864a((C0325a) c0328d);
            }
            if (c0328d instanceof C0326b) {
                this.f635a.m20850c().m20882a(c0328d);
                this.f635a.m20863a((C0326b) c0328d);
            }
            this.f637c++;
        }
    }

    /* renamed from: a */
    public void m20888a(List<C0328d> list, int i) {
        this.f636b.addAll(this.f637c + i, list);
    }
}
