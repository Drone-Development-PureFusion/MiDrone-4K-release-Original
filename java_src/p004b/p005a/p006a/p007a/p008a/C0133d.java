package p004b.p005a.p006a.p007a.p008a;

import android.util.Log;
import org.p318d.AbstractC5756f;
import p004b.p005a.p006a.p007a.C0146d;
import p004b.p005a.p006a.p007a.C0156g;
import p004b.p005a.p006a.p007a.p012d.C0147a;
import p004b.p005a.p006a.p007a.p025n.AbstractC0231d;
import p004b.p005a.p006a.p028b.AbstractC0269b;
import p004b.p005a.p006a.p028b.AbstractC0459j;
import p004b.p005a.p006a.p028b.p044i.AbstractC0456k;
/* renamed from: b.a.a.a.a.d */
/* loaded from: classes.dex */
public class C0133d extends AbstractC0269b<AbstractC0231d> {

    /* renamed from: a */
    private static final int f130a = 23;

    /* renamed from: b */
    private C0147a f131b = null;

    /* renamed from: c */
    private C0147a f132c = null;

    /* renamed from: d */
    private boolean f133d = false;

    /* renamed from: a */
    public C0147a m21525a() {
        return this.f131b;
    }

    /* renamed from: a */
    public void m21524a(C0147a c0147a) {
        this.f131b = c0147a;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo20289a(AbstractC0231d abstractC0231d) {
        if (!g_()) {
            return;
        }
        String m21519b = m21519b(abstractC0231d);
        switch (abstractC0231d.mo21220b().f208v) {
            case Integer.MIN_VALUE:
            case 5000:
                if (this.f133d && !Log.isLoggable(m21519b, 2)) {
                    return;
                }
                Log.v(m21519b, this.f131b.d().mo20455a((AbstractC0459j<AbstractC0231d>) abstractC0231d));
                return;
            case 10000:
                if (this.f133d && !Log.isLoggable(m21519b, 3)) {
                    return;
                }
                Log.d(m21519b, this.f131b.d().mo20455a((AbstractC0459j<AbstractC0231d>) abstractC0231d));
                return;
            case 20000:
                if (this.f133d && !Log.isLoggable(m21519b, 4)) {
                    return;
                }
                Log.i(m21519b, this.f131b.d().mo20455a((AbstractC0459j<AbstractC0231d>) abstractC0231d));
                return;
            case 30000:
                if (this.f133d && !Log.isLoggable(m21519b, 5)) {
                    return;
                }
                Log.w(m21519b, this.f131b.d().mo20455a((AbstractC0459j<AbstractC0231d>) abstractC0231d));
                return;
            case C0146d.f188b /* 40000 */:
                if (this.f133d && !Log.isLoggable(m21519b, 6)) {
                    return;
                }
                Log.e(m21519b, this.f131b.d().mo20455a((AbstractC0459j<AbstractC0231d>) abstractC0231d));
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void m21522a(boolean z) {
        this.f133d = z;
    }

    /* renamed from: b */
    public C0147a m21521b() {
        return this.f132c;
    }

    /* renamed from: b */
    protected String m21519b(AbstractC0231d abstractC0231d) {
        String mo20455a = this.f132c != null ? this.f132c.d().mo20455a((AbstractC0459j<AbstractC0231d>) abstractC0231d) : abstractC0231d.mo21216f();
        return (!this.f133d || mo20455a.length() <= 23) ? mo20455a : mo20455a.substring(0, 22) + AbstractC5756f.f23062a;
    }

    /* renamed from: b */
    public void m21520b(C0147a c0147a) {
        this.f132c = c0147a;
    }

    /* renamed from: c */
    public boolean m21518c() {
        return this.f133d;
    }

    @Override // p004b.p005a.p006a.p028b.AbstractC0269b, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        if (this.f131b == null || this.f131b.d() == null) {
            c("No layout set for the appender named [" + this.f476g + "].");
            return;
        }
        if (this.f132c != null) {
            AbstractC0459j<AbstractC0231d> d = this.f132c.d();
            if (d == null) {
                c("No tag layout set for the appender named [" + this.f476g + "].");
                return;
            } else if (d instanceof C0156g) {
                String h = this.f132c.h();
                if (!h.contains("%nopex")) {
                    this.f132c.k();
                    this.f132c.a(h + "%nopex");
                    this.f132c.mo20156j();
                }
                ((C0156g) d).a((AbstractC0456k) null);
            }
        }
        super.mo20156j();
    }
}
