package p004b.p005a.p006a.p028b.p051m;

import java.io.File;
import java.util.Date;
import p004b.p005a.p006a.p028b.C0359h;
import p004b.p005a.p006a.p028b.p051m.p052a.C0475e;
import p004b.p005a.p006a.p028b.p051m.p052a.C0479h;
import p004b.p005a.p006a.p028b.p051m.p052a.C0483i;
import p004b.p005a.p006a.p028b.p051m.p052a.C0488n;
import p004b.p005a.p006a.p028b.p051m.p052a.EnumC0473c;
/* renamed from: b.a.a.b.m.b */
/* loaded from: classes.dex */
public class C0494b extends AbstractC0498e {

    /* renamed from: a */
    static final String f1095a = "The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. ";

    /* renamed from: b */
    static final String f1096b = "See also http://logback.qos.ch/codes.html#tbr_fnp_prudent_unsupported";

    /* renamed from: c */
    static final String f1097c = "Please refer to http://logback.qos.ch/codes.html#fwrp_parentFileName_not_set";

    /* renamed from: h */
    public static final String f1098h = "yyyy-MM-dd_HHmm";

    /* renamed from: m */
    private static int f1099m = 20;

    /* renamed from: g */
    C0475e f1103g;

    /* renamed from: f */
    C0488n f1102f = new C0488n();

    /* renamed from: e */
    int f1101e = 1;

    /* renamed from: d */
    int f1100d = 7;

    /* renamed from: b */
    private String m20352b(String str) {
        return C0479h.m20397a(C0479h.m20393b(str)).replace("%i", "%d{yyyy-MM-dd_HHmm}");
    }

    /* renamed from: a */
    protected int m20355a() {
        return f1099m;
    }

    /* renamed from: a */
    public void m20354a(int i) {
        this.f1100d = i;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0497d
    /* renamed from: b */
    public void mo20311b() {
        if (this.f1100d >= 0) {
            File file = new File(this.f1114j.m20388a(this.f1100d));
            if (file.exists()) {
                file.delete();
            }
            int i = this.f1100d;
            while (true) {
                i--;
                if (i < this.f1101e) {
                    break;
                }
                String m20388a = this.f1114j.m20388a(i);
                if (new File(m20388a).exists()) {
                    this.f1102f.m20372a(m20388a, this.f1114j.m20388a(i + 1));
                } else {
                    d("Skipping roll-over for inexistent file " + m20388a);
                }
            }
            switch (this.f1113i) {
                case NONE:
                    this.f1102f.m20372a(mo20309d(), this.f1114j.m20388a(this.f1101e));
                    return;
                case GZ:
                    this.f1103g.m20413a(mo20309d(), this.f1114j.m20388a(this.f1101e), null);
                    return;
                case ZIP:
                    this.f1103g.m20413a(mo20309d(), this.f1114j.m20388a(this.f1101e), this.f1116l.m20387a((Object) new Date()));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: b */
    public void m20353b(int i) {
        this.f1101e = i;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0497d
    /* renamed from: d */
    public String mo20309d() {
        return n();
    }

    /* renamed from: e */
    public int m20351e() {
        return this.f1100d;
    }

    /* renamed from: f */
    public int m20350f() {
        return this.f1101e;
    }

    @Override // p004b.p005a.p006a.p028b.p051m.AbstractC0498e, p004b.p005a.p006a.p028b.p054o.AbstractC0534m
    /* renamed from: j */
    public void mo20156j() {
        this.f1102f.a(this.f1190s);
        if (this.f1115k == null) {
            c(f1095a);
            c(C0359h.f680J);
            throw new IllegalStateException("The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
        }
        this.f1114j = new C0483i(this.f1115k, this.f1190s);
        h();
        if (m()) {
            c("Prudent mode is not supported with FixedWindowRollingPolicy.");
            c(f1096b);
            throw new IllegalStateException("Prudent mode is not supported.");
        } else if (n() == null) {
            c("The File name property must be set before using this rolling policy.");
            c(f1097c);
            throw new IllegalStateException("The \"File\" option must be set.");
        } else {
            if (this.f1100d < this.f1101e) {
                e("MaxIndex (" + this.f1100d + ") cannot be smaller than MinIndex (" + this.f1101e + ").");
                e("Setting maxIndex to equal minIndex.");
                this.f1100d = this.f1101e;
            }
            int m20355a = m20355a();
            if (this.f1100d - this.f1101e > m20355a) {
                e("Large window sizes are not allowed.");
                this.f1100d = m20355a + this.f1101e;
                e("MaxIndex reduced to " + this.f1100d);
            }
            if (this.f1114j.m20381c() == null) {
                throw new IllegalStateException("FileNamePattern [" + this.f1114j.m20380d() + "] does not contain a valid IntegerToken");
            }
            if (this.f1113i == EnumC0473c.ZIP) {
                this.f1116l = new C0483i(m20352b(this.f1115k), this.f1190s);
            }
            this.f1103g = new C0475e(this.f1113i);
            this.f1103g.a(this.f1190s);
            super.mo20156j();
        }
    }
}
