package p004b.p005a.p006a.p028b.p044i;
/* renamed from: b.a.a.b.i.a */
/* loaded from: classes.dex */
public abstract class AbstractC0412a<E> extends AbstractC0449d<E> {

    /* renamed from: a */
    AbstractC0431b<E> f920a;

    /* renamed from: a */
    public AbstractC0431b<E> m20545a() {
        return this.f920a;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(E e) {
        StringBuilder sb = new StringBuilder();
        for (AbstractC0431b<E> abstractC0431b = this.f920a; abstractC0431b != null; abstractC0431b = abstractC0431b.f934f) {
            abstractC0431b.mo20480a(sb, e);
        }
        return mo20459a((AbstractC0412a<E>) e, sb.toString());
    }

    /* renamed from: a */
    protected abstract String mo20459a(E e, String str);

    /* renamed from: a */
    public void m20544a(AbstractC0431b<E> abstractC0431b) {
        this.f920a = abstractC0431b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompositeConverter<");
        if (this.f1002k != null) {
            sb.append(this.f1002k);
        }
        if (this.f920a != null) {
            sb.append(", children: ").append(this.f920a);
        }
        sb.append(">");
        return sb.toString();
    }
}
