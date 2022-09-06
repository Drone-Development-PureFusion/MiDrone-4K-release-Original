package p004b.p005a.p006a.p028b.p041h;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/* renamed from: b.a.a.b.h.d */
/* loaded from: classes.dex */
public class C0397d extends Authenticator {

    /* renamed from: a */
    String f826a;

    /* renamed from: b */
    String f827b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0397d(String str, String str2) {
        this.f826a = str;
        this.f827b = str2;
    }

    /* renamed from: a */
    public PasswordAuthentication m20637a() {
        return new PasswordAuthentication(this.f826a, this.f827b);
    }
}
