package p244m.framework.p245a;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/* renamed from: m.framework.a.b */
/* loaded from: classes2.dex */
public class C4939b extends AbstractC4940c {

    /* renamed from: a */
    private File f21277a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: a */
    public InputStream mo2564a() {
        return new FileInputStream(this.f21277a);
    }

    /* renamed from: a */
    public void m2582a(File file) {
        this.f21277a = file;
    }

    /* renamed from: a */
    public void m2581a(String str) {
        this.f21277a = new File(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p244m.framework.p245a.AbstractC4940c
    /* renamed from: b */
    public long mo2562b() {
        return this.f21277a.length();
    }

    public String toString() {
        return this.f21277a.toString();
    }
}
