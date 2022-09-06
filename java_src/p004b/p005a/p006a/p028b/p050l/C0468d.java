package p004b.p005a.p006a.p028b.p050l;

import java.io.OutputStream;
import p004b.p005a.p006a.p028b.p041h.C0410k;
/* renamed from: b.a.a.b.l.d */
/* loaded from: classes.dex */
public class C0468d extends AbstractC0467c {

    /* renamed from: d */
    String f1040d;

    /* renamed from: e */
    int f1041e;

    public C0468d(String str, int i) {
        this.f1040d = str;
        this.f1041e = i;
        this.f1034b = new C0410k(str, i);
        this.f1035c = true;
    }

    @Override // p004b.p005a.p006a.p028b.p050l.AbstractC0467c
    /* renamed from: c */
    String mo20420c() {
        return "syslog [" + this.f1040d + ":" + this.f1041e + "]";
    }

    @Override // p004b.p005a.p006a.p028b.p050l.AbstractC0467c
    /* renamed from: d */
    OutputStream mo20419d() {
        return new C0410k(this.f1040d, this.f1041e);
    }

    public String toString() {
        return "c.q.l.c.recovery.ResilientSyslogOutputStream@" + System.identityHashCode(this);
    }
}
