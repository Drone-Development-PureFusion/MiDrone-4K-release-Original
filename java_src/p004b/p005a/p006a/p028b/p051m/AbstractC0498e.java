package p004b.p005a.p006a.p028b.p051m;

import p004b.p005a.p006a.p028b.C0411i;
import p004b.p005a.p006a.p028b.p051m.p052a.C0483i;
import p004b.p005a.p006a.p028b.p051m.p052a.EnumC0473c;
import p004b.p005a.p006a.p028b.p054o.C0527f;
/* renamed from: b.a.a.b.m.e */
/* loaded from: classes.dex */
public abstract class AbstractC0498e extends C0527f implements AbstractC0497d {

    /* renamed from: a */
    private C0411i f1111a;

    /* renamed from: b */
    private boolean f1112b;

    /* renamed from: i */
    protected EnumC0473c f1113i = EnumC0473c.NONE;

    /* renamed from: j */
    C0483i f1114j;

    /* renamed from: k */
    protected String f1115k;

    /* renamed from: l */
    C0483i f1116l;

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0497d
    /* renamed from: a */
    public void mo20341a(C0411i c0411i) {
        this.f1111a = c0411i;
    }

    /* renamed from: a */
    public void m20340a(String str) {
        this.f1115k = str;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0497d
    /* renamed from: g */
    public EnumC0473c mo20339g() {
        return this.f1113i;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: g_ */
    public boolean mo20158g_() {
        return this.f1112b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void m20338h() {
        if (this.f1115k.endsWith(".gz")) {
            d("Will use gz compression");
            this.f1113i = EnumC0473c.GZ;
        } else if (this.f1115k.endsWith(".zip")) {
            d("Will use zip compression");
            this.f1113i = EnumC0473c.ZIP;
        } else {
            d("No compression will be used");
            this.f1113i = EnumC0473c.NONE;
        }
    }

    /* renamed from: j */
    public void mo20156j() {
        this.f1112b = true;
    }

    @Override // p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: k */
    public void mo20155k() {
        this.f1112b = false;
    }

    /* renamed from: l */
    public String m20337l() {
        return this.f1115k;
    }

    /* renamed from: m */
    public boolean m20336m() {
        return this.f1111a.m20549e();
    }

    /* renamed from: n */
    public String m20335n() {
        return this.f1111a.m20553b();
    }
}
