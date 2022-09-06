package p004b.p005a.p006a.p028b.p054o;
/* renamed from: b.a.a.b.o.r */
/* loaded from: classes.dex */
public class C0539r extends Exception {
    private static final long serialVersionUID = -3132040414328475658L;

    /* renamed from: a */
    Throwable f1203a;

    public C0539r(String str) {
        super(str);
    }

    public C0539r(String str, Throwable th) {
        super(str);
        this.f1203a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f1203a;
    }
}
