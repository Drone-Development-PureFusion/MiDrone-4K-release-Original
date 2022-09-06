package p069c.p071b;

import org.p290c.p309e.AbstractC5604b;
import org.p290c.p309e.C5619c;
/* renamed from: c.b.g */
/* loaded from: classes.dex */
public class C0616g implements AbstractC0618i, AbstractC5604b {

    /* renamed from: a */
    private final C5619c f1399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0616g(C5619c c5619c) {
        this.f1399a = c5619c;
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public int mo19848a() {
        return 1;
    }

    @Override // p069c.p071b.AbstractC0618i
    /* renamed from: a */
    public void mo19844a(C0622m c0622m) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    @Override // org.p290c.p309e.AbstractC5604b
    /* renamed from: d */
    public C5619c mo327d() {
        return this.f1399a;
    }

    public String toString() {
        return mo327d().toString();
    }
}
