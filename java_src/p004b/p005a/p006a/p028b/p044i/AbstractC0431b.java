package p004b.p005a.p006a.p028b.p044i;
/* renamed from: b.a.a.b.i.b */
/* loaded from: classes.dex */
public abstract class AbstractC0431b<E> {

    /* renamed from: f */
    AbstractC0431b<E> f934f;

    /* renamed from: a */
    public abstract String mo20376a(E e);

    /* renamed from: a */
    public void mo20480a(StringBuilder sb, E e) {
        sb.append(mo20376a(e));
    }

    /* renamed from: b */
    public final AbstractC0431b<E> m20542b() {
        return this.f934f;
    }

    /* renamed from: b */
    public final void m20541b(AbstractC0431b<E> abstractC0431b) {
        if (this.f934f != null) {
            throw new IllegalStateException("Next converter has been already set");
        }
        this.f934f = abstractC0431b;
    }
}
