package it.p235a.p236a;

import java.io.IOException;
import java.net.Socket;
/* renamed from: it.a.a.c */
/* loaded from: classes.dex */
class C4856c extends RunnableC4870l {

    /* renamed from: a */
    private final C4852b f20768a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4856c(C4852b c4852b) {
        this.f20768a = c4852b;
    }

    @Override // it.p235a.p236a.RunnableC4870l, it.p235a.p236a.AbstractC4867i
    /* renamed from: a */
    public Socket mo2997a() {
        Socket mo2997a = super.mo2997a();
        if (C4852b.m3106a(this.f20768a)) {
            try {
                return C4852b.m3104a(this.f20768a, mo2997a, mo2997a.getInetAddress().getHostName(), mo2997a.getPort());
            } catch (IOException e) {
                try {
                    mo2997a.close();
                } catch (Throwable th) {
                }
                throw new C4868j(e);
            }
        }
        return mo2997a;
    }
}
