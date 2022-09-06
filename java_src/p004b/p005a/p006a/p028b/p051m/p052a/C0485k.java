package p004b.p005a.p006a.p028b.p051m.p052a;

import p004b.p005a.p006a.p028b.p044i.AbstractC0449d;
/* renamed from: b.a.a.b.m.a.k */
/* loaded from: classes.dex */
public class C0485k extends AbstractC0449d implements AbstractC0486l {

    /* renamed from: a */
    public static final String f1074a = "i";

    /* renamed from: a */
    public String m20377a(int i) {
        return Integer.toString(i);
    }

    @Override // p004b.p005a.p006a.p028b.p044i.AbstractC0431b
    /* renamed from: a */
    public String mo20376a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        }
        if (!(obj instanceof Integer)) {
            throw new IllegalArgumentException("Cannot convert " + obj + " of type" + obj.getClass().getName());
        }
        return m20377a(((Integer) obj).intValue());
    }

    @Override // p004b.p005a.p006a.p028b.p051m.p052a.AbstractC0486l
    /* renamed from: b */
    public boolean mo20375b(Object obj) {
        return obj instanceof Integer;
    }
}
