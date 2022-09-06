package p244m.framework.p245a;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* renamed from: m.framework.a.j */
/* loaded from: classes2.dex */
public class C4948j extends AbstractC4940c {

    /* renamed from: a */
    private StringBuilder f21287a = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: a */
    public InputStream mo2564a() {
        return new ByteArrayInputStream(this.f21287a.toString().getBytes("utf-8"));
    }

    /* renamed from: a */
    public C4948j m2563a(String str) {
        this.f21287a.append(str);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: b */
    public long mo2562b() {
        return this.f21287a.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.f21287a.toString();
    }
}
