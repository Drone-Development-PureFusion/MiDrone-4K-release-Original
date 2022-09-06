package p004b.p005a.p006a.p028b.p044i.p046b;

import p004b.p005a.p006a.p028b.p044i.C0450e;
/* renamed from: b.a.a.b.i.b.c */
/* loaded from: classes.dex */
public class C0434c extends C0435d {

    /* renamed from: b */
    C0450e f940b;

    C0434c(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0434c(int i, Object obj) {
        super(i, obj);
    }

    /* renamed from: a */
    public void m20534a(C0450e c0450e) {
        this.f940b = c0450e;
    }

    /* renamed from: b */
    public C0450e m20533b() {
        return this.f940b;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof C0434c)) {
            C0434c c0434c = (C0434c) obj;
            return this.f940b != null ? this.f940b.equals(c0434c.f940b) : c0434c.f940b == null;
        }
        return false;
    }

    @Override // p004b.p005a.p006a.p028b.p044i.p046b.C0435d
    public int hashCode() {
        return (this.f940b != null ? this.f940b.hashCode() : 0) + (super.hashCode() * 31);
    }
}
