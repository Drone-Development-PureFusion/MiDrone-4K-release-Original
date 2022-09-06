package it.p235a.p236a;

import java.io.IOException;
import java.net.Socket;
/* renamed from: it.a.a.d */
/* loaded from: classes.dex */
class C4862d implements AbstractC4867i {

    /* renamed from: a */
    private final String f20777a;

    /* renamed from: b */
    private final int f20778b;

    /* renamed from: c */
    private final C4852b f20779c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4862d(C4852b c4852b, String str, int i) {
        this.f20779c = c4852b;
        this.f20777a = str;
        this.f20778b = i;
    }

    @Override // it.p235a.p236a.AbstractC4867i
    /* renamed from: a */
    public Socket mo2997a() {
        try {
            String m3069c = C4852b.m3079b(this.f20779c).m3012a() ? this.f20777a : C4852b.m3069c(this.f20779c);
            Socket mo3003d = C4852b.m3079b(this.f20779c).mo3003d(m3069c, this.f20778b);
            return C4852b.m3106a(this.f20779c) ? C4852b.m3104a(this.f20779c, mo3003d, m3069c, this.f20778b) : mo3003d;
        } catch (IOException e) {
            throw new C4868j("Cannot connect to the remote server", e);
        }
    }

    @Override // it.p235a.p236a.AbstractC4867i
    /* renamed from: b */
    public void mo2996b() {
    }
}
