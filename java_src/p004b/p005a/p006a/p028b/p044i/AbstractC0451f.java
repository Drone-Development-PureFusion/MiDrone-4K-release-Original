package p004b.p005a.p006a.p028b.p044i;
/* renamed from: b.a.a.b.i.f */
/* loaded from: classes.dex */
public abstract class AbstractC0451f<E> extends AbstractC0431b<E> {

    /* renamed from: i */
    static final int f1000i = 256;

    /* renamed from: j */
    static final int f1001j = 1024;

    /* renamed from: k */
    C0450e f1002k;

    /* renamed from: a */
    public final void m20481a(C0450e c0450e) {
        if (this.f1002k != null) {
            throw new IllegalStateException("FormattingInfo has been already set");
        }
        this.f1002k = c0450e;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public final void mo20480a(StringBuilder sb, E e) {
        String a = a((AbstractC0451f<E>) e);
        if (this.f1002k == null) {
            sb.append(a);
            return;
        }
        int m20483c = this.f1002k.m20483c();
        int m20486b = this.f1002k.m20486b();
        if (a == null) {
            if (m20483c <= 0) {
                return;
            }
            C0458m.m20458a(sb, m20483c);
            return;
        }
        int length = a.length();
        if (length > m20486b) {
            if (this.f1002k.m20482d()) {
                sb.append(a.substring(length - m20486b));
            } else {
                sb.append(a.substring(0, m20486b));
            }
        } else if (length >= m20483c) {
            sb.append(a);
        } else if (this.f1002k.m20490a()) {
            C0458m.m20457a(sb, a, m20483c);
        } else {
            C0458m.m20456b(sb, a, m20483c);
        }
    }

    /* renamed from: f */
    public final C0450e m20479f() {
        return this.f1002k;
    }
}
