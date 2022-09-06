package p004b.p005a.p006a.p028b.p044i.p046b;
/* renamed from: b.a.a.b.i.b.b */
/* loaded from: classes.dex */
public class C0433b extends C0438g {

    /* renamed from: a */
    C0435d f939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0433b(String str) {
        super(2, str);
    }

    /* renamed from: a */
    public C0435d m20536a() {
        return this.f939a;
    }

    /* renamed from: a */
    public void m20535a(C0435d c0435d) {
        this.f939a = c0435d;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0438g, p004b.p005a.p006a.p028b.p044i.p046b.C0434c, p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof C0433b)) {
            C0433b c0433b = (C0433b) obj;
            return this.f939a != null ? this.f939a.equals(c0433b.f939a) : c0433b.f939a == null;
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0438g, p004b.p005a.p006a.p028b.p044i.p046b.C0434c, p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public int hashCode() {
        return super.hashCode();
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0438g, p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.f939a != null) {
            stringBuffer.append("CompositeNode(" + this.f939a + ")");
        } else {
            stringBuffer.append("CompositeNode(no child)");
        }
        stringBuffer.append(f());
        return stringBuffer.toString();
    }
}
